package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.tencent.mm.plugin.gallery.model.GalleryItem.AlbumItem;
import com.tencent.mm.plugin.gallery.model.GalleryItem.PrivateAlbumItem;
import com.tencent.mm.plugin.gallery.model.e;
import com.tencent.mm.plugin.gallery.model.g;
import com.tencent.mm.plugin.gallery.model.i.a;
import com.tencent.mm.plugin.gallery.model.o;
import com.tencent.mm.plugin.gallery.model.s.a;
import com.tencent.mm.plugin.gallery.model.s.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import com.tencent.mm.vfs.i;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;

public class ImageFolderMgrView
  extends LinearLayout
  implements AdapterView.OnItemClickListener, i.a
{
  boolean hW;
  private a sRj;
  FrameLayout sRk;
  private View sRl;
  private ListView sRm;
  private b sRn;
  boolean sRo;
  i.a sRp;
  private LinkedList<GalleryItem.PrivateAlbumItem> sRq;
  private GalleryItem.PrivateAlbumItem sRr;
  b sRs;
  
  public ImageFolderMgrView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(111536);
    this.sRj = null;
    this.hW = false;
    this.sRo = false;
    this.sRq = new LinkedList();
    this.sRr = null;
    setOrientation(1);
    this.sRk = new FrameLayout(getContext());
    paramContext = new LinearLayout.LayoutParams(-1, -1);
    this.sRk.setVisibility(8);
    addView(this.sRk, paramContext);
    this.sRl = new View(getContext());
    this.sRl.setBackgroundColor(-872415232);
    this.sRl.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(111532);
        ImageFolderMgrView.c(ImageFolderMgrView.this);
        AppMethodBeat.o(111532);
      }
    });
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    this.sRk.addView(this.sRl, paramContext);
    paramContext = new RoundedCornerFrameLayout(getContext());
    paramContext.l(0.0F, 0.0F, ao.fromDPToPix(getContext(), 8), ao.fromDPToPix(getContext(), 8));
    paramAttributeSet = new FrameLayout.LayoutParams(-1, -2);
    paramAttributeSet.bottomMargin = getResources().getDimensionPixelSize(2131166394);
    paramAttributeSet.gravity = 48;
    this.sRk.addView(paramContext, paramAttributeSet);
    this.sRm = new ListView(getContext());
    this.sRm.setCacheColorHint(0);
    this.sRm.setOnItemClickListener(this);
    paramAttributeSet = new RelativeLayout.LayoutParams(-1, -2);
    paramContext.addView(this.sRm, paramAttributeSet);
    this.sRn = new b(getContext());
    this.sRm.setAdapter(this.sRn);
    this.sRp = new i.a()
    {
      public final void ao(LinkedList<GalleryItem.AlbumItem> paramAnonymousLinkedList)
      {
        AppMethodBeat.i(173780);
        Object localObject;
        if (paramAnonymousLinkedList != null)
        {
          localObject = Integer.valueOf(paramAnonymousLinkedList.size());
          ac.i("MicroMsg.ImageFolderMgrView", "onGetPrivateAlbum, %s.", new Object[] { localObject });
          e.cMt().c(ImageFolderMgrView.d(ImageFolderMgrView.this));
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
              s.b localb = ((GalleryItem.PrivateAlbumItem)localObject).sKq.sKZ;
              if (localb == null) {}
              for (boolean bool = false;; bool = localb.sLd)
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
          ac.i("MicroMsg.ImageFolderMgrView", "filter res: %s.", new Object[] { Integer.valueOf(ImageFolderMgrView.e(ImageFolderMgrView.this).size()) });
          if ((!ImageFolderMgrView.this.isInLayout()) && ((ImageFolderMgrView.f(ImageFolderMgrView.this) != null) || (ImageFolderMgrView.e(ImageFolderMgrView.this).size() > 0)))
          {
            ImageFolderMgrView.g(ImageFolderMgrView.this).a(ImageFolderMgrView.f(ImageFolderMgrView.this), ImageFolderMgrView.e(ImageFolderMgrView.this));
            ImageFolderMgrView.a(ImageFolderMgrView.this, null);
            ImageFolderMgrView.e(ImageFolderMgrView.this).clear();
            e.cMu().f(new Runnable()
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
        ac.i("MicroMsg.ImageFolderMgrView", "onPreDraw.");
        if ((ImageFolderMgrView.f(ImageFolderMgrView.this) != null) || (ImageFolderMgrView.e(ImageFolderMgrView.this).size() > 0))
        {
          ImageFolderMgrView.g(ImageFolderMgrView.this).a(ImageFolderMgrView.f(ImageFolderMgrView.this), ImageFolderMgrView.e(ImageFolderMgrView.this));
          ImageFolderMgrView.a(ImageFolderMgrView.this, null);
          ImageFolderMgrView.e(ImageFolderMgrView.this).clear();
          e.cMu().f(new Runnable()
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
  
  private void cNM()
  {
    AppMethodBeat.i(111539);
    this.sRo = true;
    this.sRk.setVisibility(0);
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772047);
    this.sRl.startAnimation(localAnimation);
    localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772105);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(111530);
        ImageFolderMgrView.a(ImageFolderMgrView.this, true);
        ImageFolderMgrView.a(ImageFolderMgrView.this);
        if (ImageFolderMgrView.this.sRs != null) {
          ImageFolderMgrView.this.sRs.my(true);
        }
        AppMethodBeat.o(111530);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    this.sRm.startAnimation(localAnimation);
    AppMethodBeat.o(111539);
  }
  
  private void cNN()
  {
    AppMethodBeat.i(111540);
    this.sRo = true;
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772109);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(111531);
        ImageFolderMgrView.b(ImageFolderMgrView.this).setVisibility(8);
        ImageFolderMgrView.a(ImageFolderMgrView.this, false);
        ImageFolderMgrView.a(ImageFolderMgrView.this);
        if (ImageFolderMgrView.this.sRs != null) {
          ImageFolderMgrView.this.sRs.my(false);
        }
        AppMethodBeat.o(111531);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    this.sRm.startAnimation(localAnimation);
    localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772048);
    this.sRl.startAnimation(localAnimation);
    AppMethodBeat.o(111540);
  }
  
  private void mA(boolean paramBoolean)
  {
    AppMethodBeat.i(111538);
    if (this.hW == paramBoolean)
    {
      ac.d("MicroMsg.ImageFolderMgrView", "want to expand, but same status, expanded %B", new Object[] { Boolean.valueOf(this.hW) });
      AppMethodBeat.o(111538);
      return;
    }
    if (this.sRo)
    {
      ac.d("MicroMsg.ImageFolderMgrView", "want to expand[%B], but now in animation", new Object[] { Boolean.valueOf(paramBoolean) });
      AppMethodBeat.o(111538);
      return;
    }
    if (this.hW)
    {
      cNN();
      AppMethodBeat.o(111538);
      return;
    }
    cNM();
    AppMethodBeat.o(111538);
  }
  
  public final void ao(LinkedList<GalleryItem.AlbumItem> paramLinkedList)
  {
    AppMethodBeat.i(111541);
    ac.i("MicroMsg.ImageFolderMgrView", "onQueryAlbumFinished, %s, size: %s.", new Object[] { this, Integer.valueOf(paramLinkedList.size()) });
    e.cMt().b(this);
    LinkedList localLinkedList = new LinkedList();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      GalleryItem.AlbumItem localAlbumItem = (GalleryItem.AlbumItem)paramLinkedList.next();
      if (i.eA(localAlbumItem.auN())) {
        localLinkedList.add(localAlbumItem);
      }
    }
    this.sRn.sQF = localLinkedList;
    e.cMu().f(new Runnable()
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
  
  public final void cNL()
  {
    AppMethodBeat.i(111537);
    if (!this.hW) {}
    for (boolean bool = true;; bool = false)
    {
      mA(bool);
      AppMethodBeat.o(111537);
      return;
    }
  }
  
  public String getSelectedAlbumName()
  {
    return this.sRn.sQG;
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(111542);
    paramAdapterView = this.sRn.Ga(paramInt);
    if (paramAdapterView == null)
    {
      ac.d("MicroMsg.ImageFolderMgrView", "get folder failed:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(111542);
      return;
    }
    this.sRl.performClick();
    if (this.sRj != null) {
      this.sRj.c(paramAdapterView);
    }
    this.sRn.sQG = bs.bG(paramAdapterView.sJZ, "");
    this.sRn.notifyDataSetChanged();
    AppMethodBeat.o(111542);
  }
  
  public void setFavItemCount(int paramInt)
  {
    AppMethodBeat.i(111543);
    this.sRn.sQH = paramInt;
    c localc = new c((byte)0);
    localc.sQo = new WeakReference(this.sRn);
    e.cMu().f(localc);
    AppMethodBeat.o(111543);
  }
  
  public void setListener(a parama)
  {
    this.sRj = parama;
  }
  
  public void setOnFolderStateChanged(b paramb)
  {
    this.sRs = paramb;
  }
  
  public static abstract interface a
  {
    public abstract void c(GalleryItem.AlbumItem paramAlbumItem);
  }
  
  public static abstract interface b
  {
    public abstract void my(boolean paramBoolean);
  }
  
  static final class c
    implements Runnable
  {
    WeakReference<b> sQo;
    
    public final void run()
    {
      AppMethodBeat.i(111535);
      if (this.sQo != null)
      {
        b localb = (b)this.sQo.get();
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