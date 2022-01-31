package com.google.android.search.verification.client;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.search.verification.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SearchActionVerificationClientService$a
  implements ServiceConnection
{
  SearchActionVerificationClientService$a(SearchActionVerificationClientService paramSearchActionVerificationClientService) {}
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    AppMethodBeat.i(94131);
    SearchActionVerificationClientService.a(this.bdW);
    SearchActionVerificationClientService.a(this.bdW, a.a.g(paramIBinder));
    AppMethodBeat.o(94131);
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    AppMethodBeat.i(94132);
    SearchActionVerificationClientService.a(this.bdW, null);
    SearchActionVerificationClientService.a(this.bdW);
    AppMethodBeat.o(94132);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.search.verification.client.SearchActionVerificationClientService.a
 * JD-Core Version:    0.7.0.1
 */