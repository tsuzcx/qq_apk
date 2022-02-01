package com.tencent.mm.plugin.choosemsgfile.b.c;

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
import com.tencent.mm.aj.k.b;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.choosemsgfile.a.b;
import com.tencent.mm.plugin.choosemsgfile.a.c;
import com.tencent.mm.plugin.choosemsgfile.b.b.k;
import com.tencent.mm.plugin.choosemsgfile.b.d.c;
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
  protected List<com.tencent.mm.plugin.choosemsgfile.b.b.a> rEV;
  public LinearLayoutManager rFD;
  d tNa;
  
  public e(com.tencent.mm.plugin.choosemsgfile.ui.e parame)
  {
    super(parame);
    AppMethodBeat.i(123322);
    this.rEV = new ArrayList();
    AppMethodBeat.o(123322);
  }
  
  public final RecyclerView.a cNa()
  {
    AppMethodBeat.i(243393);
    this.tNa = new d(this.tMV, this.rEV);
    a.tMY = new g.b() {};
    this.tNa.tMX = new g.a()
    {
      public final void a(boolean paramAnonymousBoolean, final com.tencent.mm.plugin.choosemsgfile.b.b.a paramAnonymousa, final RecyclerView.v paramAnonymousv)
      {
        AppMethodBeat.i(243521);
        if (paramAnonymousa == null)
        {
          Log.e("MicroMsg.ChooseMsgFileListUIController", "[onCheck] item is null, err");
          AppMethodBeat.o(243521);
          return;
        }
        Log.i("MicroMsg.ChooseMsgFileListUIController", "[onCheck] isChecked :%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (paramAnonymousBoolean)
        {
          paramAnonymousa.cMP();
          e.a(e.this).Ii(paramAnonymousa.tMi.field_msgId);
          com.tencent.mm.plugin.choosemsgfile.b.a.b.a(paramAnonymousa, new com.tencent.mm.plugin.choosemsgfile.b.a.a()
          {
            public final void a(MsgFile paramAnonymous2MsgFile)
            {
              AppMethodBeat.i(123311);
              Log.i("MicroMsg.ChooseMsgFileListUIController", "item:%s onDownloadSuccess msgFile:%s", new Object[] { paramAnonymousa, paramAnonymous2MsgFile });
              e.a(e.this).Ij(paramAnonymousa.tMi.field_msgId);
              e.a(e.this).a(paramAnonymousa.tMi.field_msgId, paramAnonymous2MsgFile);
              if (e.a(e.this).cNb()) {
                MMHandlerThread.postToMainThread(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(123310);
                    e.this.tNa.alc.notifyChanged();
                    AppMethodBeat.o(123310);
                  }
                });
              }
              e.this.tMV.cNe();
              paramAnonymousa.cMQ();
              paramAnonymous2MsgFile = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((com.tencent.mm.plugin.choosemsgfile.b.b.n)paramAnonymousv).tMH.getTag();
              if (paramAnonymous2MsgFile.equals(paramAnonymousa)) {
                paramAnonymous2MsgFile.V(paramAnonymousv);
              }
              AppMethodBeat.o(123311);
            }
            
            public final void cMF()
            {
              AppMethodBeat.i(123312);
              Log.e("MicroMsg.ChooseMsgFileListUIController", "item:%s onDownloadFails", new Object[] { paramAnonymousa });
              e.a(e.this).Ij(paramAnonymousa.tMi.field_msgId);
              paramAnonymousa.cMS();
              com.tencent.mm.plugin.choosemsgfile.b.b.a locala = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((com.tencent.mm.plugin.choosemsgfile.b.b.n)paramAnonymousv).tMH.getTag();
              if (locala.equals(paramAnonymousa)) {
                locala.V(paramAnonymousv);
              }
              AppMethodBeat.o(123312);
            }
            
            public final void cMG()
            {
              AppMethodBeat.i(123313);
              Log.i("MicroMsg.ChooseMsgFileListUIController", "item:%s onDownloadPause", new Object[] { paramAnonymousa });
              e.a(e.this).Ij(paramAnonymousa.tMi.field_msgId);
              paramAnonymousa.cMT();
              com.tencent.mm.plugin.choosemsgfile.b.b.a locala = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((com.tencent.mm.plugin.choosemsgfile.b.b.n)paramAnonymousv).tMH.getTag();
              if (locala.equals(paramAnonymousa)) {
                locala.V(paramAnonymousv);
              }
              AppMethodBeat.o(123313);
            }
            
            public final void cMH()
            {
              AppMethodBeat.i(123314);
              Log.e("MicroMsg.ChooseMsgFileListUIController", "item:%s onExpireFail", new Object[] { paramAnonymousa });
              e.a(e.this).Ij(paramAnonymousa.tMi.field_msgId);
              paramAnonymousa.cMR();
              com.tencent.mm.plugin.choosemsgfile.b.b.a locala = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((com.tencent.mm.plugin.choosemsgfile.b.b.n)paramAnonymousv).tMH.getTag();
              if (locala.equals(paramAnonymousa)) {
                locala.V(paramAnonymousv);
              }
              AppMethodBeat.o(123314);
            }
            
            public final void fH(int paramAnonymous2Int1, int paramAnonymous2Int2)
            {
              AppMethodBeat.i(123315);
              Log.e("MicroMsg.ChooseMsgFileListUIController", "item:%s onDownloadProgress offset:%d totalLen:%d", new Object[] { paramAnonymousa, Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
              paramAnonymousa.fJ(paramAnonymous2Int1, paramAnonymous2Int2);
              com.tencent.mm.plugin.choosemsgfile.b.b.a locala = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((com.tencent.mm.plugin.choosemsgfile.b.b.n)paramAnonymousv).tMH.getTag();
              if (locala.equals(paramAnonymousa)) {
                locala.V(paramAnonymousv);
              }
              AppMethodBeat.o(123315);
            }
          }, e.this.cMZ());
        }
        for (;;)
        {
          paramAnonymousa.V(paramAnonymousv);
          AppMethodBeat.o(243521);
          return;
          paramAnonymousa.cMT();
          e.a(e.this).Ij(paramAnonymousa.tMi.field_msgId);
          e.a(e.this).Ig(paramAnonymousa.tMi.field_msgId);
          if (e.a(e.this).cNb()) {
            MMHandlerThread.postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(123316);
                e.this.tNa.alc.notifyChanged();
                AppMethodBeat.o(123316);
              }
            });
          }
          e.this.tMV.cNe();
        }
      }
    };
    d locald = this.tNa;
    AppMethodBeat.o(243393);
    return locald;
  }
  
  public final void d(final boolean paramBoolean, String paramString1, final String paramString2)
  {
    AppMethodBeat.i(123324);
    Log.i("MicroMsg.ChooseMsgFileListUIController", "[loadData] isFirst:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.tMV.lR(paramBoolean);
    if (paramBoolean) {
      this.rEV.clear();
    }
    h.aHH();
    h.aHJ().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(123319);
        LinkedList localLinkedList = new LinkedList();
        Cursor localCursor = ((com.tencent.mm.plugin.messenger.foundation.a.n)h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).eSe().fa(e.this.iSn, -1);
        if (localCursor == null)
        {
          Log.e("MicroMsg.ChooseMsgFileListUIController", "[loadData] cursor is null!");
          AppMethodBeat.o(123319);
          return;
        }
        List localList = c.asn(paramString2);
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
              localObject2 = k.b.OQ((String)localObject2);
              if ((localObject2 == null) || (((k.b)localObject2).type != 6)) {
                break label390;
              }
              localObject2 = new k(e.this.tNa, localca, e.this.iSn);
              if (localList.size() == 0)
              {
                i = 1;
                if (i == 0) {
                  continue;
                }
                localObject3 = new Date(localca.field_createTime);
                long l2 = com.tencent.mm.ui.gridviewheaders.a.hWZ().b((Date)localObject3);
                if (l1 != l2) {
                  localLinkedList.add(new com.tencent.mm.plugin.choosemsgfile.b.b.i(e.this.tNa, localca.field_createTime));
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
              e.this.rEV.addAll(localLinkedList);
              localLinkedList.clear();
              Log.i("MicroMsg.ChooseMsgFileListUIController", "[loadData] data:%s", new Object[] { Integer.valueOf(e.this.rEV.size()) });
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(123318);
                  if (e.this.tMV != null) {
                    e.this.tMV.H(e.2.this.tNh, e.this.rEV.size());
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.c.e
 * JD-Core Version:    0.7.0.1
 */