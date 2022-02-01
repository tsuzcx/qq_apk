package com.tencent.mm.plugin.ball.a;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.base.b.b;
import com.tencent.mm.ui.n.a;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import java.util.concurrent.atomic.AtomicInteger;

public class e
  implements f
{
  public Activity activity;
  
  public e(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  public void a(f.a parama)
  {
    AppMethodBeat.i(127522);
    if ((this.activity instanceof MMActivity)) {
      ((MMActivity)this.activity).getSwipeBackLayout();
    }
    AppMethodBeat.o(127522);
  }
  
  public void a(final f.b paramb)
  {
    AppMethodBeat.i(127524);
    Log.i("MicroMsg.FloatBallPageAdapter", "convertToTranslucent");
    final AtomicInteger localAtomicInteger = new AtomicInteger(0);
    b.a(this.activity, new b.b()
    {
      public final void ei(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(188573);
        if ((!paramAnonymousBoolean) && (localAtomicInteger.getAndIncrement() <= 0))
        {
          b.a(e.this.activity, new b.b()
          {
            public final void ei(boolean paramAnonymous2Boolean)
            {
              AppMethodBeat.i(188572);
              if (e.1.this.oWd != null) {
                e.1.this.oWd.ei(paramAnonymous2Boolean);
              }
              AppMethodBeat.o(188572);
            }
          });
          AppMethodBeat.o(188573);
          return;
        }
        if (paramb != null) {
          paramb.ei(paramAnonymousBoolean);
        }
        AppMethodBeat.o(188573);
      }
    });
    Log.i("MicroMsg.FloatBallPageAdapter", "float ball page convertActivityToTranslucent");
    AppMethodBeat.o(127524);
  }
  
  public boolean aGg()
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
  
  public boolean bCI()
  {
    return true;
  }
  
  public ViewGroup chG()
  {
    AppMethodBeat.i(127517);
    Object localObject = getActivity();
    if (localObject == null)
    {
      AppMethodBeat.o(127517);
      return null;
    }
    localObject = (ViewGroup)((Activity)localObject).getWindow().getDecorView();
    AppMethodBeat.o(127517);
    return localObject;
  }
  
  public int chH()
  {
    return -1;
  }
  
  public Activity getActivity()
  {
    return this.activity;
  }
  
  public Bitmap getBitmap()
  {
    AppMethodBeat.i(127520);
    Bitmap localBitmap = a.a(getMaskView(), Bitmap.Config.ARGB_8888);
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
    Object localObject = getActivity();
    if (localObject == null)
    {
      AppMethodBeat.o(127516);
      return null;
    }
    localObject = ((Activity)localObject).getIntent();
    AppMethodBeat.o(127516);
    return localObject;
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
  
  public void hb(boolean paramBoolean)
  {
    AppMethodBeat.i(127523);
    Log.i("MicroMsg.FloatBallPageAdapter", "finish, withAnimation:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (getIntent() != null)
    {
      if (!paramBoolean) {
        break label78;
      }
      getIntent().putExtra("MMActivity.OverrideExitAnimation", 2130772124);
      getIntent().putExtra("MMActivity.OverrideEnterAnimation", 2130771986);
    }
    for (;;)
    {
      if (getActivity() != null) {
        getActivity().finish();
      }
      AppMethodBeat.o(127523);
      return;
      label78:
      getIntent().putExtra("MMActivity.OverrideExitAnimation", 0);
      getIntent().putExtra("MMActivity.OverrideEnterAnimation", 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.a.e
 * JD-Core Version:    0.7.0.1
 */