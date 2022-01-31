package com.hilive.mediasdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class LoadDelegate$1
  implements LoadDelegate.ILoadLibrary
{
  private boolean loadSo(String paramString)
  {
    AppMethodBeat.i(142829);
    int i = 0;
    for (;;)
    {
      if (i < 3) {
        try
        {
          System.loadLibrary(paramString);
          LogDelegate.i("MediaSdk.LoadDelegate", "loadSo " + paramString + " success!", new Object[0]);
          AppMethodBeat.o(142829);
          return true;
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          if (localUnsatisfiedLinkError.getMessage() == null) {}
          for (String str1 = "null";; str1 = str1.getMessage())
          {
            LogDelegate.e("MediaSdk.LoadDelegate", "loadSo " + paramString + " failed UnsatisfiedLinkError " + str1, new Object[0]);
            i += 1;
            break;
          }
        }
        catch (SecurityException localSecurityException)
        {
          if (localSecurityException.getMessage() == null) {}
          for (String str2 = "null";; str2 = str2.getMessage())
          {
            LogDelegate.e("MediaSdk.LoadDelegate", "loadSo " + paramString + " failed SecurityException " + str2, new Object[0]);
            break;
          }
        }
        catch (NullPointerException localNullPointerException)
        {
          if (localNullPointerException.getMessage() == null) {}
          for (String str3 = "null";; str3 = str3.getMessage())
          {
            LogDelegate.e("MediaSdk.LoadDelegate", "loadSo " + paramString + " failed NullPointerException " + str3, new Object[0]);
            break;
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            LogDelegate.printStackTrace("MediaSdk.LoadDelegate", localThrowable, "loadSo", new Object[0]);
          }
        }
      }
    }
    AppMethodBeat.o(142829);
    return false;
  }
  
  public final void loadLibrary(String paramString)
  {
    AppMethodBeat.i(142828);
    loadSo(paramString);
    AppMethodBeat.o(142828);
  }
  
  public final void loadLibrary(String paramString, ClassLoader paramClassLoader) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.hilive.mediasdk.LoadDelegate.1
 * JD-Core Version:    0.7.0.1
 */