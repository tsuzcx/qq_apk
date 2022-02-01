package com.tencent.mm.plugin.appbrand.step;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.keylogger.base.a;
import com.tencent.mm.plugin.appbrand.keylogger.base.d;
import com.tencent.mm.plugin.appbrand.keylogger.base.e;
import com.tencent.mm.plugin.appbrand.keylogger.base.f;
import com.tencent.mm.plugin.appbrand.keylogger.base.i;
import java.util.ArrayList;
import java.util.List;

public final class KSProcessWeAppLaunch
{
  public static final String NAME = "WeAppLaunch";
  public static final List<d> sStepNodes;
  public static a stepCheckBan;
  public static a stepColdLaunchFailed;
  public static a stepContainerUILaunch;
  public static a stepCreatePageUI;
  public static a stepCreateWebViewInstance;
  public static a stepGenerateFuncReadyRespond;
  public static a stepGetContact;
  public static a stepGetContact_CGI;
  public static a stepGetContact_DB;
  public static a stepInitRuntimeGroup;
  public static a stepInjectJSAppService;
  public static a stepInjectJSPageScript;
  public static a stepInjectJSWAMainContext;
  public static a stepInjectJSWASubContext;
  public static a stepInjectJSWAWebview;
  public static a stepInjectWAPageFrameHtml;
  public static a stepInstallLibraries;
  public static a stepLaunch;
  public static a stepPageInit;
  public static a stepPageInitUIGroup;
  public static a stepPageReady;
  public static a stepPrepareMainProcess;
  public static a stepPrepareResourceGroup;
  public static a stepPrepareResourceProcess;
  public static a stepPrepareResourceSubProcessCodePkg_DB;
  public static a stepPrepareResourceSubProcessCodePkg_Download;
  public static a stepPrepareResourceSubProcessLaunchWxaApp_CGI;
  public static a stepPrepareResourceSubProcessLaunchWxaApp_DB;
  public static a stepPrepareResourceTimeout;
  public static a stepPrepareResourceWaitForResult;
  public static a stepPrepareRuntime;
  public static a stepPrepareWebView;
  public static a stepServiceInit;
  public static a stepSetupConfigsPostResourcePrepared;
  public static a stepVdSync;
  public static a stepWaitForAppServiceAheadPreloadDone;
  public static a stepWaitForAppServicePreloadDone;
  public static a stepWaitForCommLibConfirm;
  public static a stepWaitForWebViewAheadPreloadDone;
  public static a stepWaitForWebViewPreloadDone;
  
