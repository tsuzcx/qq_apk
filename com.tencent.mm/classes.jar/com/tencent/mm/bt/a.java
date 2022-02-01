package com.tencent.mm.bt;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.Editable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.e.a;
import com.tencent.mm.api.aa;
import com.tencent.mm.api.ac.a;
import com.tencent.mm.api.ac.c;
import com.tencent.mm.api.k;
import com.tencent.mm.api.t;
import com.tencent.mm.api.w;
import com.tencent.mm.bo.a.e;
import com.tencent.mm.bo.a.g;
import com.tencent.mm.bo.a.h;
import com.tencent.mm.cache.ArtistCacheManager;
import com.tencent.mm.cache.ArtistCacheManager.a;
import com.tencent.mm.e.c;
import com.tencent.mm.e.c.10;
import com.tencent.mm.e.c.2;
import com.tencent.mm.e.c.7;
import com.tencent.mm.e.c.9;
import com.tencent.mm.e.d;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.bb;
import com.tencent.mm.vfs.y;
import com.tencent.mm.view.footer.SelectColorBar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  implements b
{
  private boolean GEW = true;
  private float YwA = -1.0F;
  public c YwB;
  com.tencent.mm.api.i YwC = com.tencent.mm.api.i.hdN;
  com.tencent.mm.api.i YwD = com.tencent.mm.api.i.hdN;
  private boolean YwE = false;
  private com.tencent.mm.e.b YwF = null;
  com.tencent.mm.view.a Ywu;
  private HashMap<com.tencent.mm.api.i, com.tencent.mm.e.b> Ywv;
  private LinkedList<com.tencent.mm.e.b> Yww;
  private k Ywx;
  Bitmap Ywy;
  private boolean Ywz = true;
  ac.a hdX;
  private int outputHeight = -1;
  private int outputWidth = -1;
  
  private void Ki(boolean paramBoolean)
  {
    AppMethodBeat.i(9320);
    if (paramBoolean)
    {
      localAnimation = AnimationUtils.loadAnimation(this.Ywu.getContext(), com.tencent.mm.bo.a.a.push_up_in);
      localAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(9283);
          a.this.Ywu.getTextEditView().setVisibility(0);
          paramAnonymousAnimation = (EditText)a.this.Ywu.getTextEditView().findViewById(a.e.text_edit);
          paramAnonymousAnimation.requestFocus();
          paramAnonymousAnimation.setSelection(paramAnonymousAnimation.length());
          a.this.Ywu.getSelectedFeatureListener().dP(true);
          ((SelectColorBar)a.this.Ywu.findViewById(a.e.select_color_bar)).setSelectColor(paramAnonymousAnimation.getCurrentTextColor());
          a.this.Ywu.getActionBar().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9282);
              a.this.Ywu.getActionBar().setVisibility(0);
              AppMethodBeat.o(9282);
            }
          });
          AppMethodBeat.o(9283);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      this.Ywu.getTextEditView().startAnimation(localAnimation);
      AppMethodBeat.o(9320);
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(this.Ywu.getContext(), com.tencent.mm.bo.a.a.push_down_out);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(9285);
        ((EditText)a.this.Ywu.getTextEditView().findViewById(a.e.text_edit)).setText("");
        a.this.Ywu.getTextEditView().setVisibility(8);
        AppMethodBeat.o(9285);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(9284);
        a.this.Ywu.getSelectedFeatureListener().dP(false);
        AppMethodBeat.o(9284);
      }
    });
    this.Ywu.getTextEditView().startAnimation(localAnimation);
    AppMethodBeat.o(9320);
  }
  
  private void iPw()
  {
    AppMethodBeat.i(9319);
    this.Yww.clear();
    this.Ywv.clear();
    this.Ywv.put(com.tencent.mm.api.i.hdN, com.tencent.mm.e.b.hoV);
    com.tencent.mm.api.i[] arrayOfi = this.Ywu.getFeatures();
    int k = arrayOfi.length;
    int i = 0;
    Object localObject2;
    Object localObject1;
    int j;
    if (i < k)
    {
      com.tencent.mm.api.i locali = arrayOfi[i];
      localObject2 = null;
      Iterator localIterator = null;
      localObject1 = localIterator;
      switch (7.YwI[locali.ordinal()])
      {
      default: 
      case 7: 
      case 4: 
        for (localObject1 = localIterator;; localObject1 = new d())
        {
          if (localObject1 != null)
          {
            if (!this.Ywv.containsKey(locali)) {
              this.Ywv.put(locali, localObject1);
            }
            if (!this.Yww.contains(localObject1))
            {
              this.Yww.add(localObject1);
              ((com.tencent.mm.e.b)localObject1).a(this, this.Ywu.getBaseBoardView().getMainMatrix(), this.Ywu.getBaseBoardView().getAliveRect());
            }
          }
          i += 1;
          break;
        }
      case 1: 
      case 2: 
        localIterator = this.Yww.iterator();
        while (localIterator.hasNext())
        {
          localObject1 = (com.tencent.mm.e.b)localIterator.next();
          if (((com.tencent.mm.e.b)localObject1).aEy() == com.tencent.mm.e.a.hoM) {
            j = 1;
          }
        }
      }
    }
    while (j == 0)
    {
      localObject1 = new com.tencent.mm.e.e();
      ((com.tencent.mm.e.e)localObject1).hqg = new a();
      break;
      localObject1 = new com.tencent.mm.e.h();
      break;
      localObject1 = new c();
      break;
      localObject1 = new com.tencent.mm.e.f();
      break;
      Collections.sort(this.Yww, new Comparator() {});
      Log.i("MicroMsg.DrawingPresenter", "[addArtists] count:%s", new Object[] { Integer.valueOf(this.Ywv.size() - 1) });
      AppMethodBeat.o(9319);
      return;
      j = 0;
      localObject1 = localObject2;
    }
  }
  
  public final boolean Z(MotionEvent paramMotionEvent)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    AppMethodBeat.i(9316);
    boolean bool1 = bool2;
    Object localObject;
    if (iPp().aEy() != com.tencent.mm.e.a.hoN)
    {
      if (iPp().aEy() == com.tencent.mm.e.a.hoO) {
        bool1 = bool2;
      }
    }
    else
    {
      if (bool1) {
        break label224;
      }
      this.YwF = ((com.tencent.mm.e.b)this.Ywv.get(this.Ywu.getBaseFooterView().getCurFeatureType()));
      localObject = this.Yww.iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.e.b localb = (com.tencent.mm.e.b)((Iterator)localObject).next();
        if ((localb.aEy() != com.tencent.mm.e.a.hoM) && (localb.onDispatchTouch(paramMotionEvent))) {
          bool1 = true;
        }
      }
    }
    label224:
    for (;;)
    {
      AppMethodBeat.o(9316);
      return bool1;
      localObject = null;
      if (this.Ywv.containsKey(com.tencent.mm.api.i.hdP)) {
        localObject = (com.tencent.mm.e.b)this.Ywv.get(com.tencent.mm.api.i.hdP);
      }
      for (;;)
      {
        bool2 = bool3;
        if (localObject != null) {
          bool2 = ((com.tencent.mm.e.b)localObject).onDispatchTouch(paramMotionEvent);
        }
        bool1 = bool2;
        if (!bool2) {
          break;
        }
        this.YwF = ((com.tencent.mm.e.b)localObject);
        bool1 = bool2;
        break;
        if (this.Ywv.containsKey(com.tencent.mm.api.i.hdQ)) {
          localObject = (com.tencent.mm.e.b)this.Ywv.get(com.tencent.mm.api.i.hdQ);
        }
      }
    }
  }
  
  public final com.tencent.mm.cache.f a(com.tencent.mm.e.a parama)
  {
    AppMethodBeat.i(9318);
    ArtistCacheManager localArtistCacheManager = ArtistCacheManager.aLv();
    String str = this.hdX.path;
    if (TextUtils.isEmpty(str))
    {
      if (ArtistCacheManager.lvF.containsKey(localArtistCacheManager.lvH))
      {
        parama = ((ArtistCacheManager.a)ArtistCacheManager.lvF.get(localArtistCacheManager.lvH)).c(parama);
        AppMethodBeat.o(9318);
        return parama;
      }
      Log.e("MicroMsg.ArtistCacheManager", "[getArtistCache] id is not contains! %s", new Object[] { localArtistCacheManager.lvH });
      AppMethodBeat.o(9318);
      return null;
    }
    if (ArtistCacheManager.lvF.containsKey(str))
    {
      parama = ((ArtistCacheManager.a)ArtistCacheManager.lvF.get(str)).c(parama);
      AppMethodBeat.o(9318);
      return parama;
    }
    Log.e("MicroMsg.ArtistCacheManager", "[getArtistCache] id is not contains! %s", new Object[] { str });
    AppMethodBeat.o(9318);
    return null;
  }
  
  public final void a(Editable paramEditable, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9303);
    if (paramEditable != null) {
      r(paramEditable.toString(), paramInt1, paramInt2, "");
    }
    AppMethodBeat.o(9303);
  }
  
  public final void a(ac.a parama)
  {
    AppMethodBeat.i(9297);
    this.hdX = parama;
    this.Ywv = new HashMap();
    this.Yww = new LinkedList();
    Object localObject = parama.path;
    int i;
    if ((Util.isNullOrNil((String)localObject)) || (!y.ZC((String)localObject)))
    {
      Log.w("MicroMsg.DrawingPresenter", "[checkImage] path:%s", new Object[] { localObject });
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        if (parama.hec)
        {
          this.Ywy = BitmapUtil.decodeFile(parama.path, null);
          if (this.Ywy != null)
          {
            BitmapUtil.drawBackgroundInNeed(this.Ywy, parama.path, -1);
            this.Ywy = this.Ywy.copy(Bitmap.Config.ARGB_8888, true);
          }
          iPw();
          AppMethodBeat.o(9297);
          return;
          BitmapFactory.Options localOptions = new BitmapFactory.Options();
          localOptions.inJustDecodeBounds = true;
          BitmapUtil.decodeFile((String)localObject, localOptions);
          if ((localOptions.outWidth <= 0) || (localOptions.outHeight <= 0))
          {
            Log.e("MicroMsg.DrawingPresenter", "[checkImage] image err! w:%s h:%s path:%s", new Object[] { Integer.valueOf(localOptions.outWidth), Integer.valueOf(localOptions.outHeight), localObject });
            i = 0;
          }
          else
          {
            i = 1;
          }
        }
        else
        {
          localObject = BitmapUtil.getImageOptions(Util.nullAs(parama.path, ""));
          if (localObject == null) {
            break label464;
          }
          int m = ((BitmapFactory.Options)localObject).outWidth;
          int k = ((BitmapFactory.Options)localObject).outHeight;
          double d = Math.sqrt(1638400.0D / (m * k));
          i = k;
          j = m;
          if (d <= 1.0D)
          {
            m = (int)(m * d);
            k = (int)(d * k);
            i = k;
            j = m;
            if (m < 1280)
            {
              i = k;
              j = m;
              if (k < 1280) {
                i = 1280;
              }
            }
          }
        }
      }
    }
    for (int j = 1280;; j = 1280)
    {
      this.Ywy = BitmapUtil.createThumbBitmap(Util.nullAs(parama.path, ""), i, j, true, false, -1);
      break;
      if (parama.hdZ == ac.c.heh)
      {
        this.Ywy = BitmapUtil.createColorBitmap(parama.backgroundColor, parama.hed.width(), parama.hed.height());
        break;
      }
      if (parama.bitmap != null)
      {
        this.Ywy = parama.bitmap;
        break;
      }
      if (this.Ywy != null) {
        break;
      }
      this.Ywy = BitmapUtil.createColorBitmap(0, 1280, 1280);
      break;
      label464:
      i = 1280;
    }
  }
  
  public final void a(w paramw, boolean paramBoolean)
  {
    AppMethodBeat.i(9309);
    ThreadPool.post(new b(paramw, paramBoolean), "onFinalGenerate_" + paramw.hashCode());
    AppMethodBeat.o(9309);
  }
  
  public final void a(com.tencent.mm.view.a parama)
  {
    this.Ywu = parama;
  }
  
  public final boolean aAx()
  {
    AppMethodBeat.i(9301);
    if (this.Ywu.getTextEditView().getVisibility() == 0)
    {
      Ki(false);
      this.Ywu.setFooterVisible(true);
      AppMethodBeat.o(9301);
      return true;
    }
    if ((this.Ywu.getChatFooterPanel() != null) && (this.Ywu.getChatFooterPanel().getVisibility() == 0))
    {
      this.Ywu.NY(true);
      this.Ywu.setFooterVisible(true);
      AppMethodBeat.o(9301);
      return true;
    }
    AppMethodBeat.o(9301);
    return false;
  }
  
  public final void aY(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(231254);
    r(paramString, paramInt1, paramInt2, "");
    AppMethodBeat.o(231254);
  }
  
  public final <T extends com.tencent.mm.e.b> T c(com.tencent.mm.api.i parami)
  {
    AppMethodBeat.i(9314);
    parami = (com.tencent.mm.e.b)this.Ywv.get(parami);
    AppMethodBeat.o(9314);
    return parami;
  }
  
  public final void d(t paramt)
  {
    AppMethodBeat.i(9315);
    com.tencent.mm.e.e locale = (com.tencent.mm.e.e)c(com.tencent.mm.api.i.hdQ);
    if (locale != null) {
      locale.b(paramt);
    }
    AppMethodBeat.o(9315);
  }
  
  public final void dG(float paramFloat)
  {
    this.YwA = paramFloat;
  }
  
  public final ac.a getConfig()
  {
    return this.hdX;
  }
  
  public final float getCurScale()
  {
    AppMethodBeat.i(9308);
    float f = this.Ywu.getBaseBoardView().getCurScale();
    AppMethodBeat.o(9308);
    return f;
  }
  
  public final com.tencent.mm.api.i[] getFeatures()
  {
    AppMethodBeat.i(9298);
    com.tencent.mm.api.i[] arrayOfi = this.Ywu.getFeatures();
    AppMethodBeat.o(9298);
    return arrayOfi;
  }
  
  public final float getInitScale()
  {
    AppMethodBeat.i(9307);
    float f = this.Ywu.getBaseBoardView().getInitScale();
    AppMethodBeat.o(9307);
    return f;
  }
  
  public final aa getSelectedFeatureListener()
  {
    AppMethodBeat.i(9299);
    aa local1 = new aa()
    {
      public final void a(com.tencent.mm.api.i paramAnonymousi)
      {
        AppMethodBeat.i(9279);
        Log.i("MicroMsg.DrawingPresenter", "[onSelectedFeature] features:%s", new Object[] { paramAnonymousi });
        if (paramAnonymousi == com.tencent.mm.api.i.hdN) {
          a.a(a.this).getBaseFooterView().setCurFeatureType(paramAnonymousi);
        }
        a.a(a.this).getBaseFooterView().jMZ();
        if (a.a(a.this).getSelectedFeatureListener() != null) {
          a.a(a.this).getSelectedFeatureListener().a(paramAnonymousi);
        }
        if (paramAnonymousi == com.tencent.mm.api.i.hdT) {
          a.this.Ywu.getFooterBg().setVisibility(8);
        }
        com.tencent.mm.e.b localb = (com.tencent.mm.e.b)a.b(a.this).get(paramAnonymousi);
        if (localb == null)
        {
          AppMethodBeat.o(9279);
          return;
        }
        if ((localb.feX) && (!localb.isAlive())) {
          localb.onAlive();
        }
        if (localb.aEy() != com.tencent.mm.e.a.hoJ) {
          localb.setOneFingerMoveEnable(false);
        }
        localb.aEB();
        a.a(a.this, localb);
        switch (a.7.YwI[paramAnonymousi.ordinal()])
        {
        default: 
          a.this.YwD = paramAnonymousi;
        }
        for (;;)
        {
          a.a(a.this).getBaseFooterView().setCurFeatureType(paramAnonymousi);
          AppMethodBeat.o(9279);
          return;
          if (!a.this.Ywu.getBaseFooterView().jMU())
          {
            ((EditText)a.this.Ywu.getTextEditView().findViewById(a.e.text_edit)).setTextColor(com.tencent.mm.view.footer.a.agLQ[0]);
            a.c(a.this);
            a.this.Ywu.setFooterVisible(false);
          }
          a.this.YwD = paramAnonymousi;
          continue;
          a.this.Ywu.setActionBarVisible(false);
          a.this.Ywu.setFooterVisible(false);
          a.this.Ywu.NY(false);
          break;
          a.this.YwC = a.this.YwD;
        }
      }
      
      public final void a(com.tencent.mm.api.i paramAnonymousi, int paramAnonymousInt, Object paramAnonymousObject)
      {
        AppMethodBeat.i(163137);
        Log.i("MicroMsg.DrawingPresenter", "[onSelectedDetailFeature] features:%s index:%s", new Object[] { paramAnonymousi, Integer.valueOf(paramAnonymousInt) });
        if (a.a(a.this).getSelectedFeatureListener() != null) {
          a.a(a.this).getSelectedFeatureListener().a(paramAnonymousi, paramAnonymousInt, paramAnonymousObject);
        }
        a.a(a.this, (com.tencent.mm.e.b)a.b(a.this).get(paramAnonymousi));
        if (a.this.iPp().aEy() == com.tencent.mm.e.a.hoJ)
        {
          AppMethodBeat.o(163137);
          return;
        }
        if (a.this.Ywu.getFooterBg().getVisibility() == 8) {
          a.this.Ywu.getFooterBg().setVisibility(0);
        }
        float f2;
        switch (a.7.YwI[paramAnonymousi.ordinal()])
        {
        default: 
          AppMethodBeat.o(163137);
          return;
        case 4: 
          paramAnonymousi = (d)a.this.iPp();
          if (paramAnonymousInt != -1)
          {
            paramAnonymousi.mColor = a.this.Ywu.getBaseFooterView().getColor(paramAnonymousInt);
            AppMethodBeat.o(163137);
            return;
          }
          paramAnonymousi.aEG();
          AppMethodBeat.o(163137);
          return;
        case 5: 
          paramAnonymousi = (com.tencent.mm.e.h)a.this.iPp();
          if (paramAnonymousInt == 0)
          {
            paramAnonymousi.hqt = e.a.mAw;
            AppMethodBeat.o(163137);
            return;
          }
          if (1 == paramAnonymousInt)
          {
            paramAnonymousi.hqt = e.a.mAx;
            AppMethodBeat.o(163137);
            return;
          }
          paramAnonymousi.aEG();
          AppMethodBeat.o(163137);
          return;
        case 3: 
          paramAnonymousi = (c)a.this.iPp();
          if (paramAnonymousInt == 0)
          {
            paramAnonymousi.hpF += 1;
            paramAnonymousi.hpp.cancel();
            if (paramAnonymousi.hpD != null) {
              paramAnonymousi.hpD.cancel();
            }
            paramAnonymousObject = new Matrix();
            paramAnonymousObject.postRotate(-90.0F, paramAnonymousi.hbZ.centerX(), paramAnonymousi.hbZ.centerY());
            if (paramAnonymousi.hpE.isEmpty()) {
              paramAnonymousi.hpE.set(paramAnonymousi.hbZ);
            }
            RectF localRectF = new RectF(paramAnonymousi.hpE);
            paramAnonymousObject.mapRect(localRectF);
            f1 = 1.0F * paramAnonymousi.hpl.width() / localRectF.width();
            f2 = 1.0F * paramAnonymousi.hpl.height() / localRectF.height();
            if (f1 < f2) {}
            for (;;)
            {
              paramAnonymousObject.postScale(f1, f1, paramAnonymousi.hbZ.centerX(), paramAnonymousi.hbZ.centerY());
              localRectF.set(paramAnonymousi.hpE);
              paramAnonymousObject.mapRect(localRectF);
              paramAnonymousi.hpE.set((int)localRectF.left, (int)localRectF.top, (int)localRectF.right, (int)localRectF.bottom);
              f2 = paramAnonymousi.hbZ.centerX();
              float f3 = paramAnonymousi.hbZ.centerY();
              paramAnonymousObject = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofInt("rotation", new int[] { 0, -90 }), PropertyValuesHolder.ofInt("deltaX", new int[] { 0, paramAnonymousi.hpl.centerX() - (int)f2 }), PropertyValuesHolder.ofInt("deltaY", new int[] { 0, paramAnonymousi.hpl.centerY() - (int)f3 }) });
              paramAnonymousObject.addUpdateListener(new c.10(paramAnonymousi, f2, f3, f1));
              paramAnonymousObject.addListener(new c.2(paramAnonymousi));
              paramAnonymousObject.setDuration(200L);
              paramAnonymousObject.start();
              AppMethodBeat.o(163137);
              return;
              f1 = f2;
            }
          }
          if (1 == paramAnonymousInt)
          {
            Log.i("MicroMsg.CropArtist", "[cancel]");
            paramAnonymousi.hpp.cancel();
            if (paramAnonymousi.hpD != null) {
              paramAnonymousi.hpD.cancel();
            }
            paramAnonymousi.hoR.iPo().getBaseBoardView().M(paramAnonymousi.hoR.iPo().getBaseBoardView().getRawBoardRect());
            if (paramAnonymousi.aEA() == null) {
              break label1244;
            }
            paramAnonymousObject = ((com.tencent.mm.cache.a)paramAnonymousi.aEA()).aLy();
            if (paramAnonymousObject == null) {
              break label1244;
            }
            f2 = paramAnonymousi.getRotation() - paramAnonymousi.d(paramAnonymousObject.avQ);
            f1 = f2;
            if (!paramAnonymousObject.Qv.isEmpty()) {
              paramAnonymousi.hoR.iPo().getBaseBoardView().N(paramAnonymousObject.Qv);
            }
          }
          break;
        }
        label1244:
        for (float f1 = f2;; f1 = 0.0F)
        {
          paramAnonymousi.hoR.iPo().getBaseBoardView().a(null, f1, true);
          paramAnonymousi.hoR.iPo().getActionBar().setVisibility(0);
          a.a(a.this, (com.tencent.mm.e.b)a.b(a.this).get(a.this.YwC));
          a.this.Ywu.getBaseFooterView().setCurFeatureType(a.this.YwC);
          AppMethodBeat.o(163137);
          return;
          if (2 == paramAnonymousInt)
          {
            Log.i("MicroMsg.CropArtist", "[doCrop]");
            if (paramAnonymousi.hpD != null) {
              paramAnonymousi.hpD.cancel();
            }
            if (!paramAnonymousi.hpp.hcg)
            {
              if (!paramAnonymousi.hpp.isStarted)
              {
                paramAnonymousi.hpp.cancel();
                paramAnonymousi.hpp.play();
              }
              paramAnonymousi.hpp.cip = new c.7(paramAnonymousi);
            }
            for (;;)
            {
              a.a(a.this, (com.tencent.mm.e.b)a.b(a.this).get(a.this.YwC));
              a.this.Ywu.getBaseFooterView().setCurFeatureType(a.this.YwC);
              AppMethodBeat.o(163137);
              return;
              paramAnonymousi.hpp.cip = null;
              paramAnonymousi.aEM();
            }
          }
          if (3 != paramAnonymousInt) {
            break;
          }
          Log.i("MicroMsg.CropArtist", "[reset]");
          paramAnonymousi.hpG = true;
          paramAnonymousi.hpp.cancel();
          if (paramAnonymousi.hpD != null) {
            paramAnonymousi.hpD.cancel();
          }
          paramAnonymousi.hpE.setEmpty();
          paramAnonymousi.aEL();
          paramAnonymousi.hpw = false;
          paramAnonymousi.hoR.iPo().getBaseBoardView().M(paramAnonymousi.hbZ);
          paramAnonymousi.hoR.iPo().getBaseBoardView().a(new c.9(paramAnonymousi), paramAnonymousi.getRotation(), true);
          AppMethodBeat.o(163137);
          return;
          paramAnonymousi = (com.tencent.mm.e.f)a.this.iPp();
          f1 = ((Float)paramAnonymousObject).floatValue();
          paramAnonymousObject = (com.tencent.mm.cache.e)paramAnonymousi.aEA();
          if (paramAnonymousObject != null) {
            paramAnonymousObject.lvQ = paramAnonymousInt;
          }
          paramAnonymousi = (com.tencent.mm.cache.e)paramAnonymousi.aEA();
          if (paramAnonymousi != null) {
            paramAnonymousi.lvR = f1;
          }
          a.this.Ywu.getBaseBoardView().postInvalidate();
          Log.i("MicroMsg.DrawingPresenter", "lxl postInvalidate");
          break;
        }
      }
      
      public final void dP(boolean paramAnonymousBoolean) {}
    };
    AppMethodBeat.o(9299);
    return local1;
  }
  
  public final boolean iPl()
  {
    return this.GEW;
  }
  
  public final void iPm()
  {
    this.GEW = false;
  }
  
  public final void iPn()
  {
    AppMethodBeat.i(9304);
    this.Ywu.setFooterVisible(true);
    Ki(false);
    AppMethodBeat.o(9304);
  }
  
  public final com.tencent.mm.view.a iPo()
  {
    return this.Ywu;
  }
  
  public final <T extends com.tencent.mm.e.b> T iPp()
  {
    AppMethodBeat.i(9306);
    if (this.YwF != null)
    {
      localb = this.YwF;
      AppMethodBeat.o(9306);
      return localb;
    }
    Log.e("MicroMsg.DrawingPresenter", "[getCurArtist] is null!");
    com.tencent.mm.e.b localb = com.tencent.mm.e.b.hoV;
    AppMethodBeat.o(9306);
    return localb;
  }
  
  public final float iPq()
  {
    return this.YwA;
  }
  
  public final void iPr()
  {
    AppMethodBeat.i(231274);
    Iterator localIterator = this.Yww.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.e.b localb = (com.tencent.mm.e.b)localIterator.next();
      localb.hoU = null;
      localb.aEA().clear();
    }
    AppMethodBeat.o(231274);
  }
  
  public final boolean iPs()
  {
    return this.YwE;
  }
  
  public final void iPt()
  {
    AppMethodBeat.i(9311);
    Log.i("MicroMsg.DrawingPresenter", "[onLayout],%s", new Object[] { Boolean.valueOf(this.YwE) });
    if (!this.YwE)
    {
      this.YwE = true;
      Iterator localIterator = this.Yww.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.e.b localb = (com.tencent.mm.e.b)localIterator.next();
        if (ArtistCacheManager.aLv().b(localb.aEy()))
        {
          localb.onAlive();
          localb.ec(true);
          Log.i("MicroMsg.DrawingPresenter", "[onAttachedToWindow] %s is revert onAlive!", new Object[] { localb.aEy() });
        }
      }
      if (this.Ywu.getBaseBoardView().jMO())
      {
        this.Ywu.getBaseBoardView().jMP();
        this.Ywu.getBaseBoardView().invalidate();
      }
    }
    AppMethodBeat.o(9311);
  }
  
  public final Bitmap iPu()
  {
    return this.Ywy;
  }
  
  public final boolean iPv()
  {
    AppMethodBeat.i(9313);
    if ((iPp().aEy() != com.tencent.mm.e.a.hoN) && (this.Ywz))
    {
      AppMethodBeat.o(9313);
      return true;
    }
    AppMethodBeat.o(9313);
    return false;
  }
  
  public final void onAttachedToWindow()
  {
    AppMethodBeat.i(9312);
    Log.i("MicroMsg.DrawingPresenter", "[onAttachedToWindow]");
    if (!this.YwE)
    {
      this.YwE = true;
      Iterator localIterator = this.Yww.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.e.b localb = (com.tencent.mm.e.b)localIterator.next();
        if (ArtistCacheManager.aLv().b(localb.aEy()))
        {
          localb.onAlive();
          localb.ec(true);
          Log.i("MicroMsg.DrawingPresenter", "[onAttachedToWindow] %s is revert onAlive!", new Object[] { localb.aEy() });
        }
      }
      if (this.Ywu.getBaseBoardView().jMO())
      {
        this.Ywu.getBaseBoardView().jMP();
        this.Ywu.getBaseBoardView().invalidate();
      }
    }
    AppMethodBeat.o(9312);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9310);
    Iterator localIterator = this.Yww.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.e.b)localIterator.next()).onDestroy();
    }
    this.Yww.clear();
    this.Ywv.clear();
    AppMethodBeat.o(9310);
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9317);
    Iterator localIterator = this.Yww.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.e.b localb = (com.tencent.mm.e.b)localIterator.next();
      if (localb.isAlive()) {
        if (iPp().aEy() == localb.aEy())
        {
          localb.onDraw(paramCanvas);
        }
        else
        {
          paramCanvas.save();
          paramCanvas.clipRect(this.Ywu.getBaseBoardView().getAliveRect());
          localb.h(paramCanvas);
          paramCanvas.restore();
        }
      }
    }
    AppMethodBeat.o(9317);
  }
  
  public final void onExit()
  {
    AppMethodBeat.i(9300);
    if (this.Ywx != null) {
      this.Ywx.onExit();
    }
    AppMethodBeat.o(9300);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(9302);
    if (this.Ywx != null) {
      this.Ywx.onFinish();
    }
    AppMethodBeat.o(9302);
  }
  
  public final void r(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(231258);
    if (TextUtils.isEmpty(paramString1))
    {
      AppMethodBeat.o(231258);
      return;
    }
    Ki(false);
    this.Ywu.setFooterVisible(true);
    Object localObject = iPp();
    EditText localEditText;
    if (((com.tencent.mm.e.b)localObject).aEy() == com.tencent.mm.e.a.hoM)
    {
      localObject = (com.tencent.mm.e.e)localObject;
      localEditText = (EditText)this.Ywu.getTextEditView().findViewById(a.e.text_edit);
      if ((localEditText.getTag() == null) || (!(localEditText.getTag() instanceof com.tencent.mm.ab.f))) {
        break label135;
      }
      ((com.tencent.mm.e.e)localObject).a((com.tencent.mm.ab.f)localEditText.getTag(), p.b(this.Ywu.getContext(), paramString1), paramInt1, paramInt2, paramString2);
    }
    for (;;)
    {
      localEditText.setTag(null);
      AppMethodBeat.o(231258);
      return;
      label135:
      ((com.tencent.mm.e.e)localObject).a(p.b(this.Ywu.getContext(), paramString1), paramInt1, paramInt2, paramString2);
    }
  }
  
  public final void setActionBarCallback(k paramk)
  {
    this.Ywx = paramk;
  }
  
  public final void setAutoShowFooterAndBar(boolean paramBoolean)
  {
    this.Ywz = paramBoolean;
  }
  
  public final void setInitScale(float paramFloat)
  {
    AppMethodBeat.i(231269);
    this.Ywu.getBaseBoardView().setInitScale(paramFloat);
    AppMethodBeat.o(231269);
  }
  
  public final void setOutputSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(231230);
    Log.i("MicroMsg.DrawingPresenter", "setOutputSize width:%d height:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.outputWidth = paramInt1;
    this.outputHeight = paramInt2;
    AppMethodBeat.o(231230);
  }
  
  public final class a
    implements com.tencent.mm.ai.a
  {
    View YwJ;
    TextView YwK;
    ImageView YwL;
    
    public a()
    {
      AppMethodBeat.i(9289);
      this.YwJ = a.this.Ywu.getRubbishView();
      this.YwK = ((TextView)this.YwJ.findViewById(a.e.rubbish_tip));
      this.YwL = ((ImageView)this.YwJ.findViewById(a.e.rubbish_icon));
      AppMethodBeat.o(9289);
    }
    
    public final void a(com.tencent.mm.ab.f paramf)
    {
      AppMethodBeat.i(9294);
      EditText localEditText = (EditText)a.this.Ywu.getTextEditView().findViewById(a.e.text_edit);
      localEditText.setTag(paramf);
      if ((a.this.YwB != null) && (a.this.YwB.b(paramf)))
      {
        AppMethodBeat.o(9294);
        return;
      }
      localEditText.setText(paramf.mAC);
      Switch localSwitch = (Switch)a.this.Ywu.findViewById(a.e.bg_switch);
      SelectColorBar localSelectColorBar = (SelectColorBar)a.this.Ywu.findViewById(a.e.select_color_bar);
      boolean bool;
      if (paramf.mBgColor != 0)
      {
        bool = true;
        localSwitch.setChecked(bool);
        if (!localSwitch.isChecked()) {
          break label172;
        }
        localSelectColorBar.setSelectColor(paramf.mBgColor);
      }
      for (;;)
      {
        localEditText.setTextColor(paramf.mColor);
        localEditText.setTag(paramf);
        a.c(a.this);
        AppMethodBeat.o(9294);
        return;
        bool = false;
        break;
        label172:
        localSelectColorBar.setSelectColor(paramf.mColor);
      }
    }
    
    public final void bcb()
    {
      AppMethodBeat.i(9291);
      Log.i("MicroMsg.DrawingPresenter", "[onUnReach]");
      this.YwJ.setActivated(false);
      this.YwL.setImageDrawable(bb.m(a.this.Ywu.getContext(), a.g.icons_filled_delete, -1));
      this.YwK.setText(a.this.Ywu.getContext().getString(a.h.rubbish_unreached_tip));
      AppMethodBeat.o(9291);
    }
    
    public final void bo(float paramFloat)
    {
      AppMethodBeat.i(9290);
      Log.i("MicroMsg.DrawingPresenter", "[onReach] distance:%s", new Object[] { Float.valueOf(paramFloat) });
      this.YwJ.setActivated(true);
      this.YwK.setText(a.this.Ywu.getContext().getString(a.h.rubbish_reached_tip));
      this.YwL.setImageDrawable(bb.m(a.this.Ywu.getContext(), a.g.icons_filled_delete_on, -1));
      AppMethodBeat.o(9290);
    }
    
    public final void onHide()
    {
      AppMethodBeat.i(9293);
      a.a(a.this, false);
      AppMethodBeat.o(9293);
    }
    
    public final void onShow()
    {
      AppMethodBeat.i(9292);
      a.a(a.this, true);
      if (a.this.YwB != null) {
        a.this.YwB.B(Boolean.TRUE);
      }
      AppMethodBeat.o(9292);
    }
  }
  
  final class b
    implements Runnable
  {
    w YwM;
    boolean YwN;
    
    b(w paramw, boolean paramBoolean)
    {
      this.YwM = paramw;
      this.YwN = paramBoolean;
    }
    
    private static Bitmap a(Bitmap paramBitmap, Rect paramRect, float paramFloat, BitmapFactory.Options paramOptions, Matrix paramMatrix)
    {
      AppMethodBeat.i(9296);
      for (;;)
      {
        try
        {
          if ((paramBitmap.getWidth() - paramRect.width() <= 9) && (paramBitmap.getHeight() - paramRect.height() <= 9)) {
            continue;
          }
          localBitmap = Bitmap.createBitmap(paramBitmap, paramRect.left, paramRect.top, paramRect.width(), paramRect.height(), paramMatrix, true);
          paramBitmap = localBitmap;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          Bitmap localBitmap;
          Log.printErrStackTrace("MicroMsg.DrawingPresenter", localOutOfMemoryError, "", new Object[0]);
          float f1 = 1920.0F / paramOptions.outHeight;
          float f2 = 1920.0F / paramOptions.outWidth;
          if (f1 <= f2) {
            continue;
          }
          paramMatrix.reset();
          paramMatrix.postScale(f1, f1, 0.0F, 0.0F);
          paramMatrix.postRotate(-paramFloat);
          if ((paramBitmap.getWidth() - paramRect.width() <= 9) && (paramBitmap.getHeight() - paramRect.height() <= 9)) {
            continue;
          }
          paramBitmap = Bitmap.createBitmap(paramBitmap, paramRect.left, paramRect.top, paramRect.width(), paramRect.height(), paramMatrix, true);
          continue;
          f1 = f2;
          continue;
          paramBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), paramMatrix, true);
          continue;
        }
        AppMethodBeat.o(9296);
        return paramBitmap;
        localBitmap = Bitmap.createBitmap(paramBitmap, 0, 0, paramBitmap.getWidth(), paramBitmap.getHeight(), paramMatrix, true);
        paramBitmap = localBitmap;
      }
    }
    
    private Rect ba(Bitmap paramBitmap)
    {
      AppMethodBeat.i(231210);
      Rect localRect = new Rect(a.this.Ywu.getBaseBoardView().getAliveRect());
      Log.i("MicroMsg.DrawingPresenter", "[saveEditPhoto] clipRectF:%s w:%s h:%s", new Object[] { localRect, Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) });
      if (localRect.left < 0) {
        localRect.left = 0;
      }
      if (localRect.top < 0) {
        localRect.top = 0;
      }
      if (localRect.bottom < 0) {
        localRect.bottom = 0;
      }
      if (localRect.right < 0) {
        localRect.right = 0;
      }
      if (localRect.bottom > paramBitmap.getHeight()) {
        localRect.bottom = paramBitmap.getHeight();
      }
      if (localRect.right > paramBitmap.getWidth()) {
        localRect.right = paramBitmap.getWidth();
      }
      AppMethodBeat.o(231210);
      return localRect;
    }
    
    public final void run()
    {
      AppMethodBeat.i(9295);
      int i;
      int j;
      try
      {
        Iterator localIterator1 = a.d(a.this).iterator();
        while (localIterator1.hasNext()) {
          ((com.tencent.mm.e.b)localIterator1.next()).aEC();
        }
        Iterator localIterator2;
        Object localObject3;
        Object localObject1;
        Bitmap localBitmap1;
        throw localBitmap2;
      }
      catch (Exception localException1)
      {
        com.tencent.threadpool.h.ahAA.bk(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(231213);
            a.b.this.YwM.f(localException1);
            AppMethodBeat.o(231213);
          }
        });
        try
        {
          localIterator2 = a.d(a.this).iterator();
          while (localIterator2.hasNext()) {
            ((com.tencent.mm.e.b)localIterator2.next()).onFinish();
          }
          localObject3 = null;
        }
        catch (Exception localException2)
        {
          AppMethodBeat.o(9295);
          return;
        }
        if (!a.this.Ywu.getBaseBoardView().jMO())
        {
          i = a.this.Ywu.getBaseBoardView().getAliveRect().width();
          j = a.this.Ywu.getBaseBoardView().getAliveRect().height();
          localObject1 = localObject3;
          if (i <= 0) {
            break label1164;
          }
          localObject1 = localObject3;
          if (j <= 0) {
            break label1164;
          }
          localObject1 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
          break label1164;
        }
        while (localObject1 == null)
        {
          this.YwM.f(new NullPointerException("bitmap is null!"));
          try
          {
            localObject1 = a.d(a.this).iterator();
            while (((Iterator)localObject1).hasNext()) {
              ((com.tencent.mm.e.b)((Iterator)localObject1).next()).onFinish();
            }
            localBitmap1 = a.this.Ywy;
          }
          catch (Exception localException3)
          {
            AppMethodBeat.o(9295);
            return;
          }
          continue;
          a.this.onDestroy();
          AppMethodBeat.o(9295);
          return;
        }
        localObject3 = new Canvas(localBitmap1);
        localObject4 = a.d(a.this).iterator();
        while (((Iterator)localObject4).hasNext()) {
          ((com.tencent.mm.e.b)((Iterator)localObject4).next()).aEA().i((Canvas)localObject3);
        }
      }
      finally
      {
        try
        {
          localObject3 = a.d(a.this).iterator();
          while (((Iterator)localObject3).hasNext()) {
            ((com.tencent.mm.e.b)((Iterator)localObject3).next()).onFinish();
          }
          AppMethodBeat.o(9295);
        }
        catch (Exception localException5) {}
      }
      label394:
      Object localObject4 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject4).inJustDecodeBounds = true;
      BitmapUtil.decodeFile(a.this.hdX.path, (BitmapFactory.Options)localObject4);
      float f3 = 1.0F * ((BitmapFactory.Options)localObject4).outHeight / localBitmap2.getHeight();
      float f4 = 1.0F * ((BitmapFactory.Options)localObject4).outWidth / localBitmap2.getWidth();
      float f1 = f3;
      float f2 = f4;
      if (a.e(a.this) > 0)
      {
        f1 = f3;
        f2 = f4;
        if (a.f(a.this) > 0)
        {
          f1 = 1.0F * a.e(a.this) / localBitmap2.getHeight();
          f2 = 1.0F * a.f(a.this) / localBitmap2.getWidth();
        }
      }
      for (;;)
      {
        f1 = a.this.Ywu.getBaseBoardView().d(a.this.Ywu.getBaseBoardView().getMainMatrix());
        Matrix localMatrix = new Matrix();
        localMatrix.postScale(f2, f2, 0.0F, 0.0F);
        localMatrix.postRotate(-f1);
        Rect localRect;
        if (a.g(a.this) > 0.0F)
        {
          localRect = ba(localBitmap2);
          f2 = (float)(localRect.width() * 1.0D / localRect.height());
          Log.i("MicroMsg.DrawingPresenter", "[saveEditPhoto] clipRectF:%s w:%s h:%s ratio:%f", new Object[] { localRect, Integer.valueOf(localBitmap2.getWidth()), Integer.valueOf(localBitmap2.getHeight()), Float.valueOf(f2) });
          if ((f2 < a.g(a.this) - 0.06D) || (f2 > a.g(a.this) + 0.06D))
          {
            if (a.g(a.this) > f2)
            {
              i = localRect.centerY();
              j = (int)(localRect.width() * 1.0F / a.g(a.this));
              Log.i("MicroMsg.DrawingPresenter", "clipRect.width() : " + localRect.width() + " new height:" + j);
              localRect.top = (i - j / 2);
              localRect.bottom = (i + j / 2);
              Log.i("MicroMsg.DrawingPresenter", "top :" + localRect.top + " bottom:" + localRect.bottom);
            }
          }
          else
          {
            label848:
            Log.i("MicroMsg.DrawingPresenter", "ratio clipRect :" + localRect.width() * 1.0F / localRect.height());
            label884:
            Object localObject2 = a(localBitmap2, localRect, f1, (BitmapFactory.Options)localObject4, localMatrix);
            com.tencent.threadpool.h.ahAA.bk(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(231212);
                a.b.this.YwM.b(this.MrP, a.b.this.YwN);
                AppMethodBeat.o(231212);
              }
            });
            try
            {
              localObject2 = a.d(a.this).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                ((com.tencent.mm.e.b)((Iterator)localObject2).next()).onFinish();
                continue;
                f1 = f2;
              }
            }
            catch (Exception localException4)
            {
              AppMethodBeat.o(9295);
              return;
            }
          }
        }
        label1164:
        do
        {
          break label1173;
          i = localRect.centerX();
          j = (int)(localRect.height() * 1.0F * a.g(a.this));
          Log.i("MicroMsg.DrawingPresenter", "clipRect.height() : " + localRect.height() + " new width:" + j);
          localRect.left = (i - j / 2);
          localRect.right = (i + j / 2);
          Log.i("MicroMsg.DrawingPresenter", "left :" + localRect.left + " right:" + localRect.right + " cropRectRatio:" + a.g(a.this));
          break label848;
          localRect = ba(localException4);
          break label884;
          a.this.onDestroy();
          AppMethodBeat.o(9295);
          return;
          a.this.onDestroy();
          AppMethodBeat.o(9295);
          return;
          a.this.onDestroy();
          break label394;
          break;
        } while (f1 <= f2);
        label1173:
        f2 = f1;
        if (f1 == 0.0F) {
          f2 = 1.0F;
        }
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void B(Boolean paramBoolean);
    
    public abstract boolean b(com.tencent.mm.ab.f paramf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.bt.a
 * JD-Core Version:    0.7.0.1
 */