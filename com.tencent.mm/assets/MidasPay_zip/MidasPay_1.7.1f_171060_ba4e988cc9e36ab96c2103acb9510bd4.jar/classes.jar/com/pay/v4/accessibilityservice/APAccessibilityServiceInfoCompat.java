package com.pay.v4.accessibilityservice;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;

public class APAccessibilityServiceInfoCompat
{
  public static final int CAPABILITY_CAN_FILTER_KEY_EVENTS = 8;
  public static final int CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY = 4;
  public static final int CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION = 2;
  public static final int CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT = 1;
  public static final int DEFAULT = 1;
  public static final int FEEDBACK_ALL_MASK = -1;
  public static final int FEEDBACK_BRAILLE = 32;
  public static final int FLAG_INCLUDE_NOT_IMPORTANT_VIEWS = 2;
  public static final int FLAG_REPORT_VIEW_IDS = 16;
  public static final int FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY = 8;
  public static final int FLAG_REQUEST_FILTER_KEY_EVENTS = 32;
  public static final int FLAG_REQUEST_TOUCH_EXPLORATION_MODE = 4;
  private static final AccessibilityServiceInfoVersionImpl IMPL = new AccessibilityServiceInfoStubImpl();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 18)
    {
      IMPL = new AccessibilityServiceInfoJellyBeanMr2();
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      IMPL = new AccessibilityServiceInfoIcsImpl();
      return;
    }
  }
  
  public static String capabilityToString(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 8)
      {
        switch (paramInt)
        {
        default: 
          return "UNKNOWN";
        case 2: 
          return "CAPABILITY_CAN_REQUEST_TOUCH_EXPLORATION";
        }
        return "CAPABILITY_CAN_RETRIEVE_WINDOW_CONTENT";
      }
      return "CAPABILITY_CAN_FILTER_KEY_EVENTS";
    }
    return "CAPABILITY_CAN_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
  }
  
  public static String feedbackTypeToString(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    while (paramInt > 0)
    {
      int i = 1 << Integer.numberOfTrailingZeros(paramInt);
      paramInt &= (i ^ 0xFFFFFFFF);
      if (localStringBuilder.length() > 1) {
        localStringBuilder.append(", ");
      }
      if (i != 4)
      {
        if (i != 8)
        {
          if (i != 16) {
            switch (i)
            {
            default: 
              break;
            case 2: 
              localStringBuilder.append("FEEDBACK_HAPTIC");
              break;
            case 1: 
              localStringBuilder.append("FEEDBACK_SPOKEN");
              break;
            }
          } else {
            localStringBuilder.append("FEEDBACK_GENERIC");
          }
        }
        else {
          localStringBuilder.append("FEEDBACK_VISUAL");
        }
      }
      else {
        localStringBuilder.append("FEEDBACK_AUDIBLE");
      }
    }
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public static String flagToString(int paramInt)
  {
    if (paramInt != 4)
    {
      if (paramInt != 8)
      {
        if (paramInt != 16)
        {
          if (paramInt != 32)
          {
            switch (paramInt)
            {
            default: 
              return null;
            case 2: 
              return "FLAG_INCLUDE_NOT_IMPORTANT_VIEWS";
            }
            return "DEFAULT";
          }
          return "FLAG_REQUEST_FILTER_KEY_EVENTS";
        }
        return "FLAG_REPORT_VIEW_IDS";
      }
      return "FLAG_REQUEST_ENHANCED_WEB_ACCESSIBILITY";
    }
    return "FLAG_REQUEST_TOUCH_EXPLORATION_MODE";
  }
  
  public static boolean getCanRetrieveWindowContent(AccessibilityServiceInfo paramAccessibilityServiceInfo)
  {
    return IMPL.getCanRetrieveWindowContent(paramAccessibilityServiceInfo);
  }
  
  public static int getCapabilities(AccessibilityServiceInfo paramAccessibilityServiceInfo)
  {
    return IMPL.getCapabilities(paramAccessibilityServiceInfo);
  }
  
  public static String getDescription(AccessibilityServiceInfo paramAccessibilityServiceInfo)
  {
    return IMPL.getDescription(paramAccessibilityServiceInfo);
  }
  
  public static String getId(AccessibilityServiceInfo paramAccessibilityServiceInfo)
  {
    return IMPL.getId(paramAccessibilityServiceInfo);
  }
  
  public static ResolveInfo getResolveInfo(AccessibilityServiceInfo paramAccessibilityServiceInfo)
  {
    return IMPL.getResolveInfo(paramAccessibilityServiceInfo);
  }
  
  public static String getSettingsActivityName(AccessibilityServiceInfo paramAccessibilityServiceInfo)
  {
    return IMPL.getSettingsActivityName(paramAccessibilityServiceInfo);
  }
  
  static class AccessibilityServiceInfoIcsImpl
    extends APAccessibilityServiceInfoCompat.AccessibilityServiceInfoStubImpl
  {
    public boolean getCanRetrieveWindowContent(AccessibilityServiceInfo paramAccessibilityServiceInfo)
    {
      return APAccessibilityServiceInfoCompatIcs.getCanRetrieveWindowContent(paramAccessibilityServiceInfo);
    }
    
    public int getCapabilities(AccessibilityServiceInfo paramAccessibilityServiceInfo)
    {
      if (getCanRetrieveWindowContent(paramAccessibilityServiceInfo)) {
        return 1;
      }
      return 0;
    }
    
    public String getDescription(AccessibilityServiceInfo paramAccessibilityServiceInfo)
    {
      return APAccessibilityServiceInfoCompatIcs.getDescription(paramAccessibilityServiceInfo);
    }
    
    public String getId(AccessibilityServiceInfo paramAccessibilityServiceInfo)
    {
      return APAccessibilityServiceInfoCompatIcs.getId(paramAccessibilityServiceInfo);
    }
    
    public ResolveInfo getResolveInfo(AccessibilityServiceInfo paramAccessibilityServiceInfo)
    {
      return APAccessibilityServiceInfoCompatIcs.getResolveInfo(paramAccessibilityServiceInfo);
    }
    
    public String getSettingsActivityName(AccessibilityServiceInfo paramAccessibilityServiceInfo)
    {
      return APAccessibilityServiceInfoCompatIcs.getSettingsActivityName(paramAccessibilityServiceInfo);
    }
  }
  
  static class AccessibilityServiceInfoJellyBeanMr2
    extends APAccessibilityServiceInfoCompat.AccessibilityServiceInfoIcsImpl
  {
    public int getCapabilities(AccessibilityServiceInfo paramAccessibilityServiceInfo)
    {
      return APAccessibilityServiceInfoCompatJellyBeanMr2.getCapabilities(paramAccessibilityServiceInfo);
    }
  }
  
  static class AccessibilityServiceInfoStubImpl
    implements APAccessibilityServiceInfoCompat.AccessibilityServiceInfoVersionImpl
  {
    public boolean getCanRetrieveWindowContent(AccessibilityServiceInfo paramAccessibilityServiceInfo)
    {
      return false;
    }
    
    public int getCapabilities(AccessibilityServiceInfo paramAccessibilityServiceInfo)
    {
      return 0;
    }
    
    public String getDescription(AccessibilityServiceInfo paramAccessibilityServiceInfo)
    {
      return null;
    }
    
    public String getId(AccessibilityServiceInfo paramAccessibilityServiceInfo)
    {
      return null;
    }
    
    public ResolveInfo getResolveInfo(AccessibilityServiceInfo paramAccessibilityServiceInfo)
    {
      return null;
    }
    
    public String getSettingsActivityName(AccessibilityServiceInfo paramAccessibilityServiceInfo)
    {
      return null;
    }
  }
  
  static abstract interface AccessibilityServiceInfoVersionImpl
  {
    public abstract boolean getCanRetrieveWindowContent(AccessibilityServiceInfo paramAccessibilityServiceInfo);
    
    public abstract int getCapabilities(AccessibilityServiceInfo paramAccessibilityServiceInfo);
    
    public abstract String getDescription(AccessibilityServiceInfo paramAccessibilityServiceInfo);
    
    public abstract String getId(AccessibilityServiceInfo paramAccessibilityServiceInfo);
    
    public abstract ResolveInfo getResolveInfo(AccessibilityServiceInfo paramAccessibilityServiceInfo);
    
    public abstract String getSettingsActivityName(AccessibilityServiceInfo paramAccessibilityServiceInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     com.pay.v4.accessibilityservice.APAccessibilityServiceInfoCompat
 * JD-Core Version:    0.7.0.1
 */