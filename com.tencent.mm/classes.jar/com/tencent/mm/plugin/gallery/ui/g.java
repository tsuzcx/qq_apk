package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.support.v7.widget.a.a.a;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.o;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;

public final class g
  extends RecyclerView.a<a>
  implements View.OnClickListener
{
  private Context mContext;
  private int sOt;
  private int sOu;
  private int sOv;
  private boolean tYm;
  d tZW;
  private int tZX;
  ArrayList<String> tZY;
  b tZZ;
  private ArrayList<String> tZh;
  private int uaa;
  private Drawable uab;
  android.support.v7.widget.a.a uac;
  
  public g(Context paramContext, ArrayList<String> paramArrayList, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(111646);
    this.tZY = new ArrayList();
    this.sOt = -1;
    this.sOu = -1;
    this.uac = new android.support.v7.widget.a.a(new a.a()
    {
      int dMM = -1;
      
      public final float K(RecyclerView.w paramAnonymousw)
      {
        return 0.295858F;
      }
      
      public final void L(RecyclerView.w paramAnonymousw) {}
      
      public final int a(RecyclerView paramAnonymousRecyclerView, RecyclerView.w paramAnonymousw)
      {
        AppMethodBeat.i(179475);
        int i = dh(51);
        AppMethodBeat.o(179475);
        return i;
      }
      
      public final void a(Canvas paramAnonymousCanvas, RecyclerView paramAnonymousRecyclerView, RecyclerView.w paramAnonymousw, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(111643);
        super.a(paramAnonymousCanvas, paramAnonymousRecyclerView, paramAnonymousw, paramAnonymousFloat1 / 1.3F, paramAnonymousFloat2 / 1.3F, paramAnonymousInt, paramAnonymousBoolean);
        AppMethodBeat.o(111643);
      }
      
      public final boolean a(RecyclerView paramAnonymousRecyclerView, RecyclerView.w paramAnonymousw1, RecyclerView.w paramAnonymousw2)
      {
        AppMethodBeat.i(164810);
        int i = paramAnonymousw1.lN();
        int j = paramAnonymousw2.lN();
        g.this.aq(i, j);
        if (g.a(g.this) != null) {
          g.a(g.this).gj(i, j);
        }
        g.a(g.this, j);
        AppMethodBeat.o(164810);
        return false;
      }
      
      public final void d(RecyclerView paramAnonymousRecyclerView, RecyclerView.w paramAnonymousw)
      {
        AppMethodBeat.i(111642);
        if (paramAnonymousw != null)
        {
          super.d(paramAnonymousRecyclerView, paramAnonymousw);
          paramAnonymousRecyclerView = AnimationUtils.loadAnimation(g.b(g.this), 2130772077);
          paramAnonymousRecyclerView.setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(111639);
              com.tencent.mm.plugin.gallery.a.d.swap(g.d(g.this), g.e(g.this), g.f(g.this));
              if (g.a(g.this) != null)
              {
                if ((g.1.this.dMM > g.e(g.this)) && (g.1.this.dMM <= g.f(g.this)))
                {
                  g.a(g.this).af(g.e(g.this), g.f(g.this), g.1.this.dMM - 1);
                  AppMethodBeat.o(111639);
                  return;
                }
                if ((g.1.this.dMM < g.e(g.this)) && (g.1.this.dMM >= g.f(g.this)))
                {
                  g.a(g.this).af(g.e(g.this), g.f(g.this), g.1.this.dMM + 1);
                  AppMethodBeat.o(111639);
                  return;
                }
                if (g.e(g.this) == g.1.this.dMM)
                {
                  g.a(g.this).af(g.e(g.this), g.f(g.this), g.f(g.this));
                  AppMethodBeat.o(111639);
                  return;
                }
                g.a(g.this).af(g.e(g.this), g.f(g.this), g.1.this.dMM);
              }
              AppMethodBeat.o(111639);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
            
            public final void onAnimationStart(Animation paramAnonymous2Animation) {}
          });
          ((g.a)paramAnonymousw).uan.startAnimation(paramAnonymousRecyclerView);
        }
        AppMethodBeat.o(111642);
      }
      
      public final void f(final RecyclerView.w paramAnonymousw, final int paramAnonymousInt)
      {
        AppMethodBeat.i(111641);
        super.f(paramAnonymousw, paramAnonymousInt);
        if (paramAnonymousw != null)
        {
          Animation localAnimation = AnimationUtils.loadAnimation(g.b(g.this), 2130772078);
          localAnimation.setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(111638);
              if (paramAnonymousInt == 2)
              {
                g.b(g.this, g.a(g.this, paramAnonymousw.lN()));
                g.1.this.dMM = g.c(g.this);
                ae.i("MicroMsg.PreviewSelectedImageAdapter", "lastVisiblePos:%s", new Object[] { Integer.valueOf(g.1.this.dMM) });
              }
              AppMethodBeat.o(111638);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
            
            public final void onAnimationStart(Animation paramAnonymous2Animation) {}
          });
          ((g.a)paramAnonymousw).uan.startAnimation(localAnimation);
        }
        AppMethodBeat.o(111641);
      }
      
      public final boolean no()
      {
        return true;
      }
      
      public final boolean np()
      {
        return false;
      }
    });
    this.mContext = paramContext;
    this.tZh = paramArrayList;
    this.tZY.addAll(paramArrayList);
    this.tZX = paramInt;
    this.tYm = paramBoolean;
    if (e.cXr().kXg == 15)
    {
      this.uab = paramContext.getResources().getDrawable(2131232558);
      AppMethodBeat.o(111646);
      return;
    }
    this.uab = paramContext.getResources().getDrawable(2131231942);
    AppMethodBeat.o(111646);
  }
  
  private GalleryItem.MediaItem a(int paramInt, a parama)
  {
    AppMethodBeat.i(111654);
    if ((paramInt < 0) || (paramInt >= this.tZY.size()))
    {
      ae.w("MicroMsg.PreviewSelectedImageAdapter", "error position %d, imagePaths size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.tZY.size()) });
      AppMethodBeat.o(111654);
      return null;
    }
    Object localObject = (String)this.tZY.get(paramInt);
    if (this.tYm)
    {
      if (this.tZW.tWe == null) {
        break label321;
      }
      localObject = GalleryItem.MediaItem.a(0, 0L, (String)localObject, (String)localObject, "");
      paramInt = this.tZW.tWe.indexOf(localObject);
      if (paramInt >= 0)
      {
        parama.uao = paramInt;
        parama = (GalleryItem.MediaItem)this.tZW.tWe.get(paramInt);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(111654);
      return parama;
      Iterator localIterator = e.cXw().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          parama = (GalleryItem.MediaItem)localIterator.next();
          if (parama.equals(localObject))
          {
            ae.i("MicroMsg.PreviewSelectedImageAdapter", "[getMediaItem] %s", new Object[] { parama.tRJ });
            break;
          }
        }
      }
      parama = null;
      continue;
      if (e.cXt() != null)
      {
        localObject = GalleryItem.MediaItem.a(0, 0L, (String)localObject, (String)localObject, "");
        paramInt = e.cXt().indexOf(localObject);
        if (paramInt >= 0)
        {
          parama = (GalleryItem.MediaItem)e.cXt().get(paramInt);
        }
        else
        {
          localIterator = e.cXw().iterator();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              parama = (GalleryItem.MediaItem)localIterator.next();
              if (parama.equals(localObject))
              {
                ae.i("MicroMsg.PreviewSelectedImageAdapter", "[getMediaItem] %s", new Object[] { parama.tRJ });
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
      ae.e("MicroMsg.PreviewSelectedImageAdapter", "get item failed");
      AppMethodBeat.o(111650);
      return;
    }
    Object localObject = parama.uan.getLayoutParams();
    int i = this.tZX;
    ((ViewGroup.LayoutParams)localObject).width = i;
    ((ViewGroup.LayoutParams)localObject).height = i;
    c(parama.uah, localMediaItem.tRJ, paramInt);
    parama.uan.setOnClickListener(this);
    if (this.tYm)
    {
      parama.uan.setTag(Integer.valueOf(parama.uao));
      if (localMediaItem.getType() != 2) {
        break label241;
      }
      parama.uai.setVisibility(0);
      i = Math.round((float)((GalleryItem.VideoMediaItem)localMediaItem).ipL / 1000.0F);
      parama.uaj.setText(String.format(Locale.CHINA, "%d:%02d", new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) }));
    }
    String str;
    for (;;)
    {
      localObject = localMediaItem.axP();
      str = localMediaItem.tRJ;
      if ((!bu.isNullOrNil((String)localObject)) || (!bu.isNullOrNil(str))) {
        break label253;
      }
      ae.e("MicroMsg.PreviewSelectedImageAdapter", "null or nil filepath: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(111650);
      return;
      parama.uan.setTag(localMediaItem.tRJ);
      break;
      label241:
      parama.uai.setVisibility(8);
    }
    label253:
    h.a(parama.tMY, localMediaItem.getType(), (String)localObject, str, localMediaItem.tRM, new h.a()
    {
      public final void cYU()
      {
        AppMethodBeat.i(111644);
        ae.i("MicroMsg.PreviewSelectedImageAdapter", "%s %s", new Object[] { Integer.valueOf(parama.tMY.getWidth()), Integer.valueOf(parama.tMY.getHeight()) });
        AppMethodBeat.o(111644);
      }
    }, localMediaItem.tRN);
    if (((e.cXr().kXg == 3) || (e.cXr().kXg == 11)) && (localMediaItem != null) && (localMediaItem.mMimeType.equalsIgnoreCase("image/gif")))
    {
      parama.uak.setVisibility(0);
      if (!localMediaItem.mMimeType.equalsIgnoreCase("edit")) {
        break label385;
      }
      parama.ual.setVisibility(0);
    }
    for (;;)
    {
      parama.uam.setVisibility(8);
      AppMethodBeat.o(111650);
      return;
      parama.uak.setVisibility(8);
      break;
      label385:
      parama.ual.setVisibility(8);
    }
  }
  
  private void c(ImageView paramImageView, String paramString, int paramInt)
  {
    AppMethodBeat.i(111651);
    if (this.tZh.contains(paramString))
    {
      paramImageView.setBackground(null);
      paramImageView.setImageDrawable(this.uab);
    }
    for (int i = 0;; i = 1)
    {
      paramImageView.setVisibility(0);
      if ((bu.isNullOrNil(this.tZW.getItem(this.uaa))) || (!this.tZW.getItem(this.uaa).equals(paramString))) {
        break;
      }
      paramImageView.setVisibility(0);
      if ((i == 0) || (paramInt != this.sOv)) {
        break label206;
      }
      paramImageView.setImageDrawable(this.uab);
      AppMethodBeat.o(111651);
      return;
      paramImageView.setBackgroundColor(-1090519041);
      paramImageView.setImageDrawable(null);
    }
    if ((!bu.isNullOrNil(this.tZW.getItem(this.uaa))) && (!this.tZW.getItem(this.uaa).equals(paramString)))
    {
      if ((paramInt != this.sOv) && (i == 0))
      {
        paramImageView.setVisibility(8);
        AppMethodBeat.o(111651);
        return;
      }
      if ((paramInt == this.sOv) && (i == 0)) {
        paramImageView.setImageDrawable(this.uab);
      }
    }
    label206:
    AppMethodBeat.o(111651);
  }
  
  public final void amb(String paramString)
  {
    AppMethodBeat.i(111647);
    this.tZY.add(paramString);
    AppMethodBeat.o(111647);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(111652);
    int i = this.tZY.size();
    AppMethodBeat.o(111652);
    return i;
  }
  
  public final void gk(int paramInt1, int paramInt2)
  {
    this.sOv = paramInt1;
    this.uaa = paramInt2;
  }
  
  public final int indexOf(String paramString)
  {
    AppMethodBeat.i(111648);
    int i = this.tZY.indexOf(paramString);
    AppMethodBeat.o(111648);
    return i;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(111653);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/PreviewSelectedImageAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    if (this.tZZ != null)
    {
      if (!this.tYm) {
        break label95;
      }
      this.tZZ.HS(((Integer)paramView.getTag()).intValue());
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/PreviewSelectedImageAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(111653);
      return;
      label95:
      this.tZZ.HS(this.tZY.indexOf(paramView.getTag()));
    }
  }
  
  public final void remove(int paramInt)
  {
    AppMethodBeat.i(111649);
    this.tZY.remove(paramInt);
    AppMethodBeat.o(111649);
  }
  
  public static final class a
    extends RecyclerView.w
  {
    public ImageView tMY;
    public ImageView tWp;
    public ImageView uah;
    public RelativeLayout uai;
    public TextView uaj;
    public ImageView uak;
    public ImageView ual;
    public ImageView uam;
    public View uan;
    public int uao;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(111645);
      this.uan = paramView;
      this.uak = ((ImageView)paramView.findViewById(2131300586));
      this.ual = ((ImageView)paramView.findViewById(2131299258));
      this.uam = ((ImageView)paramView.findViewById(2131299519));
      this.uah = ((ImageView)paramView.findViewById(2131302216));
      this.tMY = ((ImageView)paramView.findViewById(2131302221));
      this.uai = ((RelativeLayout)paramView.findViewById(2131306355));
      this.uaj = ((TextView)paramView.findViewById(2131306357));
      this.tWp = ((ImageView)paramView.findViewById(2131302212));
      this.tWp.setBackgroundResource(2131100482);
      this.tWp.setVisibility(8);
      AppMethodBeat.o(111645);
    }
  }
  
  public static abstract interface b
  {
    public abstract void HS(int paramInt);
    
    public abstract void af(int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void gj(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.g
 * JD-Core Version:    0.7.0.1
 */