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
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ab.a;
import com.tencent.mm.api.ab.c;
import com.tencent.mm.api.j;
import com.tencent.mm.api.r;
import com.tencent.mm.api.u;
import com.tencent.mm.api.z;
import com.tencent.mm.cache.ArtistCacheManager;
import com.tencent.mm.cache.ArtistCacheManager.a;
import com.tencent.mm.e.c;
import com.tencent.mm.e.c.10;
import com.tencent.mm.e.c.2;
import com.tencent.mm.e.c.7;
import com.tencent.mm.e.c.9;
import com.tencent.mm.e.d;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.ar;
import com.tencent.mm.vfs.s;
import com.tencent.mm.view.footer.SelectColorBar;
import com.tencent.mm.z.e.a;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  implements b
{
  com.tencent.mm.view.a Kyf;
  HashMap<com.tencent.mm.api.h, com.tencent.mm.e.b> Kyg;
  LinkedList<com.tencent.mm.e.b> Kyh;
  private j Kyi;
  Bitmap Kyj;
  private boolean Kyk = true;
  private boolean Kyl = true;
  private float Kym = -1.0F;
  public c Kyn;
  com.tencent.mm.api.h Kyo = com.tencent.mm.api.h.diG;
  com.tencent.mm.api.h Kyp = com.tencent.mm.api.h.diG;
  private boolean Kyq = false;
  com.tencent.mm.e.b Kyr = null;
  ab.a diP;
  int outputHeight = -1;
  int outputWidth = -1;
  
  private void gto()
  {
    AppMethodBeat.i(9319);
    this.Kyh.clear();
    this.Kyg.clear();
    this.Kyg.put(com.tencent.mm.api.h.diG, com.tencent.mm.e.b.drW);
    com.tencent.mm.api.h[] arrayOfh = this.Kyf.getFeatures();
    int k = arrayOfh.length;
    int i = 0;
    Object localObject2;
    Object localObject1;
    int j;
    if (i < k)
    {
      com.tencent.mm.api.h localh = arrayOfh[i];
      localObject2 = null;
      Iterator localIterator = null;
      localObject1 = localIterator;
      switch (7.Kyu[localh.ordinal()])
      {
      default: 
      case 7: 
      case 4: 
        for (localObject1 = localIterator;; localObject1 = new d())
        {
          if (localObject1 != null)
          {
            if (!this.Kyg.containsKey(localh)) {
              this.Kyg.put(localh, localObject1);
            }
            if (!this.Kyh.contains(localObject1))
            {
              this.Kyh.add(localObject1);
              ((com.tencent.mm.e.b)localObject1).a(this, this.Kyf.getBaseBoardView().getMainMatrix(), this.Kyf.getBaseBoardView().getAliveRect());
            }
          }
          i += 1;
          break;
        }
      case 1: 
      case 2: 
        localIterator = this.Kyh.iterator();
        while (localIterator.hasNext())
        {
          localObject1 = (com.tencent.mm.e.b)localIterator.next();
          if (((com.tencent.mm.e.b)localObject1).XS() == com.tencent.mm.e.a.drN) {
            j = 1;
          }
        }
      }
    }
    while (j == 0)
    {
      localObject1 = new com.tencent.mm.e.e();
      ((com.tencent.mm.e.e)localObject1).dti = new a();
      break;
      localObject1 = new com.tencent.mm.e.h();
      break;
      localObject1 = new c();
      break;
      localObject1 = new com.tencent.mm.e.f();
      break;
      Collections.sort(this.Kyh, new Comparator() {});
      Log.i("MicroMsg.DrawingPresenter", "[addArtists] count:%s", new Object[] { Integer.valueOf(this.Kyg.size() - 1) });
      AppMethodBeat.o(9319);
      return;
      j = 0;
      localObject1 = localObject2;
    }
  }
  
  final void Ar(boolean paramBoolean)
  {
    AppMethodBeat.i(9320);
    if (paramBoolean)
    {
      localAnimation = AnimationUtils.loadAnimation(this.Kyf.getContext(), 2130772132);
      localAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(9283);
          a.this.Kyf.getTextEditView().setVisibility(0);
          paramAnonymousAnimation = (EditText)a.this.Kyf.getTextEditView().findViewById(2131308994);
          paramAnonymousAnimation.requestFocus();
          paramAnonymousAnimation.setSelection(paramAnonymousAnimation.length());
          a.this.Kyf.getSelectedFeatureListener().cH(true);
          ((SelectColorBar)a.this.Kyf.findViewById(2131307511)).setSelectColor(paramAnonymousAnimation.getCurrentTextColor());
          a.this.Kyf.getActionBar().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9282);
              a.this.Kyf.getActionBar().setVisibility(0);
              AppMethodBeat.o(9282);
            }
          });
          AppMethodBeat.o(9283);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      this.Kyf.getTextEditView().startAnimation(localAnimation);
      AppMethodBeat.o(9320);
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(this.Kyf.getContext(), 2130772130);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(9285);
        ((EditText)a.this.Kyf.getTextEditView().findViewById(2131308994)).setText("");
        a.this.Kyf.getTextEditView().setVisibility(8);
        AppMethodBeat.o(9285);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(9284);
        a.this.Kyf.getSelectedFeatureListener().cH(false);
        AppMethodBeat.o(9284);
      }
    });
    this.Kyf.getTextEditView().startAnimation(localAnimation);
    AppMethodBeat.o(9320);
  }
  
  public final boolean R(MotionEvent paramMotionEvent)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    AppMethodBeat.i(9316);
    boolean bool1 = bool2;
    Object localObject;
    if (gti().XS() != com.tencent.mm.e.a.drO)
    {
      if (gti().XS() == com.tencent.mm.e.a.drP) {
        bool1 = bool2;
      }
    }
    else
    {
      if (bool1) {
        break label224;
      }
      this.Kyr = ((com.tencent.mm.e.b)this.Kyg.get(this.Kyf.getBaseFooterView().getCurFeatureType()));
      localObject = this.Kyh.iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.e.b localb = (com.tencent.mm.e.b)((Iterator)localObject).next();
        if ((localb.XS() != com.tencent.mm.e.a.drN) && (localb.q(paramMotionEvent))) {
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
      if (this.Kyg.containsKey(com.tencent.mm.api.h.diI)) {
        localObject = (com.tencent.mm.e.b)this.Kyg.get(com.tencent.mm.api.h.diI);
      }
      for (;;)
      {
        bool2 = bool3;
        if (localObject != null) {
          bool2 = ((com.tencent.mm.e.b)localObject).q(paramMotionEvent);
        }
        bool1 = bool2;
        if (!bool2) {
          break;
        }
        this.Kyr = ((com.tencent.mm.e.b)localObject);
        bool1 = bool2;
        break;
        if (this.Kyg.containsKey(com.tencent.mm.api.h.diJ)) {
          localObject = (com.tencent.mm.e.b)this.Kyg.get(com.tencent.mm.api.h.diJ);
        }
      }
    }
  }
  
  public final boolean Ul()
  {
    AppMethodBeat.i(9301);
    if (this.Kyf.getTextEditView().getVisibility() == 0)
    {
      Ar(false);
      this.Kyf.setFooterVisible(true);
      AppMethodBeat.o(9301);
      return true;
    }
    if ((this.Kyf.getChatFooterPanel() != null) && (this.Kyf.getChatFooterPanel().getVisibility() == 0))
    {
      this.Kyf.DC(true);
      this.Kyf.setFooterVisible(true);
      AppMethodBeat.o(9301);
      return true;
    }
    AppMethodBeat.o(9301);
    return false;
  }
  
  public final com.tencent.mm.cache.f a(com.tencent.mm.e.a parama)
  {
    AppMethodBeat.i(9318);
    ArtistCacheManager localArtistCacheManager = ArtistCacheManager.alA();
    String str = this.diP.path;
    if (TextUtils.isEmpty(str))
    {
      if (ArtistCacheManager.gpr.containsKey(localArtistCacheManager.gpt))
      {
        parama = ((ArtistCacheManager.a)ArtistCacheManager.gpr.get(localArtistCacheManager.gpt)).c(parama);
        AppMethodBeat.o(9318);
        return parama;
      }
      Log.e("MicroMsg.ArtistCacheManager", "[getArtistCache] id is not contains! %s", new Object[] { localArtistCacheManager.gpt });
      AppMethodBeat.o(9318);
      return null;
    }
    if (ArtistCacheManager.gpr.containsKey(str))
    {
      parama = ((ArtistCacheManager.a)ArtistCacheManager.gpr.get(str)).c(parama);
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
    Ar(false);
    this.Kyf.setFooterVisible(true);
    Object localObject = gti();
    EditText localEditText;
    if (((com.tencent.mm.e.b)localObject).XS() == com.tencent.mm.e.a.drN)
    {
      localObject = (com.tencent.mm.e.e)localObject;
      localEditText = (EditText)this.Kyf.getTextEditView().findViewById(2131308994);
      if ((localEditText.getTag() == null) || (!(localEditText.getTag() instanceof com.tencent.mm.z.f))) {
        break label119;
      }
      ((com.tencent.mm.e.e)localObject).a((com.tencent.mm.z.f)localEditText.getTag(), l.c(this.Kyf.getContext(), paramEditable), paramInt1, paramInt2);
    }
    for (;;)
    {
      localEditText.setTag(null);
      AppMethodBeat.o(9303);
      return;
      label119:
      ((com.tencent.mm.e.e)localObject).a(l.c(this.Kyf.getContext(), paramEditable), paramInt1, paramInt2);
    }
  }
  
  public final void a(ab.a parama)
  {
    AppMethodBeat.i(9297);
    this.diP = parama;
    this.Kyg = new HashMap();
    this.Kyh = new LinkedList();
    Object localObject = parama.path;
    int i;
    if ((Util.isNullOrNil((String)localObject)) || (!s.YS((String)localObject)))
    {
      Log.w("MicroMsg.DrawingPresenter", "[checkImage] path:%s", new Object[] { localObject });
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        if (parama.diU)
        {
          this.Kyj = BitmapUtil.decodeFile(parama.path, null);
          if (this.Kyj != null) {
            this.Kyj = this.Kyj.copy(Bitmap.Config.ARGB_8888, true);
          }
          gto();
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
            break label432;
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
      this.Kyj = BitmapUtil.createThumbBitmap(Util.nullAs(parama.path, ""), i, j, true, false);
      break;
      if (parama.diR == ab.c.dja)
      {
        this.Kyj = BitmapUtil.createColorBitmap(parama.backgroundColor, parama.diV.width(), parama.diV.height());
        break;
      }
      if (this.Kyj != null) {
        break;
      }
      this.Kyj = BitmapUtil.createColorBitmap(0, 1280, 1280);
      break;
      label432:
      i = 1280;
    }
  }
  
  public final void a(u paramu, boolean paramBoolean)
  {
    AppMethodBeat.i(9309);
    ThreadPool.post(new b(paramu, paramBoolean), "onFinalGenerate_" + paramu.hashCode());
    AppMethodBeat.o(9309);
  }
  
  public final void a(com.tencent.mm.view.a parama)
  {
    this.Kyf = parama;
  }
  
  public final void ate()
  {
    AppMethodBeat.i(9311);
    Log.i("MicroMsg.DrawingPresenter", "[onLayout],%s", new Object[] { Boolean.valueOf(this.Kyq) });
    if (!this.Kyq)
    {
      this.Kyq = true;
      Iterator localIterator = this.Kyh.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.e.b localb = (com.tencent.mm.e.b)localIterator.next();
        if (ArtistCacheManager.alA().b(localb.XS()))
        {
          localb.onAlive();
          localb.cT(true);
          Log.i("MicroMsg.DrawingPresenter", "[onAttachedToWindow] %s is revert onAlive!", new Object[] { localb.XS() });
        }
      }
      if (this.Kyf.getBaseBoardView().hgb())
      {
        this.Kyf.getBaseBoardView().hgc();
        this.Kyf.getBaseBoardView().invalidate();
      }
    }
    AppMethodBeat.o(9311);
  }
  
  public final <T extends com.tencent.mm.e.b> T c(com.tencent.mm.api.h paramh)
  {
    AppMethodBeat.i(9314);
    paramh = (com.tencent.mm.e.b)this.Kyg.get(paramh);
    AppMethodBeat.o(9314);
    return paramh;
  }
  
  public final void c(r paramr)
  {
    AppMethodBeat.i(9315);
    com.tencent.mm.e.e locale = (com.tencent.mm.e.e)c(com.tencent.mm.api.h.diJ);
    if (locale != null) {
      locale.b(paramr);
    }
    AppMethodBeat.o(9315);
  }
  
  public final ab.a getConfig()
  {
    return this.diP;
  }
  
  public final float getCurScale()
  {
    AppMethodBeat.i(9308);
    float f = this.Kyf.getBaseBoardView().getCurScale();
    AppMethodBeat.o(9308);
    return f;
  }
  
  public final com.tencent.mm.api.h[] getFeatures()
  {
    AppMethodBeat.i(9298);
    com.tencent.mm.api.h[] arrayOfh = this.Kyf.getFeatures();
    AppMethodBeat.o(9298);
    return arrayOfh;
  }
  
  public final float getInitScale()
  {
    AppMethodBeat.i(9307);
    float f = this.Kyf.getBaseBoardView().getInitScale();
    AppMethodBeat.o(9307);
    return f;
  }
  
  public final z getSelectedFeatureListener()
  {
    AppMethodBeat.i(9299);
    z local1 = new z()
    {
      public final void a(com.tencent.mm.api.h paramAnonymoush)
      {
        AppMethodBeat.i(9279);
        Log.i("MicroMsg.DrawingPresenter", "[onSelectedFeature] features:%s", new Object[] { paramAnonymoush });
        if (paramAnonymoush == com.tencent.mm.api.h.diG) {
          a.this.Kyf.getBaseFooterView().setCurFeatureType(paramAnonymoush);
        }
        a.this.Kyf.getBaseFooterView().hgl();
        if (a.this.Kyf.getSelectedFeatureListener() != null) {
          a.this.Kyf.getSelectedFeatureListener().a(paramAnonymoush);
        }
        if (paramAnonymoush == com.tencent.mm.api.h.diM) {
          a.this.Kyf.getFooterBg().setVisibility(8);
        }
        com.tencent.mm.e.b localb = (com.tencent.mm.e.b)a.this.Kyg.get(paramAnonymoush);
        if (localb == null)
        {
          AppMethodBeat.o(9279);
          return;
        }
        if ((localb.dbG) && (!localb.isAlive())) {
          localb.onAlive();
        }
        if (localb.XS() != com.tencent.mm.e.a.drK) {
          localb.setOneFingerMoveEnable(false);
        }
        localb.XV();
        a.this.Kyr = localb;
        switch (a.7.Kyu[paramAnonymoush.ordinal()])
        {
        default: 
          a.this.Kyp = paramAnonymoush;
        }
        for (;;)
        {
          a.this.Kyf.getBaseFooterView().setCurFeatureType(paramAnonymoush);
          AppMethodBeat.o(9279);
          return;
          if (!a.this.Kyf.getBaseFooterView().hgg())
          {
            ((EditText)a.this.Kyf.getTextEditView().findViewById(2131308994)).setTextColor(com.tencent.mm.view.footer.a.RoQ[0]);
            a.this.Ar(true);
            a.this.Kyf.setFooterVisible(false);
          }
          a.this.Kyp = paramAnonymoush;
          continue;
          a.this.Kyf.setActionBarVisible(false);
          a.this.Kyf.setFooterVisible(false);
          a.this.Kyf.DC(false);
          break;
          a.this.Kyo = a.this.Kyp;
        }
      }
      
      public final void a(com.tencent.mm.api.h paramAnonymoush, int paramAnonymousInt, Object paramAnonymousObject)
      {
        AppMethodBeat.i(163137);
        Log.i("MicroMsg.DrawingPresenter", "[onSelectedDetailFeature] features:%s index:%s", new Object[] { paramAnonymoush, Integer.valueOf(paramAnonymousInt) });
        if (a.this.Kyf.getSelectedFeatureListener() != null) {
          a.this.Kyf.getSelectedFeatureListener().a(paramAnonymoush, paramAnonymousInt, paramAnonymousObject);
        }
        a.this.Kyr = ((com.tencent.mm.e.b)a.this.Kyg.get(paramAnonymoush));
        if (a.this.gti().XS() == com.tencent.mm.e.a.drK)
        {
          AppMethodBeat.o(163137);
          return;
        }
        if (a.this.Kyf.getFooterBg().getVisibility() == 8) {
          a.this.Kyf.getFooterBg().setVisibility(0);
        }
        float f2;
        switch (a.7.Kyu[paramAnonymoush.ordinal()])
        {
        default: 
          AppMethodBeat.o(163137);
          return;
        case 4: 
          paramAnonymoush = (d)a.this.gti();
          if (paramAnonymousInt != -1)
          {
            paramAnonymoush.mColor = a.this.Kyf.getBaseFooterView().getColor(paramAnonymousInt);
            AppMethodBeat.o(163137);
            return;
          }
          paramAnonymoush.Ya();
          AppMethodBeat.o(163137);
          return;
        case 5: 
          paramAnonymoush = (com.tencent.mm.e.h)a.this.gti();
          if (paramAnonymousInt == 0)
          {
            paramAnonymoush.dty = e.a.hoC;
            AppMethodBeat.o(163137);
            return;
          }
          if (1 == paramAnonymousInt)
          {
            paramAnonymoush.dty = e.a.hoD;
            AppMethodBeat.o(163137);
            return;
          }
          paramAnonymoush.Ya();
          AppMethodBeat.o(163137);
          return;
        case 3: 
          paramAnonymoush = (c)a.this.gti();
          if (paramAnonymousInt == 0)
          {
            paramAnonymoush.dsG += 1;
            paramAnonymoush.dsp.cancel();
            if (paramAnonymoush.dsE != null) {
              paramAnonymoush.dsE.cancel();
            }
            paramAnonymousObject = new Matrix();
            paramAnonymousObject.postRotate(-90.0F, paramAnonymoush.dgS.centerX(), paramAnonymoush.dgS.centerY());
            if (paramAnonymoush.dsF.isEmpty()) {
              paramAnonymoush.dsF.set(paramAnonymoush.dgS);
            }
            RectF localRectF = new RectF(paramAnonymoush.dsF);
            paramAnonymousObject.mapRect(localRectF);
            f1 = 1.0F * paramAnonymoush.dsl.width() / localRectF.width();
            f2 = 1.0F * paramAnonymoush.dsl.height() / localRectF.height();
            if (f1 < f2) {}
            for (;;)
            {
              paramAnonymousObject.postScale(f1, f1, paramAnonymoush.dgS.centerX(), paramAnonymoush.dgS.centerY());
              localRectF.set(paramAnonymoush.dsF);
              paramAnonymousObject.mapRect(localRectF);
              paramAnonymoush.dsF.set((int)localRectF.left, (int)localRectF.top, (int)localRectF.right, (int)localRectF.bottom);
              f2 = paramAnonymoush.dgS.centerX();
              float f3 = paramAnonymoush.dgS.centerY();
              paramAnonymousObject = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofInt("rotation", new int[] { 0, -90 }), PropertyValuesHolder.ofInt("deltaX", new int[] { 0, paramAnonymoush.dsl.centerX() - (int)f2 }), PropertyValuesHolder.ofInt("deltaY", new int[] { 0, paramAnonymoush.dsl.centerY() - (int)f3 }) });
              paramAnonymousObject.addUpdateListener(new c.10(paramAnonymoush, f2, f3, f1));
              paramAnonymousObject.addListener(new c.2(paramAnonymoush));
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
            paramAnonymoush.dsp.cancel();
            if (paramAnonymoush.dsE != null) {
              paramAnonymoush.dsE.cancel();
            }
            paramAnonymoush.drS.gth().getBaseBoardView().u(paramAnonymoush.drS.gth().getBaseBoardView().getRawBoardRect());
            if (paramAnonymoush.XU() == null) {
              break label1242;
            }
            paramAnonymousObject = ((com.tencent.mm.cache.a)paramAnonymoush.XU()).alD();
            if (paramAnonymousObject == null) {
              break label1242;
            }
            f2 = paramAnonymoush.getRotation() - paramAnonymoush.b(paramAnonymousObject.mMatrix);
            f1 = f2;
            if (!paramAnonymousObject.hof.isEmpty()) {
              paramAnonymoush.drS.gth().getBaseBoardView().v(paramAnonymousObject.hof);
            }
          }
          break;
        }
        label1242:
        for (float f1 = f2;; f1 = 0.0F)
        {
          paramAnonymoush.drS.gth().getBaseBoardView().a(null, f1, true);
          paramAnonymoush.drS.gth().getActionBar().setVisibility(0);
          a.this.Kyr = ((com.tencent.mm.e.b)a.this.Kyg.get(a.this.Kyo));
          a.this.Kyf.getBaseFooterView().setCurFeatureType(a.this.Kyo);
          AppMethodBeat.o(163137);
          return;
          if (2 == paramAnonymousInt)
          {
            Log.i("MicroMsg.CropArtist", "[doCrop]");
            if (paramAnonymoush.dsE != null) {
              paramAnonymoush.dsE.cancel();
            }
            if (!paramAnonymoush.dsp.dgZ)
            {
              if (!paramAnonymoush.dsp.isStarted)
              {
                paramAnonymoush.dsp.cancel();
                paramAnonymoush.dsp.play();
              }
              paramAnonymoush.dsp.wY = new c.7(paramAnonymoush);
            }
            for (;;)
            {
              a.this.Kyr = ((com.tencent.mm.e.b)a.this.Kyg.get(a.this.Kyo));
              a.this.Kyf.getBaseFooterView().setCurFeatureType(a.this.Kyo);
              AppMethodBeat.o(163137);
              return;
              paramAnonymoush.dsp.wY = null;
              paramAnonymoush.Yg();
            }
          }
          if (3 != paramAnonymousInt) {
            break;
          }
          Log.i("MicroMsg.CropArtist", "[reset]");
          paramAnonymoush.dsH = true;
          paramAnonymoush.dsp.cancel();
          if (paramAnonymoush.dsE != null) {
            paramAnonymoush.dsE.cancel();
          }
          paramAnonymoush.dsF.setEmpty();
          paramAnonymoush.Yf();
          paramAnonymoush.dsx = false;
          paramAnonymoush.drS.gth().getBaseBoardView().u(paramAnonymoush.dgS);
          paramAnonymoush.drS.gth().getBaseBoardView().a(new c.9(paramAnonymoush), paramAnonymoush.getRotation(), true);
          AppMethodBeat.o(163137);
          return;
          paramAnonymoush = (com.tencent.mm.e.f)a.this.gti();
          f1 = ((Float)paramAnonymousObject).floatValue();
          paramAnonymousObject = (com.tencent.mm.cache.e)paramAnonymoush.XU();
          if (paramAnonymousObject != null) {
            paramAnonymousObject.gpC = paramAnonymousInt;
          }
          paramAnonymoush = (com.tencent.mm.cache.e)paramAnonymoush.XU();
          if (paramAnonymoush != null) {
            paramAnonymoush.gpD = f1;
          }
          a.this.Kyf.getBaseBoardView().postInvalidate();
          Log.i("MicroMsg.DrawingPresenter", "lxl postInvalidate");
          break;
        }
      }
      
      public final void cH(boolean paramAnonymousBoolean) {}
    };
    AppMethodBeat.o(9299);
    return local1;
  }
  
  public final boolean gte()
  {
    return this.Kyl;
  }
  
  public final void gtf()
  {
    this.Kyl = false;
  }
  
  public final void gtg()
  {
    AppMethodBeat.i(9304);
    this.Kyf.setFooterVisible(true);
    Ar(false);
    AppMethodBeat.o(9304);
  }
  
  public final com.tencent.mm.view.a gth()
  {
    return this.Kyf;
  }
  
  public final <T extends com.tencent.mm.e.b> T gti()
  {
    AppMethodBeat.i(9306);
    if (this.Kyr != null)
    {
      localb = this.Kyr;
      AppMethodBeat.o(9306);
      return localb;
    }
    Log.e("MicroMsg.DrawingPresenter", "[getCurArtist] is null!");
    com.tencent.mm.e.b localb = com.tencent.mm.e.b.drW;
    AppMethodBeat.o(9306);
    return localb;
  }
  
  public final void gtj()
  {
    this.Kym = 0.8571429F;
  }
  
  public final float gtk()
  {
    return this.Kym;
  }
  
  public final void gtl()
  {
    AppMethodBeat.i(204757);
    Iterator localIterator = this.Kyh.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.e.b localb = (com.tencent.mm.e.b)localIterator.next();
      localb.drV = null;
      localb.XU().clear();
    }
    AppMethodBeat.o(204757);
  }
  
  public final Bitmap gtm()
  {
    return this.Kyj;
  }
  
  public final boolean gtn()
  {
    AppMethodBeat.i(9313);
    if ((gti().XS() != com.tencent.mm.e.a.drO) && (this.Kyk))
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
    if (!this.Kyq)
    {
      this.Kyq = true;
      Iterator localIterator = this.Kyh.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.e.b localb = (com.tencent.mm.e.b)localIterator.next();
        if (ArtistCacheManager.alA().b(localb.XS()))
        {
          localb.onAlive();
          localb.cT(true);
          Log.i("MicroMsg.DrawingPresenter", "[onAttachedToWindow] %s is revert onAlive!", new Object[] { localb.XS() });
        }
      }
      if (this.Kyf.getBaseBoardView().hgb())
      {
        this.Kyf.getBaseBoardView().hgc();
        this.Kyf.getBaseBoardView().invalidate();
      }
    }
    AppMethodBeat.o(9312);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9310);
    Iterator localIterator = this.Kyh.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.e.b)localIterator.next()).onDestroy();
    }
    this.Kyh.clear();
    this.Kyg.clear();
    AppMethodBeat.o(9310);
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9317);
    Iterator localIterator = this.Kyh.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.e.b localb = (com.tencent.mm.e.b)localIterator.next();
      if (localb.isAlive()) {
        if (gti().XS() == localb.XS())
        {
          localb.onDraw(paramCanvas);
        }
        else
        {
          paramCanvas.save();
          paramCanvas.clipRect(this.Kyf.getBaseBoardView().getAliveRect());
          localb.d(paramCanvas);
          paramCanvas.restore();
        }
      }
    }
    AppMethodBeat.o(9317);
  }
  
  public final void onExit()
  {
    AppMethodBeat.i(9300);
    if (this.Kyi != null) {
      this.Kyi.onExit();
    }
    AppMethodBeat.o(9300);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(9302);
    if (this.Kyi != null) {
      this.Kyi.onFinish();
    }
    AppMethodBeat.o(9302);
  }
  
  public final void setActionBarCallback(j paramj)
  {
    this.Kyi = paramj;
  }
  
  public final void setAutoShowFooterAndBar(boolean paramBoolean)
  {
    this.Kyk = paramBoolean;
  }
  
  public final void setInitScale(float paramFloat)
  {
    AppMethodBeat.i(204756);
    this.Kyf.getBaseBoardView().setInitScale(paramFloat);
    AppMethodBeat.o(204756);
  }
  
  public final void setOutputSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204755);
    Log.i("MicroMsg.DrawingPresenter", "setOutputSize width:%d height:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.outputWidth = paramInt1;
    this.outputHeight = paramInt2;
    AppMethodBeat.o(204755);
  }
  
  public final class a
    implements com.tencent.mm.af.a
  {
    View Kyv;
    TextView Kyw;
    ImageView Kyx;
    
    public a()
    {
      AppMethodBeat.i(9289);
      this.Kyv = a.this.Kyf.getRubbishView();
      this.Kyw = ((TextView)this.Kyv.findViewById(2131307193));
      this.Kyx = ((ImageView)this.Kyv.findViewById(2131307191));
      AppMethodBeat.o(9289);
    }
    
    public final void a(com.tencent.mm.z.f paramf)
    {
      AppMethodBeat.i(9294);
      EditText localEditText = (EditText)a.this.Kyf.getTextEditView().findViewById(2131308994);
      localEditText.setTag(paramf);
      if (a.this.Kyn != null)
      {
        a.this.Kyn.b(paramf);
        AppMethodBeat.o(9294);
        return;
      }
      localEditText.setText(paramf.hoI);
      Switch localSwitch = (Switch)a.this.Kyf.findViewById(2131297362);
      SelectColorBar localSelectColorBar = (SelectColorBar)a.this.Kyf.findViewById(2131307511);
      boolean bool;
      if (paramf.mBgColor != 0)
      {
        bool = true;
        localSwitch.setChecked(bool);
        if (!localSwitch.isChecked()) {
          break label168;
        }
        localSelectColorBar.setSelectColor(paramf.mBgColor);
      }
      for (;;)
      {
        localEditText.setTextColor(paramf.mColor);
        localEditText.setTag(paramf);
        a.this.Ar(true);
        AppMethodBeat.o(9294);
        return;
        bool = false;
        break;
        label168:
        localSelectColorBar.setSelectColor(paramf.mColor);
      }
    }
    
    public final void aBB()
    {
      AppMethodBeat.i(9291);
      Log.i("MicroMsg.DrawingPresenter", "[onUnReach]");
      this.Kyv.setActivated(false);
      this.Kyx.setImageDrawable(ar.m(a.this.Kyf.getContext(), 2131690529, -1));
      this.Kyw.setText(a.this.Kyf.getContext().getString(2131764828));
      AppMethodBeat.o(9291);
    }
    
    public final void at(float paramFloat)
    {
      AppMethodBeat.i(9290);
      Log.i("MicroMsg.DrawingPresenter", "[onReach] distance:%s", new Object[] { Float.valueOf(paramFloat) });
      this.Kyv.setActivated(true);
      this.Kyw.setText(a.this.Kyf.getContext().getString(2131764827));
      this.Kyx.setImageDrawable(ar.m(a.this.Kyf.getContext(), 2131690530, -1));
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
      if (a.this.Kyn != null) {
        a.this.Kyn.l(Boolean.TRUE);
      }
      AppMethodBeat.o(9292);
    }
  }
  
  final class b
    implements Runnable
  {
    u Kyy;
    boolean Kyz;
    
    b(u paramu, boolean paramBoolean)
    {
      this.Kyy = paramu;
      this.Kyz = paramBoolean;
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
    
    public final void run()
    {
      AppMethodBeat.i(9295);
      Object localObject4;
      try
      {
        Iterator localIterator1 = a.this.Kyh.iterator();
        while (localIterator1.hasNext()) {
          ((com.tencent.mm.e.b)localIterator1.next()).XW();
        }
        Iterator localIterator2;
        Object localObject3;
        int i;
        int j;
        Object localObject1;
        Bitmap localBitmap1;
        throw localBitmap2;
      }
      catch (Exception localException1)
      {
        com.tencent.f.h.RTc.aV(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(204754);
            a.b.this.Kyy.onError(localException1);
            AppMethodBeat.o(204754);
          }
        });
        try
        {
          localIterator2 = a.this.Kyh.iterator();
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
        if (!a.this.Kyf.getBaseBoardView().hgb())
        {
          i = a.this.Kyf.getBaseBoardView().getAliveRect().width();
          j = a.this.Kyf.getBaseBoardView().getAliveRect().height();
          localObject1 = localObject3;
          if (i <= 0) {
            break label875;
          }
          localObject1 = localObject3;
          if (j <= 0) {
            break label875;
          }
          localObject1 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
          break label875;
        }
        while (localObject1 == null)
        {
          this.Kyy.onError(new NullPointerException("bitmap is null!"));
          try
          {
            localObject1 = a.this.Kyh.iterator();
            while (((Iterator)localObject1).hasNext()) {
              ((com.tencent.mm.e.b)((Iterator)localObject1).next()).onFinish();
            }
            localBitmap1 = a.this.Kyj;
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
        localObject4 = a.this.Kyh.iterator();
        while (((Iterator)localObject4).hasNext()) {
          ((com.tencent.mm.e.b)((Iterator)localObject4).next()).XU().e((Canvas)localObject3);
        }
      }
      finally
      {
        try
        {
          localObject3 = a.this.Kyh.iterator();
          while (((Iterator)localObject3).hasNext()) {
            ((com.tencent.mm.e.b)((Iterator)localObject3).next()).onFinish();
          }
          AppMethodBeat.o(9295);
        }
        catch (Exception localException5) {}
      }
      label394:
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapUtil.decodeFile(a.this.diP.path, localOptions);
      float f3 = localOptions.outHeight * 1.0F / localBitmap2.getHeight();
      float f4 = localOptions.outWidth * 1.0F / localBitmap2.getWidth();
      float f1 = f3;
      float f2 = f4;
      if (a.this.outputHeight > 0)
      {
        f1 = f3;
        f2 = f4;
        if (a.this.outputWidth > 0)
        {
          f1 = a.this.outputHeight * 1.0F / localBitmap2.getHeight();
          f2 = a.this.outputWidth * 1.0F / localBitmap2.getWidth();
        }
      }
      for (;;)
      {
        f1 = a.this.Kyf.getBaseBoardView().b(a.this.Kyf.getBaseBoardView().getMainMatrix());
        localObject4 = new Matrix();
        ((Matrix)localObject4).postScale(f2, f2, 0.0F, 0.0F);
        ((Matrix)localObject4).postRotate(-f1);
        Rect localRect = new Rect(a.this.Kyf.getBaseBoardView().getAliveRect());
        Log.i("MicroMsg.DrawingPresenter", "[saveEditPhoto] clipRectF:%s w:%s h:%s", new Object[] { localRect, Integer.valueOf(localBitmap2.getWidth()), Integer.valueOf(localBitmap2.getHeight()) });
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
        if (localRect.bottom > localBitmap2.getHeight()) {
          localRect.bottom = localBitmap2.getHeight();
        }
        if (localRect.right > localBitmap2.getWidth()) {
          localRect.right = localBitmap2.getWidth();
        }
        Object localObject2 = a(localBitmap2, localRect, f1, localOptions, (Matrix)localObject4);
        com.tencent.f.h.RTc.aV(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(204753);
            a.b.this.Kyy.a(this.ACM, a.b.this.Kyz);
            AppMethodBeat.o(204753);
          }
        });
        try
        {
          localObject2 = a.this.Kyh.iterator();
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
        label875:
        do
        {
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
        label884:
        f2 = f1;
        if (f1 == 0.0F) {
          f2 = 1.0F;
        }
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract boolean b(com.tencent.mm.z.f paramf);
    
    public abstract void l(Boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.bt.a
 * JD-Core Version:    0.7.0.1
 */