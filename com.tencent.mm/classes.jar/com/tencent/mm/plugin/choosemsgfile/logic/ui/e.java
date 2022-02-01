package com.tencent.mm.plugin.choosemsgfile.logic.ui;

import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.s;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.k.b;
import com.tencent.mm.plugin.choosemsgfile.a.b;
import com.tencent.mm.plugin.choosemsgfile.a.c;
import com.tencent.mm.plugin.choosemsgfile.logic.b.k;
import com.tencent.mm.plugin.choosemsgfile.logic.c.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.cc;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends b
{
  public LinearLayoutManager uQP;
  protected List<com.tencent.mm.plugin.choosemsgfile.logic.b.a> uQh;
  d wQq;
  
  public e(com.tencent.mm.plugin.choosemsgfile.ui.e parame)
  {
    super(parame);
    AppMethodBeat.i(123322);
    this.uQh = new ArrayList();
    AppMethodBeat.o(123322);
  }
  
  public final void c(final boolean paramBoolean, String paramString1, final String paramString2)
  {
    AppMethodBeat.i(123324);
    Log.i("MicroMsg.ChooseMsgFileListUIController", "[loadData] isFirst:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.wQl.nm(paramBoolean);
    if (paramBoolean) {
      this.uQh.clear();
    }
    h.baF();
    h.baH().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(123319);
        LinkedList localLinkedList = new LinkedList();
        Cursor localCursor = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().fT(e.this.luk, -1);
        if (localCursor == null)
        {
          Log.e("MicroMsg.ChooseMsgFileListUIController", "[loadData] cursor is null!");
          AppMethodBeat.o(123319);
          return;
        }
        List localList = c.alS(paramString2);
        long l1 = 0L;
        label396:
        label399:
        label404:
        for (;;)
        {
          try
          {
            if (localCursor.moveToNext())
            {
              cc localcc = new cc();
              localcc.convertFrom(localCursor);
              Object localObject2 = localcc.field_content;
              if (localObject2 == null) {
                break label396;
              }
              localObject2 = k.b.Hf((String)localObject2);
              if ((localObject2 == null) || (((k.b)localObject2).type != 6)) {
                break label396;
              }
              localObject2 = new k(e.this.wQq, localcc, e.this.luk);
              if (localList == null) {
                break label399;
              }
              if (localList.size() == 0)
              {
                break label399;
                if (i == 0) {
                  continue;
                }
                localObject3 = new Date(localcc.getCreateTime());
                long l2 = com.tencent.mm.ui.gridviewheaders.a.jBw().b((Date)localObject3);
                if (l1 != l2) {
                  localLinkedList.add(new com.tencent.mm.plugin.choosemsgfile.logic.b.i(e.this.wQq, localcc.getCreateTime()));
                }
                localLinkedList.add(localObject2);
                l1 = l2;
                break label404;
              }
              Object localObject3 = localList.iterator();
              if (((Iterator)localObject3).hasNext())
              {
                String str = (String)((Iterator)localObject3).next();
                boolean bool = ((k)localObject2).getFileName().endsWith(str);
                if (!bool) {
                  continue;
                }
                i = 1;
                continue;
              }
            }
            else
            {
              localCursor.close();
              e.this.uQh.addAll(localLinkedList);
              localLinkedList.clear();
              Log.i("MicroMsg.ChooseMsgFileListUIController", "[loadData] data:%s", new Object[] { Integer.valueOf(e.this.uQh.size()) });
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(123318);
                  if (e.this.wQl != null) {
                    e.this.wQl.F(e.2.this.wQx, e.this.uQh.size());
                  }
                  AppMethodBeat.o(123318);
                }
              });
              AppMethodBeat.o(123319);
              return;
            }
          }
          finally
          {
            localCursor.close();
            AppMethodBeat.o(123319);
          }
          int i = 0;
          continue;
          break label404;
          i = 1;
        }
      }
    });
    AppMethodBeat.o(123324);
  }
  
  public final RecyclerView.a dqG()
  {
    AppMethodBeat.i(262576);
    this.wQq = new d(this.wQl, this.uQh);
    this.wQq.wQo = new g.b() {};
    this.wQq.wQn = new g.a()
    {
      public final void a(boolean paramAnonymousBoolean, final com.tencent.mm.plugin.choosemsgfile.logic.b.a paramAnonymousa, final RecyclerView.v paramAnonymousv)
      {
        AppMethodBeat.i(262581);
        if (paramAnonymousa == null)
        {
          Log.e("MicroMsg.ChooseMsgFileListUIController", "[onCheck] item is null, err");
          AppMethodBeat.o(262581);
          return;
        }
        Log.i("MicroMsg.ChooseMsgFileListUIController", "[onCheck] isChecked :%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (paramAnonymousBoolean)
        {
          paramAnonymousa.dqu();
          e.a(e.this).kA(paramAnonymousa.wPy.field_msgId);
          com.tencent.mm.plugin.choosemsgfile.logic.a.b.a(paramAnonymousa, new com.tencent.mm.plugin.choosemsgfile.logic.a.a()
          {
            public final void a(MsgFile paramAnonymous2MsgFile)
            {
              AppMethodBeat.i(123311);
              Log.i("MicroMsg.ChooseMsgFileListUIController", "item:%s onDownloadSuccess msgFile:%s", new Object[] { paramAnonymousa, paramAnonymous2MsgFile });
              e.a(e.this).kB(paramAnonymousa.wPy.field_msgId);
              e.a(e.this).a(paramAnonymousa.wPy.field_msgId, paramAnonymous2MsgFile);
              if (e.a(e.this).dqH()) {
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(123310);
                    e.this.wQq.bZE.notifyChanged();
                    AppMethodBeat.o(123310);
                  }
                });
              }
              e.this.wQl.dqK();
              paramAnonymousa.dqv();
              paramAnonymous2MsgFile = (com.tencent.mm.plugin.choosemsgfile.logic.b.a)((com.tencent.mm.plugin.choosemsgfile.logic.b.n)paramAnonymousv).wPX.getTag();
              if (paramAnonymous2MsgFile.equals(paramAnonymousa)) {
                paramAnonymous2MsgFile.Q(paramAnonymousv);
              }
              AppMethodBeat.o(123311);
            }
            
            public final void dqj()
            {
              AppMethodBeat.i(123312);
              Log.e("MicroMsg.ChooseMsgFileListUIController", "item:%s onDownloadFails", new Object[] { paramAnonymousa });
              e.a(e.this).kB(paramAnonymousa.wPy.field_msgId);
              paramAnonymousa.dqx();
              com.tencent.mm.plugin.choosemsgfile.logic.b.a locala = (com.tencent.mm.plugin.choosemsgfile.logic.b.a)((com.tencent.mm.plugin.choosemsgfile.logic.b.n)paramAnonymousv).wPX.getTag();
              if (locala.equals(paramAnonymousa)) {
                locala.Q(paramAnonymousv);
              }
              AppMethodBeat.o(123312);
            }
            
            public final void dqk()
            {
              AppMethodBeat.i(123313);
              Log.i("MicroMsg.ChooseMsgFileListUIController", "item:%s onDownloadPause", new Object[] { paramAnonymousa });
              e.a(e.this).kB(paramAnonymousa.wPy.field_msgId);
              paramAnonymousa.dqy();
              com.tencent.mm.plugin.choosemsgfile.logic.b.a locala = (com.tencent.mm.plugin.choosemsgfile.logic.b.a)((com.tencent.mm.plugin.choosemsgfile.logic.b.n)paramAnonymousv).wPX.getTag();
              if (locala.equals(paramAnonymousa)) {
                locala.Q(paramAnonymousv);
              }
              AppMethodBeat.o(123313);
            }
            
            public final void dql()
            {
              AppMethodBeat.i(123314);
              Log.e("MicroMsg.ChooseMsgFileListUIController", "item:%s onExpireFail", new Object[] { paramAnonymousa });
              e.a(e.this).kB(paramAnonymousa.wPy.field_msgId);
              paramAnonymousa.dqw();
              com.tencent.mm.plugin.choosemsgfile.logic.b.a locala = (com.tencent.mm.plugin.choosemsgfile.logic.b.a)((com.tencent.mm.plugin.choosemsgfile.logic.b.n)paramAnonymousv).wPX.getTag();
              if (locala.equals(paramAnonymousa)) {
                locala.Q(paramAnonymousv);
              }
              AppMethodBeat.o(123314);
            }
            
            public final void gz(int paramAnonymous2Int1, int paramAnonymous2Int2)
            {
              AppMethodBeat.i(123315);
              Log.e("MicroMsg.ChooseMsgFileListUIController", "item:%s onDownloadProgress offset:%d totalLen:%d", new Object[] { paramAnonymousa, Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
              paramAnonymousa.gB(paramAnonymous2Int1, paramAnonymous2Int2);
              com.tencent.mm.plugin.choosemsgfile.logic.b.a locala = (com.tencent.mm.plugin.choosemsgfile.logic.b.a)((com.tencent.mm.plugin.choosemsgfile.logic.b.n)paramAnonymousv).wPX.getTag();
              if (locala.equals(paramAnonymousa)) {
                locala.Q(paramAnonymousv);
              }
              AppMethodBeat.o(123315);
            }
          }, e.this.dqF());
        }
        for (;;)
        {
          paramAnonymousa.Q(paramAnonymousv);
          AppMethodBeat.o(262581);
          return;
          paramAnonymousa.dqy();
          e.a(e.this).kB(paramAnonymousa.wPy.field_msgId);
          e.a(e.this).ky(paramAnonymousa.wPy.field_msgId);
          if (e.a(e.this).dqH()) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(123316);
                e.this.wQq.bZE.notifyChanged();
                AppMethodBeat.o(123316);
              }
            });
          }
          e.this.wQl.dqK();
        }
      }
    };
    d locald = this.wQq;
    AppMethodBeat.o(262576);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.logic.ui.e
 * JD-Core Version:    0.7.0.1
 */