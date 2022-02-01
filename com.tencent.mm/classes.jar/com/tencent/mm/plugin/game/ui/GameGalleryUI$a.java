package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.a.c.h;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.MMActivity;

final class GameGalleryUI$a
  extends android.support.v4.view.q
{
  Context mContext;
  private String[] xSQ;
  private View[] xSR;
  
  public GameGalleryUI$a(Context paramContext, String[] paramArrayOfString)
  {
    AppMethodBeat.i(42148);
    this.xSQ = new String[0];
    this.mContext = paramContext;
    if (paramArrayOfString != null) {
      this.xSQ = paramArrayOfString;
    }
    this.xSR = new View[this.xSQ.length];
    AppMethodBeat.o(42148);
  }
  
  public final void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    AppMethodBeat.i(42150);
    paramViewGroup.removeView((View)paramObject);
    AppMethodBeat.o(42150);
  }
  
  public final int getCount()
  {
    return this.xSQ.length;
  }
  
  public final Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(42149);
    Object localObject2 = this.xSR[paramInt];
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = View.inflate(this.mContext, 2131494874, null);
      this.xSR[paramInt] = localObject1;
      localObject2 = (ImageView)((View)localObject1).findViewById(2131301976);
      final ProgressBar localProgressBar = (ProgressBar)((View)localObject1).findViewById(2131301978);
      localProgressBar.setVisibility(0);
      com.tencent.mm.av.a.a locala = com.tencent.mm.av.q.bcV();
      String str = this.xSQ[paramInt];
      c.a locala1 = new c.a();
      locala1.jbe = true;
      locala.a(str, (ImageView)localObject2, locala1.bdv(), new h()
      {
        public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.av.a.d.b paramAnonymousb)
        {
          return null;
        }
        
        public final void b(String paramAnonymousString, View paramAnonymousView) {}
        
        public final void b(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.av.a.d.b paramAnonymousb)
        {
          AppMethodBeat.i(42146);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(42145);
              GameGalleryUI.a.1.this.xSS.setVisibility(8);
              AppMethodBeat.o(42145);
            }
          });
          AppMethodBeat.o(42146);
        }
      });
    }
    paramViewGroup.addView((View)localObject1);
    ((View)localObject1).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(42147);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameGalleryUI$ImageAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        ((MMActivity)GameGalleryUI.a.this.mContext).finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameGalleryUI$ImageAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(42147);
      }
    });
    AppMethodBeat.o(42149);
    return localObject1;
  }
  
  public final boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameGalleryUI.a
 * JD-Core Version:    0.7.0.1
 */