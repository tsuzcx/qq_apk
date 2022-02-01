package com.tencent.kinda.framework.widget.base;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.r;
import com.tencent.kinda.framework.R.id;
import com.tencent.kinda.gen.IUIModalPlatformFuncDelegate;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragment;
import java.lang.ref.WeakReference;

public class UIModalFuncDelegateImpl
  implements IUIModalPlatformFuncDelegate
{
  private static final String TAG = "MicroMsg.kinda.UIModalFuncDelegateImpl";
  public WeakReference<MMFragment> weakFragment;
  
  public UIModalFuncDelegateImpl(MMFragment paramMMFragment)
  {
    AppMethodBeat.i(226461);
    this.weakFragment = new WeakReference(paramMMFragment);
    AppMethodBeat.o(226461);
  }
  
  public void fragmentShow(boolean paramBoolean)
  {
    AppMethodBeat.i(226471);
    MMFragment localMMFragment = (MMFragment)this.weakFragment.get();
    if (localMMFragment == null)
    {
      Log.i("MicroMsg.kinda.UIModalFuncDelegateImpl", "activity == null.");
      AppMethodBeat.o(226471);
      return;
    }
    if (paramBoolean)
    {
      Log.i("MicroMsg.kinda.UIModalFuncDelegateImpl", "show fragment.");
      localMMFragment.getActivity().getSupportFragmentManager().beginTransaction().c(localMMFragment).FX();
      AppMethodBeat.o(226471);
      return;
    }
    Log.i("MicroMsg.kinda.UIModalFuncDelegateImpl", "hide fragment.");
    localMMFragment.getActivity().getSupportFragmentManager().beginTransaction().b(localMMFragment).FX();
    AppMethodBeat.o(226471);
  }
  
  public void genSnapshotImpl(boolean paramBoolean, final VoidCallback paramVoidCallback)
  {
    AppMethodBeat.i(226467);
    Object localObject = (MMFragment)this.weakFragment.get();
    if (localObject == null)
    {
      Log.i("MicroMsg.kinda.UIModalFuncDelegateImpl", "activity == null.");
      AppMethodBeat.o(226467);
      return;
    }
    if (!paramBoolean)
    {
      Log.i("MicroMsg.kinda.UIModalFuncDelegateImpl", "hide snapshot.");
      localView = ((MMFragment)localObject).findViewById(R.id.container);
      localObject = (ImageView)((MMFragment)localObject).findViewById(R.id.snapshot_view);
      localView.setVisibility(0);
      ((ImageView)localObject).setVisibility(4);
      ((ImageView)localObject).post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(226631);
          paramVoidCallback.call();
          AppMethodBeat.o(226631);
        }
      });
      AppMethodBeat.o(226467);
      return;
    }
    Log.i("MicroMsg.kinda.UIModalFuncDelegateImpl", "show snapshot.");
    View localView = ((MMFragment)localObject).findViewById(R.id.container);
    localObject = (ImageView)((MMFragment)localObject).findViewById(R.id.snapshot_view);
    Bitmap localBitmap = Bitmap.createBitmap(localView.getWidth(), localView.getHeight(), Bitmap.Config.ARGB_8888);
    localView.draw(new Canvas(localBitmap));
    ((ImageView)localObject).setImageBitmap(localBitmap);
    ((ImageView)localObject).setVisibility(0);
    localView.setVisibility(4);
    localView.post(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(226632);
        paramVoidCallback.call();
        AppMethodBeat.o(226632);
      }
    });
    AppMethodBeat.o(226467);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.UIModalFuncDelegateImpl
 * JD-Core Version:    0.7.0.1
 */