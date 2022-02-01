package android.support.v4.content;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.Keep;
import java.io.File;

@Deprecated
@Keep
public class FileProvider
  extends androidx.core.content.FileProvider
{
  public static Uri getUriForFile(Context paramContext, String paramString, File paramFile)
  {
    return androidx.core.content.FileProvider.getUriForFile(paramContext, paramString, paramFile);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.content.FileProvider
 * JD-Core Version:    0.7.0.1
 */