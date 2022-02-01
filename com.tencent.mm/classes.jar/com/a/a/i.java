package com.a.a;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Path.Op;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Stack;

final class i
{
  private static HashSet<String> aTw = null;
  private h aSW;
  private Canvas aTq;
  float aTr;
  g aTs;
  private Stack<g> aTt;
  private Stack<h.aj> aTu;
  private Stack<Matrix> aTv;
  private b.p aTx = null;
  
  i(Canvas paramCanvas, float paramFloat)
  {
    this.aTq = paramCanvas;
    this.aTr = paramFloat;
  }
  
  private static int T(float paramFloat)
  {
    int i = 255;
    int j = (int)(256.0F * paramFloat);
    if (j < 0) {
      i = 0;
    }
    while (j > 255) {
      return i;
    }
    return j;
  }
  
  private float a(h.ay paramay)
  {
    AppMethodBeat.i(213107);
    j localj = new j((byte)0);
    a(paramay, localj);
    float f = localj.x;
    AppMethodBeat.o(213107);
    return f;
  }
  
  private static Matrix a(h.b paramb1, h.b paramb2, f paramf)
  {
    AppMethodBeat.i(213113);
    Matrix localMatrix = new Matrix();
    if ((paramf == null) || (paramf.aPG == null))
    {
      AppMethodBeat.o(213113);
      return localMatrix;
    }
    float f2 = paramb1.width / paramb2.width;
    float f3 = paramb1.height / paramb2.height;
    float f1 = -paramb2.minX;
    float f4 = -paramb2.minY;
    if (paramf.equals(f.aPJ))
    {
      localMatrix.preTranslate(paramb1.minX, paramb1.minY);
      localMatrix.preScale(f2, f3);
      localMatrix.preTranslate(f1, f4);
      AppMethodBeat.o(213113);
      return localMatrix;
    }
    float f5;
    if (paramf.aPH == f.b.aQd)
    {
      f3 = Math.max(f2, f3);
      f2 = paramb1.width / f3;
      f5 = paramb1.height / f3;
      switch (1.aTy[paramf.aPG.ordinal()])
      {
      default: 
        label204:
        f2 = f4;
        switch (1.aTy[paramf.aPG.ordinal()])
        {
        default: 
          f2 = f4;
        }
        break;
      }
    }
    for (;;)
    {
      localMatrix.preTranslate(paramb1.minX, paramb1.minY);
      localMatrix.preScale(f3, f3);
      localMatrix.preTranslate(f1, f2);
      AppMethodBeat.o(213113);
      return localMatrix;
      f3 = Math.min(f2, f3);
      break;
      f1 -= (paramb2.width - f2) / 2.0F;
      break label204;
      f1 -= paramb2.width - f2;
      break label204;
      f2 = f4 - (paramb2.height - f5) / 2.0F;
      continue;
      f2 = f4 - (paramb2.height - f5);
    }
  }
  
  private Path a(h.ab paramab)
  {
    AppMethodBeat.i(213142);
    float f1;
    float f2;
    float f3;
    float f4;
    label71:
    label87:
    float f5;
    float f6;
    if ((paramab.aQF == null) && (paramab.aQG == null))
    {
      f1 = 0.0F;
      f2 = 0.0F;
      f3 = Math.min(f2, paramab.aQR.a(this) / 2.0F);
      f4 = Math.min(f1, paramab.aQS.b(this) / 2.0F);
      if (paramab.aQP == null) {
        break label273;
      }
      f1 = paramab.aQP.a(this);
      if (paramab.aQQ == null) {
        break label278;
      }
      f2 = paramab.aQQ.b(this);
      f5 = paramab.aQR.a(this);
      f6 = paramab.aQS.b(this);
      if (paramab.aSS == null) {
        paramab.aSS = new h.b(f1, f2, f5, f6);
      }
      f5 = f1 + f5;
      f6 = f2 + f6;
      paramab = new Path();
      if ((f3 != 0.0F) && (f4 != 0.0F)) {
        break label283;
      }
      paramab.moveTo(f1, f2);
      paramab.lineTo(f5, f2);
      paramab.lineTo(f5, f6);
      paramab.lineTo(f1, f6);
      paramab.lineTo(f1, f2);
    }
    for (;;)
    {
      paramab.close();
      AppMethodBeat.o(213142);
      return paramab;
      if (paramab.aQF == null)
      {
        f2 = paramab.aQG.b(this);
        f1 = f2;
        break;
      }
      if (paramab.aQG == null)
      {
        f2 = paramab.aQF.a(this);
        f1 = f2;
        break;
      }
      f2 = paramab.aQF.a(this);
      f1 = paramab.aQG.b(this);
      break;
      label273:
      f1 = 0.0F;
      break label71;
      label278:
      f2 = 0.0F;
      break label87;
      label283:
      float f7 = f3 * 0.5522848F;
      float f8 = f4 * 0.5522848F;
      paramab.moveTo(f1, f2 + f4);
      paramab.cubicTo(f1, f2 + f4 - f8, f1 + f3 - f7, f2, f1 + f3, f2);
      paramab.lineTo(f5 - f3, f2);
      paramab.cubicTo(f5 - f3 + f7, f2, f5, f2 + f4 - f8, f5, f2 + f4);
      paramab.lineTo(f5, f6 - f4);
      paramab.cubicTo(f5, f6 - f4 + f8, f5 - f3 + f7, f6, f5 - f3, f6);
      paramab.lineTo(f1 + f3, f6);
      paramab.cubicTo(f1 + f3 - f7, f6, f1, f6 - f4 + f8, f1, f6 - f4);
      paramab.lineTo(f1, f2 + f4);
    }
  }
  
  @TargetApi(19)
  private Path a(h.ak paramak, boolean paramBoolean)
  {
    AppMethodBeat.i(213133);
    this.aTt.push(this.aTs);
    this.aTs = new g(this.aTs);
    a(this.aTs, paramak);
    if ((!ri()) || (!visible()))
    {
      this.aTs = ((g)this.aTt.pop());
      AppMethodBeat.o(213133);
      return null;
    }
    Object localObject3;
    Object localObject1;
    Object localObject2;
    if ((paramak instanceof h.be))
    {
      if (!paramBoolean) {
        String.format("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
      }
      localObject3 = (h.be)paramak;
      localObject1 = paramak.aSW.Y(((h.be)localObject3).aQs);
      if (localObject1 == null)
      {
        String.format("Use reference '%s' not found", new Object[] { ((h.be)localObject3).aQs });
        this.aTs = ((g)this.aTt.pop());
        AppMethodBeat.o(213133);
        return null;
      }
      if (!(localObject1 instanceof h.ak))
      {
        this.aTs = ((g)this.aTt.pop());
        AppMethodBeat.o(213133);
        return null;
      }
      localObject2 = a((h.ak)localObject1, false);
      if (localObject2 == null)
      {
        AppMethodBeat.o(213133);
        return null;
      }
      if (((h.be)localObject3).aSS == null) {
        ((h.be)localObject3).aSS = e((Path)localObject2);
      }
      localObject1 = localObject2;
      if (((h.be)localObject3).transform != null)
      {
        ((Path)localObject2).transform(((h.be)localObject3).transform);
        localObject1 = localObject2;
      }
      if (this.aTs.aPr.aRV != null)
      {
        paramak = c(paramak, paramak.aSS);
        if (paramak != null) {
          ((Path)localObject1).op(paramak, Path.Op.INTERSECT);
        }
      }
      this.aTs = ((g)this.aTt.pop());
      AppMethodBeat.o(213133);
      return localObject1;
    }
    if ((paramak instanceof h.l))
    {
      localObject3 = (h.l)paramak;
      if ((paramak instanceof h.v))
      {
        localObject2 = new c(((h.v)paramak).aRh).lP;
        localObject1 = localObject2;
        if (paramak.aSS == null)
        {
          paramak.aSS = e((Path)localObject2);
          localObject1 = localObject2;
        }
      }
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        AppMethodBeat.o(213133);
        return null;
        if ((paramak instanceof h.ab))
        {
          localObject1 = a((h.ab)paramak);
          continue;
        }
        if ((paramak instanceof h.d))
        {
          localObject1 = a((h.d)paramak);
          continue;
        }
        if ((paramak instanceof h.i))
        {
          localObject1 = a((h.i)paramak);
          continue;
        }
        if ((paramak instanceof h.z)) {
          localObject1 = b((h.z)paramak);
        }
      }
      else
      {
        if (((h.l)localObject3).aSS == null) {
          ((h.l)localObject3).aSS = e((Path)localObject1);
        }
        if (((h.l)localObject3).transform != null) {
          ((Path)localObject1).transform(((h.l)localObject3).transform);
        }
        ((Path)localObject1).setFillType(rn());
        break;
        if ((paramak instanceof h.aw))
        {
          localObject2 = (h.aw)paramak;
          localObject1 = a((h.aw)localObject2);
          if (((h.aw)localObject2).transform != null) {
            ((Path)localObject1).transform(((h.aw)localObject2).transform);
          }
          ((Path)localObject1).setFillType(rn());
          break;
        }
        String.format("Invalid %s element found in clipPath definition", new Object[] { paramak.getNodeName() });
        AppMethodBeat.o(213133);
        return null;
      }
      localObject1 = null;
    }
  }
  
