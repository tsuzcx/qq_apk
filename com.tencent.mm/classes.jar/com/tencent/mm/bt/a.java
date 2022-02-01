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
import com.tencent.mm.api.p;
import com.tencent.mm.api.s;
import com.tencent.mm.api.w;
import com.tencent.mm.api.y.a;
import com.tencent.mm.cache.ArtistCacheManager;
import com.tencent.mm.e.c;
import com.tencent.mm.e.c.10;
import com.tencent.mm.e.c.2;
import com.tencent.mm.e.c.7;
import com.tencent.mm.e.c.9;
import com.tencent.mm.e.d;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.am;
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
  private boolean DHA = true;
  private boolean DHB = true;
  public c DHC;
  com.tencent.mm.api.g DHD = com.tencent.mm.api.g.cGy;
  com.tencent.mm.api.g DHE = com.tencent.mm.api.g.cGy;
  private boolean DHF = false;
  com.tencent.mm.e.b DHG = null;
  com.tencent.mm.view.a DHv;
  HashMap<com.tencent.mm.api.g, com.tencent.mm.e.b> DHw;
  LinkedList<com.tencent.mm.e.b> DHx;
  private com.tencent.mm.api.i DHy;
  Bitmap DHz;
  y.a cGH;
  
  private void eQS()
  {
    AppMethodBeat.i(9319);
    this.DHx.clear();
    this.DHw.clear();
    this.DHw.put(com.tencent.mm.api.g.cGy, com.tencent.mm.e.b.cOY);
    com.tencent.mm.api.g[] arrayOfg = this.DHv.getFeatures();
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
      switch (7.DHJ[localg.ordinal()])
      {
      default: 
      case 7: 
      case 4: 
        for (localObject1 = localIterator;; localObject1 = new d())
        {
          if (localObject1 != null)
          {
            if (!this.DHw.containsKey(localg)) {
              this.DHw.put(localg, localObject1);
            }
            if (!this.DHx.contains(localObject1))
            {
              this.DHx.add(localObject1);
              ((com.tencent.mm.e.b)localObject1).a(this, this.DHv.getBaseBoardView().getMainMatrix(), this.DHv.getBaseBoardView().getAliveRect());
            }
          }
          i += 1;
          break;
        }
      case 1: 
      case 2: 
        localIterator = this.DHx.iterator();
        while (localIterator.hasNext())
        {
          localObject1 = (com.tencent.mm.e.b)localIterator.next();
          if (((com.tencent.mm.e.b)localObject1).LZ() == com.tencent.mm.e.a.cOP) {
            j = 1;
          }
        }
      }
    }
    while (j == 0)
    {
      localObject1 = new com.tencent.mm.e.e();
      ((com.tencent.mm.e.e)localObject1).cQi = new a();
      break;
      localObject1 = new com.tencent.mm.e.g();
      break;
      localObject1 = new c();
      break;
      localObject1 = new com.tencent.mm.e.f();
      break;
      Collections.sort(this.DHx, new Comparator() {});
      ac.i("MicroMsg.DrawingPresenter", "[addArtists] count:%s", new Object[] { Integer.valueOf(this.DHw.size() - 1) });
      AppMethodBeat.o(9319);
      return;
      j = 0;
      localObject1 = localObject2;
    }
  }
  
  public final boolean Iu()
  {
    AppMethodBeat.i(9301);
    if (this.DHv.getTextEditView().getVisibility() == 0)
    {
      vx(false);
      this.DHv.setFooterVisible(true);
      AppMethodBeat.o(9301);
      return true;
    }
    if ((this.DHv.getChatFooterPanel() != null) && (this.DHv.getChatFooterPanel().getVisibility() == 0))
    {
      this.DHv.yq(true);
      this.DHv.setFooterVisible(true);
      AppMethodBeat.o(9301);
      return true;
    }
    AppMethodBeat.o(9301);
    return false;
  }
  
  public final boolean R(MotionEvent paramMotionEvent)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    AppMethodBeat.i(9316);
    boolean bool1 = bool2;
    Object localObject;
    if (eQO().LZ() != com.tencent.mm.e.a.cOQ)
    {
      if (eQO().LZ() == com.tencent.mm.e.a.cOR) {
        bool1 = bool2;
      }
    }
    else
    {
      if (bool1) {
        break label224;
      }
      this.DHG = ((com.tencent.mm.e.b)this.DHw.get(this.DHv.getBaseFooterView().getCurFeatureType()));
      localObject = this.DHx.iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.e.b localb = (com.tencent.mm.e.b)((Iterator)localObject).next();
        if ((localb.LZ() != com.tencent.mm.e.a.cOP) && (localb.n(paramMotionEvent))) {
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
      if (this.DHw.containsKey(com.tencent.mm.api.g.cGA)) {
        localObject = (com.tencent.mm.e.b)this.DHw.get(com.tencent.mm.api.g.cGA);
      }
      for (;;)
      {
        bool2 = bool3;
        if (localObject != null) {
          bool2 = ((com.tencent.mm.e.b)localObject).n(paramMotionEvent);
        }
        bool1 = bool2;
        if (!bool2) {
          break;
        }
        this.DHG = ((com.tencent.mm.e.b)localObject);
        bool1 = bool2;
        break;
        if (this.DHw.containsKey(com.tencent.mm.api.g.cGB)) {
          localObject = (com.tencent.mm.e.b)this.DHw.get(com.tencent.mm.api.g.cGB);
        }
      }
    }
  }
  
  public final com.tencent.mm.cache.f a(com.tencent.mm.e.a parama)
  {
    AppMethodBeat.i(9318);
    ArtistCacheManager.Vm();
    parama = ArtistCacheManager.a(this.cGH.path, parama);
    AppMethodBeat.o(9318);
    return parama;
  }
  
  public final void a(Editable paramEditable, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9303);
    vx(false);
    this.DHv.setFooterVisible(true);
    Object localObject = eQO();
    EditText localEditText;
    if (((com.tencent.mm.e.b)localObject).LZ() == com.tencent.mm.e.a.cOP)
    {
      localObject = (com.tencent.mm.e.e)localObject;
      localEditText = (EditText)this.DHv.getTextEditView().findViewById(2131305727);
      if ((localEditText.getTag() == null) || (!(localEditText.getTag() instanceof com.tencent.mm.z.f))) {
        break label119;
      }
      ((com.tencent.mm.e.e)localObject).a((com.tencent.mm.z.f)localEditText.getTag(), k.c(this.DHv.getContext(), paramEditable), paramInt1, paramInt2);
    }
    for (;;)
    {
      localEditText.setTag(null);
      AppMethodBeat.o(9303);
      return;
      label119:
      ((com.tencent.mm.e.e)localObject).a(k.c(this.DHv.getContext(), paramEditable), paramInt1, paramInt2);
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
    this.cGH = parama;
    this.DHw = new HashMap();
    this.DHx = new LinkedList();
    Object localObject = parama.path;
    if ((bs.isNullOrNil((String)localObject)) || (!com.tencent.mm.vfs.i.eA((String)localObject))) {
      ac.w("MicroMsg.DrawingPresenter", "[checkImage] path:%s", new Object[] { localObject });
    }
    for (;;)
    {
      if (i != 0)
      {
        if (!parama.cGM) {
          break;
        }
        this.DHz = com.tencent.mm.sdk.platformtools.f.decodeFile(parama.path, null);
        if (this.DHz != null) {
          this.DHz = this.DHz.copy(Bitmap.Config.ARGB_8888, true);
        }
      }
      eQS();
      AppMethodBeat.o(9297);
      return;
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      com.tencent.mm.sdk.platformtools.f.decodeFile((String)localObject, localOptions);
      if ((localOptions.outWidth <= 0) || (localOptions.outHeight <= 0)) {
        ac.e("MicroMsg.DrawingPresenter", "[checkImage] image err! w:%s h:%s path:%s", new Object[] { Integer.valueOf(localOptions.outWidth), Integer.valueOf(localOptions.outHeight), localObject });
      } else {
        i = 1;
      }
    }
    localObject = com.tencent.mm.sdk.platformtools.f.aKw(bs.bG(parama.path, ""));
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
      this.DHz = com.tencent.mm.sdk.platformtools.f.aG(bs.bG(parama.path, ""), i, j);
      break;
      i = 1280;
    }
  }
  
  public final void a(com.tencent.mm.view.a parama)
  {
    this.DHv = parama;
  }
  
  public final <T extends com.tencent.mm.e.b> T c(com.tencent.mm.api.g paramg)
  {
    AppMethodBeat.i(9314);
    paramg = (com.tencent.mm.e.b)this.DHw.get(paramg);
    AppMethodBeat.o(9314);
    return paramg;
  }
  
  public final void c(p paramp)
  {
    AppMethodBeat.i(9315);
    com.tencent.mm.e.e locale = (com.tencent.mm.e.e)c(com.tencent.mm.api.g.cGB);
    if (locale != null) {
      locale.b(paramp);
    }
    AppMethodBeat.o(9315);
  }
  
  public final boolean eQK()
  {
    return this.DHB;
  }
  
  public final void eQL()
  {
    this.DHB = false;
  }
  
  public final void eQM()
  {
    AppMethodBeat.i(9304);
    this.DHv.setFooterVisible(true);
    vx(false);
    AppMethodBeat.o(9304);
  }
  
  public final com.tencent.mm.view.a eQN()
  {
    return this.DHv;
  }
  
  public final <T extends com.tencent.mm.e.b> T eQO()
  {
    AppMethodBeat.i(9306);
    if (this.DHG != null)
    {
      localb = this.DHG;
      AppMethodBeat.o(9306);
      return localb;
    }
    ac.e("MicroMsg.DrawingPresenter", "[getCurArtist] is null!");
    com.tencent.mm.e.b localb = com.tencent.mm.e.b.cOY;
    AppMethodBeat.o(9306);
    return localb;
  }
  
  public final void eQP()
  {
    AppMethodBeat.i(9311);
    ac.i("MicroMsg.DrawingPresenter", "[onLayout]");
    if (!this.DHF)
    {
      this.DHF = true;
      Iterator localIterator = this.DHx.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.e.b localb = (com.tencent.mm.e.b)localIterator.next();
        if (ArtistCacheManager.Vm().b(localb.LZ()))
        {
          localb.onAlive();
          localb.ck(true);
          ac.i("MicroMsg.DrawingPresenter", "[onAttachedToWindow] %s is revert onAlive!", new Object[] { localb.LZ() });
        }
      }
      if (this.DHv.getBaseBoardView().fzb())
      {
        this.DHv.getBaseBoardView().fzc();
        this.DHv.getBaseBoardView().invalidate();
      }
    }
    AppMethodBeat.o(9311);
  }
  
  public final Bitmap eQQ()
  {
    return this.DHz;
  }
  
  public final boolean eQR()
  {
    AppMethodBeat.i(9313);
    if ((eQO().LZ() != com.tencent.mm.e.a.cOQ) && (this.DHA))
    {
      AppMethodBeat.o(9313);
      return true;
    }
    AppMethodBeat.o(9313);
    return false;
  }
  
  public final y.a getConfig()
  {
    return this.cGH;
  }
  
  public final float getCurScale()
  {
    AppMethodBeat.i(9308);
    float f = this.DHv.getBaseBoardView().getCurScale();
    AppMethodBeat.o(9308);
    return f;
  }
  
  public final com.tencent.mm.api.g[] getFeatures()
  {
    AppMethodBeat.i(9298);
    com.tencent.mm.api.g[] arrayOfg = this.DHv.getFeatures();
    AppMethodBeat.o(9298);
    return arrayOfg;
  }
  
  public final float getInitScale()
  {
    AppMethodBeat.i(9307);
    float f = this.DHv.getBaseBoardView().getInitScale();
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
        ac.i("MicroMsg.DrawingPresenter", "[onSelectedFeature] features:%s", new Object[] { paramAnonymousg });
        if (paramAnonymousg == com.tencent.mm.api.g.cGy) {
          a.this.DHv.getBaseFooterView().setCurFeatureType(paramAnonymousg);
        }
        a.this.DHv.getBaseFooterView().fzk();
        if (a.this.DHv.getSelectedFeatureListener() != null) {
          a.this.DHv.getSelectedFeatureListener().a(paramAnonymousg);
        }
        if (paramAnonymousg == com.tencent.mm.api.g.cGE) {
          a.this.DHv.getFooterBg().setVisibility(8);
        }
        com.tencent.mm.e.b localb = (com.tencent.mm.e.b)a.this.DHw.get(paramAnonymousg);
        if (localb == null)
        {
          AppMethodBeat.o(9279);
          return;
        }
        if ((localb.czD) && (!localb.isAlive())) {
          localb.onAlive();
        }
        if (localb.LZ() != com.tencent.mm.e.a.cOM) {
          localb.setOneFingerMoveEnable(false);
        }
        localb.Mc();
        a.this.DHG = localb;
        switch (a.7.DHJ[paramAnonymousg.ordinal()])
        {
        default: 
          a.this.DHE = paramAnonymousg;
        }
        for (;;)
        {
          a.this.DHv.getBaseFooterView().setCurFeatureType(paramAnonymousg);
          AppMethodBeat.o(9279);
          return;
          if (!a.this.DHv.getBaseFooterView().fzf())
          {
            ((EditText)a.this.DHv.getTextEditView().findViewById(2131305727)).setTextColor(com.tencent.mm.view.footer.a.JAq[0]);
            a.this.vx(true);
            a.this.DHv.setFooterVisible(false);
          }
          a.this.DHE = paramAnonymousg;
          continue;
          a.this.DHv.setActionBarVisible(false);
          a.this.DHv.setFooterVisible(false);
          a.this.DHv.yq(false);
          break;
          a.this.DHD = a.this.DHE;
        }
      }
      
      public final void a(com.tencent.mm.api.g paramAnonymousg, int paramAnonymousInt, Object paramAnonymousObject)
      {
        AppMethodBeat.i(163137);
        ac.i("MicroMsg.DrawingPresenter", "[onSelectedDetailFeature] features:%s index:%s", new Object[] { paramAnonymousg, Integer.valueOf(paramAnonymousInt) });
        if (a.this.DHv.getSelectedFeatureListener() != null) {
          a.this.DHv.getSelectedFeatureListener().a(paramAnonymousg, paramAnonymousInt, paramAnonymousObject);
        }
        a.this.DHG = ((com.tencent.mm.e.b)a.this.DHw.get(paramAnonymousg));
        if (a.this.eQO().LZ() == com.tencent.mm.e.a.cOM)
        {
          AppMethodBeat.o(163137);
          return;
        }
        if (a.this.DHv.getFooterBg().getVisibility() == 8) {
          a.this.DHv.getFooterBg().setVisibility(0);
        }
        float f2;
        switch (a.7.DHJ[paramAnonymousg.ordinal()])
        {
        default: 
          AppMethodBeat.o(163137);
          return;
        case 4: 
          paramAnonymousg = (d)a.this.eQO();
          if (paramAnonymousInt != -1)
          {
            a.this.DHv.getBaseFooterView();
            paramAnonymousg.mColor = com.tencent.mm.view.footer.a.getColor(paramAnonymousInt);
            AppMethodBeat.o(163137);
            return;
          }
          paramAnonymousg.Mh();
          AppMethodBeat.o(163137);
          return;
        case 5: 
          paramAnonymousg = (com.tencent.mm.e.g)a.this.eQO();
          if (paramAnonymousInt == 0)
          {
            paramAnonymousg.cQp = e.a.gfw;
            AppMethodBeat.o(163137);
            return;
          }
          if (1 == paramAnonymousInt)
          {
            paramAnonymousg.cQp = e.a.gfx;
            AppMethodBeat.o(163137);
            return;
          }
          paramAnonymousg.Mh();
          AppMethodBeat.o(163137);
          return;
        case 3: 
          paramAnonymousg = (c)a.this.eQO();
          if (paramAnonymousInt == 0)
          {
            paramAnonymousg.cPG += 1;
            paramAnonymousg.cPr.cancel();
            if (paramAnonymousg.cPE != null) {
              paramAnonymousg.cPE.cancel();
            }
            paramAnonymousObject = new Matrix();
            paramAnonymousObject.postRotate(-90.0F, paramAnonymousg.cEJ.centerX(), paramAnonymousg.cEJ.centerY());
            if (paramAnonymousg.cPF.isEmpty()) {
              paramAnonymousg.cPF.set(paramAnonymousg.cEJ);
            }
            RectF localRectF = new RectF(paramAnonymousg.cPF);
            paramAnonymousObject.mapRect(localRectF);
            f1 = 1.0F * paramAnonymousg.cPn.width() / localRectF.width();
            f2 = 1.0F * paramAnonymousg.cPn.height() / localRectF.height();
            if (f1 < f2) {}
            for (;;)
            {
              paramAnonymousObject.postScale(f1, f1, paramAnonymousg.cEJ.centerX(), paramAnonymousg.cEJ.centerY());
              localRectF.set(paramAnonymousg.cPF);
              paramAnonymousObject.mapRect(localRectF);
              paramAnonymousg.cPF.set((int)localRectF.left, (int)localRectF.top, (int)localRectF.right, (int)localRectF.bottom);
              f2 = paramAnonymousg.cEJ.centerX();
              float f3 = paramAnonymousg.cEJ.centerY();
              paramAnonymousObject = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofInt("rotation", new int[] { 0, -90 }), PropertyValuesHolder.ofInt("deltaX", new int[] { 0, paramAnonymousg.cPn.centerX() - (int)f2 }), PropertyValuesHolder.ofInt("deltaY", new int[] { 0, paramAnonymousg.cPn.centerY() - (int)f3 }) });
              paramAnonymousObject.addUpdateListener(new c.10(paramAnonymousg, f2, f3, f1));
              paramAnonymousObject.addListener(new c.2(paramAnonymousg));
              paramAnonymousObject.setDuration(200L);
              paramAnonymousObject.start();
              AppMethodBeat.o(163137);
              return;
              f1 = f2;
            }
          }
          if (1 == paramAnonymousInt)
          {
            ac.i("MicroMsg.CropArtist", "[cancel]");
            paramAnonymousg.cPr.cancel();
            if (paramAnonymousg.cPE != null) {
              paramAnonymousg.cPE.cancel();
            }
            paramAnonymousg.cOU.eQN().getBaseBoardView().Jzg = paramAnonymousg.cOU.eQN().getBaseBoardView().getRawBoardRect();
            if (paramAnonymousg.Mb() == null) {
              break label1243;
            }
            paramAnonymousObject = ((com.tencent.mm.cache.a)paramAnonymousg.Mb()).Vp();
            if (paramAnonymousObject == null) {
              break label1243;
            }
            f2 = paramAnonymousg.getRotation() - paramAnonymousg.b(paramAnonymousObject.mMatrix);
            f1 = f2;
            if (!paramAnonymousObject.geZ.isEmpty()) {
              paramAnonymousg.cOU.eQN().getBaseBoardView().r(paramAnonymousObject.geZ);
            }
          }
          break;
        }
        label1243:
        for (float f1 = f2;; f1 = 0.0F)
        {
          paramAnonymousg.cOU.eQN().getBaseBoardView().a(null, f1, true);
          paramAnonymousg.cOU.eQN().getActionBar().setVisibility(0);
          a.this.DHG = ((com.tencent.mm.e.b)a.this.DHw.get(a.this.DHD));
          a.this.DHv.getBaseFooterView().setCurFeatureType(a.this.DHD);
          AppMethodBeat.o(163137);
          return;
          if (2 == paramAnonymousInt)
          {
            ac.i("MicroMsg.CropArtist", "[doCrop]");
            if (paramAnonymousg.cPE != null) {
              paramAnonymousg.cPE.cancel();
            }
            if (!paramAnonymousg.cPr.cEQ)
            {
              if (!paramAnonymousg.cPr.aKd)
              {
                paramAnonymousg.cPr.cancel();
                paramAnonymousg.cPr.play();
              }
              paramAnonymousg.cPr.uY = new c.7(paramAnonymousg);
            }
            for (;;)
            {
              a.this.DHG = ((com.tencent.mm.e.b)a.this.DHw.get(a.this.DHD));
              a.this.DHv.getBaseFooterView().setCurFeatureType(a.this.DHD);
              AppMethodBeat.o(163137);
              return;
              paramAnonymousg.cPr.uY = null;
              paramAnonymousg.Mn();
            }
          }
          if (3 != paramAnonymousInt) {
            break;
          }
          ac.i("MicroMsg.CropArtist", "[reset]");
          paramAnonymousg.cPH = true;
          paramAnonymousg.cPr.cancel();
          if (paramAnonymousg.cPE != null) {
            paramAnonymousg.cPE.cancel();
          }
          paramAnonymousg.cPF.setEmpty();
          paramAnonymousg.Mm();
          paramAnonymousg.cPx = false;
          paramAnonymousg.cOU.eQN().getBaseBoardView().Jzg = paramAnonymousg.cEJ;
          paramAnonymousg.cOU.eQN().getBaseBoardView().a(new c.9(paramAnonymousg), paramAnonymousg.getRotation(), true);
          AppMethodBeat.o(163137);
          return;
          paramAnonymousg = (com.tencent.mm.e.f)a.this.eQO();
          f1 = ((Float)paramAnonymousObject).floatValue();
          paramAnonymousObject = (com.tencent.mm.cache.e)paramAnonymousg.Mb();
          if (paramAnonymousObject != null) {
            paramAnonymousObject.fqd = paramAnonymousInt;
          }
          paramAnonymousg = (com.tencent.mm.cache.e)paramAnonymousg.Mb();
          if (paramAnonymousg != null) {
            paramAnonymousg.fqe = f1;
          }
          a.this.DHv.getBaseBoardView().postInvalidate();
          ac.i("MicroMsg.DrawingPresenter", "lxl postInvalidate");
          break;
        }
      }
      
      public final void bW(boolean paramAnonymousBoolean) {}
    };
    AppMethodBeat.o(9299);
    return local1;
  }
  
  public final void onAttachedToWindow()
  {
    AppMethodBeat.i(9312);
    ac.i("MicroMsg.DrawingPresenter", "[onAttachedToWindow]");
    if (!this.DHF)
    {
      this.DHF = true;
      Iterator localIterator = this.DHx.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.e.b localb = (com.tencent.mm.e.b)localIterator.next();
        if (ArtistCacheManager.Vm().b(localb.LZ()))
        {
          localb.onAlive();
          localb.ck(true);
          ac.i("MicroMsg.DrawingPresenter", "[onAttachedToWindow] %s is revert onAlive!", new Object[] { localb.LZ() });
        }
      }
      if (this.DHv.getBaseBoardView().fzb())
      {
        this.DHv.getBaseBoardView().fzc();
        this.DHv.getBaseBoardView().invalidate();
      }
    }
    AppMethodBeat.o(9312);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9310);
    Iterator localIterator = this.DHx.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.e.b)localIterator.next()).onDestroy();
    }
    this.DHx.clear();
    this.DHw.clear();
    AppMethodBeat.o(9310);
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9317);
    Iterator localIterator = this.DHx.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.e.b localb = (com.tencent.mm.e.b)localIterator.next();
      if (localb.isAlive()) {
        if (eQO().LZ() == localb.LZ())
        {
          localb.onDraw(paramCanvas);
        }
        else
        {
          paramCanvas.save();
          paramCanvas.clipRect(this.DHv.getBaseBoardView().getAliveRect());
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
    if (this.DHy != null) {
      this.DHy.onExit();
    }
    AppMethodBeat.o(9300);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(9302);
    if (this.DHy != null) {
      this.DHy.onFinish();
    }
    AppMethodBeat.o(9302);
  }
  
  public final void setActionBarCallback(com.tencent.mm.api.i parami)
  {
    this.DHy = parami;
  }
  
  public final void setAutoShowFooterAndBar(boolean paramBoolean)
  {
    this.DHA = paramBoolean;
  }
  
  public final void setInitScale(float paramFloat)
  {
    AppMethodBeat.i(199931);
    this.DHv.getBaseBoardView().setInitScale(paramFloat);
    AppMethodBeat.o(199931);
  }
  
  final void vx(boolean paramBoolean)
  {
    AppMethodBeat.i(9320);
    if (paramBoolean)
    {
      localAnimation = AnimationUtils.loadAnimation(this.DHv.getContext(), 2130772108);
      localAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(9283);
          a.this.DHv.getTextEditView().setVisibility(0);
          paramAnonymousAnimation = (EditText)a.this.DHv.getTextEditView().findViewById(2131305727);
          paramAnonymousAnimation.requestFocus();
          paramAnonymousAnimation.setSelection(paramAnonymousAnimation.length());
          a.this.DHv.getSelectedFeatureListener().bW(true);
          ((SelectColorBar)a.this.DHv.findViewById(2131304505)).setSelectColor(paramAnonymousAnimation.getCurrentTextColor());
          a.this.DHv.getActionBar().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9282);
              a.this.DHv.getActionBar().setVisibility(0);
              AppMethodBeat.o(9282);
            }
          });
          AppMethodBeat.o(9283);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      this.DHv.getTextEditView().startAnimation(localAnimation);
      AppMethodBeat.o(9320);
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(this.DHv.getContext(), 2130772106);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(9285);
        ((EditText)a.this.DHv.getTextEditView().findViewById(2131305727)).setText("");
        a.this.DHv.getTextEditView().setVisibility(8);
        AppMethodBeat.o(9285);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(9284);
        a.this.DHv.getSelectedFeatureListener().bW(false);
        AppMethodBeat.o(9284);
      }
    });
    this.DHv.getTextEditView().startAnimation(localAnimation);
    AppMethodBeat.o(9320);
  }
  
  public final class a
    implements com.tencent.mm.af.a
  {
    View DHK;
    TextView DHL;
    ImageView DHM;
    
    public a()
    {
      AppMethodBeat.i(9289);
      this.DHK = a.this.DHv.getRubbishView();
      this.DHL = ((TextView)this.DHK.findViewById(2131304270));
      this.DHM = ((ImageView)this.DHK.findViewById(2131304268));
      AppMethodBeat.o(9289);
    }
    
    public final void a(com.tencent.mm.z.f paramf)
    {
      AppMethodBeat.i(9294);
      EditText localEditText = (EditText)a.this.DHv.getTextEditView().findViewById(2131305727);
      localEditText.setTag(paramf);
      if (a.this.DHC != null)
      {
        a.this.DHC.b(paramf);
        AppMethodBeat.o(9294);
        return;
      }
      localEditText.setText(paramf.gfC);
      Switch localSwitch = (Switch)a.this.DHv.findViewById(2131297210);
      SelectColorBar localSelectColorBar = (SelectColorBar)a.this.DHv.findViewById(2131304505);
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
        a.this.vx(true);
        AppMethodBeat.o(9294);
        return;
        bool = false;
        break;
        label168:
        localSelectColorBar.setSelectColor(paramf.mColor);
      }
    }
    
    public final void ah(float paramFloat)
    {
      AppMethodBeat.i(9290);
      ac.i("MicroMsg.DrawingPresenter", "[onReach] distance:%s", new Object[] { Float.valueOf(paramFloat) });
      this.DHK.setActivated(true);
      this.DHL.setText(a.this.DHv.getContext().getString(2131762742));
      this.DHM.setImageDrawable(am.k(a.this.DHv.getContext(), 2131690385, -1));
      AppMethodBeat.o(9290);
    }
    
    public final void aih()
    {
      AppMethodBeat.i(9291);
      ac.i("MicroMsg.DrawingPresenter", "[onUnReach]");
      this.DHK.setActivated(false);
      this.DHM.setImageDrawable(am.k(a.this.DHv.getContext(), 2131690384, -1));
      this.DHL.setText(a.this.DHv.getContext().getString(2131762743));
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
      if (a.this.DHC != null) {
        a.this.DHC.h(Boolean.TRUE);
      }
      AppMethodBeat.o(9292);
    }
  }
  
  final class b
    implements Runnable
  {
    s DHN;
    boolean DHO;
    
    b(s params, boolean paramBoolean)
    {
      this.DHN = params;
      this.DHO = paramBoolean;
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
          ac.printErrStackTrace("MicroMsg.DrawingPresenter", localOutOfMemoryError, "", new Object[0]);
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
        Iterator localIterator1 = a.this.DHx.iterator();
        while (localIterator1.hasNext()) {
          ((com.tencent.mm.e.b)localIterator1.next()).Md();
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
        h.JZN.aQ(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(199930);
            a.b.this.DHN.onError(localException1);
            AppMethodBeat.o(199930);
          }
        });
        try
        {
          localIterator2 = a.this.DHx.iterator();
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
        if (!a.this.DHv.getBaseBoardView().fzb())
        {
          i = a.this.DHv.getBaseBoardView().getAliveRect().width();
          j = a.this.DHv.getBaseBoardView().getAliveRect().height();
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
          this.DHN.onError(new NullPointerException("bitmap is null!"));
          try
          {
            localObject1 = a.this.DHx.iterator();
            while (((Iterator)localObject1).hasNext()) {
              ((com.tencent.mm.e.b)((Iterator)localObject1).next()).onFinish();
            }
            localBitmap1 = a.this.DHz;
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
        localObject4 = a.this.DHx.iterator();
        while (((Iterator)localObject4).hasNext()) {
          ((com.tencent.mm.e.b)((Iterator)localObject4).next()).Mb().e((Canvas)localObject3);
        }
      }
      finally
      {
        try
        {
          localObject3 = a.this.DHx.iterator();
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
      com.tencent.mm.sdk.platformtools.f.decodeFile(a.this.cGH.path, localOptions);
      float f1 = localOptions.outHeight * 1.0F / localBitmap2.getHeight();
      float f2 = localOptions.outWidth * 1.0F / localBitmap2.getWidth();
      if (f1 > f2) {
        break label814;
      }
      for (;;)
      {
        f1 = a.this.DHv.getBaseBoardView().b(a.this.DHv.getBaseBoardView().getMainMatrix());
        localObject4 = new Matrix();
        ((Matrix)localObject4).postScale(f2, f2, 0.0F, 0.0F);
        ((Matrix)localObject4).postRotate(-f1);
        Rect localRect = new Rect(a.this.DHv.getBaseBoardView().getAliveRect());
        ac.i("MicroMsg.DrawingPresenter", "[saveEditPhoto] clipRectF:%s w:%s h:%s", new Object[] { localRect, Integer.valueOf(localBitmap2.getWidth()), Integer.valueOf(localBitmap2.getHeight()) });
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
        h.JZN.aQ(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(199929);
            a.b.this.DHN.a(this.vmB, a.b.this.DHO);
            AppMethodBeat.o(199929);
          }
        });
        try
        {
          localObject2 = a.this.DHx.iterator();
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
    public abstract boolean b(com.tencent.mm.z.f paramf);
    
    public abstract void h(Boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bt.a
 * JD-Core Version:    0.7.0.1
 */