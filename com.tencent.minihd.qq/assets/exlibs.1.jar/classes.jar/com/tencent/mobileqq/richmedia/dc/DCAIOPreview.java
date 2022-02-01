package com.tencent.mobileqq.richmedia.dc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import jqn;
import jqo;

public class DCAIOPreview
  extends DataCollector
  implements ReportEvent
{
  public static final String a = "sender";
  public static final String b = "receiver";
  public static final String c = "large";
  public static final String d = "original";
  public static final String e = "long";
  public static final String f = "extra";
  public static final String g = "large";
  public static final String h = "mid";
  public static final String i = "small";
  public static final String j = "dynamic";
  public static final String k = "static";
  private String C;
  private SparseArray a = new SparseArray();
  private Handler b = new jqn(this, a());
  
  public DCAIOPreview(Context paramContext)
  {
    super(paramContext);
    int m = ((Activity)paramContext).getIntent().getIntExtra("forward_source_uin_type", -1);
    if (m == 0)
    {
      this.C = "c2c";
      return;
    }
    if (m == 1)
    {
      this.C = "grp";
      return;
    }
    if (m == 3000)
    {
      this.C = "dis";
      return;
    }
    this.C = "other";
  }
  
  private jqo a(int paramInt)
  {
    jqo localjqo2 = (jqo)this.a.get(paramInt);
    jqo localjqo1 = localjqo2;
    if (localjqo2 == null)
    {
      localjqo1 = new jqo(paramInt, this.C);
      this.a.put(paramInt, localjqo1);
    }
    return localjqo1;
  }
  
  public void a()
  {
    this.b.obtainMessage().sendToTarget();
  }
  
  public void a(int paramInt)
  {
    jqo.a(a(paramInt));
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2)
  {
    jqo localjqo = (jqo)this.a.get(paramInt);
    String str;
    if (localjqo != null)
    {
      paramInt = PhotoUtils.a(paramLong1, paramLong2);
      str = null;
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      jqo.b(localjqo, str);
      return;
      str = "long";
      continue;
      str = "small";
      continue;
      str = "mid";
      continue;
      str = "large";
      continue;
      str = "extra";
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    jqo localjqo = (jqo)this.a.get(paramInt);
    if (localjqo != null) {
      jqo.d(localjqo, paramString);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    jqo localjqo = (jqo)this.a.get(paramInt);
    if (localjqo != null) {
      jqo.a(localjqo, paramBoolean);
    }
  }
  
  public void b(int paramInt)
  {
    jqo localjqo = (jqo)this.a.get(paramInt);
    if ((localjqo != null) && (jqo.a(localjqo))) {
      jqo.b(localjqo);
    }
  }
  
  public void b(int paramInt, boolean paramBoolean)
  {
    jqo localjqo = (jqo)this.a.get(paramInt);
    if (localjqo != null) {
      if (!paramBoolean) {
        break label33;
      }
    }
    label33:
    for (String str = "dynamic";; str = "static")
    {
      jqo.c(localjqo, str);
      return;
    }
  }
  
  public void c(int paramInt)
  {
    jqo localjqo = (jqo)this.a.get(paramInt);
    if ((localjqo != null) && (jqo.a(localjqo))) {
      jqo.c(localjqo);
    }
  }
  
  public void d(int paramInt)
  {
    jqo localjqo = (jqo)this.a.get(paramInt);
    if ((localjqo != null) && (jqo.a(localjqo))) {
      jqo.a(localjqo, "sender");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DCAIOPreview
 * JD-Core Version:    0.7.0.1
 */