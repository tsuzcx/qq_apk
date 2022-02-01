package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.map.tools.Util;
import com.tencent.map.tools.net.NetManager;
import com.tencent.map.tools.net.NetRequest.NetRequestBuilder;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor.BitmapFormator;

public final class fj
  implements BitmapDescriptor.BitmapFormator
{
  public int a = -1;
  public String b = "";
  public String c = "";
  public String d = "";
  public float e = -1.0F;
  public String f;
  public fj.a g;
  public Bitmap[] h;
  public final Context i;
  private final String j = "marker_default.png";
  private final int k;
  private Bitmap l;
  private String m;
  private int n = 1;
  private int o;
  private int p;
  private int q;
  private mi r;
  
  public fj(Context paramContext, int paramInt)
  {
    this.i = paramContext;
    this.k = paramInt;
  }
  
  private Bitmap a(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(221774);
    Bitmap localBitmap = null;
    Object localObject;
    switch (paramInt)
    {
    default: 
      localObject = localBitmap;
    }
    for (;;)
    {
      AppMethodBeat.o(221774);
      return localObject;
      localObject = gv.a(paramContext, this.a);
      continue;
      localBitmap = gv.c(paramContext, this.b);
      localObject = localBitmap;
      if (localBitmap == null)
      {
        paramContext = gv.b(paramContext, this.b);
        localObject = paramContext;
        if (paramContext != null)
        {
          localObject = paramContext;
          if (!this.b.equals("color_texture_flat_style.png"))
          {
            localObject = gv.b(paramContext);
            continue;
            localObject = gv.a(paramContext, this.c);
            continue;
            localObject = gv.a(this.d);
            continue;
            localObject = gv.b(paramContext, "marker_default.png");
            continue;
            String str = a(this.e);
            localObject = localBitmap;
            if (str != null)
            {
              localObject = gv.b(paramContext, str);
              continue;
              localObject = this.l;
              continue;
              localObject = localBitmap;
              if (!TextUtils.isEmpty(this.f))
              {
                localObject = a(this.f);
                continue;
                localObject = localBitmap;
                if (this.g != null)
                {
                  localObject = this.g;
                  if (this.r == null) {
                    this.r = new mi(paramContext);
                  }
                  paramContext = this.r;
                  paramContext.setText(((fj.a)localObject).a);
                  paramContext.setTextSize(0, ((fj.a)localObject).b * ((fj.a)localObject).g);
                  paramContext.setTextColor(((fj.a)localObject).c);
                  paramContext.setStrokeColor(((fj.a)localObject).e);
                  paramContext.setStrokeWidth(((fj.a)localObject).d * ((fj.a)localObject).g);
                  paramContext.setTypeface(((fj.a)localObject).f);
                  localObject = gv.a(paramContext);
                  continue;
                  localObject = localBitmap;
                  if (this.h != null)
                  {
                    localObject = localBitmap;
                    if (this.h.length > this.q)
                    {
                      localObject = localBitmap;
                      if (this.q >= 0) {
                        localObject = this.h[this.q];
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  private Bitmap a(Context paramContext, fj.a parama)
  {
    AppMethodBeat.i(221779);
    if (this.r == null) {
      this.r = new mi(paramContext);
    }
    paramContext = this.r;
    paramContext.setText(parama.a);
    paramContext.setTextSize(0, parama.b * parama.g);
    paramContext.setTextColor(parama.c);
    paramContext.setStrokeColor(parama.e);
    paramContext.setStrokeWidth(parama.d * parama.g);
    paramContext.setTypeface(parama.f);
    paramContext = gv.a(paramContext);
    AppMethodBeat.o(221779);
    return paramContext;
  }
  
  private static Bitmap a(String paramString)
  {
    AppMethodBeat.i(221785);
    Object localObject = null;
    NetResponse localNetResponse = NetManager.getInstance().builder().url(paramString).doGet();
    paramString = localObject;
    if (localNetResponse != null)
    {
      paramString = localObject;
      if (!localNetResponse.available()) {}
    }
    try
    {
      paramString = BitmapFactory.decodeByteArray(localNetResponse.data, 0, localNetResponse.data.length);
      AppMethodBeat.o(221785);
      return paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        System.gc();
        try
        {
          paramString = BitmapFactory.decodeByteArray(localNetResponse.data, 0, localNetResponse.data.length);
        }
        catch (OutOfMemoryError paramString)
        {
          paramString = localObject;
        }
      }
    }
  }
  
  private BitmapDescriptor.BitmapFormator a(int paramInt)
  {
    this.a = paramInt;
    return this;
  }
  
  private BitmapDescriptor.BitmapFormator a(fj.a parama)
  {
    this.g = parama;
    return this;
  }
  
  private String a()
  {
    AppMethodBeat.i(221746);
    if (this.n <= 1)
    {
      AppMethodBeat.o(221746);
      return "";
    }
    String str = "@" + this.n + "x";
    AppMethodBeat.o(221746);
    return str;
  }
  
  private static String a(float paramFloat)
  {
    String str = null;
    if (paramFloat < 30.0F) {
      str = "RED.png";
    }
    do
    {
      return str;
      if ((paramFloat >= 30.0F) && (paramFloat < 60.0F)) {
        return "ORANGE.png";
      }
      if ((paramFloat >= 60.0F) && (paramFloat < 120.0F)) {
        return "YELLOW.png";
      }
      if ((paramFloat >= 120.0F) && (paramFloat < 180.0F)) {
        return "GREEN.png";
      }
      if ((paramFloat >= 180.0F) && (paramFloat < 210.0F)) {
        return "CYAN.png";
      }
      if ((paramFloat >= 210.0F) && (paramFloat < 240.0F)) {
        return "AZURE.png";
      }
      if ((paramFloat >= 240.0F) && (paramFloat < 270.0F)) {
        return "BLUE.png";
      }
      if ((paramFloat >= 270.0F) && (paramFloat < 300.0F)) {
        return "VIOLET.png";
      }
      if ((paramFloat >= 300.0F) && (paramFloat < 330.0F)) {
        return "MAGENTAV.png";
      }
    } while (paramFloat < 330.0F);
    return "ROSE.png";
  }
  
  private void a(Bitmap[] paramArrayOfBitmap)
  {
    AppMethodBeat.i(221843);
    this.h = paramArrayOfBitmap;
    getBitmap(this.i);
    AppMethodBeat.o(221843);
  }
  
  private BitmapDescriptor.BitmapFormator b(float paramFloat)
  {
    this.e = paramFloat;
    return this;
  }
  
  private BitmapDescriptor.BitmapFormator b(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  private String b()
  {
    AppMethodBeat.i(221759);
    Object localObject;
    if ((!TextUtils.isEmpty(this.m)) && (this.k != 10))
    {
      localObject = this.m;
      AppMethodBeat.o(221759);
      return localObject;
    }
    switch (this.k)
    {
    }
    for (;;)
    {
      localObject = this.m;
      AppMethodBeat.o(221759);
      return localObject;
      this.m = ("res_" + this.a);
      continue;
      this.m = ("asset_" + this.b);
      continue;
      this.m = ("file_" + this.c);
      continue;
      this.m = ("path_" + this.d);
      continue;
      this.m = "asset_marker_default.png";
      continue;
      localObject = a(this.e);
      if (localObject != null)
      {
        this.m = "asset_".concat(String.valueOf(localObject));
        continue;
        if ((this.l != null) && (!this.l.isRecycled()))
        {
          this.m = ("bitmap_" + gv.a(this.l));
          continue;
          if (!TextUtils.isEmpty(this.f))
          {
            this.m = ("url_" + Util.getMD5String(this.f));
            continue;
            if (this.g != null)
            {
              this.m = ("fonttext_" + Util.getMD5String(this.g.toString()));
              continue;
              if ((this.h != null) && (this.h.length > this.q) && (this.q >= 0))
              {
                localObject = this.h[this.q];
                if ((localObject != null) && (!((Bitmap)localObject).isRecycled())) {
                  this.m = ("bitmaps_" + gv.a((Bitmap)localObject));
                }
              }
            }
          }
        }
      }
    }
  }
  
  private static String b(Bitmap paramBitmap)
  {
    AppMethodBeat.i(221751);
    paramBitmap = gv.a(paramBitmap);
    AppMethodBeat.o(221751);
    return paramBitmap;
  }
  
  private BitmapDescriptor.BitmapFormator c(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  private BitmapDescriptor.BitmapFormator d(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  private BitmapDescriptor.BitmapFormator e(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public final BitmapDescriptor.BitmapFormator a(Bitmap paramBitmap)
  {
    AppMethodBeat.i(221900);
    this.l = paramBitmap;
    getBitmap(this.i);
    AppMethodBeat.o(221900);
    return this;
  }
  
  public final int activeSize()
  {
    if (this.h != null) {
      return this.h.length;
    }
    if (this.l != null) {
      return 1;
    }
    return 0;
  }
  
  public final Bitmap getBitmap(Context paramContext)
  {
    Bitmap localBitmap = null;
    AppMethodBeat.i(221888);
    if ((this.l != null) && (this.m != null) && (this.k != 10))
    {
      paramContext = this.l;
      AppMethodBeat.o(221888);
      return paramContext;
    }
    if (paramContext == null)
    {
      AppMethodBeat.o(221888);
      return null;
    }
    if (gv.b != null) {}
    for (Object localObject = gv.b.a(getBitmapId());; localObject = null)
    {
      if (localObject == null) {
        switch (this.k)
        {
        default: 
          localObject = localBitmap;
          paramContext = (Context)localObject;
          if (gv.b != null)
          {
            paramContext = (Context)localObject;
            if (localObject != null) {
              gv.b.a(getBitmapId(), (Bitmap)localObject);
            }
          }
          break;
        }
      }
      for (paramContext = (Context)localObject;; paramContext = (Context)localObject)
      {
        if (paramContext != null)
        {
          this.o = paramContext.getWidth();
          this.p = paramContext.getHeight();
          this.l = paramContext;
        }
        AppMethodBeat.o(221888);
        return paramContext;
        localObject = gv.a(paramContext, this.a);
        break;
        localBitmap = gv.c(paramContext, this.b);
        localObject = localBitmap;
        if (localBitmap != null) {
          break;
        }
        paramContext = gv.b(paramContext, this.b);
        localObject = paramContext;
        if (paramContext == null) {
          break;
        }
        localObject = paramContext;
        if (this.b.equals("color_texture_flat_style.png")) {
          break;
        }
        localObject = gv.b(paramContext);
        break;
        localObject = gv.a(paramContext, this.c);
        break;
        localObject = gv.a(this.d);
        break;
        localObject = gv.b(paramContext, "marker_default.png");
        break;
        String str = a(this.e);
        localObject = localBitmap;
        if (str == null) {
          break;
        }
        localObject = gv.b(paramContext, str);
        break;
        localObject = this.l;
        break;
        localObject = localBitmap;
        if (TextUtils.isEmpty(this.f)) {
          break;
        }
        localObject = a(this.f);
        break;
        localObject = localBitmap;
        if (this.g == null) {
          break;
        }
        localObject = this.g;
        if (this.r == null) {
          this.r = new mi(paramContext);
        }
        paramContext = this.r;
        paramContext.setText(((fj.a)localObject).a);
        paramContext.setTextSize(0, ((fj.a)localObject).b * ((fj.a)localObject).g);
        paramContext.setTextColor(((fj.a)localObject).c);
        paramContext.setStrokeColor(((fj.a)localObject).e);
        paramContext.setStrokeWidth(((fj.a)localObject).d * ((fj.a)localObject).g);
        paramContext.setTypeface(((fj.a)localObject).f);
        localObject = gv.a(paramContext);
        break;
        localObject = localBitmap;
        if (this.h == null) {
          break;
        }
        localObject = localBitmap;
        if (this.h.length <= this.q) {
          break;
        }
        localObject = localBitmap;
        if (this.q < 0) {
          break;
        }
        localObject = this.h[this.q];
        break;
      }
    }
  }
  
  public final String getBitmapId()
  {
    AppMethodBeat.i(221854);
    Object localObject1 = new StringBuilder();
    if ((TextUtils.isEmpty(this.m)) || (this.k == 10)) {}
    Object localObject2;
    switch (this.k)
    {
    default: 
      localObject2 = ((StringBuilder)localObject1).append(this.m);
      if (this.n > 1) {
        break;
      }
    }
    for (localObject1 = "";; localObject1 = "@" + this.n + "x")
    {
      localObject1 = (String)localObject1;
      AppMethodBeat.o(221854);
      return localObject1;
      this.m = ("res_" + this.a);
      break;
      this.m = ("asset_" + this.b);
      break;
      this.m = ("file_" + this.c);
      break;
      this.m = ("path_" + this.d);
      break;
      this.m = "asset_marker_default.png";
      break;
      localObject2 = a(this.e);
      if (localObject2 == null) {
        break;
      }
      this.m = "asset_".concat(String.valueOf(localObject2));
      break;
      if ((this.l == null) || (this.l.isRecycled())) {
        break;
      }
      this.m = ("bitmap_" + gv.a(this.l));
      break;
      if (TextUtils.isEmpty(this.f)) {
        break;
      }
      this.m = ("url_" + Util.getMD5String(this.f));
      break;
      if (this.g == null) {
        break;
      }
      this.m = ("fonttext_" + Util.getMD5String(this.g.toString()));
      break;
      if ((this.h == null) || (this.h.length <= this.q) || (this.q < 0)) {
        break;
      }
      localObject2 = this.h[this.q];
      if ((localObject2 == null) || (((Bitmap)localObject2).isRecycled())) {
        break;
      }
      this.m = ("bitmaps_" + gv.a((Bitmap)localObject2));
      break;
    }
  }
  
  public final int getFormateType()
  {
    return this.k;
  }
  
  public final int getHeight()
  {
    AppMethodBeat.i(221874);
    getBitmap(this.i);
    int i1 = this.p;
    AppMethodBeat.o(221874);
    return i1;
  }
  
  public final int getWidth()
  {
    AppMethodBeat.i(221864);
    getBitmap(this.i);
    int i1 = this.o;
    AppMethodBeat.o(221864);
    return i1;
  }
  
  public final int nextActiveIndex()
  {
    int i1;
    if ((this.h != null) && (this.h.length > 1))
    {
      i1 = this.q + 1;
      this.q = i1;
    }
    for (this.q = (i1 % this.h.length);; this.q = 0) {
      return this.q;
    }
  }
  
  public final void recycle()
  {
    AppMethodBeat.i(221933);
    kh.b("BD", "remove on format recycle");
    if (gv.b.b(getBitmapId()))
    {
      kb.a(this.h);
      kb.a(new Bitmap[] { this.l });
    }
    AppMethodBeat.o(221933);
  }
  
  public final void setScale(int paramInt)
  {
    this.n = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.fj
 * JD-Core Version:    0.7.0.1
 */