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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.ao;
import com.tencent.mm.vfs.o;
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
  com.tencent.mm.view.a FFa;
  HashMap<com.tencent.mm.api.g, com.tencent.mm.e.b> FFb;
  LinkedList<com.tencent.mm.e.b> FFc;
  private com.tencent.mm.api.i FFd;
  Bitmap FFe;
  private boolean FFf = true;
  private boolean FFg = true;
  public c FFh;
  com.tencent.mm.api.g FFi = com.tencent.mm.api.g.cSm;
  com.tencent.mm.api.g FFj = com.tencent.mm.api.g.cSm;
  private boolean FFk = false;
  com.tencent.mm.e.b FFl = null;
  y.a cSv;
  
  private void fjM()
  {
    AppMethodBeat.i(9319);
    this.FFc.clear();
    this.FFb.clear();
    this.FFb.put(com.tencent.mm.api.g.cSm, com.tencent.mm.e.b.dbq);
    com.tencent.mm.api.g[] arrayOfg = this.FFa.getFeatures();
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
      switch (a.7.FFo[localg.ordinal()])
      {
      default: 
      case 7: 
      case 4: 
        for (localObject1 = localIterator;; localObject1 = new d())
        {
          if (localObject1 != null)
          {
            if (!this.FFb.containsKey(localg)) {
              this.FFb.put(localg, localObject1);
            }
            if (!this.FFc.contains(localObject1))
            {
              this.FFc.add(localObject1);
              ((com.tencent.mm.e.b)localObject1).a(this, this.FFa.getBaseBoardView().getMainMatrix(), this.FFa.getBaseBoardView().getAliveRect());
            }
          }
          i += 1;
          break;
        }
      case 1: 
      case 2: 
        localIterator = this.FFc.iterator();
        while (localIterator.hasNext())
        {
          localObject1 = (com.tencent.mm.e.b)localIterator.next();
          if (((com.tencent.mm.e.b)localObject1).NG() == com.tencent.mm.e.a.dbh) {
            j = 1;
          }
        }
      }
    }
    while (j == 0)
    {
      localObject1 = new com.tencent.mm.e.e();
      ((com.tencent.mm.e.e)localObject1).dcA = new a();
      break;
      localObject1 = new com.tencent.mm.e.g();
      break;
      localObject1 = new c();
      break;
      localObject1 = new com.tencent.mm.e.f();
      break;
      Collections.sort(this.FFc, new Comparator() {});
      ae.i("MicroMsg.DrawingPresenter", "[addArtists] count:%s", new Object[] { Integer.valueOf(this.FFb.size() - 1) });
      AppMethodBeat.o(9319);
      return;
      j = 0;
      localObject1 = localObject2;
    }
  }
  
  public final boolean Kc()
  {
    AppMethodBeat.i(9301);
    if (this.FFa.getTextEditView().getVisibility() == 0)
    {
      wr(false);
      this.FFa.setFooterVisible(true);
      AppMethodBeat.o(9301);
      return true;
    }
    if ((this.FFa.getChatFooterPanel() != null) && (this.FFa.getChatFooterPanel().getVisibility() == 0))
    {
      this.FFa.zr(true);
      this.FFa.setFooterVisible(true);
      AppMethodBeat.o(9301);
      return true;
    }
    AppMethodBeat.o(9301);
    return false;
  }
  
  public final boolean N(MotionEvent paramMotionEvent)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    AppMethodBeat.i(9316);
    boolean bool1 = bool2;
    Object localObject;
    if (fjI().NG() != com.tencent.mm.e.a.dbi)
    {
      if (fjI().NG() == com.tencent.mm.e.a.dbj) {
        bool1 = bool2;
      }
    }
    else
    {
      if (bool1) {
        break label224;
      }
      this.FFl = ((com.tencent.mm.e.b)this.FFb.get(this.FFa.getBaseFooterView().getCurFeatureType()));
      localObject = this.FFc.iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.e.b localb = (com.tencent.mm.e.b)((Iterator)localObject).next();
        if ((localb.NG() != com.tencent.mm.e.a.dbh) && (localb.n(paramMotionEvent))) {
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
      if (this.FFb.containsKey(com.tencent.mm.api.g.cSo)) {
        localObject = (com.tencent.mm.e.b)this.FFb.get(com.tencent.mm.api.g.cSo);
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
        this.FFl = ((com.tencent.mm.e.b)localObject);
        bool1 = bool2;
        break;
        if (this.FFb.containsKey(com.tencent.mm.api.g.cSp)) {
          localObject = (com.tencent.mm.e.b)this.FFb.get(com.tencent.mm.api.g.cSp);
        }
      }
    }
  }
  
  public final com.tencent.mm.cache.f a(com.tencent.mm.e.a parama)
  {
    AppMethodBeat.i(9318);
    ArtistCacheManager.XN();
    parama = ArtistCacheManager.a(this.cSv.path, parama);
    AppMethodBeat.o(9318);
    return parama;
  }
  
  public final void a(Editable paramEditable, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(9303);
    wr(false);
    this.FFa.setFooterVisible(true);
    Object localObject = fjI();
    EditText localEditText;
    if (((com.tencent.mm.e.b)localObject).NG() == com.tencent.mm.e.a.dbh)
    {
      localObject = (com.tencent.mm.e.e)localObject;
      localEditText = (EditText)this.FFa.getTextEditView().findViewById(2131305727);
      if ((localEditText.getTag() == null) || (!(localEditText.getTag() instanceof com.tencent.mm.z.f))) {
        break label119;
      }
      ((com.tencent.mm.e.e)localObject).a((com.tencent.mm.z.f)localEditText.getTag(), k.c(this.FFa.getContext(), paramEditable), paramInt1, paramInt2);
    }
    for (;;)
    {
      localEditText.setTag(null);
      AppMethodBeat.o(9303);
      return;
      label119:
      ((com.tencent.mm.e.e)localObject).a(k.c(this.FFa.getContext(), paramEditable), paramInt1, paramInt2);
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
    this.cSv = parama;
    this.FFb = new HashMap();
    this.FFc = new LinkedList();
    Object localObject = parama.path;
    if ((bu.isNullOrNil((String)localObject)) || (!o.fB((String)localObject))) {
      ae.w("MicroMsg.DrawingPresenter", "[checkImage] path:%s", new Object[] { localObject });
    }
    for (;;)
    {
      if (i != 0)
      {
        if (!parama.cSA) {
          break;
        }
        this.FFe = com.tencent.mm.sdk.platformtools.h.decodeFile(parama.path, null);
        if (this.FFe != null) {
          this.FFe = this.FFe.copy(Bitmap.Config.ARGB_8888, true);
        }
      }
      fjM();
      AppMethodBeat.o(9297);
      return;
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      com.tencent.mm.sdk.platformtools.h.decodeFile((String)localObject, localOptions);
      if ((localOptions.outWidth <= 0) || (localOptions.outHeight <= 0)) {
        ae.e("MicroMsg.DrawingPresenter", "[checkImage] image err! w:%s h:%s path:%s", new Object[] { Integer.valueOf(localOptions.outWidth), Integer.valueOf(localOptions.outHeight), localObject });
      } else {
        i = 1;
      }
    }
    localObject = com.tencent.mm.sdk.platformtools.h.aRz(bu.bI(parama.path, ""));
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
      this.FFe = com.tencent.mm.sdk.platformtools.h.aM(bu.bI(parama.path, ""), i, j);
      break;
      i = 1280;
    }
  }
  
  public final void a(com.tencent.mm.view.a parama)
  {
    this.FFa = parama;
  }
  
  public final <T extends com.tencent.mm.e.b> T c(com.tencent.mm.api.g paramg)
  {
    AppMethodBeat.i(9314);
    paramg = (com.tencent.mm.e.b)this.FFb.get(paramg);
    AppMethodBeat.o(9314);
    return paramg;
  }
  
  public final void c(p paramp)
  {
    AppMethodBeat.i(9315);
    com.tencent.mm.e.e locale = (com.tencent.mm.e.e)c(com.tencent.mm.api.g.cSp);
    if (locale != null) {
      locale.b(paramp);
    }
    AppMethodBeat.o(9315);
  }
  
  public final boolean fjE()
  {
    return this.FFg;
  }
  
  public final void fjF()
  {
    this.FFg = false;
  }
  
  public final void fjG()
  {
    AppMethodBeat.i(9304);
    this.FFa.setFooterVisible(true);
    wr(false);
    AppMethodBeat.o(9304);
  }
  
  public final com.tencent.mm.view.a fjH()
  {
    return this.FFa;
  }
  
  public final <T extends com.tencent.mm.e.b> T fjI()
  {
    AppMethodBeat.i(9306);
    if (this.FFl != null)
    {
      localb = this.FFl;
      AppMethodBeat.o(9306);
      return localb;
    }
    ae.e("MicroMsg.DrawingPresenter", "[getCurArtist] is null!");
    com.tencent.mm.e.b localb = com.tencent.mm.e.b.dbq;
    AppMethodBeat.o(9306);
    return localb;
  }
  
  public final void fjJ()
  {
    AppMethodBeat.i(9311);
    ae.i("MicroMsg.DrawingPresenter", "[onLayout]");
    if (!this.FFk)
    {
      this.FFk = true;
      Iterator localIterator = this.FFc.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.e.b localb = (com.tencent.mm.e.b)localIterator.next();
        if (ArtistCacheManager.XN().b(localb.NG()))
        {
          localb.onAlive();
          localb.cl(true);
          ae.i("MicroMsg.DrawingPresenter", "[onAttachedToWindow] %s is revert onAlive!", new Object[] { localb.NG() });
        }
      }
      if (this.FFa.getBaseBoardView().fUG())
      {
        this.FFa.getBaseBoardView().fUH();
        this.FFa.getBaseBoardView().invalidate();
      }
    }
    AppMethodBeat.o(9311);
  }
  
  public final Bitmap fjK()
  {
    return this.FFe;
  }
  
  public final boolean fjL()
  {
    AppMethodBeat.i(9313);
    if ((fjI().NG() != com.tencent.mm.e.a.dbi) && (this.FFf))
    {
      AppMethodBeat.o(9313);
      return true;
    }
    AppMethodBeat.o(9313);
    return false;
  }
  
  public final y.a getConfig()
  {
    return this.cSv;
  }
  
  public final float getCurScale()
  {
    AppMethodBeat.i(9308);
    float f = this.FFa.getBaseBoardView().getCurScale();
    AppMethodBeat.o(9308);
    return f;
  }
  
  public final com.tencent.mm.api.g[] getFeatures()
  {
    AppMethodBeat.i(9298);
    com.tencent.mm.api.g[] arrayOfg = this.FFa.getFeatures();
    AppMethodBeat.o(9298);
    return arrayOfg;
  }
  
  public final float getInitScale()
  {
    AppMethodBeat.i(9307);
    float f = this.FFa.getBaseBoardView().getInitScale();
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
        ae.i("MicroMsg.DrawingPresenter", "[onSelectedFeature] features:%s", new Object[] { paramAnonymousg });
        if (paramAnonymousg == com.tencent.mm.api.g.cSm) {
          a.this.FFa.getBaseFooterView().setCurFeatureType(paramAnonymousg);
        }
        a.this.FFa.getBaseFooterView().fUP();
        if (a.this.FFa.getSelectedFeatureListener() != null) {
          a.this.FFa.getSelectedFeatureListener().a(paramAnonymousg);
        }
        if (paramAnonymousg == com.tencent.mm.api.g.cSs) {
          a.this.FFa.getFooterBg().setVisibility(8);
        }
        com.tencent.mm.e.b localb = (com.tencent.mm.e.b)a.this.FFb.get(paramAnonymousg);
        if (localb == null)
        {
          AppMethodBeat.o(9279);
          return;
        }
        if ((localb.cLi) && (!localb.isAlive())) {
          localb.onAlive();
        }
        if (localb.NG() != com.tencent.mm.e.a.dbe) {
          localb.setOneFingerMoveEnable(false);
        }
        localb.NJ();
        a.this.FFl = localb;
        switch (a.7.FFo[paramAnonymousg.ordinal()])
        {
        default: 
          a.this.FFj = paramAnonymousg;
        }
        for (;;)
        {
          a.this.FFa.getBaseFooterView().setCurFeatureType(paramAnonymousg);
          AppMethodBeat.o(9279);
          return;
          if (!a.this.FFa.getBaseFooterView().fUK())
          {
            ((EditText)a.this.FFa.getTextEditView().findViewById(2131305727)).setTextColor(com.tencent.mm.view.footer.a.LQk[0]);
            a.this.wr(true);
            a.this.FFa.setFooterVisible(false);
          }
          a.this.FFj = paramAnonymousg;
          continue;
          a.this.FFa.setActionBarVisible(false);
          a.this.FFa.setFooterVisible(false);
          a.this.FFa.zr(false);
          break;
          a.this.FFi = a.this.FFj;
        }
      }
      
      public final void a(com.tencent.mm.api.g paramAnonymousg, int paramAnonymousInt, Object paramAnonymousObject)
      {
        AppMethodBeat.i(163137);
        ae.i("MicroMsg.DrawingPresenter", "[onSelectedDetailFeature] features:%s index:%s", new Object[] { paramAnonymousg, Integer.valueOf(paramAnonymousInt) });
        if (a.this.FFa.getSelectedFeatureListener() != null) {
          a.this.FFa.getSelectedFeatureListener().a(paramAnonymousg, paramAnonymousInt, paramAnonymousObject);
        }
        a.this.FFl = ((com.tencent.mm.e.b)a.this.FFb.get(paramAnonymousg));
        if (a.this.fjI().NG() == com.tencent.mm.e.a.dbe)
        {
          AppMethodBeat.o(163137);
          return;
        }
        if (a.this.FFa.getFooterBg().getVisibility() == 8) {
          a.this.FFa.getFooterBg().setVisibility(0);
        }
        float f2;
        switch (a.7.FFo[paramAnonymousg.ordinal()])
        {
        default: 
          AppMethodBeat.o(163137);
          return;
        case 4: 
          paramAnonymousg = (d)a.this.fjI();
          if (paramAnonymousInt != -1)
          {
            a.this.FFa.getBaseFooterView();
            paramAnonymousg.mColor = com.tencent.mm.view.footer.a.getColor(paramAnonymousInt);
            AppMethodBeat.o(163137);
            return;
          }
          paramAnonymousg.NO();
          AppMethodBeat.o(163137);
          return;
        case 5: 
          paramAnonymousg = (com.tencent.mm.e.g)a.this.fjI();
          if (paramAnonymousInt == 0)
          {
            paramAnonymousg.dcH = e.a.gBN;
            AppMethodBeat.o(163137);
            return;
          }
          if (1 == paramAnonymousInt)
          {
            paramAnonymousg.dcH = e.a.gBO;
            AppMethodBeat.o(163137);
            return;
          }
          paramAnonymousg.NO();
          AppMethodBeat.o(163137);
          return;
        case 3: 
          paramAnonymousg = (c)a.this.fjI();
          if (paramAnonymousInt == 0)
          {
            paramAnonymousg.dbY += 1;
            paramAnonymousg.dbJ.cancel();
            if (paramAnonymousg.dbW != null) {
              paramAnonymousg.dbW.cancel();
            }
            paramAnonymousObject = new Matrix();
            paramAnonymousObject.postRotate(-90.0F, paramAnonymousg.cQy.centerX(), paramAnonymousg.cQy.centerY());
            if (paramAnonymousg.dbX.isEmpty()) {
              paramAnonymousg.dbX.set(paramAnonymousg.cQy);
            }
            RectF localRectF = new RectF(paramAnonymousg.dbX);
            paramAnonymousObject.mapRect(localRectF);
            f1 = 1.0F * paramAnonymousg.dbF.width() / localRectF.width();
            f2 = 1.0F * paramAnonymousg.dbF.height() / localRectF.height();
            if (f1 < f2) {}
            for (;;)
            {
              paramAnonymousObject.postScale(f1, f1, paramAnonymousg.cQy.centerX(), paramAnonymousg.cQy.centerY());
              localRectF.set(paramAnonymousg.dbX);
              paramAnonymousObject.mapRect(localRectF);
              paramAnonymousg.dbX.set((int)localRectF.left, (int)localRectF.top, (int)localRectF.right, (int)localRectF.bottom);
              f2 = paramAnonymousg.cQy.centerX();
              float f3 = paramAnonymousg.cQy.centerY();
              paramAnonymousObject = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofInt("rotation", new int[] { 0, -90 }), PropertyValuesHolder.ofInt("deltaX", new int[] { 0, paramAnonymousg.dbF.centerX() - (int)f2 }), PropertyValuesHolder.ofInt("deltaY", new int[] { 0, paramAnonymousg.dbF.centerY() - (int)f3 }) });
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
            ae.i("MicroMsg.CropArtist", "[cancel]");
            paramAnonymousg.dbJ.cancel();
            if (paramAnonymousg.dbW != null) {
              paramAnonymousg.dbW.cancel();
            }
            paramAnonymousg.dbm.fjH().getBaseBoardView().LPa = paramAnonymousg.dbm.fjH().getBaseBoardView().getRawBoardRect();
            if (paramAnonymousg.NI() == null) {
              break label1243;
            }
            paramAnonymousObject = ((com.tencent.mm.cache.a)paramAnonymousg.NI()).XQ();
            if (paramAnonymousObject == null) {
              break label1243;
            }
            f2 = paramAnonymousg.getRotation() - paramAnonymousg.b(paramAnonymousObject.mMatrix);
            f1 = f2;
            if (!paramAnonymousObject.gBq.isEmpty()) {
              paramAnonymousg.dbm.fjH().getBaseBoardView().q(paramAnonymousObject.gBq);
            }
          }
          break;
        }
        label1243:
        for (float f1 = f2;; f1 = 0.0F)
        {
          paramAnonymousg.dbm.fjH().getBaseBoardView().a(null, f1, true);
          paramAnonymousg.dbm.fjH().getActionBar().setVisibility(0);
          a.this.FFl = ((com.tencent.mm.e.b)a.this.FFb.get(a.this.FFi));
          a.this.FFa.getBaseFooterView().setCurFeatureType(a.this.FFi);
          AppMethodBeat.o(163137);
          return;
          if (2 == paramAnonymousInt)
          {
            ae.i("MicroMsg.CropArtist", "[doCrop]");
            if (paramAnonymousg.dbW != null) {
              paramAnonymousg.dbW.cancel();
            }
            if (!paramAnonymousg.dbJ.cQF)
            {
              if (!paramAnonymousg.dbJ.aLU)
              {
                paramAnonymousg.dbJ.cancel();
                paramAnonymousg.dbJ.play();
              }
              paramAnonymousg.dbJ.wR = new c.7(paramAnonymousg);
            }
            for (;;)
            {
              a.this.FFl = ((com.tencent.mm.e.b)a.this.FFb.get(a.this.FFi));
              a.this.FFa.getBaseFooterView().setCurFeatureType(a.this.FFi);
              AppMethodBeat.o(163137);
              return;
              paramAnonymousg.dbJ.wR = null;
              paramAnonymousg.NU();
            }
          }
          if (3 != paramAnonymousInt) {
            break;
          }
          ae.i("MicroMsg.CropArtist", "[reset]");
          paramAnonymousg.dbZ = true;
          paramAnonymousg.dbJ.cancel();
          if (paramAnonymousg.dbW != null) {
            paramAnonymousg.dbW.cancel();
          }
          paramAnonymousg.dbX.setEmpty();
          paramAnonymousg.NT();
          paramAnonymousg.dbP = false;
          paramAnonymousg.dbm.fjH().getBaseBoardView().LPa = paramAnonymousg.cQy;
          paramAnonymousg.dbm.fjH().getBaseBoardView().a(new c.9(paramAnonymousg), paramAnonymousg.getRotation(), true);
          AppMethodBeat.o(163137);
          return;
          paramAnonymousg = (com.tencent.mm.e.f)a.this.fjI();
          f1 = ((Float)paramAnonymousObject).floatValue();
          paramAnonymousObject = (com.tencent.mm.cache.e)paramAnonymousg.NI();
          if (paramAnonymousObject != null) {
            paramAnonymousObject.fKo = paramAnonymousInt;
          }
          paramAnonymousg = (com.tencent.mm.cache.e)paramAnonymousg.NI();
          if (paramAnonymousg != null) {
            paramAnonymousg.fKp = f1;
          }
          a.this.FFa.getBaseBoardView().postInvalidate();
          ae.i("MicroMsg.DrawingPresenter", "lxl postInvalidate");
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
    ae.i("MicroMsg.DrawingPresenter", "[onAttachedToWindow]");
    if (!this.FFk)
    {
      this.FFk = true;
      Iterator localIterator = this.FFc.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.e.b localb = (com.tencent.mm.e.b)localIterator.next();
        if (ArtistCacheManager.XN().b(localb.NG()))
        {
          localb.onAlive();
          localb.cl(true);
          ae.i("MicroMsg.DrawingPresenter", "[onAttachedToWindow] %s is revert onAlive!", new Object[] { localb.NG() });
        }
      }
      if (this.FFa.getBaseBoardView().fUG())
      {
        this.FFa.getBaseBoardView().fUH();
        this.FFa.getBaseBoardView().invalidate();
      }
    }
    AppMethodBeat.o(9312);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9310);
    Iterator localIterator = this.FFc.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.e.b)localIterator.next()).onDestroy();
    }
    this.FFc.clear();
    this.FFb.clear();
    AppMethodBeat.o(9310);
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9317);
    Iterator localIterator = this.FFc.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.e.b localb = (com.tencent.mm.e.b)localIterator.next();
      if (localb.isAlive()) {
        if (fjI().NG() == localb.NG())
        {
          localb.onDraw(paramCanvas);
        }
        else
        {
          paramCanvas.save();
          paramCanvas.clipRect(this.FFa.getBaseBoardView().getAliveRect());
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
    if (this.FFd != null) {
      this.FFd.onExit();
    }
    AppMethodBeat.o(9300);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(9302);
    if (this.FFd != null) {
      this.FFd.onFinish();
    }
    AppMethodBeat.o(9302);
  }
  
  public final void setActionBarCallback(com.tencent.mm.api.i parami)
  {
    this.FFd = parami;
  }
  
  public final void setAutoShowFooterAndBar(boolean paramBoolean)
  {
    this.FFf = paramBoolean;
  }
  
  public final void setInitScale(float paramFloat)
  {
    AppMethodBeat.i(195428);
    this.FFa.getBaseBoardView().setInitScale(paramFloat);
    AppMethodBeat.o(195428);
  }
  
  final void wr(boolean paramBoolean)
  {
    AppMethodBeat.i(9320);
    if (paramBoolean)
    {
      localAnimation = AnimationUtils.loadAnimation(this.FFa.getContext(), 2130772108);
      localAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(9283);
          a.this.FFa.getTextEditView().setVisibility(0);
          paramAnonymousAnimation = (EditText)a.this.FFa.getTextEditView().findViewById(2131305727);
          paramAnonymousAnimation.requestFocus();
          paramAnonymousAnimation.setSelection(paramAnonymousAnimation.length());
          a.this.FFa.getSelectedFeatureListener().bY(true);
          ((SelectColorBar)a.this.FFa.findViewById(2131304505)).setSelectColor(paramAnonymousAnimation.getCurrentTextColor());
          a.this.FFa.getActionBar().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(9282);
              a.this.FFa.getActionBar().setVisibility(0);
              AppMethodBeat.o(9282);
            }
          });
          AppMethodBeat.o(9283);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      this.FFa.getTextEditView().startAnimation(localAnimation);
      AppMethodBeat.o(9320);
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(this.FFa.getContext(), 2130772106);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(9285);
        ((EditText)a.this.FFa.getTextEditView().findViewById(2131305727)).setText("");
        a.this.FFa.getTextEditView().setVisibility(8);
        AppMethodBeat.o(9285);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(9284);
        a.this.FFa.getSelectedFeatureListener().bY(false);
        AppMethodBeat.o(9284);
      }
    });
    this.FFa.getTextEditView().startAnimation(localAnimation);
    AppMethodBeat.o(9320);
  }
  
  public final class a
    implements com.tencent.mm.af.a
  {
    View FFp;
    TextView FFq;
    ImageView FFr;
    
    public a()
    {
      AppMethodBeat.i(9289);
      this.FFp = a.this.FFa.getRubbishView();
      this.FFq = ((TextView)this.FFp.findViewById(2131304270));
      this.FFr = ((ImageView)this.FFp.findViewById(2131304268));
      AppMethodBeat.o(9289);
    }
    
    public final void a(com.tencent.mm.z.f paramf)
    {
      AppMethodBeat.i(9294);
      EditText localEditText = (EditText)a.this.FFa.getTextEditView().findViewById(2131305727);
      localEditText.setTag(paramf);
      if (a.this.FFh != null)
      {
        a.this.FFh.b(paramf);
        AppMethodBeat.o(9294);
        return;
      }
      localEditText.setText(paramf.gBT);
      Switch localSwitch = (Switch)a.this.FFa.findViewById(2131297210);
      SelectColorBar localSelectColorBar = (SelectColorBar)a.this.FFa.findViewById(2131304505);
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
        a.this.wr(true);
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
      ae.i("MicroMsg.DrawingPresenter", "[onReach] distance:%s", new Object[] { Float.valueOf(paramFloat) });
      this.FFp.setActivated(true);
      this.FFq.setText(a.this.FFa.getContext().getString(2131762742));
      this.FFr.setImageDrawable(ao.k(a.this.FFa.getContext(), 2131690385, -1));
      AppMethodBeat.o(9290);
    }
    
    public final void ali()
    {
      AppMethodBeat.i(9291);
      ae.i("MicroMsg.DrawingPresenter", "[onUnReach]");
      this.FFp.setActivated(false);
      this.FFr.setImageDrawable(ao.k(a.this.FFa.getContext(), 2131690384, -1));
      this.FFq.setText(a.this.FFa.getContext().getString(2131762743));
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
      if (a.this.FFh != null) {
        a.this.FFh.k(Boolean.TRUE);
      }
      AppMethodBeat.o(9292);
    }
  }
  
  final class b
    implements Runnable
  {
    s FFs;
    boolean FFt;
    
    b(s params, boolean paramBoolean)
    {
      this.FFs = params;
      this.FFt = paramBoolean;
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
          ae.printErrStackTrace("MicroMsg.DrawingPresenter", localOutOfMemoryError, "", new Object[0]);
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
        Iterator localIterator1 = a.this.FFc.iterator();
        while (localIterator1.hasNext()) {
          ((com.tencent.mm.e.b)localIterator1.next()).NK();
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
        com.tencent.e.h.MqF.aM(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(195427);
            a.b.this.FFs.onError(localException1);
            AppMethodBeat.o(195427);
          }
        });
        try
        {
          localIterator2 = a.this.FFc.iterator();
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
        if (!a.this.FFa.getBaseBoardView().fUG())
        {
          i = a.this.FFa.getBaseBoardView().getAliveRect().width();
          j = a.this.FFa.getBaseBoardView().getAliveRect().height();
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
          this.FFs.onError(new NullPointerException("bitmap is null!"));
          try
          {
            localObject1 = a.this.FFc.iterator();
            while (((Iterator)localObject1).hasNext()) {
              ((com.tencent.mm.e.b)((Iterator)localObject1).next()).onFinish();
            }
            localBitmap1 = a.this.FFe;
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
        localObject4 = a.this.FFc.iterator();
        while (((Iterator)localObject4).hasNext()) {
          ((com.tencent.mm.e.b)((Iterator)localObject4).next()).NI().e((Canvas)localObject3);
        }
      }
      finally
      {
        try
        {
          localObject3 = a.this.FFc.iterator();
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
      com.tencent.mm.sdk.platformtools.h.decodeFile(a.this.cSv.path, localOptions);
      float f1 = localOptions.outHeight * 1.0F / localBitmap2.getHeight();
      float f2 = localOptions.outWidth * 1.0F / localBitmap2.getWidth();
      if (f1 > f2) {
        break label814;
      }
      for (;;)
      {
        f1 = a.this.FFa.getBaseBoardView().b(a.this.FFa.getBaseBoardView().getMainMatrix());
        localObject4 = new Matrix();
        ((Matrix)localObject4).postScale(f2, f2, 0.0F, 0.0F);
        ((Matrix)localObject4).postRotate(-f1);
        Rect localRect = new Rect(a.this.FFa.getBaseBoardView().getAliveRect());
        ae.i("MicroMsg.DrawingPresenter", "[saveEditPhoto] clipRectF:%s w:%s h:%s", new Object[] { localRect, Integer.valueOf(localBitmap2.getWidth()), Integer.valueOf(localBitmap2.getHeight()) });
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
        com.tencent.e.h.MqF.aM(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(195426);
            a.b.this.FFs.a(this.wHC, a.b.this.FFt);
            AppMethodBeat.o(195426);
          }
        });
        try
        {
          localObject2 = a.this.FFc.iterator();
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
    
    public abstract void k(Boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.bt.a
 * JD-Core Version:    0.7.0.1
 */