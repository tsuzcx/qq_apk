package com.tencent.mm.plugin.ball.a;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.base.b.a;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.SwipeBackLayout.b;

public class e
  implements f
{
  private final Activity activity;
  
  public e(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  public void a(final f.a parama)
  {
    AppMethodBeat.i(127522);
    if (((this.activity instanceof MMActivity)) && (((MMActivity)this.activity).getSwipeBackLayout() != null)) {
      ((MMActivity)this.activity).getSwipeBackLayout().setSwipeBackListener(new SwipeBackLayout.b()
      {
        public final void aQ(float paramAnonymousFloat)
        {
          AppMethodBeat.i(127512);
          if (parama != null) {
            parama.aR(paramAnonymousFloat);
          }
          AppMethodBeat.o(127512);
        }
        
        public final int bq(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(127514);
          if (parama != null)
          {
            int i = parama.iJ(paramAnonymousBoolean);
            AppMethodBeat.o(127514);
            return i;
          }
          AppMethodBeat.o(127514);
          return 1;
        }
        
        public final void k(MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(127513);
          if (parama != null) {
            parama.k(paramAnonymousMotionEvent);
          }
          AppMethodBeat.o(127513);
        }
      });
    }
    AppMethodBeat.o(127522);
  }
  
  public void a(final f.b paramb)
  {
    AppMethodBeat.i(127524);
    ae.i("MicroMsg.FloatBallPageAdapter", "convertToTranslucent");
    b.a(this.activity, new b.a()
    {
      public final void iI(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(127515);
        if (paramb != null) {
          paramb.iI(paramAnonymousBoolean);
        }
        AppMethodBeat.o(127515);
      }
    });
    ae.i("MicroMsg.FloatBallPageAdapter", "float ball page convertActivityToTranslucent");
    AppMethodBeat.o(127524);
  }
  
  public ViewGroup bKN()
  {
    AppMethodBeat.i(127517);
    ViewGroup localViewGroup = (ViewGroup)this.activity.getWindow().getDecorView();
    AppMethodBeat.o(127517);
    return localViewGroup;
  }
  
  public int bKO()
  {
    return -1;
  }
  
  public boolean bhh()
  {
    AppMethodBeat.i(127521);
    if (((this.activity instanceof MMActivity)) && (((MMActivity)this.activity).getSwipeBackLayout() != null))
    {
      AppMethodBeat.o(127521);
      return true;
    }
    AppMethodBeat.o(127521);
    return false;
  }
  
  public boolean bhu()
  {
    return true;
  }
  
  public void ge(boolean paramBoolean)
  {
    AppMethodBeat.i(127523);
    ae.i("MicroMsg.FloatBallPageAdapter", "finish, withAnimation:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (getIntent() != null)
    {
      if (!paramBoolean) {
        break label71;
      }
      getIntent().putExtra("MMActivity.OverrideExitAnimation", 2130772100);
      getIntent().putExtra("MMActivity.OverrideEnterAnimation", 2130771986);
    }
    for (;;)
    {
      this.activity.finish();
      AppMethodBeat.o(127523);
      return;
      label71:
      getIntent().putExtra("MMActivity.OverrideExitAnimation", 0);
      getIntent().putExtra("MMActivity.OverrideEnterAnimation", 0);
    }
  }
  
  public Activity getActivity()
  {
    return this.activity;
  }
  
  public Bitmap getBitmap()
  {
    AppMethodBeat.i(127520);
    Bitmap localBitmap = h.ga(getMaskView());
    AppMethodBeat.o(127520);
    return localBitmap;
  }
  
  public View getContentView()
  {
    AppMethodBeat.i(127518);
    if (((this.activity instanceof MMActivity)) && (((MMActivity)this.activity).getSwipeBackLayout() != null))
    {
      View localView = ((MMActivity)this.activity).getSwipeBackLayout().getTargetContentView();
      AppMethodBeat.o(127518);
      return localView;
    }
    AppMethodBeat.o(127518);
    return null;
  }
  
  public Intent getIntent()
  {
    AppMethodBeat.i(127516);
    Intent localIntent = this.activity.getIntent();
    AppMethodBeat.o(127516);
    return localIntent;
  }
  
  public View getMaskView()
  {
    AppMethodBeat.i(127519);
    if ((this.activity instanceof MMActivity))
    {
      View localView = ((MMActivity)this.activity).getBodyView();
      AppMethodBeat.o(127519);
      return localView;
    }
    AppMethodBeat.o(127519);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.a.e
 * JD-Core Version:    0.7.0.1
 */