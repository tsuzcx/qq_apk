package com.tencent.mid.local;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

class b
  extends g
{
  b(Context paramContext)
  {
    super(paramContext);
  }
  
  protected boolean a()
  {
    return (i.a(this.a, "android.permission.WRITE_EXTERNAL_STORAGE")) && (Environment.getExternalStorageState().equals("mounted"));
  }
  
  protected String b()
  {
    try
    {
      i.a("read mid from InternalStorage");
      Object localObject1 = new File(Environment.getExternalStorageDirectory(), c());
      Object localObject4 = null;
      Object localObject2;
      try
      {
        Object localObject5 = a.a((File)localObject1).iterator();
        do
        {
          localObject1 = localObject4;
          if (!((Iterator)localObject5).hasNext()) {
            break;
          }
          localObject1 = ((String)((Iterator)localObject5).next()).split(",");
        } while ((localObject1.length != 2) || (!localObject1[0].equals(e())));
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("read mid from InternalStorage:");
        ((StringBuilder)localObject5).append(localObject1[1]);
        i.a(((StringBuilder)localObject5).toString());
        localObject1 = localObject1[1];
      }
      catch (IOException localIOException)
      {
        i.a(localIOException);
        localObject2 = localObject4;
      }
      return localObject2;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.tencent.mid.local.b
 * JD-Core Version:    0.7.0.1
 */