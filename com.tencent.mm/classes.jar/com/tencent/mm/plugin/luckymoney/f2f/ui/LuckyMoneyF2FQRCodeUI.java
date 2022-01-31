package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ag.c;
import com.tencent.mm.ag.o;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bx;
import com.tencent.mm.model.bx.a;
import com.tencent.mm.plugin.luckymoney.b.f;
import com.tencent.mm.plugin.luckymoney.b.n;
import com.tencent.mm.plugin.luckymoney.b.w;
import com.tencent.mm.plugin.luckymoney.f2f.a.1;
import com.tencent.mm.plugin.luckymoney.f2f.a.2;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.ay.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.HorizontalListViewV2;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.qbar.QbarNative;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

public class LuckyMoneyF2FQRCodeUI
  extends LuckyMoneyBaseUI
  implements ay.a
{
  private View VH;
  private SensorManager aVT;
  private DisplayMetrics eRM;
  private int[] fmY;
  private d fnI;
  private am fqP;
  private String gfH;
  private n.d iKC = new LuckyMoneyF2FQRCodeUI.9(this);
  private String jxR;
  private String lMg;
  private Button lMp;
  private String lNA;
  private int lNB;
  private View lNM;
  private View lNN;
  private ImageView lNO;
  private TextView lNP;
  private TextView lNQ;
  private ImageView lNR;
  private TextView lNS;
  private TextView lNT;
  private HorizontalListViewV2 lNU;
  private List<String> lNV;
  private Map<String, String> lNW;
  private Queue<Pair<String, Integer>> lNX;
  private LuckyMoneyF2FQRCodeUI.a lNY;
  private TextView lNZ;
  private Bitmap lOA;
  private com.tencent.mm.plugin.luckymoney.particles.b lOB = new LuckyMoneyF2FQRCodeUI.10(this);
  private com.tencent.mm.plugin.luckymoney.particles.b lOC = new com.tencent.mm.plugin.luckymoney.particles.b()
  {
    public final com.tencent.mm.plugin.luckymoney.particles.a.b b(Random paramAnonymousRandom)
    {
      int i = paramAnonymousRandom.nextInt(100);
      if (i < 10)
      {
        if (LuckyMoneyF2FQRCodeUI.o(LuckyMoneyF2FQRCodeUI.this) == null) {
          LuckyMoneyF2FQRCodeUI.g(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, a.e.lucky_money_f2f_firework_ribbon_1, 32));
        }
        return new com.tencent.mm.plugin.luckymoney.particles.a.a(LuckyMoneyF2FQRCodeUI.o(LuckyMoneyF2FQRCodeUI.this));
      }
      if (i < 20)
      {
        if (LuckyMoneyF2FQRCodeUI.p(LuckyMoneyF2FQRCodeUI.this) == null) {
          LuckyMoneyF2FQRCodeUI.h(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, a.e.lucky_money_f2f_firework_ribbon_2, 32));
        }
        return new com.tencent.mm.plugin.luckymoney.particles.a.a(LuckyMoneyF2FQRCodeUI.p(LuckyMoneyF2FQRCodeUI.this));
      }
      if (i < 30)
      {
        if (LuckyMoneyF2FQRCodeUI.q(LuckyMoneyF2FQRCodeUI.this) == null) {
          LuckyMoneyF2FQRCodeUI.i(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, a.e.lucky_money_f2f_firework_ribbon_3, 32));
        }
        return new com.tencent.mm.plugin.luckymoney.particles.a.a(LuckyMoneyF2FQRCodeUI.q(LuckyMoneyF2FQRCodeUI.this));
      }
      if (i < 50)
      {
        if (LuckyMoneyF2FQRCodeUI.r(LuckyMoneyF2FQRCodeUI.this) == null) {
          LuckyMoneyF2FQRCodeUI.j(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, a.e.lucky_money_f2f_firework_leaf_top_1, 32));
        }
        return new com.tencent.mm.plugin.luckymoney.particles.a.a(LuckyMoneyF2FQRCodeUI.r(LuckyMoneyF2FQRCodeUI.this));
      }
      if (i < 75)
      {
        if (LuckyMoneyF2FQRCodeUI.s(LuckyMoneyF2FQRCodeUI.this) == null) {
          LuckyMoneyF2FQRCodeUI.k(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, a.e.lucky_money_f2f_firework_leaf_top_2, 32));
        }
        return new com.tencent.mm.plugin.luckymoney.particles.a.a(LuckyMoneyF2FQRCodeUI.s(LuckyMoneyF2FQRCodeUI.this));
      }
      if (LuckyMoneyF2FQRCodeUI.t(LuckyMoneyF2FQRCodeUI.this) == null) {
        LuckyMoneyF2FQRCodeUI.l(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, a.e.lucky_money_f2f_firework_leaf_top_3, 32));
      }
      return new com.tencent.mm.plugin.luckymoney.particles.a.a(LuckyMoneyF2FQRCodeUI.t(LuckyMoneyF2FQRCodeUI.this));
    }
  };
  final SensorEventListener lOD = new LuckyMoneyF2FQRCodeUI.7(this);
  private ShuffleView lOa;
  private ShuffleView.c lOb;
  private List<View> lOc;
  private ViewGroup lOd;
  private ViewGroup lOe;
  private View lOf;
  private com.tencent.mm.plugin.luckymoney.f2f.a lOg;
  private long lOh;
  private String lOi;
  private ValueAnimator lOj;
  private float lOk;
  private float lOl;
  private float lOm;
  private bx.a lOn = new LuckyMoneyF2FQRCodeUI.1(this);
  private n.c lOo = new LuckyMoneyF2FQRCodeUI.8(this);
  private Bitmap lOp;
  private Bitmap lOq;
  private Bitmap lOr;
  private Bitmap lOs;
  private Bitmap lOt;
  private Bitmap lOu;
  private Bitmap lOv;
  private Bitmap lOw;
  private Bitmap lOx;
  private Bitmap lOy;
  private Bitmap lOz;
  private Bitmap mBitmap;
  private int retCode;
  
  private void bfA()
  {
    if (this.lOc.size() != this.lNB)
    {
      y.i("LuckyMoneyF2FQRCodeUI", "shuffle cards: %d", new Object[] { Integer.valueOf(this.lOc.size()), Integer.valueOf(this.lNB) });
      this.lOc.clear();
      int i = 0;
      while (i < this.lNB)
      {
        View localView = LayoutInflater.from(this).inflate(a.g.lucky_money_f2f_packet_card_view, this.lOa, false);
        ((FrameLayout.LayoutParams)localView.getLayoutParams()).gravity = 81;
        this.lOc.add(localView);
        i += 1;
      }
      this.lOa.setAllShuffleCards(this.lOc);
    }
  }
  
  private void bfx()
  {
    Object localObject1;
    Object localObject2;
    int[] arrayOfInt1;
    int i1;
    int i;
    int j;
    int i2;
    if (!bk.bl(this.jxR))
    {
      localObject1 = this.jxR;
      localObject2 = new byte[40000];
      arrayOfInt1 = new int[2];
      i1 = QbarNative.a((byte[])localObject2, arrayOfInt1, (String)localObject1, 12, 1, "UTF-8");
      QbarNative.nativeRelease();
      if (i1 != 0) {
        break label1897;
      }
      localObject1 = getResources().getDisplayMetrics();
      i = ((DisplayMetrics)localObject1).widthPixels;
      j = ((DisplayMetrics)localObject1).heightPixels;
      if (i < j)
      {
        i = (int)(i * 0.8D);
        i2 = (int)(arrayOfInt1[0] * 0.1D);
        i /= (arrayOfInt1[0] + i2 * 2);
        if (i != 0) {
          break label2041;
        }
        i = 1;
      }
    }
    label645:
    label652:
    label1897:
    label2041:
    for (;;)
    {
      int i5 = i2 * i;
      int i6 = i * (arrayOfInt1[0] + i2 * 2);
      int i7 = arrayOfInt1[1] * i + i * 2 * i2;
      localObject1 = Bitmap.createBitmap(i6, i7, Bitmap.Config.ARGB_8888);
      int[] arrayOfInt3 = new int[i6 * i7];
      int i3 = i / 2;
      int i4 = i / 2;
      Canvas localCanvas = new Canvas((Bitmap)localObject1);
      Paint localPaint = new Paint();
      localPaint.setAntiAlias(true);
      Arrays.fill(arrayOfInt3, -1);
      int[] arrayOfInt2 = new int[6];
      arrayOfInt2[0] = (i * 3 + i / 2);
      arrayOfInt2[1] = (i * 3 + i / 2);
      arrayOfInt2[2] = ((arrayOfInt1[0] - 1 - 3) * i + i / 2);
      arrayOfInt2[3] = (i * 3 + i / 2);
      arrayOfInt2[4] = (i * 3 + i / 2);
      arrayOfInt2[5] = ((arrayOfInt1[1] - 1 - 3) * i + i / 2);
      j = 0;
      int k;
      int m;
      int n;
      for (;;)
      {
        if (j >= arrayOfInt1[1]) {
          break label652;
        }
        k = 0;
        for (;;)
        {
          if (k >= arrayOfInt1[0]) {
            break label645;
          }
          if (localObject2[(arrayOfInt1[0] * j + k)] == 1)
          {
            if (((j >= 0) && (j <= 6) && (k >= 0) && (k <= 6)) || ((j >= 0) && (j <= 6) && (k >= arrayOfInt1[0] - 7) && (k <= arrayOfInt1[0] - 1)) || ((j >= arrayOfInt1[1] - 7) && (j <= arrayOfInt1[1] - 1) && (k >= 0) && (k <= 6))) {
              m = 0;
            }
            for (;;)
            {
              if (m < i)
              {
                n = 0;
                for (;;)
                {
                  if (n < i)
                  {
                    arrayOfInt3[((j * i + i5 + m) * i6 + k * i + i5 + n)] = -1;
                    n += 1;
                    continue;
                    i = j;
                    break;
                  }
                }
                m += 1;
                continue;
                boolean[] arrayOfBoolean = new boolean[10];
                arrayOfBoolean[5] = true;
                if (arrayOfBoolean[((int)(java.lang.Math.random() * 10.0D))] != 0)
                {
                  m = 0;
                  while (m < i)
                  {
                    n = 0;
                    while (n < i)
                    {
                      arrayOfInt3[((j * i + i5 + m) * i6 + k * i + i5 + n)] = -3041484;
                      n += 1;
                    }
                    m += 1;
                  }
                }
                m = 0;
                while (m < i)
                {
                  n = 0;
                  while (n < i)
                  {
                    arrayOfInt3[((j * i + i5 + m) * i6 + k * i + i5 + n)] = -2598591;
                    n += 1;
                  }
                  m += 1;
                }
              }
            }
          }
          k += 1;
        }
        j += 1;
      }
      ((Bitmap)localObject1).setPixels(arrayOfInt3, 0, i6, 0, 0, i6, i7);
      j = 0;
      while (j < 3)
      {
        localPaint.setColor(-2598591);
        localPaint.setStyle(Paint.Style.FILL);
        localCanvas.drawCircle(i * i2 + arrayOfInt2[(j * 2)], i * i2 + arrayOfInt2[(j * 2 + 1)], i * 3 + i4, localPaint);
        localPaint.setColor(-1);
        localCanvas.drawCircle(i * i2 + arrayOfInt2[(j * 2)], i * i2 + arrayOfInt2[(j * 2 + 1)], i * 2 + i3, localPaint);
        j += 1;
      }
      j = 0;
      while (j < 3)
      {
        localPaint.setColor(-3041484);
        localPaint.setStyle(Paint.Style.FILL);
        k = arrayOfInt2[(j * 2)];
        m = i * 1 / 4;
        n = arrayOfInt2[(j * 2 + 1)];
        i3 = i * 1 / 4;
        i4 = arrayOfInt2[(j * 2)];
        i5 = i * 1 / 4;
        i6 = arrayOfInt2[(j * 2 + 1)];
        i7 = i * 1 / 4;
        localCanvas.drawRect(i * i2 + k - i - m, i * i2 + n - i - i3, i5 + (i * i2 + i4 + i), i7 + (i * i2 + i6 + i), localPaint);
        j += 1;
      }
      j = 0;
      while (j < 3)
      {
        localPaint.setColor(-1);
        localPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        localObject2 = new Path();
        ((Path)localObject2).moveTo(i * i2 + arrayOfInt2[(j * 2)] - i - i * 1 / 4, i * i2 + arrayOfInt2[(j * 2 + 1)] - i - i * 1 / 4);
        ((Path)localObject2).quadTo(i * i2 + arrayOfInt2[(j * 2)], i * i2 + arrayOfInt2[(j * 2 + 1)] - i, i * i2 + arrayOfInt2[(j * 2)] + i + i / 4, i * i2 + arrayOfInt2[(j * 2 + 1)] - i - i * 1 / 4);
        ((Path)localObject2).lineTo(i * i2 + arrayOfInt2[(j * 2)] - i - i * 1 / 4, i * i2 + arrayOfInt2[(j * 2 + 1)] - i - i * 1 / 4);
        ((Path)localObject2).close();
        localCanvas.drawPath((Path)localObject2, localPaint);
        ((Path)localObject2).moveTo(i * i2 + arrayOfInt2[(j * 2)] - i - i * 1 / 4, i * i2 + arrayOfInt2[(j * 2 + 1)] - i - i * 1 / 4);
        ((Path)localObject2).quadTo(i * i2 + arrayOfInt2[(j * 2)] - i, i * i2 + arrayOfInt2[(j * 2 + 1)], i * i2 + arrayOfInt2[(j * 2)] - i - i / 4, i * i2 + arrayOfInt2[(j * 2 + 1)] + i + i * 1 / 4);
        ((Path)localObject2).lineTo(i * i2 + arrayOfInt2[(j * 2)] - i - i * 1 / 4, i * i2 + arrayOfInt2[(j * 2 + 1)] - i - i * 1 / 4);
        ((Path)localObject2).close();
        localCanvas.drawPath((Path)localObject2, localPaint);
        ((Path)localObject2).moveTo(i * i2 + arrayOfInt2[(j * 2)] + i + i * 1 / 4, i * i2 + arrayOfInt2[(j * 2 + 1)] + i + i * 1 / 4);
        ((Path)localObject2).quadTo(i * i2 + arrayOfInt2[(j * 2)], i * i2 + arrayOfInt2[(j * 2 + 1)] + i, i * i2 + arrayOfInt2[(j * 2)] - i - i / 4, i * i2 + arrayOfInt2[(j * 2 + 1)] + i + i * 1 / 4);
        ((Path)localObject2).lineTo(i * i2 + arrayOfInt2[(j * 2)] + i + i * 1 / 4, i * i2 + arrayOfInt2[(j * 2 + 1)] + i + i * 1 / 4);
        ((Path)localObject2).close();
        localCanvas.drawPath((Path)localObject2, localPaint);
        ((Path)localObject2).moveTo(i * i2 + arrayOfInt2[(j * 2)] + i + i * 1 / 4, i * i2 + arrayOfInt2[(j * 2 + 1)] + i + i * 1 / 4);
        ((Path)localObject2).quadTo(i * i2 + arrayOfInt2[(j * 2)] + i, i * i2 + arrayOfInt2[(j * 2 + 1)], i * i2 + arrayOfInt2[(j * 2)] + i + i / 4, i * i2 + arrayOfInt2[(j * 2 + 1)] - i - i * 1 / 4);
        ((Path)localObject2).lineTo(i * i2 + arrayOfInt2[(j * 2)] + i + i * 1 / 4, i * i2 + arrayOfInt2[(j * 2 + 1)] + i + i * 1 / 4);
        ((Path)localObject2).close();
        localCanvas.drawPath((Path)localObject2, localPaint);
        j += 1;
      }
      if (localObject1 == null) {
        y.i("MicroMsg.QRCodeBitmapFactory", "createBitmap bm is error result %d %s", new Object[] { Integer.valueOf(i1), bk.csb().toString() });
      }
      for (;;)
      {
        this.mBitmap = ((Bitmap)localObject1);
        this.lNR.setImageBitmap(this.mBitmap);
        if (this.lNB > 0) {
          break label1948;
        }
        this.lNR.setPadding(com.tencent.mm.cb.a.fromDPToPix(this, 5), com.tencent.mm.cb.a.fromDPToPix(this, 5), com.tencent.mm.cb.a.fromDPToPix(this, 5), com.tencent.mm.cb.a.fromDPToPix(this, 5));
        this.lNR.setImageResource(a.e.lucky_money_f2f_empty_qrcode);
        this.lNZ.setVisibility(8);
        this.lMp.setVisibility(0);
        this.lNS.setVisibility(4);
        this.lNM.setPadding(this.lNM.getPaddingLeft(), com.tencent.mm.pluginsdk.e.cD(this), this.lNM.getPaddingRight(), this.lNM.getPaddingBottom());
        if (this.lNV.size() <= 0) {
          break;
        }
        this.lNT.setText(getString(a.i.lucky_money_f2f_no_remain_tips));
        return;
        y.i("MicroMsg.QRCodeBitmapFactory", "createBitmap %s", new Object[] { localObject1 });
        continue;
        y.i("MicroMsg.QRCodeBitmapFactory", "result %d %s", new Object[] { Integer.valueOf(i1), bk.csb().toString() });
        localObject1 = null;
      }
      this.lNT.setText(getString(a.i.lucky_money_f2f_not_prepare_tips));
      return;
      this.lNR.setPadding(0, 0, 0, 0);
      this.lNS.setText(getString(a.i.lucky_money_f2f_scan_qrcode_tips));
      this.lNS.setVisibility(0);
      this.lNT.setText(getString(a.i.lucky_money_f2f_scan_qrcode_tips));
      this.lNZ.setText(getString(a.i.lucky_money_f2f_remain_tip, new Object[] { Integer.valueOf(this.lNB) }));
      this.lNZ.setVisibility(0);
      this.lMp.setVisibility(8);
      return;
    }
  }
  
  private void bfy()
  {
    HashSet localHashSet = new HashSet();
    localHashSet.add("touch_card.m4a");
    localHashSet.add("select_card.m4a");
    int i = 1;
    while (i <= 8)
    {
      localHashSet.add("music" + i + ".m4a");
      i += 1;
    }
    localHashSet.add("packet_received.m4a");
    localHashSet.add("most_lucky.m4a");
    localHashSet.add("whistle.m4a");
    com.tencent.mm.plugin.luckymoney.f2f.a locala = this.lOg;
    WeakReference localWeakReference = new WeakReference(this);
    g.DS().O(new a.1(locala, localHashSet, localWeakReference));
    locala.lNa.setOnLoadCompleteListener(new a.2(locala));
  }
  
  private void bfz()
  {
    int i = this.lNU.getWidth() - this.lNV.size() * getResources().getDimensionPixelSize(a.d.BigAvatarSize);
    if (i > 0)
    {
      this.lNU.setPadding(i / 2, 0, i / 2, 0);
      return;
    }
    this.lNU.setPadding(0, 0, 0, 0);
  }
  
  public final void aqt()
  {
    y.i("LuckyMoneyF2FQRCodeUI", "screenShot");
    if (this.lNB > 0)
    {
      Object localObject = this.jxR;
      y.i("LuckyMoneyF2FQRCodeUI", "invalidQRCode");
      b(new com.tencent.mm.plugin.luckymoney.f2f.a.b((String)localObject), false);
      y.i("LuckyMoneyF2FQRCodeUI", "getQRCode");
      b(new com.tencent.mm.plugin.luckymoney.f2f.a.e(), false);
      bfx();
      localObject = this.fmY;
      localObject[1] += 1;
      com.tencent.mm.ui.base.h.b(this, getString(a.i.lucky_money_f2f_screen_shot_tips), null, true);
    }
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    int i = 0;
    y.i("LuckyMoneyF2FQRCodeUI", "errType: %d,errCode: %d,errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramm instanceof com.tencent.mm.plugin.luckymoney.f2f.a.e))
      {
        y.d("LuckyMoneyF2FQRCodeUI", "sendId:" + this.lMg);
        if ((!bk.H(new String[] { this.lMg, ((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramm).lMg })) && (!this.lMg.equals(((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramm).lMg)))
        {
          this.lNV.clear();
          this.lNW.clear();
          this.lNX.clear();
          this.lNY.notifyDataSetChanged();
          this.lOi = "";
        }
        if (!bk.bl(((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramm).lMg)) {
          this.lMg = ((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramm).lMg;
        }
        this.jxR = ((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramm).jxR;
        this.lNB = ((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramm).lNB;
        this.lNA = ((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramm).lNA;
        bfx();
        bfA();
        if (this.lNB == 0) {
          this.fqP.stopTimer();
        }
        if ((this.lNV.size() == 0) && (!bk.bl(this.lMg))) {
          b(new w(this.lMg, 5, 0, null, "v1.0"), false);
        }
      }
    }
    while (bk.bl(paramString))
    {
      do
      {
        do
        {
          do
          {
            return true;
            if (!(paramm instanceof com.tencent.mm.plugin.luckymoney.f2f.a.a)) {
              break;
            }
            this.lMg = "";
            this.jxR = "";
            this.lNB = 0;
            this.lNV.clear();
            this.lOi = "";
            this.lNY.notifyDataSetChanged();
            bfx();
            bfA();
            this.fqP.stopTimer();
          } while (bk.bl(this.lNA));
          com.tencent.mm.ui.base.h.bC(this, this.lNA);
          return true;
          if (!(paramm instanceof w)) {
            break;
          }
          this.lOh = ((w)paramm).lQZ.lPY;
          paramString = ((w)paramm).lQZ.lQn;
        } while ((paramString == null) || (paramString.size() <= 0));
        paramInt1 = i;
        while (paramInt1 < paramString.size())
        {
          paramm = (n)paramString.get(paramInt1);
          if ((!bk.bl(paramm.lQb)) && (!this.lNV.contains(paramm.lQb)))
          {
            this.lNV.add(paramm.lQb);
            String str = o.Kj().ke(paramm.lQM);
            if (!bk.bl(paramm.lQO)) {
              this.lOi = str;
            }
            this.lNW.put(paramm.lQb, str);
          }
          paramInt1 += 1;
        }
        bfz();
        this.lNY.notifyDataSetChanged();
        return true;
      } while (!(paramm instanceof com.tencent.mm.plugin.luckymoney.f2f.a.b));
      y.i("LuckyMoneyF2FQRCodeUI", "onSceneEnd NetSceneF2FLuckyMoneyInvalid");
      this.retCode = ((com.tencent.mm.plugin.luckymoney.f2f.a.b)paramm).iHq;
      this.gfH = ((com.tencent.mm.plugin.luckymoney.f2f.a.b)paramm).iHr;
      y.i("LuckyMoneyF2FQRCodeUI", "retcode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      return true;
    }
    com.tencent.mm.ui.base.h.b(this, paramString, getString(a.i.app_tip), true);
    return true;
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return a.g.lucky_money_f2f_qrcode_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.eRM = getResources().getDisplayMetrics();
    this.lNV = new ArrayList();
    this.lNW = new HashMap();
    this.lNX = new LinkedList();
    this.lOc = new ArrayList();
    this.fmY = new int[6];
    paramBundle = this.fmY;
    paramBundle[0] += 1;
    this.fqP = new am(new am.a()
    {
      public final boolean tC()
      {
        com.tencent.mm.plugin.luckymoney.f2f.a.e locale = new com.tencent.mm.plugin.luckymoney.f2f.a.e();
        LuckyMoneyF2FQRCodeUI.this.b(locale, false);
        return true;
      }
    }, true);
    this.VH = findViewById(a.f.lucky_money_f2f_recv_header);
    this.lNM = findViewById(a.f.white_block);
    this.lNT = ((TextView)findViewById(a.f.lucky_money_f2f_qrcode_bottom_tip));
    this.lNS = ((TextView)findViewById(a.f.lucky_money_f2f_qrcode_top_tip));
    this.lOm = this.lNT.getAlpha();
    this.lNR = ((ImageView)this.VH.findViewById(a.f.lucky_money_f2f_qrcode));
    this.lNU = ((HorizontalListViewV2)findViewById(a.f.lucky_money_f2f_recv_avatar_list));
    this.lNY = new LuckyMoneyF2FQRCodeUI.a(this, (byte)0);
    this.lNU.setAdapter(this.lNY);
    this.lNU.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        paramAnonymousAdapterView = new Intent(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyDetailUI.class);
        paramAnonymousAdapterView.putExtra("key_sendid", LuckyMoneyF2FQRCodeUI.u(LuckyMoneyF2FQRCodeUI.this));
        LuckyMoneyF2FQRCodeUI.this.startActivity(paramAnonymousAdapterView);
      }
    });
    this.lNU.setOnScrollStateChangedListener(new LuckyMoneyF2FQRCodeUI.14(this));
    this.lMp = ((Button)findViewById(a.f.lucky_money_f2f_prepare_btn));
    this.lMp.setOnClickListener(new LuckyMoneyF2FQRCodeUI.15(this));
    this.lNZ = ((TextView)findViewById(a.f.lucky_money_f2f_remain_text));
    this.lNN = findViewById(a.f.lucky_money_f2f_recv_packet);
    setBackBtn(new LuckyMoneyF2FQRCodeUI.2(this));
    setMMTitle(getString(a.i.lucky_money_f2f_title));
    addIconOptionMenu(0, a.h.actionbar_icon_dark_more, new LuckyMoneyF2FQRCodeUI.3(this));
    ta(getResources().getColor(a.c.lucky_money_goldstyle_actionbar_bg_color));
    czo();
    this.lOd = ((ViewGroup)findViewById(a.f.lucky_money_f2f_firework_layer_top));
    this.lOe = ((ViewGroup)findViewById(a.f.lucky_money_f2f_firework_layer_bottom));
    this.lOf = findViewById(a.f.lucky_money_f2f_layer_mask);
    this.lOf.setAlpha(0.0F);
    this.aVT = ((SensorManager)getSystemService("sensor"));
    this.aVT.registerListener(this.lOD, this.aVT.getDefaultSensor(1), 3);
    this.lOg = new com.tencent.mm.plugin.luckymoney.f2f.a();
    this.lOa = ((ShuffleView)findViewById(a.f.lucky_money_f2f_shuffle_view));
    this.lOb = new ShuffleView.c();
    this.lOb.lPB = 4;
    this.lOb.lPz = 2;
    this.lOb.lPA = 4;
    this.lOb.lPC = 300;
    this.lOb.scaleY = 0.0F;
    this.lOa.setShuffleSetting(this.lOb);
    ShuffleView.eRM = this.eRM;
    paramBundle = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(300L);
    this.lOa.setExitAnimator(paramBundle);
    this.lOa.setExitAnimatorListener(new LuckyMoneyF2FQRCodeUI.4(this));
    this.lOa.setCardListener(new LuckyMoneyF2FQRCodeUI.5(this));
    bfy();
    this.lOj = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.lOj.setDuration(300L);
    this.lOj.setStartDelay(3000L);
    this.lOj.addUpdateListener(new LuckyMoneyF2FQRCodeUI.6(this));
    bfx();
    getWindow().addFlags(128);
  }
  
  protected void onDestroy()
  {
    com.tencent.mm.plugin.report.service.h.nFQ.f(14007, new Object[] { Integer.valueOf(this.fmY[0]), Integer.valueOf(this.fmY[1]), Integer.valueOf(this.fmY[2]), Integer.valueOf(this.fmY[3]), Integer.valueOf(this.fmY[4]), Integer.valueOf(this.fmY[5]) });
    com.tencent.mm.plugin.luckymoney.f2f.a locala = this.lOg;
    locala.hMo = true;
    locala.lNa.release();
    getWindow().clearFlags(128);
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.aVT != null) {
      this.aVT.unregisterListener(this.lOD);
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    b(new com.tencent.mm.plugin.luckymoney.f2f.a.e(), true);
    this.fqP.S(60000L, 60000L);
    ((p)g.t(p.class)).getSysCmdMsgExtension().a("ffopenwxhb", this.lOn, true);
    kh(1642);
    kh(1990);
    kh(1987);
    kh(1971);
    WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
    if (localLayoutParams.screenBrightness < 0.85F)
    {
      localLayoutParams.screenBrightness = 0.85F;
      getWindow().setAttributes(localLayoutParams);
    }
    ay.a(this, this);
    if (this.aVT != null) {
      this.aVT.registerListener(this.lOD, this.aVT.getDefaultSensor(1), 3);
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    this.fqP.stopTimer();
    ((p)g.t(p.class)).getSysCmdMsgExtension().b("ffopenwxhb", this.lOn, true);
    ki(1990);
    ki(1642);
    ki(1987);
    ki(1971);
    ay.a(this, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI
 * JD-Core Version:    0.7.0.1
 */