  static
  {
    AppMethodBeat.i(194533);
    ArrayList localArrayList = new ArrayList();
    sStepNodes = localArrayList;
    localArrayList.add(new i("WeAppLaunch"));
    stepLaunch = new e("WeAppLaunch", "Launch", true, false, "", 2, 0, 1);
    sStepNodes.add((d)stepLaunch);
    stepGetContact = new e("WeAppLaunch", "GetContact", true, false, "", 3, 1, 2);
    sStepNodes.add((d)stepGetContact);
    stepGetContact_DB = new e("WeAppLaunch", "GetContact_DB", true, true, "读取contact信息", 1, 2, -2147483648);
    sStepNodes.add((d)stepGetContact_DB);
    stepGetContact_CGI = new e("WeAppLaunch", "GetContact_CGI", false, true, "拉contact cgi", 1, 2, -2147483648);
    sStepNodes.add((d)stepGetContact_CGI);
    stepCheckBan = new e("WeAppLaunch", "CheckBan", true, false, "封禁逻辑", 1, 1, -2147483648);
    sStepNodes.add((d)stepCheckBan);
    stepContainerUILaunch = new e("WeAppLaunch", "ContainerUILaunch", true, true, "拉起容器UI界面", 1, 1, -2147483648);
    sStepNodes.add((d)stepContainerUILaunch);
    stepPrepareRuntime = new e("WeAppLaunch", "PrepareRuntime", true, false, "", 3, 1, 3);
    sStepNodes.add((d)stepPrepareRuntime);
    stepPrepareMainProcess = new e("WeAppLaunch", "PrepareMainProcess", true, true, "准备主进程通讯", 1, 3, -2147483648);
    sStepNodes.add((d)stepPrepareMainProcess);
    stepInstallLibraries = new e("WeAppLaunch", "InstallLibraries", true, true, "动态安装小程序环境所需二进制库", 1, 3, -2147483648);
    sStepNodes.add((d)stepInstallLibraries);
    stepPrepareWebView = new e("WeAppLaunch", "PrepareWebView", true, true, "准备WebView (View)", 1, 3, -2147483648);
    sStepNodes.add((d)stepPrepareWebView);
    stepPrepareResourceGroup = new e("WeAppLaunch", "PrepareResourceGroup", true, false, "Launch CGI及准备小程序包", 3, 3, 4);
    sStepNodes.add((d)stepPrepareResourceGroup);
    stepPrepareResourceProcess = new e("WeAppLaunch", "PrepareResourceProcess", true, false, "资源准备逻辑过程", 1, 4, -2147483648);
    sStepNodes.add((d)stepPrepareResourceProcess);
    stepPrepareResourceWaitForResult = new e("WeAppLaunch", "PrepareResourceWaitForResult", true, false, "runtime监听过程结果", 1, 4, -2147483648);
    sStepNodes.add((d)stepPrepareResourceWaitForResult);
    stepPrepareResourceTimeout = new e("WeAppLaunch", "PrepareResourceTimeout", true, true, "资源准备10s超时事件", 1, 4, -2147483648);
    sStepNodes.add((d)stepPrepareResourceTimeout);
    stepPrepareResourceSubProcessLaunchWxaApp_DB = new e("WeAppLaunch", "PrepareResourceSubProcessLaunchWxaApp_DB", true, true, "使用本地缓存的launch数据打开", 1, 4, -2147483648);
    sStepNodes.add((d)stepPrepareResourceSubProcessLaunchWxaApp_DB);
    stepPrepareResourceSubProcessLaunchWxaApp_CGI = new e("WeAppLaunch", "PrepareResourceSubProcessLaunchWxaApp_CGI", true, true, "同步请求launch数据打开", 1, 4, -2147483648);
    sStepNodes.add((d)stepPrepareResourceSubProcessLaunchWxaApp_CGI);
    stepPrepareResourceSubProcessCodePkg_DB = new e("WeAppLaunch", "PrepareResourceSubProcessCodePkg_DB", true, true, "使用本地缓存好的代码包打开", 1, 4, -2147483648);
    sStepNodes.add((d)stepPrepareResourceSubProcessCodePkg_DB);
    stepPrepareResourceSubProcessCodePkg_Download = new e("WeAppLaunch", "PrepareResourceSubProcessCodePkg_Download", true, true, "同步下载代码包打开", 1, 4, -2147483648);
    sStepNodes.add((d)stepPrepareResourceSubProcessCodePkg_Download);
    stepSetupConfigsPostResourcePrepared = new e("WeAppLaunch", "SetupConfigsPostResourcePrepared", true, false, "资源准备完的配置解析", 1, 3, -2147483648);
    sStepNodes.add((d)stepSetupConfigsPostResourcePrepared);
    stepWaitForCommLibConfirm = new e("WeAppLaunch", "WaitForCommLibConfirm", true, true, "确定基础库版本", 1, 3, -2147483648);
    sStepNodes.add((d)stepWaitForCommLibConfirm);
    stepWaitForWebViewPreloadDone = new e("WeAppLaunch", "WaitForWebViewPreloadDone", true, true, "等待启动前预加载webview完成 (View)", 1, 3, -2147483648);
    sStepNodes.add((d)stepWaitForWebViewPreloadDone);
    stepWaitForWebViewAheadPreloadDone = new e("WeAppLaunch", "WaitForWebViewAheadPreloadDone", true, true, "等待运行时预加载webview完成 (View)", 1, 3, -2147483648);
    sStepNodes.add((d)stepWaitForWebViewAheadPreloadDone);
    stepWaitForAppServicePreloadDone = new e("WeAppLaunch", "WaitForAppServicePreloadDone", true, true, "等待启动前预加载appservice完成 (Service)", 1, 3, -2147483648);
    sStepNodes.add((d)stepWaitForAppServicePreloadDone);
    stepWaitForAppServiceAheadPreloadDone = new e("WeAppLaunch", "WaitForAppServiceAheadPreloadDone", true, true, "等待运行时预加载appservice完成 (Service)", 1, 3, -2147483648);
    sStepNodes.add((d)stepWaitForAppServiceAheadPreloadDone);
    stepInitRuntimeGroup = new e("WeAppLaunch", "InitRuntimeGroup", true, false, "", 3, 1, 4);
    sStepNodes.add((d)stepInitRuntimeGroup);
    stepServiceInit = new e("WeAppLaunch", "ServiceInit", true, false, "", 2, 4, 5);
    sStepNodes.add((d)stepServiceInit);
    stepInjectJSWAMainContext = new e("WeAppLaunch", "InjectJSWAMainContext", true, true, "注入WAMainContext.js (Service)", 1, 5, -2147483648);
    sStepNodes.add((d)stepInjectJSWAMainContext);
    stepInjectJSWASubContext = new e("WeAppLaunch", "InjectJSWASubContext", true, true, "注入WASubContext.js (Service)", 1, 5, -2147483648);
    sStepNodes.add((d)stepInjectJSWASubContext);
    stepInjectJSAppService = new e("WeAppLaunch", "InjectJSAppService", true, true, "注入appservice.js (Service)", 1, 5, -2147483648);
    sStepNodes.add((d)stepInjectJSAppService);
    stepPageInit = new e("WeAppLaunch", "PageInit", true, false, "", 2, 4, 6);
    sStepNodes.add((d)stepPageInit);
    stepPageInitUIGroup = new e("WeAppLaunch", "PageInitUIGroup", true, false, "", 3, 6, 7);
    sStepNodes.add((d)stepPageInitUIGroup);
    stepCreatePageUI = new e("WeAppLaunch", "CreatePageUI", true, false, "首页界面创建", 1, 7, -2147483648);
    sStepNodes.add((d)stepCreatePageUI);
    stepCreateWebViewInstance = new e("WeAppLaunch", "CreateWebViewInstance", true, true, "", 1, 7, -2147483648);
    sStepNodes.add((d)stepCreateWebViewInstance);
    stepInjectWAPageFrameHtml = new e("WeAppLaunch", "InjectWAPageFrameHtml", true, true, "注入WAPageframe.html (View)", 1, 6, -2147483648);
    sStepNodes.add((d)stepInjectWAPageFrameHtml);
    stepInjectJSWAWebview = new e("WeAppLaunch", "InjectJSWAWebview", true, true, "注入WAWebview.js (View)", 1, 6, -2147483648);
    sStepNodes.add((d)stepInjectJSWAWebview);
    stepInjectJSPageScript = new e("WeAppLaunch", "InjectJSPageScript", true, false, "页面js注入 (View)", 1, 6, -2147483648);
    sStepNodes.add((d)stepInjectJSPageScript);
    stepGenerateFuncReadyRespond = new e("WeAppLaunch", "GenerateFuncReadyRespond", false, false, "webview发出的GenerateFuncReady被appservice响应 (View)", 1, 6, -2147483648);
    sStepNodes.add((d)stepGenerateFuncReadyRespond);
    stepVdSync = new e("WeAppLaunch", "VdSync", true, false, "第一次VdSync (View)", 1, 6, -2147483648);
    sStepNodes.add((d)stepVdSync);
    stepPageReady = new e("WeAppLaunch", "PageReady", true, false, "page ready (View)", 1, 6, -2147483648);
    sStepNodes.add((d)stepPageReady);
    stepColdLaunchFailed = new e("WeAppLaunch", "ColdLaunchFailed", true, true, "", 1, 1, -2147483648);
    sStepNodes.add((d)stepColdLaunchFailed);
    sStepNodes.add(new f("WeAppLaunch"));
    AppMethodBeat.o(194533);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.step.KSProcessWeAppLaunch
 * JD-Core Version:    0.7.0.1
 */