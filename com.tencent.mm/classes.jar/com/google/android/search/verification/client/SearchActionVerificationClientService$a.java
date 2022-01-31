package com.google.android.search.verification.client;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.search.verification.a.a.a;

final class SearchActionVerificationClientService$a
  implements ServiceConnection
{
  SearchActionVerificationClientService$a(SearchActionVerificationClientService paramSearchActionVerificationClientService) {}
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    SearchActionVerificationClientService.a(this.aUy, a.a.f(paramIBinder));
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    SearchActionVerificationClientService.a(this.aUy, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.search.verification.client.SearchActionVerificationClientService.a
 * JD-Core Version:    0.7.0.1
 */