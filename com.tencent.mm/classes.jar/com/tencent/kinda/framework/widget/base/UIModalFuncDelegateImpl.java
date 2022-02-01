package com.tencent.kinda.framework.widget.base;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.e;
import androidx.fragment.app.i;
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
    AppMethodBeat.i(264287);
    this.weakFragment = new WeakReference(paramMMFragment);
    AppMethodBeat.o(264287);
  }
  
  public void fragmentShow(boolean paramBoolean)
  {
    AppMethodBeat.i(264290);
    MMFragment localMMFragment = (MMFragment)this.weakFragment.get();
    if (localMMFragment == null)
    {
      Log.i("MicroMsg.kinda.UIModalFuncDelegateImpl", "activity == null.");
      AppMethodBeat.o(264290);
      return;
    }
    if (paramBoolean)
    {
      Log.i("MicroMsg.kinda.UIModalFuncDelegateImpl", "show fragment.");
      localMMFragment.getActivity().getSupportFragmentManager().beginTransaction().c(localMMFragment).ip();
      AppMethodBeat.o(264290);
      return;
    }
    Log.i("MicroMsg.kinda.UIModalFuncDelegateImpl", "hide fragment.");
    localMMFragment.getActivity().getSupportFragmentManager().beginTransaction().b(localMMFragment).ip();
    AppMethodBeat.o(264290);
  }
  
  public void genSnapshotImpl(boolean paramBoolean, final VoidCallback paramVoidCallback)
  {
    AppMethodBeat.i(264289);
    Object localObject = (MMFragment)this.weakFragment.get();
    if (localObject == null)
    {
      Log.i("MicroMsg.kinda.UIModalFuncDelegateImpl", "activity == null.");
      AppMethodBeat.o(264289);
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
          AppMethodBeat.i(264262);
          paramVoidCallback.call();
          AppMethodBeat.o(264262);
        }
      });
      AppMethodBeat.o(264289);
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
        AppMethodBeat.i(263513);
        paramVoidCallback.call();
        AppMethodBeat.o(263513);
      }
    });
    AppMethodBeat.o(264289);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.UIModalFuncDelegateImpl
 * JD-Core Version:    0.7.0.1
 */