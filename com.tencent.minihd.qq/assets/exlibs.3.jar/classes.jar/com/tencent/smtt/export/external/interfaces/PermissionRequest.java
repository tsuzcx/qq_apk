package com.tencent.smtt.export.external.interfaces;

import android.net.Uri;

public abstract interface PermissionRequest
{
  public static final String RESOURCE_AUDIO_CAPTURE = "android.webkit.resource.AUDIO_CAPTURE";
  public static final String RESOURCE_MIDI_SYSEX = "android.webkit.resource.MIDI_SYSEX";
  public static final String RESOURCE_PROTECTED_MEDIA_ID = "android.webkit.resource.PROTECTED_MEDIA_ID";
  public static final String RESOURCE_VIDEO_CAPTURE = "android.webkit.resource.VIDEO_CAPTURE";
  
  public abstract void deny();
  
  public abstract Uri getOrigin();
  
  public abstract String[] getResources();
  
  public abstract void grant(String[] paramArrayOfString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.export.external.interfaces.PermissionRequest
 * JD-Core Version:    0.7.0.1
 */