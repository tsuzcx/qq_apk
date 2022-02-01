package com.google.android.gms.common.util;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class SharedPreferencesUtils
{
  @Deprecated
  public static void publishWorldReadableSharedPreferences(Context paramContext, SharedPreferences.Editor paramEditor, String paramString)
  {
    AppMethodBeat.i(5288);
    paramContext = new File(paramContext.getApplicationInfo().dataDir, "shared_prefs");
    File localFile = paramContext.getParentFile();
    if (localFile != null) {
      localFile.setExecutable(true, false);
    }
    paramContext.setExecutable(true, false);
    paramEditor.commit();
    new File(paramContext, String.valueOf(paramString).concat(".xml")).setReadable(true, false);
    AppMethodBeat.o(5288);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.util.SharedPreferencesUtils
 * JD-Core Version:    0.7.0.1
 */