package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.PrivateAlbumItem;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.g;
import com.tencent.mm.plugin.gallery.model.i.a;
import com.tencent.mm.plugin.gallery.model.o;
import com.tencent.mm.plugin.gallery.model.s.a;
import com.tencent.mm.plugin.gallery.model.s.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.vfs.i;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;

public class ImageFolderMgrView
  extends LinearLayout
  implements AdapterView.OnItemClickListener, i.a
{
  boolean jR;
  private a tNN;
  FrameLayout tNO;
  private View tNP;
  private ListView tNQ;
  private b tNR;
  boolean tNS;
  i.a tNT;
  private LinkedList<GalleryItem.PrivateAlbumItem> tNU;
  private GalleryItem.PrivateAlbumItem tNV;
  b tNW;
  
  public ImageFolderMgrView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(111536);
    this.tNN = null;
    this.jR = false;
    this.tNS = false;
    this.tNU = new LinkedList();
    this.tNV = null;
    setOrientation(1);
    this.tNO = new FrameLayout(getContext());
    paramContext = new LinearLayout.LayoutParams(-1, -1);
    this.tNO.setVisibility(8);
    addView(this.tNO, paramContext);
    this.tNP = new View(getContext());
    this.tNP.setBackgroundColor(-872415232);
    this.tNP.setOnClickListener(new ImageFolderMgrView.3(this));
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    this.tNO.addView(this.tNP, paramContext);
    paramContext = new RoundedCornerFrameLayout(getContext());
    paramContext.p(0.0F, 0.0F, aq.fromDPToPix(getContext(), 8), aq.fromDPToPix(getContext(), 8));
    paramAttributeSet = new FrameLayout.LayoutParams(-1, -2);
    paramAttributeSet.bottomMargin = getResources().getDimensionPixelSize(2131166394);
    paramAttributeSet.gravity = 48;
    this.tNO.addView(paramContext, paramAttributeSet);
    this.tNQ = new ListView(getContext());
    this.tNQ.setCacheColorHint(0);
    this.tNQ.setOnItemClickListener(this);
    paramAttributeSet = new RelativeLayout.LayoutParams(-1, -2);
    paramContext.addView(this.tNQ, paramAttributeSet);
    this.tNR = new b(getContext());
    this.tNQ.setAdapter(this.tNR);
    this.tNT = new i.a()
    {
      public final void aq(LinkedList<GalleryItem.AlbumItem> paramAnonymousLinkedList)
      {
        AppMethodBeat.i(173780);
        Object localObject;
        if (paramAnonymousLinkedList != null)
        {
          localObject = Integer.valueOf(paramAnonymousLinkedList.size());
          ad.i("MicroMsg.ImageFolderMgrView", "onGetPrivateAlbum, %s.", new Object[] { localObject });
          e.cUM().c(ImageFolderMgrView.d(ImageFolderMgrView.this));
          if ((paramAnonymousLinkedList != null) && (paramAnonymousLinkedList.size() > 0)) {
            paramAnonymousLinkedList = paramAnonymousLinkedList.iterator();
          }
        }
        else
        {
          for (;;)
          {
            label61:
            if (!paramAnonymousLinkedList.hasNext()) {
              break label154;
            }
            localObject = (GalleryItem.AlbumItem)paramAnonymousLinkedList.next();
            if ((localObject instanceof GalleryItem.PrivateAlbumItem))
            {
              localObject = (GalleryItem.PrivateAlbumItem)localObject;
              s.b localb = ((GalleryItem.PrivateAlbumItem)localObject).tHb.tHJ;
              if (localb == null) {}
              for (boolean bool = false;; bool = localb.tHM)
              {
                if (!bool) {
                  break label139;
                }
                ImageFolderMgrView.a(ImageFolderMgrView.this, (GalleryItem.PrivateAlbumItem)localObject);
                break label61;
                localObject = "res is null.";
                break;
              }
              label139:
              ImageFolderMgrView.e(ImageFolderMgrView.this).add(localObject);
            }
          }
          label154:
          ad.i("MicroMsg.ImageFolderMgrView", "filter res: %s.", new Object[] { Integer.valueOf(ImageFolderMgrView.e(ImageFolderMgrView.this).size()) });
          if ((!ImageFolderMgrView.this.isInLayout()) && ((ImageFolderMgrView.f(ImageFolderMgrView.this) != null) || (ImageFolderMgrView.e(ImageFolderMgrView.this).size() > 0)))
          {
            ImageFolderMgrView.g(ImageFolderMgrView.this).a(ImageFolderMgrView.f(ImageFolderMgrView.this), ImageFolderMgrView.e(ImageFolderMgrView.this));
            ImageFolderMgrView.a(ImageFolderMgrView.this, null);
            ImageFolderMgrView.e(ImageFolderMgrView.this).clear();
            e.cUN().f(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(173779);
                ImageFolderMgrView.g(ImageFolderMgrView.this).notifyDataSetChanged();
                AppMethodBeat.o(173779);
              }
            });
          }
        }
        AppMethodBeat.o(173780);
      }
    };
    getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
    {
      public final boolean onPreDraw()
      {
        AppMethodBeat.i(179469);
        ad.i("MicroMsg.ImageFolderMgrView", "onPreDraw.");
        if ((ImageFolderMgrView.f(ImageFolderMgrView.this) != null) || (ImageFolderMgrView.e(ImageFolderMgrView.this).size() > 0))
        {
          ImageFolderMgrView.g(ImageFolderMgrView.this).a(ImageFolderMgrView.f(ImageFolderMgrView.this), ImageFolderMgrView.e(ImageFolderMgrView.this));
          ImageFolderMgrView.a(ImageFolderMgrView.this, null);
          ImageFolderMgrView.e(ImageFolderMgrView.this).clear();
          e.cUN().f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(179468);
              ImageFolderMgrView.g(ImageFolderMgrView.this).notifyDataSetChanged();
              AppMethodBeat.o(179468);
            }
          });
          AppMethodBeat.o(179469);
          return false;
        }
        AppMethodBeat.o(179469);
        return true;
      }
    });
    AppMethodBeat.o(111536);
  }
  
  private void cWe()
  {
    AppMethodBeat.i(111539);
    this.tNS = true;
    this.tNO.setVisibility(0);
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772047);
    this.tNP.startAnimation(localAnimation);
    localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772105);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(111530);
        ImageFolderMgrView.a(ImageFolderMgrView.this, true);
        ImageFolderMgrView.a(ImageFolderMgrView.this);
        if (ImageFolderMgrView.this.tNW != null) {
          ImageFolderMgrView.this.tNW.mQ(true);
        }
        AppMethodBeat.o(111530);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    this.tNQ.startAnimation(localAnimation);
    AppMethodBeat.o(111539);
  }
  
  private void cWf()
  {
    AppMethodBeat.i(111540);
    this.tNS = true;
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772109);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(111531);
        ImageFolderMgrView.b(ImageFolderMgrView.this).setVisibility(8);
        ImageFolderMgrView.a(ImageFolderMgrView.this, false);
        ImageFolderMgrView.a(ImageFolderMgrView.this);
        if (ImageFolderMgrView.this.tNW != null) {
          ImageFolderMgrView.this.tNW.mQ(false);
        }
        AppMethodBeat.o(111531);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    this.tNQ.startAnimation(localAnimation);
    localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772048);
    this.tNP.startAnimation(localAnimation);
    AppMethodBeat.o(111540);
  }
  
  private void mS(boolean paramBoolean)
  {
    AppMethodBeat.i(111538);
    if (this.jR == paramBoolean)
    {
      ad.d("MicroMsg.ImageFolderMgrView", "want to expand, but same status, expanded %B", new Object[] { Boolean.valueOf(this.jR) });
      AppMethodBeat.o(111538);
      return;
    }
    if (this.tNS)
    {
      ad.d("MicroMsg.ImageFolderMgrView", "want to expand[%B], but now in animation", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(111538);
      return;
    }
    if (this.jR)
    {
      cWf();
      AppMethodBeat.o(111538);
      return;
    }
    cWe();
    AppMethodBeat.o(111538);
  }
  
  public final void aq(LinkedList<GalleryItem.AlbumItem> paramLinkedList)
  {
    AppMethodBeat.i(111541);
    ad.i("MicroMsg.ImageFolderMgrView", "onQueryAlbumFinished, %s, size: %s.", new Object[] { this, Integer.valueOf(paramLinkedList.size()) });
    e.cUM().b(this);
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      GalleryItem.AlbumItem localAlbumItem = (GalleryItem.AlbumItem)paramLinkedList.next();
      if (i.fv(localAlbumItem.axA())) {
        localLinkedList.add(localAlbumItem);
      }
    }
    this.tNR.tNj = localLinkedList;
    e.cUN().f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179470);
        ImageFolderMgrView.g(ImageFolderMgrView.this).notifyDataSetChanged();
        AppMethodBeat.o(179470);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(179471);
        String str = super.toString() + "|onQueryAlbumFinished";
        AppMethodBeat.o(179471);
        return str;
      }
    });
    AppMethodBeat.o(111541);
  }
  
  public final void cWd()
  {
    AppMethodBeat.i(111537);
    if (!this.jR) {}
    for (boolean bool = true;; bool = false)
    {
      mS(bool);
      AppMethodBeat.o(111537);
      return;
    }
  }
  
  public String getSelectedAlbumName()
  {
    return this.tNR.tNk;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(111542);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramAdapterView);
    localb.bd(paramView);
    localb.mr(paramInt);
    localb.qY(paramLong);
    a.b("com/tencent/mm/plugin/gallery/ui/ImageFolderMgrView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
    paramAdapterView = this.tNR.Hp(paramInt);
    if (paramAdapterView == null)
    {
      ad.d("MicroMsg.ImageFolderMgrView", "get folder failed:".concat(String.valueOf(paramInt)));
      a.a(this, "com/tencent/mm/plugin/gallery/ui/ImageFolderMgrView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(111542);
      return;
    }
    this.tNP.performClick();
    if (this.tNN != null) {
      this.tNN.c(paramAdapterView);
    }
    this.tNR.tNk = bt.bI(paramAdapterView.tGK, "");
    this.tNR.notifyDataSetChanged();
    a.a(this, "com/tencent/mm/plugin/gallery/ui/ImageFolderMgrView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(111542);
  }
  
  public void setFavItemCount(int paramInt)
  {
    AppMethodBeat.i(111543);
    this.tNR.tNl = paramInt;
    c localc = new c((byte)0);
    localc.tMS = new WeakReference(this.tNR);
    e.cUN().f(localc);
    AppMethodBeat.o(111543);
  }
  
  public void setListener(a parama)
  {
    this.tNN = parama;
  }
  
  public void setOnFolderStateChanged(b paramb)
  {
    this.tNW = paramb;
  }
  
  public static abstract interface a
  {
    public abstract void c(GalleryItem.AlbumItem paramAlbumItem);
  }
  
  public static abstract interface b
  {
    public abstract void mQ(boolean paramBoolean);
  }
  
  static final class c
    implements Runnable
  {
    WeakReference<b> tMS;
    
    public final void run()
    {
      AppMethodBeat.i(111535);
      if (this.tMS != null)
      {
        b localb = (b)this.tMS.get();
        if (localb != null) {
          localb.notifyDataSetChanged();
        }
      }
      AppMethodBeat.o(111535);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImageFolderMgrView
 * JD-Core Version:    0.7.0.1
 */