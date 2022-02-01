package com.tencent.mm.plugin.choosemsgfile.b.c;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.GridLayoutManager.b;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.g.a.hu;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.choosemsgfile.b.b.m;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.bo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;

public final class f
  extends b
{
  int MW;
  public c opG;
  private com.tencent.mm.sdk.b.c opH;
  private GridLayoutManager opI;
  int opJ;
  
  public f(com.tencent.mm.plugin.choosemsgfile.ui.c paramc)
  {
    super(paramc);
    AppMethodBeat.i(123339);
    this.MW = 0;
    this.opJ = 0;
    this.opH = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(123339);
  }
  
  public final void b(final boolean paramBoolean, final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(123346);
    if (paramBoolean)
    {
      this.ijj.clear();
      this.MW = 0;
    }
    this.opG.opw = true;
    this.ops.js(paramBoolean);
    g.agS();
    g.agU().az(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(123338);
        LinkedList localLinkedList = new LinkedList();
        Cursor localCursor = ((k)g.ab(k.class)).dcr().dP(f.this.foE, f.this.MW);
        if (localCursor == null)
        {
          ac.e("MicroMsg.ChooseMsgFileUIController", "[loadData] NULL == cursor ");
          AppMethodBeat.o(123338);
          return;
        }
        long l1 = 0L;
        label723:
        for (;;)
        {
          Object localObject2;
          long l2;
          try
          {
            Object localObject4;
            if (localCursor.moveToNext())
            {
              f.b(f.this);
              localObject2 = new bo();
              ((bo)localObject2).convertFrom(localCursor);
              localObject3 = com.tencent.mm.plugin.choosemsgfile.b.d.c.a(f.this.opG, (bo)localObject2, f.this.foE, paramString1, paramString2);
              if (localObject3 == null) {
                break label723;
              }
              localObject4 = new Date(((dy)localObject2).field_createTime);
              l2 = com.tencent.mm.ui.gridviewheaders.a.fsS().b((Date)localObject4);
              if (l1 != l2)
              {
                localLinkedList.add(new com.tencent.mm.plugin.choosemsgfile.b.b.c(f.this.opG, ((dy)localObject2).field_createTime));
                f.c(f.this);
              }
              localLinkedList.add(localObject3);
              l1 = l2;
              continue;
            }
            localCursor.close();
            localObject2 = new LinkedList();
            if (localLinkedList.size() - f.this.opJ != 200) {
              break label614;
            }
            l1 = ((com.tencent.mm.plugin.choosemsgfile.b.b.a)localLinkedList.get(0)).getTimeStamp();
            com.tencent.mm.ui.gridviewheaders.a.fsS();
            l2 = com.tencent.mm.ui.gridviewheaders.a.By(l1);
            ac.i("MicroMsg.ChooseMsgFileUIController", "[loadData] list size:%s start:%s end:%s", new Object[] { Integer.valueOf(localLinkedList.size()), Long.valueOf(l2), Long.valueOf(l1) });
            localCursor = ((k)g.ab(k.class)).dcr().A(f.this.foE, l2, l1);
            Object localObject3 = new Date(l1);
            l1 = com.tencent.mm.ui.gridviewheaders.a.fsS().b((Date)localObject3);
            if (localCursor == null) {
              break label602;
            }
            try
            {
              if (!localCursor.moveToNext()) {
                break label602;
              }
              f.b(f.this);
              localObject4 = new bo();
              ((bo)localObject4).convertFrom(localCursor);
              com.tencent.mm.plugin.choosemsgfile.b.b.a locala = com.tencent.mm.plugin.choosemsgfile.b.d.c.a(f.this.opG, (bo)localObject4, f.this.foE, paramString1, paramString2);
              if (locala == null) {
                continue;
              }
              Date localDate = new Date(((dy)localObject4).field_createTime);
              l2 = com.tencent.mm.ui.gridviewheaders.a.fsS().b(localDate);
              if ((l1 != l2) && (com.tencent.mm.ui.gridviewheaders.a.fsS().b((Date)localObject3) != l2))
              {
                ((LinkedList)localObject2).add(new com.tencent.mm.plugin.choosemsgfile.b.b.c(f.this.opG, ((dy)localObject4).field_createTime));
                f.c(f.this);
                ((LinkedList)localObject2).add(locala);
                l1 = l2;
                continue;
              }
            }
            finally
            {
              if (localCursor == null) {}
            }
            l2 = l1;
          }
          finally
          {
            localCursor.close();
            AppMethodBeat.o(123338);
          }
          if (localCollection.size() > 0)
          {
            l2 = l1;
            if (((LinkedList)localObject2).size() == 0)
            {
              ((LinkedList)localObject2).add(0, localCollection.remove(0));
              l2 = l1;
              continue;
              label602:
              if (localCursor != null) {
                localCursor.close();
              }
              label614:
              int i = localCollection.size();
              int j = ((LinkedList)localObject2).size();
              f.this.ijj.addAll(0, (Collection)localObject2);
              f.this.ijj.addAll(((LinkedList)localObject2).size(), localCollection);
              localCollection.clear();
              ((LinkedList)localObject2).clear();
              f.this.opJ = 0;
              ac.i("MicroMsg.ChooseMsgFileUIController", "[loadData] %s", new Object[] { Integer.valueOf(f.this.ijj.size()) });
              ap.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(123337);
                  f.this.opG.opw = false;
                  f.this.ops.B(f.5.this.opD, this.opN);
                  AppMethodBeat.o(123337);
                }
              });
              AppMethodBeat.o(123338);
              return;
            }
          }
        }
      }
    });
    AppMethodBeat.o(123346);
  }
  
  public final RecyclerView.a bUV()
  {
    AppMethodBeat.i(123344);
    this.opG = new c(this.ops, this.ijj);
    this.opG.opu = new g.a()
    {
      public final void a(boolean paramAnonymousBoolean, final com.tencent.mm.plugin.choosemsgfile.b.b.a paramAnonymousa, final RecyclerView.w paramAnonymousw)
      {
        AppMethodBeat.i(123334);
        if (paramAnonymousa == null)
        {
          ac.e("MicroMsg.ChooseMsgFileUIController", "[onCheck] item is null, err");
          AppMethodBeat.o(123334);
          return;
        }
        ac.i("MicroMsg.ChooseMsgFileUIController", "[onCheck] isChecked:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (paramAnonymousBoolean)
        {
          paramAnonymousa.bUK();
          f.a(f.this).rE(paramAnonymousa.ooz.field_msgId);
          com.tencent.mm.plugin.choosemsgfile.b.a.b.a(paramAnonymousa, new com.tencent.mm.plugin.choosemsgfile.b.a.a()
          {
            public final void a(MsgFile paramAnonymous2MsgFile)
            {
              AppMethodBeat.i(123328);
              ac.i("MicroMsg.ChooseMsgFileUIController", "item:%s onDownloadSuccess msgFile:%s", new Object[] { paramAnonymousa, paramAnonymous2MsgFile });
              f.a(f.this).rF(paramAnonymousa.ooz.field_msgId);
              f.a(f.this).a(paramAnonymousa.ooz.field_msgId, paramAnonymous2MsgFile);
              if (f.a(f.this).bUX()) {
                ap.f(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(123327);
                    f.this.opG.arg.notifyChanged();
                    AppMethodBeat.o(123327);
                  }
                });
              }
              f.this.ops.bVa();
              paramAnonymousa.bUL();
              paramAnonymous2MsgFile = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((m)paramAnonymousw).opg.getTag();
              if (paramAnonymous2MsgFile.equals(paramAnonymousa)) {
                paramAnonymous2MsgFile.T(paramAnonymousw);
              }
              AppMethodBeat.o(123328);
            }
            
            public final void bUA()
            {
              AppMethodBeat.i(123330);
              ac.i("MicroMsg.ChooseMsgFileUIController", "item:%s onDownloadPause", new Object[] { paramAnonymousa });
              f.a(f.this).rF(paramAnonymousa.ooz.field_msgId);
              paramAnonymousa.bUO();
              com.tencent.mm.plugin.choosemsgfile.b.b.a locala = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((m)paramAnonymousw).opg.getTag();
              if (locala.equals(paramAnonymousa)) {
                locala.T(paramAnonymousw);
              }
              AppMethodBeat.o(123330);
            }
            
            public final void bUB()
            {
              AppMethodBeat.i(123331);
              ac.e("MicroMsg.ChooseMsgFileUIController", "item:%s onExpireFail", new Object[] { paramAnonymousa });
              f.a(f.this).rF(paramAnonymousa.ooz.field_msgId);
              paramAnonymousa.bUM();
              com.tencent.mm.plugin.choosemsgfile.b.b.a locala = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((m)paramAnonymousw).opg.getTag();
              if (locala.equals(paramAnonymousa)) {
                locala.T(paramAnonymousw);
              }
              AppMethodBeat.o(123331);
            }
            
            public final void bUz()
            {
              AppMethodBeat.i(123329);
              ac.e("MicroMsg.ChooseMsgFileUIController", "item:%s onDownloadFails", new Object[] { paramAnonymousa });
              f.a(f.this).rF(paramAnonymousa.ooz.field_msgId);
              paramAnonymousa.bUN();
              com.tencent.mm.plugin.choosemsgfile.b.b.a locala = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((m)paramAnonymousw).opg.getTag();
              if (locala.equals(paramAnonymousa)) {
                locala.T(paramAnonymousw);
              }
              AppMethodBeat.o(123329);
            }
            
            public final void eS(int paramAnonymous2Int1, int paramAnonymous2Int2)
            {
              AppMethodBeat.i(123332);
              ac.e("MicroMsg.ChooseMsgFileUIController", "item:%s onDownloadProgress offset:%d totalLen:%d", new Object[] { paramAnonymousa, Integer.valueOf(paramAnonymous2Int1), Integer.valueOf(paramAnonymous2Int2) });
              paramAnonymousa.eU(paramAnonymous2Int1, paramAnonymous2Int2);
              com.tencent.mm.plugin.choosemsgfile.b.b.a locala = (com.tencent.mm.plugin.choosemsgfile.b.b.a)((m)paramAnonymousw).opg.getTag();
              if (locala.equals(paramAnonymousa)) {
                locala.T(paramAnonymousw);
              }
              AppMethodBeat.o(123332);
            }
          }, f.this.bUU());
        }
        for (;;)
        {
          paramAnonymousa.T(paramAnonymousw);
          AppMethodBeat.o(123334);
          return;
          paramAnonymousa.bUO();
          f.a(f.this).rF(paramAnonymousa.ooz.field_msgId);
          f.a(f.this).rC(paramAnonymousa.ooz.field_msgId);
          if (f.a(f.this).bUX()) {
            ap.f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(123333);
                f.this.opG.arg.notifyChanged();
                AppMethodBeat.o(123333);
              }
            });
          }
          f.this.ops.bVa();
        }
      }
    };
    c localc = this.opG;
    AppMethodBeat.o(123344);
    return localc;
  }
  
  public final <T extends RecyclerView.i> T bUW()
  {
    AppMethodBeat.i(123345);
    if (this.opI == null)
    {
      this.opI = new GridLayoutManager(4);
      this.opI.anN = new GridLayoutManager.b()
      {
        public final int bW(int paramAnonymousInt)
        {
          AppMethodBeat.i(123335);
          if (((com.tencent.mm.plugin.choosemsgfile.b.b.a)f.this.ijj.get(paramAnonymousInt)).getType() == 0)
          {
            AppMethodBeat.o(123335);
            return 4;
          }
          AppMethodBeat.o(123335);
          return 1;
        }
      };
    }
    GridLayoutManager localGridLayoutManager = this.opI;
    AppMethodBeat.o(123345);
    return localGridLayoutManager;
  }
  
  public final void eX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(123340);
    ac.i("MicroMsg.ChooseMsgFileUIController", "onCreate");
    this.opH.alive();
    b(true, paramString1, paramString2);
    AppMethodBeat.o(123340);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(123343);
    ac.i("MicroMsg.ChooseMsgFileUIController", "onDestroy");
    this.opH.dead();
    AppMethodBeat.o(123343);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(123342);
    ac.i("MicroMsg.ChooseMsgFileUIController", "onPause");
    AppMethodBeat.o(123342);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(123341);
    ac.i("MicroMsg.ChooseMsgFileUIController", "onResume");
    this.opG.arg.notifyChanged();
    AppMethodBeat.o(123341);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.c.f
 * JD-Core Version:    0.7.0.1
 */