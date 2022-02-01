package com.tencent.mm.openim.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.KeyEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.api.j;
import com.tencent.mm.openim.e.l;
import com.tencent.mm.openim.model.IOpenIMKefuConfirmController;
import com.tencent.mm.openim.ui.dialog.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.y;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/ui/OpenIMKefuConfirmDialogUIModelImpl;", "Lcom/tencent/mm/openim/ui/OpenIMKefuConfirmBaseUIModel;", "context", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "mDialog", "Lcom/tencent/mm/openim/ui/dialog/OpenIMKefuConfirmDialog;", "onConfirmDialogOpListener", "Lcom/tencent/mm/openim/ui/OpenIMKefuConfirmUIModel$OnConfirmDialogOpListener;", "onConfirm", "", "onConfirmCancel", "onConfirmOpFailed", "onConfirmOpSuccess", "onCreate", "confirmController", "Lcom/tencent/mm/openim/model/IOpenIMKefuConfirmController;", "release", "setOnDismissListenerWrapper", "dismissListener", "Lcom/tencent/mm/picker/listener/OnDismissListener;", "showConfirmUI", "confirmType", "", "confirmPageType", "confirmData", "Lcom/tencent/mm/openim/api/OpenIMKefuGetContactResult;", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends b
{
  public static final c.a ptZ;
  private e.b pua;
  private a pub;
  
  static
  {
    AppMethodBeat.i(235957);
    ptZ = new c.a((byte)0);
    AppMethodBeat.o(235957);
  }
  
  public c(Activity paramActivity)
  {
    super(paramActivity);
    AppMethodBeat.i(235903);
    AppMethodBeat.o(235903);
  }
  
  private static final void a(DialogInterface paramDialogInterface) {}
  
  private static final void a(c paramc)
  {
    AppMethodBeat.i(235940);
    s.u(paramc, "this$0");
    paramc.bSn();
    AppMethodBeat.o(235940);
  }
  
  private static final void a(c paramc, Object paramObject)
  {
    AppMethodBeat.i(235920);
    s.u(paramc, "this$0");
    paramc.bSt();
    AppMethodBeat.o(235920);
  }
  
  private final void a(com.tencent.mm.picker.d.b paramb)
  {
    AppMethodBeat.i(235912);
    a locala = this.pub;
    if (locala != null) {
      locala.setOnDismissListener(new c..ExternalSyntheticLambda0(paramb));
    }
    AppMethodBeat.o(235912);
  }
  
  private static final void a(com.tencent.mm.picker.d.b paramb, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(235944);
    s.u(paramb, "$dismissListener");
    paramb.onDismiss(paramDialogInterface);
    AppMethodBeat.o(235944);
  }
  
  private static final boolean a(c paramc, DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(235925);
    s.u(paramc, "this$0");
    if (paramInt == 4)
    {
      paramc.a(new c..ExternalSyntheticLambda5(paramc));
      if (paramDialogInterface != null) {
        paramDialogInterface.dismiss();
      }
      AppMethodBeat.o(235925);
      return true;
    }
    AppMethodBeat.o(235925);
    return false;
  }
  
  private static final void b(c paramc, Object paramObject)
  {
    AppMethodBeat.i(235936);
    s.u(paramc, "this$0");
    paramc.bSt();
    AppMethodBeat.o(235936);
  }
  
  private static final void c(c paramc, Object paramObject)
  {
    AppMethodBeat.i(235943);
    s.u(paramc, "this$0");
    paramc.bSu();
    AppMethodBeat.o(235943);
  }
  
  public final void a(final int paramInt1, int paramInt2, j paramj)
  {
    AppMethodBeat.i(236003);
    s.u(paramj, "confirmData");
    super.a(paramInt1, paramInt2, paramj);
    this.pua = ((e.b)new b(this, paramInt1));
    a locala = new a((Context)getContext());
    locala.ptY = paramj;
    locala.setOnKeyListener(new c..ExternalSyntheticLambda1(this));
    locala.setOnShowListener(c..ExternalSyntheticLambda2.INSTANCE);
    a(new c..ExternalSyntheticLambda3(this));
    locala.puC = this.pua;
    locala.setCanceledOnTouchOutside(false);
    paramj = ah.aiuX;
    this.pub = locala;
    paramj = this.pub;
    if (paramj != null) {
      paramj.show();
    }
    AppMethodBeat.o(236003);
  }
  
  public final void a(IOpenIMKefuConfirmController paramIOpenIMKefuConfirmController)
  {
    AppMethodBeat.i(235999);
    s.u(paramIOpenIMKefuConfirmController, "confirmController");
    super.a(paramIOpenIMKefuConfirmController);
    if ((getContext() instanceof MMActivity))
    {
      paramIOpenIMKefuConfirmController = getContext();
      if (paramIOpenIMKefuConfirmController == null)
      {
        paramIOpenIMKefuConfirmController = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(235999);
        throw paramIOpenIMKefuConfirmController;
      }
      paramIOpenIMKefuConfirmController = ((MMActivity)paramIOpenIMKefuConfirmController).getController();
      Activity localActivity = getContext();
      s.checkNotNull(localActivity);
      paramIOpenIMKefuConfirmController.setStatusBarColor(bb.gy(localActivity.getResources().getColor(com.tencent.mm.plugin.comm.c.b.white), 0));
    }
    AppMethodBeat.o(235999);
  }
  
  public final void bSn()
  {
    AppMethodBeat.i(236009);
    com.tencent.threadpool.h.ahAA.o(new c..ExternalSyntheticLambda6(this), 500L);
    AppMethodBeat.o(236009);
  }
  
  public final void bSs()
  {
    AppMethodBeat.i(236006);
    super.bSs();
    AppMethodBeat.o(236006);
  }
  
  public final void bSu()
  {
    int i = 1;
    AppMethodBeat.i(236013);
    Object localObject = this.ptX;
    if ((localObject != null) && (((IOpenIMKefuConfirmController)localObject).bSh() == true)) {}
    for (;;)
    {
      if (i != 0)
      {
        a(new c..ExternalSyntheticLambda4(this));
        localObject = this.pub;
        if (localObject != null) {
          ((a)localObject).dismiss();
        }
      }
      AppMethodBeat.o(236013);
      return;
      i = 0;
    }
  }
  
  public final void bSv()
  {
    int i = 1;
    AppMethodBeat.i(236018);
    IOpenIMKefuConfirmController localIOpenIMKefuConfirmController = this.ptX;
    if ((localIOpenIMKefuConfirmController != null) && (localIOpenIMKefuConfirmController.bSg() == true)) {}
    for (;;)
    {
      if (i != 0) {
        super.bSv();
      }
      AppMethodBeat.o(236018);
      return;
      i = 0;
    }
  }
  
  public final void release()
  {
    int i = 1;
    AppMethodBeat.i(236025);
    super.release();
    Object localObject = this.pub;
    if ((localObject != null) && (((a)localObject).isShowing() == true)) {}
    for (;;)
    {
      if (i != 0)
      {
        localObject = this.pub;
        if (localObject != null) {
          ((a)localObject).xM(0);
        }
      }
      localObject = this.pub;
      if (localObject != null)
      {
        localObject = ((a)localObject).puB;
        if (localObject != null) {
          ((PluginOpenIM)com.tencent.mm.kernel.h.az(PluginOpenIM.class)).getWordingInfoStg().remove((MStorage.IOnStorageChange)localObject);
        }
      }
      AppMethodBeat.o(236025);
      return;
      i = 0;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/openim/ui/OpenIMKefuConfirmDialogUIModelImpl$showConfirmUI$1", "Lcom/tencent/mm/openim/ui/OpenIMKefuConfirmUIModel$OnConfirmDialogOpListener;", "onClose", "", "exitType", "", "onConfirmClick", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements e.b
  {
    b(c paramc, int paramInt) {}
    
    private static final void d(c paramc, Object paramObject)
    {
      AppMethodBeat.i(235906);
      s.u(paramc, "this$0");
      paramc.bSt();
      AppMethodBeat.o(235906);
    }
    
    public final void bSw()
    {
      AppMethodBeat.i(235922);
      Log.i("MicroMsg.OpenIMKefuConfirmDialogUIModelImpl", "alvinluo showConfirmDialog onConfirmClick");
      IOpenIMKefuConfirmController localIOpenIMKefuConfirmController = this.puc.ptX;
      if (localIOpenIMKefuConfirmController != null) {
        localIOpenIMKefuConfirmController.xH(paramInt1);
      }
      AppMethodBeat.o(235922);
    }
    
    public final void xL(int paramInt)
    {
      AppMethodBeat.i(235914);
      Log.i("MicroMsg.OpenIMKefuConfirmDialogUIModelImpl", s.X("alvinluo showConfirmDialog onClose exitType: ", Integer.valueOf(paramInt)));
      c.a(this.puc, new c.b..ExternalSyntheticLambda0(this.puc));
      a locala = c.b(this.puc);
      if (locala != null) {
        locala.dismiss();
      }
      AppMethodBeat.o(235914);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.openim.ui.c
 * JD-Core Version:    0.7.0.1
 */