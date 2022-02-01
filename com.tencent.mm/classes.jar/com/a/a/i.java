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
  private static HashSet<String> aBI = null;
  private Canvas aBC;
  float aBD;
  g aBE;
  private Stack<g> aBF;
  private Stack<h.aj> aBG;
  private Stack<Matrix> aBH;
  private b.p aBJ = null;
  private h aBi;
  
  i(Canvas paramCanvas, float paramFloat)
  {
    this.aBC = paramCanvas;
    this.aBD = paramFloat;
  }
  
  private static int F(float paramFloat)
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
    AppMethodBeat.i(202592);
    j localj = new j((byte)0);
    a(paramay, localj);
    float f = localj.x;
    AppMethodBeat.o(202592);
    return f;
  }
  
  private static Matrix a(h.b paramb1, h.b paramb2, f paramf)
  {
    AppMethodBeat.i(202601);
    Matrix localMatrix = new Matrix();
    if ((paramf == null) || (paramf.axS == null))
    {
      AppMethodBeat.o(202601);
      return localMatrix;
    }
    float f2 = paramb1.width / paramb2.width;
    float f3 = paramb1.height / paramb2.height;
    float f1 = -paramb2.minX;
    float f4 = -paramb2.minY;
    if (paramf.equals(f.axV))
    {
      localMatrix.preTranslate(paramb1.minX, paramb1.minY);
      localMatrix.preScale(f2, f3);
      localMatrix.preTranslate(f1, f4);
      AppMethodBeat.o(202601);
      return localMatrix;
    }
    float f5;
    if (paramf.axT == f.b.ayp)
    {
      f3 = Math.max(f2, f3);
      f2 = paramb1.width / f3;
      f5 = paramb1.height / f3;
      switch (1.aBK[paramf.axS.ordinal()])
      {
      default: 
        label204:
        f2 = f4;
        switch (1.aBK[paramf.axS.ordinal()])
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
      AppMethodBeat.o(202601);
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
    AppMethodBeat.i(202737);
    float f1;
    float f2;
    float f3;
    float f4;
    label71:
    label87:
    float f5;
    float f6;
    if ((paramab.ayQ == null) && (paramab.ayR == null))
    {
      f1 = 0.0F;
      f2 = 0.0F;
      f3 = Math.min(f2, paramab.azc.a(this) / 2.0F);
      f4 = Math.min(f1, paramab.azd.b(this) / 2.0F);
      if (paramab.aza == null) {
        break label273;
      }
      f1 = paramab.aza.a(this);
      if (paramab.azb == null) {
        break label278;
      }
      f2 = paramab.azb.b(this);
      f5 = paramab.azc.a(this);
      f6 = paramab.azd.b(this);
      if (paramab.aBe == null) {
        paramab.aBe = new h.b(f1, f2, f5, f6);
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
      AppMethodBeat.o(202737);
      return paramab;
      if (paramab.ayQ == null)
      {
        f2 = paramab.ayR.b(this);
        f1 = f2;
        break;
      }
      if (paramab.ayR == null)
      {
        f2 = paramab.ayQ.a(this);
        f1 = f2;
        break;
      }
      f2 = paramab.ayQ.a(this);
      f1 = paramab.ayR.b(this);
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
    AppMethodBeat.i(202714);
    this.aBF.push(this.aBE);
    this.aBE = new g(this.aBE);
    a(this.aBE, paramak);
    if ((!oK()) || (!visible()))
    {
      this.aBE = ((g)this.aBF.pop());
      AppMethodBeat.o(202714);
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
      localObject1 = paramak.aBi.Z(((h.be)localObject3).ayD);
      if (localObject1 == null)
      {
        String.format("Use reference '%s' not found", new Object[] { ((h.be)localObject3).ayD });
        this.aBE = ((g)this.aBF.pop());
        AppMethodBeat.o(202714);
        return null;
      }
      if (!(localObject1 instanceof h.ak))
      {
        this.aBE = ((g)this.aBF.pop());
        AppMethodBeat.o(202714);
        return null;
      }
      localObject2 = a((h.ak)localObject1, false);
      if (localObject2 == null)
      {
        AppMethodBeat.o(202714);
        return null;
      }
      if (((h.be)localObject3).aBe == null) {
        ((h.be)localObject3).aBe = e((Path)localObject2);
      }
      localObject1 = localObject2;
      if (((h.be)localObject3).transform != null)
      {
        ((Path)localObject2).transform(((h.be)localObject3).transform);
        localObject1 = localObject2;
      }
      if (this.aBE.axD.aAh != null)
      {
        paramak = c(paramak, paramak.aBe);
        if (paramak != null) {
          ((Path)localObject1).op(paramak, Path.Op.INTERSECT);
        }
      }
      this.aBE = ((g)this.aBF.pop());
      AppMethodBeat.o(202714);
      return localObject1;
    }
    if ((paramak instanceof h.l))
    {
      localObject3 = (h.l)paramak;
      if ((paramak instanceof h.v))
      {
        localObject2 = new c(((h.v)paramak).azs).aBZ;
        localObject1 = localObject2;
        if (paramak.aBe == null)
        {
          paramak.aBe = e((Path)localObject2);
          localObject1 = localObject2;
        }
      }
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        AppMethodBeat.o(202714);
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
        if (((h.l)localObject3).aBe == null) {
          ((h.l)localObject3).aBe = e((Path)localObject1);
        }
        if (((h.l)localObject3).transform != null) {
          ((Path)localObject1).transform(((h.l)localObject3).transform);
        }
        ((Path)localObject1).setFillType(oP());
        break;
        if ((paramak instanceof h.aw))
        {
          localObject2 = (h.aw)paramak;
          localObject1 = a((h.aw)localObject2);
          if (((h.aw)localObject2).transform != null) {
            ((Path)localObject1).transform(((h.aw)localObject2).transform);
          }
          ((Path)localObject1).setFillType(oP());
          break;
        }
        String.format("Invalid %s element found in clipPath definition", new Object[] { paramak.om() });
        AppMethodBeat.o(202714);
        return null;
      }
      localObject1 = null;
    }
  }
  
  private Path a(h.aw paramaw)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(202758);
    float f1;
    float f3;
    label51:
    float f4;
    label73:
    float f5;
    if ((paramaw.aBo == null) || (paramaw.aBo.size() == 0))
    {
      f1 = 0.0F;
      if ((paramaw.aBp != null) && (paramaw.aBp.size() != 0)) {
        break label277;
      }
      f3 = 0.0F;
      if ((paramaw.aBq != null) && (paramaw.aBq.size() != 0)) {
        break label299;
      }
      f4 = 0.0F;
      f5 = f2;
      if (paramaw.aBr != null)
      {
        if (paramaw.aBr.size() != 0) {
          break label321;
        }
        f5 = f2;
      }
      label98:
      f2 = f1;
      if (this.aBE.axD.azX != h.ae.f.aAJ)
      {
        f2 = a(paramaw);
        if (this.aBE.axD.azX != h.ae.f.aAK) {
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
      if (paramaw.aBe == null)
      {
        localObject = new h(f2, f3);
        a(paramaw, (i)localObject);
        paramaw.aBe = new h.b(((h)localObject).aCi.left, ((h)localObject).aCi.top, ((h)localObject).aCi.width(), ((h)localObject).aCi.height());
      }
      Object localObject = new Path();
      a(paramaw, new f(f2 + f4, f5 + f3, (Path)localObject));
      AppMethodBeat.o(202758);
      return localObject;
      f1 = ((h.p)paramaw.aBo.get(0)).a(this);
      break;
      f3 = ((h.p)paramaw.aBp.get(0)).b(this);
      break label51;
      f4 = ((h.p)paramaw.aBq.get(0)).a(this);
      break label73;
      f5 = ((h.p)paramaw.aBr.get(0)).b(this);
      break label98;
    }
  }
  
  private Path a(h.d paramd)
  {
    AppMethodBeat.i(202748);
    float f1;
    if (paramd.ayI != null)
    {
      f1 = paramd.ayI.a(this);
      if (paramd.ayJ == null) {
        break label217;
      }
    }
    label217:
    for (float f2 = paramd.ayJ.b(this);; f2 = 0.0F)
    {
      float f7 = paramd.ayK.c(this);
      float f3 = f1 - f7;
      float f4 = f2 - f7;
      float f5 = f1 + f7;
      float f6 = f2 + f7;
      if (paramd.aBe == null) {
        paramd.aBe = new h.b(f3, f4, 2.0F * f7, 2.0F * f7);
      }
      f7 *= 0.5522848F;
      paramd = new Path();
      paramd.moveTo(f1, f4);
      paramd.cubicTo(f1 + f7, f4, f5, f2 - f7, f5, f2);
      paramd.cubicTo(f5, f2 + f7, f1 + f7, f6, f1, f6);
      paramd.cubicTo(f1 - f7, f6, f3, f2 + f7, f3, f2);
      paramd.cubicTo(f3, f2 - f7, f1 - f7, f4, f1, f4);
      paramd.close();
      AppMethodBeat.o(202748);
      return paramd;
      f1 = 0.0F;
      break;
    }
  }
  
  private Path a(h.i parami)
  {
    AppMethodBeat.i(202752);
    float f1;
    if (parami.ayI != null)
    {
      f1 = parami.ayI.a(this);
      if (parami.ayJ == null) {
        break label234;
      }
    }
    label234:
    for (float f2 = parami.ayJ.b(this);; f2 = 0.0F)
    {
      float f8 = parami.ayQ.a(this);
      float f7 = parami.ayR.b(this);
      float f3 = f1 - f8;
      float f4 = f2 - f7;
      float f5 = f1 + f8;
      float f6 = f2 + f7;
      if (parami.aBe == null) {
        parami.aBe = new h.b(f3, f4, 2.0F * f8, 2.0F * f7);
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
      AppMethodBeat.o(202752);
      return parami;
      f1 = 0.0F;
      break;
    }
  }
  
  private static Typeface a(String paramString, Integer paramInteger, h.ae.b paramb)
  {
    int k = 0;
    AppMethodBeat.i(202642);
    int i;
    int j;
    if (paramb == h.ae.b.aAu)
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
      AppMethodBeat.o(202642);
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
    AppMethodBeat.i(202507);
    float f1;
    float f3;
    if (paramp1 != null)
    {
      f1 = paramp1.a(this);
      if (paramp2 != null) {
        f2 = paramp2.b(this);
      }
      paramp1 = oC();
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
      AppMethodBeat.o(202507);
      return paramp1;
      f1 = 0.0F;
      break;
      f3 = paramp1.width;
      break label47;
    }
  }
  
  private g a(h.an paraman, g paramg)
  {
    AppMethodBeat.i(202673);
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      if ((paraman instanceof h.al)) {
        localArrayList.add(0, (h.al)paraman);
      }
      if (paraman.aBj == null) {
        break;
      }
      paraman = (h.an)paraman.aBj;
    }
    paraman = localArrayList.iterator();
    while (paraman.hasNext()) {
      a(paramg, (h.al)paraman.next());
    }
    paramg.ayu = this.aBE.ayu;
    paramg.ayv = this.aBE.ayv;
    AppMethodBeat.o(202673);
    return paramg;
  }
  
  private String a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(202595);
    if (this.aBE.aCh)
    {
      paramString = paramString.replaceAll("[\\n\\t]", " ");
      AppMethodBeat.o(202595);
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
    AppMethodBeat.o(202595);
    return paramString;
  }
  
  private List<b> a(h.z paramz)
  {
    int i = 2;
    AppMethodBeat.i(202577);
    int j = paramz.azB.length;
    if (j < 2)
    {
      AppMethodBeat.o(202577);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    b localb = new b(paramz.azB[0], paramz.azB[1], 0.0F, 0.0F);
    float f2 = 0.0F;
    float f1 = 0.0F;
    while (i < j)
    {
      f1 = paramz.azB[i];
      f2 = paramz.azB[(i + 1)];
      localb.n(f1, f2);
      localArrayList.add(localb);
      localb = new b(f1, f2, f1 - localb.x, f2 - localb.y);
      i += 2;
    }
    if ((paramz instanceof h.aa)) {
      if ((f1 != paramz.azB[0]) && (f2 != paramz.azB[1]))
      {
        f1 = paramz.azB[0];
        f2 = paramz.azB[1];
        localb.n(f1, f2);
        localArrayList.add(localb);
        paramz = new b(f1, f2, f1 - localb.x, f2 - localb.y);
        paramz.a((b)localArrayList.get(0));
        localArrayList.add(paramz);
        localArrayList.set(0, paramz);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(202577);
      return localArrayList;
      localArrayList.add(localb);
    }
  }
  
  private void a(h.af paramaf, h.b paramb1, h.b paramb2, f paramf)
  {
    AppMethodBeat.i(202497);
    if ((paramb1.width == 0.0F) || (paramb1.height == 0.0F))
    {
      AppMethodBeat.o(202497);
      return;
    }
    if (paramf == null) {
      if (paramaf.ays != null) {
        paramf = paramaf.ays;
      }
    }
    for (;;)
    {
      a(this.aBE, paramaf);
      if (!oK())
      {
        AppMethodBeat.o(202497);
        return;
        paramf = f.axW;
      }
      else
      {
        this.aBE.ayv = paramb1;
        if (!this.aBE.axD.azY.booleanValue()) {
          g(this.aBE.ayv.minX, this.aBE.ayv.minY, this.aBE.ayv.width, this.aBE.ayv.height);
        }
        b(paramaf, this.aBE.ayv);
        if (paramb2 != null)
        {
          this.aBC.concat(a(this.aBE.ayv, paramb2, paramf));
          this.aBE.ayu = paramaf.ayu;
        }
        for (;;)
        {
          boolean bool = oG();
          oM();
          a(paramaf, true);
          if (bool) {
            b(paramaf);
          }
          a(paramaf);
          AppMethodBeat.o(202497);
          return;
          this.aBC.translate(this.aBE.ayv.minX, this.aBE.ayv.minY);
        }
      }
    }
  }
  
  private void a(h.aj paramaj)
  {
    AppMethodBeat.i(202458);
    this.aBG.push(paramaj);
    this.aBH.push(this.aBC.getMatrix());
    AppMethodBeat.o(202458);
  }
  
  private void a(h.aj paramaj, boolean paramBoolean)
  {
    AppMethodBeat.i(202448);
    if (paramBoolean) {
      a(paramaj);
    }
    paramaj = paramaj.oq().iterator();
    while (paramaj.hasNext()) {
      b((h.an)paramaj.next());
    }
    if (paramBoolean) {
      oF();
    }
    AppMethodBeat.o(202448);
  }
  
  private void a(h.ak paramak)
  {
    AppMethodBeat.i(202533);
    if (paramak.aBj == null)
    {
      AppMethodBeat.o(202533);
      return;
    }
    if (paramak.aBe == null)
    {
      AppMethodBeat.o(202533);
      return;
    }
    Matrix localMatrix = new Matrix();
    if (((Matrix)this.aBH.peek()).invert(localMatrix))
    {
      Object localObject = new float[8];
      localObject[0] = paramak.aBe.minX;
      localObject[1] = paramak.aBe.minY;
      localObject[2] = paramak.aBe.on();
      localObject[3] = paramak.aBe.minY;
      localObject[4] = paramak.aBe.on();
      localObject[5] = paramak.aBe.oo();
      localObject[6] = paramak.aBe.minX;
      localObject[7] = paramak.aBe.oo();
      localMatrix.preConcat(this.aBC.getMatrix());
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
      localObject = (h.ak)this.aBG.peek();
      if (((h.ak)localObject).aBe == null)
      {
        ((h.ak)localObject).aBe = h.b.e(paramak.left, paramak.top, paramak.right, paramak.bottom);
        AppMethodBeat.o(202533);
        return;
      }
      ((h.ak)localObject).aBe.a(h.b.e(paramak.left, paramak.top, paramak.right, paramak.bottom));
    }
    AppMethodBeat.o(202533);
  }
  
  private void a(h.ak paramak, Path paramPath)
  {
    AppMethodBeat.i(202476);
    if ((this.aBE.axD.azE instanceof h.u))
    {
      h.an localan = this.aBi.Z(((h.u)this.aBE.axD.azE).ayD);
      if ((localan instanceof h.y))
      {
        a(paramak, paramPath, (h.y)localan);
        AppMethodBeat.o(202476);
        return;
      }
    }
    this.aBC.drawPath(paramPath, this.aBE.aCf);
    AppMethodBeat.o(202476);
  }
  
  private void a(h.ak paramak, Path paramPath, h.y paramy)
  {
    AppMethodBeat.i(202767);
    int i;
    float f1;
    label63:
    float f2;
    label80:
    float f3;
    if ((paramy.azy != null) && (paramy.azy.booleanValue()))
    {
      i = 1;
      if (paramy.ayD != null) {
        a(paramy, paramy.ayD);
      }
      if (i == 0) {
        break label189;
      }
      if (paramy.aza == null) {
        break label165;
      }
      f1 = paramy.aza.a(this);
      if (paramy.azb == null) {
        break label171;
      }
      f2 = paramy.azb.b(this);
      if (paramy.azc == null) {
        break label177;
      }
      f3 = paramy.azc.a(this);
      label97:
      if (paramy.azd == null) {
        break label183;
      }
    }
    label165:
    label171:
    label177:
    label183:
    for (float f4 = paramy.azd.b(this);; f4 = 0.0F)
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
      AppMethodBeat.o(202767);
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
    if (paramy.aza != null)
    {
      f1 = paramy.aza.a(this, 1.0F);
      label207:
      if (paramy.azb == null) {
        break label366;
      }
      f2 = paramy.azb.a(this, 1.0F);
      label225:
      if (paramy.azc == null) {
        break label372;
      }
      f3 = paramy.azc.a(this, 1.0F);
      label243:
      if (paramy.azd == null) {
        break label378;
      }
    }
    label366:
    label372:
    label378:
    for (f4 = paramy.azd.a(this, 1.0F);; f4 = 0.0F)
    {
      f6 = paramak.aBe.minX;
      f7 = paramak.aBe.width;
      f8 = paramak.aBe.minY;
      float f9 = paramak.aBe.height;
      float f10 = paramak.aBe.width;
      f5 = f4 * paramak.aBe.height;
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
    if (paramy.ays != null) {}
    Object localObject;
    for (f localf = paramy.ays;; localf = f.axW)
    {
      oD();
      this.aBC.clipPath(paramPath);
      paramPath = new g();
      a(paramPath, h.ae.ot());
      paramPath.axD.azY = Boolean.FALSE;
      this.aBE = a(paramy, paramPath);
      localObject = paramak.aBe;
      paramPath = (Path)localObject;
      if (paramy.azA == null) {
        break label775;
      }
      this.aBC.concat(paramy.azA);
      Matrix localMatrix = new Matrix();
      paramPath = (Path)localObject;
      if (!paramy.azA.invert(localMatrix)) {
        break label775;
      }
      paramPath = new float[8];
      paramPath[0] = paramak.aBe.minX;
      paramPath[1] = paramak.aBe.minY;
      paramPath[2] = paramak.aBe.on();
      paramPath[3] = paramak.aBe.minY;
      paramPath[4] = paramak.aBe.on();
      paramPath[5] = paramak.aBe.oo();
      paramPath[6] = paramak.aBe.minX;
      paramPath[7] = paramak.aBe.oo();
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
    float f7 = paramPath.on();
    float f8 = paramPath.oo();
    paramPath = new h.b(0.0F, 0.0F, f2, f1);
    boolean bool = oG();
    for (f4 = f5 * f1 + f4; f4 < f8; f4 += f1) {
      for (f5 = f3 + f6 * f2; f5 < f7; f5 += f2)
      {
        paramPath.minX = f5;
        paramPath.minY = f4;
        oD();
        if (!this.aBE.axD.azY.booleanValue()) {
          g(paramPath.minX, paramPath.minY, paramPath.width, paramPath.height);
        }
        if (paramy.ayu != null)
        {
          this.aBC.concat(a(paramPath, paramy.ayu, localf));
          localObject = paramy.ayS.iterator();
          while (((Iterator)localObject).hasNext()) {
            b((h.an)((Iterator)localObject).next());
          }
        }
        if ((paramy.azz == null) || (paramy.azz.booleanValue())) {}
        for (i = 1;; i = 0)
        {
          this.aBC.translate(f5, f4);
          if (i != 0) {
            break;
          }
          this.aBC.scale(paramak.aBe.width, paramak.aBe.height);
          break;
        }
        oE();
      }
    }
    if (bool) {
      b(paramy);
    }
    oE();
    AppMethodBeat.o(202767);
  }
  
  private void a(h.ak paramak, h.b paramb)
  {
    AppMethodBeat.i(202546);
    if (this.aBE.axD.aAj != null)
    {
      Object localObject = new Paint();
      ((Paint)localObject).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
      this.aBC.saveLayer(null, (Paint)localObject, 31);
      localObject = new Paint();
      ((Paint)localObject).setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2127F, 0.7151F, 0.0722F, 0.0F, 0.0F })));
      this.aBC.saveLayer(null, (Paint)localObject, 31);
      localObject = this.aBi.Z(this.aBE.axD.aAj);
      a((h.s)localObject, paramak, paramb);
      this.aBC.restore();
      Paint localPaint = new Paint();
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
      this.aBC.saveLayer(null, localPaint, 31);
      a((h.s)localObject, paramak, paramb);
      this.aBC.restore();
      this.aBC.restore();
    }
    oE();
    AppMethodBeat.o(202546);
  }
  
  private static void a(h.am paramam1, h.am paramam2)
  {
    if (paramam1.azf == null) {
      paramam1.azf = paramam2.azf;
    }
    if (paramam1.azg == null) {
      paramam1.azg = paramam2.azg;
    }
    if (paramam1.azh == null) {
      paramam1.azh = paramam2.azh;
    }
    if (paramam1.azi == null) {
      paramam1.azi = paramam2.azi;
    }
  }
  
  private void a(h.an paraman, boolean paramBoolean, Path paramPath, Matrix paramMatrix)
  {
    AppMethodBeat.i(202719);
    if (!oK())
    {
      AppMethodBeat.o(202719);
      return;
    }
    oN();
    if ((paraman instanceof h.be)) {
      if (paramBoolean) {
        a((h.be)paraman, paramPath, paramMatrix);
      }
    }
    for (;;)
    {
      oO();
      AppMethodBeat.o(202719);
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
    if (paramaq1.ayI == null) {
      paramaq1.ayI = paramaq2.ayI;
    }
    if (paramaq1.ayJ == null) {
      paramaq1.ayJ = paramaq2.ayJ;
    }
    if (paramaq1.ayK == null) {
      paramaq1.ayK = paramaq2.ayK;
    }
    if (paramaq1.aBk == null) {
      paramaq1.aBk = paramaq2.aBk;
    }
    if (paramaq1.aBl == null) {
      paramaq1.aBl = paramaq2.aBl;
    }
  }
  
  private void a(h.aw paramaw, Path paramPath, Matrix paramMatrix)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(202732);
    a(this.aBE, paramaw);
    if (!oK())
    {
      AppMethodBeat.o(202732);
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
    if ((paramaw.aBo == null) || (paramaw.aBo.size() == 0))
    {
      f1 = 0.0F;
      if ((paramaw.aBp != null) && (paramaw.aBp.size() != 0)) {
        break label347;
      }
      f3 = 0.0F;
      if ((paramaw.aBq != null) && (paramaw.aBq.size() != 0)) {
        break label369;
      }
      f4 = 0.0F;
      f5 = f2;
      if (paramaw.aBr != null)
      {
        if (paramaw.aBr.size() != 0) {
          break label391;
        }
        f5 = f2;
      }
      label141:
      f2 = f1;
      if (this.aBE.axD.azX != h.ae.f.aAJ)
      {
        f2 = a(paramaw);
        if (this.aBE.axD.azX != h.ae.f.aAK) {
          break label413;
        }
      }
    }
    label391:
    label413:
    for (f2 = f1 - f2 / 2.0F;; f2 = f1 - f2)
    {
      if (paramaw.aBe == null)
      {
        localObject = new h(f2, f3);
        a(paramaw, (i)localObject);
        paramaw.aBe = new h.b(((h)localObject).aCi.left, ((h)localObject).aCi.top, ((h)localObject).aCi.width(), ((h)localObject).aCi.height());
      }
      d(paramaw);
      Object localObject = new Path();
      a(paramaw, new f(f2 + f4, f5 + f3, (Path)localObject));
      paramPath.setFillType(oP());
      paramPath.addPath((Path)localObject, paramMatrix);
      AppMethodBeat.o(202732);
      return;
      f1 = ((h.p)paramaw.aBo.get(0)).a(this);
      break;
      label347:
      f3 = ((h.p)paramaw.aBp.get(0)).b(this);
      break label92;
      label369:
      f4 = ((h.p)paramaw.aBq.get(0)).a(this);
      break label114;
      f5 = ((h.p)paramaw.aBr.get(0)).b(this);
      break label141;
    }
  }
  
  private void a(h.ay paramay, i parami)
  {
    AppMethodBeat.i(202590);
    if (!oK())
    {
      AppMethodBeat.o(202590);
      return;
    }
    paramay = paramay.ayS.iterator();
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
          oD();
          localObject1 = (h.az)localObject2;
          a(this.aBE, (h.al)localObject1);
          if ((oK()) && (visible()))
          {
            localObject2 = ((h.az)localObject1).aBi.Z(((h.az)localObject1).ayD);
            if (localObject2 != null) {
              break label210;
            }
            String.format("TextPath reference '%s' not found", new Object[] { ((h.az)localObject1).ayD });
          }
          oE();
        }
      }
      Object localObject3 = (h.v)localObject2;
      localObject2 = new c(((h.v)localObject3).azs).aBZ;
      if (((h.v)localObject3).transform != null) {
        ((Path)localObject2).transform(((h.v)localObject3).transform);
      }
      localObject3 = new PathMeasure((Path)localObject2, false);
      if (((h.az)localObject1).aBn != null)
      {
        f1 = ((h.az)localObject1).aBn.a(this, ((PathMeasure)localObject3).getLength());
        label287:
        localObject3 = oJ();
        if (localObject3 == h.ae.f.aAJ) {
          break label938;
        }
        f2 = a((h.ay)localObject1);
        if (localObject3 != h.ae.f.aAK) {
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
      c((h.ak)((h.az)localObject1).aBm);
      bool1 = oG();
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
        oD();
        localObject1 = (h.av)localObject2;
        a(this.aBE, (h.al)localObject1);
        if (oK())
        {
          f1 = 0.0F;
          f4 = 0.0F;
          f2 = 0.0F;
          if ((((h.av)localObject1).aBo == null) || (((h.av)localObject1).aBo.size() <= 0)) {
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
          if ((((h.av)localObject1).aBp != null) && (((h.av)localObject1).aBp.size() != 0)) {
            break label707;
          }
          f3 = ((e)parami).y;
          if ((((h.av)localObject1).aBq != null) && (((h.av)localObject1).aBq.size() != 0)) {
            break label730;
          }
          f2 = 0.0F;
          if ((((h.av)localObject1).aBr != null) && (((h.av)localObject1).aBr.size() != 0)) {
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
          localObject2 = oJ();
          if (localObject2 != h.ae.f.aAJ)
          {
            f5 = a((h.ay)localObject1);
            if (localObject2 == h.ae.f.aAK) {
              f1 -= f5 / 2.0F;
            }
          }
        }
        for (;;)
        {
          c((h.ak)((h.av)localObject1).aBm);
          if ((parami instanceof e))
          {
            ((e)parami).x = (f1 + f2);
            ((e)parami).y = (f4 + f3);
          }
          bool1 = oG();
          a((h.ay)localObject1, parami);
          if (bool1) {
            b((h.ak)localObject1);
          }
          oE();
          break;
          i = 0;
          break label454;
          label685:
          f1 = ((h.p)((h.av)localObject1).aBo.get(0)).a(this);
          break label474;
          label707:
          f3 = ((h.p)((h.av)localObject1).aBp.get(0)).b(this);
          break label504;
          label730:
          f2 = ((h.p)((h.av)localObject1).aBq.get(0)).a(this);
          break label528;
          label753:
          f4 = ((h.p)((h.av)localObject1).aBr.get(0)).b(this);
          break label552;
          f1 -= f5;
          continue;
          if (!(localObject2 instanceof h.au)) {
            break;
          }
          oD();
          localObject1 = (h.au)localObject2;
          a(this.aBE, (h.al)localObject1);
          if (!oK()) {
            break label203;
          }
          c((h.ak)((h.au)localObject1).aBm);
          localObject2 = ((h.an)localObject2).aBi.Z(((h.au)localObject1).ayD);
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
          String.format("Tref reference '%s' not found", new Object[] { ((h.au)localObject1).ayD });
          break label203;
          AppMethodBeat.o(202590);
          return;
        }
      }
    }
  }
  
  private void a(h.ay paramay, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(202593);
    paramay = paramay.ayS.iterator();
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
    AppMethodBeat.o(202593);
  }
  
  private void a(h.be parambe, Path paramPath, Matrix paramMatrix)
  {
    AppMethodBeat.i(202728);
    a(this.aBE, parambe);
    if (!oK())
    {
      AppMethodBeat.o(202728);
      return;
    }
    if (!visible())
    {
      AppMethodBeat.o(202728);
      return;
    }
    if (parambe.transform != null) {
      paramMatrix.preConcat(parambe.transform);
    }
    h.an localan = parambe.aBi.Z(parambe.ayD);
    if (localan == null)
    {
      String.format("Use reference '%s' not found", new Object[] { parambe.ayD });
      AppMethodBeat.o(202728);
      return;
    }
    d(parambe);
    a(localan, false, paramPath, paramMatrix);
    AppMethodBeat.o(202728);
  }
  
  private static void a(h.j paramj, String paramString)
  {
    AppMethodBeat.i(202693);
    for (;;)
    {
      h.an localan = paramj.aBi.Z(paramString);
      if (localan == null)
      {
        String.format("Gradient reference '%s' not found", new Object[] { paramString });
        AppMethodBeat.o(202693);
        return;
      }
      if (!(localan instanceof h.j))
      {
        String.format("Gradient href attributes must point to other gradient elements", new Object[0]);
        AppMethodBeat.o(202693);
        return;
      }
      if (localan == paramj)
      {
        String.format("Circular reference in gradient href attribute '%s'", new Object[] { paramString });
        AppMethodBeat.o(202693);
        return;
      }
      paramString = (h.j)localan;
      if (paramj.ayT == null) {
        paramj.ayT = paramString.ayT;
      }
      if (paramj.ayU == null) {
        paramj.ayU = paramString.ayU;
      }
      if (paramj.ayV == null) {
        paramj.ayV = paramString.ayV;
      }
      if (paramj.ayS.isEmpty()) {
        paramj.ayS = paramString.ayS;
      }
      try
      {
        if ((paramj instanceof h.am)) {
          a((h.am)paramj, (h.am)localan);
        }
        for (;;)
        {
          label181:
          if (paramString.ayD == null) {
            break label214;
          }
          paramString = paramString.ayD;
          break;
          a((h.aq)paramj, (h.aq)localan);
        }
      }
      catch (ClassCastException localClassCastException)
      {
        break label181;
        label214:
        AppMethodBeat.o(202693);
      }
    }
  }
  
  private void a(h.l paraml)
  {
    AppMethodBeat.i(202667);
    if ((this.aBE.axD.aAa == null) && (this.aBE.axD.aAb == null) && (this.aBE.axD.aAc == null))
    {
      AppMethodBeat.o(202667);
      return;
    }
    Object localObject1;
    Object localObject2;
    label140:
    Object localObject3;
    if (this.aBE.axD.aAa != null)
    {
      localObject1 = paraml.aBi.Z(this.aBE.axD.aAa);
      if (localObject1 != null)
      {
        localObject1 = (h.r)localObject1;
        if (this.aBE.axD.aAb == null) {
          break label275;
        }
        localObject2 = paraml.aBi.Z(this.aBE.axD.aAb);
        if (localObject2 == null) {
          break label251;
        }
        localObject2 = (h.r)localObject2;
        if (this.aBE.axD.aAc == null) {
          break label305;
        }
        localObject3 = paraml.aBi.Z(this.aBE.axD.aAc);
        if (localObject3 == null) {
          break label281;
        }
        localObject3 = (h.r)localObject3;
        label184:
        if (!(paraml instanceof h.v)) {
          break label311;
        }
        paraml = new a(((h.v)paraml).azs).aBN;
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
      AppMethodBeat.o(202667);
      return;
      String.format("Marker reference '%s' not found", new Object[] { this.aBE.axD.aAa });
      localObject1 = null;
      break;
      String.format("Marker reference '%s' not found", new Object[] { this.aBE.axD.aAb });
      localObject2 = null;
      break label140;
      String.format("Marker reference '%s' not found", new Object[] { this.aBE.axD.aAc });
      localObject3 = null;
      break label184;
      if ((paraml instanceof h.q))
      {
        paraml = (h.q)paraml;
        label355:
        float f3;
        if (paraml.azf != null)
        {
          f1 = paraml.azf.a(this);
          if (paraml.azg == null) {
            break label458;
          }
          f2 = paraml.azg.b(this);
          if (paraml.azh == null) {
            break label463;
          }
          f3 = paraml.azh.a(this);
          label372:
          if (paraml.azi == null) {
            break label469;
          }
        }
        label458:
        label463:
        label469:
        for (float f4 = paraml.azi.b(this);; f4 = 0.0F)
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
      AppMethodBeat.o(202667);
      return;
    }
    Object localObject4 = this.aBE.axD;
    Object localObject5 = this.aBE.axD;
    this.aBE.axD.aAc = null;
    ((h.ae)localObject5).aAb = null;
    ((h.ae)localObject4).aAa = null;
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
        if (!((b)localObject1).aBY) {
          break label852;
        }
        f1 = ((b)localObject1).aBW;
        f2 = ((b)localObject1).aBX;
        f2 = f1 * (((b)localObject1).x - ((b)localObject4).x) + (((b)localObject1).y - ((b)localObject4).y) * f2;
        f1 = f2;
        if (f2 == 0.0F)
        {
          f1 = ((b)localObject1).aBW;
          f2 = ((b)localObject1).aBX;
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
      if ((f1 != 0.0F) || ((((b)localObject1).aBW <= 0.0F) && (((b)localObject1).aBX < 0.0F)))
      {
        ((b)localObject1).aBW = (-((b)localObject1).aBW);
        ((b)localObject1).aBX = (-((b)localObject1).aBX);
        continue;
        if (localObject3 != null) {
          a((h.r)localObject3, (b)paraml.get(j - 1));
        }
        AppMethodBeat.o(202667);
        return;
      }
    }
  }
  
  private void a(h.l paraml, Path paramPath, Matrix paramMatrix)
  {
    AppMethodBeat.i(202727);
    a(this.aBE, paraml);
    if (!oK())
    {
      AppMethodBeat.o(202727);
      return;
    }
    if (!visible())
    {
      AppMethodBeat.o(202727);
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
      paramPath.setFillType(oP());
      paramPath.addPath(localPath, paramMatrix);
      AppMethodBeat.o(202727);
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
    AppMethodBeat.o(202727);
  }
  
  private void a(h.r paramr, b paramb)
  {
    float f4 = 3.0F;
    float f8 = 0.0F;
    AppMethodBeat.i(202671);
    oD();
    float f1;
    if (paramr.azo != null) {
      if (Float.isNaN(paramr.azo.floatValue()))
      {
        if ((paramb.aBW == 0.0F) && (paramb.aBX == 0.0F)) {
          break label696;
        }
        f1 = (float)Math.toDegrees(Math.atan2(paramb.aBX, paramb.aBW));
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
      if (paramr.azj)
      {
        f2 = 1.0F;
        this.aBE = d(paramr);
        localMatrix = new Matrix();
        localMatrix.preTranslate(paramb.x, paramb.y);
        localMatrix.preRotate(f1);
        localMatrix.preScale(f2, f2);
        if (paramr.azk == null) {
          break label557;
        }
        f2 = paramr.azk.a(this);
        if (paramr.azl == null) {
          break label563;
        }
        f5 = paramr.azl.b(this);
        if (paramr.azm == null) {
          break label569;
        }
        f3 = paramr.azm.a(this);
        if (paramr.azn != null) {
          f4 = paramr.azn.b(this);
        }
        if (paramr.ayu == null) {
          break label643;
        }
        f7 = f3 / paramr.ayu.width;
        f6 = f4 / paramr.ayu.height;
        if (paramr.ays == null) {
          break label577;
        }
        paramb = paramr.ays;
        label244:
        if (paramb.equals(f.axV)) {
          break label693;
        }
        if (paramb.axT != f.b.ayp) {
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
        this.aBC.concat(localMatrix);
        f1 = paramr.ayu.width * f7;
        f5 = paramr.ayu.height * f6;
        switch (1.aBK[paramb.axS.ordinal()])
        {
        default: 
          f1 = 0.0F;
          label378:
          f2 = f8;
          switch (1.aBK[paramb.axS.ordinal()])
          {
          default: 
            f2 = f8;
          case 4: 
            label440:
            if (!this.aBE.axD.azY.booleanValue()) {
              g(f1, f2, f3, f4);
            }
            localMatrix.reset();
            localMatrix.preScale(f7, f6);
            this.aBC.concat(localMatrix);
          }
          break;
        }
        for (;;)
        {
          boolean bool = oG();
          a(paramr, false);
          if (bool) {
            b(paramr);
          }
          oE();
          AppMethodBeat.o(202671);
          return;
          f1 = paramr.azo.floatValue();
          break;
          f2 = this.aBE.axD.azJ.E(this.aBD);
          break label84;
          f2 = 0.0F;
          break label150;
          f5 = 0.0F;
          break label167;
          label569:
          f3 = 3.0F;
          break label184;
          label577:
          paramb = f.axW;
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
          this.aBC.concat(localMatrix);
          if (!this.aBE.axD.azY.booleanValue()) {
            g(0.0F, 0.0F, f3, f4);
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
    AppMethodBeat.i(202774);
    if ((params.azp != null) && (params.azp.booleanValue()))
    {
      i = 1;
      if (i == 0) {
        break label115;
      }
      if (params.azc == null) {
        break label97;
      }
      f1 = params.azc.a(this);
      label53:
      if (params.azd == null) {
        break label106;
      }
    }
    label97:
    label106:
    for (f2 = params.azd.b(this);; f2 = paramb.height)
    {
      if ((f1 != 0.0F) && (f2 != 0.0F)) {
        break label180;
      }
      AppMethodBeat.o(202774);
      return;
      i = 0;
      break;
      f1 = paramb.width;
      break label53;
    }
    label115:
    if (params.azc != null) {}
    for (float f1 = params.azc.a(this, 1.0F);; f1 = 1.2F)
    {
      if (params.azd != null) {
        f2 = params.azd.a(this, 1.0F);
      }
      f1 *= paramb.width;
      f2 *= paramb.height;
      break;
    }
    label180:
    oD();
    this.aBE = d(params);
    this.aBE.axD.azP = Float.valueOf(1.0F);
    boolean bool = oG();
    this.aBC.save();
    if ((params.azq == null) || (params.azq.booleanValue())) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.aBC.translate(paramb.minX, paramb.minY);
        this.aBC.scale(paramb.width, paramb.height);
      }
      a(params, false);
      this.aBC.restore();
      if (bool) {
        a(paramak, paramb);
      }
      oE();
      AppMethodBeat.o(202774);
      return;
    }
  }
  
  private void a(h.v paramv, Path paramPath, Matrix paramMatrix)
  {
    AppMethodBeat.i(202723);
    a(this.aBE, paramv);
    if (!oK())
    {
      AppMethodBeat.o(202723);
      return;
    }
    if (!visible())
    {
      AppMethodBeat.o(202723);
      return;
    }
    if (paramv.transform != null) {
      paramMatrix.preConcat(paramv.transform);
    }
    Path localPath = new c(paramv.azs).aBZ;
    if (paramv.aBe == null) {
      paramv.aBe = e(localPath);
    }
    d(paramv);
    paramPath.setFillType(oP());
    paramPath.addPath(localPath, paramMatrix);
    AppMethodBeat.o(202723);
  }
  
  private static void a(h.y paramy, String paramString)
  {
    AppMethodBeat.i(202773);
    for (;;)
    {
      h.an localan = paramy.aBi.Z(paramString);
      if (localan == null)
      {
        String.format("Pattern reference '%s' not found", new Object[] { paramString });
        AppMethodBeat.o(202773);
        return;
      }
      if (!(localan instanceof h.y))
      {
        String.format("Pattern href attributes must point to other pattern elements", new Object[0]);
        AppMethodBeat.o(202773);
        return;
      }
      if (localan == paramy)
      {
        String.format("Circular reference in pattern href attribute '%s'", new Object[] { paramString });
        AppMethodBeat.o(202773);
        return;
      }
      paramString = (h.y)localan;
      if (paramy.azy == null) {
        paramy.azy = paramString.azy;
      }
      if (paramy.azz == null) {
        paramy.azz = paramString.azz;
      }
      if (paramy.azA == null) {
        paramy.azA = paramString.azA;
      }
      if (paramy.aza == null) {
        paramy.aza = paramString.aza;
      }
      if (paramy.azb == null) {
        paramy.azb = paramString.azb;
      }
      if (paramy.azc == null) {
        paramy.azc = paramString.azc;
      }
      if (paramy.azd == null) {
        paramy.azd = paramString.azd;
      }
      if (paramy.ayS.isEmpty()) {
        paramy.ayS = paramString.ayS;
      }
      if (paramy.ayu == null) {
        paramy.ayu = paramString.ayu;
      }
      if (paramy.ays == null) {
        paramy.ays = paramString.ays;
      }
      if (paramString.ayD == null) {
        break;
      }
      paramString = paramString.ayD;
    }
    AppMethodBeat.o(202773);
  }
  
  private void a(g paramg, h.ae paramae)
  {
    boolean bool2 = true;
    AppMethodBeat.i(202635);
    if (a(paramae, 4096L)) {
      paramg.axD.azQ = paramae.azQ;
    }
    if (a(paramae, 2048L)) {
      paramg.axD.azP = paramae.azP;
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
      paramg.axD.azE = paramae.azE;
      if ((paramae.azE != null) && (paramae.azE != h.f.ayO))
      {
        bool1 = true;
        paramg.aCd = bool1;
      }
    }
    else
    {
      if (a(paramae, 4L)) {
        paramg.axD.azG = paramae.azG;
      }
      if (a(paramae, 6149L)) {
        a(paramg, true, paramg.axD.azE);
      }
      if (a(paramae, 2L)) {
        paramg.axD.azF = paramae.azF;
      }
      if (a(paramae, 8L))
      {
        paramg.axD.azH = paramae.azH;
        if ((paramae.azH == null) || (paramae.azH == h.f.ayO)) {
          break label1394;
        }
        bool1 = true;
        paramg.aCe = bool1;
      }
      if (a(paramae, 16L)) {
        paramg.axD.azI = paramae.azI;
      }
      if (a(paramae, 6168L)) {
        a(paramg, false, paramg.axD.azH);
      }
      if (a(paramae, 34359738368L)) {
        paramg.axD.aAo = paramae.aAo;
      }
      if (a(paramae, 32L))
      {
        paramg.axD.azJ = paramae.azJ;
        paramg.aCg.setStrokeWidth(paramg.axD.azJ.c(this));
      }
      if (a(paramae, 64L)) {
        paramg.axD.azK = paramae.azK;
      }
      switch (1.aBL[paramae.azK.ordinal()])
      {
      default: 
        if (a(paramae, 128L)) {
          paramg.axD.azL = paramae.azL;
        }
        switch (1.aBM[paramae.azL.ordinal()])
        {
        default: 
          if (a(paramae, 256L))
          {
            paramg.axD.azM = paramae.azM;
            paramg.aCg.setStrokeMiter(paramae.azM.floatValue());
          }
          if (a(paramae, 512L)) {
            paramg.axD.azN = paramae.azN;
          }
          if (a(paramae, 1024L)) {
            paramg.axD.azO = paramae.azO;
          }
          if (a(paramae, 1536L))
          {
            if (paramg.axD.azN == null) {
              paramg.aCg.setPathEffect(null);
            }
          }
          else
          {
            if (a(paramae, 16384L))
            {
              f1 = oB();
              paramg.axD.azS = paramae.azS;
              paramg.aCf.setTextSize(paramae.azS.a(this, f1));
              paramg.aCg.setTextSize(paramae.azS.a(this, f1));
            }
            if (a(paramae, 8192L)) {
              paramg.axD.azR = paramae.azR;
            }
            if (a(paramae, 32768L))
            {
              if ((paramae.azT.intValue() != -1) || (paramg.axD.azT.intValue() <= 100)) {
                break label1637;
              }
              localObject1 = paramg.axD;
              ((h.ae)localObject1).azT = Integer.valueOf(((h.ae)localObject1).azT.intValue() - 100);
            }
            if (a(paramae, 65536L)) {
              paramg.axD.azU = paramae.azU;
            }
            if (a(paramae, 106496L))
            {
              if ((paramg.axD.azR == null) || (this.aBi == null)) {
                break label1730;
              }
              j localj = h.ol();
              Iterator localIterator = paramg.axD.azR.iterator();
              localObject2 = null;
              do
              {
                localObject1 = localObject2;
                if (!localIterator.hasNext()) {
                  break;
                }
                localObject2 = a((String)localIterator.next(), paramg.axD.azT, paramg.axD.azU);
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  localObject1 = localObject2;
                  if (localj != null)
                  {
                    paramg.axD.azT.intValue();
                    String.valueOf(paramg.axD.azU);
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
        localObject2 = a("serif", paramg.axD.azT, paramg.axD.azU);
      }
      paramg.aCf.setTypeface((Typeface)localObject2);
      paramg.aCg.setTypeface((Typeface)localObject2);
      if (a(paramae, 131072L))
      {
        paramg.axD.azV = paramae.azV;
        localObject1 = paramg.aCf;
        if (paramae.azV != h.ae.g.aAQ) {
          break label1706;
        }
        bool1 = true;
        label930:
        ((Paint)localObject1).setStrikeThruText(bool1);
        localObject1 = paramg.aCf;
        if (paramae.azV != h.ae.g.aAO) {
          break label1712;
        }
        bool1 = true;
        label956:
        ((Paint)localObject1).setUnderlineText(bool1);
        if (Build.VERSION.SDK_INT >= 17)
        {
          localObject1 = paramg.aCg;
          if (paramae.azV != h.ae.g.aAQ) {
            break label1718;
          }
          bool1 = true;
          label990:
          ((Paint)localObject1).setStrikeThruText(bool1);
          localObject1 = paramg.aCg;
          if (paramae.azV != h.ae.g.aAO) {
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
          paramg.axD.azW = paramae.azW;
        }
        if (a(paramae, 262144L)) {
          paramg.axD.azX = paramae.azX;
        }
        if (a(paramae, 524288L)) {
          paramg.axD.azY = paramae.azY;
        }
        if (a(paramae, 2097152L)) {
          paramg.axD.aAa = paramae.aAa;
        }
        if (a(paramae, 4194304L)) {
          paramg.axD.aAb = paramae.aAb;
        }
        if (a(paramae, 8388608L)) {
          paramg.axD.aAc = paramae.aAc;
        }
        if (a(paramae, 16777216L)) {
          paramg.axD.aAd = paramae.aAd;
        }
        if (a(paramae, 33554432L)) {
          paramg.axD.aAe = paramae.aAe;
        }
        if (a(paramae, 1048576L)) {
          paramg.axD.azZ = paramae.azZ;
        }
        if (a(paramae, 268435456L)) {
          paramg.axD.aAh = paramae.aAh;
        }
        if (a(paramae, 536870912L)) {
          paramg.axD.aAi = paramae.aAi;
        }
        if (a(paramae, 1073741824L)) {
          paramg.axD.aAj = paramae.aAj;
        }
        if (a(paramae, 67108864L)) {
          paramg.axD.aAf = paramae.aAf;
        }
        if (a(paramae, 134217728L)) {
          paramg.axD.aAg = paramae.aAg;
        }
        if (a(paramae, 8589934592L)) {
          paramg.axD.aAm = paramae.aAm;
        }
        if (a(paramae, 17179869184L)) {
          paramg.axD.aAn = paramae.aAn;
        }
        if (a(paramae, 137438953472L)) {
          paramg.axD.aAp = paramae.aAp;
        }
        AppMethodBeat.o(202635);
        return;
        bool1 = false;
        break;
        label1394:
        bool1 = false;
        break label201;
        paramg.aCg.setStrokeCap(Paint.Cap.BUTT);
        break label368;
        paramg.aCg.setStrokeCap(Paint.Cap.ROUND);
        break label368;
        paramg.aCg.setStrokeCap(Paint.Cap.SQUARE);
        break label368;
        paramg.aCg.setStrokeJoin(Paint.Join.MITER);
        break label428;
        paramg.aCg.setStrokeJoin(Paint.Join.ROUND);
        break label428;
        paramg.aCg.setStrokeJoin(Paint.Join.BEVEL);
        break label428;
        int k = paramg.axD.azN.length;
        if (k % 2 == 0) {}
        for (int i = k;; i = k * 2)
        {
          localObject1 = new float[i];
          int j = 0;
          f1 = 0.0F;
          while (j < i)
          {
            localObject1[j] = paramg.axD.azN[(j % k)].c(this);
            f1 += localObject1[j];
            j += 1;
          }
        }
        if (f1 == 0.0F)
        {
          paramg.aCg.setPathEffect(null);
          break label534;
        }
        float f3 = paramg.axD.azO.c(this);
        float f2 = f3;
        if (f3 < 0.0F) {
          f2 = f3 % f1 + f1;
        }
        paramg.aCg.setPathEffect(new DashPathEffect((float[])localObject1, f2));
        break label534;
        label1637:
        if ((paramae.azT.intValue() == 1) && (paramg.axD.azT.intValue() < 900))
        {
          localObject1 = paramg.axD;
          ((h.ae)localObject1).azT = Integer.valueOf(((h.ae)localObject1).azT.intValue() + 100);
          break label674;
        }
        paramg.axD.azT = paramae.azT;
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
    AppMethodBeat.i(202467);
    if (paramal.aBj == null) {}
    for (boolean bool = true;; bool = false)
    {
      paramg.axD.aG(bool);
      if (paramal.aBg != null) {
        a(paramg, paramal.aBg);
      }
      if (!this.aBi.oj()) {
        break;
      }
      Iterator localIterator = this.aBi.ayA.axF.iterator();
      while (localIterator.hasNext())
      {
        b.o localo = (b.o)localIterator.next();
        if (b.a(this.aBJ, localo.axC, paramal)) {
          a(paramg, localo.axD);
        }
      }
    }
    if (paramal.axD != null) {
      a(paramg, paramal.axD);
    }
    AppMethodBeat.o(202467);
  }
  
  private static void a(g paramg, boolean paramBoolean, h.ao paramao)
  {
    AppMethodBeat.i(202639);
    Float localFloat;
    float f;
    if (paramBoolean)
    {
      localFloat = paramg.axD.azG;
      f = localFloat.floatValue();
      if (!(paramao instanceof h.f)) {
        break label81;
      }
    }
    for (int i = ((h.f)paramao).ayM;; i = paramg.axD.azQ.ayM)
    {
      i = f(i, f);
      if (!paramBoolean) {
        break label110;
      }
      paramg.aCf.setColor(i);
      AppMethodBeat.o(202639);
      return;
      localFloat = paramg.axD.azI;
      break;
      label81:
      if (!(paramao instanceof h.g)) {
        break label103;
      }
    }
    label103:
    AppMethodBeat.o(202639);
    return;
    label110:
    paramg.aCg.setColor(i);
    AppMethodBeat.o(202639);
  }
  
  private void a(boolean paramBoolean, h.ac paramac)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(202700);
    g localg;
    if (paramBoolean)
    {
      if (a(paramac.aBg, 2147483648L))
      {
        this.aBE.axD.azE = paramac.aBg.aAk;
        localg = this.aBE;
        if (paramac.aBg.aAk == null) {
          break label134;
        }
      }
      for (;;)
      {
        localg.aCd = bool1;
        if (a(paramac.aBg, 4294967296L)) {
          this.aBE.axD.azG = paramac.aBg.aAl;
        }
        if (!a(paramac.aBg, 6442450944L)) {
          break;
        }
        paramac = this.aBE;
        a(paramac, paramBoolean, paramac.axD.azE);
        AppMethodBeat.o(202700);
        return;
        label134:
        bool1 = false;
      }
    }
    if (a(paramac.aBg, 2147483648L))
    {
      this.aBE.axD.azH = paramac.aBg.aAk;
      localg = this.aBE;
      if (paramac.aBg.aAk == null) {
        break label261;
      }
    }
    label261:
    for (bool1 = bool2;; bool1 = false)
    {
      localg.aCe = bool1;
      if (a(paramac.aBg, 4294967296L)) {
        this.aBE.axD.azI = paramac.aBg.aAl;
      }
      if (a(paramac.aBg, 6442450944L))
      {
        paramac = this.aBE;
        a(paramac, paramBoolean, paramac.axD.azH);
      }
      AppMethodBeat.o(202700);
      return;
    }
  }
  
  private void a(boolean paramBoolean, h.b paramb, h.am paramam)
  {
    AppMethodBeat.i(202676);
    if (paramam.ayD != null) {
      a(paramam, paramam.ayD);
    }
    Paint localPaint;
    label54:
    float f2;
    label82:
    float f1;
    label99:
    float f3;
    if ((paramam.ayT != null) && (paramam.ayT.booleanValue()))
    {
      i = 1;
      if (!paramBoolean) {
        break label258;
      }
      localPaint = this.aBE.aCf;
      if (i == 0) {
        break label298;
      }
      localObject = oC();
      if (paramam.azf == null) {
        break label270;
      }
      f2 = paramam.azf.a(this);
      if (paramam.azg == null) {
        break label276;
      }
      f1 = paramam.azg.b(this);
      if (paramam.azh == null) {
        break label282;
      }
      f3 = paramam.azh.a(this);
      label116:
      if (paramam.azi == null) {
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
    for (float f4 = paramam.azi.b(this);; f4 = 0.0F)
    {
      f5 = f2;
      f2 = f1;
      oD();
      this.aBE = d(paramam);
      localMatrix = new Matrix();
      if (i == 0)
      {
        localMatrix.preTranslate(paramb.minX, paramb.minY);
        localMatrix.preScale(paramb.width, paramb.height);
      }
      if (paramam.ayU != null) {
        localMatrix.preConcat(paramam.ayU);
      }
      j = paramam.ayS.size();
      if (j != 0) {
        break label416;
      }
      oE();
      if (!paramBoolean) {
        break label401;
      }
      this.aBE.aCd = false;
      AppMethodBeat.o(202676);
      return;
      i = 0;
      break;
      localPaint = this.aBE.aCg;
      break label54;
      f2 = 0.0F;
      break label82;
      f1 = 0.0F;
      break label99;
      f3 = ((h.b)localObject).width;
      break label116;
    }
    label298:
    if (paramam.azf != null)
    {
      f1 = paramam.azf.a(this, 1.0F);
      label316:
      if (paramam.azg == null) {
        break label383;
      }
      f2 = paramam.azg.a(this, 1.0F);
      label334:
      if (paramam.azh == null) {
        break label389;
      }
      f3 = paramam.azh.a(this, 1.0F);
      label352:
      if (paramam.azi == null) {
        break label395;
      }
    }
    label389:
    label395:
    for (f4 = paramam.azi.a(this, 1.0F);; f4 = 0.0F)
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
    this.aBE.aCe = false;
    AppMethodBeat.o(202676);
    return;
    label416:
    int[] arrayOfInt = new int[j];
    float[] arrayOfFloat = new float[j];
    int i = 0;
    Iterator localIterator = paramam.ayS.iterator();
    float f6 = -1.0F;
    if (localIterator.hasNext())
    {
      paramb = (h.ad)localIterator.next();
      if (paramb.azC != null)
      {
        f1 = paramb.azC.floatValue();
        label487:
        if ((i != 0) && (f1 < f6)) {
          break label595;
        }
        arrayOfFloat[i] = f1;
      }
      for (;;)
      {
        oD();
        a(this.aBE, paramb);
        localObject = (h.f)this.aBE.axD.aAf;
        paramb = (h.b)localObject;
        if (localObject == null) {
          paramb = h.f.ayN;
        }
        arrayOfInt[i] = f(paramb.ayM, this.aBE.axD.aAg.floatValue());
        oE();
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
      oE();
      localPaint.setColor(arrayOfInt[(j - 1)]);
      AppMethodBeat.o(202676);
      return;
    }
    Object localObject = Shader.TileMode.CLAMP;
    paramb = (h.b)localObject;
    if (paramam.ayV != null)
    {
      if (paramam.ayV != h.k.ayX) {
        break label749;
      }
      paramb = Shader.TileMode.MIRROR;
    }
    for (;;)
    {
      oE();
      paramb = new LinearGradient(f5, f2, f3, f4, arrayOfInt, arrayOfFloat, paramb);
      paramb.setLocalMatrix(localMatrix);
      localPaint.setShader(paramb);
      localPaint.setAlpha(F(this.aBE.axD.azG.floatValue()));
      AppMethodBeat.o(202676);
      return;
      label749:
      paramb = (h.b)localObject;
      if (paramam.ayV == h.k.ayY) {
        paramb = Shader.TileMode.REPEAT;
      }
    }
  }
  
  private void a(boolean paramBoolean, h.b paramb, h.aq paramaq)
  {
    AppMethodBeat.i(202687);
    if (paramaq.ayD != null) {
      a(paramaq, paramaq.ayD);
    }
    Paint localPaint;
    label54:
    float f1;
    label91:
    float f2;
    if ((paramaq.ayT != null) && (paramaq.ayT.booleanValue()))
    {
      i = 1;
      if (!paramBoolean) {
        break label246;
      }
      localPaint = this.aBE.aCf;
      if (i == 0) {
        break label291;
      }
      localObject = new h.p(50.0F, h.bd.aBA);
      if (paramaq.ayI == null) {
        break label258;
      }
      f1 = paramaq.ayI.a(this);
      if (paramaq.ayJ == null) {
        break label269;
      }
      f2 = paramaq.ayJ.b(this);
      label108:
      if (paramaq.ayK == null) {
        break label280;
      }
    }
    float f4;
    Matrix localMatrix;
    int j;
    label258:
    label269:
    label280:
    for (float f3 = paramaq.ayK.c(this);; f3 = ((h.p)localObject).c(this))
    {
      f4 = f1;
      oD();
      this.aBE = d(paramaq);
      localMatrix = new Matrix();
      if (i == 0)
      {
        localMatrix.preTranslate(paramb.minX, paramb.minY);
        localMatrix.preScale(paramb.width, paramb.height);
      }
      if (paramaq.ayU != null) {
        localMatrix.preConcat(paramaq.ayU);
      }
      j = paramaq.ayS.size();
      if (j != 0) {
        break label391;
      }
      oE();
      if (!paramBoolean) {
        break label376;
      }
      this.aBE.aCd = false;
      AppMethodBeat.o(202687);
      return;
      i = 0;
      break;
      label246:
      localPaint = this.aBE.aCg;
      break label54;
      f1 = ((h.p)localObject).a(this);
      break label91;
      f2 = ((h.p)localObject).b(this);
      break label108;
    }
    label291:
    if (paramaq.ayI != null)
    {
      f1 = paramaq.ayI.a(this, 1.0F);
      label309:
      if (paramaq.ayJ == null) {
        break label360;
      }
      f2 = paramaq.ayJ.a(this, 1.0F);
      label327:
      if (paramaq.ayK == null) {
        break label368;
      }
    }
    label360:
    label368:
    for (f3 = paramaq.ayK.a(this, 1.0F);; f3 = 0.5F)
    {
      f4 = f1;
      break;
      f1 = 0.5F;
      break label309;
      f2 = 0.5F;
      break label327;
    }
    label376:
    this.aBE.aCe = false;
    AppMethodBeat.o(202687);
    return;
    label391:
    int[] arrayOfInt = new int[j];
    float[] arrayOfFloat = new float[j];
    int i = 0;
    Iterator localIterator = paramaq.ayS.iterator();
    float f5 = -1.0F;
    if (localIterator.hasNext())
    {
      paramb = (h.ad)localIterator.next();
      if (paramb.azC != null)
      {
        f1 = paramb.azC.floatValue();
        label462:
        if ((i != 0) && (f1 < f5)) {
          break label570;
        }
        arrayOfFloat[i] = f1;
      }
      for (;;)
      {
        oD();
        a(this.aBE, paramb);
        localObject = (h.f)this.aBE.axD.aAf;
        paramb = (h.b)localObject;
        if (localObject == null) {
          paramb = h.f.ayN;
        }
        arrayOfInt[i] = f(paramb.ayM, this.aBE.axD.aAg.floatValue());
        oE();
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
      oE();
      localPaint.setColor(arrayOfInt[(j - 1)]);
      AppMethodBeat.o(202687);
      return;
    }
    Object localObject = Shader.TileMode.CLAMP;
    paramb = (h.b)localObject;
    if (paramaq.ayV != null)
    {
      if (paramaq.ayV != h.k.ayX) {
        break label713;
      }
      paramb = Shader.TileMode.MIRROR;
    }
    for (;;)
    {
      oE();
      paramb = new RadialGradient(f4, f2, f3, arrayOfInt, arrayOfFloat, paramb);
      paramb.setLocalMatrix(localMatrix);
      localPaint.setShader(paramb);
      localPaint.setAlpha(F(this.aBE.axD.azG.floatValue()));
      AppMethodBeat.o(202687);
      return;
      label713:
      paramb = (h.b)localObject;
      if (paramaq.ayV == h.k.ayY) {
        paramb = Shader.TileMode.REPEAT;
      }
    }
  }
  
  private void a(boolean paramBoolean, h.b paramb, h.u paramu)
  {
    AppMethodBeat.i(202675);
    h.an localan = this.aBi.Z(paramu.ayD);
    if (localan == null)
    {
      if (paramBoolean) {}
      for (paramb = "Fill";; paramb = "Stroke")
      {
        String.format("%s reference '%s' not found", new Object[] { paramb, paramu.ayD });
        if (paramu.azr == null) {
          break;
        }
        a(this.aBE, paramBoolean, paramu.azr);
        AppMethodBeat.o(202675);
        return;
      }
      if (paramBoolean)
      {
        this.aBE.aCd = false;
        AppMethodBeat.o(202675);
        return;
      }
      this.aBE.aCe = false;
      AppMethodBeat.o(202675);
      return;
    }
    if ((localan instanceof h.am))
    {
      a(paramBoolean, paramb, (h.am)localan);
      AppMethodBeat.o(202675);
      return;
    }
    if ((localan instanceof h.aq))
    {
      a(paramBoolean, paramb, (h.aq)localan);
      AppMethodBeat.o(202675);
      return;
    }
    if ((localan instanceof h.ac)) {
      a(paramBoolean, (h.ac)localan);
    }
    AppMethodBeat.o(202675);
  }
  
  private static boolean a(h.ae paramae, long paramLong)
  {
    return (paramae.azD & paramLong) != 0L;
  }
  
  private static Path b(h.z paramz)
  {
    AppMethodBeat.i(202753);
    Path localPath = new Path();
    localPath.moveTo(paramz.azB[0], paramz.azB[1]);
    int i = 2;
    while (i < paramz.azB.length)
    {
      localPath.lineTo(paramz.azB[i], paramz.azB[(i + 1)]);
      i += 2;
    }
    if ((paramz instanceof h.aa)) {
      localPath.close();
    }
    if (paramz.aBe == null) {
      paramz.aBe = e(localPath);
    }
    AppMethodBeat.o(202753);
    return localPath;
  }
  
  private void b(h.ak paramak)
  {
    AppMethodBeat.i(202539);
    a(paramak, paramak.aBe);
    AppMethodBeat.o(202539);
  }
  
  private void b(h.ak paramak, h.b paramb)
  {
    AppMethodBeat.i(202703);
    if (this.aBE.axD.aAh == null)
    {
      AppMethodBeat.o(202703);
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      paramak = c(paramak, paramb);
      if (paramak != null) {
        this.aBC.clipPath(paramak);
      }
      AppMethodBeat.o(202703);
      return;
    }
    d(paramak, paramb);
    AppMethodBeat.o(202703);
  }
  
  private void b(h.an paraman)
  {
    Object localObject1 = null;
    float f2 = 0.0F;
    float f4 = 0.0F;
    AppMethodBeat.i(202444);
    if ((paraman instanceof h.t))
    {
      AppMethodBeat.o(202444);
      return;
    }
    oD();
    c(paraman);
    if ((paraman instanceof h.af))
    {
      paraman = (h.af)paraman;
      a(paraman, a(paraman.aza, paraman.azb, paraman.azc, paraman.azd), paraman.ayu, paraman.ays);
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
          oE();
          AppMethodBeat.o(202444);
          return;
          if ((paraman instanceof h.be))
          {
            localObject2 = (h.be)paraman;
            if (((((h.be)localObject2).azc == null) || (!((h.be)localObject2).azc.or())) && ((((h.be)localObject2).azd == null) || (!((h.be)localObject2).azd.or())))
            {
              a(this.aBE, (h.al)localObject2);
              if (oK())
              {
                localObject3 = ((h.be)localObject2).aBi.Z(((h.be)localObject2).ayD);
                if (localObject3 == null)
                {
                  String.format("Use reference '%s' not found", new Object[] { ((h.be)localObject2).ayD });
                }
                else
                {
                  if (((h.be)localObject2).transform != null) {
                    this.aBC.concat(((h.be)localObject2).transform);
                  }
                  if (((h.be)localObject2).aza != null)
                  {
                    f1 = ((h.be)localObject2).aza.a(this);
                    if (((h.be)localObject2).azb == null) {
                      break label370;
                    }
                    f2 = ((h.be)localObject2).azb.b(this);
                    this.aBC.translate(f1, f2);
                    d((h.ak)localObject2);
                    bool1 = oG();
                    a((h.aj)localObject2);
                    if (!(localObject3 instanceof h.af)) {
                      break label375;
                    }
                    paraman = (h.af)localObject3;
                    localObject1 = a(null, null, ((h.be)localObject2).azc, ((h.be)localObject2).azd);
                    oD();
                    a(paraman, (h.b)localObject1, paraman.ayu, paraman.ays);
                    oE();
                  }
                  for (;;)
                  {
                    oF();
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
                      if (((h.be)localObject2).azc != null)
                      {
                        paraman = ((h.be)localObject2).azc;
                        if (((h.be)localObject2).azd == null) {
                          break label478;
                        }
                      }
                      for (localObject1 = ((h.be)localObject2).azd;; localObject1 = new h.p(100.0F, h.bd.aBA))
                      {
                        localObject1 = a(null, null, paraman, (h.p)localObject1);
                        oD();
                        localObject3 = (h.at)localObject3;
                        if ((((h.b)localObject1).width != 0.0F) && (((h.b)localObject1).height != 0.0F)) {
                          break label496;
                        }
                        oE();
                        break;
                        paraman = new h.p(100.0F, h.bd.aBA);
                        break label397;
                      }
                      if (((h.at)localObject3).ays != null)
                      {
                        paraman = ((h.at)localObject3).ays;
                        a(this.aBE, (h.al)localObject3);
                        this.aBE.ayv = ((h.b)localObject1);
                        if (!this.aBE.axD.azY.booleanValue()) {
                          g(this.aBE.ayv.minX, this.aBE.ayv.minY, this.aBE.ayv.width, this.aBE.ayv.height);
                        }
                        if (((h.at)localObject3).ayu == null) {
                          break label672;
                        }
                        this.aBC.concat(a(this.aBE.ayv, ((h.at)localObject3).ayu, paraman));
                        this.aBE.ayu = ((h.at)localObject3).ayu;
                      }
                      for (;;)
                      {
                        boolean bool2 = oG();
                        a((h.aj)localObject3, true);
                        if (bool2) {
                          b((h.ak)localObject3);
                        }
                        a((h.ak)localObject3);
                        break;
                        paraman = f.axW;
                        break label510;
                        this.aBC.translate(this.aBE.ayv.minX, this.aBE.ayv.minY);
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
            a(this.aBE, paraman);
            if (oK())
            {
              if (paraman.transform != null) {
                this.aBC.concat(paraman.transform);
              }
              d(paraman);
              bool1 = oG();
              localObject1 = Locale.getDefault().getLanguage();
              localObject2 = h.ol();
              localObject3 = paraman.ayS.iterator();
              while (((Iterator)localObject3).hasNext())
              {
                h.an localan = (h.an)((Iterator)localObject3).next();
                if ((localan instanceof h.ag))
                {
                  Object localObject4 = (h.ag)localan;
                  if (((h.ag)localObject4).ov() == null)
                  {
                    Object localObject5 = ((h.ag)localObject4).ow();
                    if ((localObject5 == null) || ((!((Set)localObject5).isEmpty()) && (((Set)localObject5).contains(localObject1))))
                    {
                      localObject5 = ((h.ag)localObject4).ou();
                      if (localObject5 != null)
                      {
                        if (aBI == null) {
                          oI();
                        }
                        if ((((Set)localObject5).isEmpty()) || (!aBI.containsAll((Collection)localObject5))) {
                          break;
                        }
                      }
                      else
                      {
                        localObject5 = ((h.ag)localObject4).ox();
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
                        localObject4 = ((h.ag)localObject4).oy();
                        if (localObject4 != null)
                        {
                          if ((((Set)localObject4).isEmpty()) || (localObject2 == null)) {
                            continue;
                          }
                          localObject4 = ((Set)localObject4).iterator();
                          if (((Iterator)localObject4).hasNext())
                          {
                            ((Iterator)localObject4).next();
                            this.aBE.axD.azT.intValue();
                            String.valueOf(this.aBE.axD.azU);
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
            new StringBuilder().append(paraman.om()).append(" render");
            a(this.aBE, paraman);
            if (oK())
            {
              if (paraman.transform != null) {
                this.aBC.concat(paraman.transform);
              }
              d(paraman);
              bool1 = oG();
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
      } while ((((h.o)localObject3).azc == null) || (((h.o)localObject3).azc.or()) || (((h.o)localObject3).azd == null) || (((h.o)localObject3).azd.or()) || (((h.o)localObject3).ayD == null));
      if (((h.o)localObject3).ays == null) {
        break;
      }
      paraman = ((h.o)localObject3).ays;
      localObject2 = checkForImageDataURL(((h.o)localObject3).ayD);
      if (localObject2 != null) {
        break label3306;
      }
    } while (h.ol() == null);
    for (;;)
    {
      label397:
      label478:
      label496:
      label1264:
      if (localObject1 == null)
      {
        String.format("Could not locate image '%s'", new Object[] { ((h.o)localObject3).ayD });
        break;
        paraman = f.axW;
        break label1264;
      }
      label672:
      localObject2 = new h.b(0.0F, 0.0F, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
      a(this.aBE, (h.al)localObject3);
      if ((!oK()) || (!visible())) {
        break;
      }
      if (((h.o)localObject3).transform != null) {
        this.aBC.concat(((h.o)localObject3).transform);
      }
      label1404:
      float f3;
      if (((h.o)localObject3).aza != null)
      {
        f1 = ((h.o)localObject3).aza.a(this);
        if (((h.o)localObject3).azb == null) {
          break label1653;
        }
        f2 = ((h.o)localObject3).azb.b(this);
        label1422:
        f3 = ((h.o)localObject3).azc.a(this);
        f4 = ((h.o)localObject3).azd.a(this);
        this.aBE.ayv = new h.b(f1, f2, f3, f4);
        if (!this.aBE.axD.azY.booleanValue()) {
          g(this.aBE.ayv.minX, this.aBE.ayv.minY, this.aBE.ayv.width, this.aBE.ayv.height);
        }
        ((h.o)localObject3).aBe = this.aBE.ayv;
        a((h.ak)localObject3);
        d((h.ak)localObject3);
        bool1 = oG();
        oM();
        this.aBC.save();
        this.aBC.concat(a(this.aBE.ayv, (h.b)localObject2, paraman));
        if (this.aBE.axD.aAp != h.ae.e.aAH) {
          break label1658;
        }
      }
      label1653:
      label1658:
      for (int i = 0;; i = 2)
      {
        paraman = new Paint(i);
        this.aBC.drawBitmap((Bitmap)localObject1, 0.0F, 0.0F, paraman);
        this.aBC.restore();
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
        if (paraman.azs == null) {
          break;
        }
        a(this.aBE, paraman);
        if ((!oK()) || (!visible()) || ((!this.aBE.aCe) && (!this.aBE.aCd))) {
          break;
        }
        if (paraman.transform != null) {
          this.aBC.concat(paraman.transform);
        }
        localObject1 = new c(paraman.azs).aBZ;
        if (paraman.aBe == null) {
          paraman.aBe = e((Path)localObject1);
        }
        a(paraman);
        c(paraman);
        d(paraman);
        bool1 = oG();
        if (this.aBE.aCd)
        {
          ((Path)localObject1).setFillType(oL());
          a(paraman, (Path)localObject1);
        }
        if (this.aBE.aCe) {
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
        if ((paraman.azc == null) || (paraman.azd == null) || (paraman.azc.or()) || (paraman.azd.or())) {
          break;
        }
        a(this.aBE, paraman);
        if ((!oK()) || (!visible())) {
          break;
        }
        if (paraman.transform != null) {
          this.aBC.concat(paraman.transform);
        }
        localObject1 = a(paraman);
        a(paraman);
        c(paraman);
        d(paraman);
        bool1 = oG();
        if (this.aBE.aCd) {
          a(paraman, (Path)localObject1);
        }
        if (this.aBE.aCe) {
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
        if ((paraman.ayK == null) || (paraman.ayK.or())) {
          break;
        }
        a(this.aBE, paraman);
        if ((!oK()) || (!visible())) {
          break;
        }
        if (paraman.transform != null) {
          this.aBC.concat(paraman.transform);
        }
        localObject1 = a(paraman);
        a(paraman);
        c(paraman);
        d(paraman);
        bool1 = oG();
        if (this.aBE.aCd) {
          a(paraman, (Path)localObject1);
        }
        if (this.aBE.aCe) {
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
        if ((paraman.ayQ == null) || (paraman.ayR == null) || (paraman.ayQ.or()) || (paraman.ayR.or())) {
          break;
        }
        a(this.aBE, paraman);
        if ((!oK()) || (!visible())) {
          break;
        }
        if (paraman.transform != null) {
          this.aBC.concat(paraman.transform);
        }
        localObject1 = a(paraman);
        a(paraman);
        c(paraman);
        d(paraman);
        bool1 = oG();
        if (this.aBE.aCd) {
          a(paraman, (Path)localObject1);
        }
        if (this.aBE.aCe) {
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
        a(this.aBE, paraman);
        if ((!oK()) || (!visible()) || (!this.aBE.aCe)) {
          break;
        }
        if (paraman.transform != null) {
          this.aBC.concat(paraman.transform);
        }
        if (paraman.azf == null)
        {
          f1 = 0.0F;
          label2395:
          if (paraman.azg != null) {
            break label2547;
          }
          f2 = 0.0F;
          label2404:
          if (paraman.azh != null) {
            break label2559;
          }
          f3 = 0.0F;
          label2414:
          if (paraman.azi != null) {
            break label2572;
          }
        }
        for (;;)
        {
          if (paraman.aBe == null) {
            paraman.aBe = new h.b(Math.min(f1, f3), Math.min(f2, f4), Math.abs(f3 - f1), Math.abs(f4 - f2));
          }
          localObject1 = new Path();
          ((Path)localObject1).moveTo(f1, f2);
          ((Path)localObject1).lineTo(f3, f4);
          a(paraman);
          c(paraman);
          d(paraman);
          bool1 = oG();
          d((Path)localObject1);
          a(paraman);
          if (!bool1) {
            break;
          }
          b(paraman);
          break;
          f1 = paraman.azf.a(this);
          break label2395;
          label2547:
          f2 = paraman.azg.b(this);
          break label2404;
          label2559:
          f3 = paraman.azh.a(this);
          break label2414;
          label2572:
          f4 = paraman.azi.b(this);
        }
      }
      if ((paraman instanceof h.aa))
      {
        paraman = (h.aa)paraman;
        a(this.aBE, paraman);
        if ((!oK()) || (!visible()) || ((!this.aBE.aCe) && (!this.aBE.aCd))) {
          break;
        }
        if (paraman.transform != null) {
          this.aBC.concat(paraman.transform);
        }
        if (paraman.azB.length < 2) {
          break;
        }
        localObject1 = b(paraman);
        a(paraman);
        c(paraman);
        d(paraman);
        bool1 = oG();
        if (this.aBE.aCd) {
          a(paraman, (Path)localObject1);
        }
        if (this.aBE.aCe) {
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
        a(this.aBE, paraman);
        if ((!oK()) || (!visible()) || ((!this.aBE.aCe) && (!this.aBE.aCd))) {
          break;
        }
        if (paraman.transform != null) {
          this.aBC.concat(paraman.transform);
        }
        if (paraman.azB.length < 2) {
          break;
        }
        localObject1 = b(paraman);
        a(paraman);
        ((Path)localObject1).setFillType(oL());
        c(paraman);
        d(paraman);
        bool1 = oG();
        if (this.aBE.aCd) {
          a(paraman, (Path)localObject1);
        }
        if (this.aBE.aCe) {
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
      a(this.aBE, paraman);
      if (!oK()) {
        break;
      }
      if (paraman.transform != null) {
        this.aBC.concat(paraman.transform);
      }
      label2981:
      label3003:
      label3025:
      float f5;
      if ((paraman.aBo == null) || (paraman.aBo.size() == 0))
      {
        f1 = 0.0F;
        if ((paraman.aBp != null) && (paraman.aBp.size() != 0)) {
          break label3233;
        }
        f3 = 0.0F;
        if ((paraman.aBq != null) && (paraman.aBq.size() != 0)) {
          break label3255;
        }
        f4 = 0.0F;
        f5 = f2;
        if (paraman.aBr != null)
        {
          if (paraman.aBr.size() != 0) {
            break label3277;
          }
          f5 = f2;
        }
        label3050:
        localObject1 = oJ();
        f2 = f1;
        if (localObject1 != h.ae.f.aAJ)
        {
          f2 = a(paraman);
          if (localObject1 != h.ae.f.aAK) {
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
        if (paraman.aBe == null)
        {
          localObject1 = new h(f2, f3);
          a(paraman, (i)localObject1);
          paraman.aBe = new h.b(((h)localObject1).aCi.left, ((h)localObject1).aCi.top, ((h)localObject1).aCi.width(), ((h)localObject1).aCi.height());
        }
        a(paraman);
        c(paraman);
        d(paraman);
        bool1 = oG();
        a(paraman, new e(f2 + f4, f5 + f3));
        if (!bool1) {
          break;
        }
        b(paraman);
        break;
        f1 = ((h.p)paraman.aBo.get(0)).a(this);
        break label2981;
        f3 = ((h.p)paraman.aBp.get(0)).b(this);
        break label3003;
        f4 = ((h.p)paraman.aBq.get(0)).a(this);
        break label3025;
        f5 = ((h.p)paraman.aBr.get(0)).b(this);
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
    AppMethodBeat.i(202706);
    paramak = paramak.aBi.Z(this.aBE.axD.aAh);
    if (paramak == null)
    {
      String.format("ClipPath reference '%s' not found", new Object[] { this.aBE.axD.aAh });
      AppMethodBeat.o(202706);
      return null;
    }
    Object localObject1 = (h.e)paramak;
    this.aBF.push(this.aBE);
    this.aBE = d((h.an)localObject1);
    if ((((h.e)localObject1).ayL == null) || (((h.e)localObject1).ayL.booleanValue())) {
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
    Iterator localIterator = ((h.e)localObject1).ayS.iterator();
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
    if (this.aBE.axD.aAh != null)
    {
      if (((h.e)localObject1).aBe == null) {
        ((h.e)localObject1).aBe = e(paramb);
      }
      localObject1 = c((h.ak)localObject1, ((h.e)localObject1).aBe);
      if (localObject1 != null) {
        paramb.op((Path)localObject1, Path.Op.INTERSECT);
      }
    }
    paramb.transform(paramak);
    this.aBE = ((g)this.aBF.pop());
    AppMethodBeat.o(202706);
    return paramb;
  }
  
  private void c(h.ak paramak)
  {
    AppMethodBeat.i(202674);
    if ((this.aBE.axD.azE instanceof h.u)) {
      a(true, paramak.aBe, (h.u)this.aBE.axD.azE);
    }
    if ((this.aBE.axD.azH instanceof h.u)) {
      a(false, paramak.aBe, (h.u)this.aBE.axD.azH);
    }
    AppMethodBeat.o(202674);
  }
  
  private void c(h.an paraman)
  {
    AppMethodBeat.i(202470);
    if (!(paraman instanceof h.al))
    {
      AppMethodBeat.o(202470);
      return;
    }
    paraman = (h.al)paraman;
    if (paraman.aBf != null) {
      this.aBE.aCh = paraman.aBf.booleanValue();
    }
    AppMethodBeat.o(202470);
  }
  
  private static Bitmap checkForImageDataURL(String paramString)
  {
    AppMethodBeat.i(202596);
    if (!paramString.startsWith("data:"))
    {
      AppMethodBeat.o(202596);
      return null;
    }
    if (paramString.length() < 14)
    {
      AppMethodBeat.o(202596);
      return null;
    }
    int i = paramString.indexOf(',');
    if (i < 12)
    {
      AppMethodBeat.o(202596);
      return null;
    }
    if (!";base64".equals(paramString.substring(i - 7, i)))
    {
      AppMethodBeat.o(202596);
      return null;
    }
    try
    {
      paramString = Base64.decode(paramString.substring(i + 1), 0);
      paramString = BitmapFactory.decodeByteArray(paramString, 0, paramString.length);
      AppMethodBeat.o(202596);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(202596);
    }
    return null;
  }
  
  private g d(h.an paraman)
  {
    AppMethodBeat.i(202672);
    g localg = new g();
    a(localg, h.ae.ot());
    paraman = a(paraman, localg);
    AppMethodBeat.o(202672);
    return paraman;
  }
  
  private void d(Path paramPath)
  {
    AppMethodBeat.i(202484);
    if (this.aBE.axD.aAo == h.ae.i.aAX)
    {
      Matrix localMatrix1 = this.aBC.getMatrix();
      Path localPath = new Path();
      paramPath.transform(localMatrix1, localPath);
      this.aBC.setMatrix(new Matrix());
      paramPath = this.aBE.aCg.getShader();
      Matrix localMatrix2 = new Matrix();
      if (paramPath != null)
      {
        paramPath.getLocalMatrix(localMatrix2);
        Matrix localMatrix3 = new Matrix(localMatrix2);
        localMatrix3.postConcat(localMatrix1);
        paramPath.setLocalMatrix(localMatrix3);
      }
      this.aBC.drawPath(localPath, this.aBE.aCg);
      this.aBC.setMatrix(localMatrix1);
      if (paramPath != null) {
        paramPath.setLocalMatrix(localMatrix2);
      }
      AppMethodBeat.o(202484);
      return;
    }
    this.aBC.drawPath(paramPath, this.aBE.aCg);
    AppMethodBeat.o(202484);
  }
  
  private void d(h.ak paramak)
  {
    AppMethodBeat.i(202702);
    b(paramak, paramak.aBe);
    AppMethodBeat.o(202702);
  }
  
  private void d(h.ak paramak, h.b paramb)
  {
    AppMethodBeat.i(202718);
    Object localObject = paramak.aBi.Z(this.aBE.axD.aAh);
    if (localObject == null)
    {
      String.format("ClipPath reference '%s' not found", new Object[] { this.aBE.axD.aAh });
      AppMethodBeat.o(202718);
      return;
    }
    localObject = (h.e)localObject;
    if (((h.e)localObject).ayS.isEmpty())
    {
      this.aBC.clipRect(0, 0, 0, 0);
      AppMethodBeat.o(202718);
      return;
    }
    if ((((h.e)localObject).ayL == null) || (((h.e)localObject).ayL.booleanValue())) {}
    for (int i = 1; ((paramak instanceof h.m)) && (i == 0); i = 0)
    {
      String.format("<clipPath clipPathUnits=\"objectBoundingBox\"> is not supported when referenced from container elements (like %s)", new Object[] { paramak.om() });
      AppMethodBeat.o(202718);
      return;
    }
    oN();
    if (i == 0)
    {
      paramak = new Matrix();
      paramak.preTranslate(paramb.minX, paramb.minY);
      paramak.preScale(paramb.width, paramb.height);
      this.aBC.concat(paramak);
    }
    if (((h.e)localObject).transform != null) {
      this.aBC.concat(((h.e)localObject).transform);
    }
    this.aBE = d((h.an)localObject);
    d((h.ak)localObject);
    paramak = new Path();
    paramb = ((h.e)localObject).ayS.iterator();
    while (paramb.hasNext()) {
      a((h.an)paramb.next(), true, paramak, new Matrix());
    }
    this.aBC.clipPath(paramak);
    oO();
    AppMethodBeat.o(202718);
  }
  
  private static h.b e(Path paramPath)
  {
    AppMethodBeat.i(202558);
    RectF localRectF = new RectF();
    paramPath.computeBounds(localRectF, true);
    paramPath = new h.b(localRectF.left, localRectF.top, localRectF.width(), localRectF.height());
    AppMethodBeat.o(202558);
    return paramPath;
  }
  
  private static int f(int paramInt, float paramFloat)
  {
    int i = 255;
    AppMethodBeat.i(202645);
    int j = Math.round((paramInt >> 24 & 0xFF) * paramFloat);
    if (j < 0) {
      i = 0;
    }
    for (;;)
    {
      AppMethodBeat.o(202645);
      return i << 24 | 0xFFFFFF & paramInt;
      if (j <= 255) {
        i = j;
      }
    }
  }
  
  private void g(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(202649);
    float f3 = paramFloat1 + paramFloat3;
    float f4 = paramFloat2 + paramFloat4;
    float f2 = f4;
    float f1 = f3;
    paramFloat4 = paramFloat1;
    paramFloat3 = paramFloat2;
    if (this.aBE.axD.azZ != null)
    {
      paramFloat4 = paramFloat1 + this.aBE.axD.azZ.ayH.a(this);
      paramFloat3 = paramFloat2 + this.aBE.axD.azZ.ayE.b(this);
      f1 = f3 - this.aBE.axD.azZ.ayF.a(this);
      f2 = f4 - this.aBE.axD.azZ.ayG.b(this);
    }
    this.aBC.clipRect(paramFloat4, paramFloat3, f1, f2);
    AppMethodBeat.o(202649);
  }
  
  private void oA()
  {
    AppMethodBeat.i(202332);
    this.aBE = new g();
    this.aBF = new Stack();
    a(this.aBE, h.ae.ot());
    this.aBE.ayv = null;
    this.aBE.aCh = false;
    this.aBF.push(new g(this.aBE));
    this.aBH = new Stack();
    this.aBG = new Stack();
    AppMethodBeat.o(202332);
  }
  
  private void oD()
  {
    AppMethodBeat.i(202451);
    this.aBC.save();
    this.aBF.push(this.aBE);
    this.aBE = new g(this.aBE);
    AppMethodBeat.o(202451);
  }
  
  private void oE()
  {
    AppMethodBeat.i(202457);
    this.aBC.restore();
    this.aBE = ((g)this.aBF.pop());
    AppMethodBeat.o(202457);
  }
  
  private void oF()
  {
    AppMethodBeat.i(202461);
    this.aBG.pop();
    this.aBH.pop();
    AppMethodBeat.o(202461);
  }
  
  private boolean oG()
  {
    AppMethodBeat.i(202537);
    if (!oH())
    {
      AppMethodBeat.o(202537);
      return false;
    }
    this.aBC.saveLayerAlpha(null, F(this.aBE.axD.azP.floatValue()), 31);
    this.aBF.push(this.aBE);
    this.aBE = new g(this.aBE);
    if (this.aBE.axD.aAj != null)
    {
      h.an localan = this.aBi.Z(this.aBE.axD.aAj);
      if ((localan == null) || (!(localan instanceof h.s)))
      {
        String.format("Mask reference '%s' not found", new Object[] { this.aBE.axD.aAj });
        this.aBE.axD.aAj = null;
        AppMethodBeat.o(202537);
        return true;
      }
    }
    AppMethodBeat.o(202537);
    return true;
  }
  
  private boolean oH()
  {
    AppMethodBeat.i(202548);
    if ((this.aBE.axD.azP.floatValue() < 1.0F) || (this.aBE.axD.aAj != null))
    {
      AppMethodBeat.o(202548);
      return true;
    }
    AppMethodBeat.o(202548);
    return false;
  }
  
  private static void oI()
  {
    try
    {
      AppMethodBeat.i(202554);
      HashSet localHashSet = new HashSet();
      aBI = localHashSet;
      localHashSet.add("Structure");
      aBI.add("BasicStructure");
      aBI.add("ConditionalProcessing");
      aBI.add("Image");
      aBI.add("Style");
      aBI.add("ViewportAttribute");
      aBI.add("Shape");
      aBI.add("BasicText");
      aBI.add("PaintAttribute");
      aBI.add("BasicPaintAttribute");
      aBI.add("OpacityAttribute");
      aBI.add("BasicGraphicsAttribute");
      aBI.add("Marker");
      aBI.add("Gradient");
      aBI.add("Pattern");
      aBI.add("Clip");
      aBI.add("BasicClip");
      aBI.add("Mask");
      aBI.add("View");
      AppMethodBeat.o(202554);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private h.ae.f oJ()
  {
    if ((this.aBE.axD.azW == h.ae.h.aAT) || (this.aBE.axD.azX == h.ae.f.aAK)) {
      return this.aBE.axD.azX;
    }
    if (this.aBE.axD.azX == h.ae.f.aAJ) {
      return h.ae.f.aAL;
    }
    return h.ae.f.aAJ;
  }
  
  private boolean oK()
  {
    AppMethodBeat.i(202597);
    if (this.aBE.axD.aAd != null)
    {
      boolean bool = this.aBE.axD.aAd.booleanValue();
      AppMethodBeat.o(202597);
      return bool;
    }
    AppMethodBeat.o(202597);
    return true;
  }
  
  private Path.FillType oL()
  {
    if ((this.aBE.axD.azF != null) && (this.aBE.axD.azF == h.ae.a.aAr)) {
      return Path.FillType.EVEN_ODD;
    }
    return Path.FillType.WINDING;
  }
  
  private void oM()
  {
    AppMethodBeat.i(202652);
    if ((this.aBE.axD.aAm instanceof h.f)) {}
    for (int i = ((h.f)this.aBE.axD.aAm).ayM;; i = this.aBE.axD.azQ.ayM)
    {
      int j = i;
      if (this.aBE.axD.aAn != null) {
        j = f(i, this.aBE.axD.aAn.floatValue());
      }
      this.aBC.drawColor(j);
      AppMethodBeat.o(202652);
      return;
      if (!(this.aBE.axD.aAm instanceof h.g)) {
        break;
      }
    }
    AppMethodBeat.o(202652);
  }
  
  private void oN()
  {
    AppMethodBeat.i(202720);
    c.c(this.aBC, c.axO);
    this.aBF.push(this.aBE);
    this.aBE = new g(this.aBE);
    AppMethodBeat.o(202720);
  }
  
  private void oO()
  {
    AppMethodBeat.i(202721);
    this.aBC.restore();
    this.aBE = ((g)this.aBF.pop());
    AppMethodBeat.o(202721);
  }
  
  private Path.FillType oP()
  {
    if ((this.aBE.axD.aAi != null) && (this.aBE.axD.aAi == h.ae.a.aAr)) {
      return Path.FillType.EVEN_ODD;
    }
    return Path.FillType.WINDING;
  }
  
  private boolean visible()
  {
    AppMethodBeat.i(202598);
    if (this.aBE.axD.aAe != null)
    {
      boolean bool = this.aBE.axD.aAe.booleanValue();
      AppMethodBeat.o(202598);
      return bool;
    }
    AppMethodBeat.o(202598);
    return true;
  }
  
  final void a(h paramh, g paramg)
  {
    AppMethodBeat.i(202354);
    this.aBi = paramh;
    h.af localaf = paramh.ayy;
    if (localaf == null)
    {
      String.format("Nothing to render. Document is empty.", new Object[0]);
      AppMethodBeat.o(202354);
      return;
    }
    Object localObject1;
    Object localObject2;
    if (paramg.od())
    {
      localObject1 = this.aBi.aa(paramg.viewId);
      if ((localObject1 == null) || (!(localObject1 instanceof h.bf)))
      {
        String.format("View element with id \"%s\" not found.", new Object[] { paramg.viewId });
        AppMethodBeat.o(202354);
        return;
      }
      localObject1 = (h.bf)localObject1;
      if (((h.bf)localObject1).ayu == null)
      {
        String.format("View element with id \"%s\" is missing a viewBox attribute.", new Object[] { paramg.viewId });
        AppMethodBeat.o(202354);
        return;
      }
      localObject2 = ((h.bf)localObject1).ayu;
      localObject1 = ((h.bf)localObject1).ays;
    }
    for (;;)
    {
      if (paramg.ob()) {
        paramh.b(paramg.ayr);
      }
      if (paramg.of())
      {
        this.aBJ = new b.p();
        this.aBJ.axE = paramh.aa(paramg.ayt);
      }
      oA();
      c(localaf);
      oD();
      Object localObject3 = new h.b(paramg.ayv);
      if (localaf.azc != null) {
        ((h.b)localObject3).width = localaf.azc.a(this, ((h.b)localObject3).width);
      }
      if (localaf.azd != null) {
        ((h.b)localObject3).height = localaf.azd.a(this, ((h.b)localObject3).height);
      }
      a(localaf, (h.b)localObject3, (h.b)localObject2, (f)localObject1);
      oE();
      if (paramg.ob()) {
        paramh.ok();
      }
      AppMethodBeat.o(202354);
      return;
      if (paramg.oe()) {}
      for (localObject1 = paramg.ayu;; localObject1 = localaf.ayu)
      {
        if (!paramg.oc()) {
          break label348;
        }
        localObject3 = paramg.ays;
        localObject2 = localObject1;
        localObject1 = localObject3;
        break;
      }
      label348:
      localObject3 = localaf.ays;
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
  }
  
  final float oB()
  {
    AppMethodBeat.i(202338);
    float f = this.aBE.aCf.getTextSize();
    AppMethodBeat.o(202338);
    return f;
  }
  
  final h.b oC()
  {
    if (this.aBE.ayu != null) {
      return this.aBE.ayu;
    }
    return this.aBE.ayv;
  }
  
  final class a
    implements h.x
  {
    List<i.b> aBN;
    private float aBO;
    private float aBP;
    private i.b aBQ;
    private boolean aBR;
    private boolean aBS;
    private int aBT;
    private boolean aBU;
    
    a(h.w paramw)
    {
      AppMethodBeat.i(202211);
      this.aBN = new ArrayList();
      this.aBQ = null;
      this.aBR = false;
      this.aBS = true;
      this.aBT = -1;
      if (paramw == null)
      {
        AppMethodBeat.o(202211);
        return;
      }
      paramw.a(this);
      if (this.aBU)
      {
        this.aBQ.a((i.b)this.aBN.get(this.aBT));
        this.aBN.set(this.aBT, this.aBQ);
        this.aBU = false;
      }
      if (this.aBQ != null) {
        this.aBN.add(this.aBQ);
      }
      AppMethodBeat.o(202211);
    }
    
    public final void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
    {
      AppMethodBeat.i(202226);
      if ((this.aBS) || (this.aBR))
      {
        this.aBQ.n(paramFloat1, paramFloat2);
        this.aBN.add(this.aBQ);
        this.aBR = false;
      }
      this.aBQ = new i.b(i.this, paramFloat5, paramFloat6, paramFloat5 - paramFloat3, paramFloat6 - paramFloat4);
      this.aBU = false;
      AppMethodBeat.o(202226);
    }
    
    public final void a(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean1, boolean paramBoolean2, float paramFloat4, float paramFloat5)
    {
      AppMethodBeat.i(202232);
      this.aBR = true;
      this.aBS = false;
      i.a(this.aBQ.x, this.aBQ.y, paramFloat1, paramFloat2, paramFloat3, paramBoolean1, paramBoolean2, paramFloat4, paramFloat5, this);
      this.aBS = true;
      this.aBU = false;
      AppMethodBeat.o(202232);
    }
    
    public final void close()
    {
      AppMethodBeat.i(202235);
      this.aBN.add(this.aBQ);
      m(this.aBO, this.aBP);
      this.aBU = true;
      AppMethodBeat.o(202235);
    }
    
    public final void f(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      AppMethodBeat.i(202228);
      this.aBQ.n(paramFloat1, paramFloat2);
      this.aBN.add(this.aBQ);
      this.aBQ = new i.b(i.this, paramFloat3, paramFloat4, paramFloat3 - paramFloat1, paramFloat4 - paramFloat2);
      this.aBU = false;
      AppMethodBeat.o(202228);
    }
    
    public final void l(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(202217);
      if (this.aBU)
      {
        this.aBQ.a((i.b)this.aBN.get(this.aBT));
        this.aBN.set(this.aBT, this.aBQ);
        this.aBU = false;
      }
      if (this.aBQ != null) {
        this.aBN.add(this.aBQ);
      }
      this.aBO = paramFloat1;
      this.aBP = paramFloat2;
      this.aBQ = new i.b(i.this, paramFloat1, paramFloat2, 0.0F, 0.0F);
      this.aBT = this.aBN.size();
      AppMethodBeat.o(202217);
    }
    
    public final void m(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(202221);
      this.aBQ.n(paramFloat1, paramFloat2);
      this.aBN.add(this.aBQ);
      this.aBQ = new i.b(i.this, paramFloat1, paramFloat2, paramFloat1 - this.aBQ.x, paramFloat2 - this.aBQ.y);
      this.aBU = false;
      AppMethodBeat.o(202221);
    }
  }
  
  final class b
  {
    float aBW;
    float aBX;
    boolean aBY;
    float x;
    float y;
    
    b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      AppMethodBeat.i(202242);
      this.aBW = 0.0F;
      this.aBX = 0.0F;
      this.aBY = false;
      this.x = paramFloat1;
      this.y = paramFloat2;
      double d = Math.sqrt(paramFloat3 * paramFloat3 + paramFloat4 * paramFloat4);
      if (d != 0.0D)
      {
        this.aBW = ((float)(paramFloat3 / d));
        this.aBX = ((float)(paramFloat4 / d));
      }
      AppMethodBeat.o(202242);
    }
    
    final void a(b paramb)
    {
      if ((paramb.aBW == -this.aBW) && (paramb.aBX == -this.aBX))
      {
        this.aBY = true;
        this.aBW = (-paramb.aBX);
        this.aBX = paramb.aBW;
        return;
      }
      this.aBW += paramb.aBW;
      this.aBX += paramb.aBX;
    }
    
    final void n(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(202247);
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
      if ((paramFloat1 == -this.aBW) && (paramFloat2 == -this.aBX))
      {
        this.aBY = true;
        this.aBW = (-paramFloat2);
        this.aBX = paramFloat1;
        AppMethodBeat.o(202247);
        return;
      }
      this.aBW = (paramFloat1 + this.aBW);
      this.aBX = (paramFloat2 + this.aBX);
      AppMethodBeat.o(202247);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(202253);
      String str = "(" + this.x + "," + this.y + " " + this.aBW + "," + this.aBX + ")";
      AppMethodBeat.o(202253);
      return str;
    }
  }
  
  protected static final class c
    implements h.x
  {
    Path aBZ;
    float aCa;
    float aCb;
    
    c(h.w paramw)
    {
      AppMethodBeat.i(202257);
      this.aBZ = new Path();
      if (paramw == null)
      {
        AppMethodBeat.o(202257);
        return;
      }
      paramw.a(this);
      AppMethodBeat.o(202257);
    }
    
    public final void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
    {
      AppMethodBeat.i(202263);
      this.aBZ.cubicTo(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
      this.aCa = paramFloat5;
      this.aCb = paramFloat6;
      AppMethodBeat.o(202263);
    }
    
    public final void a(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean1, boolean paramBoolean2, float paramFloat4, float paramFloat5)
    {
      AppMethodBeat.i(202266);
      i.a(this.aCa, this.aCb, paramFloat1, paramFloat2, paramFloat3, paramBoolean1, paramBoolean2, paramFloat4, paramFloat5, this);
      this.aCa = paramFloat4;
      this.aCb = paramFloat5;
      AppMethodBeat.o(202266);
    }
    
    public final void close()
    {
      AppMethodBeat.i(202269);
      this.aBZ.close();
      AppMethodBeat.o(202269);
    }
    
    public final void f(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      AppMethodBeat.i(202264);
      this.aBZ.quadTo(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
      this.aCa = paramFloat3;
      this.aCb = paramFloat4;
      AppMethodBeat.o(202264);
    }
    
    public final void l(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(202258);
      this.aBZ.moveTo(paramFloat1, paramFloat2);
      this.aCa = paramFloat1;
      this.aCb = paramFloat2;
      AppMethodBeat.o(202258);
    }
    
    public final void m(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(202261);
      this.aBZ.lineTo(paramFloat1, paramFloat2);
      this.aCa = paramFloat1;
      this.aCb = paramFloat2;
      AppMethodBeat.o(202261);
    }
  }
  
  final class d
    extends i.e
  {
    private Path aBZ;
    
    d(Path paramPath, float paramFloat)
    {
      super(paramFloat, 0.0F);
      this.aBZ = paramPath;
    }
    
    public final void ac(String paramString)
    {
      AppMethodBeat.i(202282);
      if (i.d(i.this))
      {
        if (i.e(i.this).aCd) {
          i.f(i.this).drawTextOnPath(paramString, this.aBZ, this.x, this.y, i.e(i.this).aCf);
        }
        if (i.e(i.this).aCe) {
          i.f(i.this).drawTextOnPath(paramString, this.aBZ, this.x, this.y, i.e(i.this).aCg);
        }
      }
      this.x += i.e(i.this).aCf.measureText(paramString);
      AppMethodBeat.o(202282);
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
      AppMethodBeat.i(202285);
      i.oQ();
      if (i.d(i.this))
      {
        if (i.e(i.this).aCd) {
          i.f(i.this).drawText(paramString, this.x, this.y, i.e(i.this).aCf);
        }
        if (i.e(i.this).aCe) {
          i.f(i.this).drawText(paramString, this.x, this.y, i.e(i.this).aCg);
        }
      }
      this.x += i.e(i.this).aCf.measureText(paramString);
      AppMethodBeat.o(202285);
    }
  }
  
  final class f
    extends i.i
  {
    Path aCc;
    float x;
    float y;
    
    f(float paramFloat1, float paramFloat2, Path paramPath)
    {
      super((byte)0);
      this.x = paramFloat1;
      this.y = paramFloat2;
      this.aCc = paramPath;
    }
    
    public final void ac(String paramString)
    {
      AppMethodBeat.i(202290);
      if (i.d(i.this))
      {
        Path localPath = new Path();
        i.e(i.this).aCf.getTextPath(paramString, 0, paramString.length(), this.x, this.y, localPath);
        this.aCc.addPath(localPath);
      }
      this.x += i.e(i.this).aCf.measureText(paramString);
      AppMethodBeat.o(202290);
    }
    
    public final boolean b(h.ay paramay)
    {
      AppMethodBeat.i(202288);
      if ((paramay instanceof h.az))
      {
        i.g("Using <textPath> elements in a clip path is not supported.", new Object[0]);
        AppMethodBeat.o(202288);
        return false;
      }
      AppMethodBeat.o(202288);
      return true;
    }
  }
  
  final class g
  {
    boolean aCd;
    boolean aCe;
    Paint aCf;
    Paint aCg;
    boolean aCh;
    h.ae axD;
    h.b ayu;
    h.b ayv;
    
    g()
    {
      AppMethodBeat.i(202292);
      this.aCf = new Paint();
      this.aCf.setFlags(193);
      if (Build.VERSION.SDK_INT >= 14) {
        this.aCf.setHinting(0);
      }
      this.aCf.setStyle(Paint.Style.FILL);
      this.aCf.setTypeface(Typeface.DEFAULT);
      this.aCg = new Paint();
      this.aCg.setFlags(193);
      if (Build.VERSION.SDK_INT >= 14) {
        this.aCg.setHinting(0);
      }
      this.aCg.setStyle(Paint.Style.STROKE);
      this.aCg.setTypeface(Typeface.DEFAULT);
      this.axD = h.ae.ot();
      AppMethodBeat.o(202292);
    }
    
    g(g paramg)
    {
      AppMethodBeat.i(202293);
      this.aCd = paramg.aCd;
      this.aCe = paramg.aCe;
      this.aCf = new Paint(paramg.aCf);
      this.aCg = new Paint(paramg.aCg);
      if (paramg.ayv != null) {
        this.ayv = new h.b(paramg.ayv);
      }
      if (paramg.ayu != null) {
        this.ayu = new h.b(paramg.ayu);
      }
      this.aCh = paramg.aCh;
      try
      {
        this.axD = ((h.ae)paramg.axD.clone());
        AppMethodBeat.o(202293);
        return;
      }
      catch (CloneNotSupportedException this$1)
      {
        this.axD = h.ae.ot();
        AppMethodBeat.o(202293);
      }
    }
  }
  
  final class h
    extends i.i
  {
    RectF aCi;
    float x;
    float y;
    
    h(float paramFloat1, float paramFloat2)
    {
      super((byte)0);
      AppMethodBeat.i(202295);
      this.aCi = new RectF();
      this.x = paramFloat1;
      this.y = paramFloat2;
      AppMethodBeat.o(202295);
    }
    
    public final void ac(String paramString)
    {
      AppMethodBeat.i(202298);
      if (i.d(i.this))
      {
        Object localObject = new Rect();
        i.e(i.this).aCf.getTextBounds(paramString, 0, paramString.length(), (Rect)localObject);
        localObject = new RectF((Rect)localObject);
        ((RectF)localObject).offset(this.x, this.y);
        this.aCi.union((RectF)localObject);
      }
      this.x += i.e(i.this).aCf.measureText(paramString);
      AppMethodBeat.o(202298);
    }
    
    public final boolean b(h.ay paramay)
    {
      AppMethodBeat.i(202296);
      if ((paramay instanceof h.az))
      {
        Object localObject = (h.az)paramay;
        paramay = paramay.aBi.Z(((h.az)localObject).ayD);
        if (paramay == null)
        {
          i.f("TextPath path reference '%s' not found", new Object[] { ((h.az)localObject).ayD });
          AppMethodBeat.o(202296);
          return false;
        }
        localObject = (h.v)paramay;
        paramay = new i.c(((h.v)localObject).azs).aBZ;
        if (((h.v)localObject).transform != null) {
          paramay.transform(((h.v)localObject).transform);
        }
        localObject = new RectF();
        paramay.computeBounds((RectF)localObject, true);
        this.aCi.union((RectF)localObject);
        AppMethodBeat.o(202296);
        return false;
      }
      AppMethodBeat.o(202296);
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
      AppMethodBeat.i(202305);
      this.x += i.e(i.this).aCf.measureText(paramString);
      AppMethodBeat.o(202305);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.a.a.i
 * JD-Core Version:    0.7.0.1
 */