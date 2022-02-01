package androidx.activity;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.a.a.a;
import androidx.activity.result.c.a;
import androidx.lifecycle.ab;
import androidx.lifecycle.ad;
import androidx.lifecycle.ah.b;
import androidx.lifecycle.aj;
import androidx.lifecycle.ak;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.lifecycle.j;
import androidx.lifecycle.j.a;
import androidx.lifecycle.j.b;
import androidx.lifecycle.o;
import androidx.lifecycle.q;
import androidx.lifecycle.s;
import androidx.savedstate.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class ComponentActivity
  extends androidx.core.app.ComponentActivity
  implements c, androidx.activity.result.d, ak, q, androidx.savedstate.d
{
  private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
  private final androidx.activity.result.c mActivityResultRegistry;
  private int mContentLayoutId;
  final androidx.activity.b.a mContextAwareHelper;
  private ah.b mDefaultFactory;
  private final s mLifecycleRegistry;
  private final AtomicInteger mNextLocalRequestCode;
  private final OnBackPressedDispatcher mOnBackPressedDispatcher;
  final androidx.savedstate.c mSavedStateRegistryController;
  private aj mViewModelStore;
  
  public ComponentActivity()
  {
    AppMethodBeat.i(199188);
    this.mContextAwareHelper = new androidx.activity.b.a();
    this.mLifecycleRegistry = new s(this);
    this.mSavedStateRegistryController = androidx.savedstate.c.b(this);
    this.mOnBackPressedDispatcher = new OnBackPressedDispatcher(new ComponentActivity.1(this));
    this.mNextLocalRequestCode = new AtomicInteger();
    this.mActivityResultRegistry = new androidx.activity.result.c()
    {
      public final <I, O> void a(final int paramAnonymousInt, final androidx.activity.result.a.a<I, O> paramAnonymousa, I paramAnonymousI, androidx.core.app.b paramAnonymousb)
      {
        Object localObject = null;
        AppMethodBeat.i(199234);
        ComponentActivity localComponentActivity = ComponentActivity.this;
        final a.a locala = paramAnonymousa.a(localComponentActivity, paramAnonymousI);
        if (locala != null)
        {
          new Handler(Looper.getMainLooper()).post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(199225);
              ComponentActivity.2 local2 = ComponentActivity.2.this;
              int i = paramAnonymousInt;
              Object localObject = locala.mValue;
              String str = (String)local2.eR.get(Integer.valueOf(i));
              if (str != null)
              {
                local2.eU.remove(str);
                c.a locala = (c.a)local2.eV.get(str);
                if ((locala == null) || (locala.ff == null))
                {
                  local2.eX.remove(str);
                  local2.eW.put(str, localObject);
                  AppMethodBeat.o(199225);
                  return;
                }
                locala.ff.l(localObject);
              }
              AppMethodBeat.o(199225);
            }
          });
          AppMethodBeat.o(199234);
          return;
        }
        paramAnonymousI = paramAnonymousa.n(paramAnonymousI);
        if ((paramAnonymousI.getExtras() != null) && (paramAnonymousI.getExtras().getClassLoader() == null)) {
          paramAnonymousI.setExtrasClassLoader(localComponentActivity.getClassLoader());
        }
        if (paramAnonymousI.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE"))
        {
          paramAnonymousa = paramAnonymousI.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
          paramAnonymousI.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
        }
        while ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(paramAnonymousI.getAction()))
        {
          paramAnonymousI = paramAnonymousI.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
          paramAnonymousa = paramAnonymousI;
          if (paramAnonymousI == null) {
            paramAnonymousa = new String[0];
          }
          androidx.core.app.a.a(localComponentActivity, paramAnonymousa, paramAnonymousInt);
          AppMethodBeat.o(199234);
          return;
          paramAnonymousa = localObject;
          if (paramAnonymousb != null) {
            paramAnonymousa = localObject;
          }
        }
        if ("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(paramAnonymousI.getAction()))
        {
          paramAnonymousI = (IntentSenderRequest)paramAnonymousI.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
          try
          {
            androidx.core.app.a.a(localComponentActivity, paramAnonymousI.fh, paramAnonymousInt, paramAnonymousI.fi, paramAnonymousI.fj, paramAnonymousI.fk, 0, paramAnonymousa);
            AppMethodBeat.o(199234);
            return;
          }
          catch (IntentSender.SendIntentException paramAnonymousa)
          {
            new Handler(Looper.getMainLooper()).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(199222);
                ComponentActivity.2.this.b(paramAnonymousInt, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", paramAnonymousa));
                AppMethodBeat.o(199222);
              }
            });
            AppMethodBeat.o(199234);
            return;
          }
        }
        androidx.core.app.a.a(localComponentActivity, paramAnonymousI, paramAnonymousInt, paramAnonymousa);
        AppMethodBeat.o(199234);
      }
    };
    if (getLifecycle() == null)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
      AppMethodBeat.o(199188);
      throw localIllegalStateException;
    }
    if (Build.VERSION.SDK_INT >= 19) {
      getLifecycle().addObserver(new o()
      {
        public void onStateChanged(q paramAnonymousq, j.a paramAnonymousa)
        {
          AppMethodBeat.i(199198);
          if (paramAnonymousa == j.a.ON_STOP)
          {
            paramAnonymousq = ComponentActivity.this.getWindow();
            if (paramAnonymousq == null) {
              break label43;
            }
          }
          label43:
          for (paramAnonymousq = paramAnonymousq.peekDecorView();; paramAnonymousq = null)
          {
            if (paramAnonymousq != null) {
              paramAnonymousq.cancelPendingInputEvents();
            }
            AppMethodBeat.o(199198);
            return;
          }
        }
      });
    }
    getLifecycle().addObserver(new o()
    {
      public void onStateChanged(q paramAnonymousq, j.a paramAnonymousa)
      {
        AppMethodBeat.i(199201);
        if (paramAnonymousa == j.a.ON_DESTROY)
        {
          ComponentActivity.this.mContextAwareHelper.mContext = null;
          if (!ComponentActivity.this.isChangingConfigurations()) {
            ComponentActivity.this.getViewModelStore().clear();
          }
        }
        AppMethodBeat.o(199201);
      }
    });
    getLifecycle().addObserver(new o()
    {
      public void onStateChanged(q paramAnonymousq, j.a paramAnonymousa)
      {
        AppMethodBeat.i(199212);
        ComponentActivity.this.ensureViewModelStore();
        ComponentActivity.this.getLifecycle().removeObserver(this);
        AppMethodBeat.o(199212);
      }
    });
    if ((19 <= Build.VERSION.SDK_INT) && (Build.VERSION.SDK_INT <= 23)) {
      getLifecycle().addObserver(new ImmLeaksCleaner(this));
    }
    getSavedStateRegistry().a("android:support:activity-result", new ComponentActivity..ExternalSyntheticLambda1(this));
    addOnContextAvailableListener(new ComponentActivity..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(199188);
  }
  
  public ComponentActivity(int paramInt)
  {
    this();
    this.mContentLayoutId = paramInt;
  }
  
  private void initViewTreeOwners()
  {
    AppMethodBeat.i(199197);
    al.a(getWindow().getDecorView(), this);
    am.a(getWindow().getDecorView(), this);
    e.b(getWindow().getDecorView(), this);
    AppMethodBeat.o(199197);
  }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(199245);
    initViewTreeOwners();
    super.addContentView(paramView, paramLayoutParams);
    AppMethodBeat.o(199245);
  }
  
  public final void addOnContextAvailableListener(androidx.activity.b.b paramb)
  {
    AppMethodBeat.i(199258);
    androidx.activity.b.a locala = this.mContextAwareHelper;
    if (locala.mContext != null) {
      paramb.onContextAvailable(locala.mContext);
    }
    locala.eO.add(paramb);
    AppMethodBeat.o(199258);
  }
  
  void ensureViewModelStore()
  {
    AppMethodBeat.i(199273);
    if (this.mViewModelStore == null)
    {
      a locala = (a)getLastNonConfigurationInstance();
      if (locala != null) {
        this.mViewModelStore = locala.er;
      }
      if (this.mViewModelStore == null) {
        this.mViewModelStore = new aj();
      }
    }
    AppMethodBeat.o(199273);
  }
  
  public final androidx.activity.result.c getActivityResultRegistry()
  {
    return this.mActivityResultRegistry;
  }
  
  public ah.b getDefaultViewModelProviderFactory()
  {
    AppMethodBeat.i(199280);
    if (getApplication() == null)
    {
      localObject = new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
      AppMethodBeat.o(199280);
      throw ((Throwable)localObject);
    }
    Application localApplication;
    if (this.mDefaultFactory == null)
    {
      localApplication = getApplication();
      if (getIntent() == null) {
        break label82;
      }
    }
    label82:
    for (Object localObject = getIntent().getExtras();; localObject = null)
    {
      this.mDefaultFactory = new ad(localApplication, this, (Bundle)localObject);
      localObject = this.mDefaultFactory;
      AppMethodBeat.o(199280);
      return localObject;
    }
  }
  
  @Deprecated
  public Object getLastCustomNonConfigurationInstance()
  {
    AppMethodBeat.i(199224);
    Object localObject = (a)getLastNonConfigurationInstance();
    if (localObject != null)
    {
      localObject = ((a)localObject).eq;
      AppMethodBeat.o(199224);
      return localObject;
    }
    AppMethodBeat.o(199224);
    return null;
  }
  
  public j getLifecycle()
  {
    return this.mLifecycleRegistry;
  }
  
  public final OnBackPressedDispatcher getOnBackPressedDispatcher()
  {
    return this.mOnBackPressedDispatcher;
  }
  
  public final androidx.savedstate.b getSavedStateRegistry()
  {
    return this.mSavedStateRegistryController.ccj;
  }
  
  public aj getViewModelStore()
  {
    AppMethodBeat.i(199267);
    if (getApplication() == null)
    {
      localObject = new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
      AppMethodBeat.o(199267);
      throw ((Throwable)localObject);
    }
    ensureViewModelStore();
    Object localObject = this.mViewModelStore;
    AppMethodBeat.o(199267);
    return localObject;
  }
  
  @Deprecated
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(199330);
    if (!this.mActivityResultRegistry.b(paramInt1, paramInt2, paramIntent)) {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    AppMethodBeat.o(199330);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(199285);
    this.mOnBackPressedDispatcher.onBackPressed();
    AppMethodBeat.o(199285);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(199204);
    this.mSavedStateRegistryController.n(paramBundle);
    Object localObject = this.mContextAwareHelper;
    ((androidx.activity.b.a)localObject).mContext = this;
    localObject = ((androidx.activity.b.a)localObject).eO.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((androidx.activity.b.b)((Iterator)localObject).next()).onContextAvailable(this);
    }
    super.onCreate(paramBundle);
    ab.j(this);
    if (this.mContentLayoutId != 0) {
      setContentView(this.mContentLayoutId);
    }
    AppMethodBeat.o(199204);
  }
  
  @Deprecated
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(199336);
    if ((!this.mActivityResultRegistry.b(paramInt, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", paramArrayOfString).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", paramArrayOfInt))) && (Build.VERSION.SDK_INT >= 23)) {
      super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
    AppMethodBeat.o(199336);
  }
  
  @Deprecated
  public Object onRetainCustomNonConfigurationInstance()
  {
    return null;
  }
  
  public final Object onRetainNonConfigurationInstance()
  {
    AppMethodBeat.i(199215);
    Object localObject3 = onRetainCustomNonConfigurationInstance();
    Object localObject2 = this.mViewModelStore;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      a locala = (a)getLastNonConfigurationInstance();
      localObject1 = localObject2;
      if (locala != null) {
        localObject1 = locala.er;
      }
    }
    if ((localObject1 == null) && (localObject3 == null))
    {
      AppMethodBeat.o(199215);
      return null;
    }
    localObject2 = new a();
    ((a)localObject2).eq = localObject3;
    ((a)localObject2).er = ((aj)localObject1);
    AppMethodBeat.o(199215);
    return localObject2;
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(199208);
    j localj = getLifecycle();
    if ((localj instanceof s)) {
      ((s)localj).f(j.b.bHi);
    }
    super.onSaveInstanceState(paramBundle);
    this.mSavedStateRegistryController.m(paramBundle);
    AppMethodBeat.o(199208);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public Context peekAvailableContext()
  {
    return this.mContextAwareHelper.mContext;
  }
  
  public final <I, O> androidx.activity.result.b<I> registerForActivityResult(androidx.activity.result.a.a<I, O> parama, androidx.activity.result.a<O> parama1)
  {
    AppMethodBeat.i(199349);
    parama = registerForActivityResult(parama, this.mActivityResultRegistry, parama1);
    AppMethodBeat.o(199349);
    return parama;
  }
  
  public final <I, O> androidx.activity.result.b<I> registerForActivityResult(androidx.activity.result.a.a<I, O> parama, androidx.activity.result.c paramc, androidx.activity.result.a<O> parama1)
  {
    AppMethodBeat.i(199341);
    parama = paramc.a("activity_rq#" + this.mNextLocalRequestCode.getAndIncrement(), this, parama, parama1);
    AppMethodBeat.o(199341);
    return parama;
  }
  
  public final void removeOnContextAvailableListener(androidx.activity.b.b paramb)
  {
    AppMethodBeat.i(199261);
    this.mContextAwareHelper.eO.remove(paramb);
    AppMethodBeat.o(199261);
  }
  
  /* Error */
  public void reportFullyDrawn()
  {
    // Byte code:
    //   0: ldc_w 526
    //   3: invokestatic 62	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 531	androidx/k/a:isEnabled	()Z
    //   9: ifeq +9 -> 18
    //   12: ldc_w 533
    //   15: invokestatic 536	androidx/k/a:ax	(Ljava/lang/String;)V
    //   18: getstatic 121	android/os/Build$VERSION:SDK_INT	I
    //   21: bipush 19
    //   23: if_icmple +17 -> 40
    //   26: aload_0
    //   27: invokespecial 538	androidx/core/app/ComponentActivity:reportFullyDrawn	()V
    //   30: invokestatic 541	androidx/k/a:DS	()V
    //   33: ldc_w 526
    //   36: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: return
    //   40: getstatic 121	android/os/Build$VERSION:SDK_INT	I
    //   43: bipush 19
    //   45: if_icmpne -15 -> 30
    //   48: aload_0
    //   49: ldc_w 543
    //   52: invokestatic 549	androidx/core/content/a:checkSelfPermission	(Landroid/content/Context;Ljava/lang/String;)I
    //   55: ifne -25 -> 30
    //   58: aload_0
    //   59: invokespecial 538	androidx/core/app/ComponentActivity:reportFullyDrawn	()V
    //   62: goto -32 -> 30
    //   65: astore_1
    //   66: invokestatic 541	androidx/k/a:DS	()V
    //   69: ldc_w 526
    //   72: invokestatic 116	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: aload_1
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	ComponentActivity
    //   65	11	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	18	65	finally
    //   18	30	65	finally
    //   40	62	65	finally
  }
  
  public void setContentView(int paramInt)
  {
    AppMethodBeat.i(199229);
    initViewTreeOwners();
    super.setContentView(paramInt);
    AppMethodBeat.o(199229);
  }
  
  public void setContentView(View paramView)
  {
    AppMethodBeat.i(199235);
    initViewTreeOwners();
    super.setContentView(paramView);
    AppMethodBeat.o(199235);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(199239);
    initViewTreeOwners();
    super.setContentView(paramView, paramLayoutParams);
    AppMethodBeat.o(199239);
  }
  
  @Deprecated
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(199299);
    super.startActivityForResult(paramIntent, paramInt);
    AppMethodBeat.o(199299);
  }
  
  @Deprecated
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(199309);
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
    AppMethodBeat.o(199309);
  }
  
  @Deprecated
  public void startIntentSenderForResult(IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(199315);
    super.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(199315);
  }
  
  @Deprecated
  public void startIntentSenderForResult(IntentSender paramIntentSender, int paramInt1, Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
  {
    AppMethodBeat.i(199323);
    super.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
    AppMethodBeat.o(199323);
  }
  
  static final class a
  {
    Object eq;
    aj er;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.activity.ComponentActivity
 * JD-Core Version:    0.7.0.1
 */