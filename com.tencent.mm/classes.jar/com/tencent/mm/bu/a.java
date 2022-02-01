package com.tencent.mm.bu;

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
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.e.a;
import com.tencent.mm.api.p;
import com.tencent.mm.api.s;
import com.tencent.mm.api.w;
import com.tencent.mm.api.y.a;
import com.tencent.mm.cache.ArtistCacheManager;
import com.tencent.mm.e.c;
import com.tencent.mm.e.c.5;
import com.tencent.mm.e.c.7;
import com.tencent.mm.e.c.8;
import com.tencent.mm.e.c.9;
import com.tencent.mm.e.d;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.am;
import com.tencent.mm.view.footer.SelectColorBar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  implements b
{
  com.tencent.mm.view.a Cpd;
  HashMap<com.tencent.mm.api.g, com.tencent.mm.e.b> Cpe;
  LinkedList<com.tencent.mm.e.b> Cpf;
  private com.tencent.mm.api.i Cpg;
  Bitmap Cph;
  private boolean Cpi = true;
  private boolean Cpj = true;
  public c Cpk;
  com.tencent.mm.api.g Cpl = com.tencent.mm.api.g.cJr;
  com.tencent.mm.api.g Cpm = com.tencent.mm.api.g.cJr;
  private boolean Cpn = false;
  com.tencent.mm.e.b Cpo = null;
  y.a cJA;
  
  private void eBy()
  {
    AppMethodBeat.i(9319);
    this.Cpf.clear();
    this.Cpe.clear();
    this.Cpe.put(com.tencent.mm.api.g.cJr, com.tencent.mm.e.b.cRD);
    com.tencent.mm.api.g[] arrayOfg = this.Cpd.getFeatures();
    int k = arrayOfg.length;
    int i = 0;
    Object localObject2;
    Object localObject1;
    int j;
    if (i < k)
    {
      com.tencent.mm.api.g localg = arrayOfg[i];
      localObject2 = null;
      Iterator localIterator = null;
      localObject1 = localIterator;
      switch (7.Cpr[localg.ordinal()])
      {
      default: 
      case 7: 
      case 4: 
        for (localObject1 = localIterator;; localObject1 = new d())
        {
          if (localObject1 != null)
          {
            if (!this.Cpe.containsKey(localg)) {
              this.Cpe.put(localg, localObject1);
            }
            if (!this.Cpf.contains(localObject1))
            {
              this.Cpf.add(localObject1);
              ((com.tencent.mm.e.b)localObject1).a(this, this.Cpd.getBaseBoardView().getMainMatrix(), this.Cpd.getBaseBoardView().getAliveRect());
            }
          }
          i += 1;
          break;
        }
      case 1: 
      case 2: 
        localIterator = this.Cpf.iterator();
        while (localIterator.hasNext())
        {
          localObject1 = (com.tencent.mm.e.b)localIterator.next();
          if (((com.tencent.mm.e.b)localObject1).Mb() == com.tencent.mm.e.a.cRu) {
            j = 1;
          }
        }
      }
    }
    while (j == 0)
    {
      localObject1 = new com.tencent.mm.e.e();
      ((com.tencent.mm.e.e)localObject1).cSL = new a();
      break;
      localObject1 = new com.tencent.mm.e.g();
      break;
      localObject1 = new c();
      break;
      localObject1 = new com.tencent.mm.e.f();
      break;
      Collections.sort(this.Cpf, new Comparator() {});
      ad.i("MicroMsg.DrawingPresenter", "[addArtists] count:%s", new Object[] { Integer.valueOf(this.Cpe.size() - 1) });
      AppMethodBeat.o(9319);
      return;
      j = 0;
      localObject1 = localObject2;
    }
  }
  
  public final boolean IL()
  {
    AppMethodBeat.i(9301);
    if (this.Cpd.getTextEditView().getVisibility() == 0)
    {
      uv(false);
      this.Cpd.setFooterVisible(true);
      AppMethodBeat.o(9301);
      return true;
    }
    if ((this.Cpd.getChatFooterPanel() != null) && (this.Cpd.getChatFooterPanel().getVisibility() == 0))
    {
      this.Cpd.xh(true);
      this.Cpd.setFooterVisible(true);
      AppMethodBeat.o(9301);
      return true;
    }
    AppMethodBeat.o(9301);
    return false;
  }
  
  public final boolean T(MotionEvent paramMotionEvent)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    AppMethodBeat.i(9316);
    boolean bool1 = bool2;
    Object localObject;
    if (eBu().Mb() != com.tencent.mm.e.a.cRv)
    {
      if (eBu().Mb() == com.tencent.mm.e.a.cRw) {
        bool1 = bool2;
      }
    }
    else
    {
      if (bool1) {
        break label224;
      }
      this.Cpo = ((com.tencent.mm.e.b)this.Cpe.get(this.Cpd.getBaseFooterView().getCurFeatureType()));
      localObject = this.Cpf.iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.e.b localb = (com.tencent.mm.e.b)((Iterator)localObject).next();
        if ((localb.Mb() != com.tencent.mm.e.a.cRu) && (localb.p(paramMotionEvent))) {
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
      if (this.Cpe.containsKey(com.tencent.mm.api.g.cJt)) {
        localObject = (com.tencent.mm.e.b)this.Cpe.get(com.tencent.mm.api.g.cJt);
      }
      for (;;)
      {
        bool2 = bool3;
        if (localObject != null) {
          bool2 = ((com.tencent.mm.e.b)localObject).p(paramMotionEvent);
        }
        bool1 = bool2;
        if (!bool2) {
          break;
        }
        this.Cpo = ((com.tencent.mm.e.b)localObject);
        bool1 = bool2;
        break;
        if (this.Cpe.containsKey(com.tencent.mm.api.g.cJu)) {
          localObject = (com.tencent.mm.e.b)this.Cpe.get(com.tencent.mm.api.g.cJu);
        }
      }
    }
  }
  
  public final com.tencent.mm.cache.f a(com.tencent.mm.e.a parama)
  {
    AppMethodBeat.i(9318);
    ArtistCacheManager.Ur();
    parama = ArtistCacheManager.a(this.cJA.path, parama);
    AppMethodBeat.o(9318);
    return parama;
  }
  
  public final void a(Editable paramEditable, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9303);
    uv(false);
    this.Cpd.setFooterVisible(true);
    Object localObject = eBu();
    EditText localEditText;
    if (((com.tencent.mm.e.b)localObject).Mb() == com.tencent.mm.e.a.cRu)
    {
      localObject = (com.tencent.mm.e.e)localObject;
      localEditText = (EditText)this.Cpd.getTextEditView().findViewById(2131305727);
      if ((localEditText.getTag() == null) || (!(localEditText.getTag() instanceof com.tencent.mm.aa.f))) {
        break label119;
      }
      ((com.tencent.mm.e.e)localObject).a((com.tencent.mm.aa.f)localEditText.getTag(), k.c(this.Cpd.getContext(), paramEditable), paramInt1, paramInt2);
    }
    for (;;)
    {
      localEditText.setTag(null);
      AppMethodBeat.o(9303);
      return;
      label119:
      ((com.tencent.mm.e.e)localObject).a(k.c(this.Cpd.getContext(), paramEditable), paramInt1, paramInt2);
    }
  }
  
  public final void a(s params, boolean paramBoolean)
  {
    AppMethodBeat.i(9309);
    com.tencent.mm.sdk.g.b.c(new b(params, paramBoolean), "onFinalGenerate_" + params.hashCode());
    AppMethodBeat.o(9309);
  }
  
  public final void a(y.a parama)
  {
    int i = 0;
    AppMethodBeat.i(9297);
    this.cJA = parama;
    this.Cpe = new HashMap();
    this.Cpf = new LinkedList();
    Object localObject = parama.path;
    if ((bt.isNullOrNil((String)localObject)) || (!com.tencent.mm.vfs.i.eK((String)localObject))) {
      ad.w("MicroMsg.DrawingPresenter", "[checkImage] path:%s", new Object[] { localObject });
    }
    for (;;)
    {
      if (i != 0)
      {
        if (!parama.cJF) {
          break;
        }
        this.Cph = com.tencent.mm.sdk.platformtools.f.decodeFile(parama.path, null);
        if (this.Cph != null) {
          this.Cph = this.Cph.copy(Bitmap.Config.ARGB_8888, true);
        }
      }
      eBy();
      AppMethodBeat.o(9297);
      return;
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      com.tencent.mm.sdk.platformtools.f.decodeFile((String)localObject, localOptions);
      if ((localOptions.outWidth <= 0) || (localOptions.outHeight <= 0)) {
        ad.e("MicroMsg.DrawingPresenter", "[checkImage] image err! w:%s h:%s path:%s", new Object[] { Integer.valueOf(localOptions.outWidth), Integer.valueOf(localOptions.outHeight), localObject });
      } else {
        i = 1;
      }
    }
    localObject = com.tencent.mm.sdk.platformtools.f.aFf(bt.by(parama.path, ""));
    if (localObject != null)
    {
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
    for (int j = 1280;; j = 1280)
    {
      this.Cph = com.tencent.mm.sdk.platformtools.f.aD(bt.by(parama.path, ""), i, j);
      break;
      i = 1280;
    }
  }
  
  public final void a(com.tencent.mm.view.a parama)
  {
    this.Cpd = parama;
  }
  
  public final <T extends com.tencent.mm.e.b> T c(com.tencent.mm.api.g paramg)
  {
    AppMethodBeat.i(9314);
    paramg = (com.tencent.mm.e.b)this.Cpe.get(paramg);
    AppMethodBeat.o(9314);
    return paramg;
  }
  
  public final void c(p paramp)
  {
    AppMethodBeat.i(9315);
    com.tencent.mm.e.e locale = (com.tencent.mm.e.e)c(com.tencent.mm.api.g.cJu);
    if (locale != null) {
      locale.b(paramp);
    }
    AppMethodBeat.o(9315);
  }
  
  public final boolean eBq()
  {
    return this.Cpj;
  }
  
  public final void eBr()
  {
    this.Cpj = false;
  }
  
  public final void eBs()
  {
    AppMethodBeat.i(9304);
    this.Cpd.setFooterVisible(true);
    uv(false);
    AppMethodBeat.o(9304);
  }
  
  public final com.tencent.mm.view.a eBt()
  {
    return this.Cpd;
  }
  
  public final <T extends com.tencent.mm.e.b> T eBu()
  {
    AppMethodBeat.i(9306);
    if (this.Cpo != null)
    {
      localb = this.Cpo;
      AppMethodBeat.o(9306);
      return localb;
    }
    ad.e("MicroMsg.DrawingPresenter", "[getCurArtist] is null!");
    com.tencent.mm.e.b localb = com.tencent.mm.e.b.cRD;
    AppMethodBeat.o(9306);
    return localb;
  }
  
  public final void eBv()
  {
    AppMethodBeat.i(9311);
    ad.i("MicroMsg.DrawingPresenter", "[onLayout]");
    if (!this.Cpn)
    {
      this.Cpn = true;
      Iterator localIterator = this.Cpf.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.e.b localb = (com.tencent.mm.e.b)localIterator.next();
        if (ArtistCacheManager.Ur().b(localb.Mb()))
        {
          localb.onAlive();
          localb.ci(true);
          ad.i("MicroMsg.DrawingPresenter", "[onAttachedToWindow] %s is revert onAlive!", new Object[] { localb.Mb() });
        }
      }
      if (this.Cpd.getBaseBoardView().fiN())
      {
        this.Cpd.getBaseBoardView().fiO();
        this.Cpd.getBaseBoardView().invalidate();
      }
    }
    AppMethodBeat.o(9311);
  }
  
  public final Bitmap eBw()
  {
    return this.Cph;
  }
  
  public final boolean eBx()
  {
    AppMethodBeat.i(9313);
    if ((eBu().Mb() != com.tencent.mm.e.a.cRv) && (this.Cpi))
    {
      AppMethodBeat.o(9313);
      return true;
    }
    AppMethodBeat.o(9313);
    return false;
  }
  
  public final y.a getConfig()
  {
    return this.cJA;
  }
  
  public final float getCurScale()
  {
    AppMethodBeat.i(9308);
    float f = this.Cpd.getBaseBoardView().getCurScale();
    AppMethodBeat.o(9308);
    return f;
  }
  
  public final com.tencent.mm.api.g[] getFeatures()
  {
    AppMethodBeat.i(9298);
    com.tencent.mm.api.g[] arrayOfg = this.Cpd.getFeatures();
    AppMethodBeat.o(9298);
    return arrayOfg;
  }
  
  public final float getInitScale()
  {
    AppMethodBeat.i(9307);
    float f = this.Cpd.getBaseBoardView().getInitScale();
    AppMethodBeat.o(9307);
    return f;
  }
  
  public final w getSelectedFeatureListener()
  {
    AppMethodBeat.i(9299);
    w local1 = new w()
    {
      public final void a(com.tencent.mm.api.g paramAnonymousg)
      {
        AppMethodBeat.i(9279);
        ad.i("MicroMsg.DrawingPresenter", "[onSelectedFeature] features:%s", new Object[] { paramAnonymousg });
        if (paramAnonymousg == com.tencent.mm.api.g.cJr) {
          a.this.Cpd.getBaseFooterView().setCurFeatureType(paramAnonymousg);
        }
        a.this.Cpd.getBaseFooterView().fiX();
        if (a.this.Cpd.getSelectedFeatureListener() != null) {
          a.this.Cpd.getSelectedFeatureListener().a(paramAnonymousg);
        }
        if (paramAnonymousg == com.tencent.mm.api.g.cJx) {
          a.this.Cpd.getFooterBg().setVisibility(8);
        }
        com.tencent.mm.e.b localb = (com.tencent.mm.e.b)a.this.Cpe.get(paramAnonymousg);
        if (localb == null)
        {
          AppMethodBeat.o(9279);
          return;
        }
        if ((localb.cCu) && (!localb.isAlive())) {
          localb.onAlive();
        }
        if (localb.Mb() != com.tencent.mm.e.a.cRr) {
          localb.setOneFingerMoveEnable(false);
        }
        localb.Me();
        a.this.Cpo = localb;
        switch (a.7.Cpr[paramAnonymousg.ordinal()])
        {
        default: 
          a.this.Cpm = paramAnonymousg;
        }
        for (;;)
        {
          a.this.Cpd.getBaseFooterView().setCurFeatureType(paramAnonymousg);
          AppMethodBeat.o(9279);
          return;
          if (!a.this.Cpd.getBaseFooterView().fiS())
          {
            ((EditText)a.this.Cpd.getTextEditView().findViewById(2131305727)).setTextColor(com.tencent.mm.view.footer.a.HZA[0]);
            a.this.uv(true);
            a.this.Cpd.setFooterVisible(false);
          }
          a.this.Cpm = paramAnonymousg;
          continue;
          a.this.Cpd.setActionBarVisible(false);
          a.this.Cpd.setFooterVisible(false);
          a.this.Cpd.xh(false);
          break;
          a.this.Cpl = a.this.Cpm;
        }
      }
      
      public final void a(com.tencent.mm.api.g paramAnonymousg, int paramAnonymousInt, Object paramAnonymousObject)
      {
        AppMethodBeat.i(163137);
        ad.i("MicroMsg.DrawingPresenter", "[onSelectedDetailFeature] features:%s index:%s", new Object[] { paramAnonymousg, Integer.valueOf(paramAnonymousInt) });
        if (a.this.Cpd.getSelectedFeatureListener() != null) {
          a.this.Cpd.getSelectedFeatureListener().a(paramAnonymousg, paramAnonymousInt, paramAnonymousObject);
        }
        a.this.Cpo = ((com.tencent.mm.e.b)a.this.Cpe.get(paramAnonymousg));
        if (a.this.eBu().Mb() == com.tencent.mm.e.a.cRr)
        {
          AppMethodBeat.o(163137);
          return;
        }
        if (a.this.Cpd.getFooterBg().getVisibility() == 8) {
          a.this.Cpd.getFooterBg().setVisibility(0);
        }
        float f2;
        switch (a.7.Cpr[paramAnonymousg.ordinal()])
        {
        default: 
          AppMethodBeat.o(163137);
          return;
        case 4: 
          paramAnonymousg = (d)a.this.eBu();
          if (paramAnonymousInt != -1)
          {
            a.this.Cpd.getBaseFooterView();
            paramAnonymousg.mColor = com.tencent.mm.view.footer.a.getColor(paramAnonymousInt);
            AppMethodBeat.o(163137);
            return;
          }
          paramAnonymousg.Mj();
          AppMethodBeat.o(163137);
          return;
        case 5: 
          paramAnonymousg = (com.tencent.mm.e.g)a.this.eBu();
          if (paramAnonymousInt == 0)
          {
            paramAnonymousg.cSS = e.a.gaQ;
            AppMethodBeat.o(163137);
            return;
          }
          if (1 == paramAnonymousInt)
          {
            paramAnonymousg.cSS = e.a.gaR;
            AppMethodBeat.o(163137);
            return;
          }
          paramAnonymousg.Mj();
          AppMethodBeat.o(163137);
          return;
        case 3: 
          paramAnonymousg = (c)a.this.eBu();
          if (paramAnonymousInt == 0)
          {
            paramAnonymousg.cSm += 1;
            paramAnonymousg.cRW.cancel();
            if (paramAnonymousg.cSk != null) {
              paramAnonymousg.cSk.cancel();
            }
            paramAnonymousObject = new Matrix();
            paramAnonymousObject.postRotate(-90.0F, paramAnonymousg.cHB.centerX(), paramAnonymousg.cHB.centerY());
            if (paramAnonymousg.cSl.isEmpty()) {
              paramAnonymousg.cSl.set(paramAnonymousg.cHB);
            }
            RectF localRectF = new RectF(paramAnonymousg.cSl);
            paramAnonymousObject.mapRect(localRectF);
            f1 = 1.0F * paramAnonymousg.cRS.width() / localRectF.width();
            f2 = 1.0F * paramAnonymousg.cRS.height() / localRectF.height();
            if (f1 < f2) {}
            for (;;)
            {
              paramAnonymousObject.postScale(f1, f1, paramAnonymousg.cHB.centerX(), paramAnonymousg.cHB.centerY());
              localRectF.set(paramAnonymousg.cSl);
              paramAnonymousObject.mapRect(localRectF);
              paramAnonymousg.cSl.set((int)localRectF.left, (int)localRectF.top, (int)localRectF.right, (int)localRectF.bottom);
              f2 = paramAnonymousg.cHB.centerX();
              float f3 = paramAnonymousg.cHB.centerY();
              paramAnonymousObject = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofInt("rotation", new int[] { 0, -90 }), PropertyValuesHolder.ofInt("deltaX", new int[] { 0, paramAnonymousg.cRS.centerX() - (int)f2 }), PropertyValuesHolder.ofInt("deltaY", new int[] { 0, paramAnonymousg.cRS.centerY() - (int)f3 }) });
              paramAnonymousObject.addUpdateListener(new c.8(paramAnonymousg, f2, f3, f1));
              paramAnonymousObject.addListener(new c.9(paramAnonymousg));
              paramAnonymousObject.setDuration(200L);
              paramAnonymousObject.start();
              AppMethodBeat.o(163137);
              return;
              f1 = f2;
            }
          }
          if (1 == paramAnonymousInt)
          {
            ad.i("MicroMsg.CropArtist", "[cancel]");
            paramAnonymousg.cRW.cancel();
            if (paramAnonymousg.cSk != null) {
              paramAnonymousg.cSk.cancel();
            }
            paramAnonymousg.cRz.eBt().getBaseBoardView().HYs = paramAnonymousg.cRz.eBt().getBaseBoardView().getRawBoardRect();
            if (paramAnonymousg.Md() == null) {
              break label1243;
            }
            paramAnonymousObject = ((com.tencent.mm.cache.a)paramAnonymousg.Md()).Uu();
            if (paramAnonymousObject == null) {
              break label1243;
            }
            f2 = paramAnonymousg.getRotation() - paramAnonymousg.b(paramAnonymousObject.mMatrix);
            f1 = f2;
            if (!paramAnonymousObject.gat.isEmpty()) {
              paramAnonymousg.cRz.eBt().getBaseBoardView().s(paramAnonymousObject.gat);
            }
          }
          break;
        }
        label1243:
        for (float f1 = f2;; f1 = 0.0F)
        {
          paramAnonymousg.cRz.eBt().getBaseBoardView().a(null, f1, true);
          paramAnonymousg.cRz.eBt().getActionBar().setVisibility(0);
          a.this.Cpo = ((com.tencent.mm.e.b)a.this.Cpe.get(a.this.Cpl));
          a.this.Cpd.getBaseFooterView().setCurFeatureType(a.this.Cpl);
          AppMethodBeat.o(163137);
          return;
          if (2 == paramAnonymousInt)
          {
            ad.i("MicroMsg.CropArtist", "[doCrop]");
            if (paramAnonymousg.cSk != null) {
              paramAnonymousg.cSk.cancel();
            }
            if (!paramAnonymousg.cRW.cHI)
            {
              if (!paramAnonymousg.cRW.aJn)
              {
                paramAnonymousg.cRW.cancel();
                paramAnonymousg.cRW.play();
              }
              paramAnonymousg.cRW.tX = new c.5(paramAnonymousg);
            }
            for (;;)
            {
              a.this.Cpo = ((com.tencent.mm.e.b)a.this.Cpe.get(a.this.Cpl));
              a.this.Cpd.getBaseFooterView().setCurFeatureType(a.this.Cpl);
              AppMethodBeat.o(163137);
              return;
              paramAnonymousg.cRW.tX = null;
              paramAnonymousg.Mp();
            }
          }
          if (3 != paramAnonymousInt) {
            break;
          }
          ad.i("MicroMsg.CropArtist", "[reset]");
          paramAnonymousg.cSn = true;
          paramAnonymousg.cRW.cancel();
          if (paramAnonymousg.cSk != null) {
            paramAnonymousg.cSk.cancel();
          }
          paramAnonymousg.cSl.setEmpty();
          paramAnonymousg.Mo();
          paramAnonymousg.cSc = false;
          paramAnonymousg.cRz.eBt().getBaseBoardView().HYs = paramAnonymousg.cHB;
          paramAnonymousg.cRz.eBt().getBaseBoardView().a(new c.7(paramAnonymousg), paramAnonymousg.getRotation(), true);
          AppMethodBeat.o(163137);
          return;
          paramAnonymousg = (com.tencent.mm.e.f)a.this.eBu();
          f1 = ((Float)paramAnonymousObject).floatValue();
          paramAnonymousObject = (com.tencent.mm.cache.e)paramAnonymousg.Md();
          if (paramAnonymousObject != null) {
            paramAnonymousObject.fmI = paramAnonymousInt;
          }
          paramAnonymousg = (com.tencent.mm.cache.e)paramAnonymousg.Md();
          if (paramAnonymousg != null) {
            paramAnonymousg.fmJ = f1;
          }
          a.this.Cpd.getBaseBoardView().postInvalidate();
          ad.i("MicroMsg.DrawingPresenter", "lxl postInvalidate");
          break;
        }
      }
      
      public final void bV(boolean paramAnonymousBoolean) {}
    };
    AppMethodBeat.o(9299);
    return local1;
  }
  
  public final void onAttachedToWindow()
  {
    AppMethodBeat.i(9312);
    ad.i("MicroMsg.DrawingPresenter", "[onAttachedToWindow]");
    if (!this.Cpn)
    {
      this.Cpn = true;
      Iterator localIterator = this.Cpf.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.e.b localb = (com.tencent.mm.e.b)localIterator.next();
        if (ArtistCacheManager.Ur().b(localb.Mb()))
        {
          localb.onAlive();
          localb.ci(true);
          ad.i("MicroMsg.DrawingPresenter", "[onAttachedToWindow] %s is revert onAlive!", new Object[] { localb.Mb() });
        }
      }
      if (this.Cpd.getBaseBoardView().fiN())
      {
        this.Cpd.getBaseBoardView().fiO();
        this.Cpd.getBaseBoardView().invalidate();
      }
    }
    AppMethodBeat.o(9312);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9310);
    Iterator localIterator = this.Cpf.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.e.b)localIterator.next()).onDestroy();
    }
    this.Cpf.clear();
    this.Cpe.clear();
    AppMethodBeat.o(9310);
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9317);
    Iterator localIterator = this.Cpf.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.e.b localb = (com.tencent.mm.e.b)localIterator.next();
      if (localb.isAlive()) {
        if (eBu().Mb() == localb.Mb())
        {
          localb.onDraw(paramCanvas);
        }
        else
        {
          paramCanvas.save();
          paramCanvas.clipRect(this.Cpd.getBaseBoardView().getAliveRect());
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
    if (this.Cpg != null) {
      this.Cpg.onExit();
    }
    AppMethodBeat.o(9300);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(9302);
    if (this.Cpg != null) {
      this.Cpg.onFinish();
    }
    AppMethodBeat.o(9302);
  }
  
  public final void setActionBarCallback(com.tencent.mm.api.i parami)
  {
    this.Cpg = parami;
  }
  
  public final void setAutoShowFooterAndBar(boolean paramBoolean)
  {
    this.Cpi = paramBoolean;
  }
  
  public final void setInitScale(float paramFloat)
  {
    AppMethodBeat.i(205057);
    this.Cpd.getBaseBoardView().setInitScale(paramFloat);
    AppMethodBeat.o(205057);
  }
  
  final void uv(boolean paramBoolean)
  {
    AppMethodBeat.i(9320);
    if (paramBoolean)
    {
      localAnimation = AnimationUtils.loadAnimation(this.Cpd.getContext(), 2130772108);
      localAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(9283);
          a.this.Cpd.getTextEditView().setVisibility(0);
          paramAnonymousAnimation = (EditText)a.this.Cpd.getTextEditView().findViewById(2131305727);
          paramAnonymousAnimation.requestFocus();
          paramAnonymousAnimation.setSelection(paramAnonymousAnimation.length());
          a.this.Cpd.getSelectedFeatureListener().bV(true);
          ((SelectColorBar)a.this.Cpd.findViewById(2131304505)).setSelectColor(paramAnonymousAnimation.getCurrentTextColor());
          a.this.Cpd.getActionBar().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9282);
              a.this.Cpd.getActionBar().setVisibility(0);
              AppMethodBeat.o(9282);
            }
          });
          AppMethodBeat.o(9283);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      this.Cpd.getTextEditView().startAnimation(localAnimation);
      AppMethodBeat.o(9320);
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(this.Cpd.getContext(), 2130772106);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(9285);
        ((EditText)a.this.Cpd.getTextEditView().findViewById(2131305727)).setText("");
        a.this.Cpd.getTextEditView().setVisibility(8);
        AppMethodBeat.o(9285);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(9284);
        a.this.Cpd.getSelectedFeatureListener().bV(false);
        AppMethodBeat.o(9284);
      }
    });
    this.Cpd.getTextEditView().startAnimation(localAnimation);
    AppMethodBeat.o(9320);
  }
  
  public final class a
    implements com.tencent.mm.ag.a
  {
    View Cps;
    TextView Cpt;
    ImageView Cpu;
    
    public a()
    {
      AppMethodBeat.i(9289);
      this.Cps = a.this.Cpd.getRubbishView();
      this.Cpt = ((TextView)this.Cps.findViewById(2131304270));
      this.Cpu = ((ImageView)this.Cps.findViewById(2131304268));
      AppMethodBeat.o(9289);
    }
    
    public final void a(com.tencent.mm.aa.f paramf)
    {
      AppMethodBeat.i(9294);
      EditText localEditText = (EditText)a.this.Cpd.getTextEditView().findViewById(2131305727);
      localEditText.setTag(paramf);
      if (a.this.Cpk != null)
      {
        a.this.Cpk.b(paramf);
        AppMethodBeat.o(9294);
        return;
      }
      localEditText.setText(paramf.gaW);
      Switch localSwitch = (Switch)a.this.Cpd.findViewById(2131297210);
      SelectColorBar localSelectColorBar = (SelectColorBar)a.this.Cpd.findViewById(2131304505);
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
        a.this.uv(true);
        AppMethodBeat.o(9294);
        return;
        bool = false;
        break;
        label168:
        localSelectColorBar.setSelectColor(paramf.mColor);
      }
    }
    
    public final void ad(float paramFloat)
    {
      AppMethodBeat.i(9290);
      ad.i("MicroMsg.DrawingPresenter", "[onReach] distance:%s", new Object[] { Float.valueOf(paramFloat) });
      this.Cps.setActivated(true);
      this.Cpt.setText(a.this.Cpd.getContext().getString(2131762742));
      this.Cpu.setImageDrawable(am.i(a.this.Cpd.getContext(), 2131690385, -1));
      AppMethodBeat.o(9290);
    }
    
    public final void agQ()
    {
      AppMethodBeat.i(9291);
      ad.i("MicroMsg.DrawingPresenter", "[onUnReach]");
      this.Cps.setActivated(false);
      this.Cpu.setImageDrawable(am.i(a.this.Cpd.getContext(), 2131690384, -1));
      this.Cpt.setText(a.this.Cpd.getContext().getString(2131762743));
      AppMethodBeat.o(9291);
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
      if (a.this.Cpk != null) {
        a.this.Cpk.h(Boolean.TRUE);
      }
      AppMethodBeat.o(9292);
    }
  }
  
  final class b
    implements Runnable
  {
    s Cpv;
    boolean Cpw;
    
    b(s params, boolean paramBoolean)
    {
      this.Cpv = params;
      this.Cpw = paramBoolean;
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
          ad.printErrStackTrace("MicroMsg.DrawingPresenter", localOutOfMemoryError, "", new Object[0]);
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
        Iterator localIterator1 = a.this.Cpf.iterator();
        while (localIterator1.hasNext()) {
          ((com.tencent.mm.e.b)localIterator1.next()).Mf();
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
        h.Iye.aN(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(190123);
            a.b.this.Cpv.onError(localException1);
            AppMethodBeat.o(190123);
          }
        });
        try
        {
          localIterator2 = a.this.Cpf.iterator();
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
        if (!a.this.Cpd.getBaseBoardView().fiN())
        {
          i = a.this.Cpd.getBaseBoardView().getAliveRect().width();
          j = a.this.Cpd.getBaseBoardView().getAliveRect().height();
          localObject1 = localObject3;
          if (i <= 0) {
            break label811;
          }
          localObject1 = localObject3;
          if (j <= 0) {
            break label811;
          }
          localObject1 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
          break label811;
        }
        while (localObject1 == null)
        {
          this.Cpv.onError(new NullPointerException("bitmap is null!"));
          try
          {
            localObject1 = a.this.Cpf.iterator();
            while (((Iterator)localObject1).hasNext()) {
              ((com.tencent.mm.e.b)((Iterator)localObject1).next()).onFinish();
            }
            localBitmap1 = a.this.Cph;
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
        localObject4 = a.this.Cpf.iterator();
        while (((Iterator)localObject4).hasNext()) {
          ((com.tencent.mm.e.b)((Iterator)localObject4).next()).Md().e((Canvas)localObject3);
        }
      }
      finally
      {
        try
        {
          localObject3 = a.this.Cpf.iterator();
          while (((Iterator)localObject3).hasNext()) {
            ((com.tencent.mm.e.b)((Iterator)localObject3).next()).onFinish();
          }
          AppMethodBeat.o(9295);
        }
        catch (Exception localException5) {}
      }
      label391:
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      com.tencent.mm.sdk.platformtools.f.decodeFile(a.this.cJA.path, localOptions);
      float f1 = localOptions.outHeight * 1.0F / localBitmap2.getHeight();
      float f2 = localOptions.outWidth * 1.0F / localBitmap2.getWidth();
      if (f1 > f2) {
        break label814;
      }
      for (;;)
      {
        f1 = a.this.Cpd.getBaseBoardView().b(a.this.Cpd.getBaseBoardView().getMainMatrix());
        localObject4 = new Matrix();
        ((Matrix)localObject4).postScale(f2, f2, 0.0F, 0.0F);
        ((Matrix)localObject4).postRotate(-f1);
        Rect localRect = new Rect(a.this.Cpd.getBaseBoardView().getAliveRect());
        ad.i("MicroMsg.DrawingPresenter", "[saveEditPhoto] clipRectF:%s w:%s h:%s", new Object[] { localRect, Integer.valueOf(localBitmap2.getWidth()), Integer.valueOf(localBitmap2.getHeight()) });
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
        h.Iye.aN(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(190122);
            a.b.this.Cpv.a(this.udC, a.b.this.Cpw);
            AppMethodBeat.o(190122);
          }
        });
        try
        {
          localObject2 = a.this.Cpf.iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((com.tencent.mm.e.b)((Iterator)localObject2).next()).onFinish();
          }
          f1 = f2;
        }
        catch (Exception localException4)
        {
          AppMethodBeat.o(9295);
          return;
        }
        break label814;
        a.this.onDestroy();
        AppMethodBeat.o(9295);
        return;
        a.this.onDestroy();
        AppMethodBeat.o(9295);
        return;
        a.this.onDestroy();
        break label391;
        label811:
        break;
        label814:
        f2 = f1;
        if (f1 == 0.0F) {
          f2 = 1.0F;
        }
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract boolean b(com.tencent.mm.aa.f paramf);
    
    public abstract void h(Boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bu.a
 * JD-Core Version:    0.7.0.1
 */