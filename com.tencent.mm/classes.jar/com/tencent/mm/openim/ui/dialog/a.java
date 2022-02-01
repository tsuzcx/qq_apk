package com.tencent.mm.openim.ui.dialog;

import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import androidx.appcompat.app.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.openim.api.j;
import com.tencent.mm.openim.ui.e.b;
import com.tencent.mm.openim.ui.view.BaseDialogView;
import com.tencent.mm.openim.ui.view.BaseDialogView.c;
import com.tencent.mm.openim.ui.view.BaseDialogView.d;
import com.tencent.mm.plugin.comm.c.i;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/ui/dialog/OpenIMKefuConfirmDialog;", "Landroidx/appcompat/app/AppCompatDialog;", "Lcom/tencent/mm/openim/ui/view/BaseDialogModel;", "activity", "Landroid/content/Context;", "(Landroid/content/Context;)V", "confirmData", "Lcom/tencent/mm/openim/api/OpenIMKefuGetContactResult;", "mDialogView", "Lcom/tencent/mm/openim/ui/dialog/OpenIMKefuConfirmDialogView;", "opListener", "Lcom/tencent/mm/openim/ui/OpenIMKefuConfirmUIModel$OnConfirmDialogOpListener;", "createDialogView", "dismiss", "", "dismissDialog", "exitType", "", "initContentView", "isShowingDialog", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "realShow", "release", "setConfirmData", "setConfirmDialogOpListener", "show", "showDialog", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends e
  implements com.tencent.mm.openim.ui.view.a
{
  public static final a.a puz;
  public j ptY;
  private final Context puA;
  public OpenIMKefuConfirmDialogView puB;
  public e.b puC;
  
  static
  {
    AppMethodBeat.i(236016);
    puz = new a.a((byte)0);
    AppMethodBeat.o(236016);
  }
  
  public a(Context paramContext)
  {
    super(paramContext, c.i.OpenIMKefuConfirmDialog);
    this.puA = paramContext;
  }
  
  private static final void a(a parama, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(236012);
    s.u(parama, "this$0");
    parama = parama.puB;
    if (parama != null) {
      parama.show();
    }
    AppMethodBeat.o(236012);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(236045);
    if (isShowing())
    {
      OpenIMKefuConfirmDialogView localOpenIMKefuConfirmDialogView = this.puB;
      if (localOpenIMKefuConfirmDialogView != null)
      {
        float f = localOpenIMKefuConfirmDialogView.getMaxTranslationY();
        localOpenIMKefuConfirmDialogView.isAnimating = true;
        localOpenIMKefuConfirmDialogView.fhR = false;
        View localView = localOpenIMKefuConfirmDialogView.puV;
        Object localObject = localView;
        if (localView == null)
        {
          s.bIx("dialogContainer");
          localObject = null;
        }
        localObject = ((View)localObject).animate();
        if (localObject != null)
        {
          localObject = ((ViewPropertyAnimator)localObject).translationY(f);
          if (localObject != null)
          {
            localObject = ((ViewPropertyAnimator)localObject).setDuration(300L);
            if (localObject != null)
            {
              localObject = ((ViewPropertyAnimator)localObject).setInterpolator((TimeInterpolator)new AccelerateInterpolator());
              if (localObject != null)
              {
                localObject = ((ViewPropertyAnimator)localObject).setListener((Animator.AnimatorListener)new BaseDialogView.c(localOpenIMKefuConfirmDialogView));
                if (localObject != null)
                {
                  localObject = ((ViewPropertyAnimator)localObject).setUpdateListener((ValueAnimator.AnimatorUpdateListener)new BaseDialogView.d(localOpenIMKefuConfirmDialogView));
                  if (localObject != null) {
                    ((ViewPropertyAnimator)localObject).start();
                  }
                }
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(236045);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(236033);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.OpenIMKefuConfirmDialog", "alvinluo OpenIMKefuConfirmDialog onCreate");
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.setLayout(-1, -2);
    }
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.addFlags(67108864);
    }
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.setDimAmount(0.5F);
    }
    paramBundle = getWindow();
    if (paramBundle != null) {
      paramBundle.setWindowAnimations(c.i.BottomToTopSlowAnimation);
    }
    paramBundle = getWindow();
    View localView;
    if (paramBundle != null)
    {
      localView = paramBundle.getDecorView();
      if (localView != null)
      {
        paramBundle = localView.getContext();
        if (paramBundle != null) {
          break label315;
        }
        paramBundle = (Bundle)localObject1;
        if (paramBundle != null) {
          break label354;
        }
      }
    }
    label315:
    label354:
    for (int i = com.tencent.mm.cd.a.ms(localView.getContext());; i = paramBundle.intValue())
    {
      localView.setMinimumWidth(i);
      localView.setPadding(0, 0, 0, 0);
      paramBundle = getWindow();
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getAttributes();
        if (paramBundle != null)
        {
          paramBundle.width = -1;
          paramBundle.height = -2;
          paramBundle.gravity = 80;
        }
      }
      localObject1 = this.puA;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        paramBundle = getContext();
        s.s(paramBundle, "context");
      }
      this.puB = new OpenIMKefuConfirmDialogView(paramBundle);
      paramBundle = this.puB;
      if (paramBundle != null)
      {
        localObject1 = (com.tencent.mm.openim.ui.view.a)this;
        s.u(localObject1, "dialogModel");
        paramBundle.puT = ((com.tencent.mm.openim.ui.view.a)localObject1);
      }
      paramBundle = this.puB;
      if (paramBundle != null) {
        paramBundle.setConfirmData(this.ptY);
      }
      paramBundle = this.puB;
      if (paramBundle != null) {
        paramBundle.setOnConfirmDialogOpListener(this.puC);
      }
      paramBundle = this.puB;
      s.checkNotNull(paramBundle);
      setContentView((View)paramBundle, new ViewGroup.LayoutParams(-1, -1));
      setOnShowListener(new a..ExternalSyntheticLambda0(this));
      AppMethodBeat.o(236033);
      return;
      Object localObject2 = paramBundle.getResources();
      paramBundle = (Bundle)localObject1;
      if (localObject2 == null) {
        break;
      }
      localObject2 = ((Resources)localObject2).getDisplayMetrics();
      paramBundle = (Bundle)localObject1;
      if (localObject2 == null) {
        break;
      }
      paramBundle = Integer.valueOf(((DisplayMetrics)localObject2).widthPixels);
      break;
    }
  }
  
  public final void show()
  {
    AppMethodBeat.i(236039);
    try
    {
      if (((getContext() instanceof Activity)) && (((Activity)getContext()).isFinishing()))
      {
        Log.w("MicroMsg.OpenIMKefuConfirmDialog", "realShowDialog ui is finishing and ignore");
        AppMethodBeat.o(236039);
        return;
      }
      super.show();
      AppMethodBeat.o(236039);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.OpenIMKefuConfirmDialog", (Throwable)localException, "realShowDialog exception", new Object[0]);
      AppMethodBeat.o(236039);
    }
  }
  
  public final void xM(int paramInt)
  {
    AppMethodBeat.i(236050);
    Log.v("MicroMsg.OpenIMKefuConfirmDialog", s.X("dismissDialog exitType: ", Integer.valueOf(paramInt)));
    try
    {
      if (isShowing())
      {
        super.dismiss();
        AppMethodBeat.o(236050);
        return;
      }
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(236050);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.openim.ui.dialog.a
 * JD-Core Version:    0.7.0.1
 */