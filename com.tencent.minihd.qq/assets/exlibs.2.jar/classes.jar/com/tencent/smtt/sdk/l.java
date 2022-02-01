package com.tencent.smtt.sdk;

import android.net.Uri;
import android.os.Build.VERSION;
import android.webkit.WebResourceRequest;

public class l
  extends ServiceWorkerController
{
  public com.tencent.smtt.export.external.interfaces.ServiceWorkerWebSettings getServiceWorkerWebSettings()
  {
    if (Build.VERSION.SDK_INT < 24) {
      return null;
    }
    new com.tencent.smtt.export.external.interfaces.ServiceWorkerWebSettings()
    {
      public boolean getAllowContentAccess()
      {
        if (Build.VERSION.SDK_INT >= 24) {
          return this.a.getAllowContentAccess();
        }
        return false;
      }
      
      public boolean getAllowFileAccess()
      {
        if (Build.VERSION.SDK_INT >= 24) {
          return this.a.getAllowFileAccess();
        }
        return false;
      }
      
      public boolean getBlockNetworkLoads()
      {
        if (Build.VERSION.SDK_INT >= 24) {
          return this.a.getBlockNetworkLoads();
        }
        return false;
      }
      
      public int getCacheMode()
      {
        if (Build.VERSION.SDK_INT >= 24) {
          return this.a.getCacheMode();
        }
        return -1;
      }
      
      public void setAllowContentAccess(boolean paramAnonymousBoolean)
      {
        if (Build.VERSION.SDK_INT >= 24) {
          this.a.setAllowContentAccess(paramAnonymousBoolean);
        }
      }
      
      public void setAllowFileAccess(boolean paramAnonymousBoolean)
      {
        if (Build.VERSION.SDK_INT >= 24) {
          this.a.setAllowContentAccess(paramAnonymousBoolean);
        }
      }
      
      public void setBlockNetworkLoads(boolean paramAnonymousBoolean)
      {
        if (Build.VERSION.SDK_INT >= 24) {
          this.a.setBlockNetworkLoads(paramAnonymousBoolean);
        }
      }
      
      public void setCacheMode(int paramAnonymousInt)
      {
        if (Build.VERSION.SDK_INT >= 24) {
          this.a.setCacheMode(paramAnonymousInt);
        }
      }
    };
  }
  
  public void setServiceWorkerClient(final com.tencent.smtt.export.external.interfaces.ServiceWorkerClient paramServiceWorkerClient)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      android.webkit.ServiceWorkerController.getInstance().setServiceWorkerClient(new android.webkit.ServiceWorkerClient()
      {
        public android.webkit.WebResourceResponse shouldInterceptRequest(WebResourceRequest paramAnonymousWebResourceRequest)
        {
          paramAnonymousWebResourceRequest = new SystemWebViewClient.e(paramAnonymousWebResourceRequest.getUrl().toString(), paramAnonymousWebResourceRequest.isForMainFrame(), paramAnonymousWebResourceRequest.isRedirect(), paramAnonymousWebResourceRequest.hasGesture(), paramAnonymousWebResourceRequest.getMethod(), paramAnonymousWebResourceRequest.getRequestHeaders());
          paramAnonymousWebResourceRequest = paramServiceWorkerClient.shouldInterceptRequest(paramAnonymousWebResourceRequest);
          if (paramAnonymousWebResourceRequest == null) {
            paramAnonymousWebResourceRequest = null;
          }
          android.webkit.WebResourceResponse localWebResourceResponse;
          int i;
          String str;
          do
          {
            do
            {
              return paramAnonymousWebResourceRequest;
              localWebResourceResponse = new android.webkit.WebResourceResponse(paramAnonymousWebResourceRequest.getMimeType(), paramAnonymousWebResourceRequest.getEncoding(), paramAnonymousWebResourceRequest.getData());
              localWebResourceResponse.setResponseHeaders(paramAnonymousWebResourceRequest.getResponseHeaders());
              i = paramAnonymousWebResourceRequest.getStatusCode();
              str = paramAnonymousWebResourceRequest.getReasonPhrase();
              if (i != localWebResourceResponse.getStatusCode()) {
                break;
              }
              paramAnonymousWebResourceRequest = localWebResourceResponse;
            } while (str == null);
            paramAnonymousWebResourceRequest = localWebResourceResponse;
          } while (str.equals(localWebResourceResponse.getReasonPhrase()));
          localWebResourceResponse.setStatusCodeAndReasonPhrase(i, str);
          return localWebResourceResponse;
        }
      });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.l
 * JD-Core Version:    0.7.0.1
 */