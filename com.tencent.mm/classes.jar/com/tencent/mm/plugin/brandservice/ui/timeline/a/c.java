package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.cmd.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.d;
import java.io.File;

public final class c
  implements a
{
  public static final String iia = h.getExternalStorageDirectory().getAbsolutePath() + "/skeleton.html";
  public static final String iib = h.getExternalStorageDirectory().getAbsolutePath() + "/skeleton_temp_server.html";
  
  public static d.d ayn()
  {
    int i = ae.cqS().getInt("preload_process", 4);
    if (i == 1) {
      return d.d.iih;
    }
    if (i == 2) {
      return d.d.iii;
    }
    if (i == 3) {
      return d.d.iig;
    }
    return d.d.iij;
  }
  
  public static boolean ayo()
  {
    return ae.cqS().getBoolean("preload_use", true);
  }
  
  public static boolean ayp()
  {
    if (d.IS_FLAVOR_RED) {}
    while (ae.cqS().getInt("preload_type", 1) != 3) {
      return false;
    }
    return true;
  }
  
  public static boolean ayq()
  {
    return ae.cqS().getInt("preload_type", 1) == 2;
  }
  
  public static boolean ayr()
  {
    return ae.cqS().getBoolean("preload_webview", true);
  }
  
  public static boolean ays()
  {
    return ae.cqS().getBoolean("preload_data", true);
  }
  
  public static boolean ayt()
  {
    return ae.cqS().getBoolean("preload_data_null", false);
  }
  
  public static boolean ayu()
  {
    return ae.cqS().getBoolean("preload_save_type", false);
  }
  
  public static boolean ayv()
  {
    boolean bool = false;
    if ((d.IS_FLAVOR_RED) || (d.DEBUG)) {
      bool = ae.cqS().getBoolean("preload_use_chatting", false);
    }
    return bool;
  }
  
  public static void init()
  {
    b.a(new c(), new String[] { "//mppagefastopen" });
  }
  
  public final boolean a(Context paramContext, String[] paramArrayOfString)
  {
    int j = -1;
    if ("//mppagefastopen".equals(paramArrayOfString[0]))
    {
      paramContext = ae.cqS();
      String str = paramArrayOfString[1];
      label104:
      int i;
      switch (str.hashCode())
      {
      default: 
        i = -1;
      }
      for (;;)
      {
        switch (i)
        {
        case 2: 
        default: 
          return true;
          if (!str.equals("true")) {
            break label104;
          }
          i = 0;
          continue;
          if (!str.equals("false")) {
            break label104;
          }
          i = 1;
          continue;
          if (!str.equals("server")) {
            break label104;
          }
          i = 2;
          continue;
          if (!str.equals("process")) {
            break label104;
          }
          i = 3;
          continue;
          if (!str.equals("webview")) {
            break label104;
          }
          i = 4;
          continue;
          if (!str.equals("data")) {
            break label104;
          }
          i = 5;
          continue;
          if (!str.equals("save")) {
            break label104;
          }
          i = 6;
          continue;
          if (!str.equals("chat")) {
            break label104;
          }
          i = 7;
        }
      }
      if (paramArrayOfString.length <= 2)
      {
        paramContext.edit().putBoolean("preload_use", true).commit();
        paramContext.edit().putInt("preload_type", 1).commit();
        e.cp("MicroMsg.PreloadUtil", "use tmpl webview");
        return true;
      }
      paramContext.edit().putBoolean("preload_use", true).commit();
      paramArrayOfString = paramArrayOfString[2];
      switch (paramArrayOfString.hashCode())
      {
      }
      for (;;)
      {
        switch (j)
        {
        default: 
          return true;
        case 0: 
          paramContext.edit().putInt("preload_type", 1).commit();
          e.cp("MicroMsg.PreloadUtil", "use online tmpl");
          return true;
          if (paramArrayOfString.equals("online"))
          {
            j = 0;
            continue;
            if (paramArrayOfString.equals("local"))
            {
              j = 1;
              continue;
              if (paramArrayOfString.equals("server")) {
                j = 2;
              }
            }
          }
          break;
        }
      }
      if ((d.IS_FLAVOR_RED) || (d.DEBUG))
      {
        paramContext.edit().putInt("preload_type", 3).commit();
        e.cp("MicroMsg.PreloadUtil", "use local tmpl");
        return true;
      }
      paramContext.edit().putInt("preload_type", 1).commit();
      e.cp("MicroMsg.PreloadUtil", "release can't use local tmpl, use online tmpl");
      return true;
      paramContext.edit().putInt("preload_type", 2).commit();
      e.cp("MicroMsg.PreloadUtil", "use test server tmpl");
      return true;
      paramContext.edit().putBoolean("preload_use", false).commit();
      e.cp("MicroMsg.PreloadUtil", "not use tmpl webview");
      return true;
      if (paramArrayOfString.length <= 2)
      {
        paramContext.edit().putInt("preload_process", 1).commit();
        e.cp("MicroMsg.PreloadUtil", "use process tool success");
        return true;
      }
      paramArrayOfString = paramArrayOfString[2];
      switch (paramArrayOfString.hashCode())
      {
      }
      for (;;)
      {
        switch (j)
        {
        default: 
          paramContext.edit().putInt("preload_process", 4).commit();
          e.cp("MicroMsg.PreloadUtil", "use process online success");
          return true;
          if (paramArrayOfString.equals("tool"))
          {
            j = 0;
            continue;
            if (paramArrayOfString.equals("toolmp"))
            {
              j = 1;
              continue;
              if (paramArrayOfString.equals("mm"))
              {
                j = 2;
                continue;
                if (paramArrayOfString.equals("online")) {
                  j = 3;
                }
              }
            }
          }
          break;
        }
      }
      paramContext.edit().putInt("preload_process", 1).commit();
      e.cp("MicroMsg.PreloadUtil", "use process tool success");
      return true;
      paramContext.edit().putInt("preload_process", 2).commit();
      e.cp("MicroMsg.PreloadUtil", "use process toolmp success");
      return true;
      paramContext.edit().putInt("preload_process", 3).commit();
      e.cp("MicroMsg.PreloadUtil", "use process mm success");
      return true;
      paramContext.edit().putInt("preload_process", 4).commit();
      e.cp("MicroMsg.PreloadUtil", "use process mm success");
      return true;
      if (paramArrayOfString.length <= 2)
      {
        paramContext.edit().putBoolean("preload_webview", true).commit();
        e.cp("MicroMsg.PreloadUtil", "use preload webview");
        return true;
      }
      paramArrayOfString = paramArrayOfString[2];
      switch (paramArrayOfString.hashCode())
      {
      }
      for (;;)
      {
        switch (j)
        {
        default: 
          paramContext.edit().putBoolean("preload_webview", true).commit();
          e.cp("MicroMsg.PreloadUtil", "use preload webview");
          return true;
          if (paramArrayOfString.equals("true"))
          {
            j = 0;
            continue;
            if (paramArrayOfString.equals("false")) {
              j = 1;
            }
          }
          break;
        }
      }
      paramContext.edit().putBoolean("preload_webview", true).commit();
      e.cp("MicroMsg.PreloadUtil", "use preload webview");
      return true;
      paramContext.edit().putBoolean("preload_webview", false).commit();
      e.cp("MicroMsg.PreloadUtil", "not use preload webview");
      return true;
      if (paramArrayOfString.length <= 2)
      {
        paramContext.edit().putBoolean("preload_data_null", false).commit();
        paramContext.edit().putBoolean("preload_data", true).commit();
        e.cp("MicroMsg.PreloadUtil", "use preload data");
        return true;
      }
      paramArrayOfString = paramArrayOfString[2];
      switch (paramArrayOfString.hashCode())
      {
      }
      for (;;)
      {
        switch (j)
        {
        default: 
          paramContext.edit().putBoolean("preload_data_null", false).commit();
          paramContext.edit().putBoolean("preload_data", true).commit();
          e.cp("MicroMsg.PreloadUtil", "use preload data");
          return true;
          if (paramArrayOfString.equals("true"))
          {
            j = 0;
            continue;
            if (paramArrayOfString.equals("false"))
            {
              j = 1;
              continue;
              if (paramArrayOfString.equals("null")) {
                j = 2;
              }
            }
          }
          break;
        }
      }
      paramContext.edit().putBoolean("preload_data_null", false).commit();
      paramContext.edit().putBoolean("preload_data", true).commit();
      e.cp("MicroMsg.PreloadUtil", "use preload data");
      return true;
      paramContext.edit().putBoolean("preload_data_null", false).commit();
      paramContext.edit().putBoolean("preload_data", false).commit();
      e.cp("MicroMsg.PreloadUtil", "not use preload data");
      return true;
      paramContext.edit().putBoolean("preload_data_null", true).commit();
      paramContext.edit().putBoolean("preload_data", false).commit();
      e.cp("MicroMsg.PreloadUtil", "use preload null data");
      return true;
      if (paramArrayOfString.length <= 2)
      {
        paramContext.edit().putBoolean("preload_save_type", false).commit();
        e.cp("MicroMsg.PreloadUtil", "save to data dir");
        return true;
      }
      paramArrayOfString = paramArrayOfString[2];
      switch (paramArrayOfString.hashCode())
      {
      }
      for (;;)
      {
        switch (j)
        {
        default: 
          paramContext.edit().putBoolean("preload_save_type", false).commit();
          e.cp("MicroMsg.PreloadUtil", "save to data dir");
          return true;
          if (paramArrayOfString.equals("sd")) {
            j = 0;
          }
          break;
        }
      }
      paramContext.edit().putBoolean("preload_save_type", true).commit();
      e.cp("MicroMsg.PreloadUtil", "save to sdcard dir");
      return true;
      if (paramArrayOfString.length <= 2)
      {
        paramContext.edit().putBoolean("preload_use_chatting", true).commit();
        e.cp("MicroMsg.PreloadUtil", "chat use preload");
        return true;
      }
      paramArrayOfString = paramArrayOfString[2];
      switch (paramArrayOfString.hashCode())
      {
      }
      for (;;)
      {
        switch (j)
        {
        default: 
          paramContext.edit().putBoolean("preload_use_chatting", true).commit();
          e.cp("MicroMsg.PreloadUtil", "chat use preload");
          return true;
          if (paramArrayOfString.equals("true"))
          {
            j = 0;
            continue;
            if (paramArrayOfString.equals("false")) {
              j = 1;
            }
          }
          break;
        }
      }
      paramContext.edit().putBoolean("preload_use_chatting", true).commit();
      e.cp("MicroMsg.PreloadUtil", "chat use preload");
      return true;
      paramContext.edit().putBoolean("preload_use_chatting", false).commit();
      e.cp("MicroMsg.PreloadUtil", "chat not use preload");
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.c
 * JD-Core Version:    0.7.0.1
 */