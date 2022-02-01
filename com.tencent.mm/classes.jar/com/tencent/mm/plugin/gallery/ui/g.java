package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.support.v7.widget.a.a;
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
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.VideoMediaItem;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;

public final class g
  extends RecyclerView.a<a>
  implements View.OnClickListener
{
  private Context mContext;
  private int qMZ;
  private int qNa;
  private int qNb;
  private ArrayList<String> rJX;
  private boolean rJc;
  d rKM;
  private int rKN;
  ArrayList<String> rKO;
  b rKP;
  private int rKQ;
  private Drawable rKR;
  a rKS;
  
  public g(Context paramContext, ArrayList<String> paramArrayList, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(111646);
    this.rKO = new ArrayList();
    this.qMZ = -1;
    this.qNa = -1;
    this.rKS = new a(new a.a()
    {
      int dBx = -1;
      
      public final float K(RecyclerView.v paramAnonymousv)
      {
        return 0.295858F;
      }
      
      public final void L(RecyclerView.v paramAnonymousv) {}
      
      public final int a(RecyclerView paramAnonymousRecyclerView, RecyclerView.v paramAnonymousv)
      {
        AppMethodBeat.i(179475);
        int i = di(51);
        AppMethodBeat.o(179475);
        return i;
      }
      
      public final void a(Canvas paramAnonymousCanvas, RecyclerView paramAnonymousRecyclerView, RecyclerView.v paramAnonymousv, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(111643);
        super.a(paramAnonymousCanvas, paramAnonymousRecyclerView, paramAnonymousv, paramAnonymousFloat1 / 1.3F, paramAnonymousFloat2 / 1.3F, paramAnonymousInt, paramAnonymousBoolean);
        AppMethodBeat.o(111643);
      }
      
      public final boolean a(RecyclerView paramAnonymousRecyclerView, RecyclerView.v paramAnonymousv1, RecyclerView.v paramAnonymousv2)
      {
        AppMethodBeat.i(164810);
        int i = paramAnonymousv1.ln();
        int j = paramAnonymousv2.ln();
        g.this.ap(i, j);
        if (g.a(g.this) != null) {
          g.a(g.this).fM(i, j);
        }
        g.a(g.this, j);
        AppMethodBeat.o(164810);
        return false;
      }
      
      public final void d(RecyclerView paramAnonymousRecyclerView, RecyclerView.v paramAnonymousv)
      {
        AppMethodBeat.i(111642);
        if (paramAnonymousv != null)
        {
          super.d(paramAnonymousRecyclerView, paramAnonymousv);
          paramAnonymousRecyclerView = AnimationUtils.loadAnimation(g.b(g.this), 2130772077);
          paramAnonymousRecyclerView.setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(111639);
              com.tencent.mm.plugin.gallery.a.d.swap(g.d(g.this), g.e(g.this), g.f(g.this));
              if (g.a(g.this) != null)
              {
                if ((g.1.this.dBx > g.e(g.this)) && (g.1.this.dBx <= g.f(g.this)))
                {
                  g.a(g.this).ae(g.e(g.this), g.f(g.this), g.1.this.dBx - 1);
                  AppMethodBeat.o(111639);
                  return;
                }
                if ((g.1.this.dBx < g.e(g.this)) && (g.1.this.dBx >= g.f(g.this)))
                {
                  g.a(g.this).ae(g.e(g.this), g.f(g.this), g.1.this.dBx + 1);
                  AppMethodBeat.o(111639);
                  return;
                }
                if (g.e(g.this) == g.1.this.dBx)
                {
                  g.a(g.this).ae(g.e(g.this), g.f(g.this), g.f(g.this));
                  AppMethodBeat.o(111639);
                  return;
                }
                g.a(g.this).ae(g.e(g.this), g.f(g.this), g.1.this.dBx);
              }
              AppMethodBeat.o(111639);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
            
            public final void onAnimationStart(Animation paramAnonymous2Animation) {}
          });
          ((g.a)paramAnonymousv).rLd.startAnimation(paramAnonymousRecyclerView);
        }
        AppMethodBeat.o(111642);
      }
      
      public final void f(final RecyclerView.v paramAnonymousv, final int paramAnonymousInt)
      {
        AppMethodBeat.i(111641);
        super.f(paramAnonymousv, paramAnonymousInt);
        if (paramAnonymousv != null)
        {
          Animation localAnimation = AnimationUtils.loadAnimation(g.b(g.this), 2130772078);
          localAnimation.setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(111638);
              if (paramAnonymousInt == 2)
              {
                g.b(g.this, g.a(g.this, paramAnonymousv.ln()));
                g.1.this.dBx = g.c(g.this);
                ad.i("MicroMsg.PreviewSelectedImageAdapter", "lastVisiblePos:%s", new Object[] { Integer.valueOf(g.1.this.dBx) });
              }
              AppMethodBeat.o(111638);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
            
            public final void onAnimationStart(Animation paramAnonymous2Animation) {}
          });
          ((g.a)paramAnonymousv).rLd.startAnimation(localAnimation);
        }
        AppMethodBeat.o(111641);
      }
      
      public final boolean mM()
      {
        return true;
      }
      
      public final boolean mN()
      {
        return false;
      }
    });
    this.mContext = paramContext;
    this.rJX = paramArrayList;
    this.rKO.addAll(paramArrayList);
    this.rKN = paramInt;
    this.rJc = paramBoolean;
    if (e.czh().jWF == 15)
    {
      this.rKR = paramContext.getResources().getDrawable(2131232558);
      AppMethodBeat.o(111646);
      return;
    }
    this.rKR = paramContext.getResources().getDrawable(2131231942);
    AppMethodBeat.o(111646);
  }
  
  private GalleryItem.MediaItem a(int paramInt, a parama)
  {
    AppMethodBeat.i(111654);
    if ((paramInt < 0) || (paramInt >= this.rKO.size()))
    {
      ad.w("MicroMsg.PreviewSelectedImageAdapter", "error position %d, imagePaths size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.rKO.size()) });
      AppMethodBeat.o(111654);
      return null;
    }
    Object localObject = (String)this.rKO.get(paramInt);
    if (this.rJc)
    {
      if (this.rKM.rGU == null) {
        break label321;
      }
      localObject = GalleryItem.MediaItem.a(0, 0L, (String)localObject, (String)localObject, "");
      paramInt = this.rKM.rGU.indexOf(localObject);
      if (paramInt >= 0)
      {
        parama.rLe = paramInt;
        parama = (GalleryItem.MediaItem)this.rKM.rGU.get(paramInt);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(111654);
      return parama;
      Iterator localIterator = e.czm().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          parama = (GalleryItem.MediaItem)localIterator.next();
          if (parama.equals(localObject))
          {
            ad.i("MicroMsg.PreviewSelectedImageAdapter", "[getMediaItem] %s", new Object[] { parama.rBp });
            break;
          }
        }
      }
      parama = null;
      continue;
      if (e.czj() != null)
      {
        localObject = GalleryItem.MediaItem.a(0, 0L, (String)localObject, (String)localObject, "");
        paramInt = e.czj().indexOf(localObject);
        if (paramInt >= 0)
        {
          parama = (GalleryItem.MediaItem)e.czj().get(paramInt);
        }
        else
        {
          localIterator = e.czm().iterator();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              parama = (GalleryItem.MediaItem)localIterator.next();
              if (parama.equals(localObject))
              {
                ad.i("MicroMsg.PreviewSelectedImageAdapter", "[getMediaItem] %s", new Object[] { parama.rBp });
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
      ad.e("MicroMsg.PreviewSelectedImageAdapter", "get item failed");
      AppMethodBeat.o(111650);
      return;
    }
    Object localObject = parama.rLd.getLayoutParams();
    int i = this.rKN;
    ((ViewGroup.LayoutParams)localObject).width = i;
    ((ViewGroup.LayoutParams)localObject).height = i;
    c(parama.rKX, localMediaItem.rBp, paramInt);
    parama.rLd.setOnClickListener(this);
    if (this.rJc)
    {
      parama.rLd.setTag(Integer.valueOf(parama.rLe));
      if (localMediaItem.getType() != 2) {
        break label241;
      }
      parama.rKY.setVisibility(0);
      i = Math.round((float)((GalleryItem.VideoMediaItem)localMediaItem).hsU / 1000.0F);
      parama.rKZ.setText(String.format(Locale.CHINA, "%d:%02d", new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) }));
    }
    String str;
    for (;;)
    {
      localObject = localMediaItem.anX();
      str = localMediaItem.rBp;
      if ((!bt.isNullOrNil((String)localObject)) || (!bt.isNullOrNil(str))) {
        break label253;
      }
      ad.e("MicroMsg.PreviewSelectedImageAdapter", "null or nil filepath: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(111650);
      return;
      parama.rLd.setTag(localMediaItem.rBp);
      break;
      label241:
      parama.rKY.setVisibility(8);
    }
    label253:
    h.a(parama.rww, localMediaItem.getType(), (String)localObject, str, localMediaItem.rBs, new h.a()
    {
      public final void cAN()
      {
        AppMethodBeat.i(111644);
        ad.i("MicroMsg.PreviewSelectedImageAdapter", "%s %s", new Object[] { Integer.valueOf(parama.rww.getWidth()), Integer.valueOf(parama.rww.getHeight()) });
        AppMethodBeat.o(111644);
      }
    }, localMediaItem.rBt);
    if (((e.czh().jWF == 3) || (e.czh().jWF == 11)) && (localMediaItem != null) && (localMediaItem.mMimeType.equalsIgnoreCase("image/gif")))
    {
      parama.rLa.setVisibility(0);
      if (!localMediaItem.mMimeType.equalsIgnoreCase("edit")) {
        break label385;
      }
      parama.rLb.setVisibility(0);
    }
    for (;;)
    {
      parama.rLc.setVisibility(8);
      AppMethodBeat.o(111650);
      return;
      parama.rLa.setVisibility(8);
      break;
      label385:
      parama.rLb.setVisibility(8);
    }
  }
  
  private void c(ImageView paramImageView, String paramString, int paramInt)
  {
    AppMethodBeat.i(111651);
    if (this.rJX.contains(paramString))
    {
      paramImageView.setBackground(null);
      paramImageView.setImageDrawable(this.rKR);
    }
    for (int i = 0;; i = 1)
    {
      paramImageView.setVisibility(0);
      if ((bt.isNullOrNil(this.rKM.getItem(this.rKQ))) || (!this.rKM.getItem(this.rKQ).equals(paramString))) {
        break;
      }
      paramImageView.setVisibility(0);
      if ((i == 0) || (paramInt != this.qNb)) {
        break label206;
      }
      paramImageView.setImageDrawable(this.rKR);
      AppMethodBeat.o(111651);
      return;
      paramImageView.setBackgroundColor(-1090519041);
      paramImageView.setImageDrawable(null);
    }
    if ((!bt.isNullOrNil(this.rKM.getItem(this.rKQ))) && (!this.rKM.getItem(this.rKQ).equals(paramString)))
    {
      if ((paramInt != this.qNb) && (i == 0))
      {
        paramImageView.setVisibility(8);
        AppMethodBeat.o(111651);
        return;
      }
      if ((paramInt == this.qNb) && (i == 0)) {
        paramImageView.setImageDrawable(this.rKR);
      }
    }
    label206:
    AppMethodBeat.o(111651);
  }
  
  public final void abO(String paramString)
  {
    AppMethodBeat.i(111647);
    this.rKO.add(paramString);
    AppMethodBeat.o(111647);
  }
  
  public final void fN(int paramInt1, int paramInt2)
  {
    this.qNb = paramInt1;
    this.rKQ = paramInt2;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(111652);
    int i = this.rKO.size();
    AppMethodBeat.o(111652);
    return i;
  }
  
  public final int indexOf(String paramString)
  {
    AppMethodBeat.i(111648);
    int i = this.rKO.indexOf(paramString);
    AppMethodBeat.o(111648);
    return i;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(111653);
    if (this.rKP != null)
    {
      if (this.rJc)
      {
        this.rKP.Ek(((Integer)paramView.getTag()).intValue());
        AppMethodBeat.o(111653);
        return;
      }
      this.rKP.Ek(this.rKO.indexOf(paramView.getTag()));
    }
    AppMethodBeat.o(111653);
  }
  
  public final void remove(int paramInt)
  {
    AppMethodBeat.i(111649);
    this.rKO.remove(paramInt);
    AppMethodBeat.o(111649);
  }
  
  public static final class a
    extends RecyclerView.v
  {
    public ImageView rHf;
    public ImageView rKX;
    public RelativeLayout rKY;
    public TextView rKZ;
    public ImageView rLa;
    public ImageView rLb;
    public ImageView rLc;
    public View rLd;
    public int rLe;
    public ImageView rww;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(111645);
      this.rLd = paramView;
      this.rLa = ((ImageView)paramView.findViewById(2131300586));
      this.rLb = ((ImageView)paramView.findViewById(2131299258));
      this.rLc = ((ImageView)paramView.findViewById(2131299519));
      this.rKX = ((ImageView)paramView.findViewById(2131302216));
      this.rww = ((ImageView)paramView.findViewById(2131302221));
      this.rKY = ((RelativeLayout)paramView.findViewById(2131306355));
      this.rKZ = ((TextView)paramView.findViewById(2131306357));
      this.rHf = ((ImageView)paramView.findViewById(2131302212));
      this.rHf.setBackgroundResource(2131100482);
      this.rHf.setVisibility(8);
      AppMethodBeat.o(111645);
    }
  }
  
  public static abstract interface b
  {
    public abstract void Ek(int paramInt);
    
    public abstract void ae(int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void fM(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.g
 * JD-Core Version:    0.7.0.1
 */