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
  private static HashSet<String> aTo = null;
  private h aSO;
  private Canvas aTi;
  float aTj;
  g aTk;
  private Stack<g> aTl;
  private Stack<h.aj> aTm;
  private Stack<Matrix> aTn;
  private b.p aTp = null;
  
  i(Canvas paramCanvas, float paramFloat)
  {
    this.aTi = paramCanvas;
    this.aTj = paramFloat;
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
    AppMethodBeat.i(206603);
    j localj = new j((byte)0);
    a(paramay, localj);
    float f = localj.x;
    AppMethodBeat.o(206603);
    return f;
  }
  
  private static Matrix a(h.b paramb1, h.b paramb2, f paramf)
  {
    AppMethodBeat.i(206609);
    Matrix localMatrix = new Matrix();
    if ((paramf == null) || (paramf.aPz == null))
    {
      AppMethodBeat.o(206609);
      return localMatrix;
    }
    float f2 = paramb1.width / paramb2.width;
    float f3 = paramb1.height / paramb2.height;
    float f1 = -paramb2.minX;
    float f4 = -paramb2.minY;
    if (paramf.equals(f.aPC))
    {
      localMatrix.preTranslate(paramb1.minX, paramb1.minY);
      localMatrix.preScale(f2, f3);
      localMatrix.preTranslate(f1, f4);
      AppMethodBeat.o(206609);
      return localMatrix;
    }
    float f5;
    if (paramf.aPA == f.b.aPW)
    {
      f3 = Math.max(f2, f3);
      f2 = paramb1.width / f3;
      f5 = paramb1.height / f3;
      switch (1.aTq[paramf.aPz.ordinal()])
      {
      default: 
        label204:
        f2 = f4;
        switch (1.aTq[paramf.aPz.ordinal()])
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
      AppMethodBeat.o(206609);
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
    AppMethodBeat.i(206638);
    float f1;
    float f2;
    float f3;
    float f4;
    label71:
    label87:
    float f5;
    float f6;
    if ((paramab.aQx == null) && (paramab.aQy == null))
    {
      f1 = 0.0F;
      f2 = 0.0F;
      f3 = Math.min(f2, paramab.aQJ.a(this) / 2.0F);
      f4 = Math.min(f1, paramab.aQK.b(this) / 2.0F);
      if (paramab.aQH == null) {
        break label273;
      }
      f1 = paramab.aQH.a(this);
      if (paramab.aQI == null) {
        break label278;
      }
      f2 = paramab.aQI.b(this);
      f5 = paramab.aQJ.a(this);
      f6 = paramab.aQK.b(this);
      if (paramab.aSK == null) {
        paramab.aSK = new h.b(f1, f2, f5, f6);
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
      AppMethodBeat.o(206638);
      return paramab;
      if (paramab.aQx == null)
      {
        f2 = paramab.aQy.b(this);
        f1 = f2;
        break;
      }
      if (paramab.aQy == null)
      {
        f2 = paramab.aQx.a(this);
        f1 = f2;
        break;
      }
      f2 = paramab.aQx.a(this);
      f1 = paramab.aQy.b(this);
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
    AppMethodBeat.i(206629);
    this.aTl.push(this.aTk);
    this.aTk = new g(this.aTk);
    a(this.aTk, paramak);
    if ((!rl()) || (!visible()))
    {
      this.aTk = ((g)this.aTl.pop());
      AppMethodBeat.o(206629);
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
      localObject1 = paramak.aSO.Z(((h.be)localObject3).aQk);
      if (localObject1 == null)
      {
        String.format("Use reference '%s' not found", new Object[] { ((h.be)localObject3).aQk });
        this.aTk = ((g)this.aTl.pop());
        AppMethodBeat.o(206629);
        return null;
      }
      if (!(localObject1 instanceof h.ak))
      {
        this.aTk = ((g)this.aTl.pop());
        AppMethodBeat.o(206629);
        return null;
      }
      localObject2 = a((h.ak)localObject1, false);
      if (localObject2 == null)
      {
        AppMethodBeat.o(206629);
        return null;
      }
      if (((h.be)localObject3).aSK == null) {
        ((h.be)localObject3).aSK = e((Path)localObject2);
      }
      localObject1 = localObject2;
      if (((h.be)localObject3).transform != null)
      {
        ((Path)localObject2).transform(((h.be)localObject3).transform);
        localObject1 = localObject2;
      }
      if (this.aTk.aPk.aRN != null)
      {
        paramak = c(paramak, paramak.aSK);
        if (paramak != null) {
          ((Path)localObject1).op(paramak, Path.Op.INTERSECT);
        }
      }
      this.aTk = ((g)this.aTl.pop());
      AppMethodBeat.o(206629);
      return localObject1;
    }
    if ((paramak instanceof h.l))
    {
      localObject3 = (h.l)paramak;
      if ((paramak instanceof h.v))
      {
        localObject2 = new c(((h.v)paramak).aQZ).lR;
        localObject1 = localObject2;
        if (paramak.aSK == null)
        {
          paramak.aSK = e((Path)localObject2);
          localObject1 = localObject2;
        }
      }
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        AppMethodBeat.o(206629);
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
        if (((h.l)localObject3).aSK == null) {
          ((h.l)localObject3).aSK = e((Path)localObject1);
        }
        if (((h.l)localObject3).transform != null) {
          ((Path)localObject1).transform(((h.l)localObject3).transform);
        }
        ((Path)localObject1).setFillType(rq());
        break;
        if ((paramak instanceof h.aw))
        {
          localObject2 = (h.aw)paramak;
          localObject1 = a((h.aw)localObject2);
          if (((h.aw)localObject2).transform != null) {
            ((Path)localObject1).transform(((h.aw)localObject2).transform);
          }
          ((Path)localObject1).setFillType(rq());
          break;
        }
        String.format("Invalid %s element found in clipPath definition", new Object[] { paramak.getNodeName() });
        AppMethodBeat.o(206629);
        return null;
      }
      localObject1 = null;
    }
  }
  
  private Path a(h.aw paramaw)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(206642);
    float f1;
    float f3;
    label51:
    float f4;
    label73:
    float f5;
    if ((paramaw.aSU == null) || (paramaw.aSU.size() == 0))
    {
      f1 = 0.0F;
      if ((paramaw.aSV != null) && (paramaw.aSV.size() != 0)) {
        break label277;
      }
      f3 = 0.0F;
      if ((paramaw.aSW != null) && (paramaw.aSW.size() != 0)) {
        break label299;
      }
      f4 = 0.0F;
      f5 = f2;
      if (paramaw.aSX != null)
      {
        if (paramaw.aSX.size() != 0) {
          break label321;
        }
        f5 = f2;
      }
      label98:
      f2 = f1;
      if (this.aTk.aPk.aRD != h.ae.f.aSp)
      {
        f2 = a(paramaw);
        if (this.aTk.aPk.aRD != h.ae.f.aSq) {
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
      if (paramaw.aSK == null)
      {
        localObject = new h(f2, f3);
        a(paramaw, (i)localObject);
        paramaw.aSK = new h.b(((h)localObject).aTL.left, ((h)localObject).aTL.top, ((h)localObject).aTL.width(), ((h)localObject).aTL.height());
      }
      Object localObject = new Path();
      a(paramaw, new f(f2 + f4, f5 + f3, (Path)localObject));
      AppMethodBeat.o(206642);
      return localObject;
      f1 = ((h.p)paramaw.aSU.get(0)).a(this);
      break;
      f3 = ((h.p)paramaw.aSV.get(0)).b(this);
      break label51;
      f4 = ((h.p)paramaw.aSW.get(0)).a(this);
      break label73;
      f5 = ((h.p)paramaw.aSX.get(0)).b(this);
      break label98;
    }
  }
  
  private Path a(h.d paramd)
  {
    AppMethodBeat.i(206639);
    float f1;
    if (paramd.aQp != null)
    {
      f1 = paramd.aQp.a(this);
      if (paramd.aQq == null) {
        break label217;
      }
    }
    label217:
    for (float f2 = paramd.aQq.b(this);; f2 = 0.0F)
    {
      float f7 = paramd.aQr.c(this);
      float f3 = f1 - f7;
      float f4 = f2 - f7;
      float f5 = f1 + f7;
      float f6 = f2 + f7;
      if (paramd.aSK == null) {
        paramd.aSK = new h.b(f3, f4, 2.0F * f7, 2.0F * f7);
      }
      f7 *= 0.5522848F;
      paramd = new Path();
      paramd.moveTo(f1, f4);
      paramd.cubicTo(f1 + f7, f4, f5, f2 - f7, f5, f2);
      paramd.cubicTo(f5, f2 + f7, f1 + f7, f6, f1, f6);
      paramd.cubicTo(f1 - f7, f6, f3, f2 + f7, f3, f2);
      paramd.cubicTo(f3, f2 - f7, f1 - f7, f4, f1, f4);
      paramd.close();
      AppMethodBeat.o(206639);
      return paramd;
      f1 = 0.0F;
      break;
    }
  }
  
  private Path a(h.i parami)
  {
    AppMethodBeat.i(206640);
    float f1;
    if (parami.aQp != null)
    {
      f1 = parami.aQp.a(this);
      if (parami.aQq == null) {
        break label234;
      }
    }
    label234:
    for (float f2 = parami.aQq.b(this);; f2 = 0.0F)
    {
      float f8 = parami.aQx.a(this);
      float f7 = parami.aQy.b(this);
      float f3 = f1 - f8;
      float f4 = f2 - f7;
      float f5 = f1 + f8;
      float f6 = f2 + f7;
      if (parami.aSK == null) {
        parami.aSK = new h.b(f3, f4, 2.0F * f8, 2.0F * f7);
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
      AppMethodBeat.o(206640);
      return parami;
      f1 = 0.0F;
      break;
    }
  }
  
  private static Typeface a(String paramString, Integer paramInteger, h.ae.b paramb)
  {
    int k = 0;
    AppMethodBeat.i(206612);
    int i;
    int j;
    if (paramb == h.ae.b.aSa)
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
      AppMethodBeat.o(206612);
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
    AppMethodBeat.i(206593);
    float f1;
    float f3;
    if (paramp1 != null)
    {
      f1 = paramp1.a(this);
      if (paramp2 != null) {
        f2 = paramp2.b(this);
      }
      paramp1 = rd();
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
      AppMethodBeat.o(206593);
      return paramp1;
      f1 = 0.0F;
      break;
      f3 = paramp1.width;
      break label47;
    }
  }
  
  private g a(h.an paraman, g paramg)
  {
    AppMethodBeat.i(206619);
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      if ((paraman instanceof h.al)) {
        localArrayList.add(0, (h.al)paraman);
      }
      if (paraman.aSP == null) {
        break;
      }
      paraman = (h.an)paraman.aSP;
    }
    paraman = localArrayList.iterator();
    while (paraman.hasNext()) {
      a(paramg, (h.al)paraman.next());
    }
    paramg.aQb = this.aTk.aQb;
    paramg.aQc = this.aTk.aQc;
    AppMethodBeat.o(206619);
    return paramg;
  }
  
  private String a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(206605);
    if (this.aTk.aTK)
    {
      paramString = paramString.replaceAll("[\\n\\t]", " ");
      AppMethodBeat.o(206605);
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
    AppMethodBeat.o(206605);
    return paramString;
  }
  
  private List<b> a(h.z paramz)
  {
    int i = 2;
    AppMethodBeat.i(206601);
    int j = paramz.points.length;
    if (j < 2)
    {
      AppMethodBeat.o(206601);
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
      AppMethodBeat.o(206601);
      return localArrayList;
      localArrayList.add(localb);
    }
  }
  
  private void a(h.af paramaf, h.b paramb1, h.b paramb2, f paramf)
  {
    AppMethodBeat.i(206592);
    if ((paramb1.width == 0.0F) || (paramb1.height == 0.0F))
    {
      AppMethodBeat.o(206592);
      return;
    }
    if (paramf == null) {
      if (paramaf.aPZ != null) {
        paramf = paramaf.aPZ;
      }
    }
    for (;;)
    {
      a(this.aTk, paramaf);
      if (!rl())
      {
        AppMethodBeat.o(206592);
        return;
        paramf = f.aPD;
      }
      else
      {
        this.aTk.aQc = paramb1;
        if (!this.aTk.aPk.aRE.booleanValue()) {
          j(this.aTk.aQc.minX, this.aTk.aQc.minY, this.aTk.aQc.width, this.aTk.aQc.height);
        }
        b(paramaf, this.aTk.aQc);
        if (paramb2 != null)
        {
          this.aTi.concat(a(this.aTk.aQc, paramb2, paramf));
          this.aTk.aQb = paramaf.aQb;
        }
        for (;;)
        {
          boolean bool = rh();
          rn();
          a(paramaf, true);
          if (bool) {
            b(paramaf);
          }
          a(paramaf);
          AppMethodBeat.o(206592);
          return;
          this.aTi.translate(this.aTk.aQc.minX, this.aTk.aQc.minY);
        }
      }
    }
  }
  
  private void a(h.aj paramaj)
  {
    AppMethodBeat.i(206586);
    this.aTm.push(paramaj);
    this.aTn.push(this.aTi.getMatrix());
    AppMethodBeat.o(206586);
  }
  
  private void a(h.aj paramaj, boolean paramBoolean)
  {
    AppMethodBeat.i(206583);
    if (paramBoolean) {
      a(paramaj);
    }
    paramaj = paramaj.getChildren().iterator();
    while (paramaj.hasNext()) {
      b((h.an)paramaj.next());
    }
    if (paramBoolean) {
      rg();
    }
    AppMethodBeat.o(206583);
  }
  
  private void a(h.ak paramak)
  {
    AppMethodBeat.i(206594);
    if (paramak.aSP == null)
    {
      AppMethodBeat.o(206594);
      return;
    }
    if (paramak.aSK == null)
    {
      AppMethodBeat.o(206594);
      return;
    }
    Matrix localMatrix = new Matrix();
    if (((Matrix)this.aTn.peek()).invert(localMatrix))
    {
      Object localObject = new float[8];
      localObject[0] = paramak.aSK.minX;
      localObject[1] = paramak.aSK.minY;
      localObject[2] = paramak.aSK.qR();
      localObject[3] = paramak.aSK.minY;
      localObject[4] = paramak.aSK.qR();
      localObject[5] = paramak.aSK.qS();
      localObject[6] = paramak.aSK.minX;
      localObject[7] = paramak.aSK.qS();
      localMatrix.preConcat(this.aTi.getMatrix());
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
      localObject = (h.ak)this.aTm.peek();
      if (((h.ak)localObject).aSK == null)
      {
        ((h.ak)localObject).aSK = h.b.i(paramak.left, paramak.top, paramak.right, paramak.bottom);
        AppMethodBeat.o(206594);
        return;
      }
      ((h.ak)localObject).aSK.a(h.b.i(paramak.left, paramak.top, paramak.right, paramak.bottom));
    }
    AppMethodBeat.o(206594);
  }
  
  private void a(h.ak paramak, Path paramPath)
  {
    AppMethodBeat.i(206590);
    if ((this.aTk.aPk.aRk instanceof h.u))
    {
      h.an localan = this.aSO.Z(((h.u)this.aTk.aPk.aRk).aQk);
      if ((localan instanceof h.y))
      {
        a(paramak, paramPath, (h.y)localan);
        AppMethodBeat.o(206590);
        return;
      }
    }
    this.aTi.drawPath(paramPath, this.aTk.aTI);
    AppMethodBeat.o(206590);
  }
  
  private void a(h.ak paramak, Path paramPath, h.y paramy)
  {
    AppMethodBeat.i(206643);
    int i;
    float f1;
    label63:
    float f2;
    label80:
    float f3;
    if ((paramy.aRf != null) && (paramy.aRf.booleanValue()))
    {
      i = 1;
      if (paramy.aQk != null) {
        a(paramy, paramy.aQk);
      }
      if (i == 0) {
        break label189;
      }
      if (paramy.aQH == null) {
        break label165;
      }
      f1 = paramy.aQH.a(this);
      if (paramy.aQI == null) {
        break label171;
      }
      f2 = paramy.aQI.b(this);
      if (paramy.aQJ == null) {
        break label177;
      }
      f3 = paramy.aQJ.a(this);
      label97:
      if (paramy.aQK == null) {
        break label183;
      }
    }
    label165:
    label171:
    label177:
    label183:
    for (float f4 = paramy.aQK.b(this);; f4 = 0.0F)
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
      AppMethodBeat.o(206643);
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
    if (paramy.aQH != null)
    {
      f1 = paramy.aQH.a(this, 1.0F);
      label207:
      if (paramy.aQI == null) {
        break label366;
      }
      f2 = paramy.aQI.a(this, 1.0F);
      label225:
      if (paramy.aQJ == null) {
        break label372;
      }
      f3 = paramy.aQJ.a(this, 1.0F);
      label243:
      if (paramy.aQK == null) {
        break label378;
      }
    }
    label366:
    label372:
    label378:
    for (f4 = paramy.aQK.a(this, 1.0F);; f4 = 0.0F)
    {
      f6 = paramak.aSK.minX;
      f7 = paramak.aSK.width;
      f8 = paramak.aSK.minY;
      float f9 = paramak.aSK.height;
      float f10 = paramak.aSK.width;
      f5 = f4 * paramak.aSK.height;
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
    if (paramy.aPZ != null) {}
    Object localObject;
    for (f localf = paramy.aPZ;; localf = f.aPD)
    {
      re();
      this.aTi.clipPath(paramPath);
      paramPath = new g();
      a(paramPath, h.ae.qU());
      paramPath.aPk.aRE = Boolean.FALSE;
      this.aTk = a(paramy, paramPath);
      localObject = paramak.aSK;
      paramPath = (Path)localObject;
      if (paramy.aRh == null) {
        break label775;
      }
      this.aTi.concat(paramy.aRh);
      Matrix localMatrix = new Matrix();
      paramPath = (Path)localObject;
      if (!paramy.aRh.invert(localMatrix)) {
        break label775;
      }
      paramPath = new float[8];
      paramPath[0] = paramak.aSK.minX;
      paramPath[1] = paramak.aSK.minY;
      paramPath[2] = paramak.aSK.qR();
      paramPath[3] = paramak.aSK.minY;
      paramPath[4] = paramak.aSK.qR();
      paramPath[5] = paramak.aSK.qS();
      paramPath[6] = paramak.aSK.minX;
      paramPath[7] = paramak.aSK.qS();
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
    float f7 = paramPath.qR();
    float f8 = paramPath.qS();
    paramPath = new h.b(0.0F, 0.0F, f2, f1);
    boolean bool = rh();
    for (f4 = f5 * f1 + f4; f4 < f8; f4 += f1) {
      for (f5 = f3 + f6 * f2; f5 < f7; f5 += f2)
      {
        paramPath.minX = f5;
        paramPath.minY = f4;
        re();
        if (!this.aTk.aPk.aRE.booleanValue()) {
          j(paramPath.minX, paramPath.minY, paramPath.width, paramPath.height);
        }
        if (paramy.aQb != null)
        {
          this.aTi.concat(a(paramPath, paramy.aQb, localf));
          localObject = paramy.aQz.iterator();
          while (((Iterator)localObject).hasNext()) {
            b((h.an)((Iterator)localObject).next());
          }
        }
        if ((paramy.aRg == null) || (paramy.aRg.booleanValue())) {}
        for (i = 1;; i = 0)
        {
          this.aTi.translate(f5, f4);
          if (i != 0) {
            break;
          }
          this.aTi.scale(paramak.aSK.width, paramak.aSK.height);
          break;
        }
        rf();
      }
    }
    if (bool) {
      b(paramy);
    }
    rf();
    AppMethodBeat.o(206643);
  }
  
  private void a(h.ak paramak, h.b paramb)
  {
    AppMethodBeat.i(206597);
    if (this.aTk.aPk.aRP != null)
    {
      Object localObject = new Paint();
      ((Paint)localObject).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
      this.aTi.saveLayer(null, (Paint)localObject, 31);
      localObject = new Paint();
      ((Paint)localObject).setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2127F, 0.7151F, 0.0722F, 0.0F, 0.0F })));
      this.aTi.saveLayer(null, (Paint)localObject, 31);
      localObject = this.aSO.Z(this.aTk.aPk.aRP);
      a((h.s)localObject, paramak, paramb);
      this.aTi.restore();
      Paint localPaint = new Paint();
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
      this.aTi.saveLayer(null, localPaint, 31);
      a((h.s)localObject, paramak, paramb);
      this.aTi.restore();
      this.aTi.restore();
    }
    rf();
    AppMethodBeat.o(206597);
  }
  
  private static void a(h.am paramam1, h.am paramam2)
  {
    if (paramam1.aQM == null) {
      paramam1.aQM = paramam2.aQM;
    }
    if (paramam1.aQN == null) {
      paramam1.aQN = paramam2.aQN;
    }
    if (paramam1.aQO == null) {
      paramam1.aQO = paramam2.aQO;
    }
    if (paramam1.aQP == null) {
      paramam1.aQP = paramam2.aQP;
    }
  }
  
  private void a(h.an paraman, boolean paramBoolean, Path paramPath, Matrix paramMatrix)
  {
    AppMethodBeat.i(206631);
    if (!rl())
    {
      AppMethodBeat.o(206631);
      return;
    }
    ro();
    if ((paraman instanceof h.be)) {
      if (paramBoolean) {
        a((h.be)paraman, paramPath, paramMatrix);
      }
    }
    for (;;)
    {
      rp();
      AppMethodBeat.o(206631);
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
    if (paramaq1.aQp == null) {
      paramaq1.aQp = paramaq2.aQp;
    }
    if (paramaq1.aQq == null) {
      paramaq1.aQq = paramaq2.aQq;
    }
    if (paramaq1.aQr == null) {
      paramaq1.aQr = paramaq2.aQr;
    }
    if (paramaq1.aSQ == null) {
      paramaq1.aSQ = paramaq2.aSQ;
    }
    if (paramaq1.aSR == null) {
      paramaq1.aSR = paramaq2.aSR;
    }
  }
  
  private void a(h.aw paramaw, Path paramPath, Matrix paramMatrix)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(206637);
    a(this.aTk, paramaw);
    if (!rl())
    {
      AppMethodBeat.o(206637);
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
    if ((paramaw.aSU == null) || (paramaw.aSU.size() == 0))
    {
      f1 = 0.0F;
      if ((paramaw.aSV != null) && (paramaw.aSV.size() != 0)) {
        break label347;
      }
      f3 = 0.0F;
      if ((paramaw.aSW != null) && (paramaw.aSW.size() != 0)) {
        break label369;
      }
      f4 = 0.0F;
      f5 = f2;
      if (paramaw.aSX != null)
      {
        if (paramaw.aSX.size() != 0) {
          break label391;
        }
        f5 = f2;
      }
      label141:
      f2 = f1;
      if (this.aTk.aPk.aRD != h.ae.f.aSp)
      {
        f2 = a(paramaw);
        if (this.aTk.aPk.aRD != h.ae.f.aSq) {
          break label413;
        }
      }
    }
    label391:
    label413:
    for (f2 = f1 - f2 / 2.0F;; f2 = f1 - f2)
    {
      if (paramaw.aSK == null)
      {
        localObject = new h(f2, f3);
        a(paramaw, (i)localObject);
        paramaw.aSK = new h.b(((h)localObject).aTL.left, ((h)localObject).aTL.top, ((h)localObject).aTL.width(), ((h)localObject).aTL.height());
      }
      d(paramaw);
      Object localObject = new Path();
      a(paramaw, new f(f2 + f4, f5 + f3, (Path)localObject));
      paramPath.setFillType(rq());
      paramPath.addPath((Path)localObject, paramMatrix);
      AppMethodBeat.o(206637);
      return;
      f1 = ((h.p)paramaw.aSU.get(0)).a(this);
      break;
      label347:
      f3 = ((h.p)paramaw.aSV.get(0)).b(this);
      break label92;
      label369:
      f4 = ((h.p)paramaw.aSW.get(0)).a(this);
      break label114;
      f5 = ((h.p)paramaw.aSX.get(0)).b(this);
      break label141;
    }
  }
  
  private void a(h.ay paramay, i parami)
  {
    AppMethodBeat.i(206602);
    if (!rl())
    {
      AppMethodBeat.o(206602);
      return;
    }
    paramay = paramay.aQz.iterator();
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
          parami.ac(a((String)localObject1, bool1, bool2));
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
          re();
          localObject1 = (h.az)localObject2;
          a(this.aTk, (h.al)localObject1);
          if ((rl()) && (visible()))
          {
            localObject2 = ((h.az)localObject1).aSO.Z(((h.az)localObject1).aQk);
            if (localObject2 != null) {
              break label210;
            }
            String.format("TextPath reference '%s' not found", new Object[] { ((h.az)localObject1).aQk });
          }
          rf();
        }
      }
      Object localObject3 = (h.v)localObject2;
      localObject2 = new c(((h.v)localObject3).aQZ).lR;
      if (((h.v)localObject3).transform != null) {
        ((Path)localObject2).transform(((h.v)localObject3).transform);
      }
      localObject3 = new PathMeasure((Path)localObject2, false);
      if (((h.az)localObject1).aST != null)
      {
        f1 = ((h.az)localObject1).aST.a(this, ((PathMeasure)localObject3).getLength());
        label287:
        localObject3 = rk();
        if (localObject3 == h.ae.f.aSp) {
          break label938;
        }
        f2 = a((h.ay)localObject1);
        if (localObject3 != h.ae.f.aSq) {
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
      c((h.ak)((h.az)localObject1).aSS);
      bool1 = rh();
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
        re();
        localObject1 = (h.av)localObject2;
        a(this.aTk, (h.al)localObject1);
        if (rl())
        {
          f1 = 0.0F;
          f4 = 0.0F;
          f2 = 0.0F;
          if ((((h.av)localObject1).aSU == null) || (((h.av)localObject1).aSU.size() <= 0)) {
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
          if ((((h.av)localObject1).aSV != null) && (((h.av)localObject1).aSV.size() != 0)) {
            break label707;
          }
          f3 = ((e)parami).y;
          if ((((h.av)localObject1).aSW != null) && (((h.av)localObject1).aSW.size() != 0)) {
            break label730;
          }
          f2 = 0.0F;
          if ((((h.av)localObject1).aSX != null) && (((h.av)localObject1).aSX.size() != 0)) {
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
          localObject2 = rk();
          if (localObject2 != h.ae.f.aSp)
          {
            f5 = a((h.ay)localObject1);
            if (localObject2 == h.ae.f.aSq) {
              f1 -= f5 / 2.0F;
            }
          }
        }
        for (;;)
        {
          c((h.ak)((h.av)localObject1).aSS);
          if ((parami instanceof e))
          {
            ((e)parami).x = (f1 + f2);
            ((e)parami).y = (f4 + f3);
          }
          bool1 = rh();
          a((h.ay)localObject1, parami);
          if (bool1) {
            b((h.ak)localObject1);
          }
          rf();
          break;
          i = 0;
          break label454;
          label685:
          f1 = ((h.p)((h.av)localObject1).aSU.get(0)).a(this);
          break label474;
          label707:
          f3 = ((h.p)((h.av)localObject1).aSV.get(0)).b(this);
          break label504;
          label730:
          f2 = ((h.p)((h.av)localObject1).aSW.get(0)).a(this);
          break label528;
          label753:
          f4 = ((h.p)((h.av)localObject1).aSX.get(0)).b(this);
          break label552;
          f1 -= f5;
          continue;
          if (!(localObject2 instanceof h.au)) {
            break;
          }
          re();
          localObject1 = (h.au)localObject2;
          a(this.aTk, (h.al)localObject1);
          if (!rl()) {
            break label203;
          }
          c((h.ak)((h.au)localObject1).aSS);
          localObject2 = ((h.an)localObject2).aSO.Z(((h.au)localObject1).aQk);
          if ((localObject2 != null) && ((localObject2 instanceof h.ay)))
          {
            localObject1 = new StringBuilder();
            a((h.ay)localObject2, (StringBuilder)localObject1);
            if (((StringBuilder)localObject1).length() <= 0) {
              break label203;
            }
            parami.ac(((StringBuilder)localObject1).toString());
            break label203;
          }
          String.format("Tref reference '%s' not found", new Object[] { ((h.au)localObject1).aQk });
          break label203;
          AppMethodBeat.o(206602);
          return;
        }
      }
    }
  }
  
  private void a(h.ay paramay, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(206604);
    paramay = paramay.aQz.iterator();
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
    AppMethodBeat.o(206604);
  }
  
  private void a(h.be parambe, Path paramPath, Matrix paramMatrix)
  {
    AppMethodBeat.i(206636);
    a(this.aTk, parambe);
    if (!rl())
    {
      AppMethodBeat.o(206636);
      return;
    }
    if (!visible())
    {
      AppMethodBeat.o(206636);
      return;
    }
    if (parambe.transform != null) {
      paramMatrix.preConcat(parambe.transform);
    }
    h.an localan = parambe.aSO.Z(parambe.aQk);
    if (localan == null)
    {
      String.format("Use reference '%s' not found", new Object[] { parambe.aQk });
      AppMethodBeat.o(206636);
      return;
    }
    d(parambe);
    a(localan, false, paramPath, paramMatrix);
    AppMethodBeat.o(206636);
  }
  
  private static void a(h.j paramj, String paramString)
  {
    AppMethodBeat.i(206624);
    for (;;)
    {
      h.an localan = paramj.aSO.Z(paramString);
      if (localan == null)
      {
        String.format("Gradient reference '%s' not found", new Object[] { paramString });
        AppMethodBeat.o(206624);
        return;
      }
      if (!(localan instanceof h.j))
      {
        String.format("Gradient href attributes must point to other gradient elements", new Object[0]);
        AppMethodBeat.o(206624);
        return;
      }
      if (localan == paramj)
      {
        String.format("Circular reference in gradient href attribute '%s'", new Object[] { paramString });
        AppMethodBeat.o(206624);
        return;
      }
      paramString = (h.j)localan;
      if (paramj.aQA == null) {
        paramj.aQA = paramString.aQA;
      }
      if (paramj.aQB == null) {
        paramj.aQB = paramString.aQB;
      }
      if (paramj.aQC == null) {
        paramj.aQC = paramString.aQC;
      }
      if (paramj.aQz.isEmpty()) {
        paramj.aQz = paramString.aQz;
      }
      try
      {
        if ((paramj instanceof h.am)) {
          a((h.am)paramj, (h.am)localan);
        }
        for (;;)
        {
          label181:
          if (paramString.aQk == null) {
            break label214;
          }
          paramString = paramString.aQk;
          break;
          a((h.aq)paramj, (h.aq)localan);
        }
      }
      catch (ClassCastException localClassCastException)
      {
        break label181;
        label214:
        AppMethodBeat.o(206624);
      }
    }
  }
  
  private void a(h.l paraml)
  {
    AppMethodBeat.i(206616);
    if ((this.aTk.aPk.aRG == null) && (this.aTk.aPk.aRH == null) && (this.aTk.aPk.aRI == null))
    {
      AppMethodBeat.o(206616);
      return;
    }
    Object localObject1;
    Object localObject2;
    label140:
    Object localObject3;
    if (this.aTk.aPk.aRG != null)
    {
      localObject1 = paraml.aSO.Z(this.aTk.aPk.aRG);
      if (localObject1 != null)
      {
        localObject1 = (h.r)localObject1;
        if (this.aTk.aPk.aRH == null) {
          break label275;
        }
        localObject2 = paraml.aSO.Z(this.aTk.aPk.aRH);
        if (localObject2 == null) {
          break label251;
        }
        localObject2 = (h.r)localObject2;
        if (this.aTk.aPk.aRI == null) {
          break label305;
        }
        localObject3 = paraml.aSO.Z(this.aTk.aPk.aRI);
        if (localObject3 == null) {
          break label281;
        }
        localObject3 = (h.r)localObject3;
        label184:
        if (!(paraml instanceof h.v)) {
          break label311;
        }
        paraml = new a(((h.v)paraml).aQZ).aTt;
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
      AppMethodBeat.o(206616);
      return;
      String.format("Marker reference '%s' not found", new Object[] { this.aTk.aPk.aRG });
      localObject1 = null;
      break;
      String.format("Marker reference '%s' not found", new Object[] { this.aTk.aPk.aRH });
      localObject2 = null;
      break label140;
      String.format("Marker reference '%s' not found", new Object[] { this.aTk.aPk.aRI });
      localObject3 = null;
      break label184;
      if ((paraml instanceof h.q))
      {
        paraml = (h.q)paraml;
        label355:
        float f3;
        if (paraml.aQM != null)
        {
          f1 = paraml.aQM.a(this);
          if (paraml.aQN == null) {
            break label458;
          }
          f2 = paraml.aQN.b(this);
          if (paraml.aQO == null) {
            break label463;
          }
          f3 = paraml.aQO.a(this);
          label372:
          if (paraml.aQP == null) {
            break label469;
          }
        }
        label458:
        label463:
        label469:
        for (float f4 = paraml.aQP.b(this);; f4 = 0.0F)
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
      AppMethodBeat.o(206616);
      return;
    }
    Object localObject4 = this.aTk.aPk;
    Object localObject5 = this.aTk.aPk;
    this.aTk.aPk.aRI = null;
    ((h.ae)localObject5).aRH = null;
    ((h.ae)localObject4).aRG = null;
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
        if (!((b)localObject1).aTC) {
          break label852;
        }
        f1 = ((b)localObject1).aTA;
        f2 = ((b)localObject1).aTB;
        f2 = f1 * (((b)localObject1).x - ((b)localObject4).x) + (((b)localObject1).y - ((b)localObject4).y) * f2;
        f1 = f2;
        if (f2 == 0.0F)
        {
          f1 = ((b)localObject1).aTA;
          f2 = ((b)localObject1).aTB;
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
      if ((f1 != 0.0F) || ((((b)localObject1).aTA <= 0.0F) && (((b)localObject1).aTB < 0.0F)))
      {
        ((b)localObject1).aTA = (-((b)localObject1).aTA);
        ((b)localObject1).aTB = (-((b)localObject1).aTB);
        continue;
        if (localObject3 != null) {
          a((h.r)localObject3, (b)paraml.get(j - 1));
        }
        AppMethodBeat.o(206616);
        return;
      }
    }
  }
  
  private void a(h.l paraml, Path paramPath, Matrix paramMatrix)
  {
    AppMethodBeat.i(206635);
    a(this.aTk, paraml);
    if (!rl())
    {
      AppMethodBeat.o(206635);
      return;
    }
    if (!visible())
    {
      AppMethodBeat.o(206635);
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
      paramPath.setFillType(rq());
      paramPath.addPath(localPath, paramMatrix);
      AppMethodBeat.o(206635);
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
    AppMethodBeat.o(206635);
  }
  
  private void a(h.r paramr, b paramb)
  {
    float f4 = 3.0F;
    float f8 = 0.0F;
    AppMethodBeat.i(206617);
    re();
    float f1;
    if (paramr.aQV != null) {
      if (Float.isNaN(paramr.aQV.floatValue()))
      {
        if ((paramb.aTA == 0.0F) && (paramb.aTB == 0.0F)) {
          break label696;
        }
        f1 = (float)Math.toDegrees(Math.atan2(paramb.aTB, paramb.aTA));
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
      if (paramr.aQQ)
      {
        f2 = 1.0F;
        this.aTk = d(paramr);
        localMatrix = new Matrix();
        localMatrix.preTranslate(paramb.x, paramb.y);
        localMatrix.preRotate(f1);
        localMatrix.preScale(f2, f2);
        if (paramr.aQR == null) {
          break label557;
        }
        f2 = paramr.aQR.a(this);
        if (paramr.aQS == null) {
          break label563;
        }
        f5 = paramr.aQS.b(this);
        if (paramr.aQT == null) {
          break label569;
        }
        f3 = paramr.aQT.a(this);
        if (paramr.aQU != null) {
          f4 = paramr.aQU.b(this);
        }
        if (paramr.aQb == null) {
          break label643;
        }
        f7 = f3 / paramr.aQb.width;
        f6 = f4 / paramr.aQb.height;
        if (paramr.aPZ == null) {
          break label577;
        }
        paramb = paramr.aPZ;
        label244:
        if (paramb.equals(f.aPC)) {
          break label693;
        }
        if (paramb.aPA != f.b.aPW) {
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
        this.aTi.concat(localMatrix);
        f1 = paramr.aQb.width * f7;
        f5 = paramr.aQb.height * f6;
        switch (1.aTq[paramb.aPz.ordinal()])
        {
        default: 
          f1 = 0.0F;
          label378:
          f2 = f8;
          switch (1.aTq[paramb.aPz.ordinal()])
          {
          default: 
            f2 = f8;
          case 4: 
            label440:
            if (!this.aTk.aPk.aRE.booleanValue()) {
              j(f1, f2, f3, f4);
            }
            localMatrix.reset();
            localMatrix.preScale(f7, f6);
            this.aTi.concat(localMatrix);
          }
          break;
        }
        for (;;)
        {
          boolean bool = rh();
          a(paramr, false);
          if (bool) {
            b(paramr);
          }
          rf();
          AppMethodBeat.o(206617);
          return;
          f1 = paramr.aQV.floatValue();
          break;
          f2 = this.aTk.aPk.aRp.S(this.aTj);
          break label84;
          f2 = 0.0F;
          break label150;
          f5 = 0.0F;
          break label167;
          label569:
          f3 = 3.0F;
          break label184;
          label577:
          paramb = f.aPD;
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
          this.aTi.concat(localMatrix);
          if (!this.aTk.aPk.aRE.booleanValue()) {
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
    AppMethodBeat.i(206645);
    if ((params.aQW != null) && (params.aQW.booleanValue()))
    {
      i = 1;
      if (i == 0) {
        break label115;
      }
      if (params.aQJ == null) {
        break label97;
      }
      f1 = params.aQJ.a(this);
      label53:
      if (params.aQK == null) {
        break label106;
      }
    }
    label97:
    label106:
    for (f2 = params.aQK.b(this);; f2 = paramb.height)
    {
      if ((f1 != 0.0F) && (f2 != 0.0F)) {
        break label180;
      }
      AppMethodBeat.o(206645);
      return;
      i = 0;
      break;
      f1 = paramb.width;
      break label53;
    }
    label115:
    if (params.aQJ != null) {}
    for (float f1 = params.aQJ.a(this, 1.0F);; f1 = 1.2F)
    {
      if (params.aQK != null) {
        f2 = params.aQK.a(this, 1.0F);
      }
      f1 *= paramb.width;
      f2 *= paramb.height;
      break;
    }
    label180:
    re();
    this.aTk = d(params);
    this.aTk.aPk.aRv = Float.valueOf(1.0F);
    boolean bool = rh();
    this.aTi.save();
    if ((params.aQX == null) || (params.aQX.booleanValue())) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.aTi.translate(paramb.minX, paramb.minY);
        this.aTi.scale(paramb.width, paramb.height);
      }
      a(params, false);
      this.aTi.restore();
      if (bool) {
        a(paramak, paramb);
      }
      rf();
      AppMethodBeat.o(206645);
      return;
    }
  }
  
  private void a(h.v paramv, Path paramPath, Matrix paramMatrix)
  {
    AppMethodBeat.i(206634);
    a(this.aTk, paramv);
    if (!rl())
    {
      AppMethodBeat.o(206634);
      return;
    }
    if (!visible())
    {
      AppMethodBeat.o(206634);
      return;
    }
    if (paramv.transform != null) {
      paramMatrix.preConcat(paramv.transform);
    }
    Path localPath = new c(paramv.aQZ).lR;
    if (paramv.aSK == null) {
      paramv.aSK = e(localPath);
    }
    d(paramv);
    paramPath.setFillType(rq());
    paramPath.addPath(localPath, paramMatrix);
    AppMethodBeat.o(206634);
  }
  
  private static void a(h.y paramy, String paramString)
  {
    AppMethodBeat.i(206644);
    for (;;)
    {
      h.an localan = paramy.aSO.Z(paramString);
      if (localan == null)
      {
        String.format("Pattern reference '%s' not found", new Object[] { paramString });
        AppMethodBeat.o(206644);
        return;
      }
      if (!(localan instanceof h.y))
      {
        String.format("Pattern href attributes must point to other pattern elements", new Object[0]);
        AppMethodBeat.o(206644);
        return;
      }
      if (localan == paramy)
      {
        String.format("Circular reference in pattern href attribute '%s'", new Object[] { paramString });
        AppMethodBeat.o(206644);
        return;
      }
      paramString = (h.y)localan;
      if (paramy.aRf == null) {
        paramy.aRf = paramString.aRf;
      }
      if (paramy.aRg == null) {
        paramy.aRg = paramString.aRg;
      }
      if (paramy.aRh == null) {
        paramy.aRh = paramString.aRh;
      }
      if (paramy.aQH == null) {
        paramy.aQH = paramString.aQH;
      }
      if (paramy.aQI == null) {
        paramy.aQI = paramString.aQI;
      }
      if (paramy.aQJ == null) {
        paramy.aQJ = paramString.aQJ;
      }
      if (paramy.aQK == null) {
        paramy.aQK = paramString.aQK;
      }
      if (paramy.aQz.isEmpty()) {
        paramy.aQz = paramString.aQz;
      }
      if (paramy.aQb == null) {
        paramy.aQb = paramString.aQb;
      }
      if (paramy.aPZ == null) {
        paramy.aPZ = paramString.aPZ;
      }
      if (paramString.aQk == null) {
        break;
      }
      paramString = paramString.aQk;
    }
    AppMethodBeat.o(206644);
  }
  
  private void a(g paramg, h.ae paramae)
  {
    boolean bool2 = true;
    AppMethodBeat.i(206610);
    if (a(paramae, 4096L)) {
      paramg.aPk.aRw = paramae.aRw;
    }
    if (a(paramae, 2048L)) {
      paramg.aPk.aRv = paramae.aRv;
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
      paramg.aPk.aRk = paramae.aRk;
      if ((paramae.aRk != null) && (paramae.aRk != h.f.aQv))
      {
        bool1 = true;
        paramg.aTG = bool1;
      }
    }
    else
    {
      if (a(paramae, 4L)) {
        paramg.aPk.aRm = paramae.aRm;
      }
      if (a(paramae, 6149L)) {
        a(paramg, true, paramg.aPk.aRk);
      }
      if (a(paramae, 2L)) {
        paramg.aPk.aRl = paramae.aRl;
      }
      if (a(paramae, 8L))
      {
        paramg.aPk.aRn = paramae.aRn;
        if ((paramae.aRn == null) || (paramae.aRn == h.f.aQv)) {
          break label1394;
        }
        bool1 = true;
        paramg.aTH = bool1;
      }
      if (a(paramae, 16L)) {
        paramg.aPk.aRo = paramae.aRo;
      }
      if (a(paramae, 6168L)) {
        a(paramg, false, paramg.aPk.aRn);
      }
      if (a(paramae, 34359738368L)) {
        paramg.aPk.aRU = paramae.aRU;
      }
      if (a(paramae, 32L))
      {
        paramg.aPk.aRp = paramae.aRp;
        paramg.aTJ.setStrokeWidth(paramg.aPk.aRp.c(this));
      }
      if (a(paramae, 64L)) {
        paramg.aPk.aRq = paramae.aRq;
      }
      switch (1.aTr[paramae.aRq.ordinal()])
      {
      default: 
        if (a(paramae, 128L)) {
          paramg.aPk.aRr = paramae.aRr;
        }
        switch (1.aTs[paramae.aRr.ordinal()])
        {
        default: 
          if (a(paramae, 256L))
          {
            paramg.aPk.aRs = paramae.aRs;
            paramg.aTJ.setStrokeMiter(paramae.aRs.floatValue());
          }
          if (a(paramae, 512L)) {
            paramg.aPk.aRt = paramae.aRt;
          }
          if (a(paramae, 1024L)) {
            paramg.aPk.aRu = paramae.aRu;
          }
          if (a(paramae, 1536L))
          {
            if (paramg.aPk.aRt == null) {
              paramg.aTJ.setPathEffect(null);
            }
          }
          else
          {
            if (a(paramae, 16384L))
            {
              f1 = rc();
              paramg.aPk.aRy = paramae.aRy;
              paramg.aTI.setTextSize(paramae.aRy.a(this, f1));
              paramg.aTJ.setTextSize(paramae.aRy.a(this, f1));
            }
            if (a(paramae, 8192L)) {
              paramg.aPk.aRx = paramae.aRx;
            }
            if (a(paramae, 32768L))
            {
              if ((paramae.aRz.intValue() != -1) || (paramg.aPk.aRz.intValue() <= 100)) {
                break label1637;
              }
              localObject1 = paramg.aPk;
              ((h.ae)localObject1).aRz = Integer.valueOf(((h.ae)localObject1).aRz.intValue() - 100);
            }
            if (a(paramae, 65536L)) {
              paramg.aPk.aRA = paramae.aRA;
            }
            if (a(paramae, 106496L))
            {
              if ((paramg.aPk.aRx == null) || (this.aSO == null)) {
                break label1730;
              }
              j localj = h.qQ();
              Iterator localIterator = paramg.aPk.aRx.iterator();
              localObject2 = null;
              do
              {
                localObject1 = localObject2;
                if (!localIterator.hasNext()) {
                  break;
                }
                localObject2 = a((String)localIterator.next(), paramg.aPk.aRz, paramg.aPk.aRA);
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  localObject1 = localObject2;
                  if (localj != null)
                  {
                    paramg.aPk.aRz.intValue();
                    String.valueOf(paramg.aPk.aRA);
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
        localObject2 = a("serif", paramg.aPk.aRz, paramg.aPk.aRA);
      }
      paramg.aTI.setTypeface((Typeface)localObject2);
      paramg.aTJ.setTypeface((Typeface)localObject2);
      if (a(paramae, 131072L))
      {
        paramg.aPk.aRB = paramae.aRB;
        localObject1 = paramg.aTI;
        if (paramae.aRB != h.ae.g.aSw) {
          break label1706;
        }
        bool1 = true;
        label930:
        ((Paint)localObject1).setStrikeThruText(bool1);
        localObject1 = paramg.aTI;
        if (paramae.aRB != h.ae.g.aSu) {
          break label1712;
        }
        bool1 = true;
        label956:
        ((Paint)localObject1).setUnderlineText(bool1);
        if (Build.VERSION.SDK_INT >= 17)
        {
          localObject1 = paramg.aTJ;
          if (paramae.aRB != h.ae.g.aSw) {
            break label1718;
          }
          bool1 = true;
          label990:
          ((Paint)localObject1).setStrikeThruText(bool1);
          localObject1 = paramg.aTJ;
          if (paramae.aRB != h.ae.g.aSu) {
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
          paramg.aPk.aRC = paramae.aRC;
        }
        if (a(paramae, 262144L)) {
          paramg.aPk.aRD = paramae.aRD;
        }
        if (a(paramae, 524288L)) {
          paramg.aPk.aRE = paramae.aRE;
        }
        if (a(paramae, 2097152L)) {
          paramg.aPk.aRG = paramae.aRG;
        }
        if (a(paramae, 4194304L)) {
          paramg.aPk.aRH = paramae.aRH;
        }
        if (a(paramae, 8388608L)) {
          paramg.aPk.aRI = paramae.aRI;
        }
        if (a(paramae, 16777216L)) {
          paramg.aPk.aRJ = paramae.aRJ;
        }
        if (a(paramae, 33554432L)) {
          paramg.aPk.aRK = paramae.aRK;
        }
        if (a(paramae, 1048576L)) {
          paramg.aPk.aRF = paramae.aRF;
        }
        if (a(paramae, 268435456L)) {
          paramg.aPk.aRN = paramae.aRN;
        }
        if (a(paramae, 536870912L)) {
          paramg.aPk.aRO = paramae.aRO;
        }
        if (a(paramae, 1073741824L)) {
          paramg.aPk.aRP = paramae.aRP;
        }
        if (a(paramae, 67108864L)) {
          paramg.aPk.aRL = paramae.aRL;
        }
        if (a(paramae, 134217728L)) {
          paramg.aPk.aRM = paramae.aRM;
        }
        if (a(paramae, 8589934592L)) {
          paramg.aPk.aRS = paramae.aRS;
        }
        if (a(paramae, 17179869184L)) {
          paramg.aPk.aRT = paramae.aRT;
        }
        if (a(paramae, 137438953472L)) {
          paramg.aPk.aRV = paramae.aRV;
        }
        AppMethodBeat.o(206610);
        return;
        bool1 = false;
        break;
        label1394:
        bool1 = false;
        break label201;
        paramg.aTJ.setStrokeCap(Paint.Cap.BUTT);
        break label368;
        paramg.aTJ.setStrokeCap(Paint.Cap.ROUND);
        break label368;
        paramg.aTJ.setStrokeCap(Paint.Cap.SQUARE);
        break label368;
        paramg.aTJ.setStrokeJoin(Paint.Join.MITER);
        break label428;
        paramg.aTJ.setStrokeJoin(Paint.Join.ROUND);
        break label428;
        paramg.aTJ.setStrokeJoin(Paint.Join.BEVEL);
        break label428;
        int k = paramg.aPk.aRt.length;
        if (k % 2 == 0) {}
        for (int i = k;; i = k * 2)
        {
          localObject1 = new float[i];
          int j = 0;
          f1 = 0.0F;
          while (j < i)
          {
            localObject1[j] = paramg.aPk.aRt[(j % k)].c(this);
            f1 += localObject1[j];
            j += 1;
          }
        }
        if (f1 == 0.0F)
        {
          paramg.aTJ.setPathEffect(null);
          break label534;
        }
        float f3 = paramg.aPk.aRu.c(this);
        float f2 = f3;
        if (f3 < 0.0F) {
          f2 = f3 % f1 + f1;
        }
        paramg.aTJ.setPathEffect(new DashPathEffect((float[])localObject1, f2));
        break label534;
        label1637:
        if ((paramae.aRz.intValue() == 1) && (paramg.aPk.aRz.intValue() < 900))
        {
          localObject1 = paramg.aPk;
          ((h.ae)localObject1).aRz = Integer.valueOf(((h.ae)localObject1).aRz.intValue() + 100);
          break label674;
        }
        paramg.aPk.aRz = paramae.aRz;
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
    AppMethodBeat.i(206588);
    if (paramal.aSP == null) {}
    for (boolean bool = true;; bool = false)
    {
      paramg.aPk.aI(bool);
      if (paramal.aSM != null) {
        a(paramg, paramal.aSM);
      }
      if (!this.aSO.qO()) {
        break;
      }
      Iterator localIterator = this.aSO.aQh.aPm.iterator();
      while (localIterator.hasNext())
      {
        b.o localo = (b.o)localIterator.next();
        if (b.a(this.aTp, localo.aPj, paramal)) {
          a(paramg, localo.aPk);
        }
      }
    }
    if (paramal.aPk != null) {
      a(paramg, paramal.aPk);
    }
    AppMethodBeat.o(206588);
  }
  
  private static void a(g paramg, boolean paramBoolean, h.ao paramao)
  {
    AppMethodBeat.i(206611);
    Float localFloat;
    float f;
    if (paramBoolean)
    {
      localFloat = paramg.aPk.aRm;
      f = localFloat.floatValue();
      if (!(paramao instanceof h.f)) {
        break label81;
      }
    }
    for (int i = ((h.f)paramao).aQt;; i = paramg.aPk.aRw.aQt)
    {
      i = h(i, f);
      if (!paramBoolean) {
        break label110;
      }
      paramg.aTI.setColor(i);
      AppMethodBeat.o(206611);
      return;
      localFloat = paramg.aPk.aRo;
      break;
      label81:
      if (!(paramao instanceof h.g)) {
        break label103;
      }
    }
    label103:
    AppMethodBeat.o(206611);
    return;
    label110:
    paramg.aTJ.setColor(i);
    AppMethodBeat.o(206611);
  }
  
  private void a(boolean paramBoolean, h.ac paramac)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(206625);
    g localg;
    if (paramBoolean)
    {
      if (a(paramac.aSM, 2147483648L))
      {
        this.aTk.aPk.aRk = paramac.aSM.aRQ;
        localg = this.aTk;
        if (paramac.aSM.aRQ == null) {
          break label134;
        }
      }
      for (;;)
      {
        localg.aTG = bool1;
        if (a(paramac.aSM, 4294967296L)) {
          this.aTk.aPk.aRm = paramac.aSM.aRR;
        }
        if (!a(paramac.aSM, 6442450944L)) {
          break;
        }
        paramac = this.aTk;
        a(paramac, paramBoolean, paramac.aPk.aRk);
        AppMethodBeat.o(206625);
        return;
        label134:
        bool1 = false;
      }
    }
    if (a(paramac.aSM, 2147483648L))
    {
      this.aTk.aPk.aRn = paramac.aSM.aRQ;
      localg = this.aTk;
      if (paramac.aSM.aRQ == null) {
        break label261;
      }
    }
    label261:
    for (bool1 = bool2;; bool1 = false)
    {
      localg.aTH = bool1;
      if (a(paramac.aSM, 4294967296L)) {
        this.aTk.aPk.aRo = paramac.aSM.aRR;
      }
      if (a(paramac.aSM, 6442450944L))
      {
        paramac = this.aTk;
        a(paramac, paramBoolean, paramac.aPk.aRn);
      }
      AppMethodBeat.o(206625);
      return;
    }
  }
  
  private void a(boolean paramBoolean, h.b paramb, h.am paramam)
  {
    AppMethodBeat.i(206622);
    if (paramam.aQk != null) {
      a(paramam, paramam.aQk);
    }
    Paint localPaint;
    label54:
    float f2;
    label82:
    float f1;
    label99:
    float f3;
    if ((paramam.aQA != null) && (paramam.aQA.booleanValue()))
    {
      i = 1;
      if (!paramBoolean) {
        break label258;
      }
      localPaint = this.aTk.aTI;
      if (i == 0) {
        break label298;
      }
      localObject = rd();
      if (paramam.aQM == null) {
        break label270;
      }
      f2 = paramam.aQM.a(this);
      if (paramam.aQN == null) {
        break label276;
      }
      f1 = paramam.aQN.b(this);
      if (paramam.aQO == null) {
        break label282;
      }
      f3 = paramam.aQO.a(this);
      label116:
      if (paramam.aQP == null) {
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
    for (float f4 = paramam.aQP.b(this);; f4 = 0.0F)
    {
      f5 = f2;
      f2 = f1;
      re();
      this.aTk = d(paramam);
      localMatrix = new Matrix();
      if (i == 0)
      {
        localMatrix.preTranslate(paramb.minX, paramb.minY);
        localMatrix.preScale(paramb.width, paramb.height);
      }
      if (paramam.aQB != null) {
        localMatrix.preConcat(paramam.aQB);
      }
      j = paramam.aQz.size();
      if (j != 0) {
        break label416;
      }
      rf();
      if (!paramBoolean) {
        break label401;
      }
      this.aTk.aTG = false;
      AppMethodBeat.o(206622);
      return;
      i = 0;
      break;
      localPaint = this.aTk.aTJ;
      break label54;
      f2 = 0.0F;
      break label82;
      f1 = 0.0F;
      break label99;
      f3 = ((h.b)localObject).width;
      break label116;
    }
    label298:
    if (paramam.aQM != null)
    {
      f1 = paramam.aQM.a(this, 1.0F);
      label316:
      if (paramam.aQN == null) {
        break label383;
      }
      f2 = paramam.aQN.a(this, 1.0F);
      label334:
      if (paramam.aQO == null) {
        break label389;
      }
      f3 = paramam.aQO.a(this, 1.0F);
      label352:
      if (paramam.aQP == null) {
        break label395;
      }
    }
    label389:
    label395:
    for (f4 = paramam.aQP.a(this, 1.0F);; f4 = 0.0F)
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
    this.aTk.aTH = false;
    AppMethodBeat.o(206622);
    return;
    label416:
    int[] arrayOfInt = new int[j];
    float[] arrayOfFloat = new float[j];
    int i = 0;
    Iterator localIterator = paramam.aQz.iterator();
    float f6 = -1.0F;
    if (localIterator.hasNext())
    {
      paramb = (h.ad)localIterator.next();
      if (paramb.aRi != null)
      {
        f1 = paramb.aRi.floatValue();
        label487:
        if ((i != 0) && (f1 < f6)) {
          break label595;
        }
        arrayOfFloat[i] = f1;
      }
      for (;;)
      {
        re();
        a(this.aTk, paramb);
        localObject = (h.f)this.aTk.aPk.aRL;
        paramb = (h.b)localObject;
        if (localObject == null) {
          paramb = h.f.aQu;
        }
        arrayOfInt[i] = h(paramb.aQt, this.aTk.aPk.aRM.floatValue());
        rf();
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
      rf();
      localPaint.setColor(arrayOfInt[(j - 1)]);
      AppMethodBeat.o(206622);
      return;
    }
    Object localObject = Shader.TileMode.CLAMP;
    paramb = (h.b)localObject;
    if (paramam.aQC != null)
    {
      if (paramam.aQC != h.k.aQE) {
        break label749;
      }
      paramb = Shader.TileMode.MIRROR;
    }
    for (;;)
    {
      rf();
      paramb = new LinearGradient(f5, f2, f3, f4, arrayOfInt, arrayOfFloat, paramb);
      paramb.setLocalMatrix(localMatrix);
      localPaint.setShader(paramb);
      localPaint.setAlpha(T(this.aTk.aPk.aRm.floatValue()));
      AppMethodBeat.o(206622);
      return;
      label749:
      paramb = (h.b)localObject;
      if (paramam.aQC == h.k.aQF) {
        paramb = Shader.TileMode.REPEAT;
      }
    }
  }
  
  private void a(boolean paramBoolean, h.b paramb, h.aq paramaq)
  {
    AppMethodBeat.i(206623);
    if (paramaq.aQk != null) {
      a(paramaq, paramaq.aQk);
    }
    Paint localPaint;
    label54:
    float f1;
    label91:
    float f2;
    if ((paramaq.aQA != null) && (paramaq.aQA.booleanValue()))
    {
      i = 1;
      if (!paramBoolean) {
        break label246;
      }
      localPaint = this.aTk.aTI;
      if (i == 0) {
        break label291;
      }
      localObject = new h.p(50.0F, h.bd.aTg);
      if (paramaq.aQp == null) {
        break label258;
      }
      f1 = paramaq.aQp.a(this);
      if (paramaq.aQq == null) {
        break label269;
      }
      f2 = paramaq.aQq.b(this);
      label108:
      if (paramaq.aQr == null) {
        break label280;
      }
    }
    float f4;
    Matrix localMatrix;
    int j;
    label258:
    label269:
    label280:
    for (float f3 = paramaq.aQr.c(this);; f3 = ((h.p)localObject).c(this))
    {
      f4 = f1;
      re();
      this.aTk = d(paramaq);
      localMatrix = new Matrix();
      if (i == 0)
      {
        localMatrix.preTranslate(paramb.minX, paramb.minY);
        localMatrix.preScale(paramb.width, paramb.height);
      }
      if (paramaq.aQB != null) {
        localMatrix.preConcat(paramaq.aQB);
      }
      j = paramaq.aQz.size();
      if (j != 0) {
        break label391;
      }
      rf();
      if (!paramBoolean) {
        break label376;
      }
      this.aTk.aTG = false;
      AppMethodBeat.o(206623);
      return;
      i = 0;
      break;
      label246:
      localPaint = this.aTk.aTJ;
      break label54;
      f1 = ((h.p)localObject).a(this);
      break label91;
      f2 = ((h.p)localObject).b(this);
      break label108;
    }
    label291:
    if (paramaq.aQp != null)
    {
      f1 = paramaq.aQp.a(this, 1.0F);
      label309:
      if (paramaq.aQq == null) {
        break label360;
      }
      f2 = paramaq.aQq.a(this, 1.0F);
      label327:
      if (paramaq.aQr == null) {
        break label368;
      }
    }
    label360:
    label368:
    for (f3 = paramaq.aQr.a(this, 1.0F);; f3 = 0.5F)
    {
      f4 = f1;
      break;
      f1 = 0.5F;
      break label309;
      f2 = 0.5F;
      break label327;
    }
    label376:
    this.aTk.aTH = false;
    AppMethodBeat.o(206623);
    return;
    label391:
    int[] arrayOfInt = new int[j];
    float[] arrayOfFloat = new float[j];
    int i = 0;
    Iterator localIterator = paramaq.aQz.iterator();
    float f5 = -1.0F;
    if (localIterator.hasNext())
    {
      paramb = (h.ad)localIterator.next();
      if (paramb.aRi != null)
      {
        f1 = paramb.aRi.floatValue();
        label462:
        if ((i != 0) && (f1 < f5)) {
          break label570;
        }
        arrayOfFloat[i] = f1;
      }
      for (;;)
      {
        re();
        a(this.aTk, paramb);
        localObject = (h.f)this.aTk.aPk.aRL;
        paramb = (h.b)localObject;
        if (localObject == null) {
          paramb = h.f.aQu;
        }
        arrayOfInt[i] = h(paramb.aQt, this.aTk.aPk.aRM.floatValue());
        rf();
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
      rf();
      localPaint.setColor(arrayOfInt[(j - 1)]);
      AppMethodBeat.o(206623);
      return;
    }
    Object localObject = Shader.TileMode.CLAMP;
    paramb = (h.b)localObject;
    if (paramaq.aQC != null)
    {
      if (paramaq.aQC != h.k.aQE) {
        break label713;
      }
      paramb = Shader.TileMode.MIRROR;
    }
    for (;;)
    {
      rf();
      paramb = new RadialGradient(f4, f2, f3, arrayOfInt, arrayOfFloat, paramb);
      paramb.setLocalMatrix(localMatrix);
      localPaint.setShader(paramb);
      localPaint.setAlpha(T(this.aTk.aPk.aRm.floatValue()));
      AppMethodBeat.o(206623);
      return;
      label713:
      paramb = (h.b)localObject;
      if (paramaq.aQC == h.k.aQF) {
        paramb = Shader.TileMode.REPEAT;
      }
    }
  }
  
  private void a(boolean paramBoolean, h.b paramb, h.u paramu)
  {
    AppMethodBeat.i(206621);
    h.an localan = this.aSO.Z(paramu.aQk);
    if (localan == null)
    {
      if (paramBoolean) {}
      for (paramb = "Fill";; paramb = "Stroke")
      {
        String.format("%s reference '%s' not found", new Object[] { paramb, paramu.aQk });
        if (paramu.aQY == null) {
          break;
        }
        a(this.aTk, paramBoolean, paramu.aQY);
        AppMethodBeat.o(206621);
        return;
      }
      if (paramBoolean)
      {
        this.aTk.aTG = false;
        AppMethodBeat.o(206621);
        return;
      }
      this.aTk.aTH = false;
      AppMethodBeat.o(206621);
      return;
    }
    if ((localan instanceof h.am))
    {
      a(paramBoolean, paramb, (h.am)localan);
      AppMethodBeat.o(206621);
      return;
    }
    if ((localan instanceof h.aq))
    {
      a(paramBoolean, paramb, (h.aq)localan);
      AppMethodBeat.o(206621);
      return;
    }
    if ((localan instanceof h.ac)) {
      a(paramBoolean, (h.ac)localan);
    }
    AppMethodBeat.o(206621);
  }
  
  private static boolean a(h.ae paramae, long paramLong)
  {
    return (paramae.aRj & paramLong) != 0L;
  }
  
  private static Path b(h.z paramz)
  {
    AppMethodBeat.i(206641);
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
    if (paramz.aSK == null) {
      paramz.aSK = e(localPath);
    }
    AppMethodBeat.o(206641);
    return localPath;
  }
  
  private void b(h.ak paramak)
  {
    AppMethodBeat.i(206596);
    a(paramak, paramak.aSK);
    AppMethodBeat.o(206596);
  }
  
  private void b(h.ak paramak, h.b paramb)
  {
    AppMethodBeat.i(206627);
    if (this.aTk.aPk.aRN == null)
    {
      AppMethodBeat.o(206627);
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      paramak = c(paramak, paramb);
      if (paramak != null) {
        this.aTi.clipPath(paramak);
      }
      AppMethodBeat.o(206627);
      return;
    }
    d(paramak, paramb);
    AppMethodBeat.o(206627);
  }
  
  private void b(h.an paraman)
  {
    Object localObject1 = null;
    float f2 = 0.0F;
    float f4 = 0.0F;
    AppMethodBeat.i(206582);
    if ((paraman instanceof h.t))
    {
      AppMethodBeat.o(206582);
      return;
    }
    re();
    c(paraman);
    if ((paraman instanceof h.af))
    {
      paraman = (h.af)paraman;
      a(paraman, a(paraman.aQH, paraman.aQI, paraman.aQJ, paraman.aQK), paraman.aQb, paraman.aPZ);
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
          rf();
          AppMethodBeat.o(206582);
          return;
          if ((paraman instanceof h.be))
          {
            localObject2 = (h.be)paraman;
            if (((((h.be)localObject2).aQJ == null) || (!((h.be)localObject2).aQJ.isZero())) && ((((h.be)localObject2).aQK == null) || (!((h.be)localObject2).aQK.isZero())))
            {
              a(this.aTk, (h.al)localObject2);
              if (rl())
              {
                localObject3 = ((h.be)localObject2).aSO.Z(((h.be)localObject2).aQk);
                if (localObject3 == null)
                {
                  String.format("Use reference '%s' not found", new Object[] { ((h.be)localObject2).aQk });
                }
                else
                {
                  if (((h.be)localObject2).transform != null) {
                    this.aTi.concat(((h.be)localObject2).transform);
                  }
                  if (((h.be)localObject2).aQH != null)
                  {
                    f1 = ((h.be)localObject2).aQH.a(this);
                    if (((h.be)localObject2).aQI == null) {
                      break label370;
                    }
                    f2 = ((h.be)localObject2).aQI.b(this);
                    this.aTi.translate(f1, f2);
                    d((h.ak)localObject2);
                    bool1 = rh();
                    a((h.aj)localObject2);
                    if (!(localObject3 instanceof h.af)) {
                      break label375;
                    }
                    paraman = (h.af)localObject3;
                    localObject1 = a(null, null, ((h.be)localObject2).aQJ, ((h.be)localObject2).aQK);
                    re();
                    a(paraman, (h.b)localObject1, paraman.aQb, paraman.aPZ);
                    rf();
                  }
                  for (;;)
                  {
                    rg();
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
                      if (((h.be)localObject2).aQJ != null)
                      {
                        paraman = ((h.be)localObject2).aQJ;
                        if (((h.be)localObject2).aQK == null) {
                          break label478;
                        }
                      }
                      for (localObject1 = ((h.be)localObject2).aQK;; localObject1 = new h.p(100.0F, h.bd.aTg))
                      {
                        localObject1 = a(null, null, paraman, (h.p)localObject1);
                        re();
                        localObject3 = (h.at)localObject3;
                        if ((((h.b)localObject1).width != 0.0F) && (((h.b)localObject1).height != 0.0F)) {
                          break label496;
                        }
                        rf();
                        break;
                        paraman = new h.p(100.0F, h.bd.aTg);
                        break label397;
                      }
                      if (((h.at)localObject3).aPZ != null)
                      {
                        paraman = ((h.at)localObject3).aPZ;
                        a(this.aTk, (h.al)localObject3);
                        this.aTk.aQc = ((h.b)localObject1);
                        if (!this.aTk.aPk.aRE.booleanValue()) {
                          j(this.aTk.aQc.minX, this.aTk.aQc.minY, this.aTk.aQc.width, this.aTk.aQc.height);
                        }
                        if (((h.at)localObject3).aQb == null) {
                          break label672;
                        }
                        this.aTi.concat(a(this.aTk.aQc, ((h.at)localObject3).aQb, paraman));
                        this.aTk.aQb = ((h.at)localObject3).aQb;
                      }
                      for (;;)
                      {
                        boolean bool2 = rh();
                        a((h.aj)localObject3, true);
                        if (bool2) {
                          b((h.ak)localObject3);
                        }
                        a((h.ak)localObject3);
                        break;
                        paraman = f.aPD;
                        break label510;
                        this.aTi.translate(this.aTk.aQc.minX, this.aTk.aQc.minY);
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
            a(this.aTk, paraman);
            if (rl())
            {
              if (paraman.transform != null) {
                this.aTi.concat(paraman.transform);
              }
              d(paraman);
              bool1 = rh();
              localObject1 = Locale.getDefault().getLanguage();
              localObject2 = h.qQ();
              localObject3 = paraman.aQz.iterator();
              while (((Iterator)localObject3).hasNext())
              {
                h.an localan = (h.an)((Iterator)localObject3).next();
                if ((localan instanceof h.ag))
                {
                  Object localObject4 = (h.ag)localan;
                  if (((h.ag)localObject4).qW() == null)
                  {
                    Object localObject5 = ((h.ag)localObject4).qX();
                    if ((localObject5 == null) || ((!((Set)localObject5).isEmpty()) && (((Set)localObject5).contains(localObject1))))
                    {
                      localObject5 = ((h.ag)localObject4).qV();
                      if (localObject5 != null)
                      {
                        if (aTo == null) {
                          rj();
                        }
                        if ((((Set)localObject5).isEmpty()) || (!aTo.containsAll((Collection)localObject5))) {
                          break;
                        }
                      }
                      else
                      {
                        localObject5 = ((h.ag)localObject4).qY();
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
                        localObject4 = ((h.ag)localObject4).qZ();
                        if (localObject4 != null)
                        {
                          if ((((Set)localObject4).isEmpty()) || (localObject2 == null)) {
                            continue;
                          }
                          localObject4 = ((Set)localObject4).iterator();
                          if (((Iterator)localObject4).hasNext())
                          {
                            ((Iterator)localObject4).next();
                            this.aTk.aPk.aRz.intValue();
                            String.valueOf(this.aTk.aPk.aRA);
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
            a(this.aTk, paraman);
            if (rl())
            {
              if (paraman.transform != null) {
                this.aTi.concat(paraman.transform);
              }
              d(paraman);
              bool1 = rh();
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
      } while ((((h.o)localObject3).aQJ == null) || (((h.o)localObject3).aQJ.isZero()) || (((h.o)localObject3).aQK == null) || (((h.o)localObject3).aQK.isZero()) || (((h.o)localObject3).aQk == null));
      if (((h.o)localObject3).aPZ == null) {
        break;
      }
      paraman = ((h.o)localObject3).aPZ;
      localObject2 = checkForImageDataURL(((h.o)localObject3).aQk);
      if (localObject2 != null) {
        break label3306;
      }
    } while (h.qQ() == null);
    for (;;)
    {
      label397:
      label478:
      label496:
      label1264:
      if (localObject1 == null)
      {
        String.format("Could not locate image '%s'", new Object[] { ((h.o)localObject3).aQk });
        break;
        paraman = f.aPD;
        break label1264;
      }
      label672:
      localObject2 = new h.b(0.0F, 0.0F, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
      a(this.aTk, (h.al)localObject3);
      if ((!rl()) || (!visible())) {
        break;
      }
      if (((h.o)localObject3).transform != null) {
        this.aTi.concat(((h.o)localObject3).transform);
      }
      label1404:
      float f3;
      if (((h.o)localObject3).aQH != null)
      {
        f1 = ((h.o)localObject3).aQH.a(this);
        if (((h.o)localObject3).aQI == null) {
          break label1653;
        }
        f2 = ((h.o)localObject3).aQI.b(this);
        label1422:
        f3 = ((h.o)localObject3).aQJ.a(this);
        f4 = ((h.o)localObject3).aQK.a(this);
        this.aTk.aQc = new h.b(f1, f2, f3, f4);
        if (!this.aTk.aPk.aRE.booleanValue()) {
          j(this.aTk.aQc.minX, this.aTk.aQc.minY, this.aTk.aQc.width, this.aTk.aQc.height);
        }
        ((h.o)localObject3).aSK = this.aTk.aQc;
        a((h.ak)localObject3);
        d((h.ak)localObject3);
        bool1 = rh();
        rn();
        this.aTi.save();
        this.aTi.concat(a(this.aTk.aQc, (h.b)localObject2, paraman));
        if (this.aTk.aPk.aRV != h.ae.e.aSn) {
          break label1658;
        }
      }
      label1653:
      label1658:
      for (int i = 0;; i = 2)
      {
        paraman = new Paint(i);
        this.aTi.drawBitmap((Bitmap)localObject1, 0.0F, 0.0F, paraman);
        this.aTi.restore();
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
        if (paraman.aQZ == null) {
          break;
        }
        a(this.aTk, paraman);
        if ((!rl()) || (!visible()) || ((!this.aTk.aTH) && (!this.aTk.aTG))) {
          break;
        }
        if (paraman.transform != null) {
          this.aTi.concat(paraman.transform);
        }
        localObject1 = new c(paraman.aQZ).lR;
        if (paraman.aSK == null) {
          paraman.aSK = e((Path)localObject1);
        }
        a(paraman);
        c(paraman);
        d(paraman);
        bool1 = rh();
        if (this.aTk.aTG)
        {
          ((Path)localObject1).setFillType(rm());
          a(paraman, (Path)localObject1);
        }
        if (this.aTk.aTH) {
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
        if ((paraman.aQJ == null) || (paraman.aQK == null) || (paraman.aQJ.isZero()) || (paraman.aQK.isZero())) {
          break;
        }
        a(this.aTk, paraman);
        if ((!rl()) || (!visible())) {
          break;
        }
        if (paraman.transform != null) {
          this.aTi.concat(paraman.transform);
        }
        localObject1 = a(paraman);
        a(paraman);
        c(paraman);
        d(paraman);
        bool1 = rh();
        if (this.aTk.aTG) {
          a(paraman, (Path)localObject1);
        }
        if (this.aTk.aTH) {
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
        if ((paraman.aQr == null) || (paraman.aQr.isZero())) {
          break;
        }
        a(this.aTk, paraman);
        if ((!rl()) || (!visible())) {
          break;
        }
        if (paraman.transform != null) {
          this.aTi.concat(paraman.transform);
        }
        localObject1 = a(paraman);
        a(paraman);
        c(paraman);
        d(paraman);
        bool1 = rh();
        if (this.aTk.aTG) {
          a(paraman, (Path)localObject1);
        }
        if (this.aTk.aTH) {
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
        if ((paraman.aQx == null) || (paraman.aQy == null) || (paraman.aQx.isZero()) || (paraman.aQy.isZero())) {
          break;
        }
        a(this.aTk, paraman);
        if ((!rl()) || (!visible())) {
          break;
        }
        if (paraman.transform != null) {
          this.aTi.concat(paraman.transform);
        }
        localObject1 = a(paraman);
        a(paraman);
        c(paraman);
        d(paraman);
        bool1 = rh();
        if (this.aTk.aTG) {
          a(paraman, (Path)localObject1);
        }
        if (this.aTk.aTH) {
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
        a(this.aTk, paraman);
        if ((!rl()) || (!visible()) || (!this.aTk.aTH)) {
          break;
        }
        if (paraman.transform != null) {
          this.aTi.concat(paraman.transform);
        }
        if (paraman.aQM == null)
        {
          f1 = 0.0F;
          label2395:
          if (paraman.aQN != null) {
            break label2547;
          }
          f2 = 0.0F;
          label2404:
          if (paraman.aQO != null) {
            break label2559;
          }
          f3 = 0.0F;
          label2414:
          if (paraman.aQP != null) {
            break label2572;
          }
        }
        for (;;)
        {
          if (paraman.aSK == null) {
            paraman.aSK = new h.b(Math.min(f1, f3), Math.min(f2, f4), Math.abs(f3 - f1), Math.abs(f4 - f2));
          }
          localObject1 = new Path();
          ((Path)localObject1).moveTo(f1, f2);
          ((Path)localObject1).lineTo(f3, f4);
          a(paraman);
          c(paraman);
          d(paraman);
          bool1 = rh();
          d((Path)localObject1);
          a(paraman);
          if (!bool1) {
            break;
          }
          b(paraman);
          break;
          f1 = paraman.aQM.a(this);
          break label2395;
          label2547:
          f2 = paraman.aQN.b(this);
          break label2404;
          label2559:
          f3 = paraman.aQO.a(this);
          break label2414;
          label2572:
          f4 = paraman.aQP.b(this);
        }
      }
      if ((paraman instanceof h.aa))
      {
        paraman = (h.aa)paraman;
        a(this.aTk, paraman);
        if ((!rl()) || (!visible()) || ((!this.aTk.aTH) && (!this.aTk.aTG))) {
          break;
        }
        if (paraman.transform != null) {
          this.aTi.concat(paraman.transform);
        }
        if (paraman.points.length < 2) {
          break;
        }
        localObject1 = b(paraman);
        a(paraman);
        c(paraman);
        d(paraman);
        bool1 = rh();
        if (this.aTk.aTG) {
          a(paraman, (Path)localObject1);
        }
        if (this.aTk.aTH) {
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
        a(this.aTk, paraman);
        if ((!rl()) || (!visible()) || ((!this.aTk.aTH) && (!this.aTk.aTG))) {
          break;
        }
        if (paraman.transform != null) {
          this.aTi.concat(paraman.transform);
        }
        if (paraman.points.length < 2) {
          break;
        }
        localObject1 = b(paraman);
        a(paraman);
        ((Path)localObject1).setFillType(rm());
        c(paraman);
        d(paraman);
        bool1 = rh();
        if (this.aTk.aTG) {
          a(paraman, (Path)localObject1);
        }
        if (this.aTk.aTH) {
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
      a(this.aTk, paraman);
      if (!rl()) {
        break;
      }
      if (paraman.transform != null) {
        this.aTi.concat(paraman.transform);
      }
      label2981:
      label3003:
      label3025:
      float f5;
      if ((paraman.aSU == null) || (paraman.aSU.size() == 0))
      {
        f1 = 0.0F;
        if ((paraman.aSV != null) && (paraman.aSV.size() != 0)) {
          break label3233;
        }
        f3 = 0.0F;
        if ((paraman.aSW != null) && (paraman.aSW.size() != 0)) {
          break label3255;
        }
        f4 = 0.0F;
        f5 = f2;
        if (paraman.aSX != null)
        {
          if (paraman.aSX.size() != 0) {
            break label3277;
          }
          f5 = f2;
        }
        label3050:
        localObject1 = rk();
        f2 = f1;
        if (localObject1 != h.ae.f.aSp)
        {
          f2 = a(paraman);
          if (localObject1 != h.ae.f.aSq) {
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
        if (paraman.aSK == null)
        {
          localObject1 = new h(f2, f3);
          a(paraman, (i)localObject1);
          paraman.aSK = new h.b(((h)localObject1).aTL.left, ((h)localObject1).aTL.top, ((h)localObject1).aTL.width(), ((h)localObject1).aTL.height());
        }
        a(paraman);
        c(paraman);
        d(paraman);
        bool1 = rh();
        a(paraman, new e(f2 + f4, f5 + f3));
        if (!bool1) {
          break;
        }
        b(paraman);
        break;
        f1 = ((h.p)paraman.aSU.get(0)).a(this);
        break label2981;
        f3 = ((h.p)paraman.aSV.get(0)).b(this);
        break label3003;
        f4 = ((h.p)paraman.aSW.get(0)).a(this);
        break label3025;
        f5 = ((h.p)paraman.aSX.get(0)).b(this);
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
    AppMethodBeat.i(206628);
    paramak = paramak.aSO.Z(this.aTk.aPk.aRN);
    if (paramak == null)
    {
      String.format("ClipPath reference '%s' not found", new Object[] { this.aTk.aPk.aRN });
      AppMethodBeat.o(206628);
      return null;
    }
    Object localObject1 = (h.e)paramak;
    this.aTl.push(this.aTk);
    this.aTk = d((h.an)localObject1);
    if ((((h.e)localObject1).aQs == null) || (((h.e)localObject1).aQs.booleanValue())) {
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
    Iterator localIterator = ((h.e)localObject1).aQz.iterator();
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
    if (this.aTk.aPk.aRN != null)
    {
      if (((h.e)localObject1).aSK == null) {
        ((h.e)localObject1).aSK = e(paramb);
      }
      localObject1 = c((h.ak)localObject1, ((h.e)localObject1).aSK);
      if (localObject1 != null) {
        paramb.op((Path)localObject1, Path.Op.INTERSECT);
      }
    }
    paramb.transform(paramak);
    this.aTk = ((g)this.aTl.pop());
    AppMethodBeat.o(206628);
    return paramb;
  }
  
  private void c(h.ak paramak)
  {
    AppMethodBeat.i(206620);
    if ((this.aTk.aPk.aRk instanceof h.u)) {
      a(true, paramak.aSK, (h.u)this.aTk.aPk.aRk);
    }
    if ((this.aTk.aPk.aRn instanceof h.u)) {
      a(false, paramak.aSK, (h.u)this.aTk.aPk.aRn);
    }
    AppMethodBeat.o(206620);
  }
  
  private void c(h.an paraman)
  {
    AppMethodBeat.i(206589);
    if (!(paraman instanceof h.al))
    {
      AppMethodBeat.o(206589);
      return;
    }
    paraman = (h.al)paraman;
    if (paraman.aSL != null) {
      this.aTk.aTK = paraman.aSL.booleanValue();
    }
    AppMethodBeat.o(206589);
  }
  
  private static Bitmap checkForImageDataURL(String paramString)
  {
    AppMethodBeat.i(206606);
    if (!paramString.startsWith("data:"))
    {
      AppMethodBeat.o(206606);
      return null;
    }
    if (paramString.length() < 14)
    {
      AppMethodBeat.o(206606);
      return null;
    }
    int i = paramString.indexOf(',');
    if (i < 12)
    {
      AppMethodBeat.o(206606);
      return null;
    }
    if (!";base64".equals(paramString.substring(i - 7, i)))
    {
      AppMethodBeat.o(206606);
      return null;
    }
    try
    {
      paramString = Base64.decode(paramString.substring(i + 1), 0);
      paramString = BitmapFactory.decodeByteArray(paramString, 0, paramString.length);
      AppMethodBeat.o(206606);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(206606);
    }
    return null;
  }
  
  private g d(h.an paraman)
  {
    AppMethodBeat.i(206618);
    g localg = new g();
    a(localg, h.ae.qU());
    paraman = a(paraman, localg);
    AppMethodBeat.o(206618);
    return paraman;
  }
  
  private void d(Path paramPath)
  {
    AppMethodBeat.i(206591);
    if (this.aTk.aPk.aRU == h.ae.i.aSD)
    {
      Matrix localMatrix1 = this.aTi.getMatrix();
      Path localPath = new Path();
      paramPath.transform(localMatrix1, localPath);
      this.aTi.setMatrix(new Matrix());
      paramPath = this.aTk.aTJ.getShader();
      Matrix localMatrix2 = new Matrix();
      if (paramPath != null)
      {
        paramPath.getLocalMatrix(localMatrix2);
        Matrix localMatrix3 = new Matrix(localMatrix2);
        localMatrix3.postConcat(localMatrix1);
        paramPath.setLocalMatrix(localMatrix3);
      }
      this.aTi.drawPath(localPath, this.aTk.aTJ);
      this.aTi.setMatrix(localMatrix1);
      if (paramPath != null) {
        paramPath.setLocalMatrix(localMatrix2);
      }
      AppMethodBeat.o(206591);
      return;
    }
    this.aTi.drawPath(paramPath, this.aTk.aTJ);
    AppMethodBeat.o(206591);
  }
  
  private void d(h.ak paramak)
  {
    AppMethodBeat.i(206626);
    b(paramak, paramak.aSK);
    AppMethodBeat.o(206626);
  }
  
  private void d(h.ak paramak, h.b paramb)
  {
    AppMethodBeat.i(206630);
    Object localObject = paramak.aSO.Z(this.aTk.aPk.aRN);
    if (localObject == null)
    {
      String.format("ClipPath reference '%s' not found", new Object[] { this.aTk.aPk.aRN });
      AppMethodBeat.o(206630);
      return;
    }
    localObject = (h.e)localObject;
    if (((h.e)localObject).aQz.isEmpty())
    {
      this.aTi.clipRect(0, 0, 0, 0);
      AppMethodBeat.o(206630);
      return;
    }
    if ((((h.e)localObject).aQs == null) || (((h.e)localObject).aQs.booleanValue())) {}
    for (int i = 1; ((paramak instanceof h.m)) && (i == 0); i = 0)
    {
      String.format("<clipPath clipPathUnits=\"objectBoundingBox\"> is not supported when referenced from container elements (like %s)", new Object[] { paramak.getNodeName() });
      AppMethodBeat.o(206630);
      return;
    }
    ro();
    if (i == 0)
    {
      paramak = new Matrix();
      paramak.preTranslate(paramb.minX, paramb.minY);
      paramak.preScale(paramb.width, paramb.height);
      this.aTi.concat(paramak);
    }
    if (((h.e)localObject).transform != null) {
      this.aTi.concat(((h.e)localObject).transform);
    }
    this.aTk = d((h.an)localObject);
    d((h.ak)localObject);
    paramak = new Path();
    paramb = ((h.e)localObject).aQz.iterator();
    while (paramb.hasNext()) {
      a((h.an)paramb.next(), true, paramak, new Matrix());
    }
    this.aTi.clipPath(paramak);
    rp();
    AppMethodBeat.o(206630);
  }
  
  private static h.b e(Path paramPath)
  {
    AppMethodBeat.i(206600);
    RectF localRectF = new RectF();
    paramPath.computeBounds(localRectF, true);
    paramPath = new h.b(localRectF.left, localRectF.top, localRectF.width(), localRectF.height());
    AppMethodBeat.o(206600);
    return paramPath;
  }
  
  private static int h(int paramInt, float paramFloat)
  {
    int i = 255;
    AppMethodBeat.i(206613);
    int j = Math.round((paramInt >> 24 & 0xFF) * paramFloat);
    if (j < 0) {
      i = 0;
    }
    for (;;)
    {
      AppMethodBeat.o(206613);
      return i << 24 | 0xFFFFFF & paramInt;
      if (j <= 255) {
        i = j;
      }
    }
  }
  
  private void j(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(206614);
    float f3 = paramFloat1 + paramFloat3;
    float f4 = paramFloat2 + paramFloat4;
    float f2 = f4;
    float f1 = f3;
    paramFloat4 = paramFloat1;
    paramFloat3 = paramFloat2;
    if (this.aTk.aPk.aRF != null)
    {
      paramFloat4 = paramFloat1 + this.aTk.aPk.aRF.aQo.a(this);
      paramFloat3 = paramFloat2 + this.aTk.aPk.aRF.aQl.b(this);
      f1 = f3 - this.aTk.aPk.aRF.aQm.a(this);
      f2 = f4 - this.aTk.aPk.aRF.aQn.b(this);
    }
    this.aTi.clipRect(paramFloat4, paramFloat3, f1, f2);
    AppMethodBeat.o(206614);
  }
  
  private void rb()
  {
    AppMethodBeat.i(206579);
    this.aTk = new g();
    this.aTl = new Stack();
    a(this.aTk, h.ae.qU());
    this.aTk.aQc = null;
    this.aTk.aTK = false;
    this.aTl.push(new g(this.aTk));
    this.aTn = new Stack();
    this.aTm = new Stack();
    AppMethodBeat.o(206579);
  }
  
  private void re()
  {
    AppMethodBeat.i(206584);
    this.aTi.save();
    this.aTl.push(this.aTk);
    this.aTk = new g(this.aTk);
    AppMethodBeat.o(206584);
  }
  
  private void rf()
  {
    AppMethodBeat.i(206585);
    this.aTi.restore();
    this.aTk = ((g)this.aTl.pop());
    AppMethodBeat.o(206585);
  }
  
  private void rg()
  {
    AppMethodBeat.i(206587);
    this.aTm.pop();
    this.aTn.pop();
    AppMethodBeat.o(206587);
  }
  
  private boolean rh()
  {
    AppMethodBeat.i(206595);
    if (!ri())
    {
      AppMethodBeat.o(206595);
      return false;
    }
    this.aTi.saveLayerAlpha(null, T(this.aTk.aPk.aRv.floatValue()), 31);
    this.aTl.push(this.aTk);
    this.aTk = new g(this.aTk);
    if (this.aTk.aPk.aRP != null)
    {
      h.an localan = this.aSO.Z(this.aTk.aPk.aRP);
      if ((localan == null) || (!(localan instanceof h.s)))
      {
        String.format("Mask reference '%s' not found", new Object[] { this.aTk.aPk.aRP });
        this.aTk.aPk.aRP = null;
        AppMethodBeat.o(206595);
        return true;
      }
    }
    AppMethodBeat.o(206595);
    return true;
  }
  
  private boolean ri()
  {
    AppMethodBeat.i(206598);
    if ((this.aTk.aPk.aRv.floatValue() < 1.0F) || (this.aTk.aPk.aRP != null))
    {
      AppMethodBeat.o(206598);
      return true;
    }
    AppMethodBeat.o(206598);
    return false;
  }
  
  private static void rj()
  {
    try
    {
      AppMethodBeat.i(206599);
      HashSet localHashSet = new HashSet();
      aTo = localHashSet;
      localHashSet.add("Structure");
      aTo.add("BasicStructure");
      aTo.add("ConditionalProcessing");
      aTo.add("Image");
      aTo.add("Style");
      aTo.add("ViewportAttribute");
      aTo.add("Shape");
      aTo.add("BasicText");
      aTo.add("PaintAttribute");
      aTo.add("BasicPaintAttribute");
      aTo.add("OpacityAttribute");
      aTo.add("BasicGraphicsAttribute");
      aTo.add("Marker");
      aTo.add("Gradient");
      aTo.add("Pattern");
      aTo.add("Clip");
      aTo.add("BasicClip");
      aTo.add("Mask");
      aTo.add("View");
      AppMethodBeat.o(206599);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private h.ae.f rk()
  {
    if ((this.aTk.aPk.aRC == h.ae.h.aSz) || (this.aTk.aPk.aRD == h.ae.f.aSq)) {
      return this.aTk.aPk.aRD;
    }
    if (this.aTk.aPk.aRD == h.ae.f.aSp) {
      return h.ae.f.aSr;
    }
    return h.ae.f.aSp;
  }
  
  private boolean rl()
  {
    AppMethodBeat.i(206607);
    if (this.aTk.aPk.aRJ != null)
    {
      boolean bool = this.aTk.aPk.aRJ.booleanValue();
      AppMethodBeat.o(206607);
      return bool;
    }
    AppMethodBeat.o(206607);
    return true;
  }
  
  private Path.FillType rm()
  {
    if ((this.aTk.aPk.aRl != null) && (this.aTk.aPk.aRl == h.ae.a.aRX)) {
      return Path.FillType.EVEN_ODD;
    }
    return Path.FillType.WINDING;
  }
  
  private void rn()
  {
    AppMethodBeat.i(206615);
    if ((this.aTk.aPk.aRS instanceof h.f)) {}
    for (int i = ((h.f)this.aTk.aPk.aRS).aQt;; i = this.aTk.aPk.aRw.aQt)
    {
      int j = i;
      if (this.aTk.aPk.aRT != null) {
        j = h(i, this.aTk.aPk.aRT.floatValue());
      }
      this.aTi.drawColor(j);
      AppMethodBeat.o(206615);
      return;
      if (!(this.aTk.aPk.aRS instanceof h.g)) {
        break;
      }
    }
    AppMethodBeat.o(206615);
  }
  
  private void ro()
  {
    AppMethodBeat.i(206632);
    c.c(this.aTi, c.aPv);
    this.aTl.push(this.aTk);
    this.aTk = new g(this.aTk);
    AppMethodBeat.o(206632);
  }
  
  private void rp()
  {
    AppMethodBeat.i(206633);
    this.aTi.restore();
    this.aTk = ((g)this.aTl.pop());
    AppMethodBeat.o(206633);
  }
  
  private Path.FillType rq()
  {
    if ((this.aTk.aPk.aRO != null) && (this.aTk.aPk.aRO == h.ae.a.aRX)) {
      return Path.FillType.EVEN_ODD;
    }
    return Path.FillType.WINDING;
  }
  
  private boolean visible()
  {
    AppMethodBeat.i(206608);
    if (this.aTk.aPk.aRK != null)
    {
      boolean bool = this.aTk.aPk.aRK.booleanValue();
      AppMethodBeat.o(206608);
      return bool;
    }
    AppMethodBeat.o(206608);
    return true;
  }
  
  final void a(h paramh, g paramg)
  {
    AppMethodBeat.i(206581);
    this.aSO = paramh;
    h.af localaf = paramh.aQf;
    if (localaf == null)
    {
      String.format("Nothing to render. Document is empty.", new Object[0]);
      AppMethodBeat.o(206581);
      return;
    }
    Object localObject1;
    Object localObject2;
    if (paramg.qI())
    {
      localObject1 = this.aSO.aa(paramg.viewId);
      if ((localObject1 == null) || (!(localObject1 instanceof h.bf)))
      {
        String.format("View element with id \"%s\" not found.", new Object[] { paramg.viewId });
        AppMethodBeat.o(206581);
        return;
      }
      localObject1 = (h.bf)localObject1;
      if (((h.bf)localObject1).aQb == null)
      {
        String.format("View element with id \"%s\" is missing a viewBox attribute.", new Object[] { paramg.viewId });
        AppMethodBeat.o(206581);
        return;
      }
      localObject2 = ((h.bf)localObject1).aQb;
      localObject1 = ((h.bf)localObject1).aPZ;
    }
    for (;;)
    {
      if (paramg.qG()) {
        paramh.b(paramg.aPY);
      }
      if (paramg.qK())
      {
        this.aTp = new b.p();
        this.aTp.aPl = paramh.aa(paramg.aQa);
      }
      rb();
      c(localaf);
      re();
      Object localObject3 = new h.b(paramg.aQc);
      if (localaf.aQJ != null) {
        ((h.b)localObject3).width = localaf.aQJ.a(this, ((h.b)localObject3).width);
      }
      if (localaf.aQK != null) {
        ((h.b)localObject3).height = localaf.aQK.a(this, ((h.b)localObject3).height);
      }
      a(localaf, (h.b)localObject3, (h.b)localObject2, (f)localObject1);
      rf();
      if (paramg.qG()) {
        paramh.qP();
      }
      AppMethodBeat.o(206581);
      return;
      if (paramg.qJ()) {}
      for (localObject1 = paramg.aQb;; localObject1 = localaf.aQb)
      {
        if (!paramg.qH()) {
          break label348;
        }
        localObject3 = paramg.aPZ;
        localObject2 = localObject1;
        localObject1 = localObject3;
        break;
      }
      label348:
      localObject3 = localaf.aPZ;
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
  }
  
  final float rc()
  {
    AppMethodBeat.i(206580);
    float f = this.aTk.aTI.getTextSize();
    AppMethodBeat.o(206580);
    return f;
  }
  
  final h.b rd()
  {
    if (this.aTk.aQb != null) {
      return this.aTk.aQb;
    }
    return this.aTk.aQc;
  }
  
  final class a
    implements h.x
  {
    List<i.b> aTt;
    private i.b aTu;
    private boolean aTv;
    private boolean aTw;
    private int aTx;
    private boolean aTy;
    private float me;
    private float mf;
    
    a(h.w paramw)
    {
      AppMethodBeat.i(206552);
      this.aTt = new ArrayList();
      this.aTu = null;
      this.aTv = false;
      this.aTw = true;
      this.aTx = -1;
      if (paramw == null)
      {
        AppMethodBeat.o(206552);
        return;
      }
      paramw.a(this);
      if (this.aTy)
      {
        this.aTu.a((i.b)this.aTt.get(this.aTx));
        this.aTt.set(this.aTx, this.aTu);
        this.aTy = false;
      }
      if (this.aTu != null) {
        this.aTt.add(this.aTu);
      }
      AppMethodBeat.o(206552);
    }
    
    public final void a(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean1, boolean paramBoolean2, float paramFloat4, float paramFloat5)
    {
      AppMethodBeat.i(206557);
      this.aTv = true;
      this.aTw = false;
      i.a(this.aTu.x, this.aTu.y, paramFloat1, paramFloat2, paramFloat3, paramBoolean1, paramBoolean2, paramFloat4, paramFloat5, this);
      this.aTw = true;
      this.aTy = false;
      AppMethodBeat.o(206557);
    }
    
    public final void close()
    {
      AppMethodBeat.i(206558);
      this.aTt.add(this.aTu);
      lineTo(this.me, this.mf);
      this.aTy = true;
      AppMethodBeat.o(206558);
    }
    
    public final void cubicTo(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
    {
      AppMethodBeat.i(206555);
      if ((this.aTw) || (this.aTv))
      {
        this.aTu.q(paramFloat1, paramFloat2);
        this.aTt.add(this.aTu);
        this.aTv = false;
      }
      this.aTu = new i.b(i.this, paramFloat5, paramFloat6, paramFloat5 - paramFloat3, paramFloat6 - paramFloat4);
      this.aTy = false;
      AppMethodBeat.o(206555);
    }
    
    public final void lineTo(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(206554);
      this.aTu.q(paramFloat1, paramFloat2);
      this.aTt.add(this.aTu);
      this.aTu = new i.b(i.this, paramFloat1, paramFloat2, paramFloat1 - this.aTu.x, paramFloat2 - this.aTu.y);
      this.aTy = false;
      AppMethodBeat.o(206554);
    }
    
    public final void moveTo(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(206553);
      if (this.aTy)
      {
        this.aTu.a((i.b)this.aTt.get(this.aTx));
        this.aTt.set(this.aTx, this.aTu);
        this.aTy = false;
      }
      if (this.aTu != null) {
        this.aTt.add(this.aTu);
      }
      this.me = paramFloat1;
      this.mf = paramFloat2;
      this.aTu = new i.b(i.this, paramFloat1, paramFloat2, 0.0F, 0.0F);
      this.aTx = this.aTt.size();
      AppMethodBeat.o(206553);
    }
    
    public final void quadTo(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      AppMethodBeat.i(206556);
      this.aTu.q(paramFloat1, paramFloat2);
      this.aTt.add(this.aTu);
      this.aTu = new i.b(i.this, paramFloat3, paramFloat4, paramFloat3 - paramFloat1, paramFloat4 - paramFloat2);
      this.aTy = false;
      AppMethodBeat.o(206556);
    }
  }
  
  final class b
  {
    float aTA;
    float aTB;
    boolean aTC;
    float x;
    float y;
    
    b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      AppMethodBeat.i(206559);
      this.aTA = 0.0F;
      this.aTB = 0.0F;
      this.aTC = false;
      this.x = paramFloat1;
      this.y = paramFloat2;
      double d = Math.sqrt(paramFloat3 * paramFloat3 + paramFloat4 * paramFloat4);
      if (d != 0.0D)
      {
        this.aTA = ((float)(paramFloat3 / d));
        this.aTB = ((float)(paramFloat4 / d));
      }
      AppMethodBeat.o(206559);
    }
    
    final void a(b paramb)
    {
      if ((paramb.aTA == -this.aTA) && (paramb.aTB == -this.aTB))
      {
        this.aTC = true;
        this.aTA = (-paramb.aTB);
        this.aTB = paramb.aTA;
        return;
      }
      this.aTA += paramb.aTA;
      this.aTB += paramb.aTB;
    }
    
    final void q(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(206560);
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
      if ((paramFloat1 == -this.aTA) && (paramFloat2 == -this.aTB))
      {
        this.aTC = true;
        this.aTA = (-paramFloat2);
        this.aTB = paramFloat1;
        AppMethodBeat.o(206560);
        return;
      }
      this.aTA = (paramFloat1 + this.aTA);
      this.aTB = (paramFloat2 + this.aTB);
      AppMethodBeat.o(206560);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(206561);
      String str = "(" + this.x + "," + this.y + " " + this.aTA + "," + this.aTB + ")";
      AppMethodBeat.o(206561);
      return str;
    }
  }
  
  protected static final class c
    implements h.x
  {
    float aTD;
    float aTE;
    Path lR;
    
    c(h.w paramw)
    {
      AppMethodBeat.i(206562);
      this.lR = new Path();
      if (paramw == null)
      {
        AppMethodBeat.o(206562);
        return;
      }
      paramw.a(this);
      AppMethodBeat.o(206562);
    }
    
    public final void a(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean1, boolean paramBoolean2, float paramFloat4, float paramFloat5)
    {
      AppMethodBeat.i(206567);
      i.a(this.aTD, this.aTE, paramFloat1, paramFloat2, paramFloat3, paramBoolean1, paramBoolean2, paramFloat4, paramFloat5, this);
      this.aTD = paramFloat4;
      this.aTE = paramFloat5;
      AppMethodBeat.o(206567);
    }
    
    public final void close()
    {
      AppMethodBeat.i(206568);
      this.lR.close();
      AppMethodBeat.o(206568);
    }
    
    public final void cubicTo(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
    {
      AppMethodBeat.i(206565);
      this.lR.cubicTo(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
      this.aTD = paramFloat5;
      this.aTE = paramFloat6;
      AppMethodBeat.o(206565);
    }
    
    public final void lineTo(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(206564);
      this.lR.lineTo(paramFloat1, paramFloat2);
      this.aTD = paramFloat1;
      this.aTE = paramFloat2;
      AppMethodBeat.o(206564);
    }
    
    public final void moveTo(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(206563);
      this.lR.moveTo(paramFloat1, paramFloat2);
      this.aTD = paramFloat1;
      this.aTE = paramFloat2;
      AppMethodBeat.o(206563);
    }
    
    public final void quadTo(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      AppMethodBeat.i(206566);
      this.lR.quadTo(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
      this.aTD = paramFloat3;
      this.aTE = paramFloat4;
      AppMethodBeat.o(206566);
    }
  }
  
  final class d
    extends i.e
  {
    private Path lR;
    
    d(Path paramPath, float paramFloat)
    {
      super(paramFloat, 0.0F);
      this.lR = paramPath;
    }
    
    public final void ac(String paramString)
    {
      AppMethodBeat.i(206569);
      if (i.d(i.this))
      {
        if (i.e(i.this).aTG) {
          i.f(i.this).drawTextOnPath(paramString, this.lR, this.x, this.y, i.e(i.this).aTI);
        }
        if (i.e(i.this).aTH) {
          i.f(i.this).drawTextOnPath(paramString, this.lR, this.x, this.y, i.e(i.this).aTJ);
        }
      }
      this.x += i.e(i.this).aTI.measureText(paramString);
      AppMethodBeat.o(206569);
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
    
    public void ac(String paramString)
    {
      AppMethodBeat.i(206570);
      i.rr();
      if (i.d(i.this))
      {
        if (i.e(i.this).aTG) {
          i.f(i.this).drawText(paramString, this.x, this.y, i.e(i.this).aTI);
        }
        if (i.e(i.this).aTH) {
          i.f(i.this).drawText(paramString, this.x, this.y, i.e(i.this).aTJ);
        }
      }
      this.x += i.e(i.this).aTI.measureText(paramString);
      AppMethodBeat.o(206570);
    }
  }
  
  final class f
    extends i.i
  {
    Path aTF;
    float x;
    float y;
    
    f(float paramFloat1, float paramFloat2, Path paramPath)
    {
      super((byte)0);
      this.x = paramFloat1;
      this.y = paramFloat2;
      this.aTF = paramPath;
    }
    
    public final void ac(String paramString)
    {
      AppMethodBeat.i(206572);
      if (i.d(i.this))
      {
        Path localPath = new Path();
        i.e(i.this).aTI.getTextPath(paramString, 0, paramString.length(), this.x, this.y, localPath);
        this.aTF.addPath(localPath);
      }
      this.x += i.e(i.this).aTI.measureText(paramString);
      AppMethodBeat.o(206572);
    }
    
    public final boolean b(h.ay paramay)
    {
      AppMethodBeat.i(206571);
      if ((paramay instanceof h.az))
      {
        i.g("Using <textPath> elements in a clip path is not supported.", new Object[0]);
        AppMethodBeat.o(206571);
        return false;
      }
      AppMethodBeat.o(206571);
      return true;
    }
  }
  
  final class g
  {
    h.ae aPk;
    h.b aQb;
    h.b aQc;
    boolean aTG;
    boolean aTH;
    Paint aTI;
    Paint aTJ;
    boolean aTK;
    
    g()
    {
      AppMethodBeat.i(206573);
      this.aTI = new Paint();
      this.aTI.setFlags(193);
      if (Build.VERSION.SDK_INT >= 14) {
        this.aTI.setHinting(0);
      }
      this.aTI.setStyle(Paint.Style.FILL);
      this.aTI.setTypeface(Typeface.DEFAULT);
      this.aTJ = new Paint();
      this.aTJ.setFlags(193);
      if (Build.VERSION.SDK_INT >= 14) {
        this.aTJ.setHinting(0);
      }
      this.aTJ.setStyle(Paint.Style.STROKE);
      this.aTJ.setTypeface(Typeface.DEFAULT);
      this.aPk = h.ae.qU();
      AppMethodBeat.o(206573);
    }
    
    g(g paramg)
    {
      AppMethodBeat.i(206574);
      this.aTG = paramg.aTG;
      this.aTH = paramg.aTH;
      this.aTI = new Paint(paramg.aTI);
      this.aTJ = new Paint(paramg.aTJ);
      if (paramg.aQc != null) {
        this.aQc = new h.b(paramg.aQc);
      }
      if (paramg.aQb != null) {
        this.aQb = new h.b(paramg.aQb);
      }
      this.aTK = paramg.aTK;
      try
      {
        this.aPk = ((h.ae)paramg.aPk.clone());
        AppMethodBeat.o(206574);
        return;
      }
      catch (CloneNotSupportedException this$1)
      {
        this.aPk = h.ae.qU();
        AppMethodBeat.o(206574);
      }
    }
  }
  
  final class h
    extends i.i
  {
    RectF aTL;
    float x;
    float y;
    
    h(float paramFloat1, float paramFloat2)
    {
      super((byte)0);
      AppMethodBeat.i(206575);
      this.aTL = new RectF();
      this.x = paramFloat1;
      this.y = paramFloat2;
      AppMethodBeat.o(206575);
    }
    
    public final void ac(String paramString)
    {
      AppMethodBeat.i(206577);
      if (i.d(i.this))
      {
        Object localObject = new Rect();
        i.e(i.this).aTI.getTextBounds(paramString, 0, paramString.length(), (Rect)localObject);
        localObject = new RectF((Rect)localObject);
        ((RectF)localObject).offset(this.x, this.y);
        this.aTL.union((RectF)localObject);
      }
      this.x += i.e(i.this).aTI.measureText(paramString);
      AppMethodBeat.o(206577);
    }
    
    public final boolean b(h.ay paramay)
    {
      AppMethodBeat.i(206576);
      if ((paramay instanceof h.az))
      {
        Object localObject = (h.az)paramay;
        paramay = paramay.aSO.Z(((h.az)localObject).aQk);
        if (paramay == null)
        {
          i.f("TextPath path reference '%s' not found", new Object[] { ((h.az)localObject).aQk });
          AppMethodBeat.o(206576);
          return false;
        }
        localObject = (h.v)paramay;
        paramay = new i.c(((h.v)localObject).aQZ).lR;
        if (((h.v)localObject).transform != null) {
          paramay.transform(((h.v)localObject).transform);
        }
        localObject = new RectF();
        paramay.computeBounds((RectF)localObject, true);
        this.aTL.union((RectF)localObject);
        AppMethodBeat.o(206576);
        return false;
      }
      AppMethodBeat.o(206576);
      return true;
    }
  }
  
  abstract class i
  {
    private i() {}
    
    public abstract void ac(String paramString);
    
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
    
    public final void ac(String paramString)
    {
      AppMethodBeat.i(206578);
      this.x += i.e(i.this).aTI.measureText(paramString);
      AppMethodBeat.o(206578);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.a.a.i
 * JD-Core Version:    0.7.0.1
 */