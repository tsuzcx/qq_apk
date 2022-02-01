package androidx.fragment.app;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class i
{
  final CopyOnWriteArrayList<a> bCM;
  private final FragmentManager mFragmentManager;
  
  i(FragmentManager paramFragmentManager)
  {
    AppMethodBeat.i(193772);
    this.bCM = new CopyOnWriteArrayList();
    this.mFragmentManager = paramFragmentManager;
    AppMethodBeat.o(193772);
  }
  
  final void a(Fragment paramFragment, Bundle paramBundle)
  {
    AppMethodBeat.i(193791);
    Fragment localFragment = this.mFragmentManager.getParent();
    if (localFragment != null) {
      localFragment.getParentFragmentManager().getLifecycleCallbacksDispatcher().a(paramFragment, paramBundle);
    }
    paramFragment = this.bCM.iterator();
    while (paramFragment.hasNext()) {
      paramFragment.next();
    }
    AppMethodBeat.o(193791);
  }
  
  final void a(Fragment paramFragment, View paramView, Bundle paramBundle)
  {
    AppMethodBeat.i(193815);
    Fragment localFragment = this.mFragmentManager.getParent();
    if (localFragment != null) {
      localFragment.getParentFragmentManager().getLifecycleCallbacksDispatcher().a(paramFragment, paramView, paramBundle);
    }
    paramFragment = this.bCM.iterator();
    while (paramFragment.hasNext()) {
      paramFragment.next();
    }
    AppMethodBeat.o(193815);
  }
  
  final void b(Fragment paramFragment, Bundle paramBundle)
  {
    AppMethodBeat.i(193799);
    Fragment localFragment = this.mFragmentManager.getParent();
    if (localFragment != null) {
      localFragment.getParentFragmentManager().getLifecycleCallbacksDispatcher().b(paramFragment, paramBundle);
    }
    paramFragment = this.bCM.iterator();
    while (paramFragment.hasNext()) {
      paramFragment.next();
    }
    AppMethodBeat.o(193799);
  }
  
  final void c(Fragment paramFragment, Bundle paramBundle)
  {
    AppMethodBeat.i(193808);
    Fragment localFragment = this.mFragmentManager.getParent();
    if (localFragment != null) {
      localFragment.getParentFragmentManager().getLifecycleCallbacksDispatcher().c(paramFragment, paramBundle);
    }
    paramFragment = this.bCM.iterator();
    while (paramFragment.hasNext()) {
      paramFragment.next();
    }
    AppMethodBeat.o(193808);
  }
  
  final void d(Fragment paramFragment, Bundle paramBundle)
  {
    AppMethodBeat.i(193847);
    Fragment localFragment = this.mFragmentManager.getParent();
    if (localFragment != null) {
      localFragment.getParentFragmentManager().getLifecycleCallbacksDispatcher().d(paramFragment, paramBundle);
    }
    paramFragment = this.bCM.iterator();
    while (paramFragment.hasNext()) {
      paramFragment.next();
    }
    AppMethodBeat.o(193847);
  }
  
  final void f(Fragment paramFragment)
  {
    AppMethodBeat.i(193778);
    this.mFragmentManager.getHost();
    Fragment localFragment = this.mFragmentManager.getParent();
    if (localFragment != null) {
      localFragment.getParentFragmentManager().getLifecycleCallbacksDispatcher().f(paramFragment);
    }
    paramFragment = this.bCM.iterator();
    while (paramFragment.hasNext()) {
      paramFragment.next();
    }
    AppMethodBeat.o(193778);
  }
  
  final void g(Fragment paramFragment)
  {
    AppMethodBeat.i(193785);
    this.mFragmentManager.getHost();
    Fragment localFragment = this.mFragmentManager.getParent();
    if (localFragment != null) {
      localFragment.getParentFragmentManager().getLifecycleCallbacksDispatcher().g(paramFragment);
    }
    paramFragment = this.bCM.iterator();
    while (paramFragment.hasNext()) {
      paramFragment.next();
    }
    AppMethodBeat.o(193785);
  }
  
  final void h(Fragment paramFragment)
  {
    AppMethodBeat.i(193819);
    Fragment localFragment = this.mFragmentManager.getParent();
    if (localFragment != null) {
      localFragment.getParentFragmentManager().getLifecycleCallbacksDispatcher().h(paramFragment);
    }
    paramFragment = this.bCM.iterator();
    while (paramFragment.hasNext()) {
      paramFragment.next();
    }
    AppMethodBeat.o(193819);
  }
  
  final void i(Fragment paramFragment)
  {
    AppMethodBeat.i(193829);
    Fragment localFragment = this.mFragmentManager.getParent();
    if (localFragment != null) {
      localFragment.getParentFragmentManager().getLifecycleCallbacksDispatcher().i(paramFragment);
    }
    paramFragment = this.bCM.iterator();
    while (paramFragment.hasNext()) {
      paramFragment.next();
    }
    AppMethodBeat.o(193829);
  }
  
  final void j(Fragment paramFragment)
  {
    AppMethodBeat.i(193836);
    Fragment localFragment = this.mFragmentManager.getParent();
    if (localFragment != null) {
      localFragment.getParentFragmentManager().getLifecycleCallbacksDispatcher().j(paramFragment);
    }
    paramFragment = this.bCM.iterator();
    while (paramFragment.hasNext()) {
      paramFragment.next();
    }
    AppMethodBeat.o(193836);
  }
  
  final void k(Fragment paramFragment)
  {
    AppMethodBeat.i(193843);
    Fragment localFragment = this.mFragmentManager.getParent();
    if (localFragment != null) {
      localFragment.getParentFragmentManager().getLifecycleCallbacksDispatcher().k(paramFragment);
    }
    paramFragment = this.bCM.iterator();
    while (paramFragment.hasNext()) {
      paramFragment.next();
    }
    AppMethodBeat.o(193843);
  }
  
  final void l(Fragment paramFragment)
  {
    AppMethodBeat.i(193853);
    Fragment localFragment = this.mFragmentManager.getParent();
    if (localFragment != null) {
      localFragment.getParentFragmentManager().getLifecycleCallbacksDispatcher().l(paramFragment);
    }
    paramFragment = this.bCM.iterator();
    while (paramFragment.hasNext()) {
      paramFragment.next();
    }
    AppMethodBeat.o(193853);
  }
  
  final void m(Fragment paramFragment)
  {
    AppMethodBeat.i(193860);
    Fragment localFragment = this.mFragmentManager.getParent();
    if (localFragment != null) {
      localFragment.getParentFragmentManager().getLifecycleCallbacksDispatcher().m(paramFragment);
    }
    paramFragment = this.bCM.iterator();
    while (paramFragment.hasNext()) {
      paramFragment.next();
    }
    AppMethodBeat.o(193860);
  }
  
  final void n(Fragment paramFragment)
  {
    AppMethodBeat.i(193868);
    Fragment localFragment = this.mFragmentManager.getParent();
    if (localFragment != null) {
      localFragment.getParentFragmentManager().getLifecycleCallbacksDispatcher().n(paramFragment);
    }
    paramFragment = this.bCM.iterator();
    while (paramFragment.hasNext()) {
      paramFragment.next();
    }
    AppMethodBeat.o(193868);
  }
  
  static final class a
  {
    final FragmentManager.c bCN;
    final boolean bCO;
    
    a(FragmentManager.c paramc, boolean paramBoolean)
    {
      this.bCN = paramc;
      this.bCO = paramBoolean;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.fragment.app.i
 * JD-Core Version:    0.7.0.1
 */