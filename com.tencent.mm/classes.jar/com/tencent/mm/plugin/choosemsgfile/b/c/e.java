package com.tencent.mm.plugin.choosemsgfile.b.c;

import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.choosemsgfile.b.b.k;
import com.tencent.mm.plugin.choosemsgfile.b.b.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.storage.ca;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class e
  extends b
{
  public LinearLayoutManager oDV;
  protected List<com.tencent.mm.plugin.choosemsgfile.b.b.a> opg;
  d qos;
  
  public e(com.tencent.mm.plugin.choosemsgfile.ui.c paramc)
  {
    super(paramc);
    AppMethodBeat.i(123322);
    this.opg = new ArrayList();
    AppMethodBeat.o(123322);
  }
  
  public final void c(final boolean paramBoolean, String paramString1, final String paramString2)
  {
    AppMethodBeat.i(123324);
    Log.i("MicroMsg.ChooseMsgFileListUIController", "[loadData] isFirst:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.qon.kF(paramBoolean);
    if (paramBoolean) {
      this.opg.clear();
    }
    g.aAi();
    g.aAk().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(123319);
        LinkedList localLinkedList = new LinkedList();
        Cursor localCursor = ((l)g.af(l.class)).eiy().ez(e.this.goe, -1);
        if (localCursor == null)
        {
          Log.e("MicroMsg.ChooseMsgFileListUIController", "[loadData] cursor is null!");
          AppMethodBeat.o(123319);
          return;
        }
        List localList = com.tencent.mm.plugin.choosemsgfile.b.d.c.akz(paramString2);
        long l1 = 0L;
        label390:
        for (;;)
        {
          try
          {
            if (localCursor.moveToNext())
            {
              ca localca = new ca();
              localca.convertFrom(localCursor);
              Object localObject2 = localca.field_content;
              if (localObject2 == null) {
                break label390;
              }
              localObject2 = k.b.HD((String)localObject2);
              if ((localObject2 == null) || (((k.b)localObject2).type != 6)) {
                break label390;
              }
              localObject2 = new k(e.this.qos, localca, e.this.goe);
              if (localList.size() == 0)
              {
                i = 1;
                if (i == 0) {
                  continue;
                }
                localObject3 = new Date(localca.field_createTime);
                long l2 = com.tencent.mm.ui.gridviewheaders.a.gWr().b((Date)localObject3);
                if (l1 != l2) {
                  localLinkedList.add(new com.tencent.mm.plugin.choosemsgfile.b.b.i(e.this.qos, localca.field_createTime));
                }
                localLinkedList.add(localObject2);
                l1 = l2;
                break label390;
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
              e.this.opg.addAll(localLinkedList);
              localLinkedList.clear();
              Log.i("MicroMsg.ChooseMsgFileListUIController", "[loadData] data:%s", new Object[] { Integer.valueOf(e.this.opg.size()) });
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(123318);
                  if (e.this.qon != null) {
                    e.this.qon.D(e.2.this.qoy, e.this.opg.size());
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
        }
      }
    });
    AppMethodBeat.o(123324);
  }
  
  public final RecyclerView.a cyF()
  {
    AppMethodBeat.i(123323);
    this.qos = new d(this.qon, this.opg);
    a.qoq = new g.b() {};
    this.qos.qop = new g.a()
    {
      public final void a(boolean paramAnonymousBoolean, final com.tencent.mm.plugin.choosemsgfile.b.b.a paramAnonymousa, final RecyclerView.v paramAnonymousv)
      {
        AppMethodBeat.i(123317);
        if (paramAnonymousa == null)
        {
          Log.e("MicroMsg.ChooseMsgFileListUIController", "[onCheck] item is null, err");
          AppMethodBeat.o(123317);
          return;
        }
        Log.i("MicroMsg.ChooseMsgFileListUIController", "[onCheck] isChecked :%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (paramAnonymousBoolean)
        {
          paramAnonymousa.cyu();
          e.a(e.this).BZ(paramAnonymousa.qnv.field_msgId);
          com.tencent.mm.plugin.choosemsgfile.b.a.b.a(paramAnonymousa, new com.tencent.mm.plugin.choosemsgfile.b.a.a()
          {
            public final void a(MsgFile paramAnonymous2MsgFile)
            {
              AppMethodBeat.i(123311);
              Log.i("MicroMsg.ChooseMsgFileListUIController", "item:%s onDownloadSuccess msgFile:%s", new Object[] { paramAnonymousa, paramAnonymous2MsgFile });
              e.a(e.this).Ca(paramAnonymousa.qnv.field_msgId);
              e.a(e.this).a(paramAnonymousa.qnv.field_msgId, paramAnonymous2MsgFile);
              if (e.a(e.this).cyG()) {
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(123310);
                    e.this.qos.atj.notifyChanged();
                    AppMethodBeat.o(123310);
                  }
                });
              }
              e.this.qon.cyJ();
              paramAnonymousa.cyv();
              paramAnonymous2MsgFile = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((n)paramAnonymousv).qnZ.getTag();
              if (paramAnonymous2MsgFile.equals(paramAnonymousa)) {
                paramAnonymous2MsgFile.V(paramAnonymousv);
              }
              AppMethodBeat.o(123311);
            }
            
            public final void cyk()
            {
              AppMethodBeat.i(123312);
              Log.e("MicroMsg.ChooseMsgFileListUIController", "item:%s onDownloadFails", new Object[] { paramAnonymousa });
              e.a(e.this).Ca(paramAnonymousa.qnv.field_msgId);
              paramAnonymousa.cyx();
              com.tencent.mm.plugin.choosemsgfile.b.b.a locala = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((n)paramAnonymousv).qnZ.getTag();
              if (locala.equals(paramAnonymousa)) {
                locala.V(paramAnonymousv);
              }
              AppMethodBeat.o(123312);
            }
            
            public final void cyl()
            {
              AppMethodBeat.i(123313);
              Log.i("MicroMsg.ChooseMsgFileListUIController", "item:%s onDownloadPause", new Object[] { paramAnonymousa });
              e.a(e.this).Ca(paramAnonymousa.qnv.field_msgId);
              paramAnonymousa.cyy();
              com.tencent.mm.plugin.choosemsgfile.b.b.a locala = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((n)paramAnonymousv).qnZ.getTag();
              if (locala.equals(paramAnonymousa)) {
                locala.V(paramAnonymousv);
              }
              AppMethodBeat.o(123313);
            }
            
            public final void cym()
            {
              AppMethodBeat.i(123314);
              Log.e("MicroMsg.ChooseMsgFileListUIController", "item:%s onExpireFail", new Object[] { paramAnonymousa });
              e.a(e.this).Ca(paramAnonymousa.qnv.field_msgId);
              paramAnonymousa.cyw();
              com.tencent.mm.plugin.choosemsgfile.b.b.a locala = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((n)paramAnonymousv).qnZ.getTag();
              if (locala.equals(paramAnonymousa)) {
                locala.V(paramAnonymousv);
              }
              AppMethodBeat.o(123314);
            }
            
            public final void fk(int paramAnonymous2Int1, int paramAnonymous2Int2)
            {
              AppMethodBeat.i(123315);
              Log.e("MicroMsg.ChooseMsgFileListUIController", "item:%s onDownloadProgress offset:%d totalLen:%d", new Object[] { paramAnonymousa, Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
              paramAnonymousa.fm(paramAnonymous2Int1, paramAnonymous2Int2);
              com.tencent.mm.plugin.choosemsgfile.b.b.a locala = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((n)paramAnonymousv).qnZ.getTag();
              if (locala.equals(paramAnonymousa)) {
                locala.V(paramAnonymousv);
              }
              AppMethodBeat.o(123315);
            }
          }, e.this.cyE());
        }
        for (;;)
        {
          paramAnonymousa.V(paramAnonymousv);
          AppMethodBeat.o(123317);
          return;
          paramAnonymousa.cyy();
          e.a(e.this).Ca(paramAnonymousa.qnv.field_msgId);
          e.a(e.this).BX(paramAnonymousa.qnv.field_msgId);
          if (e.a(e.this).cyG()) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(123316);
                e.this.qos.atj.notifyChanged();
                AppMethodBeat.o(123316);
              }
            });
          }
          e.this.qon.cyJ();
        }
      }
    };
    d locald = this.qos;
    AppMethodBeat.o(123323);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.c.e
 * JD-Core Version:    0.7.0.1
 */