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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.vfs.s;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;

public class ImageFolderMgrView
  extends LinearLayout
  implements AdapterView.OnItemClickListener, i.a
{
  boolean jT;
  private a xpR;
  FrameLayout xpS;
  private View xpT;
  private ListView xpU;
  private b xpV;
  boolean xpW;
  i.a xpX;
  private LinkedList<GalleryItem.PrivateAlbumItem> xpY;
  private GalleryItem.PrivateAlbumItem xpZ;
  b xqa;
  
  public ImageFolderMgrView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(111536);
    this.xpR = null;
    this.jT = false;
    this.xpW = false;
    this.xpY = new LinkedList();
    this.xpZ = null;
    setOrientation(1);
    this.xpS = new FrameLayout(getContext());
    paramContext = new LinearLayout.LayoutParams(-1, -1);
    this.xpS.setVisibility(8);
    addView(this.xpS, paramContext);
    this.xpT = new View(getContext());
    this.xpT.setBackgroundColor(-872415232);
    this.xpT.setOnClickListener(new ImageFolderMgrView.3(this));
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    this.xpS.addView(this.xpT, paramContext);
    paramContext = new RoundedCornerFrameLayout(getContext());
    paramContext.s(0.0F, 0.0F, at.fromDPToPix(getContext(), 8), at.fromDPToPix(getContext(), 8));
    paramAttributeSet = new FrameLayout.LayoutParams(-1, -2);
    paramAttributeSet.bottomMargin = getResources().getDimensionPixelSize(2131166486);
    paramAttributeSet.gravity = 48;
    this.xpS.addView(paramContext, paramAttributeSet);
    this.xpU = new ListView(getContext());
    this.xpU.setCacheColorHint(0);
    this.xpU.setOnItemClickListener(this);
    paramAttributeSet = new RelativeLayout.LayoutParams(-1, -2);
    paramContext.addView(this.xpU, paramAttributeSet);
    this.xpV = new b(getContext());
    this.xpU.setAdapter(this.xpV);
    this.xpX = new i.a()
    {
      public final void aL(LinkedList<GalleryItem.AlbumItem> paramAnonymousLinkedList)
      {
        AppMethodBeat.i(173780);
        Object localObject;
        if (paramAnonymousLinkedList != null)
        {
          localObject = Integer.valueOf(paramAnonymousLinkedList.size());
          Log.i("MicroMsg.ImageFolderMgrView", "onGetPrivateAlbum, %s.", new Object[] { localObject });
          e.dQK().c(ImageFolderMgrView.d(ImageFolderMgrView.this));
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
              s.b localb = ((GalleryItem.PrivateAlbumItem)localObject).xjf.xjN;
              if (localb == null) {}
              for (boolean bool = false;; bool = localb.xjQ)
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
          Log.i("MicroMsg.ImageFolderMgrView", "filter res: %s.", new Object[] { Integer.valueOf(ImageFolderMgrView.e(ImageFolderMgrView.this).size()) });
          if ((!ImageFolderMgrView.this.isInLayout()) && ((ImageFolderMgrView.f(ImageFolderMgrView.this) != null) || (ImageFolderMgrView.e(ImageFolderMgrView.this).size() > 0))) {
            e.dQL().postToMainThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(173779);
                ImageFolderMgrView.g(ImageFolderMgrView.this).a(ImageFolderMgrView.f(ImageFolderMgrView.this), ImageFolderMgrView.e(ImageFolderMgrView.this));
                ImageFolderMgrView.a(ImageFolderMgrView.this, null);
                ImageFolderMgrView.e(ImageFolderMgrView.this).clear();
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
        Log.i("MicroMsg.ImageFolderMgrView", "onPreDraw.");
        if ((ImageFolderMgrView.f(ImageFolderMgrView.this) != null) || (ImageFolderMgrView.e(ImageFolderMgrView.this).size() > 0))
        {
          e.dQL().postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(179468);
              ImageFolderMgrView.g(ImageFolderMgrView.this).a(ImageFolderMgrView.f(ImageFolderMgrView.this), ImageFolderMgrView.e(ImageFolderMgrView.this));
              ImageFolderMgrView.a(ImageFolderMgrView.this, null);
              ImageFolderMgrView.e(ImageFolderMgrView.this).clear();
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
  
  private void dSh()
  {
    AppMethodBeat.i(111539);
    this.xpW = true;
    this.xpS.setVisibility(0);
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772059);
    this.xpT.startAnimation(localAnimation);
    localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772129);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(111530);
        ImageFolderMgrView.a(ImageFolderMgrView.this, true);
        ImageFolderMgrView.a(ImageFolderMgrView.this);
        if (ImageFolderMgrView.this.xqa != null) {
          ImageFolderMgrView.this.xqa.pB(true);
        }
        AppMethodBeat.o(111530);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    this.xpU.startAnimation(localAnimation);
    AppMethodBeat.o(111539);
  }
  
  private void dSi()
  {
    AppMethodBeat.i(111540);
    this.xpW = true;
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772133);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(111531);
        ImageFolderMgrView.b(ImageFolderMgrView.this).setVisibility(8);
        ImageFolderMgrView.a(ImageFolderMgrView.this, false);
        ImageFolderMgrView.a(ImageFolderMgrView.this);
        if (ImageFolderMgrView.this.xqa != null) {
          ImageFolderMgrView.this.xqa.pB(false);
        }
        AppMethodBeat.o(111531);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    this.xpU.startAnimation(localAnimation);
    localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772060);
    this.xpT.startAnimation(localAnimation);
    AppMethodBeat.o(111540);
  }
  
  private void pD(boolean paramBoolean)
  {
    AppMethodBeat.i(111538);
    if (this.jT == paramBoolean)
    {
      Log.d("MicroMsg.ImageFolderMgrView", "want to expand, but same status, expanded %B", new Object[] { Boolean.valueOf(this.jT) });
      AppMethodBeat.o(111538);
      return;
    }
    if (this.xpW)
    {
      Log.d("MicroMsg.ImageFolderMgrView", "want to expand[%B], but now in animation", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(111538);
      return;
    }
    if (this.jT)
    {
      dSi();
      AppMethodBeat.o(111538);
      return;
    }
    dSh();
    AppMethodBeat.o(111538);
  }
  
  public final void aL(LinkedList<GalleryItem.AlbumItem> paramLinkedList)
  {
    AppMethodBeat.i(111541);
    Log.i("MicroMsg.ImageFolderMgrView", "onQueryAlbumFinished, %s, size: %s.", new Object[] { this, Integer.valueOf(paramLinkedList.size()) });
    e.dQK().b(this);
    final LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      GalleryItem.AlbumItem localAlbumItem = (GalleryItem.AlbumItem)paramLinkedList.next();
      if (s.YS(localAlbumItem.aQn())) {
        localLinkedList.add(localAlbumItem);
      }
    }
    e.dQL().postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(179470);
        ImageFolderMgrView.g(ImageFolderMgrView.this).xpj = localLinkedList;
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
  
  public final void dSg()
  {
    AppMethodBeat.i(111537);
    if (!this.jT) {}
    for (boolean bool = true;; bool = false)
    {
      pD(bool);
      AppMethodBeat.o(111537);
      return;
    }
  }
  
  public String getSelectedAlbumName()
  {
    return this.xpV.xpk;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(111542);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramAdapterView);
    localb.bm(paramView);
    localb.pH(paramInt);
    localb.zo(paramLong);
    a.b("com/tencent/mm/plugin/gallery/ui/ImageFolderMgrView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
    paramAdapterView = this.xpV.NN(paramInt);
    if (paramAdapterView == null)
    {
      Log.d("MicroMsg.ImageFolderMgrView", "get folder failed:".concat(String.valueOf(paramInt)));
      a.a(this, "com/tencent/mm/plugin/gallery/ui/ImageFolderMgrView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(111542);
      return;
    }
    this.xpT.performClick();
    if (this.xpR != null) {
      this.xpR.c(paramAdapterView);
    }
    this.xpV.xpk = Util.nullAs(paramAdapterView.albumName, "");
    this.xpV.notifyDataSetChanged();
    a.a(this, "com/tencent/mm/plugin/gallery/ui/ImageFolderMgrView", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(111542);
  }
  
  public void setFavItemCount(int paramInt)
  {
    AppMethodBeat.i(111543);
    this.xpV.xpl = paramInt;
    c localc = new c((byte)0);
    localc.xoS = new WeakReference(this.xpV);
    e.dQL().postToMainThread(localc);
    AppMethodBeat.o(111543);
  }
  
  public void setListener(a parama)
  {
    this.xpR = parama;
  }
  
  public void setOnFolderStateChanged(b paramb)
  {
    this.xqa = paramb;
  }
  
  public static abstract interface a
  {
    public abstract void c(GalleryItem.AlbumItem paramAlbumItem);
  }
  
  public static abstract interface b
  {
    public abstract void pB(boolean paramBoolean);
  }
  
  static final class c
    implements Runnable
  {
    WeakReference<b> xoS;
    
    public final void run()
    {
      AppMethodBeat.i(111535);
      if (this.xoS != null)
      {
        b localb = (b)this.xoS.get();
        if (localb != null) {
          localb.notifyDataSetChanged();
        }
      }
      AppMethodBeat.o(111535);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.ImageFolderMgrView
 * JD-Core Version:    0.7.0.1
 */