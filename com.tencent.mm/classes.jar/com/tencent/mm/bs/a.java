package com.tencent.mm.bs;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.g;
import com.tencent.mm.api.k;
import com.tencent.mm.api.n;
import com.tencent.mm.api.r;
import com.tencent.mm.api.s.a;
import com.tencent.mm.cache.ArtistCacheManager;
import com.tencent.mm.e.c;
import com.tencent.mm.e.f;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class a
  implements b
{
  s.a bWd;
  com.tencent.mm.view.a whc;
  HashMap<com.tencent.mm.api.e, com.tencent.mm.e.b> whd;
  LinkedList<com.tencent.mm.e.b> whe;
  private g whf;
  Bitmap whg;
  private boolean whh = true;
  public a.c whi;
  com.tencent.mm.api.e whj = com.tencent.mm.api.e.bVV;
  com.tencent.mm.api.e whk = com.tencent.mm.api.e.bVV;
  private boolean whl = false;
  com.tencent.mm.e.b whm = null;
  
  private void dqh()
  {
    AppMethodBeat.i(116342);
    this.whe.clear();
    this.whd.clear();
    this.whd.put(com.tencent.mm.api.e.bVV, com.tencent.mm.e.b.ccW);
    com.tencent.mm.api.e[] arrayOfe = this.whc.getFeatures();
    int k = arrayOfe.length;
    int i = 0;
    Object localObject2;
    Object localObject1;
    int j;
    if (i < k)
    {
      com.tencent.mm.api.e locale = arrayOfe[i];
      localObject2 = null;
      Iterator localIterator = null;
      localObject1 = localIterator;
      switch (a.7.whp[locale.ordinal()])
      {
      default: 
      case 6: 
      case 4: 
        for (localObject1 = localIterator;; localObject1 = new com.tencent.mm.e.d())
        {
          if (localObject1 != null)
          {
            if (!this.whd.containsKey(locale)) {
              this.whd.put(locale, localObject1);
            }
            if (!this.whe.contains(localObject1))
            {
              this.whe.add(localObject1);
              ((com.tencent.mm.e.b)localObject1).a(this, this.whc.getBaseBoardView().getMainMatrix(), this.whc.getBaseBoardView().getAliveRect());
            }
          }
          i += 1;
          break;
        }
      case 1: 
      case 2: 
        localIterator = this.whe.iterator();
        while (localIterator.hasNext())
        {
          localObject1 = (com.tencent.mm.e.b)localIterator.next();
          if (((com.tencent.mm.e.b)localObject1).Cz() == com.tencent.mm.e.a.ccO) {
            j = 1;
          }
        }
      }
    }
    while (j == 0)
    {
      localObject1 = new com.tencent.mm.e.e();
      ((com.tencent.mm.e.e)localObject1).ced = new a.a(this);
      break;
      localObject1 = new f();
      break;
      localObject1 = new c();
      break;
      Collections.sort(this.whe, new a.2(this));
      ab.i("MicroMsg.DrawingPresenter", "[addArtists] count:%s", new Object[] { Integer.valueOf(this.whd.size() - 1) });
      AppMethodBeat.o(116342);
      return;
      j = 0;
      localObject1 = localObject2;
    }
  }
  
  public final boolean K(MotionEvent paramMotionEvent)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    AppMethodBeat.i(116339);
    boolean bool1 = bool2;
    Object localObject;
    if (dqd().Cz() != com.tencent.mm.e.a.ccP)
    {
      if (dqd().Cz() == com.tencent.mm.e.a.ccQ) {
        bool1 = bool2;
      }
    }
    else
    {
      if (bool1) {
        break label222;
      }
      this.whm = ((com.tencent.mm.e.b)this.whd.get(this.whc.getBaseFooterView().getCurFeatureType()));
      localObject = this.whe.iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.mm.e.b localb = (com.tencent.mm.e.b)((Iterator)localObject).next();
        if ((localb.Cz() != com.tencent.mm.e.a.ccO) && (localb.o(paramMotionEvent))) {
          bool1 = true;
        }
      }
    }
    label222:
    for (;;)
    {
      AppMethodBeat.o(116339);
      return bool1;
      localObject = null;
      if (this.whd.containsKey(com.tencent.mm.api.e.bVX)) {
        localObject = (com.tencent.mm.e.b)this.whd.get(com.tencent.mm.api.e.bVX);
      }
      for (;;)
      {
        bool2 = bool3;
        if (localObject != null) {
          bool2 = ((com.tencent.mm.e.b)localObject).o(paramMotionEvent);
        }
        bool1 = bool2;
        if (!bool2) {
          break;
        }
        this.whm = ((com.tencent.mm.e.b)localObject);
        bool1 = bool2;
        break;
        if (this.whd.containsKey(com.tencent.mm.api.e.bVY)) {
          localObject = (com.tencent.mm.e.b)this.whd.get(com.tencent.mm.api.e.bVY);
        }
      }
    }
  }
  
  public final com.tencent.mm.cache.e a(com.tencent.mm.e.a parama)
  {
    AppMethodBeat.i(116341);
    parama = ArtistCacheManager.Jb().a(parama);
    AppMethodBeat.o(116341);
    return parama;
  }
  
  public final void a(Editable paramEditable, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(116327);
    px(false);
    this.whc.setFooterVisible(true);
    Object localObject = dqd();
    EditText localEditText;
    if (((com.tencent.mm.e.b)localObject).Cz() == com.tencent.mm.e.a.ccO)
    {
      localObject = (com.tencent.mm.e.e)localObject;
      localEditText = (EditText)this.whc.getTextEditView().findViewById(2131823497);
      if ((localEditText.getTag() == null) || (!(localEditText.getTag() instanceof com.tencent.mm.y.e))) {
        break label119;
      }
      ((com.tencent.mm.e.e)localObject).a((com.tencent.mm.y.e)localEditText.getTag(), j.b(this.whc.getContext(), paramEditable), paramInt1, paramInt2);
    }
    for (;;)
    {
      localEditText.setTag(null);
      AppMethodBeat.o(116327);
      return;
      label119:
      ((com.tencent.mm.e.e)localObject).a(j.b(this.whc.getContext(), paramEditable), paramInt1, paramInt2);
    }
  }
  
  public final void a(n paramn, boolean paramBoolean)
  {
    AppMethodBeat.i(116333);
    com.tencent.mm.sdk.g.d.post(new a.b(this, paramn, paramBoolean), "onFinalGenerate");
    AppMethodBeat.o(116333);
  }
  
  public final void a(s.a parama)
  {
    int i = 0;
    AppMethodBeat.i(116321);
    this.bWd = parama;
    this.whd = new HashMap();
    this.whe = new LinkedList();
    String str = parama.path;
    if ((bo.isNullOrNil(str)) || (!new File(str).exists()))
    {
      ab.w("MicroMsg.DrawingPresenter", "[checkImage] path:%s", new Object[] { str });
      if (i != 0)
      {
        if (!parama.bWi) {
          break label217;
        }
        this.whg = com.tencent.mm.sdk.platformtools.d.decodeFile(parama.path, null);
        if (this.whg == null) {}
      }
    }
    label217:
    for (this.whg = this.whg.copy(Bitmap.Config.ARGB_8888, true);; this.whg = com.tencent.mm.sdk.platformtools.d.az(bo.bf(parama.path, ""), 1280, 1280))
    {
      dqh();
      AppMethodBeat.o(116321);
      return;
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(str, localOptions);
      if ((localOptions.outWidth <= 0) || (localOptions.outHeight <= 0))
      {
        ab.e("MicroMsg.DrawingPresenter", "[checkImage] image err! w:%s h:%s path:%s", new Object[] { Integer.valueOf(localOptions.outWidth), Integer.valueOf(localOptions.outHeight), str });
        break;
      }
      i = 1;
      break;
    }
  }
  
  public final void a(com.tencent.mm.view.a parama)
  {
    this.whc = parama;
  }
  
  public final <T extends com.tencent.mm.e.b> T c(com.tencent.mm.api.e parame)
  {
    AppMethodBeat.i(116337);
    parame = (com.tencent.mm.e.b)this.whd.get(parame);
    AppMethodBeat.o(116337);
    return parame;
  }
  
  public final void d(k paramk)
  {
    AppMethodBeat.i(116338);
    com.tencent.mm.e.e locale = (com.tencent.mm.e.e)c(com.tencent.mm.api.e.bVY);
    if (locale != null) {
      locale.b(paramk);
    }
    AppMethodBeat.o(116338);
  }
  
  public final void dqb()
  {
    AppMethodBeat.i(116328);
    this.whc.setFooterVisible(true);
    px(false);
    AppMethodBeat.o(116328);
  }
  
  public final com.tencent.mm.view.a dqc()
  {
    return this.whc;
  }
  
  public final <T extends com.tencent.mm.e.b> T dqd()
  {
    AppMethodBeat.i(116330);
    if (this.whm != null)
    {
      localb = this.whm;
      AppMethodBeat.o(116330);
      return localb;
    }
    ab.e("MicroMsg.DrawingPresenter", "[getCurArtist] is null!");
    com.tencent.mm.e.b localb = com.tencent.mm.e.b.ccW;
    AppMethodBeat.o(116330);
    return localb;
  }
  
  public final void dqe()
  {
    AppMethodBeat.i(146039);
    ab.i("MicroMsg.DrawingPresenter", "[onLayout]");
    if (!this.whl)
    {
      this.whl = true;
      Iterator localIterator = this.whe.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.e.b localb = (com.tencent.mm.e.b)localIterator.next();
        if (ArtistCacheManager.Jb().b(localb.Cz()))
        {
          localb.zy();
          localb.bt(true);
          ab.i("MicroMsg.DrawingPresenter", "[onAttachedToWindow] %s is revert onAlive!", new Object[] { localb.Cz() });
        }
      }
      if (this.whc.getBaseBoardView().dQS())
      {
        this.whc.getBaseBoardView().dQT();
        this.whc.getBaseBoardView().invalidate();
      }
    }
    AppMethodBeat.o(146039);
  }
  
  public final Bitmap dqf()
  {
    return this.whg;
  }
  
  public final boolean dqg()
  {
    AppMethodBeat.i(116336);
    if ((dqd().Cz() != com.tencent.mm.e.a.ccP) && (this.whh))
    {
      AppMethodBeat.o(116336);
      return true;
    }
    AppMethodBeat.o(116336);
    return false;
  }
  
  public final s.a getConfig()
  {
    return this.bWd;
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(156832);
    Context localContext = this.whc.getContext();
    AppMethodBeat.o(156832);
    return localContext;
  }
  
  public final float getCurScale()
  {
    AppMethodBeat.i(116332);
    float f = this.whc.getBaseBoardView().getCurScale();
    AppMethodBeat.o(116332);
    return f;
  }
  
  public final com.tencent.mm.api.e[] getFeatures()
  {
    AppMethodBeat.i(116322);
    com.tencent.mm.api.e[] arrayOfe = this.whc.getFeatures();
    AppMethodBeat.o(116322);
    return arrayOfe;
  }
  
  public final float getInitScale()
  {
    AppMethodBeat.i(116331);
    float f = this.whc.getBaseBoardView().getInitScale();
    AppMethodBeat.o(116331);
    return f;
  }
  
  public final r getSelectedFeatureListener()
  {
    AppMethodBeat.i(116323);
    a.1 local1 = new a.1(this);
    AppMethodBeat.o(116323);
    return local1;
  }
  
  public final void onAttachedToWindow()
  {
    AppMethodBeat.i(116335);
    ab.i("MicroMsg.DrawingPresenter", "[onAttachedToWindow]");
    if (!this.whl)
    {
      this.whl = true;
      Iterator localIterator = this.whe.iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.e.b localb = (com.tencent.mm.e.b)localIterator.next();
        if (ArtistCacheManager.Jb().b(localb.Cz()))
        {
          localb.zy();
          localb.bt(true);
          ab.i("MicroMsg.DrawingPresenter", "[onAttachedToWindow] %s is revert onAlive!", new Object[] { localb.Cz() });
        }
      }
      if (this.whc.getBaseBoardView().dQS())
      {
        this.whc.getBaseBoardView().dQT();
        this.whc.getBaseBoardView().invalidate();
      }
    }
    AppMethodBeat.o(116335);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(116334);
    Iterator localIterator = this.whe.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.mm.e.b)localIterator.next()).onDestroy();
    }
    this.whe.clear();
    this.whd.clear();
    AppMethodBeat.o(116334);
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(116340);
    Iterator localIterator = this.whe.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.e.b localb = (com.tencent.mm.e.b)localIterator.next();
      if (localb.isAlive()) {
        if (dqd().Cz() == localb.Cz())
        {
          localb.onDraw(paramCanvas);
        }
        else
        {
          paramCanvas.save();
          paramCanvas.clipRect(this.whc.getBaseBoardView().getAliveRect());
          localb.b(paramCanvas);
          paramCanvas.restore();
        }
      }
    }
    AppMethodBeat.o(116340);
  }
  
  public final void onExit()
  {
    AppMethodBeat.i(116324);
    if (this.whf != null) {
      this.whf.onExit();
    }
    AppMethodBeat.o(116324);
  }
  
  public final void onFinish()
  {
    AppMethodBeat.i(116326);
    if (this.whf != null) {
      this.whf.onFinish();
    }
    AppMethodBeat.o(116326);
  }
  
  final void px(boolean paramBoolean)
  {
    AppMethodBeat.i(116343);
    if (paramBoolean)
    {
      localAnimation = AnimationUtils.loadAnimation(this.whc.getContext(), 2131034230);
      localAnimation.setAnimationListener(new a.3(this));
      this.whc.getTextEditView().startAnimation(localAnimation);
      AppMethodBeat.o(116343);
      return;
    }
    Animation localAnimation = AnimationUtils.loadAnimation(this.whc.getContext(), 2131034228);
    localAnimation.setAnimationListener(new a.4(this));
    this.whc.getTextEditView().startAnimation(localAnimation);
    AppMethodBeat.o(116343);
  }
  
  public final void setActionBarCallback(g paramg)
  {
    this.whf = paramg;
  }
  
  public final void setAutoShowFooterAndBar(boolean paramBoolean)
  {
    this.whh = paramBoolean;
  }
  
  public final boolean zY()
  {
    AppMethodBeat.i(116325);
    if (this.whc.getTextEditView().getVisibility() == 0)
    {
      px(false);
      this.whc.setFooterVisible(true);
      AppMethodBeat.o(116325);
      return true;
    }
    if ((this.whc.getChatFooterPanel() != null) && (this.whc.getChatFooterPanel().getVisibility() == 0))
    {
      this.whc.rN(true);
      this.whc.setFooterVisible(true);
      AppMethodBeat.o(116325);
      return true;
    }
    AppMethodBeat.o(116325);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.bs.a
 * JD-Core Version:    0.7.0.1
 */