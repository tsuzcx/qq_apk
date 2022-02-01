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
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.k;
import androidx.recyclerview.widget.k.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelvideo.ab;
import com.tencent.mm.plugin.gallery.b.a;
import com.tencent.mm.plugin.gallery.b.b;
import com.tencent.mm.plugin.gallery.b.d;
import com.tencent.mm.plugin.gallery.b.e;
import com.tencent.mm.plugin.gallery.b.i;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;

public final class g
  extends RecyclerView.a<a>
  implements View.OnClickListener
{
  private int FRM;
  private int FRN;
  private int FRO;
  private boolean HNW;
  private ArrayList<String> HOS;
  d HPK;
  private int HPL;
  ArrayList<String> HPM;
  b HPN;
  private boolean HPO;
  private int HPP;
  private Drawable HPQ;
  k HPR;
  private int HPh;
  private Context mContext;
  private SimpleDateFormat xiR;
  
  public g(Context paramContext, ArrayList<String> paramArrayList, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(289545);
    this.HPM = new ArrayList();
    this.FRM = -1;
    this.FRN = -1;
    this.xiR = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
    this.HPR = new k(new k.a()
    {
      int ieV = -1;
      
      public final boolean Ji()
      {
        return true;
      }
      
      public final boolean Jj()
      {
        return false;
      }
      
      public final int a(RecyclerView paramAnonymousRecyclerView, RecyclerView.v paramAnonymousv)
      {
        AppMethodBeat.i(289476);
        int i = bk(51, 0);
        AppMethodBeat.o(289476);
        return i;
      }
      
      public final void a(Canvas paramAnonymousCanvas, RecyclerView paramAnonymousRecyclerView, RecyclerView.v paramAnonymousv, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(289472);
        super.a(paramAnonymousCanvas, paramAnonymousRecyclerView, paramAnonymousv, paramAnonymousFloat1 / 1.3F, paramAnonymousFloat2 / 1.3F, paramAnonymousInt, paramAnonymousBoolean);
        AppMethodBeat.o(289472);
      }
      
      public final boolean a(RecyclerView paramAnonymousRecyclerView, RecyclerView.v paramAnonymousv1, RecyclerView.v paramAnonymousv2)
      {
        AppMethodBeat.i(289454);
        int i = paramAnonymousv1.KJ();
        int j = paramAnonymousv2.KJ();
        g.this.bz(i, j);
        if (g.a(g.this) != null) {
          g.a(g.this).ja(i, j);
        }
        g.a(g.this, j);
        AppMethodBeat.o(289454);
        return false;
      }
      
      public final void b(final RecyclerView.v paramAnonymousv, final int paramAnonymousInt)
      {
        AppMethodBeat.i(289460);
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
                g.b(g.this, g.a(g.this, paramAnonymousv.KJ()));
                g.1.this.ieV = g.c(g.this);
                Log.i("MicroMsg.PreviewSelectedImageAdapter", "lastVisiblePos:%s", new Object[] { Integer.valueOf(g.1.this.ieV) });
              }
              AppMethodBeat.o(111638);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
            
            public final void onAnimationStart(Animation paramAnonymous2Animation) {}
          });
          ((g.a)paramAnonymousv).convertView.startAnimation(localAnimation);
        }
        AppMethodBeat.o(289460);
      }
      
      public final void d(RecyclerView paramAnonymousRecyclerView, RecyclerView.v paramAnonymousv)
      {
        AppMethodBeat.i(289464);
        if (paramAnonymousv != null)
        {
          super.d(paramAnonymousRecyclerView, paramAnonymousv);
          paramAnonymousRecyclerView = AnimationUtils.loadAnimation(g.b(g.this), b.a.move_scale_in);
          paramAnonymousRecyclerView.setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(111639);
              com.tencent.mm.plugin.gallery.b.h.m(g.d(g.this), g.e(g.this), g.f(g.this));
              if (g.a(g.this) != null)
              {
                if ((g.1.this.ieV > g.e(g.this)) && (g.1.this.ieV <= g.f(g.this)))
                {
                  g.a(g.this).aJ(g.e(g.this), g.f(g.this), g.1.this.ieV - 1);
                  AppMethodBeat.o(111639);
                  return;
                }
                if ((g.1.this.ieV < g.e(g.this)) && (g.1.this.ieV >= g.f(g.this)))
                {
                  g.a(g.this).aJ(g.e(g.this), g.f(g.this), g.1.this.ieV + 1);
                  AppMethodBeat.o(111639);
                  return;
                }
                if (g.e(g.this) == g.1.this.ieV)
                {
                  g.a(g.this).aJ(g.e(g.this), g.f(g.this), g.f(g.this));
                  AppMethodBeat.o(111639);
                  return;
                }
                g.a(g.this).aJ(g.e(g.this), g.f(g.this), g.1.this.ieV);
              }
              AppMethodBeat.o(111639);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
            
            public final void onAnimationStart(Animation paramAnonymous2Animation) {}
          });
          ((g.a)paramAnonymousv).convertView.startAnimation(paramAnonymousRecyclerView);
        }
        AppMethodBeat.o(289464);
      }
      
      public final float g(RecyclerView.v paramAnonymousv)
      {
        return 0.295858F;
      }
      
      public final void h(RecyclerView.v paramAnonymousv) {}
    });
    this.mContext = paramContext;
    this.HOS = paramArrayList;
    this.HPM.addAll(paramArrayList);
    this.HPL = paramInt1;
    this.HNW = paramBoolean;
    this.HPh = paramInt2;
    if (e.fAn().sfB == 15)
    {
      this.HPQ = paramContext.getResources().getDrawable(b.d.game_place_holer_divider);
      AppMethodBeat.o(289545);
      return;
    }
    this.HPQ = paramContext.getResources().getDrawable(b.d.divider);
    AppMethodBeat.o(289545);
  }
  
  private GalleryItem.MediaItem a(int paramInt, a parama)
  {
    AppMethodBeat.i(111654);
    if ((paramInt < 0) || (paramInt >= this.HPM.size()))
    {
      Log.w("MicroMsg.PreviewSelectedImageAdapter", "error position %d, imagePaths size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.HPM.size()) });
      AppMethodBeat.o(111654);
      return null;
    }
    Object localObject = (String)this.HPM.get(paramInt);
    if (this.HNW)
    {
      if (this.HPK.HLA == null) {
        break label321;
      }
      localObject = GalleryItem.MediaItem.a(0, 0L, (String)localObject, (String)localObject, "");
      paramInt = this.HPK.HLA.indexOf(localObject);
      if (paramInt >= 0)
      {
        parama.HQc = paramInt;
        parama = (GalleryItem.MediaItem)this.HPK.HLA.get(paramInt);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(111654);
      return parama;
      Iterator localIterator = e.fAs().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          parama = (GalleryItem.MediaItem)localIterator.next();
          if (parama.equals(localObject))
          {
            Log.i("MicroMsg.PreviewSelectedImageAdapter", "[getMediaItem] %s", new Object[] { parama.Gcc });
            break;
          }
        }
      }
      parama = null;
      continue;
      if (e.fAp() != null)
      {
        localObject = GalleryItem.MediaItem.a(0, 0L, (String)localObject, (String)localObject, "");
        paramInt = e.fAp().indexOf(localObject);
        if (paramInt >= 0)
        {
          parama = (GalleryItem.MediaItem)e.fAp().get(paramInt);
        }
        else
        {
          localIterator = e.fAs().iterator();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              parama = (GalleryItem.MediaItem)localIterator.next();
              if (parama.equals(localObject))
              {
                Log.i("MicroMsg.PreviewSelectedImageAdapter", "[getMediaItem] %s", new Object[] { parama.Gcc });
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
    int i = this.HPL;
    ((ViewGroup.LayoutParams)localObject).width = i;
    ((ViewGroup.LayoutParams)localObject).height = i;
    d(parama.HPW, localMediaItem.Gcc, paramInt);
    parama.convertView.setOnClickListener(this);
    label197:
    String str;
    if (2 == localMediaItem.getType())
    {
      localObject = this.mContext.getResources().getString(b.i.gallery_select_video_postion) + (paramInt + 1);
      localObject = (String)localObject + ", " + this.xiR.format(new Date(localMediaItem.HHK));
      parama.convertView.setContentDescription((CharSequence)localObject);
      if (!this.HNW) {
        break label527;
      }
      parama.convertView.setTag(Integer.valueOf(parama.HQc));
      localObject = localMediaItem.bud();
      str = localMediaItem.Gcc;
      if (localMediaItem.getType() != 2) {
        break label563;
      }
      parama.HPX.setVisibility(0);
      i = Math.round((float)((GalleryItem.VideoMediaItem)localMediaItem).oTN / 1000.0F);
      parama.HPY.setText(String.format(Locale.CHINA, "%d:%02d", new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) }));
      if ((!ab.bOG()) || (!this.HPO) || (this.HPh != 3) || (y.bEl(str) <= com.tencent.mm.plugin.gallery.b.h.aRj())) {
        break label542;
      }
      parama.HLQ.setVisibility(0);
      parama.HLR.setVisibility(0);
      parama.HLR.setText(this.mContext.getString(b.i.gallery_album_item_too_large_video_disable_tips, new Object[] { com.tencent.mm.plugin.gallery.b.h.rz(com.tencent.mm.plugin.gallery.b.h.aRj()) }));
      label365:
      if (localMediaItem.getType() == 1)
      {
        if ((!ab.bOG()) || (!this.HPO) || (this.HPh != 3) || (y.bEl(str) <= 26214400L)) {
          break label575;
        }
        parama.HLQ.setVisibility(0);
        parama.HLR.setVisibility(0);
        parama.HLR.setText(this.mContext.getString(b.i.gallery_album_item_too_large_image_disable_tips, new Object[] { com.tencent.mm.plugin.gallery.b.h.rz(26214400L) }));
      }
    }
    for (;;)
    {
      if ((!Util.isNullOrNil((String)localObject)) || (!Util.isNullOrNil(str))) {
        break label596;
      }
      Log.e("MicroMsg.PreviewSelectedImageAdapter", "null or nil filepath: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(111650);
      return;
      localObject = this.mContext.getResources().getString(b.i.gallery_select_pic_postion) + (paramInt + 1);
      break;
      label527:
      parama.convertView.setTag(localMediaItem.Gcc);
      break label197;
      label542:
      parama.HLQ.setVisibility(8);
      parama.HLR.setVisibility(8);
      break label365;
      label563:
      parama.HPX.setVisibility(8);
      break label365;
      label575:
      parama.HLQ.setVisibility(8);
      parama.HLR.setVisibility(8);
    }
    label596:
    h.a(parama.HLM, localMediaItem.getType(), (String)localObject, str, localMediaItem.HHJ, new h.a()
    {
      public final void attached()
      {
        AppMethodBeat.i(111644);
        Log.i("MicroMsg.PreviewSelectedImageAdapter", "%s %s", new Object[] { Integer.valueOf(parama.HLM.getWidth()), Integer.valueOf(parama.HLM.getHeight()) });
        AppMethodBeat.o(111644);
      }
    }, localMediaItem.HHK);
    if (((e.fAn().sfB == 3) || (e.fAn().sfB == 11)) && (localMediaItem != null) && (localMediaItem.mMimeType.equalsIgnoreCase("image/gif")))
    {
      parama.HPZ.setVisibility(0);
      if (!localMediaItem.mMimeType.equalsIgnoreCase("edit")) {
        break label728;
      }
      parama.HQa.setVisibility(0);
    }
    for (;;)
    {
      parama.HQb.setVisibility(8);
      AppMethodBeat.o(111650);
      return;
      parama.HPZ.setVisibility(8);
      break;
      label728:
      parama.HQa.setVisibility(8);
    }
  }
  
  private void d(ImageView paramImageView, String paramString, int paramInt)
  {
    AppMethodBeat.i(111651);
    if (this.HOS.contains(paramString))
    {
      paramImageView.setBackground(null);
      paramImageView.setImageDrawable(this.HPQ);
    }
    for (int i = 0;; i = 1)
    {
      paramImageView.setVisibility(0);
      if ((Util.isNullOrNil(this.HPK.getItem(this.HPP))) || (!this.HPK.getItem(this.HPP).equals(paramString))) {
        break;
      }
      paramImageView.setVisibility(0);
      if ((i == 0) || (paramInt != this.FRO)) {
        break label206;
      }
      paramImageView.setImageDrawable(this.HPQ);
      AppMethodBeat.o(111651);
      return;
      paramImageView.setBackgroundColor(-1090519041);
      paramImageView.setImageDrawable(null);
    }
    if ((!Util.isNullOrNil(this.HPK.getItem(this.HPP))) && (!this.HPK.getItem(this.HPP).equals(paramString)))
    {
      if ((paramInt != this.FRO) && (i == 0))
      {
        paramImageView.setVisibility(8);
        AppMethodBeat.o(111651);
        return;
      }
      if ((paramInt == this.FRO) && (i == 0)) {
        paramImageView.setImageDrawable(this.HPQ);
      }
    }
    label206:
    AppMethodBeat.o(111651);
  }
  
  public final void aFd(String paramString)
  {
    AppMethodBeat.i(111647);
    this.HPM.add(paramString);
    AppMethodBeat.o(111647);
  }
  
  public final int cs(String paramString)
  {
    AppMethodBeat.i(111648);
    int i = this.HPM.indexOf(paramString);
    AppMethodBeat.o(111648);
    return i;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(111652);
    int i = this.HPM.size();
    AppMethodBeat.o(111652);
    return i;
  }
  
  public final void jb(int paramInt1, int paramInt2)
  {
    this.FRO = paramInt1;
    this.HPP = paramInt2;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(111653);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/gallery/ui/PreviewSelectedImageAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if (this.HPN != null)
    {
      if (!this.HNW) {
        break label95;
      }
      this.HPN.WS(((Integer)paramView.getTag()).intValue());
    }
    for (;;)
    {
      a.a(this, "com/tencent/mm/plugin/gallery/ui/PreviewSelectedImageAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(111653);
      return;
      label95:
      this.HPN.WS(this.HPM.indexOf(paramView.getTag()));
    }
  }
  
  public final void remove(int paramInt)
  {
    AppMethodBeat.i(111649);
    this.HPM.remove(paramInt);
    AppMethodBeat.o(111649);
  }
  
  public final void wb(boolean paramBoolean)
  {
    AppMethodBeat.i(289568);
    this.HPO = paramBoolean;
    this.bZE.notifyChanged();
    AppMethodBeat.o(289568);
  }
  
  public static final class a
    extends RecyclerView.v
  {
    public ImageView HLM;
    public ImageView HLN;
    public ImageView HLQ;
    public TextView HLR;
    public ImageView HPW;
    public RelativeLayout HPX;
    public TextView HPY;
    public ImageView HPZ;
    public ImageView HQa;
    public ImageView HQb;
    public int HQc;
    public View convertView;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(111645);
      this.convertView = paramView;
      this.HPZ = ((ImageView)paramView.findViewById(b.e.gif_mask));
      this.HQa = ((ImageView)paramView.findViewById(b.e.edit_mark_iv));
      this.HQb = ((ImageView)paramView.findViewById(b.e.error_icon_iv));
      this.HPW = ((ImageView)paramView.findViewById(b.e.media_placeholder));
      this.HLM = ((ImageView)paramView.findViewById(b.e.media_thumb));
      this.HPX = ((RelativeLayout)paramView.findViewById(b.e.video_mask));
      this.HPY = ((TextView)paramView.findViewById(b.e.video_mask_tv));
      this.HLN = ((ImageView)paramView.findViewById(b.e.media_mask));
      this.HLN.setBackgroundResource(b.b.half_alpha_black);
      this.HLN.setVisibility(8);
      this.HLQ = ((ImageView)paramView.findViewById(b.e.disable_mask));
      this.HLR = ((TextView)paramView.findViewById(b.e.disable_mask_tv));
      AppMethodBeat.o(111645);
    }
  }
  
  public static abstract interface b
  {
    public abstract void WS(int paramInt);
    
    public abstract void aJ(int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void ja(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.g
 * JD-Core Version:    0.7.0.1
 */