  private Path a(h.aw paramaw)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(213146);
    float f1;
    float f3;
    label51:
    float f4;
    label73:
    float f5;
    if ((paramaw.aTc == null) || (paramaw.aTc.size() == 0))
    {
      f1 = 0.0F;
      if ((paramaw.aTd != null) && (paramaw.aTd.size() != 0)) {
        break label277;
      }
      f3 = 0.0F;
      if ((paramaw.aTe != null) && (paramaw.aTe.size() != 0)) {
        break label299;
      }
      f4 = 0.0F;
      f5 = f2;
      if (paramaw.aTf != null)
      {
        if (paramaw.aTf.size() != 0) {
          break label321;
        }
        f5 = f2;
      }
      label98:
      f2 = f1;
      if (this.aTs.aPr.aRL != h.ae.f.aSx)
      {
        f2 = a(paramaw);
        if (this.aTs.aPr.aRL != h.ae.f.aSy) {
          break label343;
        }
      }
    }
    label277:
    label299:
    label321:
    label343:
    for (f2 = f1 - f2 / 2.0F;; f2 = f1 - f2)
    {
      if (paramaw.aSS == null)
      {
        localObject = new h(f2, f3);
        a(paramaw, (i)localObject);
        paramaw.aSS = new h.b(((h)localObject).aTT.left, ((h)localObject).aTT.top, ((h)localObject).aTT.width(), ((h)localObject).aTT.height());
      }
      Object localObject = new Path();
      a(paramaw, new f(f2 + f4, f5 + f3, (Path)localObject));
      AppMethodBeat.o(213146);
      return localObject;
      f1 = ((h.p)paramaw.aTc.get(0)).a(this);
      break;
      f3 = ((h.p)paramaw.aTd.get(0)).b(this);
      break label51;
      f4 = ((h.p)paramaw.aTe.get(0)).a(this);
      break label73;
      f5 = ((h.p)paramaw.aTf.get(0)).b(this);
      break label98;
    }
  }
  
  private Path a(h.d paramd)
  {
    AppMethodBeat.i(213143);
    float f1;
    if (paramd.aQx != null)
    {
      f1 = paramd.aQx.a(this);
      if (paramd.aQy == null) {
        break label217;
      }
    }
    label217:
    for (float f2 = paramd.aQy.b(this);; f2 = 0.0F)
    {
      float f7 = paramd.aQz.c(this);
      float f3 = f1 - f7;
      float f4 = f2 - f7;
      float f5 = f1 + f7;
      float f6 = f2 + f7;
      if (paramd.aSS == null) {
        paramd.aSS = new h.b(f3, f4, 2.0F * f7, 2.0F * f7);
      }
      f7 *= 0.5522848F;
      paramd = new Path();
      paramd.moveTo(f1, f4);
      paramd.cubicTo(f1 + f7, f4, f5, f2 - f7, f5, f2);
      paramd.cubicTo(f5, f2 + f7, f1 + f7, f6, f1, f6);
      paramd.cubicTo(f1 - f7, f6, f3, f2 + f7, f3, f2);
      paramd.cubicTo(f3, f2 - f7, f1 - f7, f4, f1, f4);
      paramd.close();
      AppMethodBeat.o(213143);
      return paramd;
      f1 = 0.0F;
      break;
    }
  }
  
  private Path a(h.i parami)
  {
    AppMethodBeat.i(213144);
    float f1;
    if (parami.aQx != null)
    {
      f1 = parami.aQx.a(this);
      if (parami.aQy == null) {
        break label234;
      }
    }
    label234:
    for (float f2 = parami.aQy.b(this);; f2 = 0.0F)
    {
      float f8 = parami.aQF.a(this);
      float f7 = parami.aQG.b(this);
      float f3 = f1 - f8;
      float f4 = f2 - f7;
      float f5 = f1 + f8;
      float f6 = f2 + f7;
      if (parami.aSS == null) {
        parami.aSS = new h.b(f3, f4, 2.0F * f8, 2.0F * f7);
      }
      f8 *= 0.5522848F;
      f7 *= 0.5522848F;
      parami = new Path();
      parami.moveTo(f1, f4);
      parami.cubicTo(f1 + f8, f4, f5, f2 - f7, f5, f2);
      parami.cubicTo(f5, f2 + f7, f1 + f8, f6, f1, f6);
      parami.cubicTo(f1 - f8, f6, f3, f2 + f7, f3, f2);
      parami.cubicTo(f3, f2 - f7, f1 - f8, f4, f1, f4);
      parami.close();
      AppMethodBeat.o(213144);
      return parami;
      f1 = 0.0F;
      break;
    }
  }
  
  private static Typeface a(String paramString, Integer paramInteger, h.ae.b paramb)
  {
    int k = 0;
    AppMethodBeat.i(213116);
    int i;
    int j;
    if (paramb == h.ae.b.aSi)
    {
      i = 1;
      if (paramInteger.intValue() <= 500) {
        break label145;
      }
      if (i == 0) {
        break label139;
      }
      j = 3;
      label35:
      switch (paramString.hashCode())
      {
      default: 
        label88:
        i = -1;
        switch (i)
        {
        default: 
          label90:
          paramString = null;
        }
        break;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(213116);
      return paramString;
      i = 0;
      break;
      label139:
      j = 1;
      break label35;
      label145:
      if (i != 0)
      {
        j = 2;
        break label35;
      }
      j = 0;
      break label35;
      if (!paramString.equals("serif")) {
        break label88;
      }
      i = k;
      break label90;
      if (!paramString.equals("sans-serif")) {
        break label88;
      }
      i = 1;
      break label90;
      if (!paramString.equals("monospace")) {
        break label88;
      }
      i = 2;
      break label90;
      if (!paramString.equals("cursive")) {
        break label88;
      }
      i = 3;
      break label90;
      if (!paramString.equals("fantasy")) {
        break label88;
      }
      i = 4;
      break label90;
      paramString = Typeface.create(Typeface.SERIF, j);
      continue;
      paramString = Typeface.create(Typeface.SANS_SERIF, j);
      continue;
      paramString = Typeface.create(Typeface.MONOSPACE, j);
      continue;
      paramString = Typeface.create(Typeface.SANS_SERIF, j);
      continue;
      paramString = Typeface.create(Typeface.SANS_SERIF, j);
    }
  }
  
  private h.b a(h.p paramp1, h.p paramp2, h.p paramp3, h.p paramp4)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(213097);
    float f1;
    float f3;
    if (paramp1 != null)
    {
      f1 = paramp1.a(this);
      if (paramp2 != null) {
        f2 = paramp2.b(this);
      }
      paramp1 = ra();
      if (paramp3 == null) {
        break label90;
      }
      f3 = paramp3.a(this);
      label47:
      if (paramp4 == null) {
        break label99;
      }
    }
    label90:
    label99:
    for (float f4 = paramp4.b(this);; f4 = paramp1.height)
    {
      paramp1 = new h.b(f1, f2, f3, f4);
      AppMethodBeat.o(213097);
      return paramp1;
      f1 = 0.0F;
      break;
      f3 = paramp1.width;
      break label47;
    }
  }
  
  private g a(h.an paraman, g paramg)
  {
    AppMethodBeat.i(213123);
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      if ((paraman instanceof h.al)) {
        localArrayList.add(0, (h.al)paraman);
      }
      if (paraman.aSX == null) {
        break;
      }
      paraman = (h.an)paraman.aSX;
    }
    paraman = localArrayList.iterator();
    while (paraman.hasNext()) {
      a(paramg, (h.al)paraman.next());
    }
    paramg.aQi = this.aTs.aQi;
    paramg.aQk = this.aTs.aQk;
    AppMethodBeat.o(213123);
    return paramg;
  }
  
  private String a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(213109);
    if (this.aTs.aTS)
    {
      paramString = paramString.replaceAll("[\\n\\t]", " ");
      AppMethodBeat.o(213109);
      return paramString;
    }
    String str = paramString.replaceAll("\\n", "").replaceAll("\\t", " ");
    paramString = str;
    if (paramBoolean1) {
      paramString = str.replaceAll("^\\s+", "");
    }
    str = paramString;
    if (paramBoolean2) {
      str = paramString.replaceAll("\\s+$", "");
    }
    paramString = str.replaceAll("\\s{2,}", " ");
    AppMethodBeat.o(213109);
    return paramString;
  }
  
  private List<b> a(h.z paramz)
  {
    int i = 2;
    AppMethodBeat.i(213105);
    int j = paramz.points.length;
    if (j < 2)
    {
      AppMethodBeat.o(213105);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    b localb = new b(paramz.points[0], paramz.points[1], 0.0F, 0.0F);
    float f2 = 0.0F;
    float f1 = 0.0F;
    while (i < j)
    {
      f1 = paramz.points[i];
      f2 = paramz.points[(i + 1)];
      localb.q(f1, f2);
      localArrayList.add(localb);
      localb = new b(f1, f2, f1 - localb.x, f2 - localb.y);
      i += 2;
    }
    if ((paramz instanceof h.aa)) {
      if ((f1 != paramz.points[0]) && (f2 != paramz.points[1]))
      {
        f1 = paramz.points[0];
        f2 = paramz.points[1];
        localb.q(f1, f2);
        localArrayList.add(localb);
        paramz = new b(f1, f2, f1 - localb.x, f2 - localb.y);
        paramz.a((b)localArrayList.get(0));
        localArrayList.add(paramz);
        localArrayList.set(0, paramz);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(213105);
      return localArrayList;
      localArrayList.add(localb);
    }
  }
  
  private void a(h.af paramaf, h.b paramb1, h.b paramb2, f paramf)
  {
    AppMethodBeat.i(213096);
    if ((paramb1.width == 0.0F) || (paramb1.height == 0.0F))
    {
      AppMethodBeat.o(213096);
      return;
    }
    if (paramf == null) {
      if (paramaf.aQg != null) {
        paramf = paramaf.aQg;
      }
    }
    for (;;)
    {
      a(this.aTs, paramaf);
      if (!ri())
      {
        AppMethodBeat.o(213096);
        return;
        paramf = f.aPK;
      }
      else
      {
        this.aTs.aQk = paramb1;
        if (!this.aTs.aPr.aRM.booleanValue()) {
          j(this.aTs.aQk.minX, this.aTs.aQk.minY, this.aTs.aQk.width, this.aTs.aQk.height);
        }
        b(paramaf, this.aTs.aQk);
        if (paramb2 != null)
        {
          this.aTq.concat(a(this.aTs.aQk, paramb2, paramf));
          this.aTs.aQi = paramaf.aQi;
        }
        for (;;)
        {
          boolean bool = re();
          rk();
          a(paramaf, true);
          if (bool) {
            b(paramaf);
          }
          a(paramaf);
          AppMethodBeat.o(213096);
          return;
          this.aTq.translate(this.aTs.aQk.minX, this.aTs.aQk.minY);
        }
      }
    }
  }
  
  private void a(h.aj paramaj)
  {
    AppMethodBeat.i(213090);
    this.aTu.push(paramaj);
    this.aTv.push(this.aTq.getMatrix());
    AppMethodBeat.o(213090);
  }
  
  private void a(h.aj paramaj, boolean paramBoolean)
  {
    AppMethodBeat.i(213087);
    if (paramBoolean) {
      a(paramaj);
    }
    paramaj = paramaj.getChildren().iterator();
    while (paramaj.hasNext()) {
      b((h.an)paramaj.next());
    }
    if (paramBoolean) {
      rd();
    }
    AppMethodBeat.o(213087);
  }
  
  private void a(h.ak paramak)
  {
    AppMethodBeat.i(213098);
    if (paramak.aSX == null)
    {
      AppMethodBeat.o(213098);
      return;
    }
    if (paramak.aSS == null)
    {
      AppMethodBeat.o(213098);
      return;
    }
    Matrix localMatrix = new Matrix();
    if (((Matrix)this.aTv.peek()).invert(localMatrix))
    {
      Object localObject = new float[8];
      localObject[0] = paramak.aSS.minX;
      localObject[1] = paramak.aSS.minY;
      localObject[2] = paramak.aSS.qO();
      localObject[3] = paramak.aSS.minY;
      localObject[4] = paramak.aSS.qO();
      localObject[5] = paramak.aSS.qP();
      localObject[6] = paramak.aSS.minX;
      localObject[7] = paramak.aSS.qP();
      localMatrix.preConcat(this.aTq.getMatrix());
      localMatrix.mapPoints((float[])localObject);
      paramak = new RectF(localObject[0], localObject[1], localObject[0], localObject[1]);
      int i = 2;
      while (i <= 6)
      {
        if (localObject[i] < paramak.left) {
          paramak.left = localObject[i];
        }
        if (localObject[i] > paramak.right) {
          paramak.right = localObject[i];
        }
        if (localObject[(i + 1)] < paramak.top) {
          paramak.top = localObject[(i + 1)];
        }
        if (localObject[(i + 1)] > paramak.bottom) {
          paramak.bottom = localObject[(i + 1)];
        }
        i += 2;
      }
      localObject = (h.ak)this.aTu.peek();
      if (((h.ak)localObject).aSS == null)
      {
        ((h.ak)localObject).aSS = h.b.i(paramak.left, paramak.top, paramak.right, paramak.bottom);
        AppMethodBeat.o(213098);
        return;
      }
      ((h.ak)localObject).aSS.a(h.b.i(paramak.left, paramak.top, paramak.right, paramak.bottom));
    }
    AppMethodBeat.o(213098);
  }
  
  private void a(h.ak paramak, Path paramPath)
  {
    AppMethodBeat.i(213094);
    if ((this.aTs.aPr.aRs instanceof h.u))
    {
      h.an localan = this.aSW.Y(((h.u)this.aTs.aPr.aRs).aQs);
      if ((localan instanceof h.y))
      {
        a(paramak, paramPath, (h.y)localan);
        AppMethodBeat.o(213094);
        return;
      }
    }
    this.aTq.drawPath(paramPath, this.aTs.aTQ);
    AppMethodBeat.o(213094);
  }
  
  private void a(h.ak paramak, Path paramPath, h.y paramy)
  {
    AppMethodBeat.i(213147);
    int i;
    float f1;
    label63:
    float f2;
    label80:
    float f3;
    if ((paramy.aRn != null) && (paramy.aRn.booleanValue()))
    {
      i = 1;
      if (paramy.aQs != null) {
        a(paramy, paramy.aQs);
      }
      if (i == 0) {
        break label189;
      }
      if (paramy.aQP == null) {
        break label165;
      }
      f1 = paramy.aQP.a(this);
      if (paramy.aQQ == null) {
        break label171;
      }
      f2 = paramy.aQQ.b(this);
      if (paramy.aQR == null) {
        break label177;
      }
      f3 = paramy.aQR.a(this);
      label97:
      if (paramy.aQS == null) {
        break label183;
      }
    }
    label165:
    label171:
    label177:
    label183:
    for (float f4 = paramy.aQS.b(this);; f4 = 0.0F)
    {
      f6 = f3;
      f5 = f2;
      f3 = f1;
      f2 = f6;
      f1 = f4;
      f4 = f5;
      if ((f2 != 0.0F) && (f1 != 0.0F)) {
        break label384;
      }
      AppMethodBeat.o(213147);
      return;
      i = 0;
      break;
      f1 = 0.0F;
      break label63;
      f2 = 0.0F;
      break label80;
      f3 = 0.0F;
      break label97;
    }
    label189:
    if (paramy.aQP != null)
    {
      f1 = paramy.aQP.a(this, 1.0F);
      label207:
      if (paramy.aQQ == null) {
        break label366;
      }
      f2 = paramy.aQQ.a(this, 1.0F);
      label225:
      if (paramy.aQR == null) {
        break label372;
      }
      f3 = paramy.aQR.a(this, 1.0F);
      label243:
      if (paramy.aQS == null) {
        break label378;
      }
    }
    label366:
    label372:
    label378:
    for (f4 = paramy.aQS.a(this, 1.0F);; f4 = 0.0F)
    {
      f6 = paramak.aSS.minX;
      f7 = paramak.aSS.width;
      f8 = paramak.aSS.minY;
      float f9 = paramak.aSS.height;
      float f10 = paramak.aSS.width;
      f5 = f4 * paramak.aSS.height;
      f3 *= f10;
      f4 = f2 * f9 + f8;
      f6 = f1 * f7 + f6;
      f1 = f5;
      f2 = f3;
      f3 = f6;
      break;
      f1 = 0.0F;
      break label207;
      f2 = 0.0F;
      break label225;
      f3 = 0.0F;
      break label243;
    }
    label384:
    if (paramy.aQg != null) {}
    Object localObject;
    for (f localf = paramy.aQg;; localf = f.aPK)
    {
      rb();
      this.aTq.clipPath(paramPath);
      paramPath = new g();
      a(paramPath, h.ae.qR());
      paramPath.aPr.aRM = Boolean.FALSE;
      this.aTs = a(paramy, paramPath);
      localObject = paramak.aSS;
      paramPath = (Path)localObject;
      if (paramy.aRp == null) {
        break label775;
      }
      this.aTq.concat(paramy.aRp);
      Matrix localMatrix = new Matrix();
      paramPath = (Path)localObject;
      if (!paramy.aRp.invert(localMatrix)) {
        break label775;
      }
      paramPath = new float[8];
      paramPath[0] = paramak.aSS.minX;
      paramPath[1] = paramak.aSS.minY;
      paramPath[2] = paramak.aSS.qO();
      paramPath[3] = paramak.aSS.minY;
      paramPath[4] = paramak.aSS.qO();
      paramPath[5] = paramak.aSS.qP();
      paramPath[6] = paramak.aSS.minX;
      paramPath[7] = paramak.aSS.qP();
      localMatrix.mapPoints(paramPath);
      localObject = new RectF(paramPath[0], paramPath[1], paramPath[0], paramPath[1]);
      i = 2;
      while (i <= 6)
      {
        if (paramPath[i] < ((RectF)localObject).left) {
          ((RectF)localObject).left = paramPath[i];
        }
        if (paramPath[i] > ((RectF)localObject).right) {
          ((RectF)localObject).right = paramPath[i];
        }
        if (paramPath[(i + 1)] < ((RectF)localObject).top) {
          ((RectF)localObject).top = paramPath[(i + 1)];
        }
        if (paramPath[(i + 1)] > ((RectF)localObject).bottom) {
          ((RectF)localObject).bottom = paramPath[(i + 1)];
        }
        i += 2;
      }
    }
    paramPath = new h.b(((RectF)localObject).left, ((RectF)localObject).top, ((RectF)localObject).right - ((RectF)localObject).left, ((RectF)localObject).bottom - ((RectF)localObject).top);
    label775:
    float f6 = (float)Math.floor((paramPath.minX - f3) / f2);
    float f5 = (float)Math.floor((paramPath.minY - f4) / f1);
    float f7 = paramPath.qO();
    float f8 = paramPath.qP();
    paramPath = new h.b(0.0F, 0.0F, f2, f1);
    boolean bool = re();
    for (f4 = f5 * f1 + f4; f4 < f8; f4 += f1) {
      for (f5 = f3 + f6 * f2; f5 < f7; f5 += f2)
      {
        paramPath.minX = f5;
        paramPath.minY = f4;
        rb();
        if (!this.aTs.aPr.aRM.booleanValue()) {
          j(paramPath.minX, paramPath.minY, paramPath.width, paramPath.height);
        }
        if (paramy.aQi != null)
        {
          this.aTq.concat(a(paramPath, paramy.aQi, localf));
          localObject = paramy.aQH.iterator();
          while (((Iterator)localObject).hasNext()) {
            b((h.an)((Iterator)localObject).next());
          }
        }
        if ((paramy.aRo == null) || (paramy.aRo.booleanValue())) {}
        for (i = 1;; i = 0)
        {
          this.aTq.translate(f5, f4);
          if (i != 0) {
            break;
          }
          this.aTq.scale(paramak.aSS.width, paramak.aSS.height);
          break;
        }
        rc();
      }
    }
    if (bool) {
      b(paramy);
    }
    rc();
    AppMethodBeat.o(213147);
  }
  
  private void a(h.ak paramak, h.b paramb)
  {
    AppMethodBeat.i(213101);
    if (this.aTs.aPr.aRX != null)
    {
      Object localObject = new Paint();
      ((Paint)localObject).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
      this.aTq.saveLayer(null, (Paint)localObject, 31);
      localObject = new Paint();
      ((Paint)localObject).setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2127F, 0.7151F, 0.0722F, 0.0F, 0.0F })));
      this.aTq.saveLayer(null, (Paint)localObject, 31);
      localObject = this.aSW.Y(this.aTs.aPr.aRX);
      a((h.s)localObject, paramak, paramb);
      this.aTq.restore();
      Paint localPaint = new Paint();
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
      this.aTq.saveLayer(null, localPaint, 31);
      a((h.s)localObject, paramak, paramb);
      this.aTq.restore();
      this.aTq.restore();
    }
    rc();
    AppMethodBeat.o(213101);
  }
  
  private static void a(h.am paramam1, h.am paramam2)
  {
    if (paramam1.aQU == null) {
      paramam1.aQU = paramam2.aQU;
    }
    if (paramam1.aQV == null) {
      paramam1.aQV = paramam2.aQV;
    }
    if (paramam1.aQW == null) {
      paramam1.aQW = paramam2.aQW;
    }
    if (paramam1.aQX == null) {
      paramam1.aQX = paramam2.aQX;
    }
  }
  
  private void a(h.an paraman, boolean paramBoolean, Path paramPath, Matrix paramMatrix)
  {
    AppMethodBeat.i(213135);
    if (!ri())
    {
      AppMethodBeat.o(213135);
      return;
    }
    rl();
    if ((paraman instanceof h.be)) {
      if (paramBoolean) {
        a((h.be)paraman, paramPath, paramMatrix);
      }
    }
    for (;;)
    {
      rm();
      AppMethodBeat.o(213135);
      return;
      String.format("<use> elements inside a <clipPath> cannot reference another <use>", new Object[0]);
      continue;
      if ((paraman instanceof h.v)) {
        a((h.v)paraman, paramPath, paramMatrix);
      } else if ((paraman instanceof h.aw)) {
        a((h.aw)paraman, paramPath, paramMatrix);
      } else if ((paraman instanceof h.l)) {
        a((h.l)paraman, paramPath, paramMatrix);
      } else {
        String.format("Invalid %s element found in clipPath definition", new Object[] { paraman.toString() });
      }
    }
  }
  
  private static void a(h.aq paramaq1, h.aq paramaq2)
  {
    if (paramaq1.aQx == null) {
      paramaq1.aQx = paramaq2.aQx;
    }
    if (paramaq1.aQy == null) {
      paramaq1.aQy = paramaq2.aQy;
    }
    if (paramaq1.aQz == null) {
      paramaq1.aQz = paramaq2.aQz;
    }
    if (paramaq1.aSY == null) {
      paramaq1.aSY = paramaq2.aSY;
    }
    if (paramaq1.aSZ == null) {
      paramaq1.aSZ = paramaq2.aSZ;
    }
  }
  
  private void a(h.aw paramaw, Path paramPath, Matrix paramMatrix)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(213141);
    a(this.aTs, paramaw);
    if (!ri())
    {
      AppMethodBeat.o(213141);
      return;
    }
    if (paramaw.transform != null) {
      paramMatrix.preConcat(paramaw.transform);
    }
    float f1;
    float f3;
    label92:
    float f4;
    label114:
    float f5;
    if ((paramaw.aTc == null) || (paramaw.aTc.size() == 0))
    {
      f1 = 0.0F;
      if ((paramaw.aTd != null) && (paramaw.aTd.size() != 0)) {
        break label347;
      }
      f3 = 0.0F;
      if ((paramaw.aTe != null) && (paramaw.aTe.size() != 0)) {
        break label369;
      }
      f4 = 0.0F;
      f5 = f2;
      if (paramaw.aTf != null)
      {
        if (paramaw.aTf.size() != 0) {
          break label391;
        }
        f5 = f2;
      }
      label141:
      f2 = f1;
      if (this.aTs.aPr.aRL != h.ae.f.aSx)
      {
        f2 = a(paramaw);
        if (this.aTs.aPr.aRL != h.ae.f.aSy) {
          break label413;
        }
      }
    }
    label391:
    label413:
    for (f2 = f1 - f2 / 2.0F;; f2 = f1 - f2)
    {
      if (paramaw.aSS == null)
      {
        localObject = new h(f2, f3);
        a(paramaw, (i)localObject);
        paramaw.aSS = new h.b(((h)localObject).aTT.left, ((h)localObject).aTT.top, ((h)localObject).aTT.width(), ((h)localObject).aTT.height());
      }
      d(paramaw);
      Object localObject = new Path();
      a(paramaw, new f(f2 + f4, f5 + f3, (Path)localObject));
      paramPath.setFillType(rn());
      paramPath.addPath((Path)localObject, paramMatrix);
      AppMethodBeat.o(213141);
      return;
      f1 = ((h.p)paramaw.aTc.get(0)).a(this);
      break;
      label347:
      f3 = ((h.p)paramaw.aTd.get(0)).b(this);
      break label92;
      label369:
      f4 = ((h.p)paramaw.aTe.get(0)).a(this);
      break label114;
      f5 = ((h.p)paramaw.aTf.get(0)).b(this);
      break label141;
    }
  }
  
  private void a(h.ay paramay, i parami)
  {
    AppMethodBeat.i(213106);
    if (!ri())
    {
      AppMethodBeat.o(213106);
      return;
    }
    paramay = paramay.aQH.iterator();
    boolean bool1 = true;
    Object localObject2;
    Object localObject1;
    label83:
    float f1;
    label203:
    label210:
    float f2;
    if (paramay.hasNext())
    {
      localObject2 = (h.an)paramay.next();
      boolean bool2;
      if ((localObject2 instanceof h.bc))
      {
        localObject1 = ((h.bc)localObject2).text;
        if (!paramay.hasNext())
        {
          bool2 = true;
          parami.ab(a((String)localObject1, bool1, bool2));
        }
      }
      for (;;)
      {
        bool1 = false;
        break;
        bool2 = false;
        break label83;
        if (parami.b((h.ay)localObject2))
        {
          if (!(localObject2 instanceof h.az)) {
            break label386;
          }
          rb();
          localObject1 = (h.az)localObject2;
          a(this.aTs, (h.al)localObject1);
          if ((ri()) && (visible()))
          {
            localObject2 = ((h.az)localObject1).aSW.Y(((h.az)localObject1).aQs);
            if (localObject2 != null) {
              break label210;
            }
            String.format("TextPath reference '%s' not found", new Object[] { ((h.az)localObject1).aQs });
          }
          rc();
        }
      }
      Object localObject3 = (h.v)localObject2;
      localObject2 = new c(((h.v)localObject3).aRh).lP;
      if (((h.v)localObject3).transform != null) {
        ((Path)localObject2).transform(((h.v)localObject3).transform);
      }
      localObject3 = new PathMeasure((Path)localObject2, false);
      if (((h.az)localObject1).aTb != null)
      {
        f1 = ((h.az)localObject1).aTb.a(this, ((PathMeasure)localObject3).getLength());
        label287:
        localObject3 = rh();
        if (localObject3 == h.ae.f.aSx) {
          break label938;
        }
        f2 = a((h.ay)localObject1);
        if (localObject3 != h.ae.f.aSy) {
          break label378;
        }
        f1 -= f2 / 2.0F;
      }
    }
    label386:
    label528:
    label552:
    label938:
    for (;;)
    {
      c((h.ak)((h.az)localObject1).aTa);
      bool1 = re();
      a((h.ay)localObject1, new d((Path)localObject2, f1));
      if (!bool1) {
        break label203;
      }
      b((h.ak)localObject1);
      break label203;
      f1 = 0.0F;
      break label287;
      label378:
      f1 -= f2;
      continue;
      float f4;
      int i;
      label454:
      label474:
      label504:
      float f5;
      if ((localObject2 instanceof h.av))
      {
        rb();
        localObject1 = (h.av)localObject2;
        a(this.aTs, (h.al)localObject1);
        if (ri())
        {
          f1 = 0.0F;
          f4 = 0.0F;
          f2 = 0.0F;
          if ((((h.av)localObject1).aTc == null) || (((h.av)localObject1).aTc.size() <= 0)) {
            break label679;
          }
          i = 1;
          if (!(parami instanceof e)) {
            break label932;
          }
          if (i != 0) {
            break label685;
          }
          f1 = ((e)parami).x;
          if ((((h.av)localObject1).aTd != null) && (((h.av)localObject1).aTd.size() != 0)) {
            break label707;
          }
          f3 = ((e)parami).y;
          if ((((h.av)localObject1).aTe != null) && (((h.av)localObject1).aTe.size() != 0)) {
            break label730;
          }
          f2 = 0.0F;
          if ((((h.av)localObject1).aTf != null) && (((h.av)localObject1).aTf.size() != 0)) {
            break label753;
          }
          f4 = 0.0F;
          f5 = f4;
          f4 = f3;
        }
      }
      for (float f3 = f5;; f3 = 0.0F)
      {
        if (i != 0)
        {
          localObject2 = rh();
          if (localObject2 != h.ae.f.aSx)
          {
            f5 = a((h.ay)localObject1);
            if (localObject2 == h.ae.f.aSy) {
              f1 -= f5 / 2.0F;
            }
          }
        }
        for (;;)
        {
          c((h.ak)((h.av)localObject1).aTa);
          if ((parami instanceof e))
          {
            ((e)parami).x = (f1 + f2);
            ((e)parami).y = (f4 + f3);
          }
          bool1 = re();
          a((h.ay)localObject1, parami);
          if (bool1) {
            b((h.ak)localObject1);
          }
          rc();
          break;
          i = 0;
          break label454;
          label685:
          f1 = ((h.p)((h.av)localObject1).aTc.get(0)).a(this);
          break label474;
          label707:
          f3 = ((h.p)((h.av)localObject1).aTd.get(0)).b(this);
          break label504;
          label730:
          f2 = ((h.p)((h.av)localObject1).aTe.get(0)).a(this);
          break label528;
          label753:
          f4 = ((h.p)((h.av)localObject1).aTf.get(0)).b(this);
          break label552;
          f1 -= f5;
          continue;
          if (!(localObject2 instanceof h.au)) {
            break;
          }
          rb();
          localObject1 = (h.au)localObject2;
          a(this.aTs, (h.al)localObject1);
          if (!ri()) {
            break label203;
          }
          c((h.ak)((h.au)localObject1).aTa);
          localObject2 = ((h.an)localObject2).aSW.Y(((h.au)localObject1).aQs);
          if ((localObject2 != null) && ((localObject2 instanceof h.ay)))
          {
            localObject1 = new StringBuilder();
            a((h.ay)localObject2, (StringBuilder)localObject1);
            if (((StringBuilder)localObject1).length() <= 0) {
              break label203;
            }
            parami.ab(((StringBuilder)localObject1).toString());
            break label203;
          }
          String.format("Tref reference '%s' not found", new Object[] { ((h.au)localObject1).aQs });
          break label203;
          AppMethodBeat.o(213106);
          return;
        }
      }
    }
  }
  
  private void a(h.ay paramay, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(213108);
    paramay = paramay.aQH.iterator();
    boolean bool1 = true;
    if (paramay.hasNext())
    {
      Object localObject = (h.an)paramay.next();
      if ((localObject instanceof h.ay)) {
        a((h.ay)localObject, paramStringBuilder);
      }
      while (!(localObject instanceof h.bc))
      {
        bool1 = false;
        break;
      }
      localObject = ((h.bc)localObject).text;
      if (!paramay.hasNext()) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        paramStringBuilder.append(a((String)localObject, bool1, bool2));
        break;
      }
    }
    AppMethodBeat.o(213108);
  }
  
  private void a(h.be parambe, Path paramPath, Matrix paramMatrix)
  {
    AppMethodBeat.i(213140);
    a(this.aTs, parambe);
    if (!ri())
    {
      AppMethodBeat.o(213140);
      return;
    }
    if (!visible())
    {
      AppMethodBeat.o(213140);
      return;
    }
    if (parambe.transform != null) {
      paramMatrix.preConcat(parambe.transform);
    }
    h.an localan = parambe.aSW.Y(parambe.aQs);
    if (localan == null)
    {
      String.format("Use reference '%s' not found", new Object[] { parambe.aQs });
      AppMethodBeat.o(213140);
      return;
    }
    d(parambe);
    a(localan, false, paramPath, paramMatrix);
    AppMethodBeat.o(213140);
  }
  
  private static void a(h.j paramj, String paramString)
  {
    AppMethodBeat.i(213128);
    for (;;)
    {
      h.an localan = paramj.aSW.Y(paramString);
      if (localan == null)
      {
        String.format("Gradient reference '%s' not found", new Object[] { paramString });
        AppMethodBeat.o(213128);
        return;
      }
      if (!(localan instanceof h.j))
      {
        String.format("Gradient href attributes must point to other gradient elements", new Object[0]);
        AppMethodBeat.o(213128);
        return;
      }
      if (localan == paramj)
      {
        String.format("Circular reference in gradient href attribute '%s'", new Object[] { paramString });
        AppMethodBeat.o(213128);
        return;
      }
      paramString = (h.j)localan;
      if (paramj.aQI == null) {
        paramj.aQI = paramString.aQI;
      }
      if (paramj.aQJ == null) {
        paramj.aQJ = paramString.aQJ;
      }
      if (paramj.aQK == null) {
        paramj.aQK = paramString.aQK;
      }
      if (paramj.aQH.isEmpty()) {
        paramj.aQH = paramString.aQH;
      }
      try
      {
        if ((paramj instanceof h.am)) {
          a((h.am)paramj, (h.am)localan);
        }
        for (;;)
        {
          label181:
          if (paramString.aQs == null) {
            break label214;
          }
          paramString = paramString.aQs;
          break;
          a((h.aq)paramj, (h.aq)localan);
        }
      }
      catch (ClassCastException localClassCastException)
      {
        break label181;
        label214:
        AppMethodBeat.o(213128);
      }
    }
  }
  
  private void a(h.l paraml)
  {
    AppMethodBeat.i(213120);
    if ((this.aTs.aPr.aRO == null) && (this.aTs.aPr.aRP == null) && (this.aTs.aPr.aRQ == null))
    {
      AppMethodBeat.o(213120);
      return;
    }
    Object localObject1;
    Object localObject2;
    label140:
    Object localObject3;
    if (this.aTs.aPr.aRO != null)
    {
      localObject1 = paraml.aSW.Y(this.aTs.aPr.aRO);
      if (localObject1 != null)
      {
        localObject1 = (h.r)localObject1;
        if (this.aTs.aPr.aRP == null) {
          break label275;
        }
        localObject2 = paraml.aSW.Y(this.aTs.aPr.aRP);
        if (localObject2 == null) {
          break label251;
        }
        localObject2 = (h.r)localObject2;
        if (this.aTs.aPr.aRQ == null) {
          break label305;
        }
        localObject3 = paraml.aSW.Y(this.aTs.aPr.aRQ);
        if (localObject3 == null) {
          break label281;
        }
        localObject3 = (h.r)localObject3;
        label184:
        if (!(paraml instanceof h.v)) {
          break label311;
        }
        paraml = new a(((h.v)paraml).aRh).aTB;
      }
    }
    label251:
    float f1;
    label275:
    label281:
    label305:
    label311:
    label339:
    float f2;
    for (;;)
    {
      if (paraml != null) {
        break label487;
      }
      AppMethodBeat.o(213120);
      return;
      String.format("Marker reference '%s' not found", new Object[] { this.aTs.aPr.aRO });
      localObject1 = null;
      break;
      String.format("Marker reference '%s' not found", new Object[] { this.aTs.aPr.aRP });
      localObject2 = null;
      break label140;
      String.format("Marker reference '%s' not found", new Object[] { this.aTs.aPr.aRQ });
      localObject3 = null;
      break label184;
      if ((paraml instanceof h.q))
      {
        paraml = (h.q)paraml;
        label355:
        float f3;
        if (paraml.aQU != null)
        {
          f1 = paraml.aQU.a(this);
          if (paraml.aQV == null) {
            break label458;
          }
          f2 = paraml.aQV.b(this);
          if (paraml.aQW == null) {
            break label463;
          }
          f3 = paraml.aQW.a(this);
          label372:
          if (paraml.aQX == null) {
            break label469;
          }
        }
        label458:
        label463:
        label469:
        for (float f4 = paraml.aQX.b(this);; f4 = 0.0F)
        {
          paraml = new ArrayList(2);
          paraml.add(new b(f1, f2, f3 - f1, f4 - f2));
          paraml.add(new b(f3, f4, f3 - f1, f4 - f2));
          break;
          f1 = 0.0F;
          break label339;
          f2 = 0.0F;
          break label355;
          f3 = 0.0F;
          break label372;
        }
      }
      paraml = a((h.z)paraml);
    }
    label487:
    int j = paraml.size();
    if (j == 0)
    {
      AppMethodBeat.o(213120);
      return;
    }
    Object localObject4 = this.aTs.aPr;
    Object localObject5 = this.aTs.aPr;
    this.aTs.aPr.aRQ = null;
    ((h.ae)localObject5).aRP = null;
    ((h.ae)localObject4).aRO = null;
    if (localObject1 != null) {
      a((h.r)localObject1, (b)paraml.get(0));
    }
    int i;
    if ((localObject2 != null) && (paraml.size() > 2))
    {
      localObject4 = (b)paraml.get(0);
      localObject1 = (b)paraml.get(1);
      i = 1;
      if (i < j - 1)
      {
        localObject5 = (b)paraml.get(i + 1);
        if (!((b)localObject1).aTK) {
          break label852;
        }
        f1 = ((b)localObject1).aTI;
        f2 = ((b)localObject1).aTJ;
        f2 = f1 * (((b)localObject1).x - ((b)localObject4).x) + (((b)localObject1).y - ((b)localObject4).y) * f2;
        f1 = f2;
        if (f2 == 0.0F)
        {
          f1 = ((b)localObject1).aTI;
          f2 = ((b)localObject1).aTJ;
          f1 = f1 * (((b)localObject5).x - ((b)localObject1).x) + f2 * (((b)localObject5).y - ((b)localObject1).y);
        }
        if (f1 <= 0.0F) {}
      }
    }
    label852:
    for (;;)
    {
      a((h.r)localObject2, (b)localObject1);
      i += 1;
      localObject4 = localObject5;
      localObject5 = localObject1;
      localObject1 = localObject4;
      localObject4 = localObject5;
      break;
      if ((f1 != 0.0F) || ((((b)localObject1).aTI <= 0.0F) && (((b)localObject1).aTJ < 0.0F)))
      {
        ((b)localObject1).aTI = (-((b)localObject1).aTI);
        ((b)localObject1).aTJ = (-((b)localObject1).aTJ);
        continue;
        if (localObject3 != null) {
          a((h.r)localObject3, (b)paraml.get(j - 1));
        }
        AppMethodBeat.o(213120);
        return;
      }
    }
  }
  
  private void a(h.l paraml, Path paramPath, Matrix paramMatrix)
  {
    AppMethodBeat.i(213139);
    a(this.aTs, paraml);
    if (!ri())
    {
      AppMethodBeat.o(213139);
      return;
    }
    if (!visible())
    {
      AppMethodBeat.o(213139);
      return;
    }
    if (paraml.transform != null) {
      paramMatrix.preConcat(paraml.transform);
    }
    Path localPath;
    if ((paraml instanceof h.ab)) {
      localPath = a((h.ab)paraml);
    }
    for (;;)
    {
      d(paraml);
      paramPath.setFillType(rn());
      paramPath.addPath(localPath, paramMatrix);
      AppMethodBeat.o(213139);
      return;
      if ((paraml instanceof h.d))
      {
        localPath = a((h.d)paraml);
      }
      else if ((paraml instanceof h.i))
      {
        localPath = a((h.i)paraml);
      }
      else
      {
        if (!(paraml instanceof h.z)) {
          break;
        }
        localPath = b((h.z)paraml);
      }
    }
    AppMethodBeat.o(213139);
  }
  
  private void a(h.r paramr, b paramb)
  {
    float f4 = 3.0F;
    float f8 = 0.0F;
    AppMethodBeat.i(213121);
    rb();
    float f1;
    if (paramr.aRd != null) {
      if (Float.isNaN(paramr.aRd.floatValue()))
      {
        if ((paramb.aTI == 0.0F) && (paramb.aTJ == 0.0F)) {
          break label696;
        }
        f1 = (float)Math.toDegrees(Math.atan2(paramb.aTJ, paramb.aTI));
      }
    }
    for (;;)
    {
      float f2;
      label84:
      Matrix localMatrix;
      label150:
      float f5;
      label167:
      float f3;
      label184:
      float f7;
      float f6;
      if (paramr.aQY)
      {
        f2 = 1.0F;
        this.aTs = d(paramr);
        localMatrix = new Matrix();
        localMatrix.preTranslate(paramb.x, paramb.y);
        localMatrix.preRotate(f1);
        localMatrix.preScale(f2, f2);
        if (paramr.aQZ == null) {
          break label557;
        }
        f2 = paramr.aQZ.a(this);
        if (paramr.aRa == null) {
          break label563;
        }
        f5 = paramr.aRa.b(this);
        if (paramr.aRb == null) {
          break label569;
        }
        f3 = paramr.aRb.a(this);
        if (paramr.aRc != null) {
          f4 = paramr.aRc.b(this);
        }
        if (paramr.aQi == null) {
          break label643;
        }
        f7 = f3 / paramr.aQi.width;
        f6 = f4 / paramr.aQi.height;
        if (paramr.aQg == null) {
          break label577;
        }
        paramb = paramr.aQg;
        label244:
        if (paramb.equals(f.aPJ)) {
          break label693;
        }
        if (paramb.aPH != f.b.aQd) {
          break label584;
        }
        f1 = Math.max(f7, f6);
        label272:
        f6 = f1;
        f7 = f1;
      }
      label557:
      label563:
      label693:
      for (;;)
      {
        localMatrix.preTranslate(-f2 * f7, -f5 * f6);
        this.aTq.concat(localMatrix);
        f1 = paramr.aQi.width * f7;
        f5 = paramr.aQi.height * f6;
        switch (1.aTy[paramb.aPG.ordinal()])
        {
        default: 
          f1 = 0.0F;
          label378:
          f2 = f8;
          switch (1.aTy[paramb.aPG.ordinal()])
          {
          default: 
            f2 = f8;
          case 4: 
            label440:
            if (!this.aTs.aPr.aRM.booleanValue()) {
              j(f1, f2, f3, f4);
            }
            localMatrix.reset();
            localMatrix.preScale(f7, f6);
            this.aTq.concat(localMatrix);
          }
          break;
        }
        for (;;)
        {
          boolean bool = re();
          a(paramr, false);
          if (bool) {
            b(paramr);
          }
          rc();
          AppMethodBeat.o(213121);
          return;
          f1 = paramr.aRd.floatValue();
          break;
          f2 = this.aTs.aPr.aRx.S(this.aTr);
          break label84;
          f2 = 0.0F;
          break label150;
          f5 = 0.0F;
          break label167;
          label569:
          f3 = 3.0F;
          break label184;
          label577:
          paramb = f.aPK;
          break label244;
          label584:
          f1 = Math.min(f7, f6);
          break label272;
          f1 = 0.0F - (f3 - f1) / 2.0F;
          break label378;
          f1 = 0.0F - (f3 - f1);
          break label378;
          f2 = 0.0F - (f4 - f5) / 2.0F;
          break label440;
          f2 = 0.0F - (f4 - f5);
          break label440;
          localMatrix.preTranslate(-f2, -f5);
          this.aTq.concat(localMatrix);
          if (!this.aTs.aPr.aRM.booleanValue()) {
            j(0.0F, 0.0F, f3, f4);
          }
        }
      }
      label643:
      label696:
      f1 = 0.0F;
    }
  }
  
  private void a(h.s params, h.ak paramak, h.b paramb)
  {
    float f2 = 1.2F;
    AppMethodBeat.i(213149);
    if ((params.aRe != null) && (params.aRe.booleanValue()))
    {
      i = 1;
      if (i == 0) {
        break label115;
      }
      if (params.aQR == null) {
        break label97;
      }
      f1 = params.aQR.a(this);
      label53:
      if (params.aQS == null) {
        break label106;
      }
    }
    label97:
    label106:
    for (f2 = params.aQS.b(this);; f2 = paramb.height)
    {
      if ((f1 != 0.0F) && (f2 != 0.0F)) {
        break label180;
      }
      AppMethodBeat.o(213149);
      return;
      i = 0;
      break;
      f1 = paramb.width;
      break label53;
    }
    label115:
    if (params.aQR != null) {}
    for (float f1 = params.aQR.a(this, 1.0F);; f1 = 1.2F)
    {
      if (params.aQS != null) {
        f2 = params.aQS.a(this, 1.0F);
      }
      f1 *= paramb.width;
      f2 *= paramb.height;
      break;
    }
    label180:
    rb();
    this.aTs = d(params);
    this.aTs.aPr.aRD = Float.valueOf(1.0F);
    boolean bool = re();
    this.aTq.save();
    if ((params.aRf == null) || (params.aRf.booleanValue())) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.aTq.translate(paramb.minX, paramb.minY);
        this.aTq.scale(paramb.width, paramb.height);
      }
      a(params, false);
      this.aTq.restore();
      if (bool) {
        a(paramak, paramb);
      }
      rc();
      AppMethodBeat.o(213149);
      return;
    }
  }
  
  private void a(h.v paramv, Path paramPath, Matrix paramMatrix)
  {
    AppMethodBeat.i(213138);
    a(this.aTs, paramv);
    if (!ri())
    {
      AppMethodBeat.o(213138);
      return;
    }
    if (!visible())
    {
      AppMethodBeat.o(213138);
      return;
    }
    if (paramv.transform != null) {
      paramMatrix.preConcat(paramv.transform);
    }
    Path localPath = new c(paramv.aRh).lP;
    if (paramv.aSS == null) {
      paramv.aSS = e(localPath);
    }
    d(paramv);
    paramPath.setFillType(rn());
    paramPath.addPath(localPath, paramMatrix);
    AppMethodBeat.o(213138);
  }
  
  private static void a(h.y paramy, String paramString)
  {
    AppMethodBeat.i(213148);
    for (;;)
    {
      h.an localan = paramy.aSW.Y(paramString);
      if (localan == null)
      {
        String.format("Pattern reference '%s' not found", new Object[] { paramString });
        AppMethodBeat.o(213148);
        return;
      }
      if (!(localan instanceof h.y))
      {
        String.format("Pattern href attributes must point to other pattern elements", new Object[0]);
        AppMethodBeat.o(213148);
        return;
      }
      if (localan == paramy)
      {
        String.format("Circular reference in pattern href attribute '%s'", new Object[] { paramString });
        AppMethodBeat.o(213148);
        return;
      }
      paramString = (h.y)localan;
      if (paramy.aRn == null) {
        paramy.aRn = paramString.aRn;
      }
      if (paramy.aRo == null) {
        paramy.aRo = paramString.aRo;
      }
      if (paramy.aRp == null) {
        paramy.aRp = paramString.aRp;
      }
      if (paramy.aQP == null) {
        paramy.aQP = paramString.aQP;
      }
      if (paramy.aQQ == null) {
        paramy.aQQ = paramString.aQQ;
      }
      if (paramy.aQR == null) {
        paramy.aQR = paramString.aQR;
      }
      if (paramy.aQS == null) {
        paramy.aQS = paramString.aQS;
      }
      if (paramy.aQH.isEmpty()) {
        paramy.aQH = paramString.aQH;
      }
      if (paramy.aQi == null) {
        paramy.aQi = paramString.aQi;
      }
      if (paramy.aQg == null) {
        paramy.aQg = paramString.aQg;
      }
      if (paramString.aQs == null) {
        break;
      }
      paramString = paramString.aQs;
    }
    AppMethodBeat.o(213148);
  }
  
  private void a(g paramg, h.ae paramae)
  {
    boolean bool2 = true;
    AppMethodBeat.i(213114);
    if (a(paramae, 4096L)) {
      paramg.aPr.aRE = paramae.aRE;
    }
    if (a(paramae, 2048L)) {
      paramg.aPr.aRD = paramae.aRD;
    }
    boolean bool1;
    label201:
    label368:
    float f1;
    label428:
    Object localObject1;
    label534:
    label674:
    Object localObject2;
    if (a(paramae, 1L))
    {
      paramg.aPr.aRs = paramae.aRs;
      if ((paramae.aRs != null) && (paramae.aRs != h.f.aQD))
      {
        bool1 = true;
        paramg.aTO = bool1;
      }
    }
    else
    {
      if (a(paramae, 4L)) {
        paramg.aPr.aRu = paramae.aRu;
      }
      if (a(paramae, 6149L)) {
        a(paramg, true, paramg.aPr.aRs);
      }
      if (a(paramae, 2L)) {
        paramg.aPr.aRt = paramae.aRt;
      }
      if (a(paramae, 8L))
      {
        paramg.aPr.aRv = paramae.aRv;
        if ((paramae.aRv == null) || (paramae.aRv == h.f.aQD)) {
          break label1394;
        }
        bool1 = true;
        paramg.aTP = bool1;
      }
      if (a(paramae, 16L)) {
        paramg.aPr.aRw = paramae.aRw;
      }
      if (a(paramae, 6168L)) {
        a(paramg, false, paramg.aPr.aRv);
      }
      if (a(paramae, 34359738368L)) {
        paramg.aPr.aSc = paramae.aSc;
      }
      if (a(paramae, 32L))
      {
        paramg.aPr.aRx = paramae.aRx;
        paramg.aTR.setStrokeWidth(paramg.aPr.aRx.c(this));
      }
      if (a(paramae, 64L)) {
        paramg.aPr.aRy = paramae.aRy;
      }
      switch (1.aTz[paramae.aRy.ordinal()])
      {
      default: 
        if (a(paramae, 128L)) {
          paramg.aPr.aRz = paramae.aRz;
        }
        switch (1.aTA[paramae.aRz.ordinal()])
        {
        default: 
          if (a(paramae, 256L))
          {
            paramg.aPr.aRA = paramae.aRA;
            paramg.aTR.setStrokeMiter(paramae.aRA.floatValue());
          }
          if (a(paramae, 512L)) {
            paramg.aPr.aRB = paramae.aRB;
          }
          if (a(paramae, 1024L)) {
            paramg.aPr.aRC = paramae.aRC;
          }
          if (a(paramae, 1536L))
          {
            if (paramg.aPr.aRB == null) {
              paramg.aTR.setPathEffect(null);
            }
          }
          else
          {
            if (a(paramae, 16384L))
            {
              f1 = qZ();
              paramg.aPr.aRG = paramae.aRG;
              paramg.aTQ.setTextSize(paramae.aRG.a(this, f1));
              paramg.aTR.setTextSize(paramae.aRG.a(this, f1));
            }
            if (a(paramae, 8192L)) {
              paramg.aPr.aRF = paramae.aRF;
            }
            if (a(paramae, 32768L))
            {
              if ((paramae.aRH.intValue() != -1) || (paramg.aPr.aRH.intValue() <= 100)) {
                break label1637;
              }
              localObject1 = paramg.aPr;
              ((h.ae)localObject1).aRH = Integer.valueOf(((h.ae)localObject1).aRH.intValue() - 100);
            }
            if (a(paramae, 65536L)) {
              paramg.aPr.aRI = paramae.aRI;
            }
            if (a(paramae, 106496L))
            {
              if ((paramg.aPr.aRF == null) || (this.aSW == null)) {
                break label1730;
              }
              j localj = h.qN();
              Iterator localIterator = paramg.aPr.aRF.iterator();
              localObject2 = null;
              do
              {
                localObject1 = localObject2;
                if (!localIterator.hasNext()) {
                  break;
                }
                localObject2 = a((String)localIterator.next(), paramg.aPr.aRH, paramg.aPr.aRI);
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  localObject1 = localObject2;
                  if (localj != null)
                  {
                    paramg.aPr.aRH.intValue();
                    String.valueOf(paramg.aPr.aRI);
                    localObject1 = null;
                  }
                }
                localObject2 = localObject1;
              } while (localObject1 == null);
            }
          }
          break;
        }
        break;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = a("serif", paramg.aPr.aRH, paramg.aPr.aRI);
      }
      paramg.aTQ.setTypeface((Typeface)localObject2);
      paramg.aTR.setTypeface((Typeface)localObject2);
      if (a(paramae, 131072L))
      {
        paramg.aPr.aRJ = paramae.aRJ;
        localObject1 = paramg.aTQ;
        if (paramae.aRJ != h.ae.g.aSE) {
          break label1706;
        }
        bool1 = true;
        label930:
        ((Paint)localObject1).setStrikeThruText(bool1);
        localObject1 = paramg.aTQ;
        if (paramae.aRJ != h.ae.g.aSC) {
          break label1712;
        }
        bool1 = true;
        label956:
        ((Paint)localObject1).setUnderlineText(bool1);
        if (Build.VERSION.SDK_INT >= 17)
        {
          localObject1 = paramg.aTR;
          if (paramae.aRJ != h.ae.g.aSE) {
            break label1718;
          }
          bool1 = true;
          label990:
          ((Paint)localObject1).setStrikeThruText(bool1);
          localObject1 = paramg.aTR;
          if (paramae.aRJ != h.ae.g.aSC) {
            break label1724;
          }
        }
      }
      label1706:
      label1712:
      label1718:
      label1724:
      for (bool1 = bool2;; bool1 = false)
      {
        ((Paint)localObject1).setUnderlineText(bool1);
        if (a(paramae, 68719476736L)) {
          paramg.aPr.aRK = paramae.aRK;
        }
        if (a(paramae, 262144L)) {
          paramg.aPr.aRL = paramae.aRL;
        }
        if (a(paramae, 524288L)) {
          paramg.aPr.aRM = paramae.aRM;
        }
        if (a(paramae, 2097152L)) {
          paramg.aPr.aRO = paramae.aRO;
        }
        if (a(paramae, 4194304L)) {
          paramg.aPr.aRP = paramae.aRP;
        }
        if (a(paramae, 8388608L)) {
          paramg.aPr.aRQ = paramae.aRQ;
        }
        if (a(paramae, 16777216L)) {
          paramg.aPr.aRR = paramae.aRR;
        }
        if (a(paramae, 33554432L)) {
          paramg.aPr.aRS = paramae.aRS;
        }
        if (a(paramae, 1048576L)) {
          paramg.aPr.aRN = paramae.aRN;
        }
        if (a(paramae, 268435456L)) {
          paramg.aPr.aRV = paramae.aRV;
        }
        if (a(paramae, 536870912L)) {
          paramg.aPr.aRW = paramae.aRW;
        }
        if (a(paramae, 1073741824L)) {
          paramg.aPr.aRX = paramae.aRX;
        }
        if (a(paramae, 67108864L)) {
          paramg.aPr.aRT = paramae.aRT;
        }
        if (a(paramae, 134217728L)) {
          paramg.aPr.aRU = paramae.aRU;
        }
        if (a(paramae, 8589934592L)) {
          paramg.aPr.aSa = paramae.aSa;
        }
        if (a(paramae, 17179869184L)) {
          paramg.aPr.aSb = paramae.aSb;
        }
        if (a(paramae, 137438953472L)) {
          paramg.aPr.aSd = paramae.aSd;
        }
        AppMethodBeat.o(213114);
        return;
        bool1 = false;
        break;
        label1394:
        bool1 = false;
        break label201;
        paramg.aTR.setStrokeCap(Paint.Cap.BUTT);
        break label368;
        paramg.aTR.setStrokeCap(Paint.Cap.ROUND);
        break label368;
        paramg.aTR.setStrokeCap(Paint.Cap.SQUARE);
        break label368;
        paramg.aTR.setStrokeJoin(Paint.Join.MITER);
        break label428;
        paramg.aTR.setStrokeJoin(Paint.Join.ROUND);
        break label428;
        paramg.aTR.setStrokeJoin(Paint.Join.BEVEL);
        break label428;
        int k = paramg.aPr.aRB.length;
        if (k % 2 == 0) {}
        for (int i = k;; i = k * 2)
        {
          localObject1 = new float[i];
          int j = 0;
          f1 = 0.0F;
          while (j < i)
          {
            localObject1[j] = paramg.aPr.aRB[(j % k)].c(this);
            f1 += localObject1[j];
            j += 1;
          }
        }
        if (f1 == 0.0F)
        {
          paramg.aTR.setPathEffect(null);
          break label534;
        }
        float f3 = paramg.aPr.aRC.c(this);
        float f2 = f3;
        if (f3 < 0.0F) {
          f2 = f3 % f1 + f1;
        }
        paramg.aTR.setPathEffect(new DashPathEffect((float[])localObject1, f2));
        break label534;
        label1637:
        if ((paramae.aRH.intValue() == 1) && (paramg.aPr.aRH.intValue() < 900))
        {
          localObject1 = paramg.aPr;
          ((h.ae)localObject1).aRH = Integer.valueOf(((h.ae)localObject1).aRH.intValue() + 100);
          break label674;
        }
        paramg.aPr.aRH = paramae.aRH;
        break label674;
        bool1 = false;
        break label930;
        bool1 = false;
        break label956;
        bool1 = false;
        break label990;
      }
      label1730:
      localObject1 = null;
    }
  }
  
  private void a(g paramg, h.al paramal)
  {
    AppMethodBeat.i(213092);
    if (paramal.aSX == null) {}
    for (boolean bool = true;; bool = false)
    {
      paramg.aPr.aJ(bool);
      if (paramal.aSU != null) {
        a(paramg, paramal.aSU);
      }
      if (!this.aSW.qL()) {
        break;
      }
      Iterator localIterator = this.aSW.aQp.aPt.iterator();
      while (localIterator.hasNext())
      {
        b.o localo = (b.o)localIterator.next();
        if (b.a(this.aTx, localo.aPq, paramal)) {
          a(paramg, localo.aPr);
        }
      }
    }
    if (paramal.aPr != null) {
      a(paramg, paramal.aPr);
    }
    AppMethodBeat.o(213092);
  }
  
  private static void a(g paramg, boolean paramBoolean, h.ao paramao)
  {
    AppMethodBeat.i(213115);
    Float localFloat;
    float f;
    if (paramBoolean)
    {
      localFloat = paramg.aPr.aRu;
      f = localFloat.floatValue();
      if (!(paramao instanceof h.f)) {
        break label81;
      }
    }
    for (int i = ((h.f)paramao).aQB;; i = paramg.aPr.aRE.aQB)
    {
      i = h(i, f);
      if (!paramBoolean) {
        break label110;
      }
      paramg.aTQ.setColor(i);
      AppMethodBeat.o(213115);
      return;
      localFloat = paramg.aPr.aRw;
      break;
      label81:
      if (!(paramao instanceof h.g)) {
        break label103;
      }
    }
    label103:
    AppMethodBeat.o(213115);
    return;
    label110:
    paramg.aTR.setColor(i);
    AppMethodBeat.o(213115);
  }
  
  private void a(boolean paramBoolean, h.ac paramac)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(213129);
    g localg;
    if (paramBoolean)
    {
      if (a(paramac.aSU, 2147483648L))
      {
        this.aTs.aPr.aRs = paramac.aSU.aRY;
        localg = this.aTs;
        if (paramac.aSU.aRY == null) {
          break label134;
        }
      }
      for (;;)
      {
        localg.aTO = bool1;
        if (a(paramac.aSU, 4294967296L)) {
          this.aTs.aPr.aRu = paramac.aSU.aRZ;
        }
        if (!a(paramac.aSU, 6442450944L)) {
          break;
        }
        paramac = this.aTs;
        a(paramac, paramBoolean, paramac.aPr.aRs);
        AppMethodBeat.o(213129);
        return;
        label134:
        bool1 = false;
      }
    }
    if (a(paramac.aSU, 2147483648L))
    {
      this.aTs.aPr.aRv = paramac.aSU.aRY;
      localg = this.aTs;
      if (paramac.aSU.aRY == null) {
        break label261;
      }
    }
    label261:
    for (bool1 = bool2;; bool1 = false)
    {
      localg.aTP = bool1;
      if (a(paramac.aSU, 4294967296L)) {
        this.aTs.aPr.aRw = paramac.aSU.aRZ;
      }
      if (a(paramac.aSU, 6442450944L))
      {
        paramac = this.aTs;
        a(paramac, paramBoolean, paramac.aPr.aRv);
      }
      AppMethodBeat.o(213129);
      return;
    }
  }
  
  private void a(boolean paramBoolean, h.b paramb, h.am paramam)
  {
    AppMethodBeat.i(213126);
    if (paramam.aQs != null) {
      a(paramam, paramam.aQs);
    }
    Paint localPaint;
    label54:
    float f2;
    label82:
    float f1;
    label99:
    float f3;
    if ((paramam.aQI != null) && (paramam.aQI.booleanValue()))
    {
      i = 1;
      if (!paramBoolean) {
        break label258;
      }
      localPaint = this.aTs.aTQ;
      if (i == 0) {
        break label298;
      }
      localObject = ra();
      if (paramam.aQU == null) {
        break label270;
      }
      f2 = paramam.aQU.a(this);
      if (paramam.aQV == null) {
        break label276;
      }
      f1 = paramam.aQV.b(this);
      if (paramam.aQW == null) {
        break label282;
      }
      f3 = paramam.aQW.a(this);
      label116:
      if (paramam.aQX == null) {
        break label292;
      }
    }
    float f5;
    Matrix localMatrix;
    int j;
    label258:
    label270:
    label276:
    label282:
    label292:
    for (float f4 = paramam.aQX.b(this);; f4 = 0.0F)
    {
      f5 = f2;
      f2 = f1;
      rb();
      this.aTs = d(paramam);
      localMatrix = new Matrix();
      if (i == 0)
      {
        localMatrix.preTranslate(paramb.minX, paramb.minY);
        localMatrix.preScale(paramb.width, paramb.height);
      }
      if (paramam.aQJ != null) {
        localMatrix.preConcat(paramam.aQJ);
      }
      j = paramam.aQH.size();
      if (j != 0) {
        break label416;
      }
      rc();
      if (!paramBoolean) {
        break label401;
      }
      this.aTs.aTO = false;
      AppMethodBeat.o(213126);
      return;
      i = 0;
      break;
      localPaint = this.aTs.aTR;
      break label54;
      f2 = 0.0F;
      break label82;
      f1 = 0.0F;
      break label99;
      f3 = ((h.b)localObject).width;
      break label116;
    }
    label298:
    if (paramam.aQU != null)
    {
      f1 = paramam.aQU.a(this, 1.0F);
      label316:
      if (paramam.aQV == null) {
        break label383;
      }
      f2 = paramam.aQV.a(this, 1.0F);
      label334:
      if (paramam.aQW == null) {
        break label389;
      }
      f3 = paramam.aQW.a(this, 1.0F);
      label352:
      if (paramam.aQX == null) {
        break label395;
      }
    }
    label389:
    label395:
    for (f4 = paramam.aQX.a(this, 1.0F);; f4 = 0.0F)
    {
      f5 = f1;
      break;
      f1 = 0.0F;
      break label316;
      label383:
      f2 = 0.0F;
      break label334;
      f3 = 1.0F;
      break label352;
    }
    label401:
    this.aTs.aTP = false;
    AppMethodBeat.o(213126);
    return;
    label416:
    int[] arrayOfInt = new int[j];
    float[] arrayOfFloat = new float[j];
    int i = 0;
    Iterator localIterator = paramam.aQH.iterator();
    float f6 = -1.0F;
    if (localIterator.hasNext())
    {
      paramb = (h.ad)localIterator.next();
      if (paramb.aRq != null)
      {
        f1 = paramb.aRq.floatValue();
        label487:
        if ((i != 0) && (f1 < f6)) {
          break label595;
        }
        arrayOfFloat[i] = f1;
      }
      for (;;)
      {
        rb();
        a(this.aTs, paramb);
        localObject = (h.f)this.aTs.aPr.aRT;
        paramb = (h.b)localObject;
        if (localObject == null) {
          paramb = h.f.aQC;
        }
        arrayOfInt[i] = h(paramb.aQB, this.aTs.aPr.aRU.floatValue());
        rc();
        i += 1;
        f6 = f1;
        break;
        f1 = 0.0F;
        break label487;
        label595:
        arrayOfFloat[i] = f6;
        f1 = f6;
      }
    }
    if (((f5 == f3) && (f2 == f4)) || (j == 1))
    {
      rc();
      localPaint.setColor(arrayOfInt[(j - 1)]);
      AppMethodBeat.o(213126);
      return;
    }
    Object localObject = Shader.TileMode.CLAMP;
    paramb = (h.b)localObject;
    if (paramam.aQK != null)
    {
      if (paramam.aQK != h.k.aQM) {
        break label749;
      }
      paramb = Shader.TileMode.MIRROR;
    }
    for (;;)
    {
      rc();
      paramb = new LinearGradient(f5, f2, f3, f4, arrayOfInt, arrayOfFloat, paramb);
      paramb.setLocalMatrix(localMatrix);
      localPaint.setShader(paramb);
      localPaint.setAlpha(T(this.aTs.aPr.aRu.floatValue()));
      AppMethodBeat.o(213126);
      return;
      label749:
      paramb = (h.b)localObject;
      if (paramam.aQK == h.k.aQN) {
        paramb = Shader.TileMode.REPEAT;
      }
    }
  }
  
  private void a(boolean paramBoolean, h.b paramb, h.aq paramaq)
  {
    AppMethodBeat.i(213127);
    if (paramaq.aQs != null) {
      a(paramaq, paramaq.aQs);
    }
    Paint localPaint;
    label54:
    float f1;
    label91:
    float f2;
    if ((paramaq.aQI != null) && (paramaq.aQI.booleanValue()))
    {
      i = 1;
      if (!paramBoolean) {
        break label246;
      }
      localPaint = this.aTs.aTQ;
      if (i == 0) {
        break label291;
      }
      localObject = new h.p(50.0F, h.bd.aTo);
      if (paramaq.aQx == null) {
        break label258;
      }
      f1 = paramaq.aQx.a(this);
      if (paramaq.aQy == null) {
        break label269;
      }
      f2 = paramaq.aQy.b(this);
      label108:
      if (paramaq.aQz == null) {
        break label280;
      }
    }
    float f4;
    Matrix localMatrix;
    int j;
    label258:
    label269:
    label280:
    for (float f3 = paramaq.aQz.c(this);; f3 = ((h.p)localObject).c(this))
    {
      f4 = f1;
      rb();
      this.aTs = d(paramaq);
      localMatrix = new Matrix();
      if (i == 0)
      {
        localMatrix.preTranslate(paramb.minX, paramb.minY);
        localMatrix.preScale(paramb.width, paramb.height);
      }
      if (paramaq.aQJ != null) {
        localMatrix.preConcat(paramaq.aQJ);
      }
      j = paramaq.aQH.size();
      if (j != 0) {
        break label391;
      }
      rc();
      if (!paramBoolean) {
        break label376;
      }
      this.aTs.aTO = false;
      AppMethodBeat.o(213127);
      return;
      i = 0;
      break;
      label246:
      localPaint = this.aTs.aTR;
      break label54;
      f1 = ((h.p)localObject).a(this);
      break label91;
      f2 = ((h.p)localObject).b(this);
      break label108;
    }
    label291:
    if (paramaq.aQx != null)
    {
      f1 = paramaq.aQx.a(this, 1.0F);
      label309:
      if (paramaq.aQy == null) {
        break label360;
      }
      f2 = paramaq.aQy.a(this, 1.0F);
      label327:
      if (paramaq.aQz == null) {
        break label368;
      }
    }
    label360:
    label368:
    for (f3 = paramaq.aQz.a(this, 1.0F);; f3 = 0.5F)
    {
      f4 = f1;
      break;
      f1 = 0.5F;
      break label309;
      f2 = 0.5F;
      break label327;
    }
    label376:
    this.aTs.aTP = false;
    AppMethodBeat.o(213127);
    return;
    label391:
    int[] arrayOfInt = new int[j];
    float[] arrayOfFloat = new float[j];
    int i = 0;
    Iterator localIterator = paramaq.aQH.iterator();
    float f5 = -1.0F;
    if (localIterator.hasNext())
    {
      paramb = (h.ad)localIterator.next();
      if (paramb.aRq != null)
      {
        f1 = paramb.aRq.floatValue();
        label462:
        if ((i != 0) && (f1 < f5)) {
          break label570;
        }
        arrayOfFloat[i] = f1;
      }
      for (;;)
      {
        rb();
        a(this.aTs, paramb);
        localObject = (h.f)this.aTs.aPr.aRT;
        paramb = (h.b)localObject;
        if (localObject == null) {
          paramb = h.f.aQC;
        }
        arrayOfInt[i] = h(paramb.aQB, this.aTs.aPr.aRU.floatValue());
        rc();
        i += 1;
        f5 = f1;
        break;
        f1 = 0.0F;
        break label462;
        label570:
        arrayOfFloat[i] = f5;
        f1 = f5;
      }
    }
    if ((f3 == 0.0F) || (j == 1))
    {
      rc();
      localPaint.setColor(arrayOfInt[(j - 1)]);
      AppMethodBeat.o(213127);
      return;
    }
    Object localObject = Shader.TileMode.CLAMP;
    paramb = (h.b)localObject;
    if (paramaq.aQK != null)
    {
      if (paramaq.aQK != h.k.aQM) {
        break label713;
      }
      paramb = Shader.TileMode.MIRROR;
    }
    for (;;)
    {
      rc();
      paramb = new RadialGradient(f4, f2, f3, arrayOfInt, arrayOfFloat, paramb);
      paramb.setLocalMatrix(localMatrix);
      localPaint.setShader(paramb);
      localPaint.setAlpha(T(this.aTs.aPr.aRu.floatValue()));
      AppMethodBeat.o(213127);
      return;
      label713:
      paramb = (h.b)localObject;
      if (paramaq.aQK == h.k.aQN) {
        paramb = Shader.TileMode.REPEAT;
      }
    }
  }
  
  private void a(boolean paramBoolean, h.b paramb, h.u paramu)
  {
    AppMethodBeat.i(213125);
    h.an localan = this.aSW.Y(paramu.aQs);
    if (localan == null)
    {
      if (paramBoolean) {}
      for (paramb = "Fill";; paramb = "Stroke")
      {
        String.format("%s reference '%s' not found", new Object[] { paramb, paramu.aQs });
        if (paramu.aRg == null) {
          break;
        }
        a(this.aTs, paramBoolean, paramu.aRg);
        AppMethodBeat.o(213125);
        return;
      }
      if (paramBoolean)
      {
        this.aTs.aTO = false;
        AppMethodBeat.o(213125);
        return;
      }
      this.aTs.aTP = false;
      AppMethodBeat.o(213125);
      return;
    }
    if ((localan instanceof h.am))
    {
      a(paramBoolean, paramb, (h.am)localan);
      AppMethodBeat.o(213125);
      return;
    }
    if ((localan instanceof h.aq))
    {
      a(paramBoolean, paramb, (h.aq)localan);
      AppMethodBeat.o(213125);
      return;
    }
    if ((localan instanceof h.ac)) {
      a(paramBoolean, (h.ac)localan);
    }
    AppMethodBeat.o(213125);
  }
  
  private static boolean a(h.ae paramae, long paramLong)
  {
    return (paramae.aRr & paramLong) != 0L;
  }
  
  private static Path b(h.z paramz)
  {
    AppMethodBeat.i(213145);
    Path localPath = new Path();
    localPath.moveTo(paramz.points[0], paramz.points[1]);
    int i = 2;
    while (i < paramz.points.length)
    {
      localPath.lineTo(paramz.points[i], paramz.points[(i + 1)]);
      i += 2;
    }
    if ((paramz instanceof h.aa)) {
      localPath.close();
    }
    if (paramz.aSS == null) {
      paramz.aSS = e(localPath);
    }
    AppMethodBeat.o(213145);
    return localPath;
  }
  
  private void b(h.ak paramak)
  {
    AppMethodBeat.i(213100);
    a(paramak, paramak.aSS);
    AppMethodBeat.o(213100);
  }
  
  private void b(h.ak paramak, h.b paramb)
  {
    AppMethodBeat.i(213131);
    if (this.aTs.aPr.aRV == null)
    {
      AppMethodBeat.o(213131);
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      paramak = c(paramak, paramb);
      if (paramak != null) {
        this.aTq.clipPath(paramak);
      }
      AppMethodBeat.o(213131);
      return;
    }
    d(paramak, paramb);
    AppMethodBeat.o(213131);
  }
  
  private void b(h.an paraman)
  {
    Object localObject1 = null;
    float f2 = 0.0F;
    float f4 = 0.0F;
    AppMethodBeat.i(213086);
    if ((paraman instanceof h.t))
    {
      AppMethodBeat.o(213086);
      return;
    }
    rb();
    c(paraman);
    if ((paraman instanceof h.af))
    {
      paraman = (h.af)paraman;
      a(paraman, a(paraman.aQP, paraman.aQQ, paraman.aQR, paraman.aQS), paraman.aQi, paraman.aQg);
    }
    Object localObject2;
    Object localObject3;
    float f1;
    label241:
    boolean bool1;
    label259:
    label370:
    label375:
    label510:
    do
    {
      do
      {
        for (;;)
        {
          rc();
          AppMethodBeat.o(213086);
          return;
          if ((paraman instanceof h.be))
          {
            localObject2 = (h.be)paraman;
            if (((((h.be)localObject2).aQR == null) || (!((h.be)localObject2).aQR.isZero())) && ((((h.be)localObject2).aQS == null) || (!((h.be)localObject2).aQS.isZero())))
            {
              a(this.aTs, (h.al)localObject2);
              if (ri())
              {
                localObject3 = ((h.be)localObject2).aSW.Y(((h.be)localObject2).aQs);
                if (localObject3 == null)
                {
                  String.format("Use reference '%s' not found", new Object[] { ((h.be)localObject2).aQs });
                }
                else
                {
                  if (((h.be)localObject2).transform != null) {
                    this.aTq.concat(((h.be)localObject2).transform);
                  }
                  if (((h.be)localObject2).aQP != null)
                  {
                    f1 = ((h.be)localObject2).aQP.a(this);
                    if (((h.be)localObject2).aQQ == null) {
                      break label370;
                    }
                    f2 = ((h.be)localObject2).aQQ.b(this);
                    this.aTq.translate(f1, f2);
                    d((h.ak)localObject2);
                    bool1 = re();
                    a((h.aj)localObject2);
                    if (!(localObject3 instanceof h.af)) {
                      break label375;
                    }
                    paraman = (h.af)localObject3;
                    localObject1 = a(null, null, ((h.be)localObject2).aQR, ((h.be)localObject2).aQS);
                    rb();
                    a(paraman, (h.b)localObject1, paraman.aQi, paraman.aQg);
                    rc();
                  }
                  for (;;)
                  {
                    rd();
                    if (bool1) {
                      b((h.ak)localObject2);
                    }
                    a((h.ak)localObject2);
                    break;
                    f1 = 0.0F;
                    break label241;
                    f2 = 0.0F;
                    break label259;
                    if ((localObject3 instanceof h.at))
                    {
                      if (((h.be)localObject2).aQR != null)
                      {
                        paraman = ((h.be)localObject2).aQR;
                        if (((h.be)localObject2).aQS == null) {
                          break label478;
                        }
                      }
                      for (localObject1 = ((h.be)localObject2).aQS;; localObject1 = new h.p(100.0F, h.bd.aTo))
                      {
                        localObject1 = a(null, null, paraman, (h.p)localObject1);
                        rb();
                        localObject3 = (h.at)localObject3;
                        if ((((h.b)localObject1).width != 0.0F) && (((h.b)localObject1).height != 0.0F)) {
                          break label496;
                        }
                        rc();
                        break;
                        paraman = new h.p(100.0F, h.bd.aTo);
                        break label397;
                      }
                      if (((h.at)localObject3).aQg != null)
                      {
                        paraman = ((h.at)localObject3).aQg;
                        a(this.aTs, (h.al)localObject3);
                        this.aTs.aQk = ((h.b)localObject1);
                        if (!this.aTs.aPr.aRM.booleanValue()) {
                          j(this.aTs.aQk.minX, this.aTs.aQk.minY, this.aTs.aQk.width, this.aTs.aQk.height);
                        }
                        if (((h.at)localObject3).aQi == null) {
                          break label672;
                        }
                        this.aTq.concat(a(this.aTs.aQk, ((h.at)localObject3).aQi, paraman));
                        this.aTs.aQi = ((h.at)localObject3).aQi;
                      }
                      for (;;)
                      {
                        boolean bool2 = re();
                        a((h.aj)localObject3, true);
                        if (bool2) {
                          b((h.ak)localObject3);
                        }
                        a((h.ak)localObject3);
                        break;
                        paraman = f.aPK;
                        break label510;
                        this.aTq.translate(this.aTs.aQk.minX, this.aTs.aQk.minY);
                      }
                    }
                    b((h.an)localObject3);
                  }
                }
              }
            }
          }
          else if ((paraman instanceof h.as))
          {
            paraman = (h.as)paraman;
            a(this.aTs, paraman);
            if (ri())
            {
              if (paraman.transform != null) {
                this.aTq.concat(paraman.transform);
              }
              d(paraman);
              bool1 = re();
              localObject1 = Locale.getDefault().getLanguage();
              localObject2 = h.qN();
              localObject3 = paraman.aQH.iterator();
              while (((Iterator)localObject3).hasNext())
              {
                h.an localan = (h.an)((Iterator)localObject3).next();
                if ((localan instanceof h.ag))
                {
                  Object localObject4 = (h.ag)localan;
                  if (((h.ag)localObject4).qT() == null)
                  {
                    Object localObject5 = ((h.ag)localObject4).qU();
                    if ((localObject5 == null) || ((!((Set)localObject5).isEmpty()) && (((Set)localObject5).contains(localObject1))))
                    {
                      localObject5 = ((h.ag)localObject4).qS();
                      if (localObject5 != null)
                      {
                        if (aTw == null) {
                          rg();
                        }
                        if ((((Set)localObject5).isEmpty()) || (!aTw.containsAll((Collection)localObject5))) {
                          break;
                        }
                      }
                      else
                      {
                        localObject5 = ((h.ag)localObject4).qV();
                        if (localObject5 != null)
                        {
                          if ((((Set)localObject5).isEmpty()) || (localObject2 == null)) {
                            continue;
                          }
                          localObject5 = ((Set)localObject5).iterator();
                          if (((Iterator)localObject5).hasNext())
                          {
                            ((Iterator)localObject5).next();
                            continue;
                          }
                        }
                        localObject4 = ((h.ag)localObject4).qW();
                        if (localObject4 != null)
                        {
                          if ((((Set)localObject4).isEmpty()) || (localObject2 == null)) {
                            continue;
                          }
                          localObject4 = ((Set)localObject4).iterator();
                          if (((Iterator)localObject4).hasNext())
                          {
                            ((Iterator)localObject4).next();
                            this.aTs.aPr.aRH.intValue();
                            String.valueOf(this.aTs.aPr.aRI);
                            continue;
                          }
                        }
                        b(localan);
                      }
                    }
                  }
                }
              }
              if (bool1) {
                b(paraman);
              }
              a(paraman);
            }
          }
          else
          {
            if (!(paraman instanceof h.m)) {
              break;
            }
            paraman = (h.m)paraman;
            new StringBuilder().append(paraman.getNodeName()).append(" render");
            a(this.aTs, paraman);
            if (ri())
            {
              if (paraman.transform != null) {
                this.aTq.concat(paraman.transform);
              }
              d(paraman);
              bool1 = re();
              a(paraman, true);
              if (bool1) {
                b(paraman);
              }
              a(paraman);
            }
          }
        }
        if (!(paraman instanceof h.o)) {
          break;
        }
        localObject3 = (h.o)paraman;
      } while ((((h.o)localObject3).aQR == null) || (((h.o)localObject3).aQR.isZero()) || (((h.o)localObject3).aQS == null) || (((h.o)localObject3).aQS.isZero()) || (((h.o)localObject3).aQs == null));
      if (((h.o)localObject3).aQg == null) {
        break;
      }
      paraman = ((h.o)localObject3).aQg;
      localObject2 = checkForImageDataURL(((h.o)localObject3).aQs);
      if (localObject2 != null) {
        break label3306;
      }
    } while (h.qN() == null);
    for (;;)
    {
      label397:
      label478:
      label496:
      label1264:
      if (localObject1 == null)
      {
        String.format("Could not locate image '%s'", new Object[] { ((h.o)localObject3).aQs });
        break;
        paraman = f.aPK;
        break label1264;
      }
      label672:
      localObject2 = new h.b(0.0F, 0.0F, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
      a(this.aTs, (h.al)localObject3);
      if ((!ri()) || (!visible())) {
        break;
      }
      if (((h.o)localObject3).transform != null) {
        this.aTq.concat(((h.o)localObject3).transform);
      }
      label1404:
      float f3;
      if (((h.o)localObject3).aQP != null)
      {
        f1 = ((h.o)localObject3).aQP.a(this);
        if (((h.o)localObject3).aQQ == null) {
          break label1653;
        }
        f2 = ((h.o)localObject3).aQQ.b(this);
        label1422:
        f3 = ((h.o)localObject3).aQR.a(this);
        f4 = ((h.o)localObject3).aQS.a(this);
        this.aTs.aQk = new h.b(f1, f2, f3, f4);
        if (!this.aTs.aPr.aRM.booleanValue()) {
          j(this.aTs.aQk.minX, this.aTs.aQk.minY, this.aTs.aQk.width, this.aTs.aQk.height);
        }
        ((h.o)localObject3).aSS = this.aTs.aQk;
        a((h.ak)localObject3);
        d((h.ak)localObject3);
        bool1 = re();
        rk();
        this.aTq.save();
        this.aTq.concat(a(this.aTs.aQk, (h.b)localObject2, paraman));
        if (this.aTs.aPr.aSd != h.ae.e.aSv) {
          break label1658;
        }
      }
      label1653:
      label1658:
      for (int i = 0;; i = 2)
      {
        paraman = new Paint(i);
        this.aTq.drawBitmap((Bitmap)localObject1, 0.0F, 0.0F, paraman);
        this.aTq.restore();
        if (!bool1) {
          break;
        }
        b((h.ak)localObject3);
        break;
        f1 = 0.0F;
        break label1404;
        f2 = 0.0F;
        break label1422;
      }
      if ((paraman instanceof h.v))
      {
        paraman = (h.v)paraman;
        if (paraman.aRh == null) {
          break;
        }
        a(this.aTs, paraman);
        if ((!ri()) || (!visible()) || ((!this.aTs.aTP) && (!this.aTs.aTO))) {
          break;
        }
        if (paraman.transform != null) {
          this.aTq.concat(paraman.transform);
        }
        localObject1 = new c(paraman.aRh).lP;
        if (paraman.aSS == null) {
          paraman.aSS = e((Path)localObject1);
        }
        a(paraman);
        c(paraman);
        d(paraman);
        bool1 = re();
        if (this.aTs.aTO)
        {
          ((Path)localObject1).setFillType(rj());
          a(paraman, (Path)localObject1);
        }
        if (this.aTs.aTP) {
          d((Path)localObject1);
        }
        a(paraman);
        if (!bool1) {
          break;
        }
        b(paraman);
        break;
      }
      if ((paraman instanceof h.ab))
      {
        paraman = (h.ab)paraman;
        if ((paraman.aQR == null) || (paraman.aQS == null) || (paraman.aQR.isZero()) || (paraman.aQS.isZero())) {
          break;
        }
        a(this.aTs, paraman);
        if ((!ri()) || (!visible())) {
          break;
        }
        if (paraman.transform != null) {
          this.aTq.concat(paraman.transform);
        }
        localObject1 = a(paraman);
        a(paraman);
        c(paraman);
        d(paraman);
        bool1 = re();
        if (this.aTs.aTO) {
          a(paraman, (Path)localObject1);
        }
        if (this.aTs.aTP) {
          d((Path)localObject1);
        }
        if (!bool1) {
          break;
        }
        b(paraman);
        break;
      }
      if ((paraman instanceof h.d))
      {
        paraman = (h.d)paraman;
        if ((paraman.aQz == null) || (paraman.aQz.isZero())) {
          break;
        }
        a(this.aTs, paraman);
        if ((!ri()) || (!visible())) {
          break;
        }
        if (paraman.transform != null) {
          this.aTq.concat(paraman.transform);
        }
        localObject1 = a(paraman);
        a(paraman);
        c(paraman);
        d(paraman);
        bool1 = re();
        if (this.aTs.aTO) {
          a(paraman, (Path)localObject1);
        }
        if (this.aTs.aTP) {
          d((Path)localObject1);
        }
        if (!bool1) {
          break;
        }
        b(paraman);
        break;
      }
      if ((paraman instanceof h.i))
      {
        paraman = (h.i)paraman;
        if ((paraman.aQF == null) || (paraman.aQG == null) || (paraman.aQF.isZero()) || (paraman.aQG.isZero())) {
          break;
        }
        a(this.aTs, paraman);
        if ((!ri()) || (!visible())) {
          break;
        }
        if (paraman.transform != null) {
          this.aTq.concat(paraman.transform);
        }
        localObject1 = a(paraman);
        a(paraman);
        c(paraman);
        d(paraman);
        bool1 = re();
        if (this.aTs.aTO) {
          a(paraman, (Path)localObject1);
        }
        if (this.aTs.aTP) {
          d((Path)localObject1);
        }
        if (!bool1) {
          break;
        }
        b(paraman);
        break;
      }
      if ((paraman instanceof h.q))
      {
        paraman = (h.q)paraman;
        a(this.aTs, paraman);
        if ((!ri()) || (!visible()) || (!this.aTs.aTP)) {
          break;
        }
        if (paraman.transform != null) {
          this.aTq.concat(paraman.transform);
        }
        if (paraman.aQU == null)
        {
          f1 = 0.0F;
          label2395:
          if (paraman.aQV != null) {
            break label2547;
          }
          f2 = 0.0F;
          label2404:
          if (paraman.aQW != null) {
            break label2559;
          }
          f3 = 0.0F;
          label2414:
          if (paraman.aQX != null) {
            break label2572;
          }
        }
        for (;;)
        {
          if (paraman.aSS == null) {
            paraman.aSS = new h.b(Math.min(f1, f3), Math.min(f2, f4), Math.abs(f3 - f1), Math.abs(f4 - f2));
          }
          localObject1 = new Path();
          ((Path)localObject1).moveTo(f1, f2);
          ((Path)localObject1).lineTo(f3, f4);
          a(paraman);
          c(paraman);
          d(paraman);
          bool1 = re();
          d((Path)localObject1);
          a(paraman);
          if (!bool1) {
            break;
          }
          b(paraman);
          break;
          f1 = paraman.aQU.a(this);
          break label2395;
          label2547:
          f2 = paraman.aQV.b(this);
          break label2404;
          label2559:
          f3 = paraman.aQW.a(this);
          break label2414;
          label2572:
          f4 = paraman.aQX.b(this);
        }
      }
      if ((paraman instanceof h.aa))
      {
        paraman = (h.aa)paraman;
        a(this.aTs, paraman);
        if ((!ri()) || (!visible()) || ((!this.aTs.aTP) && (!this.aTs.aTO))) {
          break;
        }
        if (paraman.transform != null) {
          this.aTq.concat(paraman.transform);
        }
        if (paraman.points.length < 2) {
          break;
        }
        localObject1 = b(paraman);
        a(paraman);
        c(paraman);
        d(paraman);
        bool1 = re();
        if (this.aTs.aTO) {
          a(paraman, (Path)localObject1);
        }
        if (this.aTs.aTP) {
          d((Path)localObject1);
        }
        a(paraman);
        if (!bool1) {
          break;
        }
        b(paraman);
        break;
      }
      if ((paraman instanceof h.z))
      {
        paraman = (h.z)paraman;
        a(this.aTs, paraman);
        if ((!ri()) || (!visible()) || ((!this.aTs.aTP) && (!this.aTs.aTO))) {
          break;
        }
        if (paraman.transform != null) {
          this.aTq.concat(paraman.transform);
        }
        if (paraman.points.length < 2) {
          break;
        }
        localObject1 = b(paraman);
        a(paraman);
        ((Path)localObject1).setFillType(rj());
        c(paraman);
        d(paraman);
        bool1 = re();
        if (this.aTs.aTO) {
          a(paraman, (Path)localObject1);
        }
        if (this.aTs.aTP) {
          d((Path)localObject1);
        }
        a(paraman);
        if (!bool1) {
          break;
        }
        b(paraman);
        break;
      }
      if (!(paraman instanceof h.aw)) {
        break;
      }
      paraman = (h.aw)paraman;
      a(this.aTs, paraman);
      if (!ri()) {
        break;
      }
      if (paraman.transform != null) {
        this.aTq.concat(paraman.transform);
      }
      label2981:
      label3003:
      label3025:
      float f5;
      if ((paraman.aTc == null) || (paraman.aTc.size() == 0))
      {
        f1 = 0.0F;
        if ((paraman.aTd != null) && (paraman.aTd.size() != 0)) {
          break label3233;
        }
        f3 = 0.0F;
        if ((paraman.aTe != null) && (paraman.aTe.size() != 0)) {
          break label3255;
        }
        f4 = 0.0F;
        f5 = f2;
        if (paraman.aTf != null)
        {
          if (paraman.aTf.size() != 0) {
            break label3277;
          }
          f5 = f2;
        }
        label3050:
        localObject1 = rh();
        f2 = f1;
        if (localObject1 != h.ae.f.aSx)
        {
          f2 = a(paraman);
          if (localObject1 != h.ae.f.aSy) {
            break label3299;
          }
        }
      }
      label3233:
      label3255:
      label3277:
      label3299:
      for (f2 = f1 - f2 / 2.0F;; f2 = f1 - f2)
      {
        if (paraman.aSS == null)
        {
          localObject1 = new h(f2, f3);
          a(paraman, (i)localObject1);
          paraman.aSS = new h.b(((h)localObject1).aTT.left, ((h)localObject1).aTT.top, ((h)localObject1).aTT.width(), ((h)localObject1).aTT.height());
        }
        a(paraman);
        c(paraman);
        d(paraman);
        bool1 = re();
        a(paraman, new e(f2 + f4, f5 + f3));
        if (!bool1) {
          break;
        }
        b(paraman);
        break;
        f1 = ((h.p)paraman.aTc.get(0)).a(this);
        break label2981;
        f3 = ((h.p)paraman.aTd.get(0)).b(this);
        break label3003;
        f4 = ((h.p)paraman.aTe.get(0)).a(this);
        break label3025;
        f5 = ((h.p)paraman.aTf.get(0)).b(this);
        break label3050;
      }
      label3306:
      localObject1 = localObject2;
    }
  }
  
  @TargetApi(19)
  private Path c(h.ak paramak, h.b paramb)
  {
    int i = 0;
    AppMethodBeat.i(213132);
    paramak = paramak.aSW.Y(this.aTs.aPr.aRV);
    if (paramak == null)
    {
      String.format("ClipPath reference '%s' not found", new Object[] { this.aTs.aPr.aRV });
      AppMethodBeat.o(213132);
      return null;
    }
    Object localObject1 = (h.e)paramak;
    this.aTt.push(this.aTs);
    this.aTs = d((h.an)localObject1);
    if ((((h.e)localObject1).aQA == null) || (((h.e)localObject1).aQA.booleanValue())) {
      i = 1;
    }
    paramak = new Matrix();
    if (i == 0)
    {
      paramak.preTranslate(paramb.minX, paramb.minY);
      paramak.preScale(paramb.width, paramb.height);
    }
    if (((h.e)localObject1).transform != null) {
      paramak.preConcat(((h.e)localObject1).transform);
    }
    paramb = new Path();
    Iterator localIterator = ((h.e)localObject1).aQH.iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (h.an)localIterator.next();
      if ((localObject2 instanceof h.ak))
      {
        localObject2 = a((h.ak)localObject2, true);
        if (localObject2 != null) {
          paramb.op((Path)localObject2, Path.Op.UNION);
        }
      }
    }
    if (this.aTs.aPr.aRV != null)
    {
      if (((h.e)localObject1).aSS == null) {
        ((h.e)localObject1).aSS = e(paramb);
      }
      localObject1 = c((h.ak)localObject1, ((h.e)localObject1).aSS);
      if (localObject1 != null) {
        paramb.op((Path)localObject1, Path.Op.INTERSECT);
      }
    }
    paramb.transform(paramak);
    this.aTs = ((g)this.aTt.pop());
    AppMethodBeat.o(213132);
    return paramb;
  }
  
  private void c(h.ak paramak)
  {
    AppMethodBeat.i(213124);
    if ((this.aTs.aPr.aRs instanceof h.u)) {
      a(true, paramak.aSS, (h.u)this.aTs.aPr.aRs);
    }
    if ((this.aTs.aPr.aRv instanceof h.u)) {
      a(false, paramak.aSS, (h.u)this.aTs.aPr.aRv);
    }
    AppMethodBeat.o(213124);
  }
  
  private void c(h.an paraman)
  {
    AppMethodBeat.i(213093);
    if (!(paraman instanceof h.al))
    {
      AppMethodBeat.o(213093);
      return;
    }
    paraman = (h.al)paraman;
    if (paraman.aST != null) {
      this.aTs.aTS = paraman.aST.booleanValue();
    }
    AppMethodBeat.o(213093);
  }
  
  private static Bitmap checkForImageDataURL(String paramString)
  {
    AppMethodBeat.i(213110);
    if (!paramString.startsWith("data:"))
    {
      AppMethodBeat.o(213110);
      return null;
    }
    if (paramString.length() < 14)
    {
      AppMethodBeat.o(213110);
      return null;
    }
    int i = paramString.indexOf(',');
    if (i < 12)
    {
      AppMethodBeat.o(213110);
      return null;
    }
    if (!";base64".equals(paramString.substring(i - 7, i)))
    {
      AppMethodBeat.o(213110);
      return null;
    }
    try
    {
      paramString = Base64.decode(paramString.substring(i + 1), 0);
      paramString = BitmapFactory.decodeByteArray(paramString, 0, paramString.length);
      AppMethodBeat.o(213110);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(213110);
    }
    return null;
  }
  
  private g d(h.an paraman)
  {
    AppMethodBeat.i(213122);
    g localg = new g();
    a(localg, h.ae.qR());
    paraman = a(paraman, localg);
    AppMethodBeat.o(213122);
    return paraman;
  }
  
  private void d(Path paramPath)
  {
    AppMethodBeat.i(213095);
    if (this.aTs.aPr.aSc == h.ae.i.aSL)
    {
      Matrix localMatrix1 = this.aTq.getMatrix();
      Path localPath = new Path();
      paramPath.transform(localMatrix1, localPath);
      this.aTq.setMatrix(new Matrix());
      paramPath = this.aTs.aTR.getShader();
      Matrix localMatrix2 = new Matrix();
      if (paramPath != null)
      {
        paramPath.getLocalMatrix(localMatrix2);
        Matrix localMatrix3 = new Matrix(localMatrix2);
        localMatrix3.postConcat(localMatrix1);
        paramPath.setLocalMatrix(localMatrix3);
      }
      this.aTq.drawPath(localPath, this.aTs.aTR);
      this.aTq.setMatrix(localMatrix1);
      if (paramPath != null) {
        paramPath.setLocalMatrix(localMatrix2);
      }
      AppMethodBeat.o(213095);
      return;
    }
    this.aTq.drawPath(paramPath, this.aTs.aTR);
    AppMethodBeat.o(213095);
  }
  
  private void d(h.ak paramak)
  {
    AppMethodBeat.i(213130);
    b(paramak, paramak.aSS);
    AppMethodBeat.o(213130);
  }
  
  private void d(h.ak paramak, h.b paramb)
  {
    AppMethodBeat.i(213134);
    Object localObject = paramak.aSW.Y(this.aTs.aPr.aRV);
    if (localObject == null)
    {
      String.format("ClipPath reference '%s' not found", new Object[] { this.aTs.aPr.aRV });
      AppMethodBeat.o(213134);
      return;
    }
    localObject = (h.e)localObject;
    if (((h.e)localObject).aQH.isEmpty())
    {
      this.aTq.clipRect(0, 0, 0, 0);
      AppMethodBeat.o(213134);
      return;
    }
    if ((((h.e)localObject).aQA == null) || (((h.e)localObject).aQA.booleanValue())) {}
    for (int i = 1; ((paramak instanceof h.m)) && (i == 0); i = 0)
    {
      String.format("<clipPath clipPathUnits=\"objectBoundingBox\"> is not supported when referenced from container elements (like %s)", new Object[] { paramak.getNodeName() });
      AppMethodBeat.o(213134);
      return;
    }
    rl();
    if (i == 0)
    {
      paramak = new Matrix();
      paramak.preTranslate(paramb.minX, paramb.minY);
      paramak.preScale(paramb.width, paramb.height);
      this.aTq.concat(paramak);
    }
    if (((h.e)localObject).transform != null) {
      this.aTq.concat(((h.e)localObject).transform);
    }
    this.aTs = d((h.an)localObject);
    d((h.ak)localObject);
    paramak = new Path();
    paramb = ((h.e)localObject).aQH.iterator();
    while (paramb.hasNext()) {
      a((h.an)paramb.next(), true, paramak, new Matrix());
    }
    this.aTq.clipPath(paramak);
    rm();
    AppMethodBeat.o(213134);
  }
  
  private static h.b e(Path paramPath)
  {
    AppMethodBeat.i(213104);
    RectF localRectF = new RectF();
    paramPath.computeBounds(localRectF, true);
    paramPath = new h.b(localRectF.left, localRectF.top, localRectF.width(), localRectF.height());
    AppMethodBeat.o(213104);
    return paramPath;
  }
  
  private static int h(int paramInt, float paramFloat)
  {
    int i = 255;
    AppMethodBeat.i(213117);
    int j = Math.round((paramInt >> 24 & 0xFF) * paramFloat);
    if (j < 0) {
      i = 0;
    }
    for (;;)
    {
      AppMethodBeat.o(213117);
      return i << 24 | 0xFFFFFF & paramInt;
      if (j <= 255) {
        i = j;
      }
    }
  }
  
  private void j(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(213118);
    float f3 = paramFloat1 + paramFloat3;
    float f4 = paramFloat2 + paramFloat4;
    float f2 = f4;
    float f1 = f3;
    paramFloat4 = paramFloat1;
    paramFloat3 = paramFloat2;
    if (this.aTs.aPr.aRN != null)
    {
      paramFloat4 = paramFloat1 + this.aTs.aPr.aRN.aQw.a(this);
      paramFloat3 = paramFloat2 + this.aTs.aPr.aRN.aQt.b(this);
      f1 = f3 - this.aTs.aPr.aRN.aQu.a(this);
      f2 = f4 - this.aTs.aPr.aRN.aQv.b(this);
    }
    this.aTq.clipRect(paramFloat4, paramFloat3, f1, f2);
    AppMethodBeat.o(213118);
  }
  
  private void qY()
  {
    AppMethodBeat.i(213083);
    this.aTs = new g();
    this.aTt = new Stack();
    a(this.aTs, h.ae.qR());
    this.aTs.aQk = null;
    this.aTs.aTS = false;
    this.aTt.push(new g(this.aTs));
    this.aTv = new Stack();
    this.aTu = new Stack();
    AppMethodBeat.o(213083);
  }
  
  private void rb()
  {
    AppMethodBeat.i(213088);
    this.aTq.save();
    this.aTt.push(this.aTs);
    this.aTs = new g(this.aTs);
    AppMethodBeat.o(213088);
  }
  
  private void rc()
  {
    AppMethodBeat.i(213089);
    this.aTq.restore();
    this.aTs = ((g)this.aTt.pop());
    AppMethodBeat.o(213089);
  }
  
  private void rd()
  {
    AppMethodBeat.i(213091);
    this.aTu.pop();
    this.aTv.pop();
    AppMethodBeat.o(213091);
  }
  
  private boolean re()
  {
    AppMethodBeat.i(213099);
    if (!rf())
    {
      AppMethodBeat.o(213099);
      return false;
    }
    this.aTq.saveLayerAlpha(null, T(this.aTs.aPr.aRD.floatValue()), 31);
    this.aTt.push(this.aTs);
    this.aTs = new g(this.aTs);
    if (this.aTs.aPr.aRX != null)
    {
      h.an localan = this.aSW.Y(this.aTs.aPr.aRX);
      if ((localan == null) || (!(localan instanceof h.s)))
      {
        String.format("Mask reference '%s' not found", new Object[] { this.aTs.aPr.aRX });
        this.aTs.aPr.aRX = null;
        AppMethodBeat.o(213099);
        return true;
      }
    }
    AppMethodBeat.o(213099);
    return true;
  }
  
  private boolean rf()
  {
    AppMethodBeat.i(213102);
    if ((this.aTs.aPr.aRD.floatValue() < 1.0F) || (this.aTs.aPr.aRX != null))
    {
      AppMethodBeat.o(213102);
      return true;
    }
    AppMethodBeat.o(213102);
    return false;
  }
  
  private static void rg()
  {
    try
    {
      AppMethodBeat.i(213103);
      HashSet localHashSet = new HashSet();
      aTw = localHashSet;
      localHashSet.add("Structure");
      aTw.add("BasicStructure");
      aTw.add("ConditionalProcessing");
      aTw.add("Image");
      aTw.add("Style");
      aTw.add("ViewportAttribute");
      aTw.add("Shape");
      aTw.add("BasicText");
      aTw.add("PaintAttribute");
      aTw.add("BasicPaintAttribute");
      aTw.add("OpacityAttribute");
      aTw.add("BasicGraphicsAttribute");
      aTw.add("Marker");
      aTw.add("Gradient");
      aTw.add("Pattern");
      aTw.add("Clip");
      aTw.add("BasicClip");
      aTw.add("Mask");
      aTw.add("View");
      AppMethodBeat.o(213103);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private h.ae.f rh()
  {
    if ((this.aTs.aPr.aRK == h.ae.h.aSH) || (this.aTs.aPr.aRL == h.ae.f.aSy)) {
      return this.aTs.aPr.aRL;
    }
    if (this.aTs.aPr.aRL == h.ae.f.aSx) {
      return h.ae.f.aSz;
    }
    return h.ae.f.aSx;
  }
  
  private boolean ri()
  {
    AppMethodBeat.i(213111);
    if (this.aTs.aPr.aRR != null)
    {
      boolean bool = this.aTs.aPr.aRR.booleanValue();
      AppMethodBeat.o(213111);
      return bool;
    }
    AppMethodBeat.o(213111);
    return true;
  }
  
  private Path.FillType rj()
  {
    if ((this.aTs.aPr.aRt != null) && (this.aTs.aPr.aRt == h.ae.a.aSf)) {
      return Path.FillType.EVEN_ODD;
    }
    return Path.FillType.WINDING;
  }
  
  private void rk()
  {
    AppMethodBeat.i(213119);
    if ((this.aTs.aPr.aSa instanceof h.f)) {}
    for (int i = ((h.f)this.aTs.aPr.aSa).aQB;; i = this.aTs.aPr.aRE.aQB)
    {
      int j = i;
      if (this.aTs.aPr.aSb != null) {
        j = h(i, this.aTs.aPr.aSb.floatValue());
      }
      this.aTq.drawColor(j);
      AppMethodBeat.o(213119);
      return;
      if (!(this.aTs.aPr.aSa instanceof h.g)) {
        break;
      }
    }
    AppMethodBeat.o(213119);
  }
  
  private void rl()
  {
    AppMethodBeat.i(213136);
    c.c(this.aTq, c.aPC);
    this.aTt.push(this.aTs);
    this.aTs = new g(this.aTs);
    AppMethodBeat.o(213136);
  }
  
  private void rm()
  {
    AppMethodBeat.i(213137);
    this.aTq.restore();
    this.aTs = ((g)this.aTt.pop());
    AppMethodBeat.o(213137);
  }
  
  private Path.FillType rn()
  {
    if ((this.aTs.aPr.aRW != null) && (this.aTs.aPr.aRW == h.ae.a.aSf)) {
      return Path.FillType.EVEN_ODD;
    }
    return Path.FillType.WINDING;
  }
  
  private boolean visible()
  {
    AppMethodBeat.i(213112);
    if (this.aTs.aPr.aRS != null)
    {
      boolean bool = this.aTs.aPr.aRS.booleanValue();
      AppMethodBeat.o(213112);
      return bool;
    }
    AppMethodBeat.o(213112);
    return true;
  }
  
  final void a(h paramh, g paramg)
  {
    AppMethodBeat.i(213085);
    this.aSW = paramh;
    h.af localaf = paramh.aQn;
    if (localaf == null)
    {
      String.format("Nothing to render. Document is empty.", new Object[0]);
      AppMethodBeat.o(213085);
      return;
    }
    Object localObject1;
    Object localObject2;
    if (paramg.qF())
    {
      localObject1 = this.aSW.Z(paramg.aQj);
      if ((localObject1 == null) || (!(localObject1 instanceof h.bf)))
      {
        String.format("View element with id \"%s\" not found.", new Object[] { paramg.aQj });
        AppMethodBeat.o(213085);
        return;
      }
      localObject1 = (h.bf)localObject1;
      if (((h.bf)localObject1).aQi == null)
      {
        String.format("View element with id \"%s\" is missing a viewBox attribute.", new Object[] { paramg.aQj });
        AppMethodBeat.o(213085);
        return;
      }
      localObject2 = ((h.bf)localObject1).aQi;
      localObject1 = ((h.bf)localObject1).aQg;
    }
    for (;;)
    {
      if (paramg.qD()) {
        paramh.b(paramg.aQf);
      }
      if (paramg.qH())
      {
        this.aTx = new b.p();
        this.aTx.aPs = paramh.Z(paramg.aQh);
      }
      qY();
      c(localaf);
      rb();
      Object localObject3 = new h.b(paramg.aQk);
      if (localaf.aQR != null) {
        ((h.b)localObject3).width = localaf.aQR.a(this, ((h.b)localObject3).width);
      }
      if (localaf.aQS != null) {
        ((h.b)localObject3).height = localaf.aQS.a(this, ((h.b)localObject3).height);
      }
      a(localaf, (h.b)localObject3, (h.b)localObject2, (f)localObject1);
      rc();
      if (paramg.qD()) {
        paramh.qM();
      }
      AppMethodBeat.o(213085);
      return;
      if (paramg.qG()) {}
      for (localObject1 = paramg.aQi;; localObject1 = localaf.aQi)
      {
        if (!paramg.qE()) {
          break label348;
        }
        localObject3 = paramg.aQg;
        localObject2 = localObject1;
        localObject1 = localObject3;
        break;
      }
      label348:
      localObject3 = localaf.aQg;
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
  }
  
  final float qZ()
  {
    AppMethodBeat.i(213084);
    float f = this.aTs.aTQ.getTextSize();
    AppMethodBeat.o(213084);
    return f;
  }
  
  final h.b ra()
  {
    if (this.aTs.aQi != null) {
      return this.aTs.aQi;
    }
    return this.aTs.aQk;
  }
  
  final class a
    implements h.x
  {
    List<i.b> aTB;
    private i.b aTC;
    private boolean aTD;
    private boolean aTE;
    private int aTF;
    private boolean aTG;
    private float mc;
    private float md;
    
    a(h.w paramw)
    {
      AppMethodBeat.i(213056);
      this.aTB = new ArrayList();
      this.aTC = null;
      this.aTD = false;
      this.aTE = true;
      this.aTF = -1;
      if (paramw == null)
      {
        AppMethodBeat.o(213056);
        return;
      }
      paramw.a(this);
      if (this.aTG)
      {
        this.aTC.a((i.b)this.aTB.get(this.aTF));
        this.aTB.set(this.aTF, this.aTC);
        this.aTG = false;
      }
      if (this.aTC != null) {
        this.aTB.add(this.aTC);
      }
      AppMethodBeat.o(213056);
    }
    
    public final void a(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean1, boolean paramBoolean2, float paramFloat4, float paramFloat5)
    {
      AppMethodBeat.i(213061);
      this.aTD = true;
      this.aTE = false;
      i.a(this.aTC.x, this.aTC.y, paramFloat1, paramFloat2, paramFloat3, paramBoolean1, paramBoolean2, paramFloat4, paramFloat5, this);
      this.aTE = true;
      this.aTG = false;
      AppMethodBeat.o(213061);
    }
    
    public final void close()
    {
      AppMethodBeat.i(213062);
      this.aTB.add(this.aTC);
      lineTo(this.mc, this.md);
      this.aTG = true;
      AppMethodBeat.o(213062);
    }
    
    public final void cubicTo(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
    {
      AppMethodBeat.i(213059);
      if ((this.aTE) || (this.aTD))
      {
        this.aTC.q(paramFloat1, paramFloat2);
        this.aTB.add(this.aTC);
        this.aTD = false;
      }
      this.aTC = new i.b(i.this, paramFloat5, paramFloat6, paramFloat5 - paramFloat3, paramFloat6 - paramFloat4);
      this.aTG = false;
      AppMethodBeat.o(213059);
    }
    
    public final void lineTo(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(213058);
      this.aTC.q(paramFloat1, paramFloat2);
      this.aTB.add(this.aTC);
      this.aTC = new i.b(i.this, paramFloat1, paramFloat2, paramFloat1 - this.aTC.x, paramFloat2 - this.aTC.y);
      this.aTG = false;
      AppMethodBeat.o(213058);
    }
    
    public final void moveTo(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(213057);
      if (this.aTG)
      {
        this.aTC.a((i.b)this.aTB.get(this.aTF));
        this.aTB.set(this.aTF, this.aTC);
        this.aTG = false;
      }
      if (this.aTC != null) {
        this.aTB.add(this.aTC);
      }
      this.mc = paramFloat1;
      this.md = paramFloat2;
      this.aTC = new i.b(i.this, paramFloat1, paramFloat2, 0.0F, 0.0F);
      this.aTF = this.aTB.size();
      AppMethodBeat.o(213057);
    }
    
    public final void quadTo(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      AppMethodBeat.i(213060);
      this.aTC.q(paramFloat1, paramFloat2);
      this.aTB.add(this.aTC);
      this.aTC = new i.b(i.this, paramFloat3, paramFloat4, paramFloat3 - paramFloat1, paramFloat4 - paramFloat2);
      this.aTG = false;
      AppMethodBeat.o(213060);
    }
  }
  
  final class b
  {
    float aTI;
    float aTJ;
    boolean aTK;
    float x;
    float y;
    
    b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      AppMethodBeat.i(213063);
      this.aTI = 0.0F;
      this.aTJ = 0.0F;
      this.aTK = false;
      this.x = paramFloat1;
      this.y = paramFloat2;
      double d = Math.sqrt(paramFloat3 * paramFloat3 + paramFloat4 * paramFloat4);
      if (d != 0.0D)
      {
        this.aTI = ((float)(paramFloat3 / d));
        this.aTJ = ((float)(paramFloat4 / d));
      }
      AppMethodBeat.o(213063);
    }
    
    final void a(b paramb)
    {
      if ((paramb.aTI == -this.aTI) && (paramb.aTJ == -this.aTJ))
      {
        this.aTK = true;
        this.aTI = (-paramb.aTJ);
        this.aTJ = paramb.aTI;
        return;
      }
      this.aTI += paramb.aTI;
      this.aTJ += paramb.aTJ;
    }
    
    final void q(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(213064);
      float f1 = paramFloat1 - this.x;
      float f2 = paramFloat2 - this.y;
      double d = Math.sqrt(f1 * f1 + f2 * f2);
      paramFloat2 = f2;
      paramFloat1 = f1;
      if (d != 0.0D)
      {
        paramFloat1 = (float)(f1 / d);
        paramFloat2 = (float)(f2 / d);
      }
      if ((paramFloat1 == -this.aTI) && (paramFloat2 == -this.aTJ))
      {
        this.aTK = true;
        this.aTI = (-paramFloat2);
        this.aTJ = paramFloat1;
        AppMethodBeat.o(213064);
        return;
      }
      this.aTI = (paramFloat1 + this.aTI);
      this.aTJ = (paramFloat2 + this.aTJ);
      AppMethodBeat.o(213064);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(213065);
      String str = "(" + this.x + "," + this.y + " " + this.aTI + "," + this.aTJ + ")";
      AppMethodBeat.o(213065);
      return str;
    }
  }
  
  protected static final class c
    implements h.x
  {
    float aTL;
    float aTM;
    Path lP;
    
    c(h.w paramw)
    {
      AppMethodBeat.i(213066);
      this.lP = new Path();
      if (paramw == null)
      {
        AppMethodBeat.o(213066);
        return;
      }
      paramw.a(this);
      AppMethodBeat.o(213066);
    }
    
    public final void a(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean1, boolean paramBoolean2, float paramFloat4, float paramFloat5)
    {
      AppMethodBeat.i(213071);
      i.a(this.aTL, this.aTM, paramFloat1, paramFloat2, paramFloat3, paramBoolean1, paramBoolean2, paramFloat4, paramFloat5, this);
      this.aTL = paramFloat4;
      this.aTM = paramFloat5;
      AppMethodBeat.o(213071);
    }
    
    public final void close()
    {
      AppMethodBeat.i(213072);
      this.lP.close();
      AppMethodBeat.o(213072);
    }
    
    public final void cubicTo(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
    {
      AppMethodBeat.i(213069);
      this.lP.cubicTo(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
      this.aTL = paramFloat5;
      this.aTM = paramFloat6;
      AppMethodBeat.o(213069);
    }
    
    public final void lineTo(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(213068);
      this.lP.lineTo(paramFloat1, paramFloat2);
      this.aTL = paramFloat1;
      this.aTM = paramFloat2;
      AppMethodBeat.o(213068);
    }
    
    public final void moveTo(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(213067);
      this.lP.moveTo(paramFloat1, paramFloat2);
      this.aTL = paramFloat1;
      this.aTM = paramFloat2;
      AppMethodBeat.o(213067);
    }
    
    public final void quadTo(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      AppMethodBeat.i(213070);
      this.lP.quadTo(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
      this.aTL = paramFloat3;
      this.aTM = paramFloat4;
      AppMethodBeat.o(213070);
    }
  }
  
  final class d
    extends i.e
  {
    private Path lP;
    
    d(Path paramPath, float paramFloat)
    {
      super(paramFloat, 0.0F);
      this.lP = paramPath;
    }
    
    public final void ab(String paramString)
    {
      AppMethodBeat.i(213073);
      if (i.d(i.this))
      {
        if (i.e(i.this).aTO) {
          i.f(i.this).drawTextOnPath(paramString, this.lP, this.x, this.y, i.e(i.this).aTQ);
        }
        if (i.e(i.this).aTP) {
          i.f(i.this).drawTextOnPath(paramString, this.lP, this.x, this.y, i.e(i.this).aTR);
        }
      }
      this.x += i.e(i.this).aTQ.measureText(paramString);
      AppMethodBeat.o(213073);
    }
  }
  
  class e
    extends i.i
  {
    float x;
    float y;
    
    e(float paramFloat1, float paramFloat2)
    {
      super((byte)0);
      this.x = paramFloat1;
      this.y = paramFloat2;
    }
    
    public void ab(String paramString)
    {
      AppMethodBeat.i(213074);
      i.ro();
      if (i.d(i.this))
      {
        if (i.e(i.this).aTO) {
          i.f(i.this).drawText(paramString, this.x, this.y, i.e(i.this).aTQ);
        }
        if (i.e(i.this).aTP) {
          i.f(i.this).drawText(paramString, this.x, this.y, i.e(i.this).aTR);
        }
      }
      this.x += i.e(i.this).aTQ.measureText(paramString);
      AppMethodBeat.o(213074);
    }
  }
  
  final class f
    extends i.i
  {
    Path aTN;
    float x;
    float y;
    
    f(float paramFloat1, float paramFloat2, Path paramPath)
    {
      super((byte)0);
      this.x = paramFloat1;
      this.y = paramFloat2;
      this.aTN = paramPath;
    }
    
    public final void ab(String paramString)
    {
      AppMethodBeat.i(213076);
      if (i.d(i.this))
      {
        Path localPath = new Path();
        i.e(i.this).aTQ.getTextPath(paramString, 0, paramString.length(), this.x, this.y, localPath);
        this.aTN.addPath(localPath);
      }
      this.x += i.e(i.this).aTQ.measureText(paramString);
      AppMethodBeat.o(213076);
    }
    
    public final boolean b(h.ay paramay)
    {
      AppMethodBeat.i(213075);
      if ((paramay instanceof h.az))
      {
        i.g("Using <textPath> elements in a clip path is not supported.", new Object[0]);
        AppMethodBeat.o(213075);
        return false;
      }
      AppMethodBeat.o(213075);
      return true;
    }
  }
  
  final class g
  {
    h.ae aPr;
    h.b aQi;
    h.b aQk;
    boolean aTO;
    boolean aTP;
    Paint aTQ;
    Paint aTR;
    boolean aTS;
    
    g()
    {
      AppMethodBeat.i(213077);
      this.aTQ = new Paint();
      this.aTQ.setFlags(193);
      if (Build.VERSION.SDK_INT >= 14) {
        this.aTQ.setHinting(0);
      }
      this.aTQ.setStyle(Paint.Style.FILL);
      this.aTQ.setTypeface(Typeface.DEFAULT);
      this.aTR = new Paint();
      this.aTR.setFlags(193);
      if (Build.VERSION.SDK_INT >= 14) {
        this.aTR.setHinting(0);
      }
      this.aTR.setStyle(Paint.Style.STROKE);
      this.aTR.setTypeface(Typeface.DEFAULT);
      this.aPr = h.ae.qR();
      AppMethodBeat.o(213077);
    }
    
    g(g paramg)
    {
      AppMethodBeat.i(213078);
      this.aTO = paramg.aTO;
      this.aTP = paramg.aTP;
      this.aTQ = new Paint(paramg.aTQ);
      this.aTR = new Paint(paramg.aTR);
      if (paramg.aQk != null) {
        this.aQk = new h.b(paramg.aQk);
      }
      if (paramg.aQi != null) {
        this.aQi = new h.b(paramg.aQi);
      }
      this.aTS = paramg.aTS;
      try
      {
        this.aPr = ((h.ae)paramg.aPr.clone());
        AppMethodBeat.o(213078);
        return;
      }
      catch (CloneNotSupportedException this$1)
      {
        this.aPr = h.ae.qR();
        AppMethodBeat.o(213078);
      }
    }
  }
  
  final class h
    extends i.i
  {
    RectF aTT;
    float x;
    float y;
    
    h(float paramFloat1, float paramFloat2)
    {
      super((byte)0);
      AppMethodBeat.i(213079);
      this.aTT = new RectF();
      this.x = paramFloat1;
      this.y = paramFloat2;
      AppMethodBeat.o(213079);
    }
    
    public final void ab(String paramString)
    {
      AppMethodBeat.i(213081);
      if (i.d(i.this))
      {
        Object localObject = new Rect();
        i.e(i.this).aTQ.getTextBounds(paramString, 0, paramString.length(), (Rect)localObject);
        localObject = new RectF((Rect)localObject);
        ((RectF)localObject).offset(this.x, this.y);
        this.aTT.union((RectF)localObject);
      }
      this.x += i.e(i.this).aTQ.measureText(paramString);
      AppMethodBeat.o(213081);
    }
    
    public final boolean b(h.ay paramay)
    {
      AppMethodBeat.i(213080);
      if ((paramay instanceof h.az))
      {
        Object localObject = (h.az)paramay;
        paramay = paramay.aSW.Y(((h.az)localObject).aQs);
        if (paramay == null)
        {
          i.f("TextPath path reference '%s' not found", new Object[] { ((h.az)localObject).aQs });
          AppMethodBeat.o(213080);
          return false;
        }
        localObject = (h.v)paramay;
        paramay = new i.c(((h.v)localObject).aRh).lP;
        if (((h.v)localObject).transform != null) {
          paramay.transform(((h.v)localObject).transform);
        }
        localObject = new RectF();
        paramay.computeBounds((RectF)localObject, true);
        this.aTT.union((RectF)localObject);
        AppMethodBeat.o(213080);
        return false;
      }
      AppMethodBeat.o(213080);
      return true;
    }
  }
  
  abstract class i
  {
    private i() {}
    
    public abstract void ab(String paramString);
    
    public boolean b(h.ay paramay)
    {
      return true;
    }
  }
  
  final class j
    extends i.i
  {
    float x = 0.0F;
    
    private j()
    {
      super((byte)0);
    }
    
    public final void ab(String paramString)
    {
      AppMethodBeat.i(213082);
      this.x += i.e(i.this).aTQ.measureText(paramString);
      AppMethodBeat.o(213082);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.a.a.i
 * JD-Core Version:    0.7.0.1
 */