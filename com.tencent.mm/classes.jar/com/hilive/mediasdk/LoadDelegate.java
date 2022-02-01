package com.hilive.mediasdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class LoadDelegate
{
  private static final String TAG = "[hilive][java]";
  private static ILoadLibrary sInstance;
  private static boolean sLibraryLoaded;
  
  static
  {
    AppMethodBeat.i(73591);
    sLibraryLoaded = false;
    sInstance = new ILoadLibrary()
    {
      private boolean loadSo(String paramAnonymousString)
      {
        AppMethodBeat.i(73587);
        int i = 0;
        for (;;)
        {
          if (i < 3) {
            try
            {
              System.loadLibrary(paramAnonymousString);
              LogDelegate.i("[hilive][java]", "loadSo " + paramAnonymousString + " success!", new Object[0]);
              AppMethodBeat.o(73587);
              return true;
            }
            catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
            {
              if (localUnsatisfiedLinkError.getMessage() == null) {}
              for (String str1 = "null";; str1 = str1.getMessage())
              {
                LogDelegate.e("[hilive][java]", "loadSo " + paramAnonymousString + " failed UnsatisfiedLinkError " + str1, new Object[0]);
                i += 1;
                break;
              }
            }
            catch (SecurityException localSecurityException)
            {
              if (localSecurityException.getMessage() == null) {}
              for (String str2 = "null";; str2 = str2.getMessage())
              {
                LogDelegate.e("[hilive][java]", "loadSo " + paramAnonymousString + " failed SecurityException " + str2, new Object[0]);
                break;
              }
            }
            catch (NullPointerException localNullPointerException)
            {
              if (localNullPointerException.getMessage() == null) {}
              for (String str3 = "null";; str3 = str3.getMessage())
              {
                LogDelegate.e("[hilive][java]", "loadSo " + paramAnonymousString + " failed NullPointerException " + str3, new Object[0]);
                break;
              }
            }
            catch (Throwable localThrowable)
            {
              for (;;)
              {
                LogDelegate.printStackTrace("[hilive][java]", localThrowable, "loadSo", new Object[0]);
              }
            }
          }
        }
        AppMethodBeat.o(73587);
        return false;
      }
      
      public final void loadLibrary(String paramAnonymousString)
      {
        AppMethodBeat.i(73586);
        loadSo(paramAnonymousString);
        AppMethodBeat.o(73586);
      }
      
      public final void loadLibrary(String paramAnonymousString, ClassLoader paramAnonymousClassLoader) {}
    };
    AppMethodBeat.o(73591);
  }
  
  public static void loadLibraries()
  {
    AppMethodBeat.i(73590);
    if (sLibraryLoaded)
    {
      AppMethodBeat.o(73590);
      return;
    }
    sInstance.loadLibrary("c++_shared");
    sInstance.loadLibrary("mmavmedia");
    sInstance.loadLibrary("mmmediasdk");
    sInstance.loadLibrary("mmmediasdkjni");
    AppMethodBeat.o(73590);
  }
  
  public static void loadLibrary(String paramString)
  {
    AppMethodBeat.i(73588);
    sInstance.loadLibrary(paramString);
    AppMethodBeat.o(73588);
  }
  
  public static void loadLibrary(String paramString, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(73589);
    sInstance.loadLibrary(paramString, paramClassLoader);
    AppMethodBeat.o(73589);
  }
  
  public static void setInstance(ILoadLibrary paramILoadLibrary)
  {
    if (paramILoadLibrary != null) {
      sInstance = paramILoadLibrary;
    }
  }
  
  public static abstract interface ILoadLibrary
  {
    public abstract void loadLibrary(String paramString);
    
    public abstract void loadLibrary(String paramString, ClassLoader paramClassLoader);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.hilive.mediasdk.LoadDelegate
 * JD-Core Version:    0.7.0.1
 */