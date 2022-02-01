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
import com.tencent.mm.e.c.10;
import com.tencent.mm.e.c.2;
import com.tencent.mm.e.c.7;
import com.tencent.mm.e.c.9;
import com.tencent.mm.e.d;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ao;
import com.tencent.mm.view.footer.SelectColorBar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  implements b
{
  com.tencent.mm.view.a FmC;
  HashMap<com.tencent.mm.api.g, com.tencent.mm.e.b> FmD;
  LinkedList<com.tencent.mm.e.b> FmE;
  private com.tencent.mm.api.i FmF;
  Bitmap FmG;
  private boolean FmH = true;
  private boolean FmI = true;
  public c FmJ;
  com.tencent.mm.api.g FmK = com.tencent.mm.api.g.cRC;
  com.tencent.mm.api.g FmL = com.tencent.mm.api.g.cRC;
  private boolean FmM = false;
  com.tencent.mm.e.b FmN = null;
  y.a cRL;
  
  private void ffW()
  {
    AppMethodBeat.i(9319);
    this.FmE.clear();
    this.FmD.clear();
    this.FmD.put(com.tencent.mm.api.g.cRC, com.tencent.mm.e.b.dao);
    com.tencent.mm.api.g[] arrayOfg = this.FmC.getFeatures();
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
      switch (7.FmQ[localg.ordinal()])
      {
      default: 
      case 7: 
      case 4: 
        for (localObject1 = localIterator;; localObject1 = new d())
        {
          if (localObject1 != null)
          {
            if (!this.FmD.containsKey(localg)) {
              this.FmD.put(localg, localObject1);
            }
            if (!this.FmE.contains(localObject1))
            {
              this.FmE.add(localObject1);
              ((com.tencent.mm.e.b)localObject1).a(this, this.FmC.getBaseBoardView().getMainMatrix(), this.FmC.getBaseBoardView().getAliveRect());
            }
          }
          i += 1;
          break;
        }
      case 1: 
      case 2: 
        localIterator = this.FmE.iterator();
        while (localIterator.hasNext())
        {
          localObject1 = (com.tencent.mm.e.b)localIterator.next();
          if (((com.tencent.mm.e.b)localObject1).NI() == com.tencent.mm.e.a.daf) {
            j = 1;
          }
        }
      }
    }
    while (j == 0)
    {
      localObject1 = new com.tencent.mm.e.e();
      ((com.tencent.mm.e.e)localObject1).dby = new a();
      break;
      localObject1 = new com.tencent.mm.e.g();
      break;
      localObject1 = new c();
      break;
      localObject1 = new com.tencent.mm.e.f();
      break;
      Collections.sort(this.FmE, new Comparator() {});
      ad.i("MicroMsg.DrawingPresenter", "[addArtists] count:%s", new Object[] { Integer.valueOf(this.FmD.size() - 1) });
      AppMethodBeat.o(9319);
      return;
      j = 0;
      localObject1 = localObject2;
    }
  }
  
  public final boolean JU()
  {
    AppMethodBeat.i(9301);
    if (this.FmC.getTextEditView().getVisibility() == 0)
    {
      wj(false);
      this.FmC.setFooterVisible(true);
      AppMethodBeat.o(9301);
      return true;
    }
    if ((this.FmC.getChatFooterPanel() != null) && (this.FmC.getChatFooterPanel().getVisibility() == 0))
    {
      this.FmC.zd(true);
      this.FmC.setFooterVisible(true);
      AppMethodBeat.o(9301);
      return true;
    }
    AppMethodBeat.o(9301);
    return false;
  }
  
  public final boolean P(MotionEvent paramMotionEvent)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    AppMethodBeat.i(9316);
    boolean bool1 = bool2;
    Object localObject;
    if (ffS().NI() != com.tencent.mm.e.a.dag)
    {
      if (ffS().NI() == com.tencent.mm.e.a.dah) {
        bool1 = bool2;
      }
    }
    else
    {
      if (bool1) {
        break label224;
      }
      this.FmN = ((com.tencent.mm.e.b)this.FmD.get(this.FmC.getBaseFooterView().getCurFeatureType()));
      localObject = this.FmE.iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.e.b localb = (com.tencent.mm.e.b)((Iterator)localObject).next();
        if ((localb.NI() != com.tencent.mm.e.a.daf) && (localb.n(paramMotionEvent))) {
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
      if (this.FmD.containsKey(com.tencent.mm.api.g.cRE)) {
        localObject = (com.tencent.mm.e.b)this.FmD.get(com.tencent.mm.api.g.cRE);
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
        this.FmN = ((com.tencent.mm.e.b)localObject);
        bool1 = bool2;
        break;
        if (this.FmD.containsKey(com.tencent.mm.api.g.cRF)) {
          localObject = (com.tencent.mm.e.b)this.FmD.get(com.tencent.mm.api.g.cRF);
        }
      }
    }
  }
  
  public final com.tencent.mm.cache.f a(com.tencent.mm.e.a parama)
  {
    AppMethodBeat.i(9318);
    ArtistCacheManager.XD();
    parama = ArtistCacheManager.a(this.cRL.path, parama);
    AppMethodBeat.o(9318);
    return parama;
  }
  
  public final void a(Editable paramEditable, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9303);
    wj(false);
    this.FmC.setFooterVisible(true);
    Object localObject = ffS();
    EditText localEditText;
    if (((com.tencent.mm.e.b)localObject).NI() == com.tencent.mm.e.a.daf)
    {
      localObject = (com.tencent.mm.e.e)localObject;
      localEditText = (EditText)this.FmC.getTextEditView().findViewById(2131305727);
      if ((localEditText.getTag() == null) || (!(localEditText.getTag() instanceof com.tencent.mm.aa.f))) {
        break label119;
      }
      ((com.tencent.mm.e.e)localObject).a((com.tencent.mm.aa.f)localEditText.getTag(), k.c(this.FmC.getContext(), paramEditable), paramInt1, paramInt2);
    }
    for (;;)
    {
      localEditText.setTag(null);
      AppMethodBeat.o(9303);
      return;
      label119:
      ((com.tencent.mm.e.e)localObject).a(k.c(this.FmC.getContext(), paramEditable), paramInt1, paramInt2);
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
    this.cRL = parama;
    this.FmD = new HashMap();
    this.FmE = new LinkedList();
    Object localObject = parama.path;
    if ((bt.isNullOrNil((String)localObject)) || (!com.tencent.mm.vfs.i.fv((String)localObject))) {
      ad.w("MicroMsg.DrawingPresenter", "[checkImage] path:%s", new Object[] { localObject });
    }
    for (;;)
    {
      if (i != 0)
      {
        if (!parama.cRQ) {
          break;
        }
        this.FmG = com.tencent.mm.sdk.platformtools.g.decodeFile(parama.path, null);
        if (this.FmG != null) {
          this.FmG = this.FmG.copy(Bitmap.Config.ARGB_8888, true);
        }
      }
      ffW();
      AppMethodBeat.o(9297);
      return;
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      com.tencent.mm.sdk.platformtools.g.decodeFile((String)localObject, localOptions);
      if ((localOptions.outWidth <= 0) || (localOptions.outHeight <= 0)) {
        ad.e("MicroMsg.DrawingPresenter", "[checkImage] image err! w:%s h:%s path:%s", new Object[] { Integer.valueOf(localOptions.outWidth), Integer.valueOf(localOptions.outHeight), localObject });
      } else {
        i = 1;
      }
    }
    localObject = com.tencent.mm.sdk.platformtools.g.aQc(bt.bI(parama.path, ""));
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
      this.FmG = com.tencent.mm.sdk.platformtools.g.aK(bt.bI(parama.path, ""), i, j);
      break;
      i = 1280;
    }
  }
  
  public final void a(com.tencent.mm.view.a parama)
  {
    this.FmC = parama;
  }
  
  public final <T extends com.tencent.mm.e.b> T c(com.tencent.mm.api.g paramg)
  {
    AppMethodBeat.i(9314);
    paramg = (com.tencent.mm.e.b)this.FmD.get(paramg);
    AppMethodBeat.o(9314);
    return paramg;
  }
  
  public final void c(p paramp)
  {
    AppMethodBeat.i(9315);
    com.tencent.mm.e.e locale = (com.tencent.mm.e.e)c(com.tencent.mm.api.g.cRF);
    if (locale != null) {
      locale.b(paramp);
    }
    AppMethodBeat.o(9315);
  }
  
  public final boolean ffO()
  {
    return this.FmI;
  }
  
  public final void ffP()
  {
    this.FmI = false;
  }
  
  public final void ffQ()
  {
    AppMethodBeat.i(9304);
    this.FmC.setFooterVisible(true);
    wj(false);
    AppMethodBeat.o(9304);
  }
  
  public final com.tencent.mm.view.a ffR()
  {
    return this.FmC;
  }
  
  public final <T extends com.tencent.mm.e.b> T ffS()
  {
    AppMethodBeat.i(9306);
    if (this.FmN != null)
    {
      localb = this.FmN;
      AppMethodBeat.o(9306);
      return localb;
    }
    ad.e("MicroMsg.DrawingPresenter", "[getCurArtist] is null!");
    com.tencent.mm.e.b localb = com.tencent.mm.e.b.dao;
    AppMethodBeat.o(9306);
    return localb;
  }
  
  public final void ffT()
  {
    AppMethodBeat.i(9311);
    ad.i("MicroMsg.DrawingPresenter", "[onLayout]");
    if (!this.FmM)
    {
      this.FmM = true;
      Iterator localIterator = this.FmE.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.e.b localb = (com.tencent.mm.e.b)localIterator.next();
        if (ArtistCacheManager.XD().b(localb.NI()))
        {
          localb.onAlive();
          localb.cl(true);
          ad.i("MicroMsg.DrawingPresenter", "[onAttachedToWindow] %s is revert onAlive!", new Object[] { localb.NI() });
        }
      }
      if (this.FmC.getBaseBoardView().fQk())
      {
        this.FmC.getBaseBoardView().fQl();
        this.FmC.getBaseBoardView().invalidate();
      }
    }
    AppMethodBeat.o(9311);
  }
  
  public final Bitmap ffU()
  {
    return this.FmG;
  }
  
  public final boolean ffV()
  {
    AppMethodBeat.i(9313);
    if ((ffS().NI() != com.tencent.mm.e.a.dag) && (this.FmH))
    {
      AppMethodBeat.o(9313);
      return true;
    }
    AppMethodBeat.o(9313);
    return false;
  }
  
  public final y.a getConfig()
  {
    return this.cRL;
  }
  
  public final float getCurScale()
  {
    AppMethodBeat.i(9308);
    float f = this.FmC.getBaseBoardView().getCurScale();
    AppMethodBeat.o(9308);
    return f;
  }
  
  public final com.tencent.mm.api.g[] getFeatures()
  {
    AppMethodBeat.i(9298);
    com.tencent.mm.api.g[] arrayOfg = this.FmC.getFeatures();
    AppMethodBeat.o(9298);
    return arrayOfg;
  }
  
  public final float getInitScale()
  {
    AppMethodBeat.i(9307);
    float f = this.FmC.getBaseBoardView().getInitScale();
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
        if (paramAnonymousg == com.tencent.mm.api.g.cRC) {
          a.this.FmC.getBaseFooterView().setCurFeatureType(paramAnonymousg);
        }
        a.this.FmC.getBaseFooterView().fQt();
        if (a.this.FmC.getSelectedFeatureListener() != null) {
          a.this.FmC.getSelectedFeatureListener().a(paramAnonymousg);
        }
        if (paramAnonymousg == com.tencent.mm.api.g.cRI) {
          a.this.FmC.getFooterBg().setVisibility(8);
        }
        com.tencent.mm.e.b localb = (com.tencent.mm.e.b)a.this.FmD.get(paramAnonymousg);
        if (localb == null)
        {
          AppMethodBeat.o(9279);
          return;
        }
        if ((localb.cKz) && (!localb.isAlive())) {
          localb.onAlive();
        }
        if (localb.NI() != com.tencent.mm.e.a.dac) {
          localb.setOneFingerMoveEnable(false);
        }
        localb.NL();
        a.this.FmN = localb;
        switch (a.7.FmQ[paramAnonymousg.ordinal()])
        {
        default: 
          a.this.FmL = paramAnonymousg;
        }
        for (;;)
        {
          a.this.FmC.getBaseFooterView().setCurFeatureType(paramAnonymousg);
          AppMethodBeat.o(9279);
          return;
          if (!a.this.FmC.getBaseFooterView().fQo())
          {
            ((EditText)a.this.FmC.getTextEditView().findViewById(2131305727)).setTextColor(com.tencent.mm.view.footer.a.Ltx[0]);
            a.this.wj(true);
            a.this.FmC.setFooterVisible(false);
          }
          a.this.FmL = paramAnonymousg;
          continue;
          a.this.FmC.setActionBarVisible(false);
          a.this.FmC.setFooterVisible(false);
          a.this.FmC.zd(false);
          break;
          a.this.FmK = a.this.FmL;
        }
      }
      
      public final void a(com.tencent.mm.api.g paramAnonymousg, int paramAnonymousInt, Object paramAnonymousObject)
      {
        AppMethodBeat.i(163137);
        ad.i("MicroMsg.DrawingPresenter", "[onSelectedDetailFeature] features:%s index:%s", new Object[] { paramAnonymousg, Integer.valueOf(paramAnonymousInt) });
        if (a.this.FmC.getSelectedFeatureListener() != null) {
          a.this.FmC.getSelectedFeatureListener().a(paramAnonymousg, paramAnonymousInt, paramAnonymousObject);
        }
        a.this.FmN = ((com.tencent.mm.e.b)a.this.FmD.get(paramAnonymousg));
        if (a.this.ffS().NI() == com.tencent.mm.e.a.dac)
        {
          AppMethodBeat.o(163137);
          return;
        }
        if (a.this.FmC.getFooterBg().getVisibility() == 8) {
          a.this.FmC.getFooterBg().setVisibility(0);
        }
        float f2;
        switch (a.7.FmQ[paramAnonymousg.ordinal()])
        {
        default: 
          AppMethodBeat.o(163137);
          return;
        case 4: 
          paramAnonymousg = (d)a.this.ffS();
          if (paramAnonymousInt != -1)
          {
            a.this.FmC.getBaseFooterView();
            paramAnonymousg.mColor = com.tencent.mm.view.footer.a.getColor(paramAnonymousInt);
            AppMethodBeat.o(163137);
            return;
          }
          paramAnonymousg.NQ();
          AppMethodBeat.o(163137);
          return;
        case 5: 
          paramAnonymousg = (com.tencent.mm.e.g)a.this.ffS();
          if (paramAnonymousInt == 0)
          {
            paramAnonymousg.dbF = e.a.gzg;
            AppMethodBeat.o(163137);
            return;
          }
          if (1 == paramAnonymousInt)
          {
            paramAnonymousg.dbF = e.a.gzh;
            AppMethodBeat.o(163137);
            return;
          }
          paramAnonymousg.NQ();
          AppMethodBeat.o(163137);
          return;
        case 3: 
          paramAnonymousg = (c)a.this.ffS();
          if (paramAnonymousInt == 0)
          {
            paramAnonymousg.daW += 1;
            paramAnonymousg.daH.cancel();
            if (paramAnonymousg.daU != null) {
              paramAnonymousg.daU.cancel();
            }
            paramAnonymousObject = new Matrix();
            paramAnonymousObject.postRotate(-90.0F, paramAnonymousg.cPO.centerX(), paramAnonymousg.cPO.centerY());
            if (paramAnonymousg.daV.isEmpty()) {
              paramAnonymousg.daV.set(paramAnonymousg.cPO);
            }
            RectF localRectF = new RectF(paramAnonymousg.daV);
            paramAnonymousObject.mapRect(localRectF);
            f1 = 1.0F * paramAnonymousg.daD.width() / localRectF.width();
            f2 = 1.0F * paramAnonymousg.daD.height() / localRectF.height();
            if (f1 < f2) {}
            for (;;)
            {
              paramAnonymousObject.postScale(f1, f1, paramAnonymousg.cPO.centerX(), paramAnonymousg.cPO.centerY());
              localRectF.set(paramAnonymousg.daV);
              paramAnonymousObject.mapRect(localRectF);
              paramAnonymousg.daV.set((int)localRectF.left, (int)localRectF.top, (int)localRectF.right, (int)localRectF.bottom);
              f2 = paramAnonymousg.cPO.centerX();
              float f3 = paramAnonymousg.cPO.centerY();
              paramAnonymousObject = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofInt("rotation", new int[] { 0, -90 }), PropertyValuesHolder.ofInt("deltaX", new int[] { 0, paramAnonymousg.daD.centerX() - (int)f2 }), PropertyValuesHolder.ofInt("deltaY", new int[] { 0, paramAnonymousg.daD.centerY() - (int)f3 }) });
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
            ad.i("MicroMsg.CropArtist", "[cancel]");
            paramAnonymousg.daH.cancel();
            if (paramAnonymousg.daU != null) {
              paramAnonymousg.daU.cancel();
            }
            paramAnonymousg.dak.ffR().getBaseBoardView().Lsn = paramAnonymousg.dak.ffR().getBaseBoardView().getRawBoardRect();
            if (paramAnonymousg.NK() == null) {
              break label1243;
            }
            paramAnonymousObject = ((com.tencent.mm.cache.a)paramAnonymousg.NK()).XG();
            if (paramAnonymousObject == null) {
              break label1243;
            }
            f2 = paramAnonymousg.getRotation() - paramAnonymousg.b(paramAnonymousObject.mMatrix);
            f1 = f2;
            if (!paramAnonymousObject.gyJ.isEmpty()) {
              paramAnonymousg.dak.ffR().getBaseBoardView().q(paramAnonymousObject.gyJ);
            }
          }
          break;
        }
        label1243:
        for (float f1 = f2;; f1 = 0.0F)
        {
          paramAnonymousg.dak.ffR().getBaseBoardView().a(null, f1, true);
          paramAnonymousg.dak.ffR().getActionBar().setVisibility(0);
          a.this.FmN = ((com.tencent.mm.e.b)a.this.FmD.get(a.this.FmK));
          a.this.FmC.getBaseFooterView().setCurFeatureType(a.this.FmK);
          AppMethodBeat.o(163137);
          return;
          if (2 == paramAnonymousInt)
          {
            ad.i("MicroMsg.CropArtist", "[doCrop]");
            if (paramAnonymousg.daU != null) {
              paramAnonymousg.daU.cancel();
            }
            if (!paramAnonymousg.daH.cPV)
            {
              if (!paramAnonymousg.daH.aLU)
              {
                paramAnonymousg.daH.cancel();
                paramAnonymousg.daH.play();
              }
              paramAnonymousg.daH.wR = new c.7(paramAnonymousg);
            }
            for (;;)
            {
              a.this.FmN = ((com.tencent.mm.e.b)a.this.FmD.get(a.this.FmK));
              a.this.FmC.getBaseFooterView().setCurFeatureType(a.this.FmK);
              AppMethodBeat.o(163137);
              return;
              paramAnonymousg.daH.wR = null;
              paramAnonymousg.NW();
            }
          }
          if (3 != paramAnonymousInt) {
            break;
          }
          ad.i("MicroMsg.CropArtist", "[reset]");
          paramAnonymousg.daX = true;
          paramAnonymousg.daH.cancel();
          if (paramAnonymousg.daU != null) {
            paramAnonymousg.daU.cancel();
          }
          paramAnonymousg.daV.setEmpty();
          paramAnonymousg.NV();
          paramAnonymousg.daN = false;
          paramAnonymousg.dak.ffR().getBaseBoardView().Lsn = paramAnonymousg.cPO;
          paramAnonymousg.dak.ffR().getBaseBoardView().a(new c.9(paramAnonymousg), paramAnonymousg.getRotation(), true);
          AppMethodBeat.o(163137);
          return;
          paramAnonymousg = (com.tencent.mm.e.f)a.this.ffS();
          f1 = ((Float)paramAnonymousObject).floatValue();
          paramAnonymousObject = (com.tencent.mm.cache.e)paramAnonymousg.NK();
          if (paramAnonymousObject != null) {
            paramAnonymousObject.fIk = paramAnonymousInt;
          }
          paramAnonymousg = (com.tencent.mm.cache.e)paramAnonymousg.NK();
          if (paramAnonymousg != null) {
            paramAnonymousg.fIl = f1;
          }
          a.this.FmC.getBaseBoardView().postInvalidate();
          ad.i("MicroMsg.DrawingPresenter", "lxl postInvalidate");
          break;
        }
      }
      
      public final void bY(boolean paramAnonymousBoolean) {}
    };
    AppMethodBeat.o(9299);
    return local1;
  }
  
  public final void onAttachedToWindow()
  {
    AppMethodBeat.i(9312);
    ad.i("MicroMsg.DrawingPresenter", "[onAttachedToWindow]");
    if (!this.FmM)
    {
      this.FmM = true;
      Iterator localIterator = this.FmE.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.e.b localb = (com.tencent.mm.e.b)localIterator.next();
        if (ArtistCacheManager.XD().b(localb.NI()))
        {
          localb.onAlive();
          localb.cl(true);
          ad.i("MicroMsg.DrawingPresenter", "[onAttachedToWindow] %s is revert onAlive!", new Object[] { localb.NI() });
        }
      }
      if (this.FmC.getBaseBoardView().fQk())
      {
        this.FmC.getBaseBoardView().fQl();
        this.FmC.getBaseBoardView().invalidate();
      }
    }
    AppMethodBeat.o(9312);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9310);
    Iterator localIterator = this.FmE.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.e.b)localIterator.next()).onDestroy();
    }
    this.FmE.clear();
    this.FmD.clear();
    AppMethodBeat.o(9310);
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9317);
    Iterator localIterator = this.FmE.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.e.b localb = (com.tencent.mm.e.b)localIterator.next();
      if (localb.isAlive()) {
        if (ffS().NI() == localb.NI())
        {
          localb.onDraw(paramCanvas);
        }
        else
        {
          paramCanvas.save();
          paramCanvas.clipRect(this.FmC.getBaseBoardView().getAliveRect());
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
    if (this.FmF != null) {
      this.FmF.onExit();
    }
    AppMethodBeat.o(9300);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(9302);
    if (this.FmF != null) {
      this.FmF.onFinish();
    }
    AppMethodBeat.o(9302);
  }
  
  public final void setActionBarCallback(com.tencent.mm.api.i parami)
  {
    this.FmF = parami;
  }
  
  public final void setAutoShowFooterAndBar(boolean paramBoolean)
  {
    this.FmH = paramBoolean;
  }
  
  public final void setInitScale(float paramFloat)
  {
    AppMethodBeat.i(221102);
    this.FmC.getBaseBoardView().setInitScale(paramFloat);
    AppMethodBeat.o(221102);
  }
  
  final void wj(boolean paramBoolean)
  {
    AppMethodBeat.i(9320);
    if (paramBoolean)
    {
      localAnimation = AnimationUtils.loadAnimation(this.FmC.getContext(), 2130772108);
      localAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(9283);
          a.this.FmC.getTextEditView().setVisibility(0);
          paramAnonymousAnimation = (EditText)a.this.FmC.getTextEditView().findViewById(2131305727);
          paramAnonymousAnimation.requestFocus();
          paramAnonymousAnimation.setSelection(paramAnonymousAnimation.length());
          a.this.FmC.getSelectedFeatureListener().bY(true);
          ((SelectColorBar)a.this.FmC.findViewById(2131304505)).setSelectColor(paramAnonymousAnimation.getCurrentTextColor());
          a.this.FmC.getActionBar().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9282);
              a.this.FmC.getActionBar().setVisibility(0);
              AppMethodBeat.o(9282);
            }
          });
          AppMethodBeat.o(9283);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      this.FmC.getTextEditView().startAnimation(localAnimation);
      AppMethodBeat.o(9320);
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(this.FmC.getContext(), 2130772106);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(9285);
        ((EditText)a.this.FmC.getTextEditView().findViewById(2131305727)).setText("");
        a.this.FmC.getTextEditView().setVisibility(8);
        AppMethodBeat.o(9285);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(9284);
        a.this.FmC.getSelectedFeatureListener().bY(false);
        AppMethodBeat.o(9284);
      }
    });
    this.FmC.getTextEditView().startAnimation(localAnimation);
    AppMethodBeat.o(9320);
  }
  
  public final class a
    implements com.tencent.mm.ag.a
  {
    View FmR;
    TextView FmS;
    ImageView FmT;
    
    public a()
    {
      AppMethodBeat.i(9289);
      this.FmR = a.this.FmC.getRubbishView();
      this.FmS = ((TextView)this.FmR.findViewById(2131304270));
      this.FmT = ((ImageView)this.FmR.findViewById(2131304268));
      AppMethodBeat.o(9289);
    }
    
    public final void a(com.tencent.mm.aa.f paramf)
    {
      AppMethodBeat.i(9294);
      EditText localEditText = (EditText)a.this.FmC.getTextEditView().findViewById(2131305727);
      localEditText.setTag(paramf);
      if (a.this.FmJ != null)
      {
        a.this.FmJ.b(paramf);
        AppMethodBeat.o(9294);
        return;
      }
      localEditText.setText(paramf.gzm);
      Switch localSwitch = (Switch)a.this.FmC.findViewById(2131297210);
      SelectColorBar localSelectColorBar = (SelectColorBar)a.this.FmC.findViewById(2131304505);
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
        a.this.wj(true);
        AppMethodBeat.o(9294);
        return;
        bool = false;
        break;
        label168:
        localSelectColorBar.setSelectColor(paramf.mColor);
      }
    }
    
    public final void ak(float paramFloat)
    {
      AppMethodBeat.i(9290);
      ad.i("MicroMsg.DrawingPresenter", "[onReach] distance:%s", new Object[] { Float.valueOf(paramFloat) });
      this.FmR.setActivated(true);
      this.FmS.setText(a.this.FmC.getContext().getString(2131762742));
      this.FmT.setImageDrawable(ao.k(a.this.FmC.getContext(), 2131690385, -1));
      AppMethodBeat.o(9290);
    }
    
    public final void akT()
    {
      AppMethodBeat.i(9291);
      ad.i("MicroMsg.DrawingPresenter", "[onUnReach]");
      this.FmR.setActivated(false);
      this.FmT.setImageDrawable(ao.k(a.this.FmC.getContext(), 2131690384, -1));
      this.FmS.setText(a.this.FmC.getContext().getString(2131762743));
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
      if (a.this.FmJ != null) {
        a.this.FmJ.k(Boolean.TRUE);
      }
      AppMethodBeat.o(9292);
    }
  }
  
  final class b
    implements Runnable
  {
    s FmU;
    boolean FmV;
    
    b(s params, boolean paramBoolean)
    {
      this.FmU = params;
      this.FmV = paramBoolean;
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
        Iterator localIterator1 = a.this.FmE.iterator();
        while (localIterator1.hasNext()) {
          ((com.tencent.mm.e.b)localIterator1.next()).NM();
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
        h.LTJ.aP(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(221101);
            a.b.this.FmU.onError(localException1);
            AppMethodBeat.o(221101);
          }
        });
        try
        {
          localIterator2 = a.this.FmE.iterator();
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
        if (!a.this.FmC.getBaseBoardView().fQk())
        {
          i = a.this.FmC.getBaseBoardView().getAliveRect().width();
          j = a.this.FmC.getBaseBoardView().getAliveRect().height();
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
          this.FmU.onError(new NullPointerException("bitmap is null!"));
          try
          {
            localObject1 = a.this.FmE.iterator();
            while (((Iterator)localObject1).hasNext()) {
              ((com.tencent.mm.e.b)((Iterator)localObject1).next()).onFinish();
            }
            localBitmap1 = a.this.FmG;
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
        localObject4 = a.this.FmE.iterator();
        while (((Iterator)localObject4).hasNext()) {
          ((com.tencent.mm.e.b)((Iterator)localObject4).next()).NK().e((Canvas)localObject3);
        }
      }
      finally
      {
        try
        {
          localObject3 = a.this.FmE.iterator();
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
      com.tencent.mm.sdk.platformtools.g.decodeFile(a.this.cRL.path, localOptions);
      float f1 = localOptions.outHeight * 1.0F / localBitmap2.getHeight();
      float f2 = localOptions.outWidth * 1.0F / localBitmap2.getWidth();
      if (f1 > f2) {
        break label814;
      }
      for (;;)
      {
        f1 = a.this.FmC.getBaseBoardView().b(a.this.FmC.getBaseBoardView().getMainMatrix());
        localObject4 = new Matrix();
        ((Matrix)localObject4).postScale(f2, f2, 0.0F, 0.0F);
        ((Matrix)localObject4).postRotate(-f1);
        Rect localRect = new Rect(a.this.FmC.getBaseBoardView().getAliveRect());
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
        h.LTJ.aP(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(221100);
            a.b.this.FmU.a(this.wrT, a.b.this.FmV);
            AppMethodBeat.o(221100);
          }
        });
        try
        {
          localObject2 = a.this.FmE.iterator();
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
    
    public abstract void k(Boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.bu.a
 * JD-Core Version:    0.7.0.1
 */