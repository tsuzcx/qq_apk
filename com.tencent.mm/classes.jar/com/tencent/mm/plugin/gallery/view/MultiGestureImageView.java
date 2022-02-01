package com.tencent.mm.plugin.gallery.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.OverScroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.f;
import java.lang.ref.WeakReference;

public class MultiGestureImageView
  extends LinearLayout
{
  private b CfA;
  private MultiTouchImageView Cfg;
  private long Cfh;
  private long Cfi;
  private float Cfj;
  private float Cfk;
  private long Cfl;
  private boolean Cfm;
  private OverScroller Cfn;
  private GestureDetector Cfo;
  private RectF Cfp;
  private a Cfq;
  private float Cfr;
  private boolean Cfs;
  private boolean Cft;
  private boolean Cfu;
  private boolean Cfv;
  private j Cfw;
  private j Cfx;
  private j Cfy;
  private d Cfz;
  private int amg;
  private int amh;
  private int count;
  private float eYT;
  private int pEj;
  private int pEk;
  
  public MultiGestureImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(111768);
    this.count = 0;
    this.Cfh = 0L;
    this.Cfi = 0L;
    this.Cfj = 0.0F;
    this.Cfk = 0.0F;
    this.Cfl = 0L;
    this.Cfm = false;
    this.Cfp = new RectF();
    this.Cfs = false;
    this.Cft = false;
    this.Cfu = false;
    this.Cfv = false;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(111768);
  }
  
  public MultiGestureImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(111769);
    this.count = 0;
    this.Cfh = 0L;
    this.Cfi = 0L;
    this.Cfj = 0.0F;
    this.Cfk = 0.0F;
    this.Cfl = 0L;
    this.Cfm = false;
    this.Cfp = new RectF();
    this.Cfs = false;
    this.Cft = false;
    this.Cfu = false;
    this.Cfv = false;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(111769);
  }
  
  private void eve()
  {
    AppMethodBeat.i(111774);
    this.Cfw.removeMessages(1);
    AppMethodBeat.o(111774);
  }
  
  private void evf()
  {
    AppMethodBeat.i(111775);
    eve();
    this.Cfw.p(1, 15L, 15L);
    AppMethodBeat.o(111775);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(111770);
    this.Cfg = new MultiTouchImageView(paramContext, paramAttributeSet);
    this.Cfo = new GestureDetector(paramContext, new MultiGestureImageView.c(this, (byte)0));
    this.Cfn = new OverScroller(paramContext, new DecelerateInterpolator(2.0F));
    paramContext = new LinearLayout.LayoutParams(-1, -1);
    this.Cfg.setLayoutParams(paramContext);
    addView(this.Cfg);
    this.Cfw = new j(new WeakReference(this));
    this.Cfx = new j(new WeakReference(this));
    this.Cfy = new j(new WeakReference(this));
    AppMethodBeat.o(111770);
  }
  
  public void computeScroll()
  {
    int m = 0;
    AppMethodBeat.i(111773);
    if (this.Cfg == null)
    {
      AppMethodBeat.o(111773);
      return;
    }
    float f4;
    float f5;
    int j;
    int k;
    if (this.Cfn.computeScrollOffset())
    {
      i = this.Cfn.getCurrX() - this.amg;
      int n = this.Cfn.getCurrY() - this.amh;
      this.amg = this.Cfn.getCurrX();
      this.amh = this.Cfn.getCurrY();
      float f3 = this.Cfg.getScale();
      f4 = this.Cfg.getImageWidth();
      float f1 = f3 * this.Cfg.getImageHeight();
      float[] arrayOfFloat = new float[9];
      this.Cfg.getImageMatrix().getValues(arrayOfFloat);
      float f2 = arrayOfFloat[2];
      f3 = f4 * f3 + f2;
      f4 = arrayOfFloat[5];
      f5 = f4 + f1;
      j = i;
      if (i < 0)
      {
        j = i;
        if (i < this.Cfp.right - Math.round(f3)) {
          j = (int)(this.Cfp.right - Math.round(f3));
        }
      }
      i = j;
      if (j > 0)
      {
        i = j;
        if (j > this.Cfp.left - Math.round(f2)) {
          i = (int)(this.Cfp.left - Math.round(f2));
        }
      }
      k = n;
      if (n < 0)
      {
        k = n;
        if (n < this.Cfp.bottom - Math.round(f5)) {
          k = (int)(this.Cfp.bottom - Math.round(f5));
        }
      }
      j = k;
      if (k > 0)
      {
        j = k;
        if (k > this.Cfp.top - Math.round(f4)) {
          j = (int)(this.Cfp.top - Math.round(f4));
        }
      }
      if ((Math.round(f2) < this.Cfp.left) && (Math.round(f3) > this.Cfp.right)) {
        break label424;
      }
      k = 0;
      if (f1 >= this.pEk) {
        break label472;
      }
    }
    label424:
    label472:
    for (int i = m;; i = j)
    {
      this.Cfg.az(k, i);
      postInvalidate();
      AppMethodBeat.o(111773);
      return;
      if (Math.round(f4) < this.Cfp.top)
      {
        k = i;
        if (Math.round(f5) > this.Cfp.bottom) {
          break;
        }
      }
      j = 0;
      k = i;
      break;
    }
  }
  
  public int getImageHeight()
  {
    AppMethodBeat.i(111779);
    int i = this.Cfg.getImageHeight();
    AppMethodBeat.o(111779);
    return i;
  }
  
  public int getImageWidth()
  {
    AppMethodBeat.i(111777);
    int i = this.Cfg.getImageWidth();
    AppMethodBeat.o(111777);
    return i;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111771);
    super.onMeasure(paramInt1, paramInt2);
    this.pEj = View.MeasureSpec.getSize(paramInt1);
    this.pEk = View.MeasureSpec.getSize(paramInt2);
    this.Cfp.set(0.0F, 0.0F, this.pEj, this.pEk);
    Log.v("MicroMsg.MultiGestureImageView", "MMGestureGallery width:" + this.pEj + " height:" + this.pEk);
    AppMethodBeat.o(111771);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(111772);
    Object localObject = this.Cfo;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aFh(), "com/tencent/mm/plugin/gallery/view/MultiGestureImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)locala.sf(0)), "com/tencent/mm/plugin/gallery/view/MultiGestureImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    float f1;
    float f2;
    float f3;
    if (paramMotionEvent.getAction() == 0)
    {
      this.Cfn.forceFinished(true);
      this.Cfy.removeMessages(2);
      this.Cfy.p(2, 500L, 0L);
      this.Cfg.hJz();
      this.count += 1;
      if (this.count == 1)
      {
        this.Cfh = System.currentTimeMillis();
        this.Cfj = f.j(paramMotionEvent, 0);
        this.Cfk = f.k(paramMotionEvent, 0);
      }
    }
    else
    {
      if ((paramMotionEvent.getAction() == 6) || (paramMotionEvent.getAction() == 262))
      {
        this.Cfy.removeMessages(2);
        this.eYT = 0.0F;
        this.Cfr = this.Cfg.getScale();
        this.Cfm = true;
        float f4;
        if (this.Cfr < this.Cfg.getScaleRate())
        {
          f1 = f.j(paramMotionEvent, 0);
          f2 = f.j(paramMotionEvent, 1);
          f3 = f.k(paramMotionEvent, 0);
          f4 = f.k(paramMotionEvent, 1);
          this.Cfg.ay(f1 - f2 + f.j(paramMotionEvent, 1), f3 - f4 + f.k(paramMotionEvent, 1));
        }
        if (this.Cfr > this.Cfg.getDoubleTabScale())
        {
          f1 = f.j(paramMotionEvent, 0);
          f2 = f.j(paramMotionEvent, 1);
          f3 = f.k(paramMotionEvent, 0);
          f4 = f.k(paramMotionEvent, 1);
          this.Cfg.A(f1 - f2 + f.j(paramMotionEvent, 1), f3 - f4 + f.k(paramMotionEvent, 1));
        }
      }
      if (paramMotionEvent.getAction() == 1)
      {
        this.Cfy.removeMessages(2);
        if (((!this.Cfu) && (!this.Cfv)) || ((!this.Cfs) && (!this.Cft))) {
          break label855;
        }
        this.Cfq = new f(this.Cfg);
        evf();
        this.Cfu = false;
        this.Cfv = false;
        this.Cfs = false;
        this.Cft = false;
        label445:
        this.eYT = 0.0F;
        this.Cfr = this.Cfg.getScale();
        if (this.count == 1)
        {
          this.Cfi = System.currentTimeMillis();
          if (this.Cfi - this.Cfh >= 350L) {
            break label986;
          }
          if ((Math.abs(this.Cfj - f.j(paramMotionEvent, 0)) < 10.0F) && (Math.abs(this.Cfk - f.k(paramMotionEvent, 0)) < 10.0F))
          {
            localObject = this.Cfx;
            ((j)localObject).fXP = false;
            ((j)localObject).p(0, 350L, 0L);
          }
        }
      }
      label554:
      if ((paramMotionEvent.getAction() == 5) || (paramMotionEvent.getAction() == 261))
      {
        this.eYT = 0.0F;
        this.Cfr = this.Cfg.getScale();
        this.Cfm = true;
      }
      if (paramMotionEvent.getAction() == 2)
      {
        if (f.ar(paramMotionEvent) != 2) {
          break label1057;
        }
        this.Cfy.removeMessages(2);
        this.Cfm = true;
        this.count = 0;
        f1 = f.j(paramMotionEvent, 0) - f.j(paramMotionEvent, 1);
        f2 = f.k(paramMotionEvent, 0) - f.k(paramMotionEvent, 1);
        f3 = (float)Math.sqrt(f1 * f1 + f2 * f2);
        if (this.eYT != 0.0F) {
          break label1003;
        }
        this.eYT = f3;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(111772);
      return true;
      if (this.count != 2) {
        break;
      }
      this.Cfl = System.currentTimeMillis();
      if (this.Cfl - this.Cfi < 350L)
      {
        if ((Math.abs(this.Cfj - f.j(paramMotionEvent, 0)) < 35.0F) && (Math.abs(this.Cfk - f.k(paramMotionEvent, 0)) < 35.0F))
        {
          this.count = 0;
          Log.d("MicroMsg.MultiGestureImageView", "double click!");
          if (this.Cfg.getScale() <= this.Cfg.getScaleRate())
          {
            this.Cfg.A(f.j(paramMotionEvent, 0), f.k(paramMotionEvent, 0));
            break;
          }
          this.Cfg.ay(f.j(paramMotionEvent, 0), f.k(paramMotionEvent, 0));
          this.Cfg.hJy();
          break;
        }
        this.count = 1;
        break;
      }
      this.count = 1;
      break;
      label855:
      if (this.Cfu)
      {
        this.Cfu = false;
        this.Cfq = new g(this.Cfg);
        evf();
      }
      if (this.Cfv)
      {
        this.Cfv = false;
        this.Cfq = new h(this.Cfg);
        evf();
      }
      if (this.Cfs)
      {
        this.Cfs = false;
        this.Cfq = new i(this.Cfg);
        evf();
      }
      if (!this.Cft) {
        break label445;
      }
      this.Cft = false;
      this.Cfq = new e(this.Cfg);
      evf();
      break label445;
      label986:
      this.count = 0;
      Log.d("MicroMsg.MultiGestureImageView", "single long click over!");
      break label554;
      label1003:
      f3 /= this.eYT;
      if (this.Cfm)
      {
        this.Cfg.s(f3 * this.Cfr, f1 + f.j(paramMotionEvent, 1), f2 + f.k(paramMotionEvent, 1));
        this.Cfg.hJy();
        continue;
        label1057:
        if ((Math.abs(this.Cfj - f.j(paramMotionEvent, 0)) > 10.0F) || (Math.abs(this.Cfk - f.k(paramMotionEvent, 0)) > 10.0F))
        {
          this.Cfy.removeMessages(2);
          this.count = 0;
          computeScroll();
        }
      }
    }
  }
  
  public void setEnableHorLongBmpMode(boolean paramBoolean)
  {
    AppMethodBeat.i(111776);
    this.Cfg.setEnableHorLongBmpMode(paramBoolean);
    AppMethodBeat.o(111776);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(111781);
    this.Cfg.setImageBitmap(paramBitmap);
    this.Cfg.hJx();
    AppMethodBeat.o(111781);
  }
  
  public void setImageHeight(int paramInt)
  {
    AppMethodBeat.i(111780);
    this.Cfg.setImageHeight(paramInt);
    AppMethodBeat.o(111780);
  }
  
  public void setImageWidth(int paramInt)
  {
    AppMethodBeat.i(111778);
    this.Cfg.setImageWidth(paramInt);
    AppMethodBeat.o(111778);
  }
  
  public void setLongClickOverListener(b paramb)
  {
    this.CfA = paramb;
  }
  
  public void setSingleClickOverListener(d paramd)
  {
    this.Cfz = paramd;
  }
  
  abstract class a
  {
    protected boolean eYG = false;
    
    public a() {}
    
    public final boolean evg()
    {
      return this.eYG;
    }
    
    public abstract void play();
  }
  
  public static abstract interface b {}
  
  public static abstract interface d {}
  
  final class e
    extends MultiGestureImageView.a
  {
    float[] CfC;
    MultiTouchImageView oQr;
    
    public e(MultiTouchImageView paramMultiTouchImageView)
    {
      super();
      AppMethodBeat.i(111750);
      this.CfC = new float[9];
      this.oQr = paramMultiTouchImageView;
      AppMethodBeat.o(111750);
    }
    
    public final void play()
    {
      AppMethodBeat.i(111751);
      MultiGestureImageView.h(MultiGestureImageView.this).getHandler().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(111749);
          MultiGestureImageView.e.this.oQr.getImageMatrix().getValues(MultiGestureImageView.e.this.CfC);
          float f1 = MultiGestureImageView.e.this.oQr.getScale();
          float f2 = MultiGestureImageView.e.this.oQr.getImageHeight() * f1;
          float f3 = MultiGestureImageView.e.this.CfC[5];
          f1 = MultiGestureImageView.i(MultiGestureImageView.this);
          if (f2 < MultiGestureImageView.i(MultiGestureImageView.this)) {
            f1 = MultiGestureImageView.i(MultiGestureImageView.this) / 2.0F + f2 / 2.0F;
          }
          f1 -= f3 + f2;
          if (f1 <= 0.0F) {
            MultiGestureImageView.e.this.eYG = true;
          }
          for (;;)
          {
            MultiGestureImageView.e.this.oQr.az(0.0F, f1);
            AppMethodBeat.o(111749);
            return;
            if (Math.abs(f1) <= 5.0F) {
              MultiGestureImageView.e.this.eYG = true;
            } else {
              f1 = (float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
            }
          }
        }
      });
      AppMethodBeat.o(111751);
    }
  }
  
  final class f
    extends MultiGestureImageView.a
  {
    float[] CfC;
    MultiTouchImageView oQr;
    
    public f(MultiTouchImageView paramMultiTouchImageView)
    {
      super();
      AppMethodBeat.i(111753);
      this.CfC = new float[9];
      this.oQr = paramMultiTouchImageView;
      AppMethodBeat.o(111753);
    }
    
    public final void play()
    {
      AppMethodBeat.i(111754);
      MultiGestureImageView.h(MultiGestureImageView.this).getHandler().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(111752);
          MultiGestureImageView.f.this.oQr.getImageMatrix().getValues(MultiGestureImageView.f.this.CfC);
          float f5 = MultiGestureImageView.f.this.oQr.getScale() * MultiGestureImageView.f.this.oQr.getImageWidth();
          float f1 = MultiGestureImageView.f.this.oQr.getScale();
          float f8 = MultiGestureImageView.f.this.oQr.getImageHeight() * f1;
          float f7 = MultiGestureImageView.f.this.CfC[2];
          float f10 = MultiGestureImageView.f.this.CfC[5];
          float f6 = MultiGestureImageView.f.this.CfC[2];
          float f9 = MultiGestureImageView.f.this.CfC[5];
          float f2 = 0.0F;
          f1 = MultiGestureImageView.i(MultiGestureImageView.this);
          float f3 = 0.0F;
          float f4 = MultiGestureImageView.g(MultiGestureImageView.this);
          if (f8 < MultiGestureImageView.i(MultiGestureImageView.this))
          {
            f2 = MultiGestureImageView.i(MultiGestureImageView.this) / 2.0F - f8 / 2.0F;
            f1 = MultiGestureImageView.i(MultiGestureImageView.this) / 2.0F + f8 / 2.0F;
          }
          for (;;)
          {
            f2 -= f10;
            f1 -= f9 + f8;
            if (f2 < 0.0F) {
              f1 = f2;
            }
            for (;;)
            {
              if (f5 < MultiGestureImageView.g(MultiGestureImageView.this))
              {
                f3 = MultiGestureImageView.g(MultiGestureImageView.this) / 2.0F;
                f4 = f5 / 2.0F;
                f2 = MultiGestureImageView.g(MultiGestureImageView.this) / 2.0F + f5 / 2.0F;
                f3 -= f4;
              }
              for (;;)
              {
                f3 -= f7;
                f2 -= f6 + f5;
                if (f3 < 0.0F) {
                  f2 = f3;
                }
                for (;;)
                {
                  label306:
                  if ((Math.abs(f2) <= 5.0F) && (Math.abs(f1) <= 5.0F)) {
                    MultiGestureImageView.f.this.eYG = true;
                  }
                  for (;;)
                  {
                    MultiGestureImageView.f.this.oQr.az(f2, f1);
                    AppMethodBeat.o(111752);
                    return;
                    if (f1 <= 0.0F) {
                      break label508;
                    }
                    break;
                    if (f2 <= 0.0F) {
                      break label497;
                    }
                    break label306;
                    if (f2 >= 0.0F) {}
                    for (f2 = (float)(Math.abs(f2) - Math.pow(Math.sqrt(Math.abs(f2)) - 1.0D, 2.0D)) * 2.0F;; f2 = -(float)(Math.abs(f2) - Math.pow(Math.sqrt(Math.abs(f2)) - 1.0D, 2.0D)) * 2.0F)
                    {
                      if (f1 < 0.0F) {
                        break label467;
                      }
                      f1 = (float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
                      break;
                    }
                    label467:
                    f1 = -(float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
                  }
                  label497:
                  f2 = 0.0F;
                }
                f2 = f4;
              }
              label508:
              f1 = 0.0F;
            }
          }
        }
      });
      AppMethodBeat.o(111754);
    }
  }
  
  final class g
    extends MultiGestureImageView.a
  {
    float[] CfC;
    MultiTouchImageView oQr;
    
    public g(MultiTouchImageView paramMultiTouchImageView)
    {
      super();
      AppMethodBeat.i(111756);
      this.CfC = new float[9];
      this.oQr = paramMultiTouchImageView;
      AppMethodBeat.o(111756);
    }
    
    public final void play()
    {
      AppMethodBeat.i(111757);
      MultiGestureImageView.h(MultiGestureImageView.this).getHandler().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(111755);
          MultiGestureImageView.g.this.oQr.getImageMatrix().getValues(MultiGestureImageView.g.this.CfC);
          float f2 = MultiGestureImageView.g.this.CfC[2];
          float f1 = MultiGestureImageView.g.this.oQr.getScale() * MultiGestureImageView.g.this.oQr.getImageWidth();
          if (f1 < MultiGestureImageView.g(MultiGestureImageView.this)) {}
          for (f1 = MultiGestureImageView.g(MultiGestureImageView.this) / 2.0F - f1 / 2.0F;; f1 = 0.0F)
          {
            f1 -= f2;
            if (f1 >= 0.0F) {
              MultiGestureImageView.g.this.eYG = true;
            }
            for (;;)
            {
              MultiGestureImageView.g.this.oQr.az(f1, 0.0F);
              AppMethodBeat.o(111755);
              return;
              if (Math.abs(f1) <= 5.0F) {
                MultiGestureImageView.g.this.eYG = true;
              } else {
                f1 = -(float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
              }
            }
          }
        }
      });
      AppMethodBeat.o(111757);
    }
  }
  
  final class h
    extends MultiGestureImageView.a
  {
    float[] CfC;
    MultiTouchImageView oQr;
    
    public h(MultiTouchImageView paramMultiTouchImageView)
    {
      super();
      AppMethodBeat.i(111759);
      this.CfC = new float[9];
      this.oQr = paramMultiTouchImageView;
      AppMethodBeat.o(111759);
    }
    
    public final void play()
    {
      AppMethodBeat.i(111760);
      MultiGestureImageView.h(MultiGestureImageView.this).getHandler().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(111758);
          MultiGestureImageView.h.this.oQr.getImageMatrix().getValues(MultiGestureImageView.h.this.CfC);
          float f1 = MultiGestureImageView.h.this.oQr.getScale();
          float f2 = MultiGestureImageView.h.this.oQr.getImageWidth() * f1;
          float f3 = MultiGestureImageView.h.this.CfC[2];
          f1 = MultiGestureImageView.g(MultiGestureImageView.this);
          if (f2 < MultiGestureImageView.g(MultiGestureImageView.this)) {
            f1 = MultiGestureImageView.g(MultiGestureImageView.this) / 2.0F + f2 / 2.0F;
          }
          f1 -= f3 + f2;
          if (f1 <= 0.0F) {
            MultiGestureImageView.h.this.eYG = true;
          }
          for (;;)
          {
            MultiGestureImageView.h.this.oQr.az(f1, 0.0F);
            AppMethodBeat.o(111758);
            return;
            if (Math.abs(f1) <= 5.0F) {
              MultiGestureImageView.h.this.eYG = true;
            } else {
              f1 = (float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
            }
          }
        }
      });
      AppMethodBeat.o(111760);
    }
  }
  
  final class i
    extends MultiGestureImageView.a
  {
    float[] CfC;
    MultiTouchImageView oQr;
    
    public i(MultiTouchImageView paramMultiTouchImageView)
    {
      super();
      AppMethodBeat.i(111762);
      this.CfC = new float[9];
      this.oQr = paramMultiTouchImageView;
      AppMethodBeat.o(111762);
    }
    
    public final void play()
    {
      AppMethodBeat.i(111763);
      MultiGestureImageView.h(MultiGestureImageView.this).getHandler().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(111761);
          MultiGestureImageView.i.this.oQr.getImageMatrix().getValues(MultiGestureImageView.i.this.CfC);
          float f2 = MultiGestureImageView.i.this.CfC[5];
          float f1 = MultiGestureImageView.i.this.oQr.getScale() * MultiGestureImageView.i.this.oQr.getImageHeight();
          if (f1 < MultiGestureImageView.i(MultiGestureImageView.this)) {}
          for (f1 = MultiGestureImageView.i(MultiGestureImageView.this) / 2.0F - f1 / 2.0F;; f1 = 0.0F)
          {
            f1 -= f2;
            if (f1 >= 0.0F) {
              MultiGestureImageView.i.this.eYG = true;
            }
            for (;;)
            {
              MultiGestureImageView.i.this.oQr.az(0.0F, f1);
              AppMethodBeat.o(111761);
              return;
              if (Math.abs(f1) <= 5.0F) {
                MultiGestureImageView.i.this.eYG = true;
              } else {
                f1 = -(float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
              }
            }
          }
        }
      });
      AppMethodBeat.o(111763);
    }
  }
  
  public final class j
    extends MMHandler
  {
    private long CfI;
    WeakReference<MultiGestureImageView> aFW;
    boolean fXP;
    
    public j()
    {
      Object localObject;
      this.aFW = localObject;
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(111766);
      super.handleMessage(paramMessage);
      removeMessages(paramMessage.what);
      if (this.aFW != null)
      {
        final MultiGestureImageView localMultiGestureImageView = (MultiGestureImageView)this.aFW.get();
        if (localMultiGestureImageView != null)
        {
          if (paramMessage.what == 0)
          {
            if ((MultiGestureImageView.a(localMultiGestureImageView) == 1) || (this.fXP))
            {
              Log.d("MicroMsg.MultiGestureImageView", "single click over!");
              if (MultiGestureImageView.b(localMultiGestureImageView) != null) {
                localMultiGestureImageView.getHandler().post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(111764);
                    MultiGestureImageView.b(localMultiGestureImageView);
                    AppMethodBeat.o(111764);
                  }
                });
              }
            }
            MultiGestureImageView.c(MultiGestureImageView.this);
            AppMethodBeat.o(111766);
            return;
          }
          if (paramMessage.what == 1)
          {
            if ((MultiGestureImageView.d(MultiGestureImageView.this) != null) && (!MultiGestureImageView.d(MultiGestureImageView.this).evg()))
            {
              MultiGestureImageView.d(MultiGestureImageView.this).play();
              sendEmptyMessageDelayed(paramMessage.what, this.CfI);
              AppMethodBeat.o(111766);
              return;
            }
            MultiGestureImageView.e(localMultiGestureImageView);
            AppMethodBeat.o(111766);
            return;
          }
          removeMessages(2);
          if (MultiGestureImageView.f(localMultiGestureImageView) != null) {
            localMultiGestureImageView.getHandler().post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(111765);
                MultiGestureImageView.f(localMultiGestureImageView);
                AppMethodBeat.o(111765);
              }
            });
          }
        }
      }
      AppMethodBeat.o(111766);
    }
    
    public final void p(int paramInt, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(111767);
      this.CfI = paramLong2;
      sendEmptyMessageDelayed(paramInt, paramLong1);
      AppMethodBeat.o(111767);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.view.MultiGestureImageView
 * JD-Core Version:    0.7.0.1
 */