package com.tencent.mm.bt;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import com.tencent.mm.api.m;
import com.tencent.mm.api.p;
import com.tencent.mm.api.q.a;
import com.tencent.mm.bo.a.e;
import com.tencent.mm.cache.ArtistCacheManager;
import com.tencent.mm.cache.ArtistCacheManager.a;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  implements b
{
  q.a buT;
  LinkedList<com.tencent.mm.e.b> soA;
  private com.tencent.mm.api.f soB;
  Bitmap soC;
  private boolean soD = true;
  com.tencent.mm.api.d soE = com.tencent.mm.api.d.buK;
  com.tencent.mm.api.d soF = com.tencent.mm.api.d.buK;
  com.tencent.mm.e.b soG = null;
  com.tencent.mm.view.a soy;
  HashMap<com.tencent.mm.api.d, com.tencent.mm.e.b> soz;
  
  private void coL()
  {
    this.soA.clear();
    this.soz.clear();
    this.soz.put(com.tencent.mm.api.d.buK, com.tencent.mm.e.b.bAa);
    com.tencent.mm.api.d[] arrayOfd = this.soy.getFeatures();
    int k = arrayOfd.length;
    int i = 0;
    Object localObject2;
    Object localObject1;
    int j;
    if (i < k)
    {
      com.tencent.mm.api.d locald = arrayOfd[i];
      localObject2 = null;
      Iterator localIterator = null;
      localObject1 = localIterator;
      switch (a.7.soJ[locald.ordinal()])
      {
      default: 
      case 6: 
      case 4: 
        for (localObject1 = localIterator;; localObject1 = new com.tencent.mm.e.d())
        {
          if (localObject1 != null)
          {
            if (!this.soz.containsKey(locald)) {
              this.soz.put(locald, localObject1);
            }
            if (!this.soA.contains(localObject1))
            {
              this.soA.add(localObject1);
              ((com.tencent.mm.e.b)localObject1).a(this, this.soy.getBaseBoardView().getMainMatrix(), this.soy.getBaseBoardView().getAliveRect());
            }
          }
          i += 1;
          break;
        }
      case 1: 
      case 2: 
        localIterator = this.soA.iterator();
        while (localIterator.hasNext())
        {
          localObject1 = (com.tencent.mm.e.b)localIterator.next();
          if (((com.tencent.mm.e.b)localObject1).tG() == com.tencent.mm.e.a.bzR) {
            j = 1;
          }
        }
      }
    }
    while (j == 0)
    {
      localObject1 = new com.tencent.mm.e.e();
      ((com.tencent.mm.e.e)localObject1).bBg = new a.a(this);
      break;
      localObject1 = new com.tencent.mm.e.f();
      break;
      localObject1 = new com.tencent.mm.e.c();
      break;
      Collections.sort(this.soA, new a.2(this));
      y.i("MicroMsg.DrawingPresenter", "[addArtists] count:%s", new Object[] { Integer.valueOf(this.soz.size() - 1) });
      return;
      j = 0;
      localObject1 = localObject2;
    }
  }
  
  public final boolean A(MotionEvent paramMotionEvent)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (coI().tG() != com.tencent.mm.e.a.bzS)
    {
      if (coI().tG() == com.tencent.mm.e.a.bzT) {
        bool2 = bool1;
      }
    }
    else
    {
      if (bool2) {
        return bool2;
      }
      this.soG = ((com.tencent.mm.e.b)this.soz.get(this.soy.getBaseFooterView().getCurFeatureType()));
      localObject = this.soA.iterator();
      com.tencent.mm.e.b localb;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localb = (com.tencent.mm.e.b)((Iterator)localObject).next();
      } while ((localb.tG() == com.tencent.mm.e.a.bzR) || (!localb.m(paramMotionEvent)));
      return true;
    }
    Object localObject = null;
    if (this.soz.containsKey(com.tencent.mm.api.d.buM)) {
      localObject = (com.tencent.mm.e.b)this.soz.get(com.tencent.mm.api.d.buM);
    }
    for (;;)
    {
      bool1 = bool3;
      if (localObject != null) {
        bool1 = ((com.tencent.mm.e.b)localObject).m(paramMotionEvent);
      }
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      this.soG = ((com.tencent.mm.e.b)localObject);
      bool2 = bool1;
      break;
      if (this.soz.containsKey(com.tencent.mm.api.d.buN)) {
        localObject = (com.tencent.mm.e.b)this.soz.get(com.tencent.mm.api.d.buN);
      }
    }
    return bool2;
  }
  
  public final com.tencent.mm.cache.d a(com.tencent.mm.e.a parama)
  {
    return ArtistCacheManager.wL().a(parama);
  }
  
  public final void a(Editable paramEditable, int paramInt1, int paramInt2)
  {
    mi(false);
    this.soy.setFooterVisible(true);
    Object localObject = coI();
    EditText localEditText;
    if (((com.tencent.mm.e.b)localObject).tG() == com.tencent.mm.e.a.bzR)
    {
      localObject = (com.tencent.mm.e.e)localObject;
      localEditText = (EditText)this.soy.getTextEditView().findViewById(a.e.text_edit);
      if ((localEditText.getTag() == null) || (!(localEditText.getTag() instanceof com.tencent.mm.z.e))) {
        break label107;
      }
      ((com.tencent.mm.e.e)localObject).a((com.tencent.mm.z.e)localEditText.getTag(), com.tencent.mm.pluginsdk.ui.d.j.b(this.soy.getContext(), paramEditable), paramInt1, paramInt2);
    }
    for (;;)
    {
      localEditText.setTag(null);
      return;
      label107:
      ((com.tencent.mm.e.e)localObject).a(com.tencent.mm.pluginsdk.ui.d.j.b(this.soy.getContext(), paramEditable), paramInt1, paramInt2);
    }
  }
  
  public final void a(m paramm, boolean paramBoolean)
  {
    com.tencent.mm.sdk.f.e.post(new a.b(this, paramm, paramBoolean), "onFinalGenerate");
  }
  
  public final void a(q.a parama)
  {
    int i = 1;
    this.buT = parama;
    this.soz = new HashMap();
    this.soA = new LinkedList();
    String str = parama.path;
    if ((bk.bl(str)) || (!new File(str).exists())) {
      y.w("MicroMsg.DrawingPresenter", "[checkImage] path:%s", new Object[] { str });
    }
    for (i = 0;; i = 0)
    {
      BitmapFactory.Options localOptions;
      do
      {
        if (i != 0) {
          this.soC = com.tencent.mm.sdk.platformtools.c.k(bk.aM(parama.path, ""), 1280, 1280, 0);
        }
        coL();
        return;
        localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, localOptions);
      } while ((localOptions.outWidth > 0) && (localOptions.outHeight > 0));
      y.e("MicroMsg.DrawingPresenter", "[checkImage] image err! w:%s h:%s path:%s", new Object[] { Integer.valueOf(localOptions.outWidth), Integer.valueOf(localOptions.outHeight), str });
    }
  }
  
  public final void a(com.tencent.mm.view.a parama)
  {
    this.soy = parama;
  }
  
  public final <T extends com.tencent.mm.e.b> T b(com.tencent.mm.api.d paramd)
  {
    return (com.tencent.mm.e.b)this.soz.get(paramd);
  }
  
  public final void coG()
  {
    this.soy.setFooterVisible(true);
    mi(false);
  }
  
  public final com.tencent.mm.view.a coH()
  {
    return this.soy;
  }
  
  public final <T extends com.tencent.mm.e.b> T coI()
  {
    if (this.soG != null) {
      return this.soG;
    }
    y.e("MicroMsg.DrawingPresenter", "[getCurArtist] is null!");
    return com.tencent.mm.e.b.bAa;
  }
  
  public final Bitmap coJ()
  {
    return this.soC;
  }
  
  public final boolean coK()
  {
    return (coI().tG() != com.tencent.mm.e.a.bzS) && (this.soD);
  }
  
  public final void d(com.tencent.mm.api.j paramj)
  {
    ((com.tencent.mm.e.e)b(com.tencent.mm.api.d.buN)).b(paramj);
  }
  
  public final q.a getConfig()
  {
    return this.buT;
  }
  
  public final Context getContext()
  {
    return this.soy.getContext();
  }
  
  public final float getCurScale()
  {
    return this.soy.getBaseBoardView().getCurScale();
  }
  
  public final com.tencent.mm.api.d[] getFeatures()
  {
    return this.soy.getFeatures();
  }
  
  public final float getInitScale()
  {
    return this.soy.getBaseBoardView().getInitScale();
  }
  
  public final p getSelectedFeatureListener()
  {
    return new a.1(this);
  }
  
  final void mi(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localAnimation = AnimationUtils.loadAnimation(this.soy.getContext(), com.tencent.mm.bo.a.a.push_up_in);
      localAnimation.setAnimationListener(new a.3(this));
      this.soy.getTextEditView().startAnimation(localAnimation);
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(this.soy.getContext(), com.tencent.mm.bo.a.a.push_down_out);
    localAnimation.setAnimationListener(new a.4(this));
    this.soy.getTextEditView().startAnimation(localAnimation);
  }
  
  public final void onAttachedToWindow()
  {
    y.i("MicroMsg.DrawingPresenter", "[onAttachedToWindow]");
    Iterator localIterator = this.soA.iterator();
    label125:
    while (localIterator.hasNext())
    {
      com.tencent.mm.e.b localb = (com.tencent.mm.e.b)localIterator.next();
      ArtistCacheManager localArtistCacheManager = ArtistCacheManager.wL();
      com.tencent.mm.e.a locala = localb.tG();
      if ((ArtistCacheManager.dkQ.containsKey(localArtistCacheManager.dkS)) && (((ArtistCacheManager.a)ArtistCacheManager.dkQ.get(localArtistCacheManager.dkS)).dkV.containsKey(locala))) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label125;
        }
        localb.tJ();
        localb.aS(true);
        y.i("MicroMsg.DrawingPresenter", "[onAttachedToWindow] %s is revert onAlive!", new Object[] { localb.tG() });
        break;
      }
    }
    if (this.soy.getBaseBoardView().cLB())
    {
      this.soy.getBaseBoardView().cLC();
      this.soy.getBaseBoardView().invalidate();
    }
  }
  
  public final void onDestroy()
  {
    Iterator localIterator = this.soA.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.e.b)localIterator.next()).onDestroy();
    }
    this.soA.clear();
    this.soz.clear();
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    Iterator localIterator = this.soA.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.e.b localb = (com.tencent.mm.e.b)localIterator.next();
      if (localb.isAlive()) {
        if (coI().tG() == localb.tG())
        {
          localb.onDraw(paramCanvas);
        }
        else
        {
          paramCanvas.save();
          paramCanvas.clipRect(this.soy.getBaseBoardView().getAliveRect());
          localb.b(paramCanvas);
          paramCanvas.restore();
        }
      }
    }
  }
  
  public final void onFinish()
  {
    if (this.soB != null) {
      this.soB.onFinish();
    }
  }
  
  public final boolean rG()
  {
    if (this.soy.getTextEditView().getVisibility() == 0)
    {
      mi(false);
      this.soy.setFooterVisible(true);
      return true;
    }
    if ((this.soy.getChatFooterPanel() != null) && (this.soy.getChatFooterPanel().getVisibility() == 0))
    {
      this.soy.od(true);
      this.soy.setFooterVisible(true);
      return true;
    }
    return false;
  }
  
  public final void rX()
  {
    if (this.soB != null) {
      this.soB.rX();
    }
  }
  
  public final void setActionBarCallback(com.tencent.mm.api.f paramf)
  {
    this.soB = paramf;
  }
  
  public final void setAutoShowFooterAndBar(boolean paramBoolean)
  {
    this.soD = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.bt.a
 * JD-Core Version:    0.7.0.1
 */