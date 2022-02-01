package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
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
  private Context mContext;
  private int vLx;
  private int vLy;
  private int vLz;
  private boolean xpA;
  private ArrayList<String> xqv;
  d xrl;
  private int xrm;
  ArrayList<String> xrn;
  b xro;
  private int xrp;
  private Drawable xrq;
  android.support.v7.widget.a.a xrr;
  
  public g(Context paramContext, ArrayList<String> paramArrayList, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(111646);
    this.xrn = new ArrayList();
    this.vLx = -1;
    this.vLy = -1;
    this.xrr = new android.support.v7.widget.a.a(new a.a()
    {
      int eeE = -1;
      
      public final float M(RecyclerView.v paramAnonymousv)
      {
        return 0.295858F;
      }
      
      public final void N(RecyclerView.v paramAnonymousv) {}
      
      public final int a(RecyclerView paramAnonymousRecyclerView, RecyclerView.v paramAnonymousv)
      {
        AppMethodBeat.i(179475);
        int i = db(51);
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
        int i = paramAnonymousv1.lR();
        int j = paramAnonymousv2.lR();
        g.this.ar(i, j);
        if (g.a(g.this) != null) {
          g.a(g.this).gI(i, j);
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
          paramAnonymousRecyclerView = AnimationUtils.loadAnimation(g.b(g.this), 2130772096);
          paramAnonymousRecyclerView.setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(111639);
              com.tencent.mm.plugin.gallery.a.d.swap(g.d(g.this), g.e(g.this), g.f(g.this));
              if (g.a(g.this) != null)
              {
                if ((g.1.this.eeE > g.e(g.this)) && (g.1.this.eeE <= g.f(g.this)))
                {
                  g.a(g.this).ak(g.e(g.this), g.f(g.this), g.1.this.eeE - 1);
                  AppMethodBeat.o(111639);
                  return;
                }
                if ((g.1.this.eeE < g.e(g.this)) && (g.1.this.eeE >= g.f(g.this)))
                {
                  g.a(g.this).ak(g.e(g.this), g.f(g.this), g.1.this.eeE + 1);
                  AppMethodBeat.o(111639);
                  return;
                }
                if (g.e(g.this) == g.1.this.eeE)
                {
                  g.a(g.this).ak(g.e(g.this), g.f(g.this), g.f(g.this));
                  AppMethodBeat.o(111639);
                  return;
                }
                g.a(g.this).ak(g.e(g.this), g.f(g.this), g.1.this.eeE);
              }
              AppMethodBeat.o(111639);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
            
            public final void onAnimationStart(Animation paramAnonymous2Animation) {}
          });
          ((g.a)paramAnonymousv).convertView.startAnimation(paramAnonymousRecyclerView);
        }
        AppMethodBeat.o(111642);
      }
      
      public final void f(final RecyclerView.v paramAnonymousv, final int paramAnonymousInt)
      {
        AppMethodBeat.i(111641);
        super.f(paramAnonymousv, paramAnonymousInt);
        if (paramAnonymousv != null)
        {
          Animation localAnimation = AnimationUtils.loadAnimation(g.b(g.this), 2130772097);
          localAnimation.setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(111638);
              if (paramAnonymousInt == 2)
              {
                g.b(g.this, g.a(g.this, paramAnonymousv.lR()));
                g.1.this.eeE = g.c(g.this);
                Log.i("MicroMsg.PreviewSelectedImageAdapter", "lastVisiblePos:%s", new Object[] { Integer.valueOf(g.1.this.eeE) });
              }
              AppMethodBeat.o(111638);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
            
            public final void onAnimationStart(Animation paramAnonymous2Animation) {}
          });
          ((g.a)paramAnonymousv).convertView.startAnimation(localAnimation);
        }
        AppMethodBeat.o(111641);
      }
      
      public final boolean nq()
      {
        return true;
      }
      
      public final boolean nr()
      {
        return false;
      }
    });
    this.mContext = paramContext;
    this.xqv = paramArrayList;
    this.xrn.addAll(paramArrayList);
    this.xrm = paramInt;
    this.xpA = paramBoolean;
    if (e.dQK().mcq == 15)
    {
      this.xrq = paramContext.getResources().getDrawable(2131232947);
      AppMethodBeat.o(111646);
      return;
    }
    this.xrq = paramContext.getResources().getDrawable(2131232026);
    AppMethodBeat.o(111646);
  }
  
  private GalleryItem.MediaItem a(int paramInt, a parama)
  {
    AppMethodBeat.i(111654);
    if ((paramInt < 0) || (paramInt >= this.xrn.size()))
    {
      Log.w("MicroMsg.PreviewSelectedImageAdapter", "error position %d, imagePaths size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.xrn.size()) });
      AppMethodBeat.o(111654);
      return null;
    }
    Object localObject = (String)this.xrn.get(paramInt);
    if (this.xpA)
    {
      if (this.xrl.xno == null) {
        break label321;
      }
      localObject = GalleryItem.MediaItem.a(0, 0L, (String)localObject, (String)localObject, "");
      paramInt = this.xrl.xno.indexOf(localObject);
      if (paramInt >= 0)
      {
        parama.xrC = paramInt;
        parama = (GalleryItem.MediaItem)this.xrl.xno.get(paramInt);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(111654);
      return parama;
      Iterator localIterator = e.dQP().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          parama = (GalleryItem.MediaItem)localIterator.next();
          if (parama.equals(localObject))
          {
            Log.i("MicroMsg.PreviewSelectedImageAdapter", "[getMediaItem] %s", new Object[] { parama.xiW });
            break;
          }
        }
      }
      parama = null;
      continue;
      if (e.dQM() != null)
      {
        localObject = GalleryItem.MediaItem.a(0, 0L, (String)localObject, (String)localObject, "");
        paramInt = e.dQM().indexOf(localObject);
        if (paramInt >= 0)
        {
          parama = (GalleryItem.MediaItem)e.dQM().get(paramInt);
        }
        else
        {
          localIterator = e.dQP().iterator();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              parama = (GalleryItem.MediaItem)localIterator.next();
              if (parama.equals(localObject))
              {
                Log.i("MicroMsg.PreviewSelectedImageAdapter", "[getMediaItem] %s", new Object[] { parama.xiW });
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
    int i = this.xrm;
    ((ViewGroup.LayoutParams)localObject).width = i;
    ((ViewGroup.LayoutParams)localObject).height = i;
    c(parama.xrw, localMediaItem.xiW, paramInt);
    parama.convertView.setOnClickListener(this);
    if (this.xpA)
    {
      parama.convertView.setTag(Integer.valueOf(parama.xrC));
      if (localMediaItem.getType() != 2) {
        break label241;
      }
      parama.xrx.setVisibility(0);
      i = Math.round((float)((GalleryItem.VideoMediaItem)localMediaItem).jkS / 1000.0F);
      parama.xry.setText(String.format(Locale.CHINA, "%d:%02d", new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) }));
    }
    String str;
    for (;;)
    {
      localObject = localMediaItem.aQn();
      str = localMediaItem.xiW;
      if ((!Util.isNullOrNil((String)localObject)) || (!Util.isNullOrNil(str))) {
        break label253;
      }
      Log.e("MicroMsg.PreviewSelectedImageAdapter", "null or nil filepath: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(111650);
      return;
      parama.convertView.setTag(localMediaItem.xiW);
      break;
      label241:
      parama.xrx.setVisibility(8);
    }
    label253:
    h.a(parama.xdY, localMediaItem.getType(), (String)localObject, str, localMediaItem.xiZ, new h.a()
    {
      public final void dSs()
      {
        AppMethodBeat.i(111644);
        Log.i("MicroMsg.PreviewSelectedImageAdapter", "%s %s", new Object[] { Integer.valueOf(parama.xdY.getWidth()), Integer.valueOf(parama.xdY.getHeight()) });
        AppMethodBeat.o(111644);
      }
    }, localMediaItem.xja);
    if (((e.dQK().mcq == 3) || (e.dQK().mcq == 11)) && (localMediaItem != null) && (localMediaItem.mMimeType.equalsIgnoreCase("image/gif")))
    {
      parama.xrz.setVisibility(0);
      if (!localMediaItem.mMimeType.equalsIgnoreCase("edit")) {
        break label385;
      }
      parama.xrA.setVisibility(0);
    }
    for (;;)
    {
      parama.xrB.setVisibility(8);
      AppMethodBeat.o(111650);
      return;
      parama.xrz.setVisibility(8);
      break;
      label385:
      parama.xrA.setVisibility(8);
    }
  }
  
  private void c(ImageView paramImageView, String paramString, int paramInt)
  {
    AppMethodBeat.i(111651);
    if (this.xqv.contains(paramString))
    {
      paramImageView.setBackground(null);
      paramImageView.setImageDrawable(this.xrq);
    }
    for (int i = 0;; i = 1)
    {
      paramImageView.setVisibility(0);
      if ((Util.isNullOrNil(this.xrl.getItem(this.xrp))) || (!this.xrl.getItem(this.xrp).equals(paramString))) {
        break;
      }
      paramImageView.setVisibility(0);
      if ((i == 0) || (paramInt != this.vLz)) {
        break label206;
      }
      paramImageView.setImageDrawable(this.xrq);
      AppMethodBeat.o(111651);
      return;
      paramImageView.setBackgroundColor(-1090519041);
      paramImageView.setImageDrawable(null);
    }
    if ((!Util.isNullOrNil(this.xrl.getItem(this.xrp))) && (!this.xrl.getItem(this.xrp).equals(paramString)))
    {
      if ((paramInt != this.vLz) && (i == 0))
      {
        paramImageView.setVisibility(8);
        AppMethodBeat.o(111651);
        return;
      }
      if ((paramInt == this.vLz) && (i == 0)) {
        paramImageView.setImageDrawable(this.xrq);
      }
    }
    label206:
    AppMethodBeat.o(111651);
  }
  
  public final void aze(String paramString)
  {
    AppMethodBeat.i(111647);
    this.xrn.add(paramString);
    AppMethodBeat.o(111647);
  }
  
  public final void gJ(int paramInt1, int paramInt2)
  {
    this.vLz = paramInt1;
    this.xrp = paramInt2;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(111652);
    int i = this.xrn.size();
    AppMethodBeat.o(111652);
    return i;
  }
  
  public final int indexOf(String paramString)
  {
    AppMethodBeat.i(111648);
    int i = this.xrn.indexOf(paramString);
    AppMethodBeat.o(111648);
    return i;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(111653);
    b localb = new b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/ui/PreviewSelectedImageAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (this.xro != null)
    {
      if (!this.xpA) {
        break label95;
      }
      this.xro.NV(((Integer)paramView.getTag()).intValue());
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/ui/PreviewSelectedImageAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(111653);
      return;
      label95:
      this.xro.NV(this.xrn.indexOf(paramView.getTag()));
    }
  }
  
  public final void remove(int paramInt)
  {
    AppMethodBeat.i(111649);
    this.xrn.remove(paramInt);
    AppMethodBeat.o(111649);
  }
  
  public static final class a
    extends RecyclerView.v
  {
    public View convertView;
    public ImageView xdY;
    public ImageView xnz;
    public ImageView xrA;
    public ImageView xrB;
    public int xrC;
    public ImageView xrw;
    public RelativeLayout xrx;
    public TextView xry;
    public ImageView xrz;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(111645);
      this.convertView = paramView;
      this.xrz = ((ImageView)paramView.findViewById(2131302131));
      this.xrA = ((ImageView)paramView.findViewById(2131299834));
      this.xrB = ((ImageView)paramView.findViewById(2131300157));
      this.xrw = ((ImageView)paramView.findViewById(2131304568));
      this.xdY = ((ImageView)paramView.findViewById(2131304573));
      this.xrx = ((RelativeLayout)paramView.findViewById(2131309781));
      this.xry = ((TextView)paramView.findViewById(2131309783));
      this.xnz = ((ImageView)paramView.findViewById(2131304563));
      this.xnz.setBackgroundResource(2131100584);
      this.xnz.setVisibility(8);
      AppMethodBeat.o(111645);
    }
  }
  
  public static abstract interface b
  {
    public abstract void NV(int paramInt);
    
    public abstract void ak(int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void gI(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.g
 * JD-Core Version:    0.7.0.1
 */