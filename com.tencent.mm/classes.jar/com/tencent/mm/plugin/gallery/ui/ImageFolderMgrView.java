package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
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
import com.tencent.mm.plugin.gallery.b.c;
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.PrivateAlbumItem;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.g;
import com.tencent.mm.plugin.gallery.model.l.a;
import com.tencent.mm.plugin.gallery.model.q;
import com.tencent.mm.plugin.gallery.model.t.a;
import com.tencent.mm.plugin.gallery.model.t.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.vfs.y;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;

public class ImageFolderMgrView
  extends LinearLayout
  implements AdapterView.OnItemClickListener, l.a
{
  private a HOo;
  FrameLayout HOp;
  private View HOq;
  private ListView HOr;
  b HOs;
  boolean HOt;
  l.a HOu;
  private LinkedList<PrivateAlbumItem> HOv;
  private PrivateAlbumItem HOw;
  c HOx;
  ImageFolderMgrView.b HOy;
  boolean qv;
  
  public ImageFolderMgrView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(111536);
    this.HOo = null;
    this.qv = false;
    this.HOt = false;
    this.HOv = new LinkedList();
    this.HOw = null;
    setOrientation(1);
    this.HOp = new FrameLayout(getContext());
    paramContext = new LinearLayout.LayoutParams(-1, -1);
    this.HOp.setVisibility(8);
    addView(this.HOp, paramContext);
    this.HOq = new View(getContext());
    this.HOq.setBackgroundColor(-872415232);
    this.HOq.setOnClickListener(new ImageFolderMgrView.3(this));
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    this.HOp.addView(this.HOq, paramContext);
    paramContext = new RoundedCornerFrameLayout(getContext());
    paramContext.A(0.0F, 0.0F, bd.fromDPToPix(getContext(), 8), bd.fromDPToPix(getContext(), 8));
    paramAttributeSet = new FrameLayout.LayoutParams(-1, -2);
    paramAttributeSet.bottomMargin = getResources().getDimensionPixelSize(b.c.gallery_bottom_margin);
    paramAttributeSet.gravity = 48;
    this.HOp.addView(paramContext, paramAttributeSet);
    this.HOr = new ListView(getContext());
    this.HOr.setCacheColorHint(0);
    this.HOr.setOnItemClickListener(this);
    paramAttributeSet = new RelativeLayout.LayoutParams(-1, -2);
    paramContext.addView(this.HOr, paramAttributeSet);
    this.HOs = new b(getContext());
    this.HOr.setAdapter(this.HOs);
    this.HOu = new l.a()
    {
      public final void bm(LinkedList<GalleryItem.AlbumItem> paramAnonymousLinkedList)
      {
        AppMethodBeat.i(173780);
        Object localObject;
        if (paramAnonymousLinkedList != null)
        {
          localObject = Integer.valueOf(paramAnonymousLinkedList.size());
          Log.i("MicroMsg.ImageFolderMgrView", "onGetPrivateAlbum, %s.", new Object[] { localObject });
          e.fAn().c(ImageFolderMgrView.c(ImageFolderMgrView.this));
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
            if ((localObject instanceof PrivateAlbumItem))
            {
              localObject = (PrivateAlbumItem)localObject;
              t.b localb = ((PrivateAlbumItem)localObject).HIp.HIB;
              if (localb == null) {}
              for (boolean bool = false;; bool = localb.HIE)
              {
                if (!bool) {
                  break label139;
                }
                ImageFolderMgrView.a(ImageFolderMgrView.this, (PrivateAlbumItem)localObject);
                break label61;
                localObject = "res is null.";
                break;
              }
              label139:
              ImageFolderMgrView.d(ImageFolderMgrView.this).add(localObject);
            }
          }
          label154:
          Log.i("MicroMsg.ImageFolderMgrView", "filter res: %s.", new Object[] { Integer.valueOf(ImageFolderMgrView.d(ImageFolderMgrView.this).size()) });
          if ((!ImageFolderMgrView.this.isInLayout()) && ((ImageFolderMgrView.e(ImageFolderMgrView.this) != null) || (ImageFolderMgrView.d(ImageFolderMgrView.this).size() > 0))) {
            e.fAo().postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(173779);
                ImageFolderMgrView.f(ImageFolderMgrView.this).a(ImageFolderMgrView.e(ImageFolderMgrView.this), ImageFolderMgrView.d(ImageFolderMgrView.this));
                ImageFolderMgrView.a(ImageFolderMgrView.this, null);
                ImageFolderMgrView.d(ImageFolderMgrView.this).clear();
                ImageFolderMgrView.f(ImageFolderMgrView.this).notifyDataSetChanged();
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
        Log.i("MicroMsg.ImageFolderMgrView", "onPreDraw.");
        if ((ImageFolderMgrView.e(ImageFolderMgrView.this) != null) || (ImageFolderMgrView.d(ImageFolderMgrView.this).size() > 0))
        {
          e.fAo().postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(179468);
              ImageFolderMgrView.f(ImageFolderMgrView.this).a(ImageFolderMgrView.e(ImageFolderMgrView.this), ImageFolderMgrView.d(ImageFolderMgrView.this));
              ImageFolderMgrView.a(ImageFolderMgrView.this, null);
              ImageFolderMgrView.d(ImageFolderMgrView.this).clear();
              ImageFolderMgrView.f(ImageFolderMgrView.this).notifyDataSetChanged();
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
  
  private void fBD()
  {
    AppMethodBeat.i(111539);
    this.HOt = true;
    this.HOp.setVisibility(0);
    Object localObject = new AlphaAnimation(0.0F, 1.0F);
    ((AlphaAnimation)localObject).setDuration(300L);
    this.HOq.startAnimation((Animation)localObject);
    localObject = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, -1.0F, 1, 0.0F);
    ((TranslateAnimation)localObject).setDuration(300L);
    ((TranslateAnimation)localObject).setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(111530);
        ImageFolderMgrView.a(ImageFolderMgrView.this, true);
        ImageFolderMgrView.a(ImageFolderMgrView.this);
        if (ImageFolderMgrView.this.HOx != null) {
          ImageFolderMgrView.this.HOx.vV(true);
        }
        AppMethodBeat.o(111530);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    this.HOr.startAnimation((Animation)localObject);
    AppMethodBeat.o(111539);
  }
  
  private void fBE()
  {
    AppMethodBeat.i(111540);
    this.HOt = true;
    Object localObject = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, -1.0F);
    ((TranslateAnimation)localObject).setDuration(300L);
    ((TranslateAnimation)localObject).setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(111531);
        ImageFolderMgrView.b(ImageFolderMgrView.this).setVisibility(8);
        ImageFolderMgrView.a(ImageFolderMgrView.this, false);
        ImageFolderMgrView.a(ImageFolderMgrView.this);
        if (ImageFolderMgrView.this.HOx != null) {
          ImageFolderMgrView.this.HOx.vV(false);
        }
        AppMethodBeat.o(111531);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    this.HOr.startAnimation((Animation)localObject);
    localObject = new AlphaAnimation(1.0F, 0.0F);
    ((AlphaAnimation)localObject).setFillAfter(true);
    ((AlphaAnimation)localObject).setDuration(300L);
    this.HOq.startAnimation((Animation)localObject);
    AppMethodBeat.o(111540);
  }
  
  private void vX(boolean paramBoolean)
  {
    AppMethodBeat.i(111538);
    if (this.qv == paramBoolean)
    {
      Log.d("MicroMsg.ImageFolderMgrView", "want to expand, but same status, expanded %B", new Object[] { Boolean.valueOf(this.qv) });
      AppMethodBeat.o(111538);
      return;
    }
    if (this.HOt)
    {
      Log.d("MicroMsg.ImageFolderMgrView", "want to expand[%B], but now in animation", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(111538);
      return;
    }
    if (this.qv)
    {
      fBE();
      AppMethodBeat.o(111538);
      return;
    }
    fBD();
    AppMethodBeat.o(111538);
  }
  
  public final void bm(LinkedList<GalleryItem.AlbumItem> paramLinkedList)
  {
    AppMethodBeat.i(111541);
    Log.i("MicroMsg.ImageFolderMgrView", "onQueryAlbumFinished, %s, size: %s.", new Object[] { this, Integer.valueOf(paramLinkedList.size()) });
    e.fAn().b(this);
    final LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      GalleryItem.AlbumItem localAlbumItem = (GalleryItem.AlbumItem)paramLinkedList.next();
      if (y.ZC(localAlbumItem.bud())) {
        localLinkedList.add(localAlbumItem);
      }
    }
    e.fAo().postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179470);
        ImageFolderMgrView.f(ImageFolderMgrView.this).HNF = localLinkedList;
        ImageFolderMgrView.f(ImageFolderMgrView.this).notifyDataSetChanged();
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
  
  public final void fBC()
  {
    AppMethodBeat.i(111537);
    if (!this.qv) {}
    for (boolean bool = true;; bool = false)
    {
      vX(bool);
      this.HOs.fBA();
      AppMethodBeat.o(111537);
      return;
    }
  }
  
  public String getSelectedAlbumName()
  {
    return this.HOs.HNG;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(111542);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramAdapterView);
    localb.cH(paramView);
    localb.sc(paramInt);
    localb.hB(paramLong);
    a.c("com/tencent/mm/plugin/gallery/ui/ImageFolderMgrView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
    paramAdapterView = this.HOs.WJ(paramInt);
    if (paramAdapterView == null)
    {
      Log.d("MicroMsg.ImageFolderMgrView", "get folder failed:".concat(String.valueOf(paramInt)));
      a.a(this, "com/tencent/mm/plugin/gallery/ui/ImageFolderMgrView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(111542);
      return;
    }
    vX(false);
    if (this.HOo != null) {
      this.HOo.b(paramAdapterView);
    }
    this.HOs.HNG = Util.nullAs(paramAdapterView.albumName, "");
    this.HOs.notifyDataSetChanged();
    a.a(this, "com/tencent/mm/plugin/gallery/ui/ImageFolderMgrView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(111542);
  }
  
  public void setFavItemCount(int paramInt)
  {
    AppMethodBeat.i(111543);
    this.HOs.HNH = paramInt;
    d locald = new d((byte)0);
    locald.HNp = new WeakReference(this.HOs);
    e.fAo().postToMainThread(locald);
    AppMethodBeat.o(111543);
  }
  
  public void setFolderAlbumDialogDismiss(ImageFolderMgrView.b paramb)
  {
    this.HOy = paramb;
  }
  
  public void setListener(a parama)
  {
    this.HOo = parama;
  }
  
  public void setOnFolderStateChanged(c paramc)
  {
    this.HOx = paramc;
  }
  
  public static abstract interface a
  {
    public abstract void b(GalleryItem.AlbumItem paramAlbumItem);
  }
  
  public static abstract interface c
  {
    public abstract void vV(boolean paramBoolean);
  }
  
  static final class d
    implements Runnable
  {
    WeakReference<b> HNp;
    
    public final void run()
    {
      AppMethodBeat.i(111535);
      if (this.HNp != null)
      {
        b localb = (b)this.HNp.get();
        if (localb != null) {
          localb.notifyDataSetChanged();
        }
      }
      AppMethodBeat.o(111535);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImageFolderMgrView
 * JD-Core Version:    0.7.0.1
 */