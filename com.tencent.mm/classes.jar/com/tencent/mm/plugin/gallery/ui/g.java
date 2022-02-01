package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.l;
import androidx.recyclerview.widget.l.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.gallery.b.a;
import com.tencent.mm.plugin.gallery.b.b;
import com.tencent.mm.plugin.gallery.b.d;
import com.tencent.mm.plugin.gallery.b.e;
import com.tencent.mm.plugin.gallery.b.i;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;

public final class g
  extends RecyclerView.a<a>
  implements View.OnClickListener
{
  private int Ask;
  private int Asl;
  private int Asm;
  private boolean CbU;
  private ArrayList<String> CcP;
  d CdG;
  private int CdH;
  ArrayList<String> CdI;
  b CdJ;
  private int CdK;
  private Drawable CdL;
  l CdM;
  private Context mContext;
  
  public g(Context paramContext, ArrayList<String> paramArrayList, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(111646);
    this.CdI = new ArrayList();
    this.Ask = -1;
    this.Asl = -1;
    this.CdM = new l(new l.a()
    {
      int fYT = -1;
      
      public final int a(RecyclerView paramAnonymousRecyclerView, RecyclerView.v paramAnonymousv)
      {
        AppMethodBeat.i(244486);
        int i = cA(51);
        AppMethodBeat.o(244486);
        return i;
      }
      
      public final void a(Canvas paramAnonymousCanvas, RecyclerView paramAnonymousRecyclerView, RecyclerView.v paramAnonymousv, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(244485);
        super.a(paramAnonymousCanvas, paramAnonymousRecyclerView, paramAnonymousv, paramAnonymousFloat1 / 1.3F, paramAnonymousFloat2 / 1.3F, paramAnonymousInt, paramAnonymousBoolean);
        AppMethodBeat.o(244485);
      }
      
      public final boolean a(RecyclerView paramAnonymousRecyclerView, RecyclerView.v paramAnonymousv1, RecyclerView.v paramAnonymousv2)
      {
        AppMethodBeat.i(244480);
        int i = paramAnonymousv1.md();
        int j = paramAnonymousv2.md();
        g.this.aF(i, j);
        if (g.a(g.this) != null) {
          g.a(g.this).hA(i, j);
        }
        g.a(g.this, j);
        AppMethodBeat.o(244480);
        return false;
      }
      
      public final void b(final RecyclerView.v paramAnonymousv, final int paramAnonymousInt)
      {
        AppMethodBeat.i(244481);
        super.b(paramAnonymousv, paramAnonymousInt);
        if (paramAnonymousv != null)
        {
          Animation localAnimation = AnimationUtils.loadAnimation(g.b(g.this), b.a.move_scale_out);
          localAnimation.setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(111638);
              if (paramAnonymousInt == 2)
              {
                g.b(g.this, g.a(g.this, paramAnonymousv.md()));
                g.1.this.fYT = g.c(g.this);
                Log.i("MicroMsg.PreviewSelectedImageAdapter", "lastVisiblePos:%s", new Object[] { Integer.valueOf(g.1.this.fYT) });
              }
              AppMethodBeat.o(111638);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
            
            public final void onAnimationStart(Animation paramAnonymous2Animation) {}
          });
          ((g.a)paramAnonymousv).convertView.startAnimation(localAnimation);
        }
        AppMethodBeat.o(244481);
      }
      
      public final void d(RecyclerView paramAnonymousRecyclerView, RecyclerView.v paramAnonymousv)
      {
        AppMethodBeat.i(244482);
        if (paramAnonymousv != null)
        {
          super.d(paramAnonymousRecyclerView, paramAnonymousv);
          paramAnonymousRecyclerView = AnimationUtils.loadAnimation(g.b(g.this), b.a.move_scale_in);
          paramAnonymousRecyclerView.setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(111639);
              com.tencent.mm.plugin.gallery.a.e.e(g.d(g.this), g.e(g.this), g.f(g.this));
              if (g.a(g.this) != null)
              {
                if ((g.1.this.fYT > g.e(g.this)) && (g.1.this.fYT <= g.f(g.this)))
                {
                  g.a(g.this).an(g.e(g.this), g.f(g.this), g.1.this.fYT - 1);
                  AppMethodBeat.o(111639);
                  return;
                }
                if ((g.1.this.fYT < g.e(g.this)) && (g.1.this.fYT >= g.f(g.this)))
                {
                  g.a(g.this).an(g.e(g.this), g.f(g.this), g.1.this.fYT + 1);
                  AppMethodBeat.o(111639);
                  return;
                }
                if (g.e(g.this) == g.1.this.fYT)
                {
                  g.a(g.this).an(g.e(g.this), g.f(g.this), g.f(g.this));
                  AppMethodBeat.o(111639);
                  return;
                }
                g.a(g.this).an(g.e(g.this), g.f(g.this), g.1.this.fYT);
              }
              AppMethodBeat.o(111639);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
            
            public final void onAnimationStart(Animation paramAnonymous2Animation) {}
          });
          ((g.a)paramAnonymousv).convertView.startAnimation(paramAnonymousRecyclerView);
        }
        AppMethodBeat.o(244482);
      }
      
      public final float f(RecyclerView.v paramAnonymousv)
      {
        return 0.295858F;
      }
      
      public final void g(RecyclerView.v paramAnonymousv) {}
      
      public final boolean kA()
      {
        return false;
      }
      
      public final boolean kz()
      {
        return true;
      }
    });
    this.mContext = paramContext;
    this.CcP = paramArrayList;
    this.CdI.addAll(paramArrayList);
    this.CdH = paramInt;
    this.CbU = paramBoolean;
    if (com.tencent.mm.plugin.gallery.model.e.etl().pag == 15)
    {
      this.CdL = paramContext.getResources().getDrawable(b.d.game_place_holer_divider);
      AppMethodBeat.o(111646);
      return;
    }
    this.CdL = paramContext.getResources().getDrawable(b.d.divider);
    AppMethodBeat.o(111646);
  }
  
  private GalleryItem.MediaItem a(int paramInt, a parama)
  {
    AppMethodBeat.i(111654);
    if ((paramInt < 0) || (paramInt >= this.CdI.size()))
    {
      Log.w("MicroMsg.PreviewSelectedImageAdapter", "error position %d, imagePaths size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.CdI.size()) });
      AppMethodBeat.o(111654);
      return null;
    }
    Object localObject = (String)this.CdI.get(paramInt);
    if (this.CbU)
    {
      if (this.CdG.BZG == null) {
        break label321;
      }
      localObject = GalleryItem.MediaItem.a(0, 0L, (String)localObject, (String)localObject, "");
      paramInt = this.CdG.BZG.indexOf(localObject);
      if (paramInt >= 0)
      {
        parama.CdX = paramInt;
        parama = (GalleryItem.MediaItem)this.CdG.BZG.get(paramInt);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(111654);
      return parama;
      Iterator localIterator = com.tencent.mm.plugin.gallery.model.e.etq().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          parama = (GalleryItem.MediaItem)localIterator.next();
          if (parama.equals(localObject))
          {
            Log.i("MicroMsg.PreviewSelectedImageAdapter", "[getMediaItem] %s", new Object[] { parama.AAz });
            break;
          }
        }
      }
      parama = null;
      continue;
      if (com.tencent.mm.plugin.gallery.model.e.etn() != null)
      {
        localObject = GalleryItem.MediaItem.a(0, 0L, (String)localObject, (String)localObject, "");
        paramInt = com.tencent.mm.plugin.gallery.model.e.etn().indexOf(localObject);
        if (paramInt >= 0)
        {
          parama = (GalleryItem.MediaItem)com.tencent.mm.plugin.gallery.model.e.etn().get(paramInt);
        }
        else
        {
          localIterator = com.tencent.mm.plugin.gallery.model.e.etq().iterator();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              parama = (GalleryItem.MediaItem)localIterator.next();
              if (parama.equals(localObject))
              {
                Log.i("MicroMsg.PreviewSelectedImageAdapter", "[getMediaItem] %s", new Object[] { parama.AAz });
                break;
              }
            }
          }
          parama = null;
        }
      }
      else
      {
        parama = GalleryItem.MediaItem.a(1, 0L, (String)localObject, (String)localObject, "");
        continue;
        label321:
        parama = null;
      }
    }
  }
  
  private void a(final a parama, int paramInt)
  {
    AppMethodBeat.i(111650);
    GalleryItem.MediaItem localMediaItem = a(paramInt, parama);
    if (localMediaItem == null)
    {
      Log.e("MicroMsg.PreviewSelectedImageAdapter", "get item failed");
      AppMethodBeat.o(111650);
      return;
    }
    Object localObject = parama.convertView.getLayoutParams();
    int i = this.CdH;
    ((ViewGroup.LayoutParams)localObject).width = i;
    ((ViewGroup.LayoutParams)localObject).height = i;
    d(parama.CdR, localMediaItem.AAz, paramInt);
    parama.convertView.setOnClickListener(this);
    if (2 == localMediaItem.getType())
    {
      localObject = this.mContext.getResources().getString(b.i.gallery_select_video_postion) + (paramInt + 1);
      parama.convertView.setContentDescription((CharSequence)localObject);
      if (!this.CbU) {
        break label315;
      }
      parama.convertView.setTag(Integer.valueOf(parama.CdX));
      label152:
      if (localMediaItem.getType() != 2) {
        break label330;
      }
      parama.CdS.setVisibility(0);
      i = Math.round((float)((GalleryItem.VideoMediaItem)localMediaItem).maT / 1000.0F);
      parama.CdT.setText(String.format(Locale.CHINA, "%d:%02d", new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) }));
    }
    String str;
    for (;;)
    {
      localObject = localMediaItem.aZe();
      str = localMediaItem.AAz;
      if ((!Util.isNullOrNil((String)localObject)) || (!Util.isNullOrNil(str))) {
        break label342;
      }
      Log.e("MicroMsg.PreviewSelectedImageAdapter", "null or nil filepath: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(111650);
      return;
      localObject = this.mContext.getResources().getString(b.i.gallery_select_pic_postion) + (paramInt + 1);
      break;
      label315:
      parama.convertView.setTag(localMediaItem.AAz);
      break label152;
      label330:
      parama.CdS.setVisibility(8);
    }
    label342:
    h.a(parama.BPW, localMediaItem.getType(), (String)localObject, str, localMediaItem.BVl, new h.a()
    {
      public final void euT()
      {
        AppMethodBeat.i(111644);
        Log.i("MicroMsg.PreviewSelectedImageAdapter", "%s %s", new Object[] { Integer.valueOf(parama.BPW.getWidth()), Integer.valueOf(parama.BPW.getHeight()) });
        AppMethodBeat.o(111644);
      }
    }, localMediaItem.BVm);
    if (((com.tencent.mm.plugin.gallery.model.e.etl().pag == 3) || (com.tencent.mm.plugin.gallery.model.e.etl().pag == 11)) && (localMediaItem != null) && (localMediaItem.mMimeType.equalsIgnoreCase("image/gif")))
    {
      parama.CdU.setVisibility(0);
      if (!localMediaItem.mMimeType.equalsIgnoreCase("edit")) {
        break label474;
      }
      parama.CdV.setVisibility(0);
    }
    for (;;)
    {
      parama.CdW.setVisibility(8);
      AppMethodBeat.o(111650);
      return;
      parama.CdU.setVisibility(8);
      break;
      label474:
      parama.CdV.setVisibility(8);
    }
  }
  
  private void d(ImageView paramImageView, String paramString, int paramInt)
  {
    AppMethodBeat.i(111651);
    if (this.CcP.contains(paramString))
    {
      paramImageView.setBackground(null);
      paramImageView.setImageDrawable(this.CdL);
    }
    for (int i = 0;; i = 1)
    {
      paramImageView.setVisibility(0);
      if ((Util.isNullOrNil(this.CdG.getItem(this.CdK))) || (!this.CdG.getItem(this.CdK).equals(paramString))) {
        break;
      }
      paramImageView.setVisibility(0);
      if ((i == 0) || (paramInt != this.Asm)) {
        break label206;
      }
      paramImageView.setImageDrawable(this.CdL);
      AppMethodBeat.o(111651);
      return;
      paramImageView.setBackgroundColor(-1090519041);
      paramImageView.setImageDrawable(null);
    }
    if ((!Util.isNullOrNil(this.CdG.getItem(this.CdK))) && (!this.CdG.getItem(this.CdK).equals(paramString)))
    {
      if ((paramInt != this.Asm) && (i == 0))
      {
        paramImageView.setVisibility(8);
        AppMethodBeat.o(111651);
        return;
      }
      if ((paramInt == this.Asm) && (i == 0)) {
        paramImageView.setImageDrawable(this.CdL);
      }
    }
    label206:
    AppMethodBeat.o(111651);
  }
  
  public final void aIE(String paramString)
  {
    AppMethodBeat.i(111647);
    this.CdI.add(paramString);
    AppMethodBeat.o(111647);
  }
  
  public final int bf(String paramString)
  {
    AppMethodBeat.i(111648);
    int i = this.CdI.indexOf(paramString);
    AppMethodBeat.o(111648);
    return i;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(111652);
    int i = this.CdI.size();
    AppMethodBeat.o(111652);
    return i;
  }
  
  public final void hB(int paramInt1, int paramInt2)
  {
    this.Asm = paramInt1;
    this.CdK = paramInt2;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(111653);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/plugin/gallery/ui/PreviewSelectedImageAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    if (this.CdJ != null)
    {
      if (!this.CbU) {
        break label95;
      }
      this.CdJ.Tk(((Integer)paramView.getTag()).intValue());
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/gallery/ui/PreviewSelectedImageAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(111653);
      return;
      label95:
      this.CdJ.Tk(this.CdI.indexOf(paramView.getTag()));
    }
  }
  
  public final void remove(int paramInt)
  {
    AppMethodBeat.i(111649);
    this.CdI.remove(paramInt);
    AppMethodBeat.o(111649);
  }
  
  public static final class a
    extends RecyclerView.v
  {
    public ImageView BPW;
    public ImageView BZR;
    public ImageView CdR;
    public RelativeLayout CdS;
    public TextView CdT;
    public ImageView CdU;
    public ImageView CdV;
    public ImageView CdW;
    public int CdX;
    public View convertView;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(111645);
      this.convertView = paramView;
      this.CdU = ((ImageView)paramView.findViewById(b.e.gif_mask));
      this.CdV = ((ImageView)paramView.findViewById(b.e.edit_mark_iv));
      this.CdW = ((ImageView)paramView.findViewById(b.e.error_icon_iv));
      this.CdR = ((ImageView)paramView.findViewById(b.e.media_placeholder));
      this.BPW = ((ImageView)paramView.findViewById(b.e.media_thumb));
      this.CdS = ((RelativeLayout)paramView.findViewById(b.e.video_mask));
      this.CdT = ((TextView)paramView.findViewById(b.e.video_mask_tv));
      this.BZR = ((ImageView)paramView.findViewById(b.e.media_mask));
      this.BZR.setBackgroundResource(b.b.half_alpha_black);
      this.BZR.setVisibility(8);
      AppMethodBeat.o(111645);
    }
  }
  
  public static abstract interface b
  {
    public abstract void Tk(int paramInt);
    
    public abstract void an(int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void hA(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.g
 * JD-Core Version:    0.7.0.1
 */