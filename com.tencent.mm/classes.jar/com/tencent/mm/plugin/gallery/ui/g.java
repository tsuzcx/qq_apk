package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Locale;

public final class g
  extends RecyclerView.a<a>
  implements View.OnClickListener
{
  private Context mContext;
  private int rIx;
  private int rIy;
  private int rIz;
  private boolean sQR;
  private ArrayList<String> sRM;
  d sSB;
  private int sSC;
  ArrayList<String> sSD;
  b sSE;
  private int sSF;
  private Drawable sSG;
  a sSH;
  
  public g(Context paramContext, ArrayList<String> paramArrayList, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(111646);
    this.sSD = new ArrayList();
    this.rIx = -1;
    this.rIy = -1;
    this.sSH = new a(new a.a()
    {
      int dzl = -1;
      
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
        int i = paramAnonymousw1.lv();
        int j = paramAnonymousw2.lv();
        g.this.ap(i, j);
        if (g.a(g.this) != null) {
          g.a(g.this).fT(i, j);
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
                if ((g.1.this.dzl > g.e(g.this)) && (g.1.this.dzl <= g.f(g.this)))
                {
                  g.a(g.this).af(g.e(g.this), g.f(g.this), g.1.this.dzl - 1);
                  AppMethodBeat.o(111639);
                  return;
                }
                if ((g.1.this.dzl < g.e(g.this)) && (g.1.this.dzl >= g.f(g.this)))
                {
                  g.a(g.this).af(g.e(g.this), g.f(g.this), g.1.this.dzl + 1);
                  AppMethodBeat.o(111639);
                  return;
                }
                if (g.e(g.this) == g.1.this.dzl)
                {
                  g.a(g.this).af(g.e(g.this), g.f(g.this), g.f(g.this));
                  AppMethodBeat.o(111639);
                  return;
                }
                g.a(g.this).af(g.e(g.this), g.f(g.this), g.1.this.dzl);
              }
              AppMethodBeat.o(111639);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
            
            public final void onAnimationStart(Animation paramAnonymous2Animation) {}
          });
          ((g.a)paramAnonymousw).sSS.startAnimation(paramAnonymousRecyclerView);
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
                g.b(g.this, g.a(g.this, paramAnonymousw.lv()));
                g.1.this.dzl = g.c(g.this);
                ac.i("MicroMsg.PreviewSelectedImageAdapter", "lastVisiblePos:%s", new Object[] { Integer.valueOf(g.1.this.dzl) });
              }
              AppMethodBeat.o(111638);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
            
            public final void onAnimationStart(Animation paramAnonymous2Animation) {}
          });
          ((g.a)paramAnonymousw).sSS.startAnimation(localAnimation);
        }
        AppMethodBeat.o(111641);
      }
      
      public final boolean mW()
      {
        return true;
      }
      
      public final boolean mX()
      {
        return false;
      }
    });
    this.mContext = paramContext;
    this.sRM = paramArrayList;
    this.sSD.addAll(paramArrayList);
    this.sSC = paramInt;
    this.sQR = paramBoolean;
    if (e.cMt().kxr == 15)
    {
      this.sSG = paramContext.getResources().getDrawable(2131232558);
      AppMethodBeat.o(111646);
      return;
    }
    this.sSG = paramContext.getResources().getDrawable(2131231942);
    AppMethodBeat.o(111646);
  }
  
  private GalleryItem.MediaItem a(int paramInt, a parama)
  {
    AppMethodBeat.i(111654);
    if ((paramInt < 0) || (paramInt >= this.sSD.size()))
    {
      ac.w("MicroMsg.PreviewSelectedImageAdapter", "error position %d, imagePaths size %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.sSD.size()) });
      AppMethodBeat.o(111654);
      return null;
    }
    Object localObject = (String)this.sSD.get(paramInt);
    if (this.sQR)
    {
      if (this.sSB.sOJ == null) {
        break label321;
      }
      localObject = GalleryItem.MediaItem.a(0, 0L, (String)localObject, (String)localObject, "");
      paramInt = this.sSB.sOJ.indexOf(localObject);
      if (paramInt >= 0)
      {
        parama.sST = paramInt;
        parama = (GalleryItem.MediaItem)this.sSB.sOJ.get(paramInt);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(111654);
      return parama;
      Iterator localIterator = e.cMy().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          parama = (GalleryItem.MediaItem)localIterator.next();
          if (parama.equals(localObject))
          {
            ac.i("MicroMsg.PreviewSelectedImageAdapter", "[getMediaItem] %s", new Object[] { parama.sKh });
            break;
          }
        }
      }
      parama = null;
      continue;
      if (e.cMv() != null)
      {
        localObject = GalleryItem.MediaItem.a(0, 0L, (String)localObject, (String)localObject, "");
        paramInt = e.cMv().indexOf(localObject);
        if (paramInt >= 0)
        {
          parama = (GalleryItem.MediaItem)e.cMv().get(paramInt);
        }
        else
        {
          localIterator = e.cMy().iterator();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              parama = (GalleryItem.MediaItem)localIterator.next();
              if (parama.equals(localObject))
              {
                ac.i("MicroMsg.PreviewSelectedImageAdapter", "[getMediaItem] %s", new Object[] { parama.sKh });
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
      ac.e("MicroMsg.PreviewSelectedImageAdapter", "get item failed");
      AppMethodBeat.o(111650);
      return;
    }
    Object localObject = parama.sSS.getLayoutParams();
    int i = this.sSC;
    ((ViewGroup.LayoutParams)localObject).width = i;
    ((ViewGroup.LayoutParams)localObject).height = i;
    c(parama.sSM, localMediaItem.sKh, paramInt);
    parama.sSS.setOnClickListener(this);
    if (this.sQR)
    {
      parama.sSS.setTag(Integer.valueOf(parama.sST));
      if (localMediaItem.getType() != 2) {
        break label241;
      }
      parama.sSN.setVisibility(0);
      i = Math.round((float)((GalleryItem.VideoMediaItem)localMediaItem).hTw / 1000.0F);
      parama.sSO.setText(String.format(Locale.CHINA, "%d:%02d", new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) }));
    }
    String str;
    for (;;)
    {
      localObject = localMediaItem.auN();
      str = localMediaItem.sKh;
      if ((!bs.isNullOrNil((String)localObject)) || (!bs.isNullOrNil(str))) {
        break label253;
      }
      ac.e("MicroMsg.PreviewSelectedImageAdapter", "null or nil filepath: ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(111650);
      return;
      parama.sSS.setTag(localMediaItem.sKh);
      break;
      label241:
      parama.sSN.setVisibility(8);
    }
    label253:
    h.a(parama.sFo, localMediaItem.getType(), (String)localObject, str, localMediaItem.sKk, new h.a()
    {
      public final void cGk()
      {
        AppMethodBeat.i(111644);
        ac.i("MicroMsg.PreviewSelectedImageAdapter", "%s %s", new Object[] { Integer.valueOf(parama.sFo.getWidth()), Integer.valueOf(parama.sFo.getHeight()) });
        AppMethodBeat.o(111644);
      }
    }, localMediaItem.sKl);
    if (((e.cMt().kxr == 3) || (e.cMt().kxr == 11)) && (localMediaItem != null) && (localMediaItem.mMimeType.equalsIgnoreCase("image/gif")))
    {
      parama.sSP.setVisibility(0);
      if (!localMediaItem.mMimeType.equalsIgnoreCase("edit")) {
        break label385;
      }
      parama.sSQ.setVisibility(0);
    }
    for (;;)
    {
      parama.sSR.setVisibility(8);
      AppMethodBeat.o(111650);
      return;
      parama.sSP.setVisibility(8);
      break;
      label385:
      parama.sSQ.setVisibility(8);
    }
  }
  
  private void c(ImageView paramImageView, String paramString, int paramInt)
  {
    AppMethodBeat.i(111651);
    if (this.sRM.contains(paramString))
    {
      paramImageView.setBackground(null);
      paramImageView.setImageDrawable(this.sSG);
    }
    for (int i = 0;; i = 1)
    {
      paramImageView.setVisibility(0);
      if ((bs.isNullOrNil(this.sSB.getItem(this.sSF))) || (!this.sSB.getItem(this.sSF).equals(paramString))) {
        break;
      }
      paramImageView.setVisibility(0);
      if ((i == 0) || (paramInt != this.rIz)) {
        break label206;
      }
      paramImageView.setImageDrawable(this.sSG);
      AppMethodBeat.o(111651);
      return;
      paramImageView.setBackgroundColor(-1090519041);
      paramImageView.setImageDrawable(null);
    }
    if ((!bs.isNullOrNil(this.sSB.getItem(this.sSF))) && (!this.sSB.getItem(this.sSF).equals(paramString)))
    {
      if ((paramInt != this.rIz) && (i == 0))
      {
        paramImageView.setVisibility(8);
        AppMethodBeat.o(111651);
        return;
      }
      if ((paramInt == this.rIz) && (i == 0)) {
        paramImageView.setImageDrawable(this.sSG);
      }
    }
    label206:
    AppMethodBeat.o(111651);
  }
  
  public final void agG(String paramString)
  {
    AppMethodBeat.i(111647);
    this.sSD.add(paramString);
    AppMethodBeat.o(111647);
  }
  
  public final void fU(int paramInt1, int paramInt2)
  {
    this.rIz = paramInt1;
    this.sSF = paramInt2;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(111652);
    int i = this.sSD.size();
    AppMethodBeat.o(111652);
    return i;
  }
  
  public final int indexOf(String paramString)
  {
    AppMethodBeat.i(111648);
    int i = this.sSD.indexOf(paramString);
    AppMethodBeat.o(111648);
    return i;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(111653);
    if (this.sSE != null)
    {
      if (this.sQR)
      {
        this.sSE.Gg(((Integer)paramView.getTag()).intValue());
        AppMethodBeat.o(111653);
        return;
      }
      this.sSE.Gg(this.sSD.indexOf(paramView.getTag()));
    }
    AppMethodBeat.o(111653);
  }
  
  public final void remove(int paramInt)
  {
    AppMethodBeat.i(111649);
    this.sSD.remove(paramInt);
    AppMethodBeat.o(111649);
  }
  
  public static final class a
    extends RecyclerView.w
  {
    public ImageView sFo;
    public ImageView sOU;
    public ImageView sSM;
    public RelativeLayout sSN;
    public TextView sSO;
    public ImageView sSP;
    public ImageView sSQ;
    public ImageView sSR;
    public View sSS;
    public int sST;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(111645);
      this.sSS = paramView;
      this.sSP = ((ImageView)paramView.findViewById(2131300586));
      this.sSQ = ((ImageView)paramView.findViewById(2131299258));
      this.sSR = ((ImageView)paramView.findViewById(2131299519));
      this.sSM = ((ImageView)paramView.findViewById(2131302216));
      this.sFo = ((ImageView)paramView.findViewById(2131302221));
      this.sSN = ((RelativeLayout)paramView.findViewById(2131306355));
      this.sSO = ((TextView)paramView.findViewById(2131306357));
      this.sOU = ((ImageView)paramView.findViewById(2131302212));
      this.sOU.setBackgroundResource(2131100482);
      this.sOU.setVisibility(8);
      AppMethodBeat.o(111645);
    }
  }
  
  public static abstract interface b
  {
    public abstract void Gg(int paramInt);
    
    public abstract void af(int paramInt1, int paramInt2, int paramInt3);
    
    public abstract void fT(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.g
 * JD-Core Version:    0.7.0.1
 */