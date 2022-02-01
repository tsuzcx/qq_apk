package com.tencent.mm.plugin.collect.model;

import android.app.Dialog;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.wb;
import com.tencent.mm.autogen.a.wb.a;
import com.tencent.mm.autogen.a.wb.b;
import com.tencent.mm.plugin.collect.reward.a.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.etz;
import com.tencent.mm.protocal.protobuf.eub;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.model.r;
import com.tencent.mm.wallet_core.model.r.a;
import com.tencent.mm.wallet_core.ui.l;
import java.lang.ref.WeakReference;

public class ScanMaterialCodeListener
  extends IListener<wb>
{
  private Dialog pIQ;
  
  public ScanMaterialCodeListener()
  {
    super(f.hfK);
    AppMethodBeat.i(160790);
    this.__eventId = wb.class.getName().hashCode();
    AppMethodBeat.o(160790);
  }
  
  private boolean a(final wb paramwb)
  {
    AppMethodBeat.i(63856);
    Log.i("MicroMsg.ScanMaterialCodeListener", "scan material code type: %s", new Object[] { Integer.valueOf(paramwb.hZI.type) });
    if ((paramwb.hZI.contextRef == null) || (paramwb.hZI.contextRef.get() == null))
    {
      Log.i("MicroMsg.ScanMaterialCodeListener", "context has destroyed");
      paramwb.hZI.callback.run();
      AppMethodBeat.o(63856);
      return false;
    }
    final Context localContext = (Context)paramwb.hZI.contextRef.get();
    Object localObject;
    if (paramwb.hZI.type == 0)
    {
      this.pIQ = l.a(localContext, false, null);
      localObject = new j(paramwb.hZI.hZK, paramwb.hZI.scene);
      com.tencent.mm.kernel.h.aZW().a(1800, new com.tencent.mm.am.h()
      {
        public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, p paramAnonymousp)
        {
          AppMethodBeat.i(63852);
          if ((ScanMaterialCodeListener.a(ScanMaterialCodeListener.this) != null) && (ScanMaterialCodeListener.a(ScanMaterialCodeListener.this).isShowing()))
          {
            ScanMaterialCodeListener.a(ScanMaterialCodeListener.this).dismiss();
            ScanMaterialCodeListener.b(ScanMaterialCodeListener.this);
          }
          com.tencent.mm.kernel.h.aZW().b(1800, this);
          paramAnonymousString = (j)paramAnonymousp;
          paramAnonymousString.a(new r.a() {}).b(new r.a()
          {
            public final void c(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, p paramAnonymous2p)
            {
              AppMethodBeat.i(63851);
              ScanMaterialCodeListener.1.this.wZh.hZJ.errMsg = paramAnonymousString.wYE.wYI;
              if (Util.isNullOrNil(ScanMaterialCodeListener.1.this.wZh.hZJ.errMsg)) {
                ScanMaterialCodeListener.1.this.wZh.hZJ.errMsg = ScanMaterialCodeListener.1.this.val$context.getString(a.i.wallet_unknown_err);
              }
              AppMethodBeat.o(63851);
            }
          }).c(new r.a()
          {
            public final void c(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, p paramAnonymous2p)
            {
              AppMethodBeat.i(63850);
              ScanMaterialCodeListener.1.this.wZh.hZJ.errMsg = paramAnonymous2String;
              if (Util.isNullOrNil(ScanMaterialCodeListener.1.this.wZh.hZJ.errMsg)) {
                ScanMaterialCodeListener.1.this.wZh.hZJ.errMsg = ScanMaterialCodeListener.1.this.val$context.getString(a.i.wallet_unknown_err);
              }
              AppMethodBeat.o(63850);
            }
          });
          paramwb.hZI.callback.run();
          AppMethodBeat.o(63852);
        }
      });
      com.tencent.mm.kernel.h.aZW().a((p)localObject, 0);
    }
    for (;;)
    {
      AppMethodBeat.o(63856);
      return false;
      if (paramwb.hZI.type == 1)
      {
        this.pIQ = l.a(localContext, false, null);
        localObject = new c(paramwb.hZI.hZK, paramwb.hZI.scene);
        com.tencent.mm.kernel.h.aZW().a(2811, new com.tencent.mm.am.h()
        {
          public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, p paramAnonymousp)
          {
            AppMethodBeat.i(63855);
            if ((ScanMaterialCodeListener.a(ScanMaterialCodeListener.this) != null) && (ScanMaterialCodeListener.a(ScanMaterialCodeListener.this).isShowing()))
            {
              ScanMaterialCodeListener.a(ScanMaterialCodeListener.this).dismiss();
              ScanMaterialCodeListener.b(ScanMaterialCodeListener.this);
            }
            com.tencent.mm.kernel.h.aZW().b(2811, this);
            paramAnonymousString = (c)paramAnonymousp;
            paramAnonymousString.a(new r.a() {}).b(new r.a()
            {
              public final void c(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, p paramAnonymous2p)
              {
                AppMethodBeat.i(63854);
                ScanMaterialCodeListener.2.this.wZh.hZJ.errMsg = paramAnonymousString.wZU.wYI;
                if (Util.isNullOrNil(ScanMaterialCodeListener.2.this.wZh.hZJ.errMsg)) {
                  ScanMaterialCodeListener.2.this.wZh.hZJ.errMsg = ScanMaterialCodeListener.2.this.val$context.getString(a.i.wallet_unknown_err);
                }
                AppMethodBeat.o(63854);
              }
            }).c(new r.a()
            {
              public final void c(int paramAnonymous2Int1, int paramAnonymous2Int2, String paramAnonymous2String, p paramAnonymous2p)
              {
                AppMethodBeat.i(63853);
                ScanMaterialCodeListener.2.this.wZh.hZJ.errMsg = paramAnonymous2String;
                if (Util.isNullOrNil(ScanMaterialCodeListener.2.this.wZh.hZJ.errMsg)) {
                  ScanMaterialCodeListener.2.this.wZh.hZJ.errMsg = ScanMaterialCodeListener.2.this.val$context.getString(a.i.wallet_unknown_err);
                }
                AppMethodBeat.o(63853);
              }
            });
            paramwb.hZI.callback.run();
            AppMethodBeat.o(63855);
          }
        });
        com.tencent.mm.kernel.h.aZW().a((p)localObject, 0);
      }
      else
      {
        Log.w("MicroMsg.ScanMaterialCodeListener", "unknown type: %d", new Object[] { Integer.valueOf(paramwb.hZI.type) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.ScanMaterialCodeListener
 * JD-Core Version:    0.7.0.1
 */