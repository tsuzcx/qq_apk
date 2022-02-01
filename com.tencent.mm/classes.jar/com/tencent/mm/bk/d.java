package com.tencent.mm.bk;

import android.database.Cursor;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f.d;
import com.tencent.mm.g.a.gg;
import com.tencent.mm.g.a.mn;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bl.d;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class d
  implements aw
{
  public static int glx = 0;
  public static int[] hxD = new int[1000];
  private final int cNj;
  private b hxA;
  private final long hxB;
  private final int hxC;
  private com.tencent.mm.sdk.b.c hxE;
  private e hxz;
  
  public d()
  {
    AppMethodBeat.i(20665);
    this.hxz = new e();
    this.hxA = new b();
    this.hxB = 259200000L;
    this.cNj = 0;
    this.hxC = 2;
    this.hxE = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(20665);
  }
  
  public static void a(cs paramcs, bl.d paramd)
  {
    AppMethodBeat.i(20672);
    ad.d("MicroMsg.SubCoreVerify", "saveToLbsVerifyStg, cmdAM, status = " + paramcs.mBi + ", id = " + paramcs.uKZ);
    bi localbi = new bi();
    localbi.field_content = z.a(paramcs.Cxz);
    localbi.field_createtime = bt.aGK();
    localbi.field_imgpath = "";
    localbi.field_sayhicontent = paramd.content;
    localbi.field_sayhiuser = paramd.yGA;
    localbi.field_scene = paramd.scene;
    if (paramcs.mBi > 3) {}
    for (int i = paramcs.mBi;; i = 3)
    {
      localbi.field_status = i;
      localbi.field_svrid = paramcs.uKZ;
      localbi.field_talker = z.a(paramcs.Cxx);
      localbi.field_type = paramcs.saz;
      localbi.field_isSend = 0;
      localbi.field_sayhiencryptuser = paramd.FAk;
      localbi.field_ticket = paramd.rso;
      localbi.field_flag = 1;
      ((bj)((k)g.ab(k.class)).cOF()).a(localbi);
      com.tencent.mm.ak.c.ac(localbi.field_sayhiencryptuser, 3);
      AppMethodBeat.o(20672);
      return;
    }
  }
  
  public static bb aCn()
  {
    AppMethodBeat.i(20666);
    g.afz().aeD();
    com.tencent.mm.storage.az localaz = aCo();
    bb localbb = (bb)((k)g.ab(k.class)).cOH();
    localbb.add(localaz, g.afE().EUN.getLooper());
    AppMethodBeat.o(20666);
    return localbb;
  }
  
  public static com.tencent.mm.storage.az aCo()
  {
    AppMethodBeat.i(20667);
    g.afz().aeD();
    com.tencent.mm.storage.az localaz = (com.tencent.mm.storage.az)((k)g.ab(k.class)).cOG();
    AppMethodBeat.o(20667);
    return localaz;
  }
  
  public static bj aCp()
  {
    AppMethodBeat.i(20668);
    g.afz().aeD();
    bj localbj = (bj)((k)g.ab(k.class)).cOF();
    AppMethodBeat.o(20668);
    return localbj;
  }
  
  public static bv aCq()
  {
    AppMethodBeat.i(20669);
    g.afz().aeD();
    bv localbv = (bv)((k)g.ab(k.class)).cOE();
    AppMethodBeat.o(20669);
    return localbv;
  }
  
  public static void b(cs paramcs, bl.d paramd)
  {
    AppMethodBeat.i(20673);
    ad.d("MicroMsg.SubCoreVerify", "saveToShakeVerifyStg, cmdAM, status = " + paramcs.mBi + ", id = " + paramcs.uKZ);
    bu localbu = new bu();
    localbu.field_content = z.a(paramcs.Cxz);
    localbu.field_createtime = bt.aGK();
    localbu.field_imgpath = "";
    localbu.field_sayhicontent = paramd.content;
    localbu.field_sayhiuser = paramd.yGA;
    localbu.field_scene = paramd.scene;
    if (paramcs.mBi > 3) {}
    for (int i = paramcs.mBi;; i = 3)
    {
      localbu.field_status = i;
      localbu.field_svrid = paramcs.uKZ;
      localbu.field_talker = z.a(paramcs.Cxx);
      localbu.field_type = paramcs.saz;
      localbu.field_isSend = 0;
      ((bv)((k)g.ab(k.class)).cOE()).a(localbu);
      com.tencent.mm.ak.c.ac(localbu.field_sayhiuser, 3);
      AppMethodBeat.o(20673);
      return;
    }
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    int i = 1;
    AppMethodBeat.i(20671);
    f.d.a(Integer.valueOf(37), this.hxz);
    f.d.a(Integer.valueOf(65), this.hxz);
    f.d.a(Integer.valueOf(40), this.hxA);
    com.tencent.mm.sdk.b.a.ESL.c(this.hxE);
    int j = aCo().eLD();
    long l = System.currentTimeMillis();
    com.tencent.mm.model.az.arV();
    l -= bt.a((Long)com.tencent.mm.model.c.afk().get(340225, null), 0L);
    ad.i("MicroMsg.SubCoreVerify", "timeInterval = ".concat(String.valueOf(l)));
    if ((l > 259200000L) && (j > 0))
    {
      Object localObject1 = aCo();
      Object localObject2 = String.format("select %s from %s where isNew = 1 ORDER BY lastModifiedTime DESC limit %d", new Object[] { "contentNickname", "fmessage_conversation", Integer.valueOf(2) });
      localObject1 = ((com.tencent.mm.storage.az)localObject1).db.a((String)localObject2, null, 2);
      localObject2 = new ArrayList();
      while (((Cursor)localObject1).moveToNext()) {
        ((List)localObject2).add(((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("contentNickname")));
      }
      ((Cursor)localObject1).close();
      j = ((List)localObject2).size();
      if (j > 0)
      {
        localObject1 = (String)((List)localObject2).get(0);
        while (i < j)
        {
          localObject1 = (String)localObject1 + ", " + (String)((List)localObject2).get(i);
          i += 1;
        }
        ad.i("MicroMsg.SubCoreVerify", "title = ".concat(String.valueOf(localObject1)));
        localObject2 = new mn();
        ((mn)localObject2).drG.userName = null;
        ((mn)localObject2).drG.bNK = ((String)localObject1);
        ((mn)localObject2).drG.type = 0;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject2);
        com.tencent.mm.model.az.arV();
        com.tencent.mm.model.c.afk().set(340225, Long.valueOf(System.currentTimeMillis()));
      }
    }
    AppMethodBeat.o(20671);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(20670);
    f.d.b(Integer.valueOf(37), this.hxz);
    f.d.b(Integer.valueOf(65), this.hxz);
    f.d.b(Integer.valueOf(40), this.hxA);
    com.tencent.mm.sdk.b.a.ESL.d(this.hxE);
    com.tencent.mm.model.az.getNotification().TU();
    AppMethodBeat.o(20670);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.bk.d
 * JD-Core Version:    0.7.0.1
 */