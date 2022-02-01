package com.tencent.mm.ca;

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
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.e.a;
import com.tencent.mm.api.ab.a;
import com.tencent.mm.api.ab.c;
import com.tencent.mm.api.j;
import com.tencent.mm.api.r;
import com.tencent.mm.api.z;
import com.tencent.mm.bv.a.e;
import com.tencent.mm.bv.a.g;
import com.tencent.mm.bv.a.h;
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
import com.tencent.mm.ui.au;
import com.tencent.mm.view.footer.SelectColorBar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  implements b
{
  private float RAa = -1.0F;
  public c RAb;
  com.tencent.mm.api.h RAc = com.tencent.mm.api.h.fam;
  com.tencent.mm.api.h RAd = com.tencent.mm.api.h.fam;
  private boolean RAe = false;
  private com.tencent.mm.e.b RAf = null;
  com.tencent.mm.view.a RzT;
  private HashMap<com.tencent.mm.api.h, com.tencent.mm.e.b> RzU;
  private LinkedList<com.tencent.mm.e.b> RzV;
  private j RzW;
  Bitmap RzX;
  private boolean RzY = true;
  private boolean RzZ = true;
  ab.a faw;
  private int outputHeight = -1;
  private int outputWidth = -1;
  
  private void Ew(boolean paramBoolean)
  {
    AppMethodBeat.i(9320);
    if (paramBoolean)
    {
      localAnimation = AnimationUtils.loadAnimation(this.RzT.getContext(), com.tencent.mm.bv.a.a.push_up_in);
      localAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(9283);
          a.this.RzT.getTextEditView().setVisibility(0);
          paramAnonymousAnimation = (EditText)a.this.RzT.getTextEditView().findViewById(a.e.text_edit);
          paramAnonymousAnimation.requestFocus();
          paramAnonymousAnimation.setSelection(paramAnonymousAnimation.length());
          a.this.RzT.getSelectedFeatureListener().dd(true);
          ((SelectColorBar)a.this.RzT.findViewById(a.e.select_color_bar)).setSelectColor(paramAnonymousAnimation.getCurrentTextColor());
          a.this.RzT.getActionBar().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9282);
              a.this.RzT.getActionBar().setVisibility(0);
              AppMethodBeat.o(9282);
            }
          });
          AppMethodBeat.o(9283);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      this.RzT.getTextEditView().startAnimation(localAnimation);
      AppMethodBeat.o(9320);
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(this.RzT.getContext(), com.tencent.mm.bv.a.a.push_down_out);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(9285);
        ((EditText)a.this.RzT.getTextEditView().findViewById(a.e.text_edit)).setText("");
        a.this.RzT.getTextEditView().setVisibility(8);
        AppMethodBeat.o(9285);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(9284);
        a.this.RzT.getSelectedFeatureListener().dd(false);
        AppMethodBeat.o(9284);
      }
    });
    this.RzT.getTextEditView().startAnimation(localAnimation);
    AppMethodBeat.o(9320);
  }
  
  private void hoA()
  {
    AppMethodBeat.i(9319);
    this.RzV.clear();
    this.RzU.clear();
    this.RzU.put(com.tencent.mm.api.h.fam, com.tencent.mm.e.b.fkI);
    com.tencent.mm.api.h[] arrayOfh = this.RzT.getFeatures();
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
      switch (7.RAi[localh.ordinal()])
      {
      default: 
      case 7: 
      case 4: 
        for (localObject1 = localIterator;; localObject1 = new d())
        {
          if (localObject1 != null)
          {
            if (!this.RzU.containsKey(localh)) {
              this.RzU.put(localh, localObject1);
            }
            if (!this.RzV.contains(localObject1))
            {
              this.RzV.add(localObject1);
              ((com.tencent.mm.e.b)localObject1).a(this, this.RzT.getBaseBoardView().getMainMatrix(), this.RzT.getBaseBoardView().getAliveRect());
            }
          }
          i += 1;
          break;
        }
      case 1: 
      case 2: 
        localIterator = this.RzV.iterator();
        while (localIterator.hasNext())
        {
          localObject1 = (com.tencent.mm.e.b)localIterator.next();
          if (((com.tencent.mm.e.b)localObject1).acy() == com.tencent.mm.e.a.fkz) {
            j = 1;
          }
        }
      }
    }
    while (j == 0)
    {
      localObject1 = new com.tencent.mm.e.e();
      ((com.tencent.mm.e.e)localObject1).flT = new a();
      break;
      localObject1 = new com.tencent.mm.e.h();
      break;
      localObject1 = new c();
      break;
      localObject1 = new com.tencent.mm.e.f();
      break;
      Collections.sort(this.RzV, new Comparator() {});
      Log.i("MicroMsg.DrawingPresenter", "[addArtists] count:%s", new Object[] { Integer.valueOf(this.RzU.size() - 1) });
      AppMethodBeat.o(9319);
      return;
      j = 0;
      localObject1 = localObject2;
    }
  }
  
  public final boolean X(MotionEvent paramMotionEvent)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    AppMethodBeat.i(9316);
    boolean bool1 = bool2;
    Object localObject;
    if (hov().acy() != com.tencent.mm.e.a.fkA)
    {
      if (hov().acy() == com.tencent.mm.e.a.fkB) {
        bool1 = bool2;
      }
    }
    else
    {
      if (bool1) {
        break label224;
      }
      this.RAf = ((com.tencent.mm.e.b)this.RzU.get(this.RzT.getBaseFooterView().getCurFeatureType()));
      localObject = this.RzV.iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.e.b localb = (com.tencent.mm.e.b)((Iterator)localObject).next();
        if ((localb.acy() != com.tencent.mm.e.a.fkz) && (localb.q(paramMotionEvent))) {
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
      if (this.RzU.containsKey(com.tencent.mm.api.h.fao)) {
        localObject = (com.tencent.mm.e.b)this.RzU.get(com.tencent.mm.api.h.fao);
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
        this.RAf = ((com.tencent.mm.e.b)localObject);
        bool1 = bool2;
        break;
        if (this.RzU.containsKey(com.tencent.mm.api.h.fap)) {
          localObject = (com.tencent.mm.e.b)this.RzU.get(com.tencent.mm.api.h.fap);
        }
      }
    }
  }
  
  public final boolean YD()
  {
    AppMethodBeat.i(9301);
    if (this.RzT.getTextEditView().getVisibility() == 0)
    {
      Ew(false);
      this.RzT.setFooterVisible(true);
      AppMethodBeat.o(9301);
      return true;
    }
    if ((this.RzT.getChatFooterPanel() != null) && (this.RzT.getChatFooterPanel().getVisibility() == 0))
    {
      this.RzT.Ic(true);
      this.RzT.setFooterVisible(true);
      AppMethodBeat.o(9301);
      return true;
    }
    AppMethodBeat.o(9301);
    return false;
  }
  
  public final com.tencent.mm.cache.f a(com.tencent.mm.e.a parama)
  {
    AppMethodBeat.i(9318);
    ArtistCacheManager localArtistCacheManager = ArtistCacheManager.arz();
    String str = this.faw.path;
    if (TextUtils.isEmpty(str))
    {
      if (ArtistCacheManager.iTz.containsKey(localArtistCacheManager.iTB))
      {
        parama = ((ArtistCacheManager.a)ArtistCacheManager.iTz.get(localArtistCacheManager.iTB)).c(parama);
        AppMethodBeat.o(9318);
        return parama;
      }
      Log.e("MicroMsg.ArtistCacheManager", "[getArtistCache] id is not contains! %s", new Object[] { localArtistCacheManager.iTB });
      AppMethodBeat.o(9318);
      return null;
    }
    if (ArtistCacheManager.iTz.containsKey(str))
    {
      parama = ((ArtistCacheManager.a)ArtistCacheManager.iTz.get(str)).c(parama);
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
      aQ(paramEditable.toString(), paramInt1, paramInt2);
    }
    AppMethodBeat.o(9303);
  }
  
  public final void a(ab.a parama)
  {
    AppMethodBeat.i(9297);
    this.faw = parama;
    this.RzU = new HashMap();
    this.RzV = new LinkedList();
    Object localObject = parama.path;
    int i;
    if ((Util.isNullOrNil((String)localObject)) || (!com.tencent.mm.vfs.u.agG((String)localObject)))
    {
      Log.w("MicroMsg.DrawingPresenter", "[checkImage] path:%s", new Object[] { localObject });
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        if (parama.faB)
        {
          this.RzX = BitmapUtil.decodeFile(parama.path, null);
          if (this.RzX != null) {
            this.RzX = this.RzX.copy(Bitmap.Config.ARGB_8888, true);
          }
          hoA();
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
      this.RzX = BitmapUtil.createThumbBitmap(Util.nullAs(parama.path, ""), i, j, true, false);
      break;
      if (parama.fay == ab.c.faH)
      {
        this.RzX = BitmapUtil.createColorBitmap(parama.backgroundColor, parama.faC.width(), parama.faC.height());
        break;
      }
      if (this.RzX != null) {
        break;
      }
      this.RzX = BitmapUtil.createColorBitmap(0, 1280, 1280);
      break;
      label432:
      i = 1280;
    }
  }
  
  public final void a(com.tencent.mm.api.u paramu, boolean paramBoolean)
  {
    AppMethodBeat.i(9309);
    ThreadPool.post(new b(paramu, paramBoolean), "onFinalGenerate_" + paramu.hashCode());
    AppMethodBeat.o(9309);
  }
  
  public final void a(com.tencent.mm.view.a parama)
  {
    this.RzT = parama;
  }
  
  public final void aQ(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(259835);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(259835);
      return;
    }
    Ew(false);
    this.RzT.setFooterVisible(true);
    Object localObject = hov();
    EditText localEditText;
    if (((com.tencent.mm.e.b)localObject).acy() == com.tencent.mm.e.a.fkz)
    {
      localObject = (com.tencent.mm.e.e)localObject;
      localEditText = (EditText)this.RzT.getTextEditView().findViewById(a.e.text_edit);
      if ((localEditText.getTag() == null) || (!(localEditText.getTag() instanceof com.tencent.mm.ab.f))) {
        break label133;
      }
      ((com.tencent.mm.e.e)localObject).a((com.tencent.mm.ab.f)localEditText.getTag(), l.c(this.RzT.getContext(), paramString), paramInt1, paramInt2);
    }
    for (;;)
    {
      localEditText.setTag(null);
      AppMethodBeat.o(259835);
      return;
      label133:
      ((com.tencent.mm.e.e)localObject).a(l.c(this.RzT.getContext(), paramString), paramInt1, paramInt2);
    }
  }
  
  public final void azS()
  {
    AppMethodBeat.i(9311);
    Log.i("MicroMsg.DrawingPresenter", "[onLayout],%s", new Object[] { Boolean.valueOf(this.RAe) });
    if (!this.RAe)
    {
      this.RAe = true;
      Iterator localIterator = this.RzV.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.e.b localb = (com.tencent.mm.e.b)localIterator.next();
        if (ArtistCacheManager.arz().b(localb.acy()))
        {
          localb.onAlive();
          localb.dq(true);
          Log.i("MicroMsg.DrawingPresenter", "[onAttachedToWindow] %s is revert onAlive!", new Object[] { localb.acy() });
        }
      }
      if (this.RzT.getBaseBoardView().ihB())
      {
        this.RzT.getBaseBoardView().ihC();
        this.RzT.getBaseBoardView().invalidate();
      }
    }
    AppMethodBeat.o(9311);
  }
  
  public final <T extends com.tencent.mm.e.b> T c(com.tencent.mm.api.h paramh)
  {
    AppMethodBeat.i(9314);
    paramh = (com.tencent.mm.e.b)this.RzU.get(paramh);
    AppMethodBeat.o(9314);
    return paramh;
  }
  
  public final void c(r paramr)
  {
    AppMethodBeat.i(9315);
    com.tencent.mm.e.e locale = (com.tencent.mm.e.e)c(com.tencent.mm.api.h.fap);
    if (locale != null) {
      locale.b(paramr);
    }
    AppMethodBeat.o(9315);
  }
  
  public final void cv(float paramFloat)
  {
    this.RAa = paramFloat;
  }
  
  public final ab.a getConfig()
  {
    return this.faw;
  }
  
  public final float getCurScale()
  {
    AppMethodBeat.i(9308);
    float f = this.RzT.getBaseBoardView().getCurScale();
    AppMethodBeat.o(9308);
    return f;
  }
  
  public final com.tencent.mm.api.h[] getFeatures()
  {
    AppMethodBeat.i(9298);
    com.tencent.mm.api.h[] arrayOfh = this.RzT.getFeatures();
    AppMethodBeat.o(9298);
    return arrayOfh;
  }
  
  public final float getInitScale()
  {
    AppMethodBeat.i(9307);
    float f = this.RzT.getBaseBoardView().getInitScale();
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
        if (paramAnonymoush == com.tencent.mm.api.h.fam) {
          a.a(a.this).getBaseFooterView().setCurFeatureType(paramAnonymoush);
        }
        a.a(a.this).getBaseFooterView().ihM();
        if (a.a(a.this).getSelectedFeatureListener() != null) {
          a.a(a.this).getSelectedFeatureListener().a(paramAnonymoush);
        }
        if (paramAnonymoush == com.tencent.mm.api.h.fas) {
          a.this.RzT.getFooterBg().setVisibility(8);
        }
        com.tencent.mm.e.b localb = (com.tencent.mm.e.b)a.b(a.this).get(paramAnonymoush);
        if (localb == null)
        {
          AppMethodBeat.o(9279);
          return;
        }
        if ((localb.dfI) && (!localb.isAlive())) {
          localb.onAlive();
        }
        if (localb.acy() != com.tencent.mm.e.a.fkw) {
          localb.setOneFingerMoveEnable(false);
        }
        localb.acB();
        a.a(a.this, localb);
        switch (a.7.RAi[paramAnonymoush.ordinal()])
        {
        default: 
          a.this.RAd = paramAnonymoush;
        }
        for (;;)
        {
          a.a(a.this).getBaseFooterView().setCurFeatureType(paramAnonymoush);
          AppMethodBeat.o(9279);
          return;
          if (!a.this.RzT.getBaseFooterView().ihH())
          {
            ((EditText)a.this.RzT.getTextEditView().findViewById(a.e.text_edit)).setTextColor(com.tencent.mm.view.footer.a.YQk[0]);
            a.c(a.this);
            a.this.RzT.setFooterVisible(false);
          }
          a.this.RAd = paramAnonymoush;
          continue;
          a.this.RzT.setActionBarVisible(false);
          a.this.RzT.setFooterVisible(false);
          a.this.RzT.Ic(false);
          break;
          a.this.RAc = a.this.RAd;
        }
      }
      
      public final void a(com.tencent.mm.api.h paramAnonymoush, int paramAnonymousInt, Object paramAnonymousObject)
      {
        AppMethodBeat.i(163137);
        Log.i("MicroMsg.DrawingPresenter", "[onSelectedDetailFeature] features:%s index:%s", new Object[] { paramAnonymoush, Integer.valueOf(paramAnonymousInt) });
        if (a.a(a.this).getSelectedFeatureListener() != null) {
          a.a(a.this).getSelectedFeatureListener().a(paramAnonymoush, paramAnonymousInt, paramAnonymousObject);
        }
        a.a(a.this, (com.tencent.mm.e.b)a.b(a.this).get(paramAnonymoush));
        if (a.this.hov().acy() == com.tencent.mm.e.a.fkw)
        {
          AppMethodBeat.o(163137);
          return;
        }
        if (a.this.RzT.getFooterBg().getVisibility() == 8) {
          a.this.RzT.getFooterBg().setVisibility(0);
        }
        float f2;
        switch (a.7.RAi[paramAnonymoush.ordinal()])
        {
        default: 
          AppMethodBeat.o(163137);
          return;
        case 4: 
          paramAnonymoush = (d)a.this.hov();
          if (paramAnonymousInt != -1)
          {
            paramAnonymoush.mColor = a.this.RzT.getBaseFooterView().getColor(paramAnonymousInt);
            AppMethodBeat.o(163137);
            return;
          }
          paramAnonymoush.acG();
          AppMethodBeat.o(163137);
          return;
        case 5: 
          paramAnonymoush = (com.tencent.mm.e.h)a.this.hov();
          if (paramAnonymousInt == 0)
          {
            paramAnonymoush.fmg = e.a.kat;
            AppMethodBeat.o(163137);
            return;
          }
          if (1 == paramAnonymousInt)
          {
            paramAnonymoush.fmg = e.a.kau;
            AppMethodBeat.o(163137);
            return;
          }
          paramAnonymoush.acG();
          AppMethodBeat.o(163137);
          return;
        case 3: 
          paramAnonymoush = (c)a.this.hov();
          if (paramAnonymousInt == 0)
          {
            paramAnonymoush.fls += 1;
            paramAnonymoush.flc.cancel();
            if (paramAnonymoush.flq != null) {
              paramAnonymoush.flq.cancel();
            }
            paramAnonymousObject = new Matrix();
            paramAnonymousObject.postRotate(-90.0F, paramAnonymoush.eYz.centerX(), paramAnonymoush.eYz.centerY());
            if (paramAnonymoush.flr.isEmpty()) {
              paramAnonymoush.flr.set(paramAnonymoush.eYz);
            }
            RectF localRectF = new RectF(paramAnonymoush.flr);
            paramAnonymousObject.mapRect(localRectF);
            f1 = 1.0F * paramAnonymoush.fkY.width() / localRectF.width();
            f2 = 1.0F * paramAnonymoush.fkY.height() / localRectF.height();
            if (f1 < f2) {}
            for (;;)
            {
              paramAnonymousObject.postScale(f1, f1, paramAnonymoush.eYz.centerX(), paramAnonymoush.eYz.centerY());
              localRectF.set(paramAnonymoush.flr);
              paramAnonymousObject.mapRect(localRectF);
              paramAnonymoush.flr.set((int)localRectF.left, (int)localRectF.top, (int)localRectF.right, (int)localRectF.bottom);
              f2 = paramAnonymoush.eYz.centerX();
              float f3 = paramAnonymoush.eYz.centerY();
              paramAnonymousObject = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofInt("rotation", new int[] { 0, -90 }), PropertyValuesHolder.ofInt("deltaX", new int[] { 0, paramAnonymoush.fkY.centerX() - (int)f2 }), PropertyValuesHolder.ofInt("deltaY", new int[] { 0, paramAnonymoush.fkY.centerY() - (int)f3 }) });
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
            paramAnonymoush.flc.cancel();
            if (paramAnonymoush.flq != null) {
              paramAnonymoush.flq.cancel();
            }
            paramAnonymoush.fkE.hou().getBaseBoardView().E(paramAnonymoush.fkE.hou().getBaseBoardView().getRawBoardRect());
            if (paramAnonymoush.acA() == null) {
              break label1244;
            }
            paramAnonymousObject = ((com.tencent.mm.cache.a)paramAnonymoush.acA()).arC();
            if (paramAnonymousObject == null) {
              break label1244;
            }
            f2 = paramAnonymoush.getRotation() - paramAnonymoush.b(paramAnonymousObject.aqj);
            f1 = f2;
            if (!paramAnonymousObject.jZW.isEmpty()) {
              paramAnonymoush.fkE.hou().getBaseBoardView().F(paramAnonymousObject.jZW);
            }
          }
          break;
        }
        label1244:
        for (float f1 = f2;; f1 = 0.0F)
        {
          paramAnonymoush.fkE.hou().getBaseBoardView().a(null, f1, true);
          paramAnonymoush.fkE.hou().getActionBar().setVisibility(0);
          a.a(a.this, (com.tencent.mm.e.b)a.b(a.this).get(a.this.RAc));
          a.this.RzT.getBaseFooterView().setCurFeatureType(a.this.RAc);
          AppMethodBeat.o(163137);
          return;
          if (2 == paramAnonymousInt)
          {
            Log.i("MicroMsg.CropArtist", "[doCrop]");
            if (paramAnonymoush.flq != null) {
              paramAnonymoush.flq.cancel();
            }
            if (!paramAnonymoush.flc.eYG)
            {
              if (!paramAnonymoush.flc.isStarted)
              {
                paramAnonymoush.flc.cancel();
                paramAnonymoush.flc.play();
              }
              paramAnonymoush.flc.atS = new c.7(paramAnonymoush);
            }
            for (;;)
            {
              a.a(a.this, (com.tencent.mm.e.b)a.b(a.this).get(a.this.RAc));
              a.this.RzT.getBaseFooterView().setCurFeatureType(a.this.RAc);
              AppMethodBeat.o(163137);
              return;
              paramAnonymoush.flc.atS = null;
              paramAnonymoush.acM();
            }
          }
          if (3 != paramAnonymousInt) {
            break;
          }
          Log.i("MicroMsg.CropArtist", "[reset]");
          paramAnonymoush.flt = true;
          paramAnonymoush.flc.cancel();
          if (paramAnonymoush.flq != null) {
            paramAnonymoush.flq.cancel();
          }
          paramAnonymoush.flr.setEmpty();
          paramAnonymoush.acL();
          paramAnonymoush.flj = false;
          paramAnonymoush.fkE.hou().getBaseBoardView().E(paramAnonymoush.eYz);
          paramAnonymoush.fkE.hou().getBaseBoardView().a(new c.9(paramAnonymoush), paramAnonymoush.getRotation(), true);
          AppMethodBeat.o(163137);
          return;
          paramAnonymoush = (com.tencent.mm.e.f)a.this.hov();
          f1 = ((Float)paramAnonymousObject).floatValue();
          paramAnonymousObject = (com.tencent.mm.cache.e)paramAnonymoush.acA();
          if (paramAnonymousObject != null) {
            paramAnonymousObject.iTK = paramAnonymousInt;
          }
          paramAnonymoush = (com.tencent.mm.cache.e)paramAnonymoush.acA();
          if (paramAnonymoush != null) {
            paramAnonymoush.iTL = f1;
          }
          a.this.RzT.getBaseBoardView().postInvalidate();
          Log.i("MicroMsg.DrawingPresenter", "lxl postInvalidate");
          break;
        }
      }
      
      public final void dd(boolean paramAnonymousBoolean) {}
    };
    AppMethodBeat.o(9299);
    return local1;
  }
  
  public final boolean hor()
  {
    return this.RzZ;
  }
  
  public final void hos()
  {
    this.RzZ = false;
  }
  
  public final void hot()
  {
    AppMethodBeat.i(9304);
    this.RzT.setFooterVisible(true);
    Ew(false);
    AppMethodBeat.o(9304);
  }
  
  public final com.tencent.mm.view.a hou()
  {
    return this.RzT;
  }
  
  public final <T extends com.tencent.mm.e.b> T hov()
  {
    AppMethodBeat.i(9306);
    if (this.RAf != null)
    {
      localb = this.RAf;
      AppMethodBeat.o(9306);
      return localb;
    }
    Log.e("MicroMsg.DrawingPresenter", "[getCurArtist] is null!");
    com.tencent.mm.e.b localb = com.tencent.mm.e.b.fkI;
    AppMethodBeat.o(9306);
    return localb;
  }
  
  public final float how()
  {
    return this.RAa;
  }
  
  public final void hox()
  {
    AppMethodBeat.i(259841);
    Iterator localIterator = this.RzV.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.e.b localb = (com.tencent.mm.e.b)localIterator.next();
      localb.fkH = null;
      localb.acA().clear();
    }
    AppMethodBeat.o(259841);
  }
  
  public final Bitmap hoy()
  {
    return this.RzX;
  }
  
  public final boolean hoz()
  {
    AppMethodBeat.i(9313);
    if ((hov().acy() != com.tencent.mm.e.a.fkA) && (this.RzY))
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
    if (!this.RAe)
    {
      this.RAe = true;
      Iterator localIterator = this.RzV.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.e.b localb = (com.tencent.mm.e.b)localIterator.next();
        if (ArtistCacheManager.arz().b(localb.acy()))
        {
          localb.onAlive();
          localb.dq(true);
          Log.i("MicroMsg.DrawingPresenter", "[onAttachedToWindow] %s is revert onAlive!", new Object[] { localb.acy() });
        }
      }
      if (this.RzT.getBaseBoardView().ihB())
      {
        this.RzT.getBaseBoardView().ihC();
        this.RzT.getBaseBoardView().invalidate();
      }
    }
    AppMethodBeat.o(9312);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9310);
    Iterator localIterator = this.RzV.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.e.b)localIterator.next()).onDestroy();
    }
    this.RzV.clear();
    this.RzU.clear();
    AppMethodBeat.o(9310);
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9317);
    Iterator localIterator = this.RzV.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.e.b localb = (com.tencent.mm.e.b)localIterator.next();
      if (localb.isAlive()) {
        if (hov().acy() == localb.acy())
        {
          localb.onDraw(paramCanvas);
        }
        else
        {
          paramCanvas.save();
          paramCanvas.clipRect(this.RzT.getBaseBoardView().getAliveRect());
          localb.e(paramCanvas);
          paramCanvas.restore();
        }
      }
    }
    AppMethodBeat.o(9317);
  }
  
  public final void onExit()
  {
    AppMethodBeat.i(9300);
    if (this.RzW != null) {
      this.RzW.onExit();
    }
    AppMethodBeat.o(9300);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(9302);
    if (this.RzW != null) {
      this.RzW.onFinish();
    }
    AppMethodBeat.o(9302);
  }
  
  public final void setActionBarCallback(j paramj)
  {
    this.RzW = paramj;
  }
  
  public final void setAutoShowFooterAndBar(boolean paramBoolean)
  {
    this.RzY = paramBoolean;
  }
  
  public final void setInitScale(float paramFloat)
  {
    AppMethodBeat.i(259836);
    this.RzT.getBaseBoardView().setInitScale(paramFloat);
    AppMethodBeat.o(259836);
  }
  
  public final void setOutputSize(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(259830);
    Log.i("MicroMsg.DrawingPresenter", "setOutputSize width:%d height:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    this.outputWidth = paramInt1;
    this.outputHeight = paramInt2;
    AppMethodBeat.o(259830);
  }
  
  public final class a
    implements com.tencent.mm.ai.a
  {
    View RAj;
    TextView RAk;
    ImageView RAl;
    
    public a()
    {
      AppMethodBeat.i(9289);
      this.RAj = a.this.RzT.getRubbishView();
      this.RAk = ((TextView)this.RAj.findViewById(a.e.rubbish_tip));
      this.RAl = ((ImageView)this.RAj.findViewById(a.e.rubbish_icon));
      AppMethodBeat.o(9289);
    }
    
    public final void a(com.tencent.mm.ab.f paramf)
    {
      AppMethodBeat.i(9294);
      EditText localEditText = (EditText)a.this.RzT.getTextEditView().findViewById(a.e.text_edit);
      localEditText.setTag(paramf);
      if (a.this.RAb != null)
      {
        a.this.RAb.b(paramf);
        AppMethodBeat.o(9294);
        return;
      }
      localEditText.setText(paramf.kaz);
      Switch localSwitch = (Switch)a.this.RzT.findViewById(a.e.bg_switch);
      SelectColorBar localSelectColorBar = (SelectColorBar)a.this.RzT.findViewById(a.e.select_color_bar);
      boolean bool;
      if (paramf.mBgColor != 0)
      {
        bool = true;
        localSwitch.setChecked(bool);
        if (!localSwitch.isChecked()) {
          break label170;
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
        label170:
        localSelectColorBar.setSelectColor(paramf.mColor);
      }
    }
    
    public final void aJe()
    {
      AppMethodBeat.i(9291);
      Log.i("MicroMsg.DrawingPresenter", "[onUnReach]");
      this.RAj.setActivated(false);
      this.RAl.setImageDrawable(au.o(a.this.RzT.getContext(), a.g.icons_filled_delete, -1));
      this.RAk.setText(a.this.RzT.getContext().getString(a.h.rubbish_unreached_tip));
      AppMethodBeat.o(9291);
    }
    
    public final void at(float paramFloat)
    {
      AppMethodBeat.i(9290);
      Log.i("MicroMsg.DrawingPresenter", "[onReach] distance:%s", new Object[] { Float.valueOf(paramFloat) });
      this.RAj.setActivated(true);
      this.RAk.setText(a.this.RzT.getContext().getString(a.h.rubbish_reached_tip));
      this.RAl.setImageDrawable(au.o(a.this.RzT.getContext(), a.g.icons_filled_delete_on, -1));
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
      if (a.this.RAb != null) {
        a.this.RAb.t(Boolean.TRUE);
      }
      AppMethodBeat.o(9292);
    }
  }
  
  final class b
    implements Runnable
  {
    com.tencent.mm.api.u RAm;
    boolean RAn;
    
    b(com.tencent.mm.api.u paramu, boolean paramBoolean)
    {
      this.RAm = paramu;
      this.RAn = paramBoolean;
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
    
    private Rect aH(Bitmap paramBitmap)
    {
      AppMethodBeat.i(260183);
      Rect localRect = new Rect(a.this.RzT.getBaseBoardView().getAliveRect());
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
      AppMethodBeat.o(260183);
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
          ((com.tencent.mm.e.b)localIterator1.next()).acC();
        }
        Iterator localIterator2;
        Object localObject3;
        Object localObject1;
        Bitmap localBitmap1;
        throw localBitmap2;
      }
      catch (Exception localException1)
      {
        com.tencent.e.h.ZvG.bc(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(260263);
            a.b.this.RAm.onError(localException1);
            AppMethodBeat.o(260263);
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
        if (!a.this.RzT.getBaseBoardView().ihB())
        {
          i = a.this.RzT.getBaseBoardView().getAliveRect().width();
          j = a.this.RzT.getBaseBoardView().getAliveRect().height();
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
          this.RAm.onError(new NullPointerException("bitmap is null!"));
          try
          {
            localObject1 = a.d(a.this).iterator();
            while (((Iterator)localObject1).hasNext()) {
              ((com.tencent.mm.e.b)((Iterator)localObject1).next()).onFinish();
            }
            localBitmap1 = a.this.RzX;
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
          ((com.tencent.mm.e.b)((Iterator)localObject4).next()).acA().f((Canvas)localObject3);
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
      BitmapUtil.decodeFile(a.this.faw.path, (BitmapFactory.Options)localObject4);
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
        f1 = a.this.RzT.getBaseBoardView().b(a.this.RzT.getBaseBoardView().getMainMatrix());
        Matrix localMatrix = new Matrix();
        localMatrix.postScale(f2, f2, 0.0F, 0.0F);
        localMatrix.postRotate(-f1);
        Rect localRect;
        if (a.g(a.this) > 0.0F)
        {
          localRect = aH(localBitmap2);
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
            com.tencent.e.h.ZvG.bc(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(260390);
                a.b.this.RAm.a(this.GvQ, a.b.this.RAn);
                AppMethodBeat.o(260390);
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
          localRect = aH(localException4);
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
    public abstract boolean b(com.tencent.mm.ab.f paramf);
    
    public abstract void t(Boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ca.a
 * JD-Core Version:    0.7.0.1
 */