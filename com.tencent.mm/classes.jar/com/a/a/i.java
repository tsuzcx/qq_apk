package com.a.a;

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
  private static HashSet<String> cxx = null;
  private h cwY;
  private Canvas cxr;
  float cxs;
  g cxt;
  private Stack<g> cxu;
  private Stack<h.aj> cxv;
  private Stack<Matrix> cxw;
  private b.p cxy = null;
  
  i(Canvas paramCanvas, float paramFloat)
  {
    this.cxr = paramCanvas;
    this.cxs = paramFloat;
  }
  
  private void Oi()
  {
    AppMethodBeat.i(207804);
    this.cxt = new g();
    this.cxu = new Stack();
    a(this.cxt, h.ae.Ob());
    this.cxt.cuk = null;
    this.cxt.cxT = false;
    this.cxu.push(new g(this.cxt));
    this.cxw = new Stack();
    this.cxv = new Stack();
    AppMethodBeat.o(207804);
  }
  
  private void Ol()
  {
    AppMethodBeat.i(207872);
    this.cxr.save();
    this.cxu.push(this.cxt);
    this.cxt = new g(this.cxt);
    AppMethodBeat.o(207872);
  }
  
  private void Om()
  {
    AppMethodBeat.i(207879);
    this.cxr.restore();
    this.cxt = ((g)this.cxu.pop());
    AppMethodBeat.o(207879);
  }
  
  private void On()
  {
    AppMethodBeat.i(207896);
    this.cxv.pop();
    this.cxw.pop();
    AppMethodBeat.o(207896);
  }
  
  private boolean Oo()
  {
    AppMethodBeat.i(207934);
    if (!Op())
    {
      AppMethodBeat.o(207934);
      return false;
    }
    this.cxr.saveLayerAlpha(null, aM(this.cxt.ctr.cvF.floatValue()), 31);
    this.cxu.push(this.cxt);
    this.cxt = new g(this.cxt);
    if (this.cxt.ctr.cvZ != null)
    {
      h.an localan = this.cwY.bm(this.cxt.ctr.cvZ);
      if ((localan == null) || (!(localan instanceof h.s)))
      {
        String.format("Mask reference '%s' not found", new Object[] { this.cxt.ctr.cvZ });
        this.cxt.ctr.cvZ = null;
        AppMethodBeat.o(207934);
        return true;
      }
    }
    AppMethodBeat.o(207934);
    return true;
  }
  
  private boolean Op()
  {
    AppMethodBeat.i(207941);
    if ((this.cxt.ctr.cvF.floatValue() < 1.0F) || (this.cxt.ctr.cvZ != null))
    {
      AppMethodBeat.o(207941);
      return true;
    }
    AppMethodBeat.o(207941);
    return false;
  }
  
  private static void Oq()
  {
    try
    {
      AppMethodBeat.i(207943);
      HashSet localHashSet = new HashSet();
      cxx = localHashSet;
      localHashSet.add("Structure");
      cxx.add("BasicStructure");
      cxx.add("ConditionalProcessing");
      cxx.add("Image");
      cxx.add("Style");
      cxx.add("ViewportAttribute");
      cxx.add("Shape");
      cxx.add("BasicText");
      cxx.add("PaintAttribute");
      cxx.add("BasicPaintAttribute");
      cxx.add("OpacityAttribute");
      cxx.add("BasicGraphicsAttribute");
      cxx.add("Marker");
      cxx.add("Gradient");
      cxx.add("Pattern");
      cxx.add("Clip");
      cxx.add("BasicClip");
      cxx.add("Mask");
      cxx.add("View");
      AppMethodBeat.o(207943);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private h.ae.f Or()
  {
    if ((this.cxt.ctr.cvM == h.ae.h.cwJ) || (this.cxt.ctr.cvN == h.ae.f.cwA)) {
      return this.cxt.ctr.cvN;
    }
    if (this.cxt.ctr.cvN == h.ae.f.cwz) {
      return h.ae.f.cwB;
    }
    return h.ae.f.cwz;
  }
  
  private boolean Os()
  {
    AppMethodBeat.i(207961);
    if (this.cxt.ctr.cvT != null)
    {
      boolean bool = this.cxt.ctr.cvT.booleanValue();
      AppMethodBeat.o(207961);
      return bool;
    }
    AppMethodBeat.o(207961);
    return true;
  }
  
  private Path.FillType Ot()
  {
    if ((this.cxt.ctr.cvu != null) && (this.cxt.ctr.cvu == h.ae.a.cwh)) {
      return Path.FillType.EVEN_ODD;
    }
    return Path.FillType.WINDING;
  }
  
  private void Ou()
  {
    AppMethodBeat.i(207983);
    if ((this.cxt.ctr.cwc instanceof h.f)) {}
    for (int i = ((h.f)this.cxt.ctr.cwc).cuC;; i = this.cxt.ctr.cvG.cuC)
    {
      int j = i;
      if (this.cxt.ctr.cwd != null) {
        j = i(i, this.cxt.ctr.cwd.floatValue());
      }
      this.cxr.drawColor(j);
      AppMethodBeat.o(207983);
      return;
      if (!(this.cxt.ctr.cwc instanceof h.g)) {
        break;
      }
    }
    AppMethodBeat.o(207983);
  }
  
  private void Ov()
  {
    AppMethodBeat.i(208018);
    c.d(this.cxr, c.ctD);
    this.cxu.push(this.cxt);
    this.cxt = new g(this.cxt);
    AppMethodBeat.o(208018);
  }
  
  private void Ow()
  {
    AppMethodBeat.i(208021);
    this.cxr.restore();
    this.cxt = ((g)this.cxu.pop());
    AppMethodBeat.o(208021);
  }
  
  private Path.FillType Ox()
  {
    if ((this.cxt.ctr.cvY != null) && (this.cxt.ctr.cvY == h.ae.a.cwh)) {
      return Path.FillType.EVEN_ODD;
    }
    return Path.FillType.WINDING;
  }
  
  private float a(h.ay paramay)
  {
    AppMethodBeat.i(207953);
    j localj = new j((byte)0);
    a(paramay, localj);
    float f = localj.x;
    AppMethodBeat.o(207953);
    return f;
  }
  
  private static Matrix a(h.b paramb1, h.b paramb2, f paramf)
  {
    AppMethodBeat.i(207966);
    Matrix localMatrix = new Matrix();
    if ((paramf == null) || (paramf.ctH == null))
    {
      AppMethodBeat.o(207966);
      return localMatrix;
    }
    float f2 = paramb1.width / paramb2.width;
    float f3 = paramb1.height / paramb2.height;
    float f1 = -paramb2.minX;
    float f4 = -paramb2.minY;
    if (paramf.equals(f.ctK))
    {
      localMatrix.preTranslate(paramb1.minX, paramb1.minY);
      localMatrix.preScale(f2, f3);
      localMatrix.preTranslate(f1, f4);
      AppMethodBeat.o(207966);
      return localMatrix;
    }
    float f5;
    if (paramf.ctI == f.b.cue)
    {
      f3 = Math.max(f2, f3);
      f2 = paramb1.width / f3;
      f5 = paramb1.height / f3;
      switch (1.cxz[paramf.ctH.ordinal()])
      {
      default: 
        label208:
        f2 = f4;
        switch (1.cxz[paramf.ctH.ordinal()])
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
      AppMethodBeat.o(207966);
      return localMatrix;
      f3 = Math.min(f2, f3);
      break;
      f1 -= (paramb2.width - f2) / 2.0F;
      break label208;
      f1 -= paramb2.width - f2;
      break label208;
      f2 = f4 - (paramb2.height - f5) / 2.0F;
      continue;
      f2 = f4 - (paramb2.height - f5);
    }
  }
  
  private Path a(h.ab paramab)
  {
    AppMethodBeat.i(208031);
    float f1;
    float f2;
    float f3;
    float f4;
    label72:
    label88:
    float f5;
    float f6;
    if ((paramab.cuG == null) && (paramab.cuH == null))
    {
      f1 = 0.0F;
      f2 = 0.0F;
      f3 = Math.min(f2, paramab.cuR.a(this) / 2.0F);
      f4 = Math.min(f1, paramab.cuS.b(this) / 2.0F);
      if (paramab.cuP == null) {
        break label275;
      }
      f1 = paramab.cuP.a(this);
      if (paramab.cuQ == null) {
        break label280;
      }
      f2 = paramab.cuQ.b(this);
      f5 = paramab.cuR.a(this);
      f6 = paramab.cuS.b(this);
      if (paramab.cwU == null) {
        paramab.cwU = new h.b(f1, f2, f5, f6);
      }
      f5 = f1 + f5;
      f6 = f2 + f6;
      paramab = new Path();
      if ((f3 != 0.0F) && (f4 != 0.0F)) {
        break label285;
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
      AppMethodBeat.o(208031);
      return paramab;
      if (paramab.cuG == null)
      {
        f2 = paramab.cuH.b(this);
        f1 = f2;
        break;
      }
      if (paramab.cuH == null)
      {
        f2 = paramab.cuG.a(this);
        f1 = f2;
        break;
      }
      f2 = paramab.cuG.a(this);
      f1 = paramab.cuH.b(this);
      break;
      label275:
      f1 = 0.0F;
      break label72;
      label280:
      f2 = 0.0F;
      break label88;
      label285:
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
  
  private Path a(h.ak paramak, boolean paramBoolean)
  {
    AppMethodBeat.i(208012);
    this.cxu.push(this.cxt);
    this.cxt = new g(this.cxt);
    a(this.cxt, paramak);
    if ((!Os()) || (!visible()))
    {
      this.cxt = ((g)this.cxu.pop());
      AppMethodBeat.o(208012);
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
      localObject1 = paramak.cwY.bm(((h.be)localObject3).cut);
      if (localObject1 == null)
      {
        String.format("Use reference '%s' not found", new Object[] { ((h.be)localObject3).cut });
        this.cxt = ((g)this.cxu.pop());
        AppMethodBeat.o(208012);
        return null;
      }
      if (!(localObject1 instanceof h.ak))
      {
        this.cxt = ((g)this.cxu.pop());
        AppMethodBeat.o(208012);
        return null;
      }
      localObject2 = a((h.ak)localObject1, false);
      if (localObject2 == null)
      {
        AppMethodBeat.o(208012);
        return null;
      }
      if (((h.be)localObject3).cwU == null) {
        ((h.be)localObject3).cwU = e((Path)localObject2);
      }
      localObject1 = localObject2;
      if (((h.be)localObject3).transform != null)
      {
        ((Path)localObject2).transform(((h.be)localObject3).transform);
        localObject1 = localObject2;
      }
      if (this.cxt.ctr.cvX != null)
      {
        paramak = c(paramak, paramak.cwU);
        if (paramak != null) {
          ((Path)localObject1).op(paramak, Path.Op.INTERSECT);
        }
      }
      this.cxt = ((g)this.cxu.pop());
      AppMethodBeat.o(208012);
      return localObject1;
    }
    if ((paramak instanceof h.l))
    {
      localObject3 = (h.l)paramak;
      if ((paramak instanceof h.v))
      {
        localObject2 = new c(((h.v)paramak).cvh).path;
        localObject1 = localObject2;
        if (paramak.cwU == null)
        {
          paramak.cwU = e((Path)localObject2);
          localObject1 = localObject2;
        }
      }
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        AppMethodBeat.o(208012);
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
        if (((h.l)localObject3).cwU == null) {
          ((h.l)localObject3).cwU = e((Path)localObject1);
        }
        if (((h.l)localObject3).transform != null) {
          ((Path)localObject1).transform(((h.l)localObject3).transform);
        }
        ((Path)localObject1).setFillType(Ox());
        break;
        if ((paramak instanceof h.aw))
        {
          localObject2 = (h.aw)paramak;
          localObject1 = a((h.aw)localObject2);
          if (localObject1 == null)
          {
            AppMethodBeat.o(208012);
            return null;
          }
          if (((h.aw)localObject2).transform != null) {
            ((Path)localObject1).transform(((h.aw)localObject2).transform);
          }
          ((Path)localObject1).setFillType(Ox());
          break;
        }
        String.format("Invalid %s element found in clipPath definition", new Object[] { paramak.NV() });
        AppMethodBeat.o(208012);
        return null;
      }
      localObject1 = null;
    }
  }
  
  private Path a(h.aw paramaw)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(208052);
    float f1;
    float f3;
    label51:
    float f4;
    label73:
    float f5;
    if ((paramaw.x == null) || (paramaw.x.size() == 0))
    {
      f1 = 0.0F;
      if ((paramaw.cxe != null) && (paramaw.cxe.size() != 0)) {
        break label277;
      }
      f3 = 0.0F;
      if ((paramaw.cxf != null) && (paramaw.cxf.size() != 0)) {
        break label299;
      }
      f4 = 0.0F;
      f5 = f2;
      if (paramaw.cxg != null)
      {
        if (paramaw.cxg.size() != 0) {
          break label321;
        }
        f5 = f2;
      }
      label98:
      f2 = f1;
      if (this.cxt.ctr.cvN != h.ae.f.cwz)
      {
        f2 = a(paramaw);
        if (this.cxt.ctr.cvN != h.ae.f.cwA) {
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
      if (paramaw.cwU == null)
      {
        localObject = new h(f2, f3);
        a(paramaw, (i)localObject);
        paramaw.cwU = new h.b(((h)localObject).cxU.left, ((h)localObject).cxU.top, ((h)localObject).cxU.width(), ((h)localObject).cxU.height());
      }
      Object localObject = new Path();
      a(paramaw, new f(f2 + f4, f5 + f3, (Path)localObject));
      AppMethodBeat.o(208052);
      return localObject;
      f1 = ((h.p)paramaw.x.get(0)).a(this);
      break;
      f3 = ((h.p)paramaw.cxe.get(0)).b(this);
      break label51;
      f4 = ((h.p)paramaw.cxf.get(0)).a(this);
      break label73;
      f5 = ((h.p)paramaw.cxg.get(0)).b(this);
      break label98;
    }
  }
  
  private Path a(h.d paramd)
  {
    AppMethodBeat.i(208035);
    float f1;
    if (paramd.cuy != null)
    {
      f1 = paramd.cuy.a(this);
      if (paramd.cuz == null) {
        break label218;
      }
    }
    label218:
    for (float f2 = paramd.cuz.b(this);; f2 = 0.0F)
    {
      float f7 = paramd.cuA.c(this);
      float f3 = f1 - f7;
      float f4 = f2 - f7;
      float f5 = f1 + f7;
      float f6 = f2 + f7;
      if (paramd.cwU == null) {
        paramd.cwU = new h.b(f3, f4, 2.0F * f7, 2.0F * f7);
      }
      f7 *= 0.5522848F;
      paramd = new Path();
      paramd.moveTo(f1, f4);
      paramd.cubicTo(f1 + f7, f4, f5, f2 - f7, f5, f2);
      paramd.cubicTo(f5, f2 + f7, f1 + f7, f6, f1, f6);
      paramd.cubicTo(f1 - f7, f6, f3, f2 + f7, f3, f2);
      paramd.cubicTo(f3, f2 - f7, f1 - f7, f4, f1, f4);
      paramd.close();
      AppMethodBeat.o(208035);
      return paramd;
      f1 = 0.0F;
      break;
    }
  }
  
  private Path a(h.i parami)
  {
    AppMethodBeat.i(208041);
    float f1;
    if (parami.cuy != null)
    {
      f1 = parami.cuy.a(this);
      if (parami.cuz == null) {
        break label236;
      }
    }
    label236:
    for (float f2 = parami.cuz.b(this);; f2 = 0.0F)
    {
      float f8 = parami.cuG.a(this);
      float f7 = parami.cuH.b(this);
      float f3 = f1 - f8;
      float f4 = f2 - f7;
      float f5 = f1 + f8;
      float f6 = f2 + f7;
      if (parami.cwU == null) {
        parami.cwU = new h.b(f3, f4, 2.0F * f8, 2.0F * f7);
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
      AppMethodBeat.o(208041);
      return parami;
      f1 = 0.0F;
      break;
    }
  }
  
  private static Typeface a(String paramString, Integer paramInteger, h.ae.b paramb)
  {
    int k = 0;
    AppMethodBeat.i(207975);
    int i;
    int j;
    if (paramb == h.ae.b.cwk)
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
      AppMethodBeat.o(207975);
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
    AppMethodBeat.i(207927);
    float f1;
    float f3;
    if (paramp1 != null)
    {
      f1 = paramp1.a(this);
      if (paramp2 != null) {
        f2 = paramp2.b(this);
      }
      paramp1 = Ok();
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
      AppMethodBeat.o(207927);
      return paramp1;
      f1 = 0.0F;
      break;
      f3 = paramp1.width;
      break label47;
    }
  }
  
  private g a(h.an paraman, g paramg)
  {
    AppMethodBeat.i(207992);
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      if ((paraman instanceof h.al)) {
        localArrayList.add(0, (h.al)paraman);
      }
      if (paraman.cwZ == null) {
        break;
      }
      paraman = (h.an)paraman.cwZ;
    }
    paraman = localArrayList.iterator();
    while (paraman.hasNext()) {
      a(paramg, (h.al)paraman.next());
    }
    paramg.cuj = this.cxt.cuj;
    paramg.cuk = this.cxt.cuk;
    AppMethodBeat.o(207992);
    return paramg;
  }
  
  private String a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(207957);
    if (this.cxt.cxT)
    {
      paramString = paramString.replaceAll("[\\n\\t]", " ");
      AppMethodBeat.o(207957);
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
    AppMethodBeat.o(207957);
    return paramString;
  }
  
  private List<b> a(h.z paramz)
  {
    int i = 2;
    AppMethodBeat.i(207947);
    int j = paramz.cvq.length;
    if (j < 2)
    {
      AppMethodBeat.o(207947);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    b localb = new b(paramz.cvq[0], paramz.cvq[1], 0.0F, 0.0F);
    float f2 = 0.0F;
    float f1 = 0.0F;
    while (i < j)
    {
      f1 = paramz.cvq[i];
      f2 = paramz.cvq[(i + 1)];
      localb.U(f1, f2);
      localArrayList.add(localb);
      localb = new b(f1, f2, f1 - localb.x, f2 - localb.y);
      i += 2;
    }
    if ((paramz instanceof h.aa)) {
      if ((f1 != paramz.cvq[0]) && (f2 != paramz.cvq[1]))
      {
        f1 = paramz.cvq[0];
        f2 = paramz.cvq[1];
        localb.U(f1, f2);
        localArrayList.add(localb);
        paramz = new b(f1, f2, f1 - localb.x, f2 - localb.y);
        paramz.a((b)localArrayList.get(0));
        localArrayList.add(paramz);
        localArrayList.set(0, paramz);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(207947);
      return localArrayList;
      localArrayList.add(localb);
    }
  }
  
  private void a(h.af paramaf, h.b paramb1, h.b paramb2, f paramf)
  {
    AppMethodBeat.i(207924);
    if ((paramb1.width == 0.0F) || (paramb1.height == 0.0F))
    {
      AppMethodBeat.o(207924);
      return;
    }
    if (paramf == null) {
      if (paramaf.cuh != null) {
        paramf = paramaf.cuh;
      }
    }
    for (;;)
    {
      a(this.cxt, paramaf);
      if (!Os())
      {
        AppMethodBeat.o(207924);
        return;
        paramf = f.ctL;
      }
      else
      {
        this.cxt.cuk = paramb1;
        if (!this.cxt.ctr.cvO.booleanValue()) {
          j(this.cxt.cuk.minX, this.cxt.cuk.minY, this.cxt.cuk.width, this.cxt.cuk.height);
        }
        b(paramaf, this.cxt.cuk);
        if (paramb2 != null)
        {
          this.cxr.concat(a(this.cxt.cuk, paramb2, paramf));
          this.cxt.cuj = paramaf.cuj;
        }
        for (;;)
        {
          boolean bool = Oo();
          Ou();
          a(paramaf, true);
          if (bool) {
            b(paramaf);
          }
          a(paramaf);
          AppMethodBeat.o(207924);
          return;
          this.cxr.translate(this.cxt.cuk.minX, this.cxt.cuk.minY);
        }
      }
    }
  }
  
  private void a(h.aj paramaj)
  {
    AppMethodBeat.i(207889);
    this.cxv.push(paramaj);
    this.cxw.push(this.cxr.getMatrix());
    AppMethodBeat.o(207889);
  }
  
  private void a(h.aj paramaj, boolean paramBoolean)
  {
    AppMethodBeat.i(207865);
    if (paramBoolean) {
      a(paramaj);
    }
    paramaj = paramaj.NZ().iterator();
    while (paramaj.hasNext()) {
      b((h.an)paramaj.next());
    }
    if (paramBoolean) {
      On();
    }
    AppMethodBeat.o(207865);
  }
  
  private void a(h.ak paramak)
  {
    AppMethodBeat.i(207930);
    if (paramak.cwZ == null)
    {
      AppMethodBeat.o(207930);
      return;
    }
    if (paramak.cwU == null)
    {
      AppMethodBeat.o(207930);
      return;
    }
    Matrix localMatrix = new Matrix();
    if (((Matrix)this.cxw.peek()).invert(localMatrix))
    {
      Object localObject = new float[8];
      localObject[0] = paramak.cwU.minX;
      localObject[1] = paramak.cwU.minY;
      localObject[2] = paramak.cwU.NW();
      localObject[3] = paramak.cwU.minY;
      localObject[4] = paramak.cwU.NW();
      localObject[5] = paramak.cwU.NX();
      localObject[6] = paramak.cwU.minX;
      localObject[7] = paramak.cwU.NX();
      localMatrix.preConcat(this.cxr.getMatrix());
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
      localObject = (h.ak)this.cxv.peek();
      if (((h.ak)localObject).cwU == null)
      {
        ((h.ak)localObject).cwU = h.b.h(paramak.left, paramak.top, paramak.right, paramak.bottom);
        AppMethodBeat.o(207930);
        return;
      }
      ((h.ak)localObject).cwU.a(h.b.h(paramak.left, paramak.top, paramak.right, paramak.bottom));
    }
    AppMethodBeat.o(207930);
  }
  
  private void a(h.ak paramak, Path paramPath)
  {
    AppMethodBeat.i(207913);
    if ((this.cxt.ctr.cvt instanceof h.u))
    {
      h.an localan = this.cwY.bm(((h.u)this.cxt.ctr.cvt).cut);
      if ((localan instanceof h.y))
      {
        a(paramak, paramPath, (h.y)localan);
        AppMethodBeat.o(207913);
        return;
      }
    }
    this.cxr.drawPath(paramPath, this.cxt.cxR);
    AppMethodBeat.o(207913);
  }
  
  private void a(h.ak paramak, Path paramPath, h.y paramy)
  {
    AppMethodBeat.i(208063);
    int i;
    float f1;
    label63:
    float f2;
    label80:
    float f3;
    if ((paramy.cvn != null) && (paramy.cvn.booleanValue()))
    {
      i = 1;
      if (paramy.cut != null) {
        a(paramy, paramy.cut);
      }
      if (i == 0) {
        break label189;
      }
      if (paramy.cuP == null) {
        break label165;
      }
      f1 = paramy.cuP.a(this);
      if (paramy.cuQ == null) {
        break label171;
      }
      f2 = paramy.cuQ.b(this);
      if (paramy.cuR == null) {
        break label177;
      }
      f3 = paramy.cuR.a(this);
      label97:
      if (paramy.cuS == null) {
        break label183;
      }
    }
    label165:
    label171:
    label177:
    label183:
    for (float f4 = paramy.cuS.b(this);; f4 = 0.0F)
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
      AppMethodBeat.o(208063);
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
    if (paramy.cuP != null)
    {
      f1 = paramy.cuP.a(this, 1.0F);
      label207:
      if (paramy.cuQ == null) {
        break label366;
      }
      f2 = paramy.cuQ.a(this, 1.0F);
      label225:
      if (paramy.cuR == null) {
        break label372;
      }
      f3 = paramy.cuR.a(this, 1.0F);
      label243:
      if (paramy.cuS == null) {
        break label378;
      }
    }
    label366:
    label372:
    label378:
    for (f4 = paramy.cuS.a(this, 1.0F);; f4 = 0.0F)
    {
      f6 = paramak.cwU.minX;
      f7 = paramak.cwU.width;
      f8 = paramak.cwU.minY;
      float f9 = paramak.cwU.height;
      float f10 = paramak.cwU.width;
      f5 = f4 * paramak.cwU.height;
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
    if (paramy.cuh != null) {}
    Object localObject;
    for (f localf = paramy.cuh;; localf = f.ctL)
    {
      Ol();
      this.cxr.clipPath(paramPath);
      paramPath = new g();
      a(paramPath, h.ae.Ob());
      paramPath.ctr.cvO = Boolean.FALSE;
      this.cxt = a(paramy, paramPath);
      localObject = paramak.cwU;
      paramPath = (Path)localObject;
      if (paramy.cvp == null) {
        break label775;
      }
      this.cxr.concat(paramy.cvp);
      Matrix localMatrix = new Matrix();
      paramPath = (Path)localObject;
      if (!paramy.cvp.invert(localMatrix)) {
        break label775;
      }
      paramPath = new float[8];
      paramPath[0] = paramak.cwU.minX;
      paramPath[1] = paramak.cwU.minY;
      paramPath[2] = paramak.cwU.NW();
      paramPath[3] = paramak.cwU.minY;
      paramPath[4] = paramak.cwU.NW();
      paramPath[5] = paramak.cwU.NX();
      paramPath[6] = paramak.cwU.minX;
      paramPath[7] = paramak.cwU.NX();
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
    float f7 = paramPath.NW();
    float f8 = paramPath.NX();
    paramPath = new h.b(0.0F, 0.0F, f2, f1);
    boolean bool = Oo();
    for (f4 = f5 * f1 + f4; f4 < f8; f4 += f1) {
      for (f5 = f3 + f6 * f2; f5 < f7; f5 += f2)
      {
        paramPath.minX = f5;
        paramPath.minY = f4;
        Ol();
        if (!this.cxt.ctr.cvO.booleanValue()) {
          j(paramPath.minX, paramPath.minY, paramPath.width, paramPath.height);
        }
        if (paramy.cuj != null)
        {
          this.cxr.concat(a(paramPath, paramy.cuj, localf));
          localObject = paramy.aAO.iterator();
          while (((Iterator)localObject).hasNext()) {
            b((h.an)((Iterator)localObject).next());
          }
        }
        if ((paramy.cvo == null) || (paramy.cvo.booleanValue())) {}
        for (i = 1;; i = 0)
        {
          this.cxr.translate(f5, f4);
          if (i != 0) {
            break;
          }
          this.cxr.scale(paramak.cwU.width, paramak.cwU.height);
          break;
        }
        Om();
      }
    }
    if (bool) {
      b(paramy);
    }
    Om();
    AppMethodBeat.o(208063);
  }
  
  private void a(h.ak paramak, h.b paramb)
  {
    AppMethodBeat.i(207939);
    if (this.cxt.ctr.cvZ != null)
    {
      Object localObject = new Paint();
      ((Paint)localObject).setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
      this.cxr.saveLayer(null, (Paint)localObject, 31);
      localObject = new Paint();
      ((Paint)localObject).setColorFilter(new ColorMatrixColorFilter(new ColorMatrix(new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2127F, 0.7151F, 0.0722F, 0.0F, 0.0F })));
      this.cxr.saveLayer(null, (Paint)localObject, 31);
      localObject = this.cwY.bm(this.cxt.ctr.cvZ);
      a((h.s)localObject, paramak, paramb);
      this.cxr.restore();
      Paint localPaint = new Paint();
      localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
      this.cxr.saveLayer(null, localPaint, 31);
      a((h.s)localObject, paramak, paramb);
      this.cxr.restore();
      this.cxr.restore();
    }
    Om();
    AppMethodBeat.o(207939);
  }
  
  private static void a(h.am paramam1, h.am paramam2)
  {
    if (paramam1.cuU == null) {
      paramam1.cuU = paramam2.cuU;
    }
    if (paramam1.cuV == null) {
      paramam1.cuV = paramam2.cuV;
    }
    if (paramam1.cuW == null) {
      paramam1.cuW = paramam2.cuW;
    }
    if (paramam1.cuX == null) {
      paramam1.cuX = paramam2.cuX;
    }
  }
  
  private void a(h.an paraman, boolean paramBoolean, Path paramPath, Matrix paramMatrix)
  {
    AppMethodBeat.i(208017);
    if (!Os())
    {
      AppMethodBeat.o(208017);
      return;
    }
    Ov();
    if ((paraman instanceof h.be)) {
      if (paramBoolean) {
        a((h.be)paraman, paramPath, paramMatrix);
      }
    }
    for (;;)
    {
      Ow();
      AppMethodBeat.o(208017);
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
    if (paramaq1.cuy == null) {
      paramaq1.cuy = paramaq2.cuy;
    }
    if (paramaq1.cuz == null) {
      paramaq1.cuz = paramaq2.cuz;
    }
    if (paramaq1.cuA == null) {
      paramaq1.cuA = paramaq2.cuA;
    }
    if (paramaq1.cxa == null) {
      paramaq1.cxa = paramaq2.cxa;
    }
    if (paramaq1.cxb == null) {
      paramaq1.cxb = paramaq2.cxb;
    }
  }
  
  private void a(h.aw paramaw, Path paramPath, Matrix paramMatrix)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(208029);
    a(this.cxt, paramaw);
    if (!Os())
    {
      AppMethodBeat.o(208029);
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
    if ((paramaw.x == null) || (paramaw.x.size() == 0))
    {
      f1 = 0.0F;
      if ((paramaw.cxe != null) && (paramaw.cxe.size() != 0)) {
        break label347;
      }
      f3 = 0.0F;
      if ((paramaw.cxf != null) && (paramaw.cxf.size() != 0)) {
        break label369;
      }
      f4 = 0.0F;
      f5 = f2;
      if (paramaw.cxg != null)
      {
        if (paramaw.cxg.size() != 0) {
          break label391;
        }
        f5 = f2;
      }
      label141:
      f2 = f1;
      if (this.cxt.ctr.cvN != h.ae.f.cwz)
      {
        f2 = a(paramaw);
        if (this.cxt.ctr.cvN != h.ae.f.cwA) {
          break label413;
        }
      }
    }
    label391:
    label413:
    for (f2 = f1 - f2 / 2.0F;; f2 = f1 - f2)
    {
      if (paramaw.cwU == null)
      {
        localObject = new h(f2, f3);
        a(paramaw, (i)localObject);
        paramaw.cwU = new h.b(((h)localObject).cxU.left, ((h)localObject).cxU.top, ((h)localObject).cxU.width(), ((h)localObject).cxU.height());
      }
      d(paramaw);
      Object localObject = new Path();
      a(paramaw, new f(f2 + f4, f5 + f3, (Path)localObject));
      paramPath.setFillType(Ox());
      paramPath.addPath((Path)localObject, paramMatrix);
      AppMethodBeat.o(208029);
      return;
      f1 = ((h.p)paramaw.x.get(0)).a(this);
      break;
      label347:
      f3 = ((h.p)paramaw.cxe.get(0)).b(this);
      break label92;
      label369:
      f4 = ((h.p)paramaw.cxf.get(0)).a(this);
      break label114;
      f5 = ((h.p)paramaw.cxg.get(0)).b(this);
      break label141;
    }
  }
  
  private void a(h.ay paramay, i parami)
  {
    AppMethodBeat.i(207951);
    if (!Os())
    {
      AppMethodBeat.o(207951);
      return;
    }
    paramay = paramay.aAO.iterator();
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
          parami.bp(a((String)localObject1, bool1, bool2));
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
          Ol();
          localObject1 = (h.az)localObject2;
          a(this.cxt, (h.al)localObject1);
          if ((Os()) && (visible()))
          {
            localObject2 = ((h.az)localObject1).cwY.bm(((h.az)localObject1).cut);
            if (localObject2 != null) {
              break label210;
            }
            String.format("TextPath reference '%s' not found", new Object[] { ((h.az)localObject1).cut });
          }
          Om();
        }
      }
      Object localObject3 = (h.v)localObject2;
      localObject2 = new c(((h.v)localObject3).cvh).path;
      if (((h.v)localObject3).transform != null) {
        ((Path)localObject2).transform(((h.v)localObject3).transform);
      }
      localObject3 = new PathMeasure((Path)localObject2, false);
      if (((h.az)localObject1).cxd != null)
      {
        f1 = ((h.az)localObject1).cxd.a(this, ((PathMeasure)localObject3).getLength());
        label287:
        localObject3 = Or();
        if (localObject3 == h.ae.f.cwz) {
          break label938;
        }
        f2 = a((h.ay)localObject1);
        if (localObject3 != h.ae.f.cwA) {
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
      c((h.ak)((h.az)localObject1).cxc);
      bool1 = Oo();
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
        Ol();
        localObject1 = (h.av)localObject2;
        a(this.cxt, (h.al)localObject1);
        if (Os())
        {
          f1 = 0.0F;
          f4 = 0.0F;
          f2 = 0.0F;
          if ((((h.av)localObject1).x == null) || (((h.av)localObject1).x.size() <= 0)) {
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
          if ((((h.av)localObject1).cxe != null) && (((h.av)localObject1).cxe.size() != 0)) {
            break label707;
          }
          f3 = ((e)parami).y;
          if ((((h.av)localObject1).cxf != null) && (((h.av)localObject1).cxf.size() != 0)) {
            break label730;
          }
          f2 = 0.0F;
          if ((((h.av)localObject1).cxg != null) && (((h.av)localObject1).cxg.size() != 0)) {
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
          localObject2 = Or();
          if (localObject2 != h.ae.f.cwz)
          {
            f5 = a((h.ay)localObject1);
            if (localObject2 == h.ae.f.cwA) {
              f1 -= f5 / 2.0F;
            }
          }
        }
        for (;;)
        {
          c((h.ak)((h.av)localObject1).cxc);
          if ((parami instanceof e))
          {
            ((e)parami).x = (f1 + f2);
            ((e)parami).y = (f4 + f3);
          }
          bool1 = Oo();
          a((h.ay)localObject1, parami);
          if (bool1) {
            b((h.ak)localObject1);
          }
          Om();
          break;
          i = 0;
          break label454;
          label685:
          f1 = ((h.p)((h.av)localObject1).x.get(0)).a(this);
          break label474;
          label707:
          f3 = ((h.p)((h.av)localObject1).cxe.get(0)).b(this);
          break label504;
          label730:
          f2 = ((h.p)((h.av)localObject1).cxf.get(0)).a(this);
          break label528;
          label753:
          f4 = ((h.p)((h.av)localObject1).cxg.get(0)).b(this);
          break label552;
          f1 -= f5;
          continue;
          if (!(localObject2 instanceof h.au)) {
            break;
          }
          Ol();
          localObject1 = (h.au)localObject2;
          a(this.cxt, (h.al)localObject1);
          if (!Os()) {
            break label203;
          }
          c((h.ak)((h.au)localObject1).cxc);
          localObject2 = ((h.an)localObject2).cwY.bm(((h.au)localObject1).cut);
          if ((localObject2 != null) && ((localObject2 instanceof h.ay)))
          {
            localObject1 = new StringBuilder();
            a((h.ay)localObject2, (StringBuilder)localObject1);
            if (((StringBuilder)localObject1).length() <= 0) {
              break label203;
            }
            parami.bp(((StringBuilder)localObject1).toString());
            break label203;
          }
          String.format("Tref reference '%s' not found", new Object[] { ((h.au)localObject1).cut });
          break label203;
          AppMethodBeat.o(207951);
          return;
        }
      }
    }
  }
  
  private void a(h.ay paramay, StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(207955);
    paramay = paramay.aAO.iterator();
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
    AppMethodBeat.o(207955);
  }
  
  private void a(h.be parambe, Path paramPath, Matrix paramMatrix)
  {
    AppMethodBeat.i(208027);
    a(this.cxt, parambe);
    if (!Os())
    {
      AppMethodBeat.o(208027);
      return;
    }
    if (!visible())
    {
      AppMethodBeat.o(208027);
      return;
    }
    if (parambe.transform != null) {
      paramMatrix.preConcat(parambe.transform);
    }
    h.an localan = parambe.cwY.bm(parambe.cut);
    if (localan == null)
    {
      String.format("Use reference '%s' not found", new Object[] { parambe.cut });
      AppMethodBeat.o(208027);
      return;
    }
    d(parambe);
    a(localan, false, paramPath, paramMatrix);
    AppMethodBeat.o(208027);
  }
  
  private static void a(h.j paramj, String paramString)
  {
    AppMethodBeat.i(208001);
    for (;;)
    {
      h.an localan = paramj.cwY.bm(paramString);
      if (localan == null)
      {
        String.format("Gradient reference '%s' not found", new Object[] { paramString });
        AppMethodBeat.o(208001);
        return;
      }
      if (!(localan instanceof h.j))
      {
        String.format("Gradient href attributes must point to other gradient elements", new Object[0]);
        AppMethodBeat.o(208001);
        return;
      }
      if (localan == paramj)
      {
        String.format("Circular reference in gradient href attribute '%s'", new Object[] { paramString });
        AppMethodBeat.o(208001);
        return;
      }
      paramString = (h.j)localan;
      if (paramj.cuI == null) {
        paramj.cuI = paramString.cuI;
      }
      if (paramj.cuJ == null) {
        paramj.cuJ = paramString.cuJ;
      }
      if (paramj.cuK == null) {
        paramj.cuK = paramString.cuK;
      }
      if (paramj.aAO.isEmpty()) {
        paramj.aAO = paramString.aAO;
      }
      try
      {
        if ((paramj instanceof h.am)) {
          a((h.am)paramj, (h.am)localan);
        }
        for (;;)
        {
          label181:
          if (paramString.cut == null) {
            break label214;
          }
          paramString = paramString.cut;
          break;
          a((h.aq)paramj, (h.aq)localan);
        }
      }
      catch (ClassCastException localClassCastException)
      {
        break label181;
        label214:
        AppMethodBeat.o(208001);
      }
    }
  }
  
  private void a(h.l paraml)
  {
    AppMethodBeat.i(207985);
    if ((this.cxt.ctr.cvQ == null) && (this.cxt.ctr.cvR == null) && (this.cxt.ctr.cvS == null))
    {
      AppMethodBeat.o(207985);
      return;
    }
    Object localObject1;
    Object localObject2;
    label140:
    Object localObject3;
    if (this.cxt.ctr.cvQ != null)
    {
      localObject1 = paraml.cwY.bm(this.cxt.ctr.cvQ);
      if (localObject1 != null)
      {
        localObject1 = (h.r)localObject1;
        if (this.cxt.ctr.cvR == null) {
          break label275;
        }
        localObject2 = paraml.cwY.bm(this.cxt.ctr.cvR);
        if (localObject2 == null) {
          break label251;
        }
        localObject2 = (h.r)localObject2;
        if (this.cxt.ctr.cvS == null) {
          break label305;
        }
        localObject3 = paraml.cwY.bm(this.cxt.ctr.cvS);
        if (localObject3 == null) {
          break label281;
        }
        localObject3 = (h.r)localObject3;
        label184:
        if (!(paraml instanceof h.v)) {
          break label311;
        }
        paraml = new a(((h.v)paraml).cvh).cxC;
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
      AppMethodBeat.o(207985);
      return;
      String.format("Marker reference '%s' not found", new Object[] { this.cxt.ctr.cvQ });
      localObject1 = null;
      break;
      String.format("Marker reference '%s' not found", new Object[] { this.cxt.ctr.cvR });
      localObject2 = null;
      break label140;
      String.format("Marker reference '%s' not found", new Object[] { this.cxt.ctr.cvS });
      localObject3 = null;
      break label184;
      if ((paraml instanceof h.q))
      {
        paraml = (h.q)paraml;
        label355:
        float f3;
        if (paraml.cuU != null)
        {
          f1 = paraml.cuU.a(this);
          if (paraml.cuV == null) {
            break label458;
          }
          f2 = paraml.cuV.b(this);
          if (paraml.cuW == null) {
            break label463;
          }
          f3 = paraml.cuW.a(this);
          label372:
          if (paraml.cuX == null) {
            break label469;
          }
        }
        label458:
        label463:
        label469:
        for (float f4 = paraml.cuX.b(this);; f4 = 0.0F)
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
      AppMethodBeat.o(207985);
      return;
    }
    Object localObject4 = this.cxt.ctr;
    Object localObject5 = this.cxt.ctr;
    this.cxt.ctr.cvS = null;
    ((h.ae)localObject5).cvR = null;
    ((h.ae)localObject4).cvQ = null;
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
        if (!((b)localObject1).cxL) {
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
        AppMethodBeat.o(207985);
        return;
      }
    }
  }
  
  private void a(h.l paraml, Path paramPath, Matrix paramMatrix)
  {
    AppMethodBeat.i(208026);
    a(this.cxt, paraml);
    if (!Os())
    {
      AppMethodBeat.o(208026);
      return;
    }
    if (!visible())
    {
      AppMethodBeat.o(208026);
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
      paramPath.setFillType(Ox());
      paramPath.addPath(localPath, paramMatrix);
      AppMethodBeat.o(208026);
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
    AppMethodBeat.o(208026);
  }
  
  private void a(h.r paramr, b paramb)
  {
    float f4 = 3.0F;
    float f8 = 0.0F;
    AppMethodBeat.i(207988);
    Ol();
    float f1;
    if (paramr.cvd != null) {
      if (Float.isNaN(paramr.cvd.floatValue()))
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
      if (paramr.cuY)
      {
        f2 = 1.0F;
        this.cxt = d(paramr);
        localMatrix = new Matrix();
        localMatrix.preTranslate(paramb.x, paramb.y);
        localMatrix.preRotate(f1);
        localMatrix.preScale(f2, f2);
        if (paramr.cuZ == null) {
          break label557;
        }
        f2 = paramr.cuZ.a(this);
        if (paramr.cva == null) {
          break label563;
        }
        f5 = paramr.cva.b(this);
        if (paramr.cvb == null) {
          break label569;
        }
        f3 = paramr.cvb.a(this);
        if (paramr.cvc != null) {
          f4 = paramr.cvc.b(this);
        }
        if (paramr.cuj == null) {
          break label643;
        }
        f7 = f3 / paramr.cuj.width;
        f6 = f4 / paramr.cuj.height;
        if (paramr.cuh == null) {
          break label577;
        }
        paramb = paramr.cuh;
        label244:
        if (paramb.equals(f.ctK)) {
          break label693;
        }
        if (paramb.ctI != f.b.cue) {
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
        this.cxr.concat(localMatrix);
        f1 = paramr.cuj.width * f7;
        f5 = paramr.cuj.height * f6;
        switch (1.cxz[paramb.ctH.ordinal()])
        {
        default: 
          f1 = 0.0F;
          label378:
          f2 = f8;
          switch (1.cxz[paramb.ctH.ordinal()])
          {
          default: 
            f2 = f8;
          case 4: 
            label440:
            if (!this.cxt.ctr.cvO.booleanValue()) {
              j(f1, f2, f3, f4);
            }
            localMatrix.reset();
            localMatrix.preScale(f7, f6);
            this.cxr.concat(localMatrix);
          }
          break;
        }
        for (;;)
        {
          boolean bool = Oo();
          a(paramr, false);
          if (bool) {
            b(paramr);
          }
          Om();
          AppMethodBeat.o(207988);
          return;
          f1 = paramr.cvd.floatValue();
          break;
          f2 = this.cxt.ctr.cvz.aL(this.cxs);
          break label84;
          f2 = 0.0F;
          break label150;
          f5 = 0.0F;
          break label167;
          label569:
          f3 = 3.0F;
          break label184;
          label577:
          paramb = f.ctL;
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
          this.cxr.concat(localMatrix);
          if (!this.cxt.ctr.cvO.booleanValue()) {
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
    AppMethodBeat.i(208077);
    if ((params.cve != null) && (params.cve.booleanValue()))
    {
      i = 1;
      if (i == 0) {
        break label115;
      }
      if (params.cuR == null) {
        break label97;
      }
      f1 = params.cuR.a(this);
      label53:
      if (params.cuS == null) {
        break label106;
      }
    }
    label97:
    label106:
    for (f2 = params.cuS.b(this);; f2 = paramb.height)
    {
      if ((f1 != 0.0F) && (f2 != 0.0F)) {
        break label180;
      }
      AppMethodBeat.o(208077);
      return;
      i = 0;
      break;
      f1 = paramb.width;
      break label53;
    }
    label115:
    if (params.cuR != null) {}
    for (float f1 = params.cuR.a(this, 1.0F);; f1 = 1.2F)
    {
      if (params.cuS != null) {
        f2 = params.cuS.a(this, 1.0F);
      }
      f1 *= paramb.width;
      f2 *= paramb.height;
      break;
    }
    label180:
    Ol();
    this.cxt = d(params);
    this.cxt.ctr.cvF = Float.valueOf(1.0F);
    boolean bool = Oo();
    this.cxr.save();
    if ((params.cvf == null) || (params.cvf.booleanValue())) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.cxr.translate(paramb.minX, paramb.minY);
        this.cxr.scale(paramb.width, paramb.height);
      }
      a(params, false);
      this.cxr.restore();
      if (bool) {
        a(paramak, paramb);
      }
      Om();
      AppMethodBeat.o(208077);
      return;
    }
  }
  
  private void a(h.v paramv, Path paramPath, Matrix paramMatrix)
  {
    AppMethodBeat.i(208024);
    a(this.cxt, paramv);
    if (!Os())
    {
      AppMethodBeat.o(208024);
      return;
    }
    if (!visible())
    {
      AppMethodBeat.o(208024);
      return;
    }
    if (paramv.transform != null) {
      paramMatrix.preConcat(paramv.transform);
    }
    Path localPath = new c(paramv.cvh).path;
    if (paramv.cwU == null) {
      paramv.cwU = e(localPath);
    }
    d(paramv);
    paramPath.setFillType(Ox());
    paramPath.addPath(localPath, paramMatrix);
    AppMethodBeat.o(208024);
  }
  
  private static void a(h.y paramy, String paramString)
  {
    AppMethodBeat.i(208068);
    for (;;)
    {
      h.an localan = paramy.cwY.bm(paramString);
      if (localan == null)
      {
        String.format("Pattern reference '%s' not found", new Object[] { paramString });
        AppMethodBeat.o(208068);
        return;
      }
      if (!(localan instanceof h.y))
      {
        String.format("Pattern href attributes must point to other pattern elements", new Object[0]);
        AppMethodBeat.o(208068);
        return;
      }
      if (localan == paramy)
      {
        String.format("Circular reference in pattern href attribute '%s'", new Object[] { paramString });
        AppMethodBeat.o(208068);
        return;
      }
      paramString = (h.y)localan;
      if (paramy.cvn == null) {
        paramy.cvn = paramString.cvn;
      }
      if (paramy.cvo == null) {
        paramy.cvo = paramString.cvo;
      }
      if (paramy.cvp == null) {
        paramy.cvp = paramString.cvp;
      }
      if (paramy.cuP == null) {
        paramy.cuP = paramString.cuP;
      }
      if (paramy.cuQ == null) {
        paramy.cuQ = paramString.cuQ;
      }
      if (paramy.cuR == null) {
        paramy.cuR = paramString.cuR;
      }
      if (paramy.cuS == null) {
        paramy.cuS = paramString.cuS;
      }
      if (paramy.aAO.isEmpty()) {
        paramy.aAO = paramString.aAO;
      }
      if (paramy.cuj == null) {
        paramy.cuj = paramString.cuj;
      }
      if (paramy.cuh == null) {
        paramy.cuh = paramString.cuh;
      }
      if (paramString.cut == null) {
        break;
      }
      paramString = paramString.cut;
    }
    AppMethodBeat.o(208068);
  }
  
  private void a(g paramg, h.ae paramae)
  {
    boolean bool2 = true;
    AppMethodBeat.i(207971);
    if (a(paramae, 4096L)) {
      paramg.ctr.cvG = paramae.cvG;
    }
    if (a(paramae, 2048L)) {
      paramg.ctr.cvF = paramae.cvF;
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
      paramg.ctr.cvt = paramae.cvt;
      if ((paramae.cvt != null) && (paramae.cvt != h.f.cuE))
      {
        bool1 = true;
        paramg.cxP = bool1;
      }
    }
    else
    {
      if (a(paramae, 4L)) {
        paramg.ctr.cvw = paramae.cvw;
      }
      if (a(paramae, 6149L)) {
        a(paramg, true, paramg.ctr.cvt);
      }
      if (a(paramae, 2L)) {
        paramg.ctr.cvu = paramae.cvu;
      }
      if (a(paramae, 8L))
      {
        paramg.ctr.cvx = paramae.cvx;
        if ((paramae.cvx == null) || (paramae.cvx == h.f.cuE)) {
          break label1394;
        }
        bool1 = true;
        paramg.cxQ = bool1;
      }
      if (a(paramae, 16L)) {
        paramg.ctr.cvy = paramae.cvy;
      }
      if (a(paramae, 6168L)) {
        a(paramg, false, paramg.ctr.cvx);
      }
      if (a(paramae, 34359738368L)) {
        paramg.ctr.cwe = paramae.cwe;
      }
      if (a(paramae, 32L))
      {
        paramg.ctr.cvz = paramae.cvz;
        paramg.cxS.setStrokeWidth(paramg.ctr.cvz.c(this));
      }
      if (a(paramae, 64L)) {
        paramg.ctr.cvA = paramae.cvA;
      }
      switch (1.cxA[paramae.cvA.ordinal()])
      {
      default: 
        if (a(paramae, 128L)) {
          paramg.ctr.cvB = paramae.cvB;
        }
        switch (1.cxB[paramae.cvB.ordinal()])
        {
        default: 
          if (a(paramae, 256L))
          {
            paramg.ctr.cvC = paramae.cvC;
            paramg.cxS.setStrokeMiter(paramae.cvC.floatValue());
          }
          if (a(paramae, 512L)) {
            paramg.ctr.cvD = paramae.cvD;
          }
          if (a(paramae, 1024L)) {
            paramg.ctr.cvE = paramae.cvE;
          }
          if (a(paramae, 1536L))
          {
            if (paramg.ctr.cvD == null) {
              paramg.cxS.setPathEffect(null);
            }
          }
          else
          {
            if (a(paramae, 16384L))
            {
              f1 = Oj();
              paramg.ctr.cvI = paramae.cvI;
              paramg.cxR.setTextSize(paramae.cvI.a(this, f1));
              paramg.cxS.setTextSize(paramae.cvI.a(this, f1));
            }
            if (a(paramae, 8192L)) {
              paramg.ctr.cvH = paramae.cvH;
            }
            if (a(paramae, 32768L))
            {
              if ((paramae.cvJ.intValue() != -1) || (paramg.ctr.cvJ.intValue() <= 100)) {
                break label1637;
              }
              localObject1 = paramg.ctr;
              ((h.ae)localObject1).cvJ = Integer.valueOf(((h.ae)localObject1).cvJ.intValue() - 100);
            }
            if (a(paramae, 65536L)) {
              paramg.ctr.cvK = paramae.cvK;
            }
            if (a(paramae, 106496L))
            {
              if ((paramg.ctr.cvH == null) || (this.cwY == null)) {
                break label1730;
              }
              j localj = h.NU();
              Iterator localIterator = paramg.ctr.cvH.iterator();
              localObject2 = null;
              do
              {
                localObject1 = localObject2;
                if (!localIterator.hasNext()) {
                  break;
                }
                localObject2 = a((String)localIterator.next(), paramg.ctr.cvJ, paramg.ctr.cvK);
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  localObject1 = localObject2;
                  if (localj != null)
                  {
                    paramg.ctr.cvJ.intValue();
                    String.valueOf(paramg.ctr.cvK);
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
        localObject2 = a("serif", paramg.ctr.cvJ, paramg.ctr.cvK);
      }
      paramg.cxR.setTypeface((Typeface)localObject2);
      paramg.cxS.setTypeface((Typeface)localObject2);
      if (a(paramae, 131072L))
      {
        paramg.ctr.cvL = paramae.cvL;
        localObject1 = paramg.cxR;
        if (paramae.cvL != h.ae.g.cwG) {
          break label1706;
        }
        bool1 = true;
        label930:
        ((Paint)localObject1).setStrikeThruText(bool1);
        localObject1 = paramg.cxR;
        if (paramae.cvL != h.ae.g.cwE) {
          break label1712;
        }
        bool1 = true;
        label956:
        ((Paint)localObject1).setUnderlineText(bool1);
        if (Build.VERSION.SDK_INT >= 17)
        {
          localObject1 = paramg.cxS;
          if (paramae.cvL != h.ae.g.cwG) {
            break label1718;
          }
          bool1 = true;
          label990:
          ((Paint)localObject1).setStrikeThruText(bool1);
          localObject1 = paramg.cxS;
          if (paramae.cvL != h.ae.g.cwE) {
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
          paramg.ctr.cvM = paramae.cvM;
        }
        if (a(paramae, 262144L)) {
          paramg.ctr.cvN = paramae.cvN;
        }
        if (a(paramae, 524288L)) {
          paramg.ctr.cvO = paramae.cvO;
        }
        if (a(paramae, 2097152L)) {
          paramg.ctr.cvQ = paramae.cvQ;
        }
        if (a(paramae, 4194304L)) {
          paramg.ctr.cvR = paramae.cvR;
        }
        if (a(paramae, 8388608L)) {
          paramg.ctr.cvS = paramae.cvS;
        }
        if (a(paramae, 16777216L)) {
          paramg.ctr.cvT = paramae.cvT;
        }
        if (a(paramae, 33554432L)) {
          paramg.ctr.cvU = paramae.cvU;
        }
        if (a(paramae, 1048576L)) {
          paramg.ctr.cvP = paramae.cvP;
        }
        if (a(paramae, 268435456L)) {
          paramg.ctr.cvX = paramae.cvX;
        }
        if (a(paramae, 536870912L)) {
          paramg.ctr.cvY = paramae.cvY;
        }
        if (a(paramae, 1073741824L)) {
          paramg.ctr.cvZ = paramae.cvZ;
        }
        if (a(paramae, 67108864L)) {
          paramg.ctr.cvV = paramae.cvV;
        }
        if (a(paramae, 134217728L)) {
          paramg.ctr.cvW = paramae.cvW;
        }
        if (a(paramae, 8589934592L)) {
          paramg.ctr.cwc = paramae.cwc;
        }
        if (a(paramae, 17179869184L)) {
          paramg.ctr.cwd = paramae.cwd;
        }
        if (a(paramae, 137438953472L)) {
          paramg.ctr.cwf = paramae.cwf;
        }
        AppMethodBeat.o(207971);
        return;
        bool1 = false;
        break;
        label1394:
        bool1 = false;
        break label201;
        paramg.cxS.setStrokeCap(Paint.Cap.BUTT);
        break label368;
        paramg.cxS.setStrokeCap(Paint.Cap.ROUND);
        break label368;
        paramg.cxS.setStrokeCap(Paint.Cap.SQUARE);
        break label368;
        paramg.cxS.setStrokeJoin(Paint.Join.MITER);
        break label428;
        paramg.cxS.setStrokeJoin(Paint.Join.ROUND);
        break label428;
        paramg.cxS.setStrokeJoin(Paint.Join.BEVEL);
        break label428;
        int k = paramg.ctr.cvD.length;
        if (k % 2 == 0) {}
        for (int i = k;; i = k * 2)
        {
          localObject1 = new float[i];
          int j = 0;
          f1 = 0.0F;
          while (j < i)
          {
            localObject1[j] = paramg.ctr.cvD[(j % k)].c(this);
            f1 += localObject1[j];
            j += 1;
          }
        }
        if (f1 == 0.0F)
        {
          paramg.cxS.setPathEffect(null);
          break label534;
        }
        float f3 = paramg.ctr.cvE.c(this);
        float f2 = f3;
        if (f3 < 0.0F) {
          f2 = f3 % f1 + f1;
        }
        paramg.cxS.setPathEffect(new DashPathEffect((float[])localObject1, f2));
        break label534;
        label1637:
        if ((paramae.cvJ.intValue() == 1) && (paramg.ctr.cvJ.intValue() < 900))
        {
          localObject1 = paramg.ctr;
          ((h.ae)localObject1).cvJ = Integer.valueOf(((h.ae)localObject1).cvJ.intValue() + 100);
          break label674;
        }
        paramg.ctr.cvJ = paramae.cvJ;
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
    AppMethodBeat.i(207902);
    if (paramal.cwZ == null) {}
    for (boolean bool = true;; bool = false)
    {
      paramg.ctr.br(bool);
      if (paramal.cwW != null) {
        a(paramg, paramal.cwW);
      }
      if (!this.cwY.NS()) {
        break;
      }
      Iterator localIterator = this.cwY.cup.ctt.iterator();
      while (localIterator.hasNext())
      {
        b.o localo = (b.o)localIterator.next();
        if (b.a(this.cxy, localo.ctq, paramal)) {
          a(paramg, localo.ctr);
        }
      }
    }
    if (paramal.ctr != null) {
      a(paramg, paramal.ctr);
    }
    AppMethodBeat.o(207902);
  }
  
  private static void a(g paramg, boolean paramBoolean, h.ao paramao)
  {
    AppMethodBeat.i(207973);
    Float localFloat;
    float f;
    if (paramBoolean)
    {
      localFloat = paramg.ctr.cvw;
      f = localFloat.floatValue();
      if (!(paramao instanceof h.f)) {
        break label81;
      }
    }
    for (int i = ((h.f)paramao).cuC;; i = paramg.ctr.cvG.cuC)
    {
      i = i(i, f);
      if (!paramBoolean) {
        break label110;
      }
      paramg.cxR.setColor(i);
      AppMethodBeat.o(207973);
      return;
      localFloat = paramg.ctr.cvy;
      break;
      label81:
      if (!(paramao instanceof h.g)) {
        break label103;
      }
    }
    label103:
    AppMethodBeat.o(207973);
    return;
    label110:
    paramg.cxS.setColor(i);
    AppMethodBeat.o(207973);
  }
  
  private void a(boolean paramBoolean, h.ac paramac)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    AppMethodBeat.i(208004);
    g localg;
    if (paramBoolean)
    {
      if (a(paramac.cwW, 2147483648L))
      {
        this.cxt.ctr.cvt = paramac.cwW.cwa;
        localg = this.cxt;
        if (paramac.cwW.cwa == null) {
          break label134;
        }
      }
      for (;;)
      {
        localg.cxP = bool1;
        if (a(paramac.cwW, 4294967296L)) {
          this.cxt.ctr.cvw = paramac.cwW.cwb;
        }
        if (!a(paramac.cwW, 6442450944L)) {
          break;
        }
        paramac = this.cxt;
        a(paramac, paramBoolean, paramac.ctr.cvt);
        AppMethodBeat.o(208004);
        return;
        label134:
        bool1 = false;
      }
    }
    if (a(paramac.cwW, 2147483648L))
    {
      this.cxt.ctr.cvx = paramac.cwW.cwa;
      localg = this.cxt;
      if (paramac.cwW.cwa == null) {
        break label261;
      }
    }
    label261:
    for (bool1 = bool2;; bool1 = false)
    {
      localg.cxQ = bool1;
      if (a(paramac.cwW, 4294967296L)) {
        this.cxt.ctr.cvy = paramac.cwW.cwb;
      }
      if (a(paramac.cwW, 6442450944L))
      {
        paramac = this.cxt;
        a(paramac, paramBoolean, paramac.ctr.cvx);
      }
      AppMethodBeat.o(208004);
      return;
    }
  }
  
  private void a(boolean paramBoolean, h.b paramb, h.am paramam)
  {
    AppMethodBeat.i(207999);
    if (paramam.cut != null) {
      a(paramam, paramam.cut);
    }
    Paint localPaint;
    label54:
    float f2;
    label82:
    float f1;
    label99:
    float f3;
    if ((paramam.cuI != null) && (paramam.cuI.booleanValue()))
    {
      i = 1;
      if (!paramBoolean) {
        break label258;
      }
      localPaint = this.cxt.cxR;
      if (i == 0) {
        break label298;
      }
      localObject = Ok();
      if (paramam.cuU == null) {
        break label270;
      }
      f2 = paramam.cuU.a(this);
      if (paramam.cuV == null) {
        break label276;
      }
      f1 = paramam.cuV.b(this);
      if (paramam.cuW == null) {
        break label282;
      }
      f3 = paramam.cuW.a(this);
      label116:
      if (paramam.cuX == null) {
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
    for (float f4 = paramam.cuX.b(this);; f4 = 0.0F)
    {
      f5 = f2;
      f2 = f1;
      Ol();
      this.cxt = d(paramam);
      localMatrix = new Matrix();
      if (i == 0)
      {
        localMatrix.preTranslate(paramb.minX, paramb.minY);
        localMatrix.preScale(paramb.width, paramb.height);
      }
      if (paramam.cuJ != null) {
        localMatrix.preConcat(paramam.cuJ);
      }
      j = paramam.aAO.size();
      if (j != 0) {
        break label416;
      }
      Om();
      if (!paramBoolean) {
        break label401;
      }
      this.cxt.cxP = false;
      AppMethodBeat.o(207999);
      return;
      i = 0;
      break;
      localPaint = this.cxt.cxS;
      break label54;
      f2 = 0.0F;
      break label82;
      f1 = 0.0F;
      break label99;
      f3 = ((h.b)localObject).width;
      break label116;
    }
    label298:
    if (paramam.cuU != null)
    {
      f1 = paramam.cuU.a(this, 1.0F);
      label316:
      if (paramam.cuV == null) {
        break label383;
      }
      f2 = paramam.cuV.a(this, 1.0F);
      label334:
      if (paramam.cuW == null) {
        break label389;
      }
      f3 = paramam.cuW.a(this, 1.0F);
      label352:
      if (paramam.cuX == null) {
        break label395;
      }
    }
    label389:
    label395:
    for (f4 = paramam.cuX.a(this, 1.0F);; f4 = 0.0F)
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
    this.cxt.cxQ = false;
    AppMethodBeat.o(207999);
    return;
    label416:
    int[] arrayOfInt = new int[j];
    float[] arrayOfFloat = new float[j];
    int i = 0;
    Iterator localIterator = paramam.aAO.iterator();
    float f6 = -1.0F;
    if (localIterator.hasNext())
    {
      paramb = (h.ad)localIterator.next();
      if (paramb.cvr != null)
      {
        f1 = paramb.cvr.floatValue();
        label487:
        if ((i != 0) && (f1 < f6)) {
          break label595;
        }
        arrayOfFloat[i] = f1;
      }
      for (;;)
      {
        Ol();
        a(this.cxt, paramb);
        localObject = (h.f)this.cxt.ctr.cvV;
        paramb = (h.b)localObject;
        if (localObject == null) {
          paramb = h.f.cuD;
        }
        arrayOfInt[i] = i(paramb.cuC, this.cxt.ctr.cvW.floatValue());
        Om();
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
      Om();
      localPaint.setColor(arrayOfInt[(j - 1)]);
      AppMethodBeat.o(207999);
      return;
    }
    Object localObject = Shader.TileMode.CLAMP;
    paramb = (h.b)localObject;
    if (paramam.cuK != null)
    {
      if (paramam.cuK != h.k.cuM) {
        break label749;
      }
      paramb = Shader.TileMode.MIRROR;
    }
    for (;;)
    {
      Om();
      paramb = new LinearGradient(f5, f2, f3, f4, arrayOfInt, arrayOfFloat, paramb);
      paramb.setLocalMatrix(localMatrix);
      localPaint.setShader(paramb);
      localPaint.setAlpha(aM(this.cxt.ctr.cvw.floatValue()));
      AppMethodBeat.o(207999);
      return;
      label749:
      paramb = (h.b)localObject;
      if (paramam.cuK == h.k.cuN) {
        paramb = Shader.TileMode.REPEAT;
      }
    }
  }
  
  private void a(boolean paramBoolean, h.b paramb, h.aq paramaq)
  {
    AppMethodBeat.i(208000);
    if (paramaq.cut != null) {
      a(paramaq, paramaq.cut);
    }
    Paint localPaint;
    label54:
    float f1;
    label91:
    float f2;
    if ((paramaq.cuI != null) && (paramaq.cuI.booleanValue()))
    {
      i = 1;
      if (!paramBoolean) {
        break label246;
      }
      localPaint = this.cxt.cxR;
      if (i == 0) {
        break label291;
      }
      localObject = new h.p(50.0F, h.bd.cxp);
      if (paramaq.cuy == null) {
        break label258;
      }
      f1 = paramaq.cuy.a(this);
      if (paramaq.cuz == null) {
        break label269;
      }
      f2 = paramaq.cuz.b(this);
      label108:
      if (paramaq.cuA == null) {
        break label280;
      }
    }
    float f4;
    Matrix localMatrix;
    int j;
    label258:
    label269:
    label280:
    for (float f3 = paramaq.cuA.c(this);; f3 = ((h.p)localObject).c(this))
    {
      f4 = f1;
      Ol();
      this.cxt = d(paramaq);
      localMatrix = new Matrix();
      if (i == 0)
      {
        localMatrix.preTranslate(paramb.minX, paramb.minY);
        localMatrix.preScale(paramb.width, paramb.height);
      }
      if (paramaq.cuJ != null) {
        localMatrix.preConcat(paramaq.cuJ);
      }
      j = paramaq.aAO.size();
      if (j != 0) {
        break label391;
      }
      Om();
      if (!paramBoolean) {
        break label376;
      }
      this.cxt.cxP = false;
      AppMethodBeat.o(208000);
      return;
      i = 0;
      break;
      label246:
      localPaint = this.cxt.cxS;
      break label54;
      f1 = ((h.p)localObject).a(this);
      break label91;
      f2 = ((h.p)localObject).b(this);
      break label108;
    }
    label291:
    if (paramaq.cuy != null)
    {
      f1 = paramaq.cuy.a(this, 1.0F);
      label309:
      if (paramaq.cuz == null) {
        break label360;
      }
      f2 = paramaq.cuz.a(this, 1.0F);
      label327:
      if (paramaq.cuA == null) {
        break label368;
      }
    }
    label360:
    label368:
    for (f3 = paramaq.cuA.a(this, 1.0F);; f3 = 0.5F)
    {
      f4 = f1;
      break;
      f1 = 0.5F;
      break label309;
      f2 = 0.5F;
      break label327;
    }
    label376:
    this.cxt.cxQ = false;
    AppMethodBeat.o(208000);
    return;
    label391:
    int[] arrayOfInt = new int[j];
    float[] arrayOfFloat = new float[j];
    int i = 0;
    Iterator localIterator = paramaq.aAO.iterator();
    float f5 = -1.0F;
    if (localIterator.hasNext())
    {
      paramb = (h.ad)localIterator.next();
      if (paramb.cvr != null)
      {
        f1 = paramb.cvr.floatValue();
        label462:
        if ((i != 0) && (f1 < f5)) {
          break label570;
        }
        arrayOfFloat[i] = f1;
      }
      for (;;)
      {
        Ol();
        a(this.cxt, paramb);
        localObject = (h.f)this.cxt.ctr.cvV;
        paramb = (h.b)localObject;
        if (localObject == null) {
          paramb = h.f.cuD;
        }
        arrayOfInt[i] = i(paramb.cuC, this.cxt.ctr.cvW.floatValue());
        Om();
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
      Om();
      localPaint.setColor(arrayOfInt[(j - 1)]);
      AppMethodBeat.o(208000);
      return;
    }
    Object localObject = Shader.TileMode.CLAMP;
    paramb = (h.b)localObject;
    if (paramaq.cuK != null)
    {
      if (paramaq.cuK != h.k.cuM) {
        break label713;
      }
      paramb = Shader.TileMode.MIRROR;
    }
    for (;;)
    {
      Om();
      paramb = new RadialGradient(f4, f2, f3, arrayOfInt, arrayOfFloat, paramb);
      paramb.setLocalMatrix(localMatrix);
      localPaint.setShader(paramb);
      localPaint.setAlpha(aM(this.cxt.ctr.cvw.floatValue()));
      AppMethodBeat.o(208000);
      return;
      label713:
      paramb = (h.b)localObject;
      if (paramaq.cuK == h.k.cuN) {
        paramb = Shader.TileMode.REPEAT;
      }
    }
  }
  
  private void a(boolean paramBoolean, h.b paramb, h.u paramu)
  {
    AppMethodBeat.i(207996);
    h.an localan = this.cwY.bm(paramu.cut);
    if (localan == null)
    {
      if (paramBoolean) {}
      for (paramb = "Fill";; paramb = "Stroke")
      {
        String.format("%s reference '%s' not found", new Object[] { paramb, paramu.cut });
        if (paramu.cvg == null) {
          break;
        }
        a(this.cxt, paramBoolean, paramu.cvg);
        AppMethodBeat.o(207996);
        return;
      }
      if (paramBoolean)
      {
        this.cxt.cxP = false;
        AppMethodBeat.o(207996);
        return;
      }
      this.cxt.cxQ = false;
      AppMethodBeat.o(207996);
      return;
    }
    if ((localan instanceof h.am))
    {
      a(paramBoolean, paramb, (h.am)localan);
      AppMethodBeat.o(207996);
      return;
    }
    if ((localan instanceof h.aq))
    {
      a(paramBoolean, paramb, (h.aq)localan);
      AppMethodBeat.o(207996);
      return;
    }
    if ((localan instanceof h.ac)) {
      a(paramBoolean, (h.ac)localan);
    }
    AppMethodBeat.o(207996);
  }
  
  private static boolean a(h.ae paramae, long paramLong)
  {
    return (paramae.cvs & paramLong) != 0L;
  }
  
  private static int aM(float paramFloat)
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
  
  private static Path b(h.z paramz)
  {
    AppMethodBeat.i(208044);
    Path localPath = new Path();
    localPath.moveTo(paramz.cvq[0], paramz.cvq[1]);
    int i = 2;
    while (i < paramz.cvq.length)
    {
      localPath.lineTo(paramz.cvq[i], paramz.cvq[(i + 1)]);
      i += 2;
    }
    if ((paramz instanceof h.aa)) {
      localPath.close();
    }
    if (paramz.cwU == null) {
      paramz.cwU = e(localPath);
    }
    AppMethodBeat.o(208044);
    return localPath;
  }
  
  private void b(h.ak paramak)
  {
    AppMethodBeat.i(207936);
    a(paramak, paramak.cwU);
    AppMethodBeat.o(207936);
  }
  
  private void b(h.ak paramak, h.b paramb)
  {
    AppMethodBeat.i(208007);
    if (this.cxt.ctr.cvX == null)
    {
      AppMethodBeat.o(208007);
      return;
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      paramak = c(paramak, paramb);
      if (paramak != null) {
        this.cxr.clipPath(paramak);
      }
      AppMethodBeat.o(208007);
      return;
    }
    d(paramak, paramb);
    AppMethodBeat.o(208007);
  }
  
  private void b(h.an paraman)
  {
    Object localObject1 = null;
    float f2 = 0.0F;
    float f4 = 0.0F;
    AppMethodBeat.i(207857);
    if ((paraman instanceof h.t))
    {
      AppMethodBeat.o(207857);
      return;
    }
    Ol();
    c(paraman);
    if ((paraman instanceof h.af))
    {
      paraman = (h.af)paraman;
      a(paraman, a(paraman.cuP, paraman.cuQ, paraman.cuR, paraman.cuS), paraman.cuj, paraman.cuh);
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
          Om();
          AppMethodBeat.o(207857);
          return;
          if ((paraman instanceof h.be))
          {
            localObject2 = (h.be)paraman;
            if (((((h.be)localObject2).cuR == null) || (!((h.be)localObject2).cuR.Oa())) && ((((h.be)localObject2).cuS == null) || (!((h.be)localObject2).cuS.Oa())))
            {
              a(this.cxt, (h.al)localObject2);
              if (Os())
              {
                localObject3 = ((h.be)localObject2).cwY.bm(((h.be)localObject2).cut);
                if (localObject3 == null)
                {
                  String.format("Use reference '%s' not found", new Object[] { ((h.be)localObject2).cut });
                }
                else
                {
                  if (((h.be)localObject2).transform != null) {
                    this.cxr.concat(((h.be)localObject2).transform);
                  }
                  if (((h.be)localObject2).cuP != null)
                  {
                    f1 = ((h.be)localObject2).cuP.a(this);
                    if (((h.be)localObject2).cuQ == null) {
                      break label370;
                    }
                    f2 = ((h.be)localObject2).cuQ.b(this);
                    this.cxr.translate(f1, f2);
                    d((h.ak)localObject2);
                    bool1 = Oo();
                    a((h.aj)localObject2);
                    if (!(localObject3 instanceof h.af)) {
                      break label375;
                    }
                    paraman = (h.af)localObject3;
                    localObject1 = a(null, null, ((h.be)localObject2).cuR, ((h.be)localObject2).cuS);
                    Ol();
                    a(paraman, (h.b)localObject1, paraman.cuj, paraman.cuh);
                    Om();
                  }
                  for (;;)
                  {
                    On();
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
                      if (((h.be)localObject2).cuR != null)
                      {
                        paraman = ((h.be)localObject2).cuR;
                        if (((h.be)localObject2).cuS == null) {
                          break label478;
                        }
                      }
                      for (localObject1 = ((h.be)localObject2).cuS;; localObject1 = new h.p(100.0F, h.bd.cxp))
                      {
                        localObject1 = a(null, null, paraman, (h.p)localObject1);
                        Ol();
                        localObject3 = (h.at)localObject3;
                        if ((((h.b)localObject1).width != 0.0F) && (((h.b)localObject1).height != 0.0F)) {
                          break label496;
                        }
                        Om();
                        break;
                        paraman = new h.p(100.0F, h.bd.cxp);
                        break label397;
                      }
                      if (((h.at)localObject3).cuh != null)
                      {
                        paraman = ((h.at)localObject3).cuh;
                        a(this.cxt, (h.al)localObject3);
                        this.cxt.cuk = ((h.b)localObject1);
                        if (!this.cxt.ctr.cvO.booleanValue()) {
                          j(this.cxt.cuk.minX, this.cxt.cuk.minY, this.cxt.cuk.width, this.cxt.cuk.height);
                        }
                        if (((h.at)localObject3).cuj == null) {
                          break label672;
                        }
                        this.cxr.concat(a(this.cxt.cuk, ((h.at)localObject3).cuj, paraman));
                        this.cxt.cuj = ((h.at)localObject3).cuj;
                      }
                      for (;;)
                      {
                        boolean bool2 = Oo();
                        a((h.aj)localObject3, true);
                        if (bool2) {
                          b((h.ak)localObject3);
                        }
                        a((h.ak)localObject3);
                        break;
                        paraman = f.ctL;
                        break label510;
                        this.cxr.translate(this.cxt.cuk.minX, this.cxt.cuk.minY);
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
            a(this.cxt, paraman);
            if (Os())
            {
              if (paraman.transform != null) {
                this.cxr.concat(paraman.transform);
              }
              d(paraman);
              bool1 = Oo();
              localObject1 = Locale.getDefault().getLanguage();
              localObject2 = h.NU();
              localObject3 = paraman.aAO.iterator();
              while (((Iterator)localObject3).hasNext())
              {
                h.an localan = (h.an)((Iterator)localObject3).next();
                if ((localan instanceof h.ag))
                {
                  Object localObject4 = (h.ag)localan;
                  if (((h.ag)localObject4).Od() == null)
                  {
                    Object localObject5 = ((h.ag)localObject4).Oe();
                    if ((localObject5 == null) || ((!((Set)localObject5).isEmpty()) && (((Set)localObject5).contains(localObject1))))
                    {
                      localObject5 = ((h.ag)localObject4).Oc();
                      if (localObject5 != null)
                      {
                        if (cxx == null) {
                          Oq();
                        }
                        if ((((Set)localObject5).isEmpty()) || (!cxx.containsAll((Collection)localObject5))) {
                          break;
                        }
                      }
                      else
                      {
                        localObject5 = ((h.ag)localObject4).Of();
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
                        localObject4 = ((h.ag)localObject4).Og();
                        if (localObject4 != null)
                        {
                          if ((((Set)localObject4).isEmpty()) || (localObject2 == null)) {
                            continue;
                          }
                          localObject4 = ((Set)localObject4).iterator();
                          if (((Iterator)localObject4).hasNext())
                          {
                            ((Iterator)localObject4).next();
                            this.cxt.ctr.cvJ.intValue();
                            String.valueOf(this.cxt.ctr.cvK);
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
            new StringBuilder().append(paraman.NV()).append(" render");
            a(this.cxt, paraman);
            if (Os())
            {
              if (paraman.transform != null) {
                this.cxr.concat(paraman.transform);
              }
              d(paraman);
              bool1 = Oo();
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
      } while ((((h.o)localObject3).cuR == null) || (((h.o)localObject3).cuR.Oa()) || (((h.o)localObject3).cuS == null) || (((h.o)localObject3).cuS.Oa()) || (((h.o)localObject3).cut == null));
      if (((h.o)localObject3).cuh == null) {
        break;
      }
      paraman = ((h.o)localObject3).cuh;
      localObject2 = checkForImageDataURL(((h.o)localObject3).cut);
      if (localObject2 != null) {
        break label3306;
      }
    } while (h.NU() == null);
    for (;;)
    {
      label397:
      label478:
      label496:
      label1264:
      if (localObject1 == null)
      {
        String.format("Could not locate image '%s'", new Object[] { ((h.o)localObject3).cut });
        break;
        paraman = f.ctL;
        break label1264;
      }
      label672:
      localObject2 = new h.b(0.0F, 0.0F, ((Bitmap)localObject1).getWidth(), ((Bitmap)localObject1).getHeight());
      a(this.cxt, (h.al)localObject3);
      if ((!Os()) || (!visible())) {
        break;
      }
      if (((h.o)localObject3).transform != null) {
        this.cxr.concat(((h.o)localObject3).transform);
      }
      label1404:
      float f3;
      if (((h.o)localObject3).cuP != null)
      {
        f1 = ((h.o)localObject3).cuP.a(this);
        if (((h.o)localObject3).cuQ == null) {
          break label1653;
        }
        f2 = ((h.o)localObject3).cuQ.b(this);
        label1422:
        f3 = ((h.o)localObject3).cuR.a(this);
        f4 = ((h.o)localObject3).cuS.a(this);
        this.cxt.cuk = new h.b(f1, f2, f3, f4);
        if (!this.cxt.ctr.cvO.booleanValue()) {
          j(this.cxt.cuk.minX, this.cxt.cuk.minY, this.cxt.cuk.width, this.cxt.cuk.height);
        }
        ((h.o)localObject3).cwU = this.cxt.cuk;
        a((h.ak)localObject3);
        d((h.ak)localObject3);
        bool1 = Oo();
        Ou();
        this.cxr.save();
        this.cxr.concat(a(this.cxt.cuk, (h.b)localObject2, paraman));
        if (this.cxt.ctr.cwf != h.ae.e.cwx) {
          break label1658;
        }
      }
      label1653:
      label1658:
      for (int i = 0;; i = 2)
      {
        paraman = new Paint(i);
        this.cxr.drawBitmap((Bitmap)localObject1, 0.0F, 0.0F, paraman);
        this.cxr.restore();
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
        if (paraman.cvh == null) {
          break;
        }
        a(this.cxt, paraman);
        if ((!Os()) || (!visible()) || ((!this.cxt.cxQ) && (!this.cxt.cxP))) {
          break;
        }
        if (paraman.transform != null) {
          this.cxr.concat(paraman.transform);
        }
        localObject1 = new c(paraman.cvh).path;
        if (paraman.cwU == null) {
          paraman.cwU = e((Path)localObject1);
        }
        a(paraman);
        c(paraman);
        d(paraman);
        bool1 = Oo();
        if (this.cxt.cxP)
        {
          ((Path)localObject1).setFillType(Ot());
          a(paraman, (Path)localObject1);
        }
        if (this.cxt.cxQ) {
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
        if ((paraman.cuR == null) || (paraman.cuS == null) || (paraman.cuR.Oa()) || (paraman.cuS.Oa())) {
          break;
        }
        a(this.cxt, paraman);
        if ((!Os()) || (!visible())) {
          break;
        }
        if (paraman.transform != null) {
          this.cxr.concat(paraman.transform);
        }
        localObject1 = a(paraman);
        a(paraman);
        c(paraman);
        d(paraman);
        bool1 = Oo();
        if (this.cxt.cxP) {
          a(paraman, (Path)localObject1);
        }
        if (this.cxt.cxQ) {
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
        if ((paraman.cuA == null) || (paraman.cuA.Oa())) {
          break;
        }
        a(this.cxt, paraman);
        if ((!Os()) || (!visible())) {
          break;
        }
        if (paraman.transform != null) {
          this.cxr.concat(paraman.transform);
        }
        localObject1 = a(paraman);
        a(paraman);
        c(paraman);
        d(paraman);
        bool1 = Oo();
        if (this.cxt.cxP) {
          a(paraman, (Path)localObject1);
        }
        if (this.cxt.cxQ) {
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
        if ((paraman.cuG == null) || (paraman.cuH == null) || (paraman.cuG.Oa()) || (paraman.cuH.Oa())) {
          break;
        }
        a(this.cxt, paraman);
        if ((!Os()) || (!visible())) {
          break;
        }
        if (paraman.transform != null) {
          this.cxr.concat(paraman.transform);
        }
        localObject1 = a(paraman);
        a(paraman);
        c(paraman);
        d(paraman);
        bool1 = Oo();
        if (this.cxt.cxP) {
          a(paraman, (Path)localObject1);
        }
        if (this.cxt.cxQ) {
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
        a(this.cxt, paraman);
        if ((!Os()) || (!visible()) || (!this.cxt.cxQ)) {
          break;
        }
        if (paraman.transform != null) {
          this.cxr.concat(paraman.transform);
        }
        if (paraman.cuU == null)
        {
          f1 = 0.0F;
          label2395:
          if (paraman.cuV != null) {
            break label2547;
          }
          f2 = 0.0F;
          label2404:
          if (paraman.cuW != null) {
            break label2559;
          }
          f3 = 0.0F;
          label2414:
          if (paraman.cuX != null) {
            break label2572;
          }
        }
        for (;;)
        {
          if (paraman.cwU == null) {
            paraman.cwU = new h.b(Math.min(f1, f3), Math.min(f2, f4), Math.abs(f3 - f1), Math.abs(f4 - f2));
          }
          localObject1 = new Path();
          ((Path)localObject1).moveTo(f1, f2);
          ((Path)localObject1).lineTo(f3, f4);
          a(paraman);
          c(paraman);
          d(paraman);
          bool1 = Oo();
          d((Path)localObject1);
          a(paraman);
          if (!bool1) {
            break;
          }
          b(paraman);
          break;
          f1 = paraman.cuU.a(this);
          break label2395;
          label2547:
          f2 = paraman.cuV.b(this);
          break label2404;
          label2559:
          f3 = paraman.cuW.a(this);
          break label2414;
          label2572:
          f4 = paraman.cuX.b(this);
        }
      }
      if ((paraman instanceof h.aa))
      {
        paraman = (h.aa)paraman;
        a(this.cxt, paraman);
        if ((!Os()) || (!visible()) || ((!this.cxt.cxQ) && (!this.cxt.cxP))) {
          break;
        }
        if (paraman.transform != null) {
          this.cxr.concat(paraman.transform);
        }
        if (paraman.cvq.length < 2) {
          break;
        }
        localObject1 = b(paraman);
        a(paraman);
        c(paraman);
        d(paraman);
        bool1 = Oo();
        if (this.cxt.cxP) {
          a(paraman, (Path)localObject1);
        }
        if (this.cxt.cxQ) {
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
        a(this.cxt, paraman);
        if ((!Os()) || (!visible()) || ((!this.cxt.cxQ) && (!this.cxt.cxP))) {
          break;
        }
        if (paraman.transform != null) {
          this.cxr.concat(paraman.transform);
        }
        if (paraman.cvq.length < 2) {
          break;
        }
        localObject1 = b(paraman);
        a(paraman);
        ((Path)localObject1).setFillType(Ot());
        c(paraman);
        d(paraman);
        bool1 = Oo();
        if (this.cxt.cxP) {
          a(paraman, (Path)localObject1);
        }
        if (this.cxt.cxQ) {
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
      a(this.cxt, paraman);
      if (!Os()) {
        break;
      }
      if (paraman.transform != null) {
        this.cxr.concat(paraman.transform);
      }
      label2981:
      label3003:
      label3025:
      float f5;
      if ((paraman.x == null) || (paraman.x.size() == 0))
      {
        f1 = 0.0F;
        if ((paraman.cxe != null) && (paraman.cxe.size() != 0)) {
          break label3233;
        }
        f3 = 0.0F;
        if ((paraman.cxf != null) && (paraman.cxf.size() != 0)) {
          break label3255;
        }
        f4 = 0.0F;
        f5 = f2;
        if (paraman.cxg != null)
        {
          if (paraman.cxg.size() != 0) {
            break label3277;
          }
          f5 = f2;
        }
        label3050:
        localObject1 = Or();
        f2 = f1;
        if (localObject1 != h.ae.f.cwz)
        {
          f2 = a(paraman);
          if (localObject1 != h.ae.f.cwA) {
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
        if (paraman.cwU == null)
        {
          localObject1 = new h(f2, f3);
          a(paraman, (i)localObject1);
          paraman.cwU = new h.b(((h)localObject1).cxU.left, ((h)localObject1).cxU.top, ((h)localObject1).cxU.width(), ((h)localObject1).cxU.height());
        }
        a(paraman);
        c(paraman);
        d(paraman);
        bool1 = Oo();
        a(paraman, new e(f2 + f4, f5 + f3));
        if (!bool1) {
          break;
        }
        b(paraman);
        break;
        f1 = ((h.p)paraman.x.get(0)).a(this);
        break label2981;
        f3 = ((h.p)paraman.cxe.get(0)).b(this);
        break label3003;
        f4 = ((h.p)paraman.cxf.get(0)).a(this);
        break label3025;
        f5 = ((h.p)paraman.cxg.get(0)).b(this);
        break label3050;
      }
      label3306:
      localObject1 = localObject2;
    }
  }
  
  private Path c(h.ak paramak, h.b paramb)
  {
    int i = 0;
    AppMethodBeat.i(208009);
    paramak = paramak.cwY.bm(this.cxt.ctr.cvX);
    if (paramak == null)
    {
      String.format("ClipPath reference '%s' not found", new Object[] { this.cxt.ctr.cvX });
      AppMethodBeat.o(208009);
      return null;
    }
    Object localObject1 = (h.e)paramak;
    this.cxu.push(this.cxt);
    this.cxt = d((h.an)localObject1);
    if ((((h.e)localObject1).cuB == null) || (((h.e)localObject1).cuB.booleanValue())) {
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
    Iterator localIterator = ((h.e)localObject1).aAO.iterator();
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
    if (this.cxt.ctr.cvX != null)
    {
      if (((h.e)localObject1).cwU == null) {
        ((h.e)localObject1).cwU = e(paramb);
      }
      localObject1 = c((h.ak)localObject1, ((h.e)localObject1).cwU);
      if (localObject1 != null) {
        paramb.op((Path)localObject1, Path.Op.INTERSECT);
      }
    }
    paramb.transform(paramak);
    this.cxt = ((g)this.cxu.pop());
    AppMethodBeat.o(208009);
    return paramb;
  }
  
  private void c(h.ak paramak)
  {
    AppMethodBeat.i(207994);
    if ((this.cxt.ctr.cvt instanceof h.u)) {
      a(true, paramak.cwU, (h.u)this.cxt.ctr.cvt);
    }
    if ((this.cxt.ctr.cvx instanceof h.u)) {
      a(false, paramak.cwU, (h.u)this.cxt.ctr.cvx);
    }
    AppMethodBeat.o(207994);
  }
  
  private void c(h.an paraman)
  {
    AppMethodBeat.i(207908);
    if (!(paraman instanceof h.al))
    {
      AppMethodBeat.o(207908);
      return;
    }
    paraman = (h.al)paraman;
    if (paraman.cwV != null) {
      this.cxt.cxT = paraman.cwV.booleanValue();
    }
    AppMethodBeat.o(207908);
  }
  
  private static Bitmap checkForImageDataURL(String paramString)
  {
    AppMethodBeat.i(207960);
    if (!paramString.startsWith("data:"))
    {
      AppMethodBeat.o(207960);
      return null;
    }
    if (paramString.length() < 14)
    {
      AppMethodBeat.o(207960);
      return null;
    }
    int i = paramString.indexOf(',');
    if (i < 12)
    {
      AppMethodBeat.o(207960);
      return null;
    }
    if (!";base64".equals(paramString.substring(i - 7, i)))
    {
      AppMethodBeat.o(207960);
      return null;
    }
    try
    {
      paramString = Base64.decode(paramString.substring(i + 1), 0);
      paramString = BitmapFactory.decodeByteArray(paramString, 0, paramString.length);
      AppMethodBeat.o(207960);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(207960);
    }
    return null;
  }
  
  private g d(h.an paraman)
  {
    AppMethodBeat.i(207990);
    g localg = new g();
    a(localg, h.ae.Ob());
    paraman = a(paraman, localg);
    AppMethodBeat.o(207990);
    return paraman;
  }
  
  private void d(Path paramPath)
  {
    AppMethodBeat.i(207919);
    if (this.cxt.ctr.cwe == h.ae.i.cwN)
    {
      Matrix localMatrix1 = this.cxr.getMatrix();
      Path localPath = new Path();
      paramPath.transform(localMatrix1, localPath);
      this.cxr.setMatrix(new Matrix());
      paramPath = this.cxt.cxS.getShader();
      Matrix localMatrix2 = new Matrix();
      if (paramPath != null)
      {
        paramPath.getLocalMatrix(localMatrix2);
        Matrix localMatrix3 = new Matrix(localMatrix2);
        localMatrix3.postConcat(localMatrix1);
        paramPath.setLocalMatrix(localMatrix3);
      }
      this.cxr.drawPath(localPath, this.cxt.cxS);
      this.cxr.setMatrix(localMatrix1);
      if (paramPath != null) {
        paramPath.setLocalMatrix(localMatrix2);
      }
      AppMethodBeat.o(207919);
      return;
    }
    this.cxr.drawPath(paramPath, this.cxt.cxS);
    AppMethodBeat.o(207919);
  }
  
  private void d(h.ak paramak)
  {
    AppMethodBeat.i(208006);
    b(paramak, paramak.cwU);
    AppMethodBeat.o(208006);
  }
  
  private void d(h.ak paramak, h.b paramb)
  {
    AppMethodBeat.i(208014);
    Object localObject = paramak.cwY.bm(this.cxt.ctr.cvX);
    if (localObject == null)
    {
      String.format("ClipPath reference '%s' not found", new Object[] { this.cxt.ctr.cvX });
      AppMethodBeat.o(208014);
      return;
    }
    localObject = (h.e)localObject;
    if (((h.e)localObject).aAO.isEmpty())
    {
      this.cxr.clipRect(0, 0, 0, 0);
      AppMethodBeat.o(208014);
      return;
    }
    if ((((h.e)localObject).cuB == null) || (((h.e)localObject).cuB.booleanValue())) {}
    for (int i = 1; ((paramak instanceof h.m)) && (i == 0); i = 0)
    {
      String.format("<clipPath clipPathUnits=\"objectBoundingBox\"> is not supported when referenced from container elements (like %s)", new Object[] { paramak.NV() });
      AppMethodBeat.o(208014);
      return;
    }
    Ov();
    if (i == 0)
    {
      paramak = new Matrix();
      paramak.preTranslate(paramb.minX, paramb.minY);
      paramak.preScale(paramb.width, paramb.height);
      this.cxr.concat(paramak);
    }
    if (((h.e)localObject).transform != null) {
      this.cxr.concat(((h.e)localObject).transform);
    }
    this.cxt = d((h.an)localObject);
    d((h.ak)localObject);
    paramak = new Path();
    paramb = ((h.e)localObject).aAO.iterator();
    while (paramb.hasNext()) {
      a((h.an)paramb.next(), true, paramak, new Matrix());
    }
    this.cxr.clipPath(paramak);
    Ow();
    AppMethodBeat.o(208014);
  }
  
  private static h.b e(Path paramPath)
  {
    AppMethodBeat.i(207945);
    RectF localRectF = new RectF();
    paramPath.computeBounds(localRectF, true);
    paramPath = new h.b(localRectF.left, localRectF.top, localRectF.width(), localRectF.height());
    AppMethodBeat.o(207945);
    return paramPath;
  }
  
  private static int i(int paramInt, float paramFloat)
  {
    int i = 255;
    AppMethodBeat.i(207978);
    int j = Math.round((paramInt >> 24 & 0xFF) * paramFloat);
    if (j < 0) {
      i = 0;
    }
    for (;;)
    {
      AppMethodBeat.o(207978);
      return i << 24 | 0xFFFFFF & paramInt;
      if (j <= 255) {
        i = j;
      }
    }
  }
  
  private void j(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(207981);
    float f3 = paramFloat1 + paramFloat3;
    float f4 = paramFloat2 + paramFloat4;
    float f2 = f4;
    float f1 = f3;
    paramFloat4 = paramFloat1;
    paramFloat3 = paramFloat2;
    if (this.cxt.ctr.cvP != null)
    {
      paramFloat4 = paramFloat1 + this.cxt.ctr.cvP.cux.a(this);
      paramFloat3 = paramFloat2 + this.cxt.ctr.cvP.cuu.b(this);
      f1 = f3 - this.cxt.ctr.cvP.cuv.a(this);
      f2 = f4 - this.cxt.ctr.cvP.cuw.b(this);
    }
    this.cxr.clipRect(paramFloat4, paramFloat3, f1, f2);
    AppMethodBeat.o(207981);
  }
  
  private boolean visible()
  {
    AppMethodBeat.i(207963);
    if (this.cxt.ctr.cvU != null)
    {
      boolean bool = this.cxt.ctr.cvU.booleanValue();
      AppMethodBeat.o(207963);
      return bool;
    }
    AppMethodBeat.o(207963);
    return true;
  }
  
  final float Oj()
  {
    AppMethodBeat.i(208160);
    float f = this.cxt.cxR.getTextSize();
    AppMethodBeat.o(208160);
    return f;
  }
  
  final h.b Ok()
  {
    if (this.cxt.cuj != null) {
      return this.cxt.cuj;
    }
    return this.cxt.cuk;
  }
  
  final void a(h paramh, g paramg)
  {
    AppMethodBeat.i(208175);
    this.cwY = paramh;
    h.af localaf = paramh.cun;
    if (localaf == null)
    {
      String.format("Nothing to render. Document is empty.", new Object[0]);
      AppMethodBeat.o(208175);
      return;
    }
    Object localObject1;
    Object localObject2;
    if (paramg.NM())
    {
      localObject1 = this.cwY.bn(paramg.viewId);
      if ((localObject1 == null) || (!(localObject1 instanceof h.bf)))
      {
        String.format("View element with id \"%s\" not found.", new Object[] { paramg.viewId });
        AppMethodBeat.o(208175);
        return;
      }
      localObject1 = (h.bf)localObject1;
      if (((h.bf)localObject1).cuj == null)
      {
        String.format("View element with id \"%s\" is missing a viewBox attribute.", new Object[] { paramg.viewId });
        AppMethodBeat.o(208175);
        return;
      }
      localObject2 = ((h.bf)localObject1).cuj;
      localObject1 = ((h.bf)localObject1).cuh;
    }
    for (;;)
    {
      if (paramg.NK()) {
        paramh.b(paramg.cug);
      }
      if (paramg.NO())
      {
        this.cxy = new b.p();
        this.cxy.cts = paramh.bn(paramg.cui);
      }
      Oi();
      c(localaf);
      Ol();
      Object localObject3 = new h.b(paramg.cuk);
      if (localaf.cuR != null) {
        ((h.b)localObject3).width = localaf.cuR.a(this, ((h.b)localObject3).width);
      }
      if (localaf.cuS != null) {
        ((h.b)localObject3).height = localaf.cuS.a(this, ((h.b)localObject3).height);
      }
      a(localaf, (h.b)localObject3, (h.b)localObject2, (f)localObject1);
      Om();
      if (paramg.NK()) {
        paramh.NT();
      }
      AppMethodBeat.o(208175);
      return;
      if (paramg.NN()) {}
      for (localObject1 = paramg.cuj;; localObject1 = localaf.cuj)
      {
        if (!paramg.NL()) {
          break label348;
        }
        localObject3 = paramg.cuh;
        localObject2 = localObject1;
        localObject1 = localObject3;
        break;
      }
      label348:
      localObject3 = localaf.cuh;
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
  }
  
  final class a
    implements h.x
  {
    List<i.b> cxC;
    private float cxD;
    private float cxE;
    private i.b cxF;
    private boolean cxG;
    private boolean cxH;
    private int cxI;
    private boolean cxJ;
    
    a(h.w paramw)
    {
      AppMethodBeat.i(207891);
      this.cxC = new ArrayList();
      this.cxF = null;
      this.cxG = false;
      this.cxH = true;
      this.cxI = -1;
      if (paramw == null)
      {
        AppMethodBeat.o(207891);
        return;
      }
      paramw.a(this);
      if (this.cxJ)
      {
        this.cxF.a((i.b)this.cxC.get(this.cxI));
        this.cxC.set(this.cxI, this.cxF);
        this.cxJ = false;
      }
      if (this.cxF != null) {
        this.cxC.add(this.cxF);
      }
      AppMethodBeat.o(207891);
    }
    
    public final void B(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(207899);
      if (this.cxJ)
      {
        this.cxF.a((i.b)this.cxC.get(this.cxI));
        this.cxC.set(this.cxI, this.cxF);
        this.cxJ = false;
      }
      if (this.cxF != null) {
        this.cxC.add(this.cxF);
      }
      this.cxD = paramFloat1;
      this.cxE = paramFloat2;
      this.cxF = new i.b(i.this, paramFloat1, paramFloat2, 0.0F, 0.0F);
      this.cxI = this.cxC.size();
      AppMethodBeat.o(207899);
    }
    
    public final void D(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(207906);
      this.cxF.U(paramFloat1, paramFloat2);
      this.cxC.add(this.cxF);
      this.cxF = new i.b(i.this, paramFloat1, paramFloat2, paramFloat1 - this.cxF.x, paramFloat2 - this.cxF.y);
      this.cxJ = false;
      AppMethodBeat.o(207906);
    }
    
    public final void a(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean1, boolean paramBoolean2, float paramFloat4, float paramFloat5)
    {
      AppMethodBeat.i(207921);
      this.cxG = true;
      this.cxH = false;
      i.a(this.cxF.x, this.cxF.y, paramFloat1, paramFloat2, paramFloat3, paramBoolean1, paramBoolean2, paramFloat4, paramFloat5, this);
      this.cxH = true;
      this.cxJ = false;
      AppMethodBeat.o(207921);
    }
    
    public final void b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
    {
      AppMethodBeat.i(207911);
      if ((this.cxH) || (this.cxG))
      {
        this.cxF.U(paramFloat1, paramFloat2);
        this.cxC.add(this.cxF);
        this.cxG = false;
      }
      this.cxF = new i.b(i.this, paramFloat5, paramFloat6, paramFloat5 - paramFloat3, paramFloat6 - paramFloat4);
      this.cxJ = false;
      AppMethodBeat.o(207911);
    }
    
    public final void close()
    {
      AppMethodBeat.i(207925);
      this.cxC.add(this.cxF);
      D(this.cxD, this.cxE);
      this.cxJ = true;
      AppMethodBeat.o(207925);
    }
    
    public final void i(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      AppMethodBeat.i(207916);
      this.cxF.U(paramFloat1, paramFloat2);
      this.cxC.add(this.cxF);
      this.cxF = new i.b(i.this, paramFloat3, paramFloat4, paramFloat3 - paramFloat1, paramFloat4 - paramFloat2);
      this.cxJ = false;
      AppMethodBeat.o(207916);
    }
  }
  
  final class b
  {
    float aBW;
    float aBX;
    boolean cxL;
    float x;
    float y;
    
    b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      AppMethodBeat.i(207883);
      this.aBW = 0.0F;
      this.aBX = 0.0F;
      this.cxL = false;
      this.x = paramFloat1;
      this.y = paramFloat2;
      double d = Math.sqrt(paramFloat3 * paramFloat3 + paramFloat4 * paramFloat4);
      if (d != 0.0D)
      {
        this.aBW = ((float)(paramFloat3 / d));
        this.aBX = ((float)(paramFloat4 / d));
      }
      AppMethodBeat.o(207883);
    }
    
    final void U(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(207892);
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
        this.cxL = true;
        this.aBW = (-paramFloat2);
        this.aBX = paramFloat1;
        AppMethodBeat.o(207892);
        return;
      }
      this.aBW = (paramFloat1 + this.aBW);
      this.aBX = (paramFloat2 + this.aBX);
      AppMethodBeat.o(207892);
    }
    
    final void a(b paramb)
    {
      if ((paramb.aBW == -this.aBW) && (paramb.aBX == -this.aBX))
      {
        this.cxL = true;
        this.aBW = (-paramb.aBX);
        this.aBX = paramb.aBW;
        return;
      }
      this.aBW += paramb.aBW;
      this.aBX += paramb.aBX;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(207905);
      String str = "(" + this.x + "," + this.y + " " + this.aBW + "," + this.aBX + ")";
      AppMethodBeat.o(207905);
      return str;
    }
  }
  
  protected static final class c
    implements h.x
  {
    float cxM;
    float cxN;
    Path path;
    
    c(h.w paramw)
    {
      AppMethodBeat.i(207884);
      this.path = new Path();
      if (paramw == null)
      {
        AppMethodBeat.o(207884);
        return;
      }
      paramw.a(this);
      AppMethodBeat.o(207884);
    }
    
    public final void B(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(207890);
      this.path.moveTo(paramFloat1, paramFloat2);
      this.cxM = paramFloat1;
      this.cxN = paramFloat2;
      AppMethodBeat.o(207890);
    }
    
    public final void D(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(207898);
      this.path.lineTo(paramFloat1, paramFloat2);
      this.cxM = paramFloat1;
      this.cxN = paramFloat2;
      AppMethodBeat.o(207898);
    }
    
    public final void a(float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean1, boolean paramBoolean2, float paramFloat4, float paramFloat5)
    {
      AppMethodBeat.i(207915);
      i.a(this.cxM, this.cxN, paramFloat1, paramFloat2, paramFloat3, paramBoolean1, paramBoolean2, paramFloat4, paramFloat5, this);
      this.cxM = paramFloat4;
      this.cxN = paramFloat5;
      AppMethodBeat.o(207915);
    }
    
    public final void b(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
    {
      AppMethodBeat.i(207904);
      this.path.cubicTo(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramFloat5, paramFloat6);
      this.cxM = paramFloat5;
      this.cxN = paramFloat6;
      AppMethodBeat.o(207904);
    }
    
    public final void close()
    {
      AppMethodBeat.i(207920);
      this.path.close();
      AppMethodBeat.o(207920);
    }
    
    public final void i(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      AppMethodBeat.i(207910);
      this.path.quadTo(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
      this.cxM = paramFloat3;
      this.cxN = paramFloat4;
      AppMethodBeat.o(207910);
    }
  }
  
  final class d
    extends i.e
  {
    private Path path;
    
    d(Path paramPath, float paramFloat)
    {
      super(paramFloat, 0.0F);
      this.path = paramPath;
    }
    
    public final void bp(String paramString)
    {
      AppMethodBeat.i(207870);
      if (i.d(i.this))
      {
        if (i.e(i.this).cxP) {
          i.f(i.this).drawTextOnPath(paramString, this.path, this.x, this.y, i.e(i.this).cxR);
        }
        if (i.e(i.this).cxQ) {
          i.f(i.this).drawTextOnPath(paramString, this.path, this.x, this.y, i.e(i.this).cxS);
        }
      }
      this.x += i.e(i.this).cxR.measureText(paramString);
      AppMethodBeat.o(207870);
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
    
    public void bp(String paramString)
    {
      AppMethodBeat.i(207880);
      i.Oy();
      if (i.d(i.this))
      {
        if (i.e(i.this).cxP) {
          i.f(i.this).drawText(paramString, this.x, this.y, i.e(i.this).cxR);
        }
        if (i.e(i.this).cxQ) {
          i.f(i.this).drawText(paramString, this.x, this.y, i.e(i.this).cxS);
        }
      }
      this.x += i.e(i.this).cxR.measureText(paramString);
      AppMethodBeat.o(207880);
    }
  }
  
  final class f
    extends i.i
  {
    Path cxO;
    float x;
    float y;
    
    f(float paramFloat1, float paramFloat2, Path paramPath)
    {
      super((byte)0);
      this.x = paramFloat1;
      this.y = paramFloat2;
      this.cxO = paramPath;
    }
    
    public final boolean b(h.ay paramay)
    {
      AppMethodBeat.i(207873);
      if ((paramay instanceof h.az))
      {
        i.g("Using <textPath> elements in a clip path is not supported.", new Object[0]);
        AppMethodBeat.o(207873);
        return false;
      }
      AppMethodBeat.o(207873);
      return true;
    }
    
    public final void bp(String paramString)
    {
      AppMethodBeat.i(207882);
      if (i.d(i.this))
      {
        Path localPath = new Path();
        i.e(i.this).cxR.getTextPath(paramString, 0, paramString.length(), this.x, this.y, localPath);
        this.cxO.addPath(localPath);
      }
      this.x += i.e(i.this).cxR.measureText(paramString);
      AppMethodBeat.o(207882);
    }
  }
  
  final class g
  {
    h.ae ctr;
    h.b cuj;
    h.b cuk;
    boolean cxP;
    boolean cxQ;
    Paint cxR;
    Paint cxS;
    boolean cxT;
    
    g()
    {
      AppMethodBeat.i(207867);
      this.cxR = new Paint();
      this.cxR.setFlags(193);
      if (Build.VERSION.SDK_INT >= 14) {
        this.cxR.setHinting(0);
      }
      this.cxR.setStyle(Paint.Style.FILL);
      this.cxR.setTypeface(Typeface.DEFAULT);
      this.cxS = new Paint();
      this.cxS.setFlags(193);
      if (Build.VERSION.SDK_INT >= 14) {
        this.cxS.setHinting(0);
      }
      this.cxS.setStyle(Paint.Style.STROKE);
      this.cxS.setTypeface(Typeface.DEFAULT);
      this.ctr = h.ae.Ob();
      AppMethodBeat.o(207867);
    }
    
    g(g paramg)
    {
      AppMethodBeat.i(207874);
      this.cxP = paramg.cxP;
      this.cxQ = paramg.cxQ;
      this.cxR = new Paint(paramg.cxR);
      this.cxS = new Paint(paramg.cxS);
      if (paramg.cuk != null) {
        this.cuk = new h.b(paramg.cuk);
      }
      if (paramg.cuj != null) {
        this.cuj = new h.b(paramg.cuj);
      }
      this.cxT = paramg.cxT;
      try
      {
        this.ctr = ((h.ae)paramg.ctr.clone());
        AppMethodBeat.o(207874);
        return;
      }
      catch (CloneNotSupportedException this$1)
      {
        this.ctr = h.ae.Ob();
        AppMethodBeat.o(207874);
      }
    }
  }
  
  final class h
    extends i.i
  {
    RectF cxU;
    float x;
    float y;
    
    h(float paramFloat1, float paramFloat2)
    {
      super((byte)0);
      AppMethodBeat.i(207885);
      this.cxU = new RectF();
      this.x = paramFloat1;
      this.y = paramFloat2;
      AppMethodBeat.o(207885);
    }
    
    public final boolean b(h.ay paramay)
    {
      AppMethodBeat.i(207897);
      if ((paramay instanceof h.az))
      {
        Object localObject = (h.az)paramay;
        paramay = paramay.cwY.bm(((h.az)localObject).cut);
        if (paramay == null)
        {
          i.f("TextPath path reference '%s' not found", new Object[] { ((h.az)localObject).cut });
          AppMethodBeat.o(207897);
          return false;
        }
        localObject = (h.v)paramay;
        paramay = new i.c(((h.v)localObject).cvh).path;
        if (((h.v)localObject).transform != null) {
          paramay.transform(((h.v)localObject).transform);
        }
        localObject = new RectF();
        paramay.computeBounds((RectF)localObject, true);
        this.cxU.union((RectF)localObject);
        AppMethodBeat.o(207897);
        return false;
      }
      AppMethodBeat.o(207897);
      return true;
    }
    
    public final void bp(String paramString)
    {
      AppMethodBeat.i(207914);
      if (i.d(i.this))
      {
        Object localObject = new Rect();
        i.e(i.this).cxR.getTextBounds(paramString, 0, paramString.length(), (Rect)localObject);
        localObject = new RectF((Rect)localObject);
        ((RectF)localObject).offset(this.x, this.y);
        this.cxU.union((RectF)localObject);
      }
      this.x += i.e(i.this).cxR.measureText(paramString);
      AppMethodBeat.o(207914);
    }
  }
  
  abstract class i
  {
    private i() {}
    
    public boolean b(h.ay paramay)
    {
      return true;
    }
    
    public abstract void bp(String paramString);
  }
  
  final class j
    extends i.i
  {
    float x = 0.0F;
    
    private j()
    {
      super((byte)0);
    }
    
    public final void bp(String paramString)
    {
      AppMethodBeat.i(207894);
      this.x += i.e(i.this).cxR.measureText(paramString);
      AppMethodBeat.o(207894);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.a.a.i
 * JD-Core Version:    0.7.0.1
 */