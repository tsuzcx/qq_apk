package com.tencent.mm.plugin.ball.a;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.c.j.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.b;
import com.tencent.mm.ui.base.b.b;
import com.tencent.mm.ui.p.a;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;

public class e
  implements f
{
  private WeakReference<Activity> vjr;
  
  public e(Activity paramActivity)
  {
    AppMethodBeat.i(288307);
    this.vjr = new WeakReference(paramActivity);
    AppMethodBeat.o(288307);
  }
  
  public final void S(Activity paramActivity)
  {
    AppMethodBeat.i(288309);
    this.vjr = new WeakReference(paramActivity);
    AppMethodBeat.o(288309);
  }
  
  public void a(f.a parama)
  {
    AppMethodBeat.i(127522);
    parama = getActivity();
    if ((parama instanceof MMActivity)) {
      ((MMActivity)parama).getSwipeBackLayout();
    }
    AppMethodBeat.o(127522);
  }
  
  public void a(final f.b paramb)
  {
    AppMethodBeat.i(127524);
    Log.i("MicroMsg.FloatBallPageAdapter", "convertToTranslucent");
    final AtomicInteger localAtomicInteger = new AtomicInteger(0);
    b.a(getActivity(), new b.b()
    {
      public final void onComplete(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(288321);
        if ((!paramAnonymousBoolean) && (localAtomicInteger.getAndIncrement() <= 0))
        {
          b.a(e.this.getActivity(), new b.b()
          {
            public final void onComplete(boolean paramAnonymous2Boolean)
            {
              AppMethodBeat.i(288315);
              if (e.1.this.vjt != null) {
                e.1.this.vjt.onComplete(paramAnonymous2Boolean);
              }
              AppMethodBeat.o(288315);
            }
          });
          AppMethodBeat.o(288321);
          return;
        }
        if (paramb != null) {
          paramb.onComplete(paramAnonymousBoolean);
        }
        AppMethodBeat.o(288321);
      }
    });
    Log.i("MicroMsg.FloatBallPageAdapter", "float ball page convertActivityToTranslucent");
    AppMethodBeat.o(127524);
  }
  
  public boolean bhU()
  {
    AppMethodBeat.i(127521);
    if (((getActivity() instanceof MMActivity)) && (((MMActivity)getActivity()).getSwipeBackLayout() != null))
    {
      AppMethodBeat.o(127521);
      return true;
    }
    AppMethodBeat.o(127521);
    return false;
  }
  
  public ViewGroup cXB()
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
  
  public int cXC()
  {
    return -1;
  }
  
  public boolean cor()
  {
    return true;
  }
  
  public Activity getActivity()
  {
    AppMethodBeat.i(288312);
    if (this.vjr.get() == null)
    {
      AppMethodBeat.o(288312);
      return null;
    }
    Activity localActivity = (Activity)this.vjr.get();
    AppMethodBeat.o(288312);
    return localActivity;
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
    Object localObject = getActivity();
    if (((localObject instanceof MMActivity)) && (((MMActivity)localObject).getSwipeBackLayout() != null))
    {
      localObject = ((MMActivity)localObject).getSwipeBackLayout().getTargetContentView();
      AppMethodBeat.o(127518);
      return localObject;
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
    Object localObject = getActivity();
    if ((localObject instanceof MMActivity))
    {
      localObject = ((MMActivity)localObject).getBodyView();
      AppMethodBeat.o(127519);
      return localObject;
    }
    AppMethodBeat.o(127519);
    return null;
  }
  
  public void iR(boolean paramBoolean)
  {
    AppMethodBeat.i(127523);
    Log.i("MicroMsg.FloatBallPageAdapter", "finish, withAnimation:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (getIntent() != null)
    {
      if (!paramBoolean) {
        break label80;
      }
      getIntent().putExtra("MMActivity.OverrideExitAnimation", j.a.pop_out);
      getIntent().putExtra("MMActivity.OverrideEnterAnimation", j.a.anim_not_change);
    }
    for (;;)
    {
      if (getActivity() != null) {
        getActivity().finish();
      }
      AppMethodBeat.o(127523);
      return;
      label80:
      getIntent().putExtra("MMActivity.OverrideExitAnimation", 0);
      getIntent().putExtra("MMActivity.OverrideEnterAnimation", 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.a.e
 * JD-Core Version:    0.7.0.1
 */