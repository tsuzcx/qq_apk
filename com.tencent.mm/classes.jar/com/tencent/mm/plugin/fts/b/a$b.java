package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.c.a;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

final class a$b
  extends com.tencent.mm.plugin.fts.a.a.a
{
  private HashSet<String> mUi;
  private HashMap<String, ad> mUj;
  private long mUk;
  private long mUl;
  private int mUm;
  private int mUn;
  private int mUo;
  private int mUp;
  private int mUq;
  private int mUr;
  private int mUs;
  private int mUt;
  
  private a$b(a parama)
  {
    AppMethodBeat.i(136666);
    this.mUj = new HashMap();
    this.mUk = -1L;
    this.mUl = -1L;
    this.mUm = 0;
    this.mUn = 0;
    this.mUo = 0;
    this.mUp = 0;
    this.mUq = 0;
    AppMethodBeat.o(136666);
  }
  
  public final String aAn()
  {
    AppMethodBeat.i(136668);
    String str = String.format("{build: %d newContact: %d, newChatroom: %d, remove: %d, dirty: %d, timestamp: %d, failContact: %d, failChatroom}", new Object[] { Integer.valueOf(this.mUt), Integer.valueOf(this.mUn), Integer.valueOf(this.mUm), Integer.valueOf(this.mUo), Integer.valueOf(this.mUr), Integer.valueOf(this.mUs), Integer.valueOf(this.mUp), Integer.valueOf(this.mUq) });
    AppMethodBeat.o(136668);
    return str;
  }
  
  public final boolean execute()
  {
    AppMethodBeat.i(136667);
    ab.i("MicroMsg.FTS.FTS5SearchContactLogic", "Start building contact index.");
    Pg("start");
    Object localObject5;
    Object localObject6;
    long l;
    Object localObject3;
    if (this.mUi == null)
    {
      this.mUi = new HashSet();
      localObject5 = a.a(this.mUg).a(c.mQI, true, false, true, false, true);
      while (((Cursor)localObject5).moveToNext())
      {
        localObject6 = ((Cursor)localObject5).getString(1);
        i = ((Cursor)localObject5).getInt(2);
        l = ((Cursor)localObject5).getLong(0);
        if (i == 1)
        {
          localObject3 = (List)a.b(this.mUg).get(localObject6);
          localObject1 = localObject3;
          if (localObject3 == null)
          {
            localObject1 = new ArrayList(16);
            a.b(this.mUg).put(localObject6, localObject1);
          }
          ((List)localObject1).add(Long.valueOf(l));
        }
        else
        {
          this.mUi.add(localObject6);
          if (i == 2) {
            a.c(this.mUg).add(localObject6);
          }
        }
      }
      ((Cursor)localObject5).close();
      this.mUr = a.b(this.mUg).size();
      this.mUs = a.c(this.mUg).size();
      this.mUt = this.mUi.size();
      if (this.mUt < 5) {
        this.mRO |= 1L;
      }
    }
    Pg("getBuildContact");
    if (Thread.interrupted())
    {
      localObject1 = new InterruptedException();
      AppMethodBeat.o(136667);
      throw ((Throwable)localObject1);
    }
    if (a.b(this.mUg).size() > 0)
    {
      localObject1 = new ArrayList();
      localObject3 = a.b(this.mUg).values().iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((List)localObject1).addAll((List)((Iterator)localObject3).next());
      }
      a.b(this.mUg).clear();
      a.a(this.mUg).bS((List)localObject1);
    }
    Pg("deleteDirtyContact");
    if (Thread.interrupted())
    {
      localObject1 = new InterruptedException();
      AppMethodBeat.o(136667);
      throw ((Throwable)localObject1);
    }
    if (a.c(this.mUg).size() > 0)
    {
      localObject1 = a.c(this.mUg).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (String)((Iterator)localObject1).next();
        l = a.d(this.mUg).OV((String)localObject3);
        a.a(this.mUg).W((String)localObject3, l);
      }
      a.c(this.mUg).clear();
    }
    Pg("updateTimestampContact");
    if (Thread.interrupted())
    {
      localObject1 = new InterruptedException();
      AppMethodBeat.o(136667);
      throw ((Throwable)localObject1);
    }
    Object localObject1 = a.d(this.mUg).i("SELECT ROWID, username, alias, conRemark, nickname, verifyFlag, type, lvbuff, contactLabelIds FROM rcontact WHERE ROWID > ? AND deleteFlag=0 ORDER BY ROWID;", new String[] { Long.toString(this.mUk) });
    int i = 50;
    int j;
    while (((Cursor)localObject1).moveToNext())
    {
      if (Thread.interrupted())
      {
        ((Cursor)localObject1).close();
        a.a(this.mUg).commit();
        localObject1 = new InterruptedException();
        AppMethodBeat.o(136667);
        throw ((Throwable)localObject1);
      }
      l = ((Cursor)localObject1).getLong(0);
      this.mUk = l;
      localObject3 = new ad();
      ((ad)localObject3).euF = l;
      ((ad)localObject3).setUsername(((Cursor)localObject1).getString(1));
      ((ad)localObject3).jm(((Cursor)localObject1).getString(2));
      ((ad)localObject3).jn(((Cursor)localObject1).getString(3));
      ((ad)localObject3).jp(((Cursor)localObject1).getString(4));
      ((ad)localObject3).hu(((Cursor)localObject1).getInt(5));
      ((ad)localObject3).setType(((Cursor)localObject1).getInt(6));
      ((ad)localObject3).G(((Cursor)localObject1).getBlob(7));
      ((ad)localObject3).jw(((Cursor)localObject1).getString(8));
      ((ad)localObject3).hw(0);
      this.mUj.put(((aq)localObject3).field_username, localObject3);
      if ((!t.lA(((aq)localObject3).field_username)) && (this.mUg.H((ad)localObject3)) && (!this.mUi.remove(((aq)localObject3).field_username)))
      {
        j = i;
        if (i >= 50)
        {
          a.a(this.mUg).commit();
          a.a(this.mUg).beginTransaction();
          j = 0;
        }
        i = j;
        try
        {
          if (!((aq)localObject3).field_username.endsWith("@chatroom"))
          {
            i = j;
            if ((((aq)localObject3).field_verifyFlag & ad.dwB()) == 0)
            {
              i = j;
              this.mUg.F((ad)localObject3);
              i = j;
              ((ad)localObject3).dwE();
            }
          }
          i = j;
          j += this.mUg.J((ad)localObject3);
          i = j;
          this.mUn += 1;
          i = j;
        }
        catch (Exception localException4)
        {
          ab.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", localException4, "Build contact index failed with exception.\n", new Object[0]);
          this.mUp += 1;
        }
      }
    }
    ((Cursor)localObject1).close();
    a.a(this.mUg).commit();
    Pg("buildWXContact");
    if (Thread.interrupted())
    {
      localObject1 = new InterruptedException();
      AppMethodBeat.o(136667);
      throw ((Throwable)localObject1);
    }
    Object localObject4 = a.d(this.mUg).i("SELECT rowid, chatroomname, memberlist, roomdata FROM chatroom WHERE ROWID > ? ORDER BY ROWID;", new String[] { Long.toString(this.mUl) });
    i = 50;
    while (((Cursor)localObject4).moveToNext())
    {
      if (Thread.interrupted())
      {
        ((Cursor)localObject4).close();
        a.a(this.mUg).commit();
        localObject1 = new InterruptedException();
        AppMethodBeat.o(136667);
        throw ((Throwable)localObject1);
      }
      this.mUl = ((Cursor)localObject4).getLong(0);
      localObject1 = ((Cursor)localObject4).getString(1);
      if (!this.mUi.remove(localObject1))
      {
        localObject5 = (ad)this.mUj.get(localObject1);
        if (localObject5 == null)
        {
          this.mUq += 1;
        }
        else
        {
          Object localObject7 = ((Cursor)localObject4).getString(2);
          localObject6 = ((Cursor)localObject4).getBlob(3);
          for (;;)
          {
            try
            {
              localObject7 = c.a.mQW.split((CharSequence)localObject7);
              Arrays.sort((Object[])localObject7, new a.b.1(this));
              j = this.mUg.j((String)localObject1, (String[])localObject7);
              i += j;
            }
            catch (Exception localException1)
            {
              for (;;)
              {
                try
                {
                  j = this.mUg.a((String)localObject1, (ad)localObject5, (String[])localObject7, (byte[])localObject6, this.mUj);
                  i += j;
                }
                catch (Exception localException2)
                {
                  Object localObject2;
                  continue;
                }
                try
                {
                  this.mUm += 1;
                  j = i;
                  i = j;
                  if (j < 50) {
                    break;
                  }
                  a.a(this.mUg).commit();
                  a.a(this.mUg).beginTransaction();
                  i = 0;
                }
                catch (Exception localException3) {}
              }
              localException1 = localException1;
            }
            ab.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", localException1, "Build contact index failed with exception.\n", new Object[0]);
            this.mUq += 1;
            j = i;
          }
        }
      }
    }
    ((Cursor)localObject4).close();
    a.a(this.mUg).commit();
    Pg("buildChatroomContact");
    if (Thread.interrupted())
    {
      localObject2 = new InterruptedException();
      AppMethodBeat.o(136667);
      throw ((Throwable)localObject2);
    }
    this.mUo = this.mUi.size();
    localObject2 = this.mUi.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = (String)((Iterator)localObject2).next();
      a.a(this.mUg).b(c.mQI, (String)localObject4);
      ((PluginFTS)g.G(PluginFTS.class)).getTopHitsLogic().d(c.mQI, (String)localObject4);
    }
    this.mUi.clear();
    this.mUj.clear();
    Pg("deleteUnusedContact");
    ((PluginFTS)g.G(PluginFTS.class)).setFTSIndexReady(true);
    AppMethodBeat.o(136667);
    return true;
  }
  
  public final int getId()
  {
    return 1;
  }
  
  public final String getName()
  {
    return "BuildContactIndexTask";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.a.b
 * JD-Core Version:    0.7.0.1
